package com.wang.sell.repository;

import com.wang.sell.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 9:55 2018/5/24
 * @ Description：
 * @ Modified By：
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    /**
     * create by: 泽非
     * description:通过商品的状态：上架或者已下架，来查看所有上架的或者所有已经下架的商品
     * create time: 10:12 2018/5/24
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
