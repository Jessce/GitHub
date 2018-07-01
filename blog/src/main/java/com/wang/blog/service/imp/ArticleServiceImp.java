package com.wang.blog.service.imp;

import com.wang.blog.domain.Article;
import com.wang.blog.enums.ArticleStatusEnum;
import com.wang.blog.repository.ArticleRepository;
import com.wang.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ArticleServiceImp implements ArticleService{
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article findById(Integer id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public List<Article> findUpAll() {
        return articleRepository.findByArticleStatus(ArticleStatusEnum.UP.getCode());
    }
}
