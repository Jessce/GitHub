package com.wang.blog.VO;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 17:03 2018/6/26
 * @ Description：
 * @ Modified By：
 */
@Data
    public class CategoryVO {

        //    栏目名称
        private String name;

        //    栏目类型
        private Integer type;

        //    栏目下文章列表
        private List<ArticleListVO> articles;
}
