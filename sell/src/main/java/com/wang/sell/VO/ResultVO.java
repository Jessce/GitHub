package com.wang.sell.VO;

import lombok.Data;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:58 2018/5/24
 * @ Description：返回给前端的最外层对象
 * @ Modified By：
 */
@Data
public class ResultVO<T> {
    /*错误码,0成功，1失败*/
    private Integer code;
    /*提示信息*/
    private String Message;

    private T Data;

}
