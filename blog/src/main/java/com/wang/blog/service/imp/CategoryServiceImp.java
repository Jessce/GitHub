package com.wang.blog.service.imp;

import com.wang.blog.domain.Category;
import com.wang.blog.repository.CategoryRepository;
import com.wang.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 20:58 2018/6/25
 * @ Description：
 * @ Modified By：
 */
@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findByTypeIn(List<Integer> categoryType) {
        return categoryRepository.findByCategoryTypeIn(categoryType);
    }

    @Override
    public Category findByType(Integer categoryType) {
        return categoryRepository.findByCategoryType(categoryType);
    }

//    新添方法，方法简单，未做单元测试
    @Override
    public Category findOne(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

//    新添方法，方法简单，未做单元测试
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
