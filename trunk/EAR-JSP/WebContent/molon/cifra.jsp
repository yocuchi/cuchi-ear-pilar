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
String texto = "En aquel tiempo dijo Jes�s a los os que hab�an cre�do en �l: �Si os manten�is en mi Palabra, ser�is verdaderamente mis disc�pulos, y conocer�is la verdad y la verdad os har� libres�. Ellos le respondieron: �Nosotros somos descendencia de Abraham y nunca hemos sido esclavos de nadie. �C�mo dices t�: Os har�is libres?� Jes�s les respondi�: �En verdad, en verdad os digo: todo el que comete pecado es un esclavo. Y el esclavo no se queda en casa para siempre; mientras el hijo se queda para siempre. Si, pues, el Hijo os da la libertad, ser�is realmente libres. Ya s� que sois descendencia de Abraham; pero trat�is de matarme, porque mi Palabra no prende en vosotros. Yo hablo lo que he visto donde mi Padre; y vosotros hac�is lo que hab�is o�do donde vuestro padre�. Ellos le respondieron: �Nuestro padre es Abraham�. Jes�s les dice: �Si sois hijos de Abraham, haced las obras de Abraham. Pero trat�is de matarme, a m� que os he dicho la verdad que o� de Dios. Eso no lo hizo Abraham. Vosotros hac�is las obras de vuestro padre�. Ellos le dijeron: �Nosotros no hemos nacido de la prostituci�n; no tenemos m�s padre que a Dios�. Jes�s les respondi�: �Si Dios fuera vuestro Padre, me amar�ais a m�, porque yo he salido y vengo de Dios; no he venido por mi cuenta, sino que �l me ha enviado";

out.println(CifradorLocoAscii.cifra(texto,Integer.parseInt(session.getAttribute( "login" ).toString())));

%>
 
</body>
</html>