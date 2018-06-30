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
    List<Article> findAll();

//    根据文章ID查询文章
    Article findById(Integer id);

//    查询所有发布的文章
    List<Article> findUpAll();

//    删除或者取消发布某篇文章

//    创建一篇文章


}
