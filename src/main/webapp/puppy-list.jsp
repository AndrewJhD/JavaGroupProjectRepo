<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PuppyList</title>
</head>
<body>
<form method = "post" action = "navigationServlet" >
<table class="table table-striped table-hover">
<c:forEach items="${requestScope.allPuppys}" var="currentpuppy">
<tr>
   <td><input type="radio" name="id" value="${currentpuppy.id}" ></td>
   <td>${currentpuppy.puppy}</td>
   <td>${currentpuppy.breed}</td>
   </tr>
</c:forEach>
</table>
<br />
<input type = "submit" value = "edit" name="doThisToPuppy" class="btn btn-warning">
<input type = "submit" value = "delete" name="doThisToPuppy" class="btn btn-danger">
<input type="submit" value = "add" name = "doThisToPuppy" class="btn btn-success">

</form>
</body>
</html>