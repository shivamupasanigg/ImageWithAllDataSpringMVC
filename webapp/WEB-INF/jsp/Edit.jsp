<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center"></div>
        <h2>Edit Customer</h2>
        
         <form:form action="update" method="post" modelAttribute="student" enctype="multipart/form-data">
                
                   ${student.id}
                 <form:hidden path="id" name="id"/>  
                 <br>
                 name : <form:input path="name"  name="name" value=""/> 
                 <br>
                 email : <form:input path="email" type="email" name="email" value=""/>
                 <br>
                 address : <form:textarea path="address" cols="25" rows="5" name="address"/>
                 <br>
                  Phone Number :<form:input path="phone" type="tel" id="phone" name="phone" />
                    <br>     
                image :: <input type="file" id="file" name="file" required>
<br>
      			<input type="submit" value="Update">
                    <br>               
         </form:form>
</body>
</html>