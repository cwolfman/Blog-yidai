package com.yidai.config;

import com.yidai.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: 一呆
 * @date: 2021/8/31 23:08
 * @description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * @Param:
     * @return:
     * @date: 2021/8/31 23:08
     * @description: 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");
    }
}