<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/9/8
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterMerchant</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<%--    <link rel="stylesheet" href="./css/style.css" type="text/css"/>--%>
    <style>
        body {
            color: #656667;
            font-family: "Akzidenz-Grotesk BQ Light";
        }
        h2 {
            line-height: 1.25;
            font-size: 2.825em;
            font-weight: 300;
            color: #006633;
        }
        .sub{
            background: #32bd40;
            color: #fff;
            font-size: 1.25em;
            width:50%;
            line-height:1.5em;
            outline: none;border: none;
        }
    </style>
    <script type="text/javascript" src="css/mjs.js" charset="UTF-8">
    </script>
    <script type="text/javascript">
        function validate(){
            if(registerForm.username.value==""){
                alert("账号不能为空！");
                return;
            }
            if(registerForm.password.value==""){
                alert("密码不能为空！");
                return;
            }
            if(registerForm.confirmPassword.value==""){
                alert("确认密码不能为空！");
                return;
            }
            registerForm.submit();
        }
    </script>
    <script type="text/javascript">
        function refresh(){
            var d = new Date();
            registerForm.imgValidate.src = 'CodeServlet?t='+d.toString(38);
        }
    </script>
</head>
<body align="center">
    <br>
    <h2>分配账号</h2>
    <form name="registerForm" action="AddMerchant" id="userForm">
        用户名  <input type="text" style="width: 250px"  placeholder="请输入用户名(英文字符或数字)" value="" name ="username"/><span id="userMessage"></span><br><br>
        密码    <input type="password"  style="width: 250px" placeholder="请输入密码(长度在6-12位之间)" value="" name ="password"/><span id="pwdMessage"></span><br><br>
        确认密码<input type="password"   placeholder="请确认密码" value="" id ="confirmPassword"/><span id="conPwdMessage"></span><br><br>
        <input type="button" class="sub" id="register" onClick="validate()" value="注册"><br>
    </form>
    <form name="return" action="showShopper.jsp">
        <input type="submit" class="sub" value="返回">
    </form>
</body>
</html>
