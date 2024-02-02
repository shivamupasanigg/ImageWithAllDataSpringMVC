<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Base64"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>

	<a href="index">go back insert page</a>
<br>
<br>

	<table border="1" style="float: left;">
		<tr>
			<th>ID</th>
		</tr>
		<c:forEach var="studentList" items="${studentList}">
			<tr>
				<td style="height: 106px;">${studentList.id}</td>
			</tr>
		</c:forEach>
	</table>
	
	<table border="1" style="float: left;">
		<tr>
			<th>images</th>
		</tr>
		<c:forEach var="base64Images" items="${base64Images}">
			<tr>
				<td style="height: 106px;"><img src="data:image/png;base64,${base64Images}" alt="Image" height="100" width="100"></td>
			</tr>
		</c:forEach>
	</table>
	
	
	<table border="1" style="float: left;">
		<tr>
			<th>name</th>
			<th>email</th>
			<th>address</th>
			<th>phone</th>
			<th rowspan="1">actions</th>
		</tr>
		<c:forEach var="studentList" items="${studentList}">
			<tr>
				<td style="height: 106px;">${studentList.name}</td>
				<td style="height: 106px;">${studentList.email}</td>
				<td style="height: 106px;">${studentList.address}</td>
				<td style="height: 106px;">${studentList.phone}</td>
				<td style="height: 106px;"><a href="Edit?id=${studentList.id}">update</a>&nbsp;&nbsp;&nbsp;<a href="Delete?id=${studentList.id}">delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>