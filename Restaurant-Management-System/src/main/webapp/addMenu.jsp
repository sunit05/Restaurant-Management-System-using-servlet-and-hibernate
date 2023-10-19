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
	<%
	HttpSession httpSession = request.getSession();
	String s = (String) httpSession.getAttribute("sessionname");
	%>
	<%
	if (s.equals(null)) {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
		requestDispatcher.include(request, response);
	}
	%>
	<section  class="login-container">
	<form action="addMenu" method="post">

		name: <br>
		<input type="text" name="name"> <br> <br> category:
		<br>
		<input type="text" name="category"> <br> <br> cost:
		<br>
		<input type="number" name="cost"> <br> <br> <input
			type="submit">
	</form>
	</section>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>