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
	<section  class="login-container">
<form action="deleteAdmin" method="post">
	
	enter the admin id: <br> <input type="text" name="id"><br> <br>
	enter username:<br> <input type="text" name="un" > <br> <br>
	enter password:<br> <input type="password" name="pw" > <br> <br>
	
	<input type="submit">
	
	</form>
	</section>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>