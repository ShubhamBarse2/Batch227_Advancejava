<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Welcome to Kiran Academy...</h1>

	<form action="index.jsp" method="post">

		<label>Name : </label> <input type="text" placeholder="Enter UR Name"
			name="name"> <br> <br> <label>Age : </label> <input
			type="number" placeholder="Enter UR Age" name="age"> <br>
		<br> <label>City : </label> <input type="text"
			placeholder="Enter UR City" name="city"> <br> <br>
		<button>Submit</button>
	</form>


	<h1>Informations...</h1>

	<%
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String city = request.getParameter("city");

	System.out.println(name);
	System.out.println(age);
	System.out.println(city);
	%>

	Name :
	<%=name%>
	Age :
	<%=age%>
	City :
	<%=city%>




</body>
</hmtl>