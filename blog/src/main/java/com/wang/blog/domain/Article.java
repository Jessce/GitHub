package com.wang.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String subtitle;

    private Date date;

    @Column(columnDefinition = "text")
    private String context;

    private Date createTime;

    private Date updateTime;

    private String visible;
}
