package sun.service.Exception;

/**
 * 删除管理员异常
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class DeleteManagerException extends ServiceException {
    public DeleteManagerException() {
    }

    public DeleteManagerException(String message) {
        super(message);
    }

    public DeleteManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteManagerException(Throwable cause) {
        super(cause);
    }

    public DeleteManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
