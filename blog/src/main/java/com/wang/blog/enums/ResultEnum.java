package com.wang.blog.enums;

import lombok.Getter;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 15:02 2018/7/3
 * @ Description：
 * @ Modified By：
 */
@Getter
public enum ResultEnum {
    ARTICLE_NOT_EXIST(10,"文章不存在"),
    ARTICLE_STATUS_ERROR(11,"文章状态错误"),
    LOGIN_ERROR(12,"登陆失败，登陆信息不正确"),
    LOGIN_NOT_EXIST(13,"登陆失败，用户不存在"),
    LOGOUT_SUCCESS(14,"登出成功"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
