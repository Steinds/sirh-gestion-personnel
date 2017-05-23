<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs</h1>
	<!-- Liste des noms -->
	<ul>
		<%
			List<Collaborateur> collaborateurs = (List<Collaborateur>)request.getAttribute("collaborateurs");
			for (Collaborateur collab : collaborateurs) {
		%>
		<li> <%=collab.getMatricule()%> <%=collab.getNom()%> <%=collab.getPrenom()%>  <%=collab.getAdresse()%> <%=collab.getDateNaissance()%> <%=collab.getSecu()%> <%=collab.getEmailPro()%> <img src="<%=collab.getPhoto()%>" style="width:150px;height:150px;">  </li>
		<%
			}
		%>
	</ul>
	<button class="btn btn-primary">Yes</button>
</body>
</html>
