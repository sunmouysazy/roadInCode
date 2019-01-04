package sun.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.entity.ResponseResult;
import sun.service.Exception.PasswordFormatException;
import sun.service.Exception.ServiceException;
import sun.service.Exception.UserNotFindException;
import sun.service.Exception.UsernameConfictException;
import sun.service.Exception.UsernameFormatException;

/**
 * 控制层的基类
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class BaseController {
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseResult handleException(Exception e){
        //判断异常类型 并处理
        if(e instanceof UserNotFindException){
            //201 - 用户不存在异常
            return new ResponseResult(201,e.getMessage());
        }else if (e instanceof UsernameFormatException) {
            // 301-用户名格式异常
            return new ResponseResult(301, e.getMessage());
        } else if (e instanceof PasswordFormatException) {
            // 302-密码格式异常
            return new ResponseResult(302, e.getMessage());
        } else if (e instanceof UsernameConfictException) {
            // 303-用户名占用异常
            return new ResponseResult(303, e.getMessage());
        }
        return null;
    }
}
