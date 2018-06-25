package com.wang.blog.service.imp;

import com.wang.blog.domain.Article;
import com.wang.blog.repository.ArticleRepository;
import com.wang.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 20:36 2018/6/25
 * @ Description：
 * @ Modified By：
 */
@Service
public class ArticleServiceImp implements ArticleService{
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(Integer id) {
        return articleRepository.findById(id).get();
    }
}
