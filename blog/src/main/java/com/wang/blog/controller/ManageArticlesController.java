package com.wang.blog.controller;

import com.wang.blog.domain.Article;
import com.wang.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

//    查询全部文章
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10")Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest=PageRequest.of(page-1,size);
        Page<Article> articlePage=articleService.findAll(pageRequest);
        map.put("articlePage",articlePage);
        return  new ModelAndView("articles/list",map);
    }

//    创建文章

//    取消发布&删除文章


//    更新文章
}
