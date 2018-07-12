package com.wang.blog.controller;

import com.wang.blog.VO.ArticleListVO;
import com.wang.blog.VO.ArticleInfoVO;
import com.wang.blog.VO.CategoryVO;
import com.wang.blog.VO.ResultVO;
import com.wang.blog.domain.Article;
import com.wang.blog.domain.Category;
import com.wang.blog.service.ArticleService;
import com.wang.blog.service.imp.CategoryServiceImp;
import com.wang.blog.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:39 2018/6/26
 * @ Description：首页controller
 * @ Modified By：
 */
@RestController
@RequestMapping("/client/articles")
@Slf4j
public class ClientArticlesController {
    @Autowired
    ArticleService articleServiceImp;

    @Autowired
    CategoryServiceImp categoryServiceImp;

    /**
     * create by: 泽非
     * description:所有发布文章展示列表
     * create time: 10:22 2018/7/5
     */
    @CrossOrigin
    @GetMapping("/list")
    public ResultVO findUpAllArticles(){
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

            List<ArticleListVO> articles=new ArrayList<>();
            for(Article article:articleList){
                if(article.getCategoryType().equals(category.getCategoryType())){
                    ArticleListVO articleListVO =new ArticleListVO();
                    BeanUtils.copyProperties(article, articleListVO);
                    articles.add(articleListVO);
                }
            }
            categoryVO.setArticles(articles);
            categoryVOList.add(categoryVO);
        }

        return ResultVOUtils.success(categoryVOList);
    }

    /**
     * create by: 泽非
     * description:查看某篇文章内容详情
     * create time: 10:23 2018/7/5
     */
    @CrossOrigin
    @GetMapping("/article")
    public ResultVO findOneArticle(@RequestParam(value = "ArticleId",defaultValue = "1") Integer articleId){
//        查询id对应的文章
        Article article=new Article();
        try {
           article = articleServiceImp.findById(articleId);
       }catch (NoSuchElementException e){
            log.error("【查询文章】文章不存在,Article={}",article);
            return ResultVOUtils.success();
       }

//        复制数据并返回
        ArticleInfoVO articleInfoVO =new ArticleInfoVO();
        BeanUtils.copyProperties(article, articleInfoVO);

        return ResultVOUtils.success(articleInfoVO);
    }
}
