<%@ page contentType="text/html ; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://cvq.pict.org/jsp/taglib" prefix="cvq"%>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources"/>

<c:if test="${error != null}">
  <p>
    <c:if test="${error == 'error.remote_exception'}">
      <span class="portlet-msg-error"><fmt:message key="cvq.error.remote_exception"/>.</span>
    </c:if>
  </p>
</c:if>
<c:if test="${error == null}">
  <c:choose>
	<c:when test="${fn:length(requests) > 0}">
	<div class="cvqfo-requestlist">
	<table width="100%">
		<tr>
			<th><cvq:i18n clazz="fr.cg95.cvq.xml.common.RequestType" field="Id" lang="fr"/></th>
			<th>Demande</th>
			<th><cvq:i18n clazz="fr.cg95.cvq.xml.common.RequestType" field="CreationDate" lang="fr"/></th>
			<th><cvq:i18n clazz="fr.cg95.cvq.xml.common.RequestType" field="LastModificationDate" lang="fr"/></th>
			<th><cvq:i18n clazz="fr.cg95.cvq.xml.common.RequestType" field="State" lang="fr"/></th>
		</tr>
		<c:forEach items="${requests}" var="request">
			<tr>
				<td width="10%"><c:out value="${request.id}"/></td>
				<td width="40%"><c:out value="${request.requestType.label}"/></td>
				<td width="15%">
					<fmt:formatDate value="${request.creationDate}" type="date" pattern="dd MMMM yyyy"/>
				</td>
				<td width="15%">
					<fmt:formatDate value="${request.lastModificationDate}" type="date" pattern="dd MMMM yyyy"/>
				</td>
				<td width="20%">
					<c:set var="requestState" value="${request.state}"/>
					<cvq:i18n clazz="fr.cg95.cvq.xml.common.RequestType" field="State" 
						enumValue="${requestState}" lang="fr"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</c:when>
	<c:otherwise>
	  <p class="portlet-msg-info">Il n'y a pas demandes correspondant aux critères demandés.</p>
	</c:otherwise>
  </c:choose>
</c:if>

