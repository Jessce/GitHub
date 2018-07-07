package com.wang.blog.handler;

import com.wang.blog.exception.AdminAuthorizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 22:46 2018/7/7
 * @ Description：
 * @ Modified By：
 */
@ControllerAdvice
public class AuthorizeExceptionHandler {
    @ExceptionHandler(AdminAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"+"/admin/index");
    }
}
