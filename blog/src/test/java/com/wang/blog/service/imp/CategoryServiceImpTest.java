package com.wang.blog.service.imp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 21:00 2018/6/25
 * @ Description：
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceImpTest {
    @Autowired
    CategoryServiceImp categoryServiceImp;

    @Test
    public void findAll() throws Exception {
        System.out.println(categoryServiceImp.findAll());
    }

}