package sun.service.Exception;

/**
 * 修改用户数据未上传id异常
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class NullOfIdForParamException extends ServiceException {
    public NullOfIdForParamException() {
    }

    public NullOfIdForParamException(String message) {
        super(message);
    }

    public NullOfIdForParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullOfIdForParamException(Throwable cause) {
        super(cause);
    }

    public NullOfIdForParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
