<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                管理端系统
            </a>
        </li>
        <#--<li>-->
            <#--<a href="/sell/seller/order/list"><i class="fa fa-fw fa-list-alt"></i> 订单</a>-->
        <#--</li>-->
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 文章 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="/blog/manage/articles/list">文章列表</a></li>
                <li><a href="/blog/manage/articles/index">新增文章</a></li>
            </ul>
        </li>
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 类目 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="/blog/manage/category/list">类目列表</a></li>
                <li><a href="/blog/manage/category/index">新增类目</a></li>
            </ul>
        </li>

        <li>
            <a href="/blog/admin/logout"><i class="fa fa-fw fa-list-alt"></i> 登出</a>
        </li>
    </ul>
</nav>