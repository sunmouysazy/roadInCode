package sun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 拦截器
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("自定义拦截器。。。");
        // 从request中获取session
        HttpSession session = request.getSession();
        // 判断session中是否存在id
        if(session.getAttribute("id") != null){
            // 存在: 用户登录 则放行
            return true;
        }else {
            // 不存在：用户未登录，重定向，拦截
            response.sendRedirect("../static/login.html");
        }
        return true;
    }

}
