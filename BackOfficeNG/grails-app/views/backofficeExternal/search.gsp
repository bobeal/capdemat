<html>
  <head>
    <title><g:message code="requestExternalAction.header.search" /></title>
    <meta name="layout" content="main" />
    <!-- link rel="stylesheet" href="${resource(dir : 'css/backoffice', file : 'externalSearch.css')}" / -->
    <script type="text/javascript" src="${resource(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'externalSearch.js')}"></script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div id="head" class="head">
          <g:render template="searchForm" />
        </div>
        <div class="search-results">
          <g:render template="searchResults" />
        </div>
      </div>
    </div>
    <!-- filters and sorters -->
    <div id="narrow" class="yui-b">
      <div class="nobox">
        <h3><g:message code="header.sortBy" /></h3>
        <div class="body">
          <form action="#" id="searchSorters">
            <ul>
              <li>
                <label for="dateSort"><g:message code="requestExternalAction.property.date" /></label>
                <input type="radio" name="date" id="dateSort" ${sortBy == 'date' ? 'checked="checked"' : ''} />
              </li>
              <li>
                <label for="keySort"><g:message code="requestExternalAction.property.key" /></label>
                <input type="radio" name="key" id="keySort" ${sortBy == 'key' ? 'checked="checked"' : ''} />
              </li>
              <li>
                <label for="nameSort"><g:message code="requestExternalAction.property.name" /></label>
                <input type="radio" name="name" id="nameSort" ${sortBy == 'name' ? 'checked="checked"' : ''} />
              </li>
              <li>
                <label for="statusSort"><g:message code="requestExternalAction.property.status" /></label>
                <input type="radio" name="status" id="statusSort" ${sortBy == 'status' ? 'checked="checked"' : ''} />
              </li>
            </ul>
          </form>
        </div>
      </div>
      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#" id="searchFilters">
            <label for="externalServiceLabelFilter"><g:message code="requestExternalAction.property.name" /> :</label>
            <select id="externalServiceLabelFilter" name="externalServiceLabelFilter">
              <option value=""><g:message code="search.filter.defaultValue" /></option>
              <g:each in="${externalServiceLabels}">
                <option value="${it}"
                  <g:if test="${filters['externalServiceLabelFilter'].equals(it)}">selected="selected"</g:if>>
                  ${it}
                </option>
              </g:each>
            </select>
            <label for="statusFilter"><g:message code="requestExternalAction.property.status" /> :</label>
            <select id="statusFilter" name="statusFilter">
              <option value=""><g:message code="search.filter.defaultValue" /></option>
              <g:each in="${requestExternalActionStatuses}">
                <option value="${it}"
                  <g:if test="${filters['statusFilter'].equals(it.toString())}">selected="selected"</g:if>>
                  <g:capdematEnumToText var="${it}" i18nKeyPrefix="externalservice.trace.status" />
                </option>
              </g:each>
            </select>
            <label for="requestTypeFilter"><g:message code="property.requestType" /> :</label>
            <select id="requestTypeFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${requestTypes}" var="requestType">
                <option value="${requestType.id}" ${filters['requestTypeFilter'] == requestType.id.toString() ? 'selected' : ''}>
                  ${requestType.label}
                </option>
              </g:each>
            </select>
            <label for="requestStateFilter"><g:message code="property.state" /> :</label>
            <select id="requestStateFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${requestStates}" var="state">
                <option value="${state}" ${filters['requestStateFilter'] == state.toString() ? 'selected' : ''}>
                  <g:message code="request.state.${state.toString().toLowerCase()}" />
                </option>
              </g:each>
            </select>
          </form>
        </div>
      </div>
      <g:if test="${inSearch && totalRecords > 0 && session.isACategoryManager}">
        <div class="nobox yellow">
          <h3><g:message code="requestExternalAction.header.externalServices" /></h3>
          <div id="resendContainer" class="body">
            <div id="sendRequestsFormErrors"></div>
            <form action="sendRequests" method="post" id="sendRequestsForm">
              <g:each var="key" in="${keys}">
                <input type="hidden" name="ids" value="${key}" />
              </g:each>
              <g:if test="${!session.currentCredentialBean.agent.email}">
                <label for="notificationEmail"><g:message code="externalService.batchRequestResend.notifiedEmail" /></label>
                <input type="text" id="notificationEmail" name="email" class="validate required"
                  title="<g:message code="externalService.batchRequestResend.error.email.required" />" />
                <span class="help"><g:message code="externalService.batchRequestResend.notifiedEmail.help" /></span>
              </g:if>
              <input type="submit" id="resendButton"
                value="<g:message code="requestExternalAction.action.resend" />"/>
            </form>
          </div>
        </div>
      </g:if>
    </div>
  </body>
</html>
