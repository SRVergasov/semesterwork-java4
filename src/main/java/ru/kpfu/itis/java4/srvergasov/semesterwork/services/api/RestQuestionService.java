package ru.kpfu.itis.java4.srvergasov.semesterwork.services.api;

import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Question;
import ru.kpfu.itis.java4.srvergasov.semesterwork.rest.entity.RestQuestion;

import java.util.List;

public interface RestQuestionService {

    List<RestQuestion> getAllQuestions();

    RestQuestion getQuestion(Long id);

    RestQuestion addQuestion(RestQuestion restQuestion);

    void deleteQuestion(Long id);

    RestQuestion updateQuestion(RestQuestion restQuestion);
}
