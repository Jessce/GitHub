<html>
    <#include "../common/header.ftl">
    <body>
    <div id="wrapper" class="toggled">
        <#--边栏sidebar-->
        <#include "../common/nav.ftl">

        <#--主要内容content-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>文章ID</th>
                                <th>文章标题</th>
                                <th>文章描述</th>
                                <th>类目编号</th>
                                <th>文章状态</th>
                                <th>创建时间</th>
                                <th>更新时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list articlePage.content as article>
                            <tr>
                                <td>${article.articleId}</td>
                                <td>${article.articleTitle}</td>
                                <td>${article.articleDescription}</td>
                                <td>${article.categoryType}</td>
                                <td>${article.getArticleStatusEnum().getMessage()}</td>
                                <td>${article.createTime}</td>
                                <td>${article.updateTime}</td>
                                <td><a href="/blog/manage/articles/index?articleId=${article.articleId}">修改</td>
                                <#if article.getArticleStatusEnum().getMessage()=="已发布">
                                    <td><a href="/blog/manage/articles/off_line?articleId=${article.articleId}">下线</td>
                                <#else >
                                    <td><a href="/blog/manage/articles/on_line?articleId=${article.articleId}">发布</td>
                                </#if>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled"> <a href="#">上一页</a></li>
                        <#else>
                            <li> <a href="/blog/manage/articles/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                        </#if>
                        <#list 1..articlePage.getTotalPages() as index>
                            <#if currentPage==index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/blog/manage/articles/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>
                        <#if currentPage gte articlePage.getTotalPages()>
                            <li class="disabled"> <a href="#">下一页</a></li>
                        <#else>
                            <li> <a href="/blog/manage/articles/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                        </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>