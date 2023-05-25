package ru.kpfu.itis.java4.srvergasov.semesterwork.services.api;

import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AnswerDto;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.LikeForm;

public interface LikeService {

    AnswerDto like(LikeForm likeForm);
}
