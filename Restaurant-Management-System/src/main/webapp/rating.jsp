<%@page import="com.jsp.dto.Menu"%>
<%@page import="com.jsp.dto.Cart"%>
<%@page import="com.jsp.service.CartService"%>
<%@page import="java.util.List"%>
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
	<%-- <%
	Cookie[] cookies = null;
    
    cookies = request.getCookies();
    
    if( cookies != null && cookies.length>0) { 
    	out.println("Rating added");
    }%> --%>
    <section  class="login-container">
	<form action="rating" method="post">

		<%
		CartService cartService = new CartService();
		List<Cart> carts = cartService.getCarts();
		int id = 0;
		%>
		<%

		%>
		<table class="styleTable">
			<thead>
				<th>FOOD ID</th>
				<th>FOOD NAME</th>
			</thead>
			<%
			for (Cart c : carts) {
				List<Menu> menus = c.getMenus();
			%>
			<tr>
				<%
				for (Menu m : menus) {
				%>
				<td><%=m.getF_id()%></td>
				<td><%=m.getF_name()%></td>
				<%
				}
				%>
			</tr>

			<%
			}
			%>
		</table>
		<p>Enter FoodId to rate:</p>
		<input type="number" name="foodid">
		<p>Click on button to rate:</p>
		
		<input type="submit" name="stars" value="1">
		<input type="submit" name="stars" value="2">
		<input type="submit" name="stars" value="3">
		<input type="submit" name="stars" value="4">
		<input type="submit" name="stars" value="5">
		
		<input type="submit" name="logout" value="Logout">
	</form>
	</section>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>