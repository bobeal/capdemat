<html>
  <head>
    <title><g:message code="externalServiceTrace.header.search" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir : 'css/backoffice', file : 'externalSearch.css')}" />
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
                <label for="dateSort"><g:message code="externalServiceTrace.property.date" /></label>
                <input type="radio" name="date" id="dateSort" ${sortBy == 'date' ? 'checked="checked"' : ''} />
              </li>
              <li>
                <label for="keySort"><g:message code="externalServiceTrace.property.key" /></label>
                <input type="radio" name="key" id="keySort" ${sortBy == 'key' ? 'checked="checked"' : ''} />
              </li>
              <li>
                <label for="nameSort"><g:message code="externalServiceTrace.property.name" /></label>
                <input type="radio" name="name" id="nameSort" ${sortBy == 'name' ? 'checked="checked"' : ''} />
              </li>
              <li>
                <label for="statusSort"><g:message code="externalServiceTrace.property.status" /></label>
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
            <label for="externalServiceLabelFilter"><g:message code="externalServiceTrace.property.name" /> :</label>
            <select id="externalServiceLabelFilter" name="externalServiceLabelFilter">
              <option value=""><g:message code="search.filter.defaultValue" /></option>
              <g:each in="${externalServiceLabels}">
                <option value="${it}"
                  <g:if test="${filters['externalServiceLabelFilter'].equals(it)}">selected="selected"</g:if>>
                  ${it}
                </option>
              </g:each>
            </select>
            <label for="statusFilter"><g:message code="externalServiceTrace.property.status" /> :</label>
            <select id="statusFilter" name="statusFilter">
              <option value=""><g:message code="search.filter.defaultValue" /></option>
              <g:each in="${traceStatuses}">
                <option value="${it}"
                  <g:if test="${filters['statusFilter'].equals(it.toString())}">selected="selected"</g:if>>
                  <g:capdematEnumToText var="${it}" i18nKeyPrefix="externalservice.trace.status" />
                </option>
              </g:each>
            </select>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
