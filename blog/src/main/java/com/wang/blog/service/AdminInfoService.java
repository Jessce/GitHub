package com.wang.blog.service;

import com.wang.blog.domain.AdminInfo;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:23 2018/7/7
 * @ Description：
 * @ Modified By：
 */
@Service
public interface AdminInfoService {
    AdminInfo findByAdminname(String adminname);
}
