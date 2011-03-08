<html>
  <head>
    <title><g:message code="request.header.search" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${resource(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'requestSearch.js')}"></script>
  </head>
  <body>

    <div id="yui-main">
      <div class="yui-b">
      
        <div id="head" class="head">
          <g:render template="advancedSearchForm" />          
        </div>

        <div class="search-results">
          <g:render template="searchResults" />
        </div>
        
      </div>
    </div>

    <!-- filters and sorters -->
    <div id="narrow" class="yui-b">
      <menu:subMenu i18nPrefix="header" data="${subMenuEntries}" />
      <div class="nobox">
        <h3><g:message code="header.sortBy" /></h3>
        <div class="body">
          <form action="#" id="requestSearchSorters">
            <ul>
              <li>
                <label for="creationDate"><g:message code="property.creationDate" /></label>
                <input type="radio" name="requestSorter" id="creationDate" ${sortBy == 'creationDate' ? 'checked="checked"' : ''} />
              </li>
              <li>
                <label for="requesterLastName"><g:message code="property.requester" /></label>
                <input type="radio" name="requestSorter" id="requesterLastName" ${sortBy == 'requesterLastName' ? 'checked="checked"' : ''} />
              </li>
              <li>
                <label for="subjectLastName"><g:message code="request.property.subject" /></label>
                <input type="radio" name="requestSorter" id="subjectLastName" ${sortBy == 'subjectLastName' ? 'checked="checked"' : ''} />
              </li>
              <li>
                <label for="requestId"><g:message code="property.requestId" /></label>
                <input type="radio" name="requestSorter" id="requestId" ${sortBy == 'requestId' ? 'checked="checked"' : ''} />
              </li>
              <li>
                <label for="homeFolderId"><g:message code="property.homeFolderId" /></label>
                <input type="radio" name="requestSorter" id="homeFolderId" ${sortBy == 'homeFolderId' ? 'checked="checked"' : ''} />
              </li>
            </ul>
          </form>
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#" id="requestSearchFilters">
            <label for="categoryIdFilter"><g:message code="property.category" /> :</label>
            <select id="categoryIdFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allCategories}" var="category">
                <option value="${category.id}" ${filters['categoryIdFilter'] == category.id.toString() ? 'selected' : ''}>
                  ${category.name}
                </option>
              </g:each>
            </select>
            
            <label for="requestTypeIdFilter"><g:message code="property.requestType" /> :</label>
            <select id="requestTypeIdFilter"> 
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allRequestTypes}" var="requestType">
                <option value="${requestType.id}" ${filters['requestTypeIdFilter'] == requestType.id.toString() ? 'selected' : ''}>
                  ${requestType.label}
                </option>
              </g:each>
            </select>
            
            <label for="stateFilter"><g:message code="property.state" /> :</label>
            <select id="stateFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allStates}" var="state">
                <option value="${state}" ${filters['stateFilter'] == state.toString() ? 'selected' : ''}>
                  <g:message code="request.state.${state.toString().toLowerCase()}" />
                </option>
              </g:each>
            </select>
            
            <label for="lastInterveningUserIdFilter"><g:message code="request.property.lastInterveningUser" /> :</label>
            <select id="lastInterveningUserIdFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allAgents}" var="agent">
                <option value="${agent.id}" ${filters['lastInterveningUserIdFilter'] == agent.id.toString() ? 'selected' : ''}>
                  ${agent.getLastName() != null ? agent.getLastName() + " " + agent.getFirstName() : agent.getLogin()}
                </option>
              </g:each>
            </select>

            <label for="qualityFilter"><g:message code="request.property.quality" /> :</label>
            <select id="qualityFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <option value="Red" ${filters['qualityFilter'] == 'Red' ? 'selected' : ''}>
                <g:message code="request.property.redAlert"/>
              </option>
              <option value="Orange" ${filters['qualityFilter'] == 'Orange' ? 'selected' : ''}>
                <g:message code="request.property.orangeAlert"/>
              </option>
            </select>
            
          </form>
        </div>
      </div>
      
    </div>
  
  </body>
</html>
