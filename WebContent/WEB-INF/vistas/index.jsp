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
	if(request.getParameter("txtBoxUsuario")!= null)
	{
		texto=request.getParameter("txtBoxUsuario");
	}else{
		response.sendRedirect("login.jsp");
	}
%>

<%=texto%>

</body>
</html>