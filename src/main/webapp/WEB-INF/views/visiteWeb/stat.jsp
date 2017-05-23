<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.VisiteWeb"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Stat</title>
</head>
<body>
<h1>Les Statistiques :</h1>
	<c:forEach var="visite" items="${visites}">
	
	<p>	${visite.chemin}	:	${visite.tempsExecution} </p>
	</c:forEach>
</body>
</html>