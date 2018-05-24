package com.wang.sell.service;

import com.wang.sell.domain.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    ProductCategory findOne(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
