<div class="txt-right" id="requestSearchSwitcher">
  <g:message code="action.goToRequestSearch" /> |
  <a href="${createLink(controller:'backofficeExternal',action:'search')}" class="simple">
    <g:message code="action.goToExternalSearch" /></a>
</div>

<div id="search-form">
  <h1><g:message code="request.header.search" /></h1>
  <form method="post" id="requestForm" class="advanced-search" action="${createLink(action:'search')}">
    <input type="hidden" id="totalRecords" name="totalRecords" value="${totalRecords}" />
    <input type="hidden" id="recordsReturned" name="recordsReturned" value="${recordsReturned}" />
    <input type="hidden" id="recordOffset" name="recordOffset" value="${recordOffset}" />
    <input type="hidden" id="sortBy" name="sortBy" value="${sortBy}" />
    <input type="hidden" id="filterBy" name="filterBy" value="${filterBy}" />

    <div class="yui-g">
      <div class="yui-u first">
        <label for="id"><g:message code="request.property.requestId" /> :</label>
        <input type="text" id="id" name="id" size="40" value="${params?.id}" />
        
        <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
        <input type="text" name="homeFolderId" size="40" value="${params?.homeFolderId}" />
      </div>

      <div class="yui-u">
        <label for="requesterLastName"><g:message code="request.property.requesterLastName" /> :</label>
        <input type="text" name="requesterLastName" size="40" value="${params?.requesterLastName}" />
          
        <label for="subjectLastName"><g:message code="request.property.subjectLastName" /> :</label>
        <input type="text" name="subjectLastName" size="40" value="${params?.subjectLastName}" />

        <label for="creationDateFrom"><g:message code="request.search.creationDateInterval" /> :</label>
        <input type="text" id="creationDateFrom" name="creationDateFrom" size="10" value="${params?.creationDateFrom}" />
        <a>
          <img id="creationDateFromShow" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
        </a>
        <div id="creationDateFromCalContainer" class="yui-cal"></div>
        <input type="text" id="creationDateTo" name="creationDateTo" size="10" value="${params?.creationDateTo}" />
        <a>
          <img id="creationDateToShow" src="${resource(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
        </a>
        <div id="creationDateToCalContainer" class="yui-cal"></div>
      </div>
    </div>
    <div class="form-button">
      <input type="submit" value="<g:message code="action.search" />"/>
    </div>
  </form>
</div>
