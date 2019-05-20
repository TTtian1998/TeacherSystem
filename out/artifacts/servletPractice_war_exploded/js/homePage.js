
$(function () {
    initTable();
});

//初始化表格列名
function initTable(){
    $("#table").bootstrapTable({
        url: '../TableServlet',
        contentType: 'json',
        method: 'post',
        dataType: 'json',
        search: true,
        strictSearch: true,
        //隔行换色
        striped: false,
        //分页
        pagination: true,
        showColumns: true,                  //是否显示所有的列
        pageSize: 10,
        pageNumber: 1,
        pageList: [10, 20, 30],
        cache: false, //禁用缓存
        showRefresh: true, //是否显示刷新按钮
        uniqueId: "id",
        smartDisplay:false,
        columns: [{
            align: "center",
            valign: "middle",
            checkbox: true,
            visible: true
        }, {
            title: '序号',
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            field: 'id',
            title: 'id',
            align: 'center',
            valign: 'middle',
        }, {
            field: 'name',
            title: '姓名',
            align: "center",
            valign: "middle",
        }, {
            field: 'school',
            title: '学校',
            align: "center",
            valign: "middle",
        },{
            field: 'major',
            title: '专业',
            align: "center",
            valign: "middle",
        },{
            field: 'date',
            title: '生日',
            align: "center",
            valign: "middle",
        },{
            field: 'salary',
            title: '薪水',
            align: "center",
            valign: "middle",
        },{
            title: '操作',
            align: "center",
            valign: "middle",
            // events:operateEvents,
            formatter: operateFormatter
        }]
    });
}

//表格中加入按钮
function operateFormatter(value, row, index) {
    return [
        '<button type="button" class="viewT btn btn-primary btn-sm" onclick="viewTeacher()">查看</button>',
        '<button type="button" class="modifyT btn btn-danger btn-sm"  onclick="modifyTeacher()">修改</button>',
    ].join('');
}
window.operateFormatter = operateFormatter;

// 新增学生
function add() {
    var name =$("#teacherName").val();
    var school =$("#teacherSchool").val();
    var major =$("#teacherMajor").val();
    var date =$("#teacherBtd").val();
    var salary =$("#teacherSalary").val();
    $.ajax({
        url:'../AddServlet',
        method:'',
        async: false,
        data: {
            name: name,
            school: school,
            major: major,
            date : date ,
            salary: salary
        },
        success:function (result) {
            if (result=="true"){
                alert("新增成功");
                $('#addModal').modal('hide');
                // 刷新
                $('#table').bootstrapTable('refresh');
            } else {
                alert("新增失败");
            }
            clear();
        }
    })
}

// 清空新增弹出框中的输入框的值
function clear() {
    $("#teacherName").val("");
    $("#teacherSchool").val("");
    $("#teacherMajor").val("");
    $("#teacherBtd").val("");
    $("#teacherSalary").val("");
}

//查看学生
function viewTeacher() {
    var data = $("#table").bootstrapTable("getSelections");
    $.ajax({
        url: '../ViewServlet',
        method: 'get',
        async: false,
        data: {
            id:parseInt(data[0].id.toString())
        },
        success:function () {
                $('#ViewModal').modal('show');
                $('#viewId').val(parseInt(data[0].id.toString())),
                $('#viewName').val(data[0].name.toString()),
                $('#viewSchool').val(data[0].school.toString()),
                $('#viewMajor').val(data[0].major.toString()),
                $('#viewBtd').val(data[0].date.toString()),
                $('#viewSalary').val(data[0].salary.toString())
        }
    })
}

//删除学生

function deleteInfo() {
    var data = $("#table").bootstrapTable("getSelections");
    $.ajax({
        url: '../DeleteServlet',
        method: 'get',
        async: false,
        data: {
            id:parseInt(data[0].id.toString())
        },
        success:function (result) {
            if (result=='true') {
                alert("删除成功");
                $('#table').bootstrapTable('refresh');
            }
            else {
                alert("删除失败")
            }
        }
    })
}


// 修改信息
function modifyTeacher() {
    $('#ModifyModal').modal('show');
    var data = $("#table").bootstrapTable("getSelections");

    var name =$("#modifyName").val();
    var school =$("#modifySchool").val();
    var major =$("#modifyMajor").val();
    var date =$("#modifyBtd").val();
    var salary =$("#modifySalary").val();
    $.ajax({
        url: '../ModifyServlet',
        method: 'get',
        async: false,
        data: {
            id:parseInt(data[0].id.toString()),
            name: name,
            school: school,
            major: major,
            date : date ,
            salary: salary
        },
        success:function (result) {
                if (result=='true'){
                    alert("修改成功")
                    $('#ModifyModal').modal('hide');
                    // 刷新
                    $('#table').bootstrapTable('refresh');
                }
                else {
                    alert("修改失败")
                }
            clear();
        }
    })
}
//按年龄排序
function sortByAge() {

}