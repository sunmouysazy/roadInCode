package sun.service.Exception;

/**
 * 密码错误异常
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class PasswordWoringException extends ServiceException {


    public PasswordWoringException() {
    }

    public PasswordWoringException(String message) {
        super(message);
    }

    public PasswordWoringException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordWoringException(Throwable cause) {
        super(cause);
    }

    public PasswordWoringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
