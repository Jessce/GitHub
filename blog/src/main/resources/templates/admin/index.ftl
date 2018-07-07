<html>
  <head>
      <meta charset="UTF-8">
      <title>后端管理系统</title>
      <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="form-horizontal" role="form"  method="post" action="/blog/admin/login">
                <div class="form-group">
                    <label for="adminname" class="col-sm-2 control-label">Name:</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="adminname" id="adminname" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password:</label>
                    <div class="col-sm-2">
                        <input type="password" class="form-control" name="password" id="password" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label><input type="checkbox" />Remember me</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>