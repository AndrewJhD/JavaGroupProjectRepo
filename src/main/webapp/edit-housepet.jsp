<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Pet</title>
</head>
<body>
<h2>Edit This Pet </h2>
<small class="text-muted">Make changes to the name or species</small>
<br />
<form action ="editHousePetServlet" method="post">
<label for="housepet">Pet:</label><input type ="text" name = "housepet" value= "${housepetToEdit.name}"><br />
<label for="species">Species:</label>
<input type = "text" name = "species"  value= "${housePetToEdit.species}"><br />
<input type = "hidden" name = "id" value="${housePetToEdit.id}">
<input type = "submit" value="Save Edited Puppy" class="btn btn-primary">
</form>
</body>
</html>