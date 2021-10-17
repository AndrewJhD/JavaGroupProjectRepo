<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Puppy</title>
</head>
<body>
<h2>Edit This Puppy </h2>
<small class="text-muted">Make changes to the puppy or breed</small>
<br />
<form action ="editHousePetServlet" method="post">
<label for="name">Name:</label><input type ="text" name = "name" value= "${housePetToEdit.name}"><br />
<label for="species">Species:</label>
<input type = "text" name = "species"  value= "${housePetToEdit.species}"><br />
<input type = "hidden" name = "id" value="${housePetToEdit.id}">
<input type = "submit" value="Save Edited Pet" class="btn btn-primary">
</form>
</body>
</html>