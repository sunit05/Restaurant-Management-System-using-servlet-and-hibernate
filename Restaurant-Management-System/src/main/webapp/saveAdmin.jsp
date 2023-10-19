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
<form action="saveAdmin" method="post">
	
	name: <br><input type="text" name="name" > <br> <br>
	username: <br><input type="text" name="un" > <br> <br>
	password: <br><input type="password" name="pw1" > <br> <br>
	Enter password again to confirm: <br><input type="password" name="pw2" > <br> <br>
	
	<input type="submit">
	
	</form>
	</section>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>