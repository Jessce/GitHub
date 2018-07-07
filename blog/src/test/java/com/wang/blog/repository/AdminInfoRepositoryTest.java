package com.wang.blog.repository;

import com.wang.blog.domain.AdminInfo;
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
 * @ Date       ：Created in 16:08 2018/7/7
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminInfoRepositoryTest {
    @Autowired
    AdminInfoRepository adminInfoRepository;

    @Test
    @Transactional
    public void save(){
        AdminInfo adminInfo=new AdminInfo();
        adminInfo.setAdminname("RJH");
        adminInfo.setPassword("13777867005");
        AdminInfo admin=adminInfoRepository.save(adminInfo);
        Assert.assertNotNull(admin);
    }

    @Test
    public void findByAdminname() throws Exception {
        AdminInfo adminInfo=adminInfoRepository.findByAdminname("zefei");
        Assert.assertNotNull(adminInfo);
    }

}