package com.wang.sell.repository;

import com.wang.sell.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByIdTest(){
        Optional<ProductCategory> productCategory=categoryRepository.findById(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void findAllTest(){
        List<ProductCategory> list=categoryRepository.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void updateTest(){
        Optional<ProductCategory> productCategory=categoryRepository.findById(2);
        productCategory.get().setCategoryName("nanshengzuiai");
        productCategory.get().setCategoryType(9);
        categoryRepository.save(productCategory.get());
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory("4399",6);
        ProductCategory result=categoryRepository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list= Arrays.asList(2,3,4);
        List<ProductCategory> result=categoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}