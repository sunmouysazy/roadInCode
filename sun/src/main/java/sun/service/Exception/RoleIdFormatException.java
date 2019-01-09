package sun.service.Exception;

/**
 * 角色id定义错误异常
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class RoleIdFormatException extends ServiceException {
    public RoleIdFormatException() {
    }

    public RoleIdFormatException(String message) {
        super(message);
    }

    public RoleIdFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleIdFormatException(Throwable cause) {
        super(cause);
    }

    public RoleIdFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
