package com.wang.blog.repository;

import com.wang.blog.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 20:13 2018/5/26
 * @ Description：
 * @ Modified By：
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findByCategoryTypeIn(List<Integer> categoryTypeList);
    Category findByCategoryType(Integer categoryType);
}
