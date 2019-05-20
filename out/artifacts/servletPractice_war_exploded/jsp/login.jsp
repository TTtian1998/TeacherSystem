<%--
  Created by IntelliJ IDEA.
  User: tzx
  Date: 2019/5/9
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>教师管理系统登录界面</title>
    <meta charset="UTF-8">
    <%--<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">--%>
    <%--<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>--%>
    <%--<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
    <%--<link rel="stylesheet" type="text/css" href="../css/login.css" >--%>
    <%--<script src="../js/login.js"></script>--%>
      <script src="../js/jquery/jquery-3.3.1.min.js"></script>
      <link rel="stylesheet" type="text/css" href="../css/login.css" >
      <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
      <script src="../js/jquery/bootstrap.min.js"></script>
      <script type="text/javascript" src="../js/login.js"></script>
  </head>
  <body>
  <%--登录框--%>
  <div class="container" >
    <div class="row justify-content-center align-items-center" style="height: 100vh">
      <div class="col-4">
        <div class="card">
          <div class="card-body">
            <form>
              <div class="card-title">
                <h2 class="loginTitle">教师管理系统</h2>
              </div>
              <div class="form-group">
                <p>账号：</p>
                <input type="text" class="form-control" name="username" id="username">
              </div>
              <div class="form-group">
                <p>密码：</p>
                <input type="password" class="form-control" name="password" id="password">
              </div>
              <div class="form-group">
                 <button type="button" id="loginBtn" class="button btnLog">登录</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
