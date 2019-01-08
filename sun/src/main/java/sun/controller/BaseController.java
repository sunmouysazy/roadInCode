package sun.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.entity.ResponseResult;
import sun.service.Exception.DeleteManagerException;
import sun.service.Exception.NoAccessInfoException;
import sun.service.Exception.PageIndexOfException;
import sun.service.Exception.PasswordFormatException;
import sun.service.Exception.PasswordWoringException;
import sun.service.Exception.ServiceException;
import sun.service.Exception.UpdatePasswordException;
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
    public ResponseResult handleException(Exception e) {
        // 判断异常类型 并处理
        if (e instanceof UserNotFindException) {
            // 201 - 用户不存在异常
            return new ResponseResult(201, e.getMessage());
        } else if (e instanceof UsernameFormatException) {
            // 301-用户名格式异常
            return new ResponseResult(301, e.getMessage());
        } else if (e instanceof PasswordFormatException) {
            // 302-密码格式异常
            return new ResponseResult(302, e.getMessage());
        } else if (e instanceof UsernameConfictException) {
            // 303-用户名占用异常
            return new ResponseResult(303, e.getMessage());
        } else if (e instanceof PasswordWoringException) {
            // 304-密码输入错误异常
            return new ResponseResult(304, e.getMessage());
        }else if (e instanceof UpdatePasswordException) {
            // 305-更新密码未知异常
            return new ResponseResult(305, e.getMessage());
        }else if (e instanceof NoAccessInfoException) {
            // 306-用户访问管理页面异常
            return new ResponseResult(306, e.getMessage());
        }else if (e instanceof DeleteManagerException) {
            // 307-删除管理异常
            return new ResponseResult(307, e.getMessage());
        }else if (e instanceof PageIndexOfException) {
            // 308-页面超限异常
            return new ResponseResult(308, e.getMessage());
        }
        return null;
    }

    // session验证 获取当前登录用户的id
    protected Integer getIdfromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }
}
