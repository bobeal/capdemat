<%@ page contentType="text/html; charset=UTF-8" %>

<html>
  <head>
	<title>SP-PLUS test form</title>
  </head>
  <body>
  	<form method="post">
  		<spring:bind path="userData.homeFolderId">
			Home Folder Id : <input type="text" name="homeFolderId"/>
	  		<br/>
	  	</spring:bind>
  		<spring:bind path="userData.requestId">
  			Request Id : <input type="text" name="requestId"/>
  			<br/>
 	  	</spring:bind>
  		<spring:bind path="userData.amount">
  			Montant : <input type="text" name="amount"/>
  			<br/>
	  	</spring:bind>
  		<input type="submit" name="Payer"/>
  	</form>
  </body>  
</html>