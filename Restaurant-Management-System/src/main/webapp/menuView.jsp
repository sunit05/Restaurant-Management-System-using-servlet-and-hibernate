
<%@page import="com.jsp.dto.Menu"%>
<%@page import="com.jsp.service.MenuService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>save</title>
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
	String s = (String) httpSession.getAttribute("sessionname");
	%>
	<%
	if (s.equals(null)) {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
		requestDispatcher.include(request, response);
	}
	%>

<section  class="login-container">
	<form action="viewMenu" method="post">


		<h1>menu</h1>
		<%
		MenuService menuService = new MenuService();
		List<Menu> menus = menuService.getMenus();
		%>
		<table class="styleTable">
			<thead>
				<th>ID</th>
				<th>CATEGORY</th>
				<th>FOOD NAME</th>
				<!-- <th>ABOUT FOOD</th> -->
				<th>PRICE</th>
				<th>RATING</th>

			</thead>
			<%
			List<Menu> menus2 = new ArrayList<Menu>();
			List<Cookie> cookies = new ArrayList<Cookie>();
			for (Menu m : menus) {
			%>

			<tr>
				<td><%=m.getF_id()%></td>
				<td><%=m.getF_category()%></td>
				<td><%=m.getF_name()%></td>
				<%-- <td><%=m.getf_description()%></td> --%>
				<td><%=m.getF_cost()%></td>
				<%-- <td><%=m.getChef()%></td> --%>
				<td><%=m.getF_rating()%></td>
				
			</tr>
			<%
			}
			%>
		</table>

		<!-- <br> <br> <input type="submit"> -->
	</form>
	</section>
	<footer>
		<p>&copy; 2023 Indian Lounge</p>
	</footer>
</body>
</html>