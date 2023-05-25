package ru.kpfu.itis.java4.srvergasov.semesterwork.exceptions;

public class AnswersNotFoundException extends RuntimeException {
    public AnswersNotFoundException() {
        super();
    }

    public AnswersNotFoundException(String message) {
        super(message);
    }

    public AnswersNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnswersNotFoundException(Throwable cause) {
        super(cause);
    }
}
