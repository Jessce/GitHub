package com.wang.blog.service.imp;

import com.wang.blog.domain.Article;
import com.wang.blog.enums.ArticleStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void onLineTest(){
        Article article =articleServiceImp.onLine(4);
        Assert.assertEquals(article.getArticleStatusEnum(), ArticleStatusEnum.UP);
    }

    @Test
    @Transactional
    public void offLineTest(){
        Article article =articleServiceImp.offLine(4);
        Assert.assertEquals(article.getArticleStatusEnum(), ArticleStatusEnum.DOWN);
    }

    @Test
    @Transactional
    public void saveTest(){
        Article article=new Article();
        article.setArticleTitle("test2");
        article.setArticleStatus(0);
        article.setArticleDescription("test2");
        article.setCategoryType(7);
        article.setArticleContent("这是测试用文章对象2号，请叫我测试文章对象2号");
        Assert.assertNotNull(articleServiceImp.save(article));
    }

}