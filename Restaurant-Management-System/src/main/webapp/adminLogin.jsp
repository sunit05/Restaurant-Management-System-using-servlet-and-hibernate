<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="styles.css">
<style>
.inputtext{
	color: white;
	font-size: 20px;
	padding: 0;
	margin: 0;
}
</style>
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
	<form action="adminLogin" method="post">
		<section class="login-container">
			<p class="inputtext">Enter Username:</p>
			<br> <input type="text" name="un"> <br> <br>
			<p class="inputtext">Enter Password:</p>
			<br> <input type="password" name="pw"> <br> <br>

			<input class="login-button" type="submit">
			
			<a class="link" href="saveAdmin.jsp">Register</a>
		</section>
	</form>

	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>