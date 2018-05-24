package com.wang.sell.service.impl;

import com.wang.sell.domain.ProductCategory;
import com.wang.sell.repository.CategoryRepository;
import com.wang.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductCategory findOne(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }
}
