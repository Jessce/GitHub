package com.wang.blog.form;

import lombok.Data;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 11:49 2018/7/4
 * @ Description：文章表单
 * @ Modified By：
 */
@Data
public class ArticleForm {

    private Integer articleId;

    /*文章类型*/
    private Integer categoryType;

    /*标题*/
    private String articleTitle;

    /*正文*/
    private String articleContent;

    /*文章描述*/
    private String articleDescription;

}
