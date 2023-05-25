package ru.kpfu.itis.java4.srvergasov.semesterwork.services.api;

import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.QuestionDto;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.QuestionEditForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.QuestionForm;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> getAllQuestions();

    void addQuestion(QuestionForm questionForm, String username);

    void deleteQuestion(long questionId);

    QuestionDto getQuestion(long questionId);

    void updateQuestion(QuestionEditForm questionForm);
}
