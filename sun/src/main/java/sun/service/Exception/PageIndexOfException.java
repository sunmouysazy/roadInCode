package sun.service.Exception;

/**
 * 页面超出界限异常
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class PageIndexOfException extends ServiceException {
    public PageIndexOfException() {
    }

    public PageIndexOfException(String message) {
        super(message);
    }

    public PageIndexOfException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageIndexOfException(Throwable cause) {
        super(cause);
    }

    public PageIndexOfException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
