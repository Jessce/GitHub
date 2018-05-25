package com.wang.sell.repository;

import com.wang.sell.domain.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @ Author     ：泽非
 * @ Date       ：Created in 23:31 2018/5/25
 * @ Description：
 * @ Modified By：
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
    Page<OrderDetail> findAllByOrderId(String orderId,Pageable pageable);
}
