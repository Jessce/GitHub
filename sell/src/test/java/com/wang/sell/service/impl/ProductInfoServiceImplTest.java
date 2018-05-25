package com.wang.sell.service.impl;

import com.wang.sell.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static com.wang.sell.enums.ProductStatusEnum.Up;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 11:47 2018/5/24
 * @ Description：商品Service层实现单元测试
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Autowired
    ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo=productInfoService.findOne("123456");
        Assert.assertEquals(new Integer(2),productInfo.getCategoryType());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest=PageRequest.of(0,2);
        Page<ProductInfo> list=productInfoService.findAll(pageRequest);
        System.out.println(list.getTotalElements());

    }

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> list=productInfoService.findByProductStatus(Up.getCode());
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("da ji ji");
        productInfo.setProductPrice(new BigDecimal(15.00));
        productInfo.setProductStock(20);
        productInfo.setProductDescription("zhe da nv zhuang da lao");
        productInfo.setProductIcon("https://xxxxxx.jpg");
        productInfo.setCategoryType(2);
        /*使用枚举维护代表商品状态的数字*/
        productInfo.setProductStatus(Up.getCode());
        ProductInfo result=productInfoService.save(productInfo);
        Assert.assertNotNull(result);

    }

}