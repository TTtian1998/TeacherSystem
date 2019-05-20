$(function(){
    $("#loginBtn").click(function() {
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            url:'../LoginServlet',
            method:'get',
            async:false,
            data:{
                username:username,
                password:password
            },
            success:function(result){
                if (result=="true"){
                    setInterval(function () {
                        window.location.href="http://localhost:8080/jsp/homePage.jsp";
                    },100)
                }else{
                    alert("登录失败!")
                }
            }
        })
    })
});