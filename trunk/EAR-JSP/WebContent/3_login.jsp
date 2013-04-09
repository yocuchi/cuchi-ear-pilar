<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>
<%-- This is a JSP Comment before JSP Scriplet --%>
<%

out.print("<h1> El login es " +request.getParameter("login") +"</h1>");
out.print("<h1> El password es " +request.getParameter("password") +"</h1>");

System.out.println(request.getParameter("login") + "-" +request.getParameter("password") );

session.setAttribute( "Nombre", request.getParameter("login")  );



if (request.getParameter("password")!= null){
%>

<p> Links molones</p>
<a href="molon/saluda.jsp">Saluda</a> <br/>
<a href="molon/cifra.jsp">Saluda</a> <br/>
<% } %>

</body>
</html>