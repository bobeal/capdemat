<%@ page contentType="text/html ; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<portlet:defineObjects/>
<portlet:actionURL var="actionURL"/>

<span class="portlet-msg-info">Vous &ecirc;tes connect&eacute; en tant que <strong>${renderRequest.remoteUser}</strong></span>

<p>
	Cliquez pour vous <a href="@cvq/fo-logout">d&eacute;connecter</a>
</p>