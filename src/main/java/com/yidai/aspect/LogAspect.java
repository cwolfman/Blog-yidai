package com.yidai.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yidai
 * @date: 2021/8/31 23:09
 * @description: 定义切面
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @Param:
     * @return:
     * @date: 2021/8/31 23:09
     * @description: 定义切入点表达式
     */
    @Pointcut("execution(* com.yidai.controller.*.*(..))")
    public void log() {
    }

    /**
     * @Param:
     * @return:
     * @date: 2021/8/31 23:09
     * @description: 引用切入点
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        //获得类名.方法名
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        //获得方法参数
        Object[] args = joinPoint.getArgs();

        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        //打印请求信息
        logger.info("Request: {}", requestLog);
    }

    @After("log()")
    public void doAfter() {
        logger.info("------------doAfter------------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result) {

        //打印返回值
        logger.info("Result: {}", result);
    }

    /**
     * @author: yidai
     * @date: 2021/8/31 23:09
     * @description: 用于封装请求信息
     */
    @Data
    @AllArgsConstructor
    public static class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }
}
