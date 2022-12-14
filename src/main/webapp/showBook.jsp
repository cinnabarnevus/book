<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="beans.Book"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%><!--表示允许EL表达式-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showBook.jsp(顾客买书页面的展示)</title>
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

</style>
</head>

<body>
	<h2 align="center">Welcome to buy books</h2>
	<table align="center" border="0" cellpadding="5">
		<tr align="center" style="color: #006633">
			<th>No. &nbsp&nbsp&nbsp&nbsp </th><!--表格的表头以th标签进行定义-->
			<th>&nbsp Name &nbsp&nbsp&nbsp&nbsp</th>
			<th >Price&nbsp&nbsp</th>
			<!-- 
			<th>数量</th>
			<th>作者</th>
			 -->
			<th>Buy&nbsp</th>
		</tr>

		<c:set value="1" var="coun"></c:set>

		<form action="AddCart" method="post" onsubmit="return check(this);">
			<c:forEach items="${sessionScope.list2}" var="book"><!--var表示变量名-->
				<tr align="center">
					<td><c:out value="${coun}"></c:out></td>
					<c:set value="${coun+1}" var="coun"></c:set>
					<td style="color: #116149">&nbsp《${book.value.name}》<!--哈希表中数据的存储是以键值对的形式存储的，故此处的book需要加.value来访问name-->
						<sub> <a href="detail.jsp?id=${book.key}&name=${book.value.name}&price=${book.value.price}&bookCount=${book.value.bookCount}&author=${book.value.author}">more</a>
						</sub>&nbsp&nbsp&nbsp
					</td>

					<td>${book.value.price}&nbsp&nbsp&nbsp</td>

					<td>
						 <input	name="check" type="checkbox" value="${book.key}">
					</td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td colspan="6"><input class="sub" type="submit" value="Add Cart"></td>
			</tr>
		</form>
	</table>
	<br>
	<a href="login.jsp" >back</a>
</body>
</html>