<div class="txt-right" id="searchSwitcher">
  <a class="simple"
    href="${createLink(controller:'backofficeRequest',action:'initSearch')}">
    <g:message code="action.goToRequestSearch" /></a> |
  <g:message code="action.goToExternalSearch" />
</div>
<div id="search-form">
  <h1><g:message code="requestExternalAction.header.search" /></h1>
  <form method="post" id="searchForm" class="advanced-search" action="${createLink(action:'search')}">
    <input type="hidden" id="totalRecords" name="totalRecords" value="${totalRecords}" />
    <input type="hidden" id="recordOffset" name="recordOffset" value="${recordOffset}" />
    <input type="hidden" id="sortBy" name="sortBy" value="${sortBy}" />
    <input type="hidden" id="filterBy" name="filterBy" value="${filterBy}" />
    <div class="yui-g">
      <div class="yui-u first">
        <label for="key"><g:message code="requestExternalAction.property.key" /> :</label>
        <input type="text" id="key" name="key" size="40" value="${key}" />
        <label for="lastOnly"><g:message code="requestExternalAction.search.message.lastOnly" /> :</label>
        <input type="checkbox" id="lastOnly" name="lastOnly" <g:if test="${lastOnly}">checked="checked" </g:if>/>
      </div>
      <div class="yui-u">
        <label for="dateFrom"><g:message code="requestExternalAction.search.message.dateFrom" /> :</label>
        <input type="text" id="dateFrom" name="dateFrom" size="10" value="${dateFrom}" />
        <a>
          <img id="dateFromShow" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
        </a>
        <div id="dateFromCalContainer" class="yui-cal"></div>
        <label for="dateTo"><g:message code="requestExternalAction.search.message.dateTo" /> :</label>
        <input type="text" id="dateTo" name="dateTo" size="10" value="${dateTo}" />
        <a>
          <img id="dateToShow" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
        </a>
        <div id="dateToCalContainer" class="yui-cal"></div>
      </div>
    </div>
    <div class="form-button">
      <input type="submit" value="<g:message code="action.search" />"/>
    </div>
  </form>
</div>
