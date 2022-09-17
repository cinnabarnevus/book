<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/9/8
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>addShopper.jsp</title>
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
</head>
<body>
    <form action="AddShopper" method="post"  >
        <div align="center">
            <h2>Add Shopper</h2>
            id: <input type="text" name="id" /><br/><br/>
            书店名: <input type="text" name="name" /><br/><br/>
            地址: <input type="text" name="address"/><br/><br/>
            联系方式: <input type="text" name="phone" /><br/><br/>
            <input type="submit" value="Add" class="sub"><br/><br/>
        </div>
    </form>
    <form action="showShopper.jsp" method="post" >
        <div align="center">
            <input type="submit" value="show All Shoppers" class="sub"><br/><br/>
        </div>
    </form>
</body>
</html>
