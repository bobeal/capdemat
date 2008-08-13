<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="invoice.search.title"/></title>
    <link href="<c:url value="/css/yui/calendar.css"/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value="/css/calendar.css"/>" type="text/css" rel="stylesheet" />
    <style type="text/css">
		#paymentDateStartCalContainer { display:none; position:relative; z-index:100;}
		#paymentDateEndCalContainer { display:none; position:relative; z-index:100;}
	</style>
	<script type="text/javascript" src="<c:url value="/js/calendar.js"/>"></script> 
	<script type="text/javascript" src="<c:url value="/js/invoiceDetailPanel.js"/>"></script> 
	<%@ include file="/WEB-INF/views/common/invoice_table.jsp" %>
    <script type="text/javascript">
		YAHOO.payment_module.calendar.cal = new Array(2);
		YAHOO.util.Event.onDOMReady(YAHOO.payment_module.calendar.init, 
															{id : 0, label : "paymentDateStart"});
		YAHOO.util.Event.onDOMReady(YAHOO.payment_module.calendar.init, 
															{id : 1, label : "paymentDateEnd"});
	
		YAHOO.util.Event.onContentReady('invoiceSearchFieldset', onDefaultSubmitButtonsMarkupReady);
    </script>
  </head>
  
  <body>
  	
    <form method="post" action="#">
      <fieldset id="invoiceSearchFieldset">
        <legend><fmt:message key="invoice.search.search_legend"/></legend>
        <c:if test="${error_message != null}">
        	<div class="errors">
        		<fmt:message key="${error_message}">
        			<fmt:param value="${error_message_param}"></fmt:param>
        		</fmt:message>
        	</div>
        </c:if>
		<label for="id"><fmt:message key="invoice.invoice_id"/> : </label>
		<input type="text" id="id" name="id" value="<c:out value="${invoice.id}"/>"/>
		<br/>
		<label for="label"><fmt:message key="invoice.label"/> : </label>
		<input type="text" id="label" name="label" value="<c:out value="${invoice.label}"/>" />
		<br/>
		<div class="yui-skin-sam">
			<label for="paymentDateStart"><fmt:message key="invoice.payment_date.start"/> : </label>
			<input type="text" id="paymentDateStart" name="paymentDateStart" 
				value="<c:out value="${invoice.paymentDateStart}"/>"/>
			<a onclick="showCalendar('paymentDateStartShow', 0);" href="javascript:void(0);">
				<img id="paymentDateStartShow" src="<c:url value='/img/calendar/calendar.gif'/>" />
			</a>
			<div id="paymentDateStartCalContainer" style="position:absolute; display:none;"></div>
		</div>
		<div class="yui-skin-sam">
			<label for="paymentDateEnd"><fmt:message key="invoice.payment_date.end"/> : </label>
			<input type="text" id="paymentDateEnd" name="paymentDateEnd" 
				value="<c:out value="${invoice.paymentDateEnd}"/>" />
			<a onclick="showCalendar('paymentDateEndShow', 1);" href="javascript:void(0);">
				<img id="paymentDateEndShow" src="<c:url value='/img/calendar/calendar.gif'/>" />
			</a>
			<div id="paymentDateEndCalContainer" style="position:absolute; display:none;"></div>
		</div>
		<label for="efaId">
			<fmt:message key="familyaccount.external_account_id"/> : 
		</label>
		<input type="text" id="efaId" name="efaId" 
			value="<c:out value="${invoice.efaId}"/>" />
		<br/>
		<label for="externalApplicationId">
			<fmt:message key="external_application.label"/> : 
		</label>
		<select id="externalApplicationId" name="externalApplicationId">
			<option value=""><fmt:message key="common.no_choice"/></option>
			<c:forEach items="${externalApplications}" var="externalApplication">
				<c:if test="${invoice.externalApplicationId == externalApplication.id}">
					<option value="<c:out value="${externalApplication.id}"/>" selected="selected">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:if>
				<c:if test="${invoice.externalApplicationId != externalApplication.id}">
					<option value="<c:out value="${externalApplication.id}" />">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:if>
			</c:forEach>
		</select>
		<br/>
        <label for="wrappedSubmit">&nbsp;</label>
        <input type="submit" id="wrappedSubmit" name="wrappedSubmit" value="<fmt:message key="action.search"/>"/>
      </fieldset>
    </form>
    
    <!--  where invoices data will appear in a table -->
    <c:if test="${invoices != null}">
    	<div id="search-results-paginator-top" class="search-results-paginator"></div>
    	<div  class="search-results yui-skin-sam">
    		<div id="invoicesData"></div>
    	</div>
    	<div id="search-results-paginator-bottom" class="search-results-paginator"></div>
    </c:if>
    
    <!-- invoice detail panel messages, put here for i18n purposes -->
    <div id="invoicePanelBodyTableHeaders" style="display:none;">
    	<span id="invoicePanelBodyHeader"><fmt:message key="invoice.detail_panel.header" /></span>
    	<span id="invoicePanelBodyTableHeaderLabel"><fmt:message key="invoice.detail_panel.label" /></span>
		<span id="invoicePanelBodyTableHeaderSubject"><fmt:message key="invoice.detail_panel.subject" /></span>
		<span id="invoicePanelBodyTableHeaderUnitPrice"><fmt:message key="invoice.detail_panel.unit_price" /></span>
		<span id="invoicePanelBodyTableHeaderQuantity"><fmt:message key="invoice.detail_panel.quantity" /></span>
		<span id="invoicePanelBodyTableHeaderValue"><fmt:message key="invoice.detail_panel.value" /></span>
    </div>
    
  </body>  
</html>
