<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>save</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
		<img class="restaurant-logo" src="logo.png" alt="">
	</header>

	<nav>
		<ul>
			<li><a href="home.jsp">Home</a></li>
		</ul>
	</nav>
<form action="updateAdmin" method="post">
	
	enter the admin id: <br> <input type="text" name="id"><br> <br>
	enter old username:<br> <input type="text" name="old_un" > <br> <br>
	enter old password:<br> <input type="password" name="old_pw" > <br> <br>
	enter new username:<br> <input type="text" name="new_un" > <br> <br>
	enter new password:<br> <input type="password" name="new_pw" > <br> <br>

	<input type="submit">
	
	</form>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>