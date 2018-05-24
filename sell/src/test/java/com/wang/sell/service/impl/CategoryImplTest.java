package com.wang.sell.service.impl;

import com.wang.sell.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryImplTest {
    @Autowired
    private CategoryImpl categoryImpl;

    @Test
    public void findOne() throws Exception {
        ProductCategory result=categoryImpl.findOne(2);
        Assert.assertEquals("nanshengzuiai",result.getCategoryName());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList=categoryImpl.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList=categoryImpl.findByCategoryTypeIn(Arrays.asList(2,3,4));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory=new ProductCategory("chijizhunaxiang",7);
        ProductCategory result = categoryImpl.save(productCategory);
        Assert.assertNotNull(result);
    }

}