package com.wang.blog.utils;

import com.wang.blog.enums.CodeEnum;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 23:06 2018/7/1
 * @ Description：根据code值返回传入的枚举中对应的枚举
 * @ Modified By：
 */
public class EnumUtils {
    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
        for(T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
