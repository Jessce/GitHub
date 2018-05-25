package com.wang.sell.enums;

import lombok.Getter;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:52 2018/5/25
 * @ Description：0未支付，1支付成功
 * @ Modified By：
 */
@Getter
public enum PayStatusEnum {
    WAITING(0,"未支付"),
    SUCCESS(1,"支付成功"),
            ;
    Integer code;
    String Mseeage;

    PayStatusEnum(Integer code, String mseeage) {
        this.code = code;
        Mseeage = mseeage;
    }
}
