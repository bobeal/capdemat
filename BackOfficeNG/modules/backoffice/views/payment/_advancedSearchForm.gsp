<h1><g:message code="payment.header.advancedSearch" /></h1>
<form method="POST" id="paymentForm" class="advanced-search" action="<g:createLink action="loadPayments" />">
  <div class="yui-g">
  
    <div class="yui-u first">
      <label for="requesterLastName"><g:message code="payment.property.requesterLastName" /> :</label>
      <input type="text" id="requesterLastName" name="requesterLastName" size="40" value="${requesterLastName}"/>
      
      <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
      <input type="text" id="homeFolderId" name="homeFolderId" size="40" value="${homefolderId}"/>
       
      <label for="cvqReference"><g:message code="payment.property.cvqReference" /> :</label>
      <input type="text" id="cvqReference" name="cvqReference" size="40" value="${cvqReference}"/>
       
      <label for="bankReference"><g:message code="payment.property.bankReference" /> :</label>
      <input type="text" id="bankReference"  name="bankReference" size="40" value="${bankReference}"/>
    </div>
    
    <div class="yui-u">
      <label for="initDateFrom">
        <g:message code="payment.property.payment" />
        (<g:message code="layout.from" /> - <g:message code="layout.to" />) :
      </label>
      <input type="text" id="initDateFrom" name="initDateFrom" value="${initDateFrom}"size="8"/>
      <a onclick="showCalendar('initDateFromShow', 0);">
        <img id="initDateFromShow" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="initDateFromCalContainer" class="yui-cal"></div>
      <span> - </span>
      <input type="text" id="initDateTo" name="initDateTo" value="${initDateTo}"size="8"/> 
      <a onclick="showCalendar('initDateToShow', 1);">    
        <img id="initDateToShow" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="initDateToCalContainer" class="yui-cal"></div>
       
      <label for="paymentState"><g:message code="property.state" /> :</label>
      <select name="paymentState" id="paymentState">
        <option value=""></option>
        <g:each in="${allStates}" var="paymentState">
          <option value="${paymentState}">${paymentState}</option>
        </g:each>
      </select>
      
      <label for="broker"><g:message code="payment.property.broker" /> :</label>
      <select name="broker" id="broker">
        <option value=""></option>
        <g:each in="${allBrokers}" var="broker">
          <option value="${broker.key}">${broker.value}</option>
        </g:each>
      </select>
  </div>
  
  </div>
  <div class="form-button">
    <input type="button" id="submitSearchPayment" name="submitSearchPayment" value="<g:message code="action.search" />" />
  </div>
   
</form>


