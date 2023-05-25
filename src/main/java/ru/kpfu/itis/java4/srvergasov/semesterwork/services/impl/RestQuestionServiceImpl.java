package ru.kpfu.itis.java4.srvergasov.semesterwork.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.java4.srvergasov.semesterwork.exceptions.UserNotFoundException;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Category;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Question;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.User;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.CategoryRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local.QuestionRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local.UserRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.rest.entity.RestQuestion;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.RestQuestionService;

import java.util.List;

import static ru.kpfu.itis.java4.srvergasov.semesterwork.rest.entity.RestQuestion.from;
import static ru.kpfu.itis.java4.srvergasov.semesterwork.rest.entity.RestQuestion.fromWithoutAnswers;

@Service
@AllArgsConstructor
public class RestQuestionServiceImpl implements RestQuestionService {

    private QuestionRepository questionRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    @Override
    public List<RestQuestion> getAllQuestions() {
        return from(questionRepository.findAll());
    }

    @Override
    public RestQuestion getQuestion(Long id) {
        return from(questionRepository.getById(id));
    }

    @Override
    public RestQuestion addQuestion(RestQuestion restQuestion) {
        User user = userRepository.findByUsername(restQuestion.getAuthorName()).orElseThrow(UserNotFoundException::new);
        Category category = categoryRepository.getCategoriesByName(restQuestion.getCategory()).orElse(categoryRepository.getById(1L));
        Question question = Question.builder()
                .title(restQuestion.getTitle())
                .description(restQuestion.getDescription())
                .user(user)
                .category(category)
                .build();
        return fromWithoutAnswers(questionRepository.save(question));
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public RestQuestion updateQuestion(RestQuestion restQuestion) {
        Question question = questionRepository.getById(restQuestion.getId());
        if (restQuestion.getTitle() != null) {
            question.setTitle(restQuestion.getTitle());
        }
        if (restQuestion.getDescription() != null) {
            question.setDescription(restQuestion.getDescription());
        }
        if (restQuestion.getAuthorName() != null) {
            question.setUser(userRepository.findByUsername(restQuestion.getAuthorName()).orElseThrow(UserNotFoundException::new));
        }
        if (restQuestion.getCategory() != null) {
            question.setCategory(categoryRepository.getCategoriesByName(restQuestion.getCategory()).orElse(categoryRepository.getById(1L)));
        }
        return from(questionRepository.save(question));
    }
}
