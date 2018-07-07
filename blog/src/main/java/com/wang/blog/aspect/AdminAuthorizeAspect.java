package com.wang.blog.aspect;

import com.wang.blog.constant.CookieConstant;
import com.wang.blog.exception.AdminAuthorizeException;
import com.wang.blog.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 22:37 2018/7/7
 * @ Description：
 * @ Modified By：
 */
@Aspect
@Component
@Slf4j
public class AdminAuthorizeAspect {
    @Pointcut("execution(public * com.wang.blog.controller.Manage*.*(..))")
    public void verify(){}

    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie = CookieUtils.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw new AdminAuthorizeException();
        }
    }
}
