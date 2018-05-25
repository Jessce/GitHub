package com.wang.sell.repository;

import com.wang.sell.domain.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @ Author     ：泽非
 * @ Date       ：Created in 17:03 2018/5/25
 * @ Description：
 * @ Modified By：
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findAllByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
