package com.wang.blog.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 20:03 2018/5/26
 * @ Description：
 * @ Modified By：
 */
@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /*栏目名称*/
    private String categoryName;

    /*栏目类型*/
    private Integer categoryType;
}
