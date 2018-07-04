package com.wang.blog.controller;

import com.wang.blog.domain.Article;
import com.wang.blog.domain.Category;
import com.wang.blog.exception.ArticleException;
import com.wang.blog.service.ArticleService;
import com.wang.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 0:50 2018/7/1
 * @ Description：
 * @ Modified By：
 */
@Controller
@RequestMapping("/manage/articles")
public class ManageArticlesController {
    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

//    查询全部文章
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10")Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest=PageRequest.of(page-1,size);
        Page<Article> articlePage=articleService.findAll(pageRequest);
        map.put("articlePage",articlePage);
        map.put("currentPage",page);
        map.put("size",size);
        return  new ModelAndView("articles/list",map);
    }

    /**
     * create by: 泽非
     * description:文章发布
     * create time: 15:57 2018/7/3
     */
    @GetMapping("/on_line")
    public ModelAndView onLine(@RequestParam("articleId") Integer articleId,
                               Map<String,Object> map){
        try {
            articleService.onLine(articleId);
        }catch (ArticleException e){
            map.put("msg",e.getMessage());
            map.put("url","/blog/manage/articles/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/blog/manage/articles/list");
        return new ModelAndView("common/success",map);
    }

    /**
     * create by: 泽非
     * description:取消文章发布
     * create time: 15:57 2018/7/3
     */
    @GetMapping("/off_line")
    public ModelAndView offLine(@RequestParam("articleId") Integer articleId,
                               Map<String,Object> map){
        try {
            articleService.offLine(articleId);
        }catch (ArticleException e){
            map.put("msg",e.getMessage());
            map.put("url","/blog/manage/articles/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/blog/manage/articles/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "articleId",required = false) Integer articleId,
                              Map<String,Object> map){
        if(!(articleId==null)){
            Article article=articleService.findById(articleId);
            map.put("article",article);
        }
//        查询所有类目
        List<Category> categoryList=categoryService.findAll();
        map.put("categoryList",categoryList);

        return new ModelAndView("articles/index",map);
    }


}
