package com.wang.blog.VO;

import lombok.Data;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 21:17 2018/6/25
 * @ Description：controller层返回http请求的最外层对象
 * @ Modified By：
 */
@Data
public class ResultVO<T> {
//    错误码
    private Integer code;

//    提示信息
    private String msg;

    private T data;

}
