package com.wang.sell.repository;

import com.wang.sell.domain.OrderMaster;
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
 * @ Date       ：Created in 17:09 2018/5/25
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    private final static String OPENID="123321";
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void save(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("zefei");
        orderMaster.setBuyerPhone("178xxxx5633");
        orderMaster.setBuyerAddress("zijingang");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(10));

        OrderMaster result=repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findAllByBuyerOpenid() throws Exception {
        PageRequest pageRequest=PageRequest.of(0,1);
        Page<OrderMaster> list=repository.findAllByBuyerOpenid(OPENID,pageRequest);
        System.out.println(list.getTotalElements());

    }

}