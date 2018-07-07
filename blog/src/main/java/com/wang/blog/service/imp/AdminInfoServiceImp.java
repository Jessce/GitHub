package com.wang.blog.service.imp;

import com.wang.blog.domain.AdminInfo;
import com.wang.blog.repository.AdminInfoRepository;
import com.wang.blog.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:25 2018/7/7
 * @ Description：
 * @ Modified By：
 */
@Service
public class AdminInfoServiceImp implements AdminInfoService {
    @Autowired
    AdminInfoRepository adminInfoRepository;

    @Override
    public AdminInfo findByAdminname(String adminname) {
        return adminInfoRepository.findByAdminname(adminname);
    }
}
