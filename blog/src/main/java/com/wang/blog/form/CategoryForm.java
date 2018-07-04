package com.wang.blog.form;

import lombok.Data;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 23:01 2018/7/4
 * @ Description：
 * @ Modified By：
 */
@Data
public class CategoryForm {
    private Integer categoryId;

    /*栏目名称*/
    private String categoryName;

    /*栏目类型*/
    private Integer categoryType;
}
