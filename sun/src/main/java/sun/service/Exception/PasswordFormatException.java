package sun.service.Exception;

/**
 *  密码格式异常
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class PasswordFormatException extends ServiceException {

    public PasswordFormatException() {
    }

    public PasswordFormatException(String message) {
        super(message);
    }

    public PasswordFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordFormatException(Throwable cause) {
        super(cause);
    }

    public PasswordFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
