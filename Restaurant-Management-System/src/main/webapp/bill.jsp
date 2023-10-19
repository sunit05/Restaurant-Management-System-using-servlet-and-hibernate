<%@page import="com.jsp.dto.Menu"%>
<%@page import="com.jsp.dto.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.service.CartService"%>
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
	String s = (String) httpSession.getAttribute("customer_session_name");
	%>
	<%
	if (s.equals(null)) {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
		requestDispatcher.include(request, response);
	}
	%>
	<section  class="login-container">
	<form action="bill" method="post">


		<h1>menu</h1>
		<%
		CartService cartService = new CartService();
		List<Cart> carts = cartService.getCarts();
		%>
		<%!double a = 0;
	double b = 0;%>
		<table class="styleTable">
			<thead>
				<th>FOOD NAME</th>
				<th>PRICE</th>

			</thead>

			<%
			for (Cart c : carts) {
				List<Menu> menus = c.getMenus();
				int id = 0;
			%>

			<tr>
				<!--  <td><%=c.getCart_id()%></td>-->
				<%
				for (Menu m : menus) {
				%>
				<td><%=m.getF_name()%></td>
				<td><%=a = m.getF_cost()%></td>
				<%

				b = a + b;
				%>

				<%
				}
				%>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan="3"><b>Total = <%=b%></b></td>
			</tr>
		</table>
		<%b=0;%>
		<input type="hidden" name="total" value="<%=b%>"> <br> <br>
		<input type="submit" name="pay" value="PAY BILL">
	</form>
	</section>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>