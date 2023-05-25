package ru.kpfu.itis.java4.srvergasov.semesterwork.services.api;

import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AnswerDto;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.AnswerForm;

import java.util.List;

public interface AnswerService {

    List<AnswerDto> getAllAnswersByQuestion(Long questionId);

    void addAnswer(AnswerForm answerForm, String username, Long questionId);

    Long deleteAnswer(Long answerId);

}
