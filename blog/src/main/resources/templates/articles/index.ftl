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
                    <form role="form" method="post" action="/blog/manage/articles/save">
                        <div class="form-group">
                            <label for="articleTitle">标题</label>
                            <input type="text" name="articleTitle" class="form-control"  value="${(article.articleTitle)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="articleDescription">描述</label>
                            <textarea rows="4" name="articleDescription" type="text" class="form-control" }">${(article.articleDescription)!''}</textarea>
                        </div>
                        <div class="form-group">
                            <label for="createTime">创建时间</label>
                            <input name="createTime" type="text" class="form-control" readonly value="${(article.createTime)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="updateTime">更新时间</label>
                            <input name="updateTime" type="text" class="form-control" readonly value="${(article.updateTime)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                            <#list categoryList as category>
                                <option value="${category.categoryType}"
                                    <#if (article.categoryType)?? && article.categoryType == category.categoryType>
                                        selected
                                    </#if>
                                >${category.categoryName}
                                </option>
                            </#list>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="articleContent">正文</label>
                            <textarea rows="20" name="articleContent" type="text" class="form-control"}">${(article.articleContent)!''}</textarea>
                        </div>
                        <input hidden type="text" name="articleId" value="${(article.articleId)!''}">
                        <#--<div class="form-group">-->
                            <#--<label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile" />-->
                        <#--</div>-->
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>