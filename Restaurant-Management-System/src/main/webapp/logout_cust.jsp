<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<form action="logout_cust" method="post">

		<%HttpSession httpSession=request.getSession();
		String s=(String)httpSession.getAttribute("customer_session_name");
		
		%>
		<%
		if(s.equals(null)){
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.jsp");
		requestDispatcher.include(request, response);
		
		}
		%>
		<br><h3>
	 <%= s %> , THANKS FOR VISITING OUR RESTAURANT</h3>
		<br><br>
		<%httpSession.removeAttribute("customer_session_name");
		httpSession.invalidate();
		%>
		<a href="home.jsp">RETURN TO HOME</a>
</form>
</section>
<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>