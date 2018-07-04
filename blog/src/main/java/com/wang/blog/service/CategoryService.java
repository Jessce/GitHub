package com.wang.blog.service;

import com.wang.blog.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 20:57 2018/6/25
 * @ Description：
 * @ Modified By：
 */
@Service
public interface CategoryService {
    List<Category> findAll();

    List<Category> findByTypeIn(List<Integer> categoryType);

    Category findByType(Integer categoryType);

    Category findOne(Integer categoryId);

    Category save(Category category);
}
