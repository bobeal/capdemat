<html>
  <head>
    <title><g:message code="payment.header.simpleSearch" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'payment.js')}"></script>
  </head>
  <body>
    
    <div id="yui-main">
      <div class="yui-b">
      
        <div id="head" class="head">
          <g:if test="${mode == 'simple'}">
            <g:render template="simpleSearchForm" />
          </g:if>
          <g:else>
            <g:render template="advancedSearchForm" />
          </g:else>
        </div>

        <div id="search-results">
          <g:render template="searchResults" />
        </div>
        
      </div>
    </div>

    <!-- filters and sorters -->
    <div id="narrow" class="yui-b">
    
      <div class="nobox">
        <h3><g:message code="header.switchTo" /></h3>
        <div class="body">
          <g:link action="configure">${message(code:'payment.header.configure')}</g:link>
        </div>
      </div>
      
      <div class="nobox">
        <h3><g:message code="header.sortBy" /></h3>
        <div class="body">
          <form action="#" id="paymentSearchSorters">
            <ul>
              <li>
                <label><g:message code="property.userLastName" /></label>
                <input type="radio" id="requesterLastName" ${sortBy == 'requesterLastName' ? 'checked' : ''} />
              </li>
              <li>
                <label><g:message code="property.homeFolderId" /></label>
                <input type="radio" id="homeFolderId" ${sortBy == 'homeFolderId' ? 'checked' : ''} />
              </li>
              <li>
                <label><g:message code="payment.property.initializationDate" /></label>
                <input type="radio" id="initializationDate" ${sortBy == 'initializationDate' ? 'checked' : ''} />
              </li>
            </ul>
          </form>
        </div>
      </div>
      
      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#" id="paymentSearchFilters">

            <label for="paymentStateFilter"><g:message code="payment.property.paymentState" /> :</label>
            <select name="paymentStateFilter" id="paymentStateFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allStates}" var="paymentState">
                <option value="${paymentState}" ${filters['paymentStateFilter'] == paymentState.toString() ? 'selected' : ''}>
                  <g:message code="payment.state.${paymentState.toString().toLowerCase()}" />
                </option>
              </g:each>
            </select>

            <label for="brokerFilter"><g:message code="payment.property.broker" /> :</label>
            <select name="brokerFilter" id="brokerFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allBrokers}" var="broker">
                <option value="${broker.key}" ${filters['brokerFilter'] == broker.key ? 'selected' : ''}>
                  ${broker.key}
                </option>
              </g:each>
            </select>

            <label for="paymentModeFilter"><g:message code="payment.property.paymentMode" /> :</label>
            <select name="paymentModeFilter" id="paymentModeFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allModes}" var="paymentMode">
                <option value="${paymentMode}" ${filters['paymentModeFilter'] == paymentMode.toString() ? 'selected' : ''}>
                  <g:message code="payment.mode.${paymentMode.toString().toLowerCase()}" />
                </option>
              </g:each>
            </select>

          </form>
        </div>
      </div>
      
    </div>    
  </body>
</html>

