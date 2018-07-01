package com.wang.blog.VO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wang.blog.utils.serializer.DateConver;
import lombok.Data;

import java.util.Date;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 22:07 2018/6/30
 * @ Description：
 * @ Modified By：
 */
@Data
public class ArticleInfoVO {

    private Integer articleId;

    private String articleTitle;

    @JsonSerialize(using= DateConver.class)
    private Date createTime;

    private String articleContent;

}
