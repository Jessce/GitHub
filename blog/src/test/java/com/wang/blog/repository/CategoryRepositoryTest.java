package com.wang.blog.repository;

import com.wang.blog.domain.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


/**
 * @ Author     ：泽非
 * @ Date       ：Created in 20:16 2018/5/26
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @Transactional
    public void saveTest(){
        Category category=new Category();
        category.setCategoryName("动漫");
        category.setCategoryType(100);
        Category result=categoryRepository.save(category);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> categoryTypeList= Arrays.asList(1,2,3,4,5,6,7);
        List<Category> list=categoryRepository.findByCategoryTypeIn(categoryTypeList);
        Assert.assertNotEquals(0,list.size());
    }

}