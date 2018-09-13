<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Olá Mundo JSP</title>
</head>
<body>
	<%!
		private int counter = 0;
		private String getNow(){
			Date now = new Date();
			String date = new SimpleDateFormat("dd/MM/yyyy").format(now);
			return date;
		}
	%>
	<%
		String name = request.getParameter("nome");
		
		if(getNow().startsWith("07/09")){
			out.print("Dia de descanso");
		}
		else{
	%>
		<%= "Dia de trabalho" %>
	<%} %>
	<strong>Seja bem-vindo </strong><%= name %>
</body>
</html>