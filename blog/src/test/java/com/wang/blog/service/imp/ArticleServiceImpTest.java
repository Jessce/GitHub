package com.wang.blog.service.imp;

import com.wang.blog.domain.Article;
import com.wang.blog.enums.ArticleStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 20:48 2018/6/25
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImpTest {
    @Autowired
    ArticleServiceImp articleServiceImp;

//    @Test
//    public void findAll() throws Exception {
//        System.out.println(articleServiceImp.findAll());
//    }

    @Test
    public void findById() throws Exception {
        System.out.println(articleServiceImp.findById(1));
    }

    @Test
    public void onLineTest(){
        Article article =articleServiceImp.onLine(4);
        Assert.assertEquals(article.getArticleStatusEnum(), ArticleStatusEnum.UP);
    }

    @Test
    public void offLineTest(){
        Article article =articleServiceImp.offLine(4);
        Assert.assertEquals(article.getArticleStatusEnum(), ArticleStatusEnum.DOWN);
    }

}