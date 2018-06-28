package com.wang.blog.controller;

import com.wang.blog.VO.ArticleVO;
import com.wang.blog.VO.CategoryVO;
import com.wang.blog.VO.ResultVO;
import com.wang.blog.domain.Article;
import com.wang.blog.domain.Category;
import com.wang.blog.service.imp.ArticleServiceImp;
import com.wang.blog.service.imp.CategoryServiceImp;
import com.wang.blog.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:39 2018/6/26
 * @ Description：首页controller
 * @ Modified By：
 */
@RestController
@RequestMapping("/client/articles")
public class ClientArticlesController {
    @Autowired
    ArticleServiceImp articleServiceImp;

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @GetMapping("/list")
    public ResultVO findAllArticles(){
//        1.查询所有发布的文章
        List<Article> articleList=articleServiceImp.findUpAll();

//        2.查询所有类目
        List<Integer> categoryTypeList=new ArrayList<>();
        for(Article article:articleList){
            categoryTypeList.add( article.getCategoryType());
        }
        List<Category> categoryList=categoryServiceImp.findByTypeIn(categoryTypeList);
//        3.数据拼装
        List<CategoryVO> categoryVOList=new ArrayList<>();
        for(Category category:categoryList){
            CategoryVO categoryVO=new CategoryVO();
            categoryVO.setName(category.getCategoryName());
            categoryVO.setType(category.getCategoryType());

            List<ArticleVO> articles=new ArrayList<>();
            for(Article article:articleList){
                if(article.getCategoryType().equals(category.getCategoryType())){
                    ArticleVO articleVO=new ArticleVO();
                    BeanUtils.copyProperties(article,articleVO);
                    articles.add(articleVO);
                }
            }
            categoryVO.setArticles(articles);
            categoryVOList.add(categoryVO);
        }

        return ResultVOUtils.success(categoryVOList);
    }

//    @GetMapping("/")


}
