package ru.kpfu.itis.java4.srvergasov.semesterwork.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AnswerDto;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.AnswerForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.exceptions.AnswersNotFoundException;
import ru.kpfu.itis.java4.srvergasov.semesterwork.exceptions.UserNotFoundException;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Answer;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Question;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.User;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.AnswerRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local.QuestionRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local.UserRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.AnswerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;
    private UserRepository userRepository;
    private QuestionRepository questionRepository;

    @Override
    public List<AnswerDto> getAllAnswersByQuestion(Long questionId) {
        return answerRepository.findAllByQuestionId(questionId).orElseThrow(AnswersNotFoundException::new).stream().map(AnswerDto::from).collect(Collectors.toList());
    }

    @Override
    public void addAnswer(AnswerForm answerForm, String username, Long questionId) {
        User user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        Question question = questionRepository.getById(questionId);
        answerRepository.save(Answer.builder()
                .user(user)
                .question(question)
                .text(answerForm.getText())
                .build());
    }

    @Override
    public Long deleteAnswer(Long answerId) {
        Answer answer = answerRepository.getById(answerId);
        Long questionId = answer.getQuestion().getId();
        userRepository.updateRatingBeforeDeletingAnswer(answerId);
        answerRepository.delete(answer);
        return questionId;
    }
}
