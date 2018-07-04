package com.wang.blog.service;

import com.wang.blog.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    Page<Article> findAll(Pageable pageable);

//    根据文章ID查询文章
    Article findById(Integer id);

//    查询所有发布的文章
    List<Article> findUpAll();

//    发布某篇文章
    Article onLine(Integer articleId);

//    下线一篇文章
    Article offLine(Integer articleId);

//    创建/更新一篇文章
    Article save(Article article);

}
