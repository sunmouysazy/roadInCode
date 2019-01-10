package sun.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 过滤器
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@WebFilter(urlPatterns = { "/web/*" }, filterName = "MyFilter")
public class MyFilter implements Filter {
    // 白名单(无需过滤的访问路径)
    private List<String> whiteList = new ArrayList<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我的过滤器！！！");
        // 添加白名单成员
        // 页面路径
        whiteList.add("register.html");
        whiteList.add("login.html");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 创建服务器请求对象
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        // 创建服务器响应对象
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        // 获取当前页面
        String uri = request.getRequestURI();
        int beginIndex = uri.lastIndexOf("/")+1;
        uri = uri.substring(beginIndex);
        System.out.println("当前请求页面为:"+uri);

        // 判断当前访问的页面是否需要过滤
        if(whiteList.contains(uri)){
            // 不需要过滤的页面
            System.out.println("无需过滤，放行："+uri);
            // 继续执行过滤器链
            filterChain.doFilter(request,response);
            return;
        }

        // 需要过滤的页面，需要进行session验证
        if(session.getAttribute("id")!= null){
            // 如果session中存在id，则证明用户已登录，放行
            System.out.println("已经登录，直接放行");
            // 继续执行过滤器链
            filterChain.doFilter(request,response);
            return;
        }

        // 执行到此处，则证明页面需要过滤，且未登录，拦截并重定向到登录页面
        System.out.println("拦截当前页面："+uri+"，重定向至登录页面！");
        // 重定向
        response.sendRedirect("login.html");
    }

    @Override
    public void destroy() {

    }
}
