package com.wang.blog.repository;

import com.wang.blog.domain.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:06 2018/7/7
 * @ Description：
 * @ Modified By：
 */
public interface AdminInfoRepository extends JpaRepository<AdminInfo,Integer> {
    AdminInfo findByAdminname(String adminname);
}
