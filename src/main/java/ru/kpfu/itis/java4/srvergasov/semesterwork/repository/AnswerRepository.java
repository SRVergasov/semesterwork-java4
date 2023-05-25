package ru.kpfu.itis.java4.srvergasov.semesterwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query("select ans from Answer ans where ans.question.id = :id")
    Optional<List<Answer>> findAllByQuestionId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("delete from Answer a where a.question.id = :questionId")
    void deleteByQuestionId(@Param("questionId") Long questionId);

}
