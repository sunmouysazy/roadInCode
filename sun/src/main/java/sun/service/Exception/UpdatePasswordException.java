package sun.service.Exception;

/**
 * 更新密码错误异常
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class UpdatePasswordException extends ServiceException {
    public UpdatePasswordException() {
    }

    public UpdatePasswordException(String message) {
        super(message);
    }

    public UpdatePasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdatePasswordException(Throwable cause) {
        super(cause);
    }

    public UpdatePasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
