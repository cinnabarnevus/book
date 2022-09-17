<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="beans.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchShopCart</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

body {
	color: #656667;
	font-family: "Akzidenz-Grotesk BQ Light";
}

h2 {
	line-height: 1.25;
	font-size: 3.125em;
	font-weight: 300;
	color: #006633;
}
.sub {
	background: #32bd40;
	color: #fff;
	font-size: 1.25em;
	width: 100%;
	line-height: 1.5em;
	outline: none;
	border: none;
}
.add{
	background: #32bd40;
	color: #fff;
	font-size: 1.25em;
	width:50%;
	line-height:1.5em;
	outline: none;border: none;
}
.sub1 {
	color: #32bd40;
	outline: none;
	background: #fff;
	border:0;
}
</style>
</head>

<body align="center">
<h2 align="center">Shopping Cart</h2>
	<table align="center" border="0" cellpadding="5">
		<tr align="center">
			<th>No.</th>
			<th>Book name</th>
			<th>Price</th>
			<th>Count</th>
			<th>Update</th>
			<th>Delete</th>
			<%-- 以后可以增加删除的功能，或者减少数量 --%>
		</tr>
		<c:set value="1" var="coun"></c:set>
		<c:forEach items="${cart}" var="cartBook">
			<tr align="center">
				<td><c:out value="${coun}"></c:out></td>
				<c:set value="${coun+1 }" var="coun"></c:set>
				<td>《${cartBook.name }》</td>
				<td>${cartBook.price }</td>
				<td>${cartBook.bookCount }</td>
				<td>
					<form action="UpdateCart" method="post" >
						<input type="hidden" name="id" value="${cartBook.id}">
						<input type="text" name="bookCount" size="3">
						<input type="submit" value="Update" class="sub1">
					</form>
				</td>
				<td>
					<form action="DeleteCart" method="post">
						<input type="hidden" name="id" value="${cartBook.id}">
						<input type="submit" value="Delete" class="sub1">
					</form>
				</td>
			</tr>
		</c:forEach>
		<tr align="center">
			<td colspan="4">
			<p><c:out value="${coun-1 }" ></c:out> items in total, total price ：${sessionScope.totalPrice }</p>
			</td>
		</tr>
	</table>

	<form action="showBook.jsp" method="get" onsubmit="return check(this)">
		<input type="hidden" value="1" name="start">
		<input class="add" type="submit" value="继续购买">
	</form>
	<br>
	<form action="AfterPaid" method="post" onsubmit="return check(this)">
		<input class="add"  type="submit" value="结算">
	</form>
</body>
</html>