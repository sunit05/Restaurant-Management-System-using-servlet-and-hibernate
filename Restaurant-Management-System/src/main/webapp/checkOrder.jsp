<%@page import="com.jsp.dto.Menu"%>
<%@page import="com.jsp.dto.Cart"%>
<%@page import="com.jsp.service.CartService"%>
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
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="table.css">
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
	String un = (String) httpSession.getAttribute("chef_un");

	String pw = (String) httpSession.getAttribute("chef_pw");
	%>
	<%
	if (un.equals(null) && pw.equals(null)) {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
		requestDispatcher.include(request, response);
	}
	%>
	<section  class="login-container">
	<form action="checkOrder" method="post">

		<h1>CURRENT ORDERS</h1>
		<%
		CartService cartService = new CartService();
		List<Cart> carts = cartService.getCarts();
		%>
		<%!double a = 0;
	double b = 0;%>
		<table class="styleTable">
			<thead>
				<th>FOOD NAME</th>
				<th>ORDER STATUS</th>
			</thead>

			<%
			for (Cart c : carts) {
				List<Menu> menus = c.getMenus();
				int id = 0;
			%>

			<tr>
				<%
				for (Menu m : menus) {
				%>
				<td><%=m.getF_name()%></td>
				<td><%=c.getOrder_status()%></td>

				<%
				}
				%>
			</tr>
			<%
			}
			%>
			<tr>
			</tr>
		</table>
		<br>
		<input type="submit" name="serve" value="SERVE FOOD">
	</form>
	</section>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>