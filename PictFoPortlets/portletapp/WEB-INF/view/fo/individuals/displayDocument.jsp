<%@ page contentType="text/html ; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://cvq.pict.org/jsp/taglib" prefix="cvq"%>

<portlet:actionURL var="actionURL"/>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources"/>

<c:if test="${error != null}">
  <p>
     <c:if test="${error == 'error.remote_exception'}">
        <span class="portlet-msg-error"><fmt:message key="cvq.error.remote_exception"/>.</span>
     </c:if>
  </p>
</c:if>
<c:if test="${error == null}">
  
  <fieldset class="cvqfo-newrequest" id="requestDocuments">
     <c:if test="${model.documentId != null}" >
        <div class="cvqfo-img-zoom">
          <p>
           <img src="/ppa-com.zenexity.pict.cvq/image?documentId=${model.documentId}&name=${model.name}" alt="affichage du document"/>
          </p>
        </div>
     </c:if>
     <c:if test="${model.documentId == null && model.homeFolderId != null}" >
        <center><c:out value="Ici vous pouvez visualiser vos documents" /></center>
     </c:if>
   </fieldset>
</c:if>
