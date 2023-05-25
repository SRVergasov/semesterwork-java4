package ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("select u from User u order by u.rating asc")
    List<User> findAllOrderByRating();

    @Modifying
    @Transactional
    @Query("update User user set user.rating = " +
            "(select user.rating - (ans.likedUsers.size * ans.question.category.level)" +
            " from Answer ans where ans.id = :ansId) " +
            "where user.id = (select ans.user.id from Answer ans where ans.id = :ansId)")
    void updateRatingBeforeDeletingAnswer(@Param("ansId") Long ansId);

    @Modifying
    @Transactional
    @Query("update User user set user.rating = " +
            "(select user.rating + (:ratingPlus * ans.question.category.level) " +
            "from Answer ans where ans.id = :ansId) " +
            "where user.id = (select ans.user.id from Answer ans where ans.id = :ansId)")
    void updateRatingAfterLike(@Param("ratingPlus") long ratingPlus, @Param("ansId") Long ansId);


}
