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
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
