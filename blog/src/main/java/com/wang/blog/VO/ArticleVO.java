package com.wang.blog.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 22:43 2018/6/26
 * @ Description：
 * @ Modified By：
 */
@Data
public class ArticleVO {

//    文章ID
    private Integer id;

//    文章标题
    private String title;

//    文章摘要
    private String description;

//    文章小图
    private String icon;

}
