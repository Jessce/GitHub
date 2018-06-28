package com.wang.blog.controller;

import com.wang.blog.VO.ArticleVO;
import com.wang.blog.VO.CategoryVO;
import com.wang.blog.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:39 2018/6/26
 * @ Description：首页controller
 * @ Modified By：
 */
@RestController
@RequestMapping("/client/articles")
public class ClientArticlesController {

    @GetMapping("/list")
    public ResultVO findAllArticles(){
        ResultVO resultVO=new ResultVO();
        CategoryVO categoryVO=new CategoryVO();
        ArticleVO articleVO=new ArticleVO();
        categoryVO.setName("技术");
        categoryVO.setType(7);
        categoryVO.setArticles(Arrays.asList(articleVO));

        resultVO.setCode(0);
        resultVO.setMsg("msg");
        resultVO.setData(Arrays.asList(categoryVO));

        return resultVO;
    }

//    @GetMapping("/")


}
