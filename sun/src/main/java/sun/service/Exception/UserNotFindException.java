package sun.service.Exception;

/**
 * 用户查询不存在异常
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class UserNotFindException extends ServiceException{

    public UserNotFindException() {
    }


    public UserNotFindException(String message) {
        super(message);
    }


    public UserNotFindException(String message, Throwable cause) {
        super(message, cause);
    }


    public UserNotFindException(Throwable cause) {
        super(cause);
    }


    public UserNotFindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
