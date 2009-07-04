<div id="search-form">
  <h1><g:message code="payment.header.search" /></h1>
  <form method="POST" id="paymentForm" class="advanced-search" action="<g:createLink action="search" />">
    <input type="hidden" id="totalRecords" name="totalRecords" value="${totalRecords}" />
    <input type="hidden" id="recordsReturned" name="recordsReturned" value="${recordsReturned}" />
    <input type="hidden" id="recordOffset" name="recordOffset" value="${recordOffset}" />
    <input type="hidden" id="paginatorChange" name="paginatorChange" />
    <input type="hidden" id="sortBy" name="sortBy" value="${sortBy}" />
    <input type="hidden" id="filterBy" name="filterBy" value="${filterBy}" />
    <input type="hidden" id="mode" name="mode" value="advanced" />
    <div class="yui-g">
  
      <div class="yui-u first">
        <label for="requesterLastName"><g:message code="property.userLastName" /> :</label>
        <input type="text" id="requesterLastName" name="requesterLastName" size="40" value="${params?.requesterLastName}"/>
      
        <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
        <input type="text" id="homeFolderId" name="homeFolderId" size="40" value="${params?.homeFolderId}"/>
       
        <label for="cvqReference"><g:message code="payment.property.cvqReference" /> :</label>
        <input type="text" id="cvqReference" name="cvqReference" size="40" value="${params?.cvqReference}"/>
       
      </div>
    
      <div class="yui-u">
      
        <label for="bankReference"><g:message code="payment.property.bankReference" /> :</label>
        <input type="text" id="bankReference"  name="bankReference" size="40" value="${params?.bankReference}"/>

        <label for="initDateFrom">
          <g:message code="payment.search.initializationDatePeriod" /> :
        </label>
        <input type="text" id="initDateFrom" name="initDateFrom" value="${params?.initDateFrom}"size="8"/>
        <a onclick="showCalendar('initDateFromShow', 0);">
          <img id="initDateFromShow" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
        </a>
        <div id="initDateFromCalContainer" class="yui-cal"></div>
        <span> - </span>
        <input type="text" id="initDateTo" name="initDateTo" value="${params?.initDateTo}"size="8"/> 
        <a onclick="showCalendar('initDateToShow', 1);">    
          <img id="initDateToShow" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
        </a>
        <div id="initDateToCalContainer" class="yui-cal"></div>
      </div>
    </div>
    <div style="clear:both;">&nbsp;</div>
    <input type="button" id="submitSearchPayment" name="submitSearchPayment"
        class="form-button" value="<g:message code="action.search" />"/>
   
  </form>
</div>