package com.wang.blog.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:04 2018/7/7
 * @ Description：
 * @ Modified By：
 */
@Entity
@Data
public class AdminInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    private String adminname;

    private String password;
}
