<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<div style="padding:10px;font-size: 1em;font-weight: bold;color: #6e6e6e;">
	    <p class="text">
	    	Votre quotient familial : <bean:write name="familyHome" property="familyQuotient" scope="session"/>
	    </p>
</div>