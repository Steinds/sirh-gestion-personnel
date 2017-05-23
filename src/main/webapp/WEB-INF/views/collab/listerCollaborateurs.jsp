<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<h1>Liste de nos Collaborateurs :</h1>
	<!-- Liste des noms -->
	<a href="<c:url value='/collaborateurs/nouveau'></c:url>" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Nouveau </a><br><br>
	
	
	<div class="row">
	
		<c:forEach var="collab" items="${collaborateurs}">
  			<div class="col-sm-6 col-md-4 col-lg-3">
   				 <div class="thumbnail">  				 	
 						 <div class="well">
   							 <strong> ${collab.nom}  ${collab.prenom}</strong>
 						 </div>				
     				 <img src="${collab.photo}" style="width:180px;height:150px;">
     				 <br>
     				 <div class="caption well">    			
      					  <p>Matricule: ${collab.matricule}</p> <p>Adresse: ${collab.adresse}</p> <p>Date de Naissance: ${collab.dateNaissance}</p> <p>Numéro de sécu:${collab.secu}</p> <p>Email: ${collab.emailPro}</p> 
       					  <a href="#" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-pencil"></span> Editer </a>
     				 </div>
   				 </div>
 			 </div>					  
		</c:forEach>
	</div>
	
	
</body>
</html>
