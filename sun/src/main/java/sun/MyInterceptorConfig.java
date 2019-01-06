package sun;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器配置信息
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/web/**").excludePathPatterns("/2/people/**");
        super.addInterceptors(registry);
    }
}
