<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.VisiteWeb"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Stat</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
<h1 style="text-align:center; margin:20px 0 30px 0">Les visites</h1>
	
	<table class="table table-striped">
		<thead>
            <tr>
                <th>Chemin</th>
                <th>Nombre de visites</th>
                <th>Min</th>
                <th>Max</th>
                <th>Moyenne</th>
            </tr>
        </thead>
        
        <tbody>
        	<c:forEach var="visite" items="${visite}">
        	<tr>
        		<td>${visite.chemin}</td>
        		<td>${visite.nbVisites}</td>
        		<td>${visite.min}</td>
        		<td>${visite.max}</td>
        		<td>${visite.moy}</td>
        	</tr>
        	</c:forEach>
        </tbody>
        
	
	</table>
</body>
</html>