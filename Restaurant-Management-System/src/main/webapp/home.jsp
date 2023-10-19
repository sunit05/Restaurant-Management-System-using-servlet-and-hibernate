<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Indian Lounge</title>
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

	<form action="Home" method="post">
		<section class="login-container">

			<input class="login-button" type="submit" value="Admin Login"
				name="adminLogin"> <br> <br> <input
				class="login-button" type="submit" value="Chef Login"
				name="chefLogin"> <br> <br> <input
				class="login-button" type="submit" value="Order Food"
				name="customerLogin"><br> <br>
		</section>
	</form>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>