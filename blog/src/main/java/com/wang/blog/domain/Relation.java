package com.wang.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Relation {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer articleId;

    private Integer tagId;
}
