<html>
    <head>
        <meta charset="UTF-8">
        <title>管理端文章列表</title>
        <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>文章ID</th>
                        <th>文章标题</th>
                        <th>栏目编号</th>
                        <th>文章状态</th>
                        <th>创建时间</th>
                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list articlePage.content as article>
                    <tr>
                        <td>${article.articleId}</td>
                        <td>${article.articleTitle}</td>
                        <td>${article.categoryType}</td>
                        <td>${article.getArticleStatusEnum().getMessage()}</td>
                        <td>${article.createTime}</td>
                        <td>详情</td>
                        <td>取消</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </body>
</html>