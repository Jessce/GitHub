package com.wang.blog.service;

import com.wang.blog.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 20:36 2018/6/25
 * @ Description：
 * @ Modified By：
 */
@Service
public interface ArticleService {
//    查询全部文章列表
    public List<Article> findAll();
//    根据文章ID查询文章
    public Article findById(Integer id);

}
