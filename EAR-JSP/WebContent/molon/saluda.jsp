<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>
<%-- This is a JSP Comment before JSP Scriplet --%>
<%
	
if (session.getAttribute("Nombre") != null){
		out.println("HOLA "+session.getAttribute("Nombre")+"<br/>");	
}
else{
	out.println("No has hecho login!!!");	
}

		


%><img src="chuck">

</body>
</html>