<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="familyaccount.manage.title"/></title>
    <script type="text/javascript" src="<c:url value="/js/familyAccountAssociate.js"/>"></script>
  </head>
  
  <body>
    <form id="familyAccountAssociateForm" method="post" action="#">
      <fieldset id="familyAccountAssociateFieldset">
        <legend><fmt:message key="familyaccount.associate.associate_legend"/></legend>
		<label for="familyAccountType">
			<fmt:message key="familyaccount.type"/> : 
		</label>
		<input type="radio" name="familyAccountType" 	value="not_associated" checked="checked" />
		<fmt:message key="familyaccount.type.not_associated" /><br>
		<label>&nbsp;</label>
		<input type="radio" name="familyAccountType" 	value="associated" />
		<fmt:message key="familyaccount.type.associated" /><br>
		<label>&nbsp;</label>
		<input type="radio" name="familyAccountType" 	value="no_meaning"/>
		<fmt:message key="familyaccount.type.no_meaning" /><br>
		<br/>
		<label for="cfaResponsible">
			<fmt:message key="familyaccount.capwebct_responsible_lastname"/> :
		</label>
		<input type="text" name="cfaResponsible" id="cfaResponsible" />
		<br/>
		<label for="externalApplicationId">
			<fmt:message key="external_application.label"/> :
		</label>
		<select id="externalApplicationId" name="externalApplicationId">
			<c:forEach items="${externalApplications}" var="externalApplication">
				<c:if test="${externalApplicationId == externalApplication.id}">
					<option value="<c:out value="${externalApplication.id}"/>" selected="selected">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:if>
				<c:if test="${externalApplicationId != externalApplication.id}">
					<option value="<c:out value="${externalApplication.id}" />">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:if>
			</c:forEach>
		</select>
		<br/>
        <label for="wrappedSubmit">&nbsp;</label>
        <input type="button" id="wrappedSubmit" name="wrappedSubmit" 
        	value="<fmt:message key="action.search"/>"/>
      </fieldset>
    </form>
    
    <div id="familyAccountAssociationDialog" class="yui-skin-sam">
		<div class="hd"><fmt:message key='familyaccount.associate.associate_dialog_legend' /></div>
		<div class="bd">
			<div id="familyAccountAutoComplete">
				<form id="familyAccountAssociationForm" name="familyAccountAssociationForm" method="POST" 
					action="<c:url value='/familyaccount/associate.jsp?action=addFamilyAccountBinding'/>">
					<p style="margin-top:1em;">
						<fmt:message key='familyaccount.autocomplete_association_help' /> :
					</p>
    				<input id="familyAccountInput" type="text" size="50"><br/>
    				<input type="hidden" name="cfaIdToAssociate" id="cfaIdToAssociate"/>
    				<input type="hidden" name="efaIdToAssociate" id="efaIdToAssociate"/>
    				<input type="hidden" name="externalApplicationIdToAssociate" 
    					id="externalApplicationIdToAssociate"/>
    				<div id="familyAccountAutoCompleteContainer" style="margin-top:1em;margin-right:1em;"></div>
    			</form>
			</div>
		</div>
		<div class="ft" style="overflow:visible;"></div>
	</div>
    
    <div id="search-results-paginator-top" class="search-results-paginator"></div>
   	<div  class="search-results yui-skin-sam">
   		<div id="familyAccountsAssociationTable"></div>
   	</div>
    <div id="search-results-paginator-bottom" class="search-results-paginator"></div>
    
    <!-- family accounts labels used by JS code, put here for i18n purposes -->
    <div id="familyAccountsLabels" style="display:none;">
    	<span id="faTableCfaHeader"><fmt:message key='table.header.capwebct_information'/></span>
    	<span id="faTableEfaHeader"><fmt:message key='table.header.external_application_information'/></span>
    	<span id="faTableId"><fmt:message key='table.header.id'/></span>
    	<span id="faTableResponsible"><fmt:message key='table.header.responsible'/></span>
    	<span id="faTableAddress"><fmt:message key='table.header.address'/></span>
    	<span id="faTableAction"><fmt:message key='table.header.action'/></span>

    	<span id="faAssociationOk"><fmt:message key='action.associate'/></span>
    	<span id="faAssociationCancel"><fmt:message key='action.cancel'/></span>
    	<span id="faAssociationAssociatedMessage"><fmt:message key='familyaccount.associate.associated_message'/></span>

    	<span id="faDeassociationConfirmMessage"><fmt:message key="familyaccount.deassociate_confirm_message"/></span>

    	<span id="faHideConfirmMessage"><fmt:message key="familyaccount.hide_confirm_message"/></span>
    	
    	<span id="faCommonWarning"><fmt:message key="common.warning" /></span>
    	<span id="faCommonYes"><fmt:message key="common.yes" /></span>
    	<span id="faCommonNo"><fmt:message key="common.no" /></span>
    </div>

  </body>
  
</html>
