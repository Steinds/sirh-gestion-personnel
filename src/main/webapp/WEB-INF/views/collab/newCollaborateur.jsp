<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<form class="form-horizontal" method="post">
<fieldset>

<!-- Form Name -->
<legend>Nouveau Collaborateur</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nom">Nom</label>  
  <div class="col-md-4">
  <input id="nom" name="nom" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="prenom">Prenom</label>  
  <div class="col-md-4">
  <input id="prenom" name="prenom" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="dateNaissance">Date de Naissance</label>  
  <div class="col-md-4">
  <input id="dateNaissance" name="dateNaissance" type="date" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="adresse">Adresse</label>  
  <div class="col-md-4">
  <input id="adresse" name="adresse" type="text" placeholder="" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="secuNum">Numéro de sécu</label>  
  <div class="col-md-4">
  <input id="secuNum" name="secuNum" type="text" placeholder="" maxlength="15" class="form-control input-md"> 
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="buttonCreate"></label>
  <div class="col-md-4">
    <button id="buttonCreate" name="buttonCreate" class="btn btn-warning">Creer</button>
  </div>
</div>
</fieldset>
</form>
</body>
</html>
