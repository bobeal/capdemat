<%@ page contentType="text/html ; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources"/>

<c:if test="${error != null}">
  <p>
    <c:if test="${error == 'error.remote_exception'}">
      <span class="portlet-msg-error"><fmt:message key="cvq.error.remote_exception"/>.</span>
    </c:if>
  </p>
</c:if>
<c:if test="${error == null}">
  <ul style="margin-top:0px;">
    <li class="cvqfo-request cvqfo-request-inprogress ${requestedState == 'inprogressRequests' ? 'cvqfo-request-selected' : ''}">
    		<a href="@cvq/requests/category?requestedState=inprogressRequests">${fn:length(inprogressRequests)} demande(s) en cours</a>
    	</li>
    <li class="cvqfo-request cvqfo-request-accepted ${requestedState == 'acceptedRequests' ? 'cvqfo-request-selected' : ''}">
    		<a href="@cvq/requests/category?requestedState=acceptedRequests">${fn:length(acceptedRequests)} demande(s) acceptée(s)</a>
    	</li>
    <li class="cvqfo-request cvqfo-request-failed ${requestedState == 'failedRequests' ? 'cvqfo-request-selected' : ''}">
    		<a href="@cvq/requests/category?requestedState=failedRequests">${fn:length(failedRequests)} demande(s) annulée(s)</a>
    	</li>
    <li class="cvqfo-request cvqfo-request-archived ${requestedState == 'archivedRequests' ? 'cvqfo-request-selected' : ''}">
    		<a href="@cvq/requests/category?requestedState=archivedRequests">${fn:length(archivedRequests)} demande(s) archivée(s)</a>
    	</li>
  </ul>
  <a href="@cvq/requests/create" class="cvqfo-newrequest">Nouvelle demande</a>
</c:if>


