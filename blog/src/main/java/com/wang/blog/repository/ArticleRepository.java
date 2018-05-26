package com.wang.blog.repository;

import com.wang.blog.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 22:58 2018/5/26
 * @ Description：
 * @ Modified By：
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {
//    通过Category类型查询所有Article
    Page<Article> findByCategoryTypeIn(List<Integer> categoryTypeList, Pageable pageable);
//    通过文章标题/副标题查询Article
    Article findByArticleTitle(String ArticleTitle);

}
