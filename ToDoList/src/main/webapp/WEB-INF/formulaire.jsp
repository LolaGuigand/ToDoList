<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href ="./style.css">
<title>ToDo list</title>
</head>
<body>

<h1>Ma liste</h1>

<form action="./" method="POST">
<!-- si ma liste de t�ches n'est pas vide ... -->
<c:if test="${!empty ListeAFaire}">
<h2>� faire :</h2>
<ul>
	<c:forEach items="${ListeAFaire}" var="choseAFaire"  varStatus="status">
			<li>
				<span>${choseAFaire}</span>
				<!-- On va arriver au m�me endroit que lorqu'on cr�e une t�che
				 on ajoute un param�tre name au bouton pour indiquer au doPost() que l'on souhaite supprimer une t�che et pas en ajouter
				 status.index correspond � l'index de la t�che � supprimer. -->
				<!--   <button type="submit" name="update" value="${status.index}"><img alt="modifier" src="images/edit--v1.png" width="15px" name="changement"></button> -->
				 <button type="submit" name="delete" value="${status.index}"><img alt="supprimer" src="images/delete.png"width="15px"name="changement"></button>
			</li>
			</c:forEach>
</ul>
</c:if>
<c:if test="${empty ListeAFaire}">

<p>Vous n'avez pas de t�che en cours.</p>
</c:if>

            
<input type="text" name="afaire" placeholder="nouvelle t�che" autofocus="autofocus" />
<button type="submit">ENVOYER</button>

<!-- Ajouter la possibilit� de supprimer /modifier une t�che
<!--  -->

</form>
</body>
</html>