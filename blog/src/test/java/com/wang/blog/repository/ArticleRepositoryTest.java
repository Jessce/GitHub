package com.wang.blog.repository;

import com.wang.blog.domain.Article;
import com.wang.blog.enums.ArticleStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 23:11 2018/5/26
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {
    @Autowired
    ArticleRepository articleRepository;

    @Test
    @Transactional
    public void saveTest(){
    Article article=new Article();
    article.setCategoryType(200);
    article.setArticleTitle("关于java框架springboot的学习");
    article.setArticleContent("通过慕课网自学获得了springboot的相关知识，尤其感谢廖师兄");
    article.setArticleStatus(ArticleStatusEnum.UP.getCode());
    article.setArticleIcon("https://xxxxxxx.jpg");
    article.setArticleDescription("有关于我springboot的学习经历、心得和笔记");
    Article result=articleRepository.save(article);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
    }

    @Test
    public void findByArticleTitle() throws Exception {
    }

}