<%@page import="java.io.PrintWriter"%>
<%@page import="com.jsp.dto.Chef"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.service.ChefService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Chefs</title>
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="table.css">
</head>
<body>
	<%
  		HttpSession httpSession=request.getSession();
		String s=(String)httpSession.getAttribute("sessionname");
	%>
	<%
	if(s.equals(null)){
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.jsp");
		requestDispatcher.include(request, response);
	}
	%>

	<header>
		<img class="restaurant-logo" src="logo.png" alt="">
	</header>

	<nav>
		<ul>
			<li><a href="home.jsp">Home</a></li>
		</ul>
	</nav>

	<form action="checkAllChef" method="post">

		<%
		ChefService chefService = new ChefService();
		List<Chef> chefs = chefService.getChefs();
		%>
		<section class="login-container">
			<table class="styleTable">
				<thead>
					<th>ID</th>
					<th>NAME</th>
					<th>USERNAME</th>
					<th>STATUS</th>
					<th>AUTHORIZE?</th>
				</thead>
				<%
				for (Chef c : chefs) {
				%>

				<tr>
					<td><%=c.getCh_id()%></td>
					<td><%=c.getCh_name()%></td>
					<td><%=c.getCh_username()%></td>
					<td><%=c.getCh_status()%></td>
					<td><a style="color:black;" href="auth.jsp?id=<%=c.getCh_id()%>">Authorize</a></td>

				</tr>

				<%
				}
				%>
			</table>
		</section>
	</form>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>