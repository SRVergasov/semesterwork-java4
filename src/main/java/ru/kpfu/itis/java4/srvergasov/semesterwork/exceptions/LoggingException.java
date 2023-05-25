package ru.kpfu.itis.java4.srvergasov.semesterwork.exceptions;

public class LoggingException extends RuntimeException {
    public LoggingException() {
        super();
    }

    public LoggingException(String message) {
        super(message);
    }

    public LoggingException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoggingException(Throwable cause) {
        super(cause);
    }
}
