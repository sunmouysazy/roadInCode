package sun.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置信息
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        //配置拦截路径
        registration.addPathPatterns("/user/**");
        //配置不拦截的路径
        registration.excludePathPatterns("/user/login","/user/add");
    }
}
