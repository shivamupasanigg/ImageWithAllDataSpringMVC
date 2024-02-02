<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>File Upload</h1>
	<form action="insert" method="post" enctype="multipart/form-data">

		<label for="name">name :: </label> <input type="text" id="name"
			name="name" required><br>
		<br> <label for="email">email :: </label> <input type="email"
			id="email" name="email" required><br>
		<br> <label for="address">address :: </label>
		<textarea id="address" name="address" rows="4" cols="50"></textarea><br>

		<label for="phone">Phone Number ::</label> <input type="tel"
			id="phone" name="phone" required><br><label for="file">Select
			Image:</label> <input type="file" id="file" name="file" required><br>
		<br> <input type="submit" value="Submit">

	</form>

	<a href="showImage">show image</a>
</body>
</html>