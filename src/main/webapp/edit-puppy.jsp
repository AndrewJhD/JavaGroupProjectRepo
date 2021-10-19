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
<form action ="editPuppyServlet" method="post">
<label for="puppy">Puppy:</label><input type ="text" name = "puppy" value= "${puppyToEdit.puppy}"><br />
<label for="breed">Breed:</label>
<input type = "text" name = "breed"  value= "${puppyToEdit.breed}"><br />
<input type = "hidden" name = "id" value="${puppyToEdit.id}">
<input type = "submit" value="Save Edited Puppy" class="btn btn-primary">
</form>
</body>
</html>