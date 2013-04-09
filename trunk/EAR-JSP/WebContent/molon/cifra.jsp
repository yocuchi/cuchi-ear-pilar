<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    %>
    <%@ page import="Cifrado.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>
<%-- This is a JSP Comment before JSP Scriplet --%>
<%
	
		out.println("HOLA "+session.getAttribute( "theName" )+"<br/>");	


%>

<p> el texto de la Bilbia segun tu nombre es </p>

<%
String texto = "En aquel tiempo dijo Jesús a los os que habían creído en él: «Si os mantenéis en mi Palabra, seréis verdaderamente mis discípulos, y conoceréis la verdad y la verdad os hará libres». Ellos le respondieron: «Nosotros somos descendencia de Abraham y nunca hemos sido esclavos de nadie. ¿Cómo dices tú: Os haréis libres?» Jesús les respondió: «En verdad, en verdad os digo: todo el que comete pecado es un esclavo. Y el esclavo no se queda en casa para siempre; mientras el hijo se queda para siempre. Si, pues, el Hijo os da la libertad, seréis realmente libres. Ya sé que sois descendencia de Abraham; pero tratáis de matarme, porque mi Palabra no prende en vosotros. Yo hablo lo que he visto donde mi Padre; y vosotros hacéis lo que habéis oído donde vuestro padre». Ellos le respondieron: «Nuestro padre es Abraham». Jesús les dice: «Si sois hijos de Abraham, haced las obras de Abraham. Pero tratáis de matarme, a mí que os he dicho la verdad que oí de Dios. Eso no lo hizo Abraham. Vosotros hacéis las obras de vuestro padre». Ellos le dijeron: «Nosotros no hemos nacido de la prostitución; no tenemos más padre que a Dios». Jesús les respondió: «Si Dios fuera vuestro Padre, me amaríais a mí, porque yo he salido y vengo de Dios; no he venido por mi cuenta, sino que Él me ha enviado";

out.println(CifradorLocoAscii.cifra(texto,Integer.parseInt(session.getAttribute( "login" ).toString())));

%>
 
</body>
</html>