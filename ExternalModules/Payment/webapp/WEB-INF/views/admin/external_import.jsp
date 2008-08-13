<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="admin.import_export.title"/></title>
    <script type="text/javascript" src="<c:url value="/js/externalImport.js"/>"></script>
  </head>
  
  <body>
    <form method="post" enctype="multipart/form-data" action="#" id="externalImportForm">
      <fieldset id="adminFieldset">
        <legend><fmt:message key="admin.import_export.import_legend"/></legend>
        <div class="errors-form" id="externalImportFormError"></div>
        <c:if test="${import_result.successful}">
        	<div class="message">
        		<fmt:message key="${import_result.successMessage}">
        			<fmt:param value="${import_result.importedLines}"></fmt:param>
        		</fmt:message>
        		<br/>
        		<c:if test="${! empty import_result.createdEfa}">
        			<fmt:message key="admin.import_export.implicit_created_efa" /> :
        			<c:forEach items="${import_result.createdEfa}" var="createdEfa">
        				<c:out value="${createdEfa}" />&nbsp;
        			</c:forEach>
        		</c:if>
        	</div>
        </c:if>
        <c:if test="${import_result != null}">
        	<c:if test="${!import_result.successful}">
        		<div class="errors">
         			<c:if test="${import_result.failMessage}">
        				<fmt:message key="${import_result.failMessage}" /> :
        			</c:if>
        			<c:forEach items="${import_result.failedImports}" var="failedImport">
        				<fmt:message key="${failedImport.key}" /> :
        				<c:forEach items="${failedImport.value}" var="value">
        					<c:out value="${value}" />&nbsp;
        				</c:forEach>
        			</c:forEach>
        		</div>
        	</c:if>
        </c:if>
		<label for="dataType" class="required"><fmt:message key="common.data_type"/> * : </label>
		<select id="dataType" name="dataType" class="validate-not-empty"
			onchange="updateBrokersState();"
			title="<fmt:message key="admin.import_export.data_type_required"/>">
			<option value=""><fmt:message key="action.choose"/></option>
			<c:forEach items="${externalDataTypes}" var="externalDataType">
				<option value="<c:out value="${externalDataType.key}" />">
					<fmt:message key="${externalDataType.i18nKey}" />
				</option>
			</c:forEach>
		</select>
		<br/>
		<label for="externalApplicationId" class="required">
			<fmt:message key="external_application.label"/> * : 
		</label>
		<select id="externalApplicationId" name="externalApplicationId"
			onchange="loadExternalApplicationBrokers('<c:url value="/admin/extapp_json.jsp"/>');" 
			class="validate-not-empty" title="<fmt:message key="admin.import_export.external_application_required"/>">
			<option value=""><fmt:message key="action.choose"/></option>
			<c:forEach items="${externalApplications}" var="externalApplication">
				<option value="<c:out value="${externalApplication.id}" />">
					<c:out value="${externalApplication.label}" />
				</option>
			</c:forEach>
		</select>
		<br/>
		<label for="externalApplicationBroker" id="externalApplicationBrokerLabel" class="required">
			<fmt:message key="external_application.broker"/> * : 
		</label>
		<input type="text" id="externalApplicationBroker" name="externalApplicationBroker" 
			class="required" title="<fmt:message key="admin.import_export.broker_required"/>" />
		<br/>
		<label for="data" class="required"><fmt:message key="admin.import_export.data_file"/> * : </label>
        <input type="file" id="data" name="data" />
		<br/>
		<label for="detailsData"><fmt:message key="admin.import_export.details_data_file"/> : </label>
        <input type="file" id="detailsData" name="detailsData" />
		<br/>
        <label for="submitSaveExternalImport">&nbsp;</label>
       	<input type="button" id="submitSaveExternalImport" 
                name="submitSaveExternalImport" value="<fmt:message key="action.import"/>" />
      </fieldset>
    </form>
  </body>  
</html>
