package ru.kpfu.itis.java4.srvergasov.semesterwork.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AnswerDto;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.LikeForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.exceptions.UserNotFoundException;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Answer;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.User;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.AnswerRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local.UserRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.LikeService;

import java.util.List;

import static ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AnswerDto.from;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private AnswerRepository answerRepository;
    private UserRepository userRepository;

    @Override
    public AnswerDto like(LikeForm likeForm) {
        Answer answer = answerRepository.getById(likeForm.getAnswerId());
        User user = userRepository.findByUsername(likeForm.getUsername()).orElseThrow(UserNotFoundException::new);
        List<User> likedUsers = answer.getLikedUsers();
        long ratingPlus;
        if (likedUsers.contains(user)) {
            likedUsers.remove(user);
            ratingPlus = -1;
        } else {
            likedUsers.add(user);
            ratingPlus = 1;
        }
        answer.setLikedUsers(likedUsers);
        userRepository.updateRatingAfterLike(ratingPlus, likeForm.getAnswerId());
        return from(answerRepository.save(answerRepository.getById(likeForm.getAnswerId())));
    }
}
