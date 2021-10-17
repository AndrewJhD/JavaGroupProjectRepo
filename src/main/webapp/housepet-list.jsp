<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HousePetList</title>
</head>
<body>
<form method = "post" action = "navigationServlet" >
<table class="table table-striped table-hover">
<c:forEach items="${requestScope.allHousetPets}" var="currenthousepet">
<tr>
   <td><input type="radio" name="id" value="${currenthousepet.id}" ></td>
   <td>${currenthousepet.name}</td>
   <td>${currenthousepet.species}</td>
   </tr>
</c:forEach>
</table>
<br />
<input type = "submit" value = "edit" name="doThisToHousePet" class="btn btn-warning">
<input type = "submit" value = "delete" name="doThisToHousePet" class="btn btn-danger">
<input type="submit" value = "add" name = "doThisToHousePet" class="btn btn-success">

</form>
</body>
</html>