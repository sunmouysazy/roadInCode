package sun.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
        System.out.println("在请求处理之前进行调用");
        // 从request中获取session
        HttpSession session = request.getSession();
        // 判断session中是否存在uid
        if (session.getAttribute("id") != null) {
            // 存在：用户已登录，则放行
            System.out.println("用户已登录,拦截器放行！");
            return true;
        }
        // 不存在：用户未登录，重定向，且拦截
        System.out.println("用户未登录，拦截器拦截！");
        response.sendRedirect("localhost:8080/web/login.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求处理之后进行调用，但是在视图被渲染之前");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("在整个请求结束之后被调用 渲染了对应的视图之后执行 ");
    }
}
