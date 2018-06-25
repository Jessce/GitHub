package com.wang.blog.service.imp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

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

    @Test
    public void findAll() throws Exception {
        System.out.println(articleServiceImp.findAll());
    }

    @Test
    public void findById() throws Exception {
        System.out.println(articleServiceImp.findById(1));
    }

}