<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center; margin:20px 0 30px 0">Activité depuis le démarrage:</h1>
	
	<table class="table table-striped">
		<thead>
            <tr>
                <th>Date/Heure</th>
                <th>Libellé</th>
               
            </tr>
        </thead>
        
        <tbody>
        	<c:forEach var="evt" items="${listeEvt}">
        	<tr>
        		<td>${evt.dateHeure}</td>
        		<td>${evt.type.toString()} - matricule: ${evt.matricule}</td>
        		
        	</tr>
        	</c:forEach>
        </tbody>
        
	
	</table>
</body>
</html>