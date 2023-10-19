<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
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
	<form action="adminDash" method="post">
		<input type="submit" value="View All Chef" name="viewChef"> <br>
		<br> <input type="submit" value="View Menu" name="viewMenu"><br>
		<br> <input type="submit" value="Add Food" name="addFood"><br>
		<br> <input type="submit" value="Remove Food" name="removeFood"><br>
		<br> <input type="submit" value="LOGOUT" name="logout">
	</form>
	</section>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>