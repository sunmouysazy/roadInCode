package sun.service.Exception;

/**
 * 用户名被占用异常
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class UsernameConfictException extends ServiceException{
    public UsernameConfictException() {
    }

    public UsernameConfictException(String message) {
        super(message);
    }

    public UsernameConfictException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameConfictException(Throwable cause) {
        super(cause);
    }

    public UsernameConfictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
