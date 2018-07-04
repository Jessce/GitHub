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
                    <form role="form">
                        <div class="form-group">
                            <label for="articleTitle">标题</label>
                            <input type="text" class="form-control"  value="${(article.articleTitle)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="articleDescription">描述</label>
                            <textarea rows="4" type="text" class="form-control"  value="${(article.articleDescription)!''}">${(article.articleDescription)!''}</textarea>
                        </div>
                        <div class="form-group">
                            <label for="createTime">创建时间</label>
                            <input type="text" class="form-control"  value="${(article.createTime)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="updateTime">更新时间</label>
                            <input type="text" class="form-control"  value="${(article.updateTime)!''}"/>
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
                            <label for="articleContent">正文</label><textarea rows="20" type="text" class="form-control"  value="${(article.articleContent)!''}">${(article.articleContent)!''}</textarea>
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