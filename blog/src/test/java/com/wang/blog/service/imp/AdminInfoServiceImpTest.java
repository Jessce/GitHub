package com.wang.blog.service.imp;

import com.wang.blog.service.AdminInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:26 2018/7/7
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminInfoServiceImpTest {
    @Autowired
    AdminInfoService adminInfoService;

    @Test
    public void findByAdminname() throws Exception {
        Assert.assertNotNull(adminInfoService.findByAdminname("zefei"));
    }

}