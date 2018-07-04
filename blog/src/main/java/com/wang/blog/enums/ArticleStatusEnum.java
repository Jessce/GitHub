package com.wang.blog.enums;

import lombok.Getter;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 20:07 2018/5/26
 * @ Description：文章状态枚举
 * @ Modified By：
 */
@Getter
public enum ArticleStatusEnum implements CodeEnum{
    DOWN(0,"未发布"),
    UP(1,"已发布"),
    ;

    private Integer code;
    private String message;

    ArticleStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
