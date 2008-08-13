<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<html>
  <head>
	<title>SP-PLUS test form</title>
  </head>
  <body>
	<h1>Résultat du paiement</h1>
	<ul>
	  <li>Etat : <c:out value="${etat}"/></li>
	  <li>Référence interne : <c:out value="${refsfp}"/></li>
	  <li>Référence cvq : <c:out value="${reference}"/></li>
	  <li>Montant : <c:out value="${montant}"/></li>
	</ul>
  </body>
</html>