<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="payment.search.title"/></title>
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
    </script>
  </head>
  
  <body>
  	
    <form method="post" action="#">
      <fieldset id="paymentSearchFieldset">
        <legend><fmt:message key="payment.search.search_legend"/></legend>
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
		<label for="paymentAck"><fmt:message key="payment.payment_ack"/> : </label>
		<input type="text" id="paymentAck" name="paymentAck" value="<c:out value="${payment.paymentAck}"/>"/>
		<br/>
		<label for="cvqAck"><fmt:message key="payment.cvq_ack"/> : </label>
		<input type="text" id="cvqAck" name="cvqAck" value="<c:out value="${payment.cvqAck}"/>" />
		<br/>
		<label for="cfaId"><fmt:message key="familyaccount.capwebct_id"/> : </label>
		<input type="text" id="cfaId" name="cfaId" value="<c:out value="${payment.cfaId}"/>" />
		<br/>
		<label for="broker"><fmt:message key="external_application.broker"/> : </label>
		<input type="text" id="broker" name="broker" value="<c:out value="${payment.broker}"/>" />
		<br/>
        <label for="wrappedSubmit">&nbsp;</label>
        <input type="submit" id="wrappedSubmit" name="wrappedSubmit" 
        	value="<fmt:message key="action.search"/>"/>
      </fieldset>
    </form>
    
    <!--  where payments data will appear in a table -->
    <c:if test="${payments != null}">
    	<div id="search-results-paginator-top" class="search-results-paginator"></div>
    	<div  class="search-results yui-skin-sam">
    		<div id="paymentsData"></div>
    	</div>
    	<div id="search-results-paginator-bottom" class="search-results-paginator"></div>
    </c:if>
    
  </body>  
</html>
