<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/9/8
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="beans.Shop"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page isELIgnored="false"%>
<jsp:include page='<%="/DoGetShopper"%>'></jsp:include>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<meta charset="UTF-8">
<title>showShopper.jsp</title>
<style type="text/css">
    table {
        border-collapse: collapse;
    }

    body {
        color: #656667;
        font-family: "Akzidenz-Grotesk BQ Light";
    }

    caption {
        line-height: 1.25;
        font-size: 2.825em;
        font-weight: 300;
        color: #006633;
    }

    .sub {
        color: #32bd40;
        outline: none;
        background: #fff;
        border:0;
    }
    .add{
        background: #32bd40;
        color: #fff;
        font-size: 1.25em;
        width:50%;
        line-height:1.5em;
        outline: none;border: none;
    }
</style>

<body align="center">
    <table align="center" border="0" cellpadding="5">
        <caption>
            Shopper Information
        </caption>
        <tr align="center">
            <th>序号</th>
            <th>id</th>
            <th>书店名</th>
            <th>地址</th>
            <th>联系方式</th>
            <th>修改联系方式</th>
            <th>删除</th>
        </tr>
        <c:set value="1" var="coun"></c:set>
        <c:forEach items="${list}" var="book">
            <tr align="center">
                <td><c:out value="${coun}"></c:out></td>
                <c:set value="${coun+1}" var="coun"></c:set>
                <td>${book.value.id}</td>
                <td>${book.value.name}</td>
                <td>${book.value.address}</td>
                <td>${book.value.phone}</td>
                <td>
                    <form action="UpdateShopper" method="post" >
                        <input type="hidden" name="id" value="${book.key}">
                        <input type="text" name="phone" size="3">
                        <input type="submit" value="Update" class="sub">
                    </form>
                </td>
                <td>
                    <form action="DeleteShopper" method="post">
                        <input type="hidden" name="id" value="${book.key}">
                        <input type="submit" value="Delete" class="sub">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form action="addShopper.jsp" method="post" onsubmit="return check(this);">
        <input type="submit"  value="Add Shopper" class="add">
    </form>
    <br>
    <form action="regMerchant.jsp" method="post" onsubmit="return check(this);">
        <input type="submit"  value="Add Merchant" class="add">
    </form>
</body>
</html>
