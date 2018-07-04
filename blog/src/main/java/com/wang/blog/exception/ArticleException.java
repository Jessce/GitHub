package com.wang.blog.exception;

import com.wang.blog.enums.ResultEnum;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 15:01 2018/7/3
 * @ Description：
 * @ Modified By：
 */
public class ArticleException extends RuntimeException {
    private Integer code;

    public ArticleException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public ArticleException(Integer code,String msg){
        super(msg);
        this.code=code;
    }

}
