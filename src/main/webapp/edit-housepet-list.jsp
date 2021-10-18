<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a list of pets</title>
</head>
<body>
<h2>Edit This Owner's List </h2>
<small class="text-muted">Make changes to this Owner's pet(s)</small>
<br />
<form action="editListDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
List Name: <input type = "text" name = "listName" value="${listToEdit.listName}"><br />

Record date: <input type ="text" name = "month" placeholder="mm" size="4" value = "${month}"> <input type = "text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">

Owner Name: <input type = "text" name = "ownerName" value="${listToEdit.owner.ownerName}"><br />

All Pets:<br />
</form>
</body>
</html>