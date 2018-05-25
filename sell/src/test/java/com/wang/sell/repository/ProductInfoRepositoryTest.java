package com.wang.sell.repository;

import com.wang.sell.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static com.wang.sell.enums.ProductStatusEnum.Up;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 10:11 2018/5/24
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    ProductInfoRepository productInfoRepository;

    /*增改 单元测试*/
    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        /**
         * create by: 泽非
         * description:存在问题待解决2：数据库无法存储中文字符串，需要更改设置
         * create time: 11:11 2018/5/24
         */
        productInfo.setProductName("da ji tui");
        /*有疑问1*/
        productInfo.setProductPrice(new BigDecimal(10.00));
        productInfo.setProductStock(20);
        productInfo.setProductDescription("zhe da da ji tui");
        productInfo.setProductIcon("https://xxxxxx.jpg");
        productInfo.setCategoryType(2);
        /*使用枚举维护代表商品状态的数字*/
        productInfo.setProductStatus(Up.getCode());
        ProductInfo result=productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }

    /*查找测试*/
    @Test
    public void findTest(){
        Optional<ProductInfo> productInfo=productInfoRepository.findById("123456");
        Assert.assertEquals(new Integer(2),productInfo.get().getCategoryType());
    }

}