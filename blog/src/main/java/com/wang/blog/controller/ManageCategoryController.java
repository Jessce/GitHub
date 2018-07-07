package com.wang.blog.controller;

import com.wang.blog.domain.Category;
import com.wang.blog.form.CategoryForm;
import com.wang.blog.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 22:23 2018/7/4
 * @ Description：管理端类目控制器（controller）
 * @ Modified By：
 */
@Controller
@RequestMapping("/manage/category")
public class ManageCategoryController {
    @Autowired
    CategoryService categoryService;
    
    /**
     * create by: 泽非
     * description:类目列表
     * create time: 22:31 2018/7/4
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<Category> categoryList=categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("category/list",map);
    }

    /**
     * create by: 泽非
     * description:展示类目修改和创建页面接口(Get方法)
     * create time: 22:45 2018/7/4
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String,Object> map){
        if(categoryId!=null){
            Category category=categoryService.findOne(categoryId);
            map.put("category",category);
        }
        return new ModelAndView("category/index",map);
    }

    /**
     * create by: 泽非
     * description:类目创建和修改接口
     * create time: 23:03 2018/7/4
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/blog/manage/category/index");
            return new ModelAndView("common/error",map);
        }
        Category category=new Category();
        try {
            if (form.getCategoryId() != null) {
                category = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, category);
            categoryService.save(category);
        }catch (Exception e){
            map.put("msg",e.getMessage());
            map.put("url","/blog/manage/category/index");
            return new ModelAndView("common/error",map);
        }
        map.put("category",category);
        map.put("url","/blog/manage/category/list");
        return new ModelAndView("common/success",map);
    }
}
