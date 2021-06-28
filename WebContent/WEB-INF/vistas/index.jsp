<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String texto="";
	String clave="";
	String esValio="";
	if(request.getParameter("txtBoxUsuario")!= null)
	{
		texto=request.getParameter("txtBoxUsuario");
		clave=request.getParameter("txtBoxClave");
		esValio=request.getParameter("usuarioValido");
		
	}else{
		response.sendRedirect("login.jsp");
	}
%>
El usuario es: 
<%=texto%>
</br>
La clave es: 
<%=clave%>
</br>
Usuario valido: 
<%=esValio%>
</body>
</html>