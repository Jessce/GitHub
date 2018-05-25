package com.wang.sell.service;

import com.wang.sell.domain.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 11:16 2018/5/24
 * @ Description：商品Service层
 * @ Modified By：
 */
@Service
public interface ProductInfoService {
    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findByProductStatus(Integer productStatus);

    ProductInfo save(ProductInfo productInfo);

//    加库存

//    减库存
}
