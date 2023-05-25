package ru.kpfu.itis.java4.srvergasov.semesterwork.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.QuestionDto;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.QuestionEditForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.QuestionForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.exceptions.UserNotFoundException;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Answer;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Question;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.User;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.AnswerRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.CategoryRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local.QuestionRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local.UserRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.QuestionService;

import java.util.List;

import static ru.kpfu.itis.java4.srvergasov.semesterwork.dto.QuestionDto.from;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private AnswerRepository answerRepository;

    @Override
    public List<QuestionDto> getAllQuestions() {
        return from(questionRepository.findAll());
    }

    @Override
    public void addQuestion(QuestionForm questionForm, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        Question question = Question.builder()
                .title(questionForm.getTitle())
                .description(questionForm.getDescription())
                .user(user)
                .category(categoryRepository.getCategoriesByName(questionForm.getCategory()).orElse(categoryRepository.getById(1L)))
                .build();
        questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(long questionId) {
        Question question = questionRepository.getById(questionId);
        for (Answer answer : question.getAnswers()) {
            userRepository.updateRatingBeforeDeletingAnswer(answer.getId());
        }
        answerRepository.deleteByQuestionId(questionId);
        questionRepository.deleteById(questionId);
    }

    @Override
    public QuestionDto getQuestion(long questionId) {
        return from(questionRepository.getById(questionId));
    }

    @Override
    public void updateQuestion(QuestionEditForm questionForm) {
        Question question = questionRepository.getById(Long.parseLong(questionForm.getId()));
        question.setTitle(questionForm.getTitle());
        question.setDescription(questionForm.getDescription());
        questionRepository.save(question);
    }
}

