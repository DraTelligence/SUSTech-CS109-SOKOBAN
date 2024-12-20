package exceptions;

public class AnswerNotFoundException extends Exception {
    // 默认构造函数
    public AnswerNotFoundException() {
        super("The given map has no corresponding answer...");
    }

    // 接受错误消息的构造函数
    public AnswerNotFoundException(String message) {
        super(message);
    }

    // 接受错误消息和原因的构造函数
    public AnswerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // 接受原因的构造函数
    public AnswerNotFoundException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
