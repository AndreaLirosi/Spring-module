package develhope.API.Interceptor.Middleware1.configuration;

import develhope.API.Interceptor.Middleware1.interceptor.APILoggingInterceptor;
import develhope.API.Interceptor.Middleware1.interceptor.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class SpringMVCConfiguration implements WebMvcConfigurer {

    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private LegacyInterceptor legacyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor).addPathPatterns("/time/now");
        registry.addInterceptor(legacyInterceptor).addPathPatterns("/legacy/get");
    }
}
