package com.wang.blog.controller;

import com.wang.blog.domain.Article;
import com.wang.blog.domain.Category;
import com.wang.blog.exception.ArticleException;
import com.wang.blog.form.ArticleForm;
import com.wang.blog.service.ArticleService;
import com.wang.blog.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
 * @ Date       ：Created in 0:50 2018/7/1
 * @ Description：后台管理端controller
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
     * description:发布文章接口，实现功能的同时，根据结果跳转到一个成功/错误的公用界面
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
     * description:取消文章发布接口
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

    /**
     * create by: 泽非
     * description:文章表单展示界面
     * create time: 10:20 2018/7/5
     */
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

    /**
     * create by: 泽非
     * description:创建/修改文章
     * create time: 11:52 2018/7/4
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ArticleForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){

        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/blog/manage/articles/index");
            return new ModelAndView("common/error",map);
        }
        Article article=new Article();
        try {
        /*id为空说明是新增*/
            if (!(form.getArticleId() == null)) {
                article = articleService.findById(form.getArticleId());
            }
            BeanUtils.copyProperties(form, article);
            articleService.save(article);
        }catch (Exception e){
            map.put("msg",e.getMessage());
            map.put("url","/blog/manage/articles/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/blog/manage/articles/list");
        return new ModelAndView("common/success",map);
    }
}