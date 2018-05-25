package com.wang.sell.repository;

import com.wang.sell.domain.OrderDetail;
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

import static org.junit.Assert.*;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 23:35 2018/5/25
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("12345678");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("123458");
        orderDetail.setProductName("ji chi ");
        orderDetail.setProductIcon("http://xxxxx.gif");
        orderDetail.setProductPrice(new BigDecimal(8.23));
        orderDetail.setProductQuantity(5);
        OrderDetail result=repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findAllByOrderId() throws Exception {
        PageRequest pageRequest=PageRequest.of(0,2);
        Page<OrderDetail> list=repository.findAllByOrderId("123456",pageRequest);
//        System.out.println(list.getTotalElements());
        Assert.assertNotEquals(0,list.getTotalElements());
    }

}