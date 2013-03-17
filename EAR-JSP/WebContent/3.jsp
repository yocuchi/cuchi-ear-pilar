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
	for( int i=0; i<10;i++){
		out.println("HOLA ARTISTA <br/>");	
		
	}
		


%>
 <form name="login" action="3_login.jsp" method="POST">
            Login de Facebook:<br/>
            <input type="text" name="login" value="" /><br/>
            Password de feisbuk:<br/>
            <input type="password" name="password" value="" /><br/>
            <br/>
            <input type="submit" value="Login" /><br/>
        </form>

</body>
</html>