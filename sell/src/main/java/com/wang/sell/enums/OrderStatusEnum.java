package com.wang.sell.enums;

import lombok.Getter;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:35 2018/5/25
 * @ Description：订单状态，0已下单等待接单，1成功接单，2取消订单
 * 订单状态，0新订单，1完结订单，2取消订单
 * @ Modified By：
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1,"已完成订单"),
    CANCEL(2,"取消订单"),
    ;
    Integer code;
    String Mseeage;

    OrderStatusEnum(Integer code, String mseeage) {
        this.code = code;
        Mseeage = mseeage;
    }
}
