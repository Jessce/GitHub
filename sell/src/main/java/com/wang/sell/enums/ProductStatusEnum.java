package com.wang.sell.enums;


import lombok.Getter;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 10:27 2018/5/24
 * @ Description：枚举维护代表商品状态的数字；0代表上架，1代表下架；
 * 枚举类型的用法：, , ;
 * @ Modified By：
 */
@Getter
public enum ProductStatusEnum {
    Up(0,"已上架"),
    Down(1,"已下架"),
    ;

    Integer code;
    String Mseeage;

    ProductStatusEnum(Integer code, String mseeage) {
        this.code = code;
        Mseeage = mseeage;
    }
}
