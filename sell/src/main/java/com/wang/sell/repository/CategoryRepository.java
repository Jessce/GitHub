package com.wang.sell.repository;

import com.wang.sell.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<ProductCategory, Integer> {
        List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
