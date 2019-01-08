package sun.service.Exception;

/**
 * 无法访问异常（普通用户访问管理页面时引发）
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class NoAccessInfoException extends ServiceException {
    public NoAccessInfoException() {
    }

    public NoAccessInfoException(String message) {
        super(message);
    }

    public NoAccessInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAccessInfoException(Throwable cause) {
        super(cause);
    }

    public NoAccessInfoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
