package com.wang.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wang.blog.enums.ArticleStatusEnum;
import com.wang.blog.utils.EnumUtils;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 19:53 2018/5/26
 * @ Description：
 * @ Modified By：
 */
@Entity
@Data
@DynamicUpdate
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;

    /*文章类型*/
    private Integer categoryType;

    /*标题*/
    private String articleTitle;

    /*副标题*/
    private String articleSubtitle;

    /*正文*/
    private String articleContent;

    /*文章状态*/
    private Integer articleStatus=ArticleStatusEnum.DOWN.getCode();

    /*文章小图*/
    private String articleIcon;

    /*文章描述*/
    private String articleDescription;

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;

    @JsonIgnore
    public ArticleStatusEnum getArticleStatusEnum(){
        return EnumUtils.getByCode(articleStatus,ArticleStatusEnum.class);
    }
}