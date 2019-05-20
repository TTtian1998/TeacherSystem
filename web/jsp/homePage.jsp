<%--
  Created by IntelliJ IDEA.
  User: tzx
  Date: 2019/5/12
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../js/jquery/bootstrap-table.js"></script>
    <script src="../js/jquery/bootstrap-table-zh-CN.js"></script>
    <link href="../css/bootstrap/bootstrap-table.css" rel="stylesheet">
    <link href="../css/bootstrap/bootstrap-theme.css">
    <script src="../js/homePage.js"></script>
    <link href="../css/homePage.css" rel="stylesheet">
</head>
<body>

<%--标题、表格--%>
<div class="html container">
    <div class="header page-header">
        <h2 class="pageTitle">教师信息管理</h2>
    </div>

    <div class="BtnGroup">
        <button class="btn btn-success" data-toggle="modal" data-target="#addModal">新增</button>
        <button class="btn btn-danger" data-toggle="modal" onclick="deleteInfo()">删除</button>
        <button class="btn btn-primary" data-toggle="modal" onclick="">按id排序</button>
        <button class="btn btn-warning" data-toggle="modal" onclick="">按年龄排序</button>
    </div>
    <div class="data">
        <table id="table" class="table table-bordered"></table>
    </div>

</div>
<%--新增弹框--%>
<div id="addModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">新增教师信息</h4>
            </div>
            <div class="modal-body">
                <div class="row">

                    <div class="col-xs-12 col-md-12">
                        <h4>姓名：</h4>
                        <input type="text" id="teacherName" name="name" autofocus="autofocus"
                               class="form-control" placeholder="例如：小明" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>学校：</h4>
                        <input type="text" id="teacherSchool" name="school"
                               class="form-control" placeholder="例如：重庆理工大学" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>专业：</h4>
                        <input type="text" id="teacherMajor" name="major"
                               class="form-control" placeholder="例如：软件工程" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>生日：</h4>
                        <input type="text" id="teacherBtd" name="date"
                               class="form-control" placeholder="例如：2001-6-6" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>薪水：</h4>
                        <input type="text" id="teacherSalary" name="salary"
                               class="form-control" placeholder="例如：8888" aria-describedby="basic-addon1"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="add()">提交</button>
                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="clear()">取消</button>
            </div>
        </div>
    </div>
</div>
<%--删除弹框--%>

<%--查看弹框--%>
<div id="ViewModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document" style="background-color: #e7f3ff;">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <h4 class="modal-title">查看教师信息</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <h4>id：</h4>
                    <input type="text" id="viewId" name="id" autofocus="autofocus" readonly ="readonly"
                           class="form-control"  aria-describedby="basic-addon1"/>
                </div>
                <div class="col-xs-12 col-md-12">
                    <h4>姓名：</h4>
                    <input type="text" id="viewName" name="name" autofocus="autofocus" readonly ="readonly"
                           class="form-control"  aria-describedby="basic-addon1"/>
                </div>
                <div class="col-xs-12 col-md-12">
                    <h4>学校：</h4>
                    <input type="text" id="viewSchool" name="school"
                           class="form-control" readonly ="readonly" aria-describedby="basic-addon1"/>
                </div>
                <div class="col-xs-12 col-md-12">
                    <h4>专业：</h4>
                    <input type="text" id="viewMajor" name="major"
                           class="form-control" readonly ="readonly" aria-describedby="basic-addon1"/>
                </div>
                <div class="col-xs-12 col-md-12">
                    <h4>生日：</h4>
                    <input type="text" id="viewBtd" name="date"
                           class="form-control" readonly ="readonly" aria-describedby="basic-addon1"/>
                </div>
                <div class="col-xs-12 col-md-12">
                    <h4>薪水：</h4>
                    <input type="text" id="viewSalary" name="salary"
                           class="form-control" readonly ="readonly" aria-describedby="basic-addon1"/>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="clear()">取消</button>
        </div>
    </div>
</div>
<%--修改弹框--%>
<div id="ModifyModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">修改教师信息</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12 col-md-12">
                        <h4>id：</h4>
                        <input type="text" id="modifyId" name="id" autofocus="autofocus" readonly ="readonly"
                               class="form-control" placeholder="id不可以修改" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>姓名：</h4>
                        <input type="text" id="modifyName" name="name" autofocus="autofocus"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>学校：</h4>
                        <input type="text" id="modifySchool" name="school"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>专业：</h4>
                        <input type="text" id="modifyMajor" name="major"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>生日：</h4>
                        <input type="text" id="modifyBtd" name="date"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>薪水：</h4>
                        <input type="text" id="modifySalary" name="salary"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="modifyTeacher()">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="clear()">取消</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
