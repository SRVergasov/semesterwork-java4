package ru.kpfu.itis.java4.srvergasov.semesterwork.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ThrowsAspect implements ThrowsAdvice {

    @AfterThrowing(value = "execution(* ru.kpfu.itis.java4.srvergasov.semesterwork.controllers.QuestionController.*(..)) " +
            "|| execution(* ru.kpfu.itis.java4.srvergasov.semesterwork.controllers.SignUpController.*(..)) || " +
            "execution(* ru.kpfu.itis.java4.srvergasov.semesterwork.controllers.LoginController.*(..)) ||" +
            "execution(* ru.kpfu.itis.java4.srvergasov.semesterwork.controllers.SignUpController.*(..)) ||" +
            "execution(* ru.kpfu.itis.java4.srvergasov.semesterwork.controllers.ProfileController.*(..)) ||" +
            "execution(* ru.kpfu.itis.java4.srvergasov.semesterwork.controllers.LikesController.*(..)) ||" +
            "execution(* ru.kpfu.itis.java4.srvergasov.semesterwork.rest.controllers.QuestionsRestController.*(..)) ||" +
            "execution(* ru.kpfu.itis.java4.srvergasov.semesterwork.controllers.MainController.*(..))", throwing = "exception")
    public void afterThrowingQuestionController(JoinPoint joinPoint, Exception exception) throws Exception {
        System.out.println(new StringBuffer("Exception: ").append(exception).append(" message: ").append(exception.getMessage()));
    }

}
