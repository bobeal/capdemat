<%@ page contentType="text/html ; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects/>
<portlet:actionURL var="actionURL"/>

<c:if test="${error != null}">
	<span class="portlet-msg-error">Impossible d'authentifier '${username}' <!-- ${error} --></span>
</c:if>

<form method="POST" action="@cvq/fo-login">
					
	<fieldset>
		<legend>Connexion</legend>
		
		<p>
			<label class="portlet-form-label">Nom d'utilisateur :</label>
			<input class="portlet-form-input-field" type="text" name="username" value="${username}"/>
		</p>
						
		<p>
			<label class="portlet-form-label">Mot de passe :</label>
			<input class="portlet-form-input-field" type="password" name="password" />
		</p>
		
	</fieldset>
						
	<p>
		<input class="portlet-form-button" type="submit" value="connexion" />
	</p>
						
</form>