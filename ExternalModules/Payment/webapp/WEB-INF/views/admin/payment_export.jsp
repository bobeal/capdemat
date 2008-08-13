<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="payment.export.title"/></title>
    <link href="<c:url value="/css/yui/calendar.css"/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value="/css/calendar.css"/>" type="text/css" rel="stylesheet" />
    <style type="text/css">
		#paymentDateStartCalContainer { display:none; position:relative; z-index:100;}
		#paymentDateEndCalContainer { display:none; position:relative; z-index:100;}
	</style>
	<script type="text/javascript" src="<c:url value="/js/calendar.js"/>"></script> 
	<%@ include file="/WEB-INF/views/common/payment_table.jsp" %>
    <script type="text/javascript">
		YAHOO.payment_module.calendar.cal = new Array(2);
		YAHOO.util.Event.onDOMReady(YAHOO.payment_module.calendar.init, 
															{id : 0, label : "paymentDateStart"});
		YAHOO.util.Event.onDOMReady(YAHOO.payment_module.calendar.init, 
															{id : 1, label : "paymentDateEnd"});

		YAHOO.util.Event.onContentReady('paymentSearchFieldset', onDefaultSubmitButtonsMarkupReady);
		YAHOO.util.Event.onContentReady('exportDiv"', onDefaultSubmitButtonsMarkupReady);
    </script>
  </head>
  
  <body>
  	
    <form method="post" action="#">
      <fieldset id="paymentSearchFieldset">
        <legend><fmt:message key="payment.export.export_legend"/></legend>
        <c:if test="${error_message != null}">
        	<div class="errors">
        		<fmt:message key="${error_message}">
        			<fmt:param value="${error_message_param}"></fmt:param>
        		</fmt:message>
        	</div>
        </c:if>
		<div class="yui-skin-sam">
			<label for="paymentDateStart"><fmt:message key="payment.payment_date.start"/> : </label>
			<input type="text" id="paymentDateStart" name="paymentDateStart" 
				value="<c:out value="${payment.paymentDateStart}"/>"/>
			<a onclick="showCalendar('paymentDateStartShow', 0);" href="javascript:void(0);">
				<img id="paymentDateStartShow" src="<c:url value='/img/calendar/calendar.gif'/>" />
			</a>
			<div id="paymentDateStartCalContainer" style="position:absolute; display:none;"></div>
		</div>
		<div class="yui-skin-sam">
			<label for="paymentDateEnd"><fmt:message key="payment.payment_date.end"/> : </label>
			<input type="text" id="paymentDateEnd" name="paymentDateEnd" 
				value="<c:out value="${payment.paymentDateEnd}"/>" />
			<a onclick="showCalendar('paymentDateEndShow', 1);" href="javascript:void(0);">
				<img id="paymentDateEndShow" src="<c:url value='/img/calendar/calendar.gif'/>" />
			</a>
			<div id="paymentDateEndCalContainer" style="position:absolute; display:none;"></div>
		</div>
		<label for="externalApplicationId">
			<fmt:message key="external_application.label"/> : 
		</label>
		<select id="externalApplicationId" name="externalApplicationId">
			<option value=""><fmt:message key="common.no_choice"/></option>
			<c:forEach items="${externalApplications}" var="externalApplication">
				<c:if test="${payment.externalApplicationId == externalApplication.id}">
					<option value="<c:out value="${externalApplication.id}"/>" selected="selected">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:if>
				<c:if test="${payment.externalApplicationId != externalApplication.id}">
					<option value="<c:out value="${externalApplication.id}" />">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:if>
			</c:forEach>
		</select>
		<br/>
        <label for="wrappedSubmit">&nbsp;</label>
        <input type="submit" id="wrappedSubmit" name="wrappedSubmit" 
        	value="<fmt:message key="action.search"/>"/>
      </fieldset>
    </form>
    
    <!--  where payments data will appear in a table -->
    <div  class="search-results yui-skin-sam">
    	<div id="paymentsData"></div>
    </div>
    
    <div id="exportDiv">
        <input type="submit" id="wrappedSubmit" name="wrappedSubmit" 
        	value="<fmt:message key="action.export"/>"/>
    </div>
    
  </body>  
</html>
