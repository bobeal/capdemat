<html>
  <head>
    <title><g:message code="request.header.simpleSearch" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'request.js')}"></script>
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
        <h3><g:message code="header.sortBy" /></h3>
        <div class="body">
          <form action="#">
            <ul>
              <li>
                <label><g:message code="property.date" /></label>
                <input type="radio" id="creationDate" 
                  onchange="YAHOO.capdematBo.request.search.sortSearchRequest('creationDate');"
                  ${sortBy == 'creationDate' ? 'checked' : ''} />
              </li>
              <li>
                <label><g:message code="property.requester" /></label>
                <input type="radio" id="requesterLastName" 
                  onchange="YAHOO.capdematBo.request.search.sortSearchRequest('requesterLastName');"
                  ${sortBy == 'requesterLastName' ? 'checked' : ''} />
              </li>
              <li>
                <label><g:message code="property.homeFolder" /></label>
                <input type="radio" id="homeFolderId" 
                onchange="YAHOO.capdematBo.request.search.sortSearchRequest('homeFolderId');" 
                  ${sortBy == 'homeFolderId' ? 'checked' : ''} />
              </li>
            </ul>
          </form>
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#">
            <label for="categoryIdFilter"><g:message code="property.category" /> :</label>
            <select id="categoryIdFilter" 
              onchange="YAHOO.capdematBo.request.search.filterSearchRequest('categoryIdFilter');">
              <option value=""></option>
              <g:each in="${allCategories}" var="category">
                <option value="${category.id}" ${filters['categoryIdFilter'] == category.id.toString() ? 'selected' : ''}>
                  ${category.name}
                </option>
              </g:each>
            </select>
            
            <label for="requestTypeFilter"><g:message code="property.requestType" /> :</label>
            <select id="requestTypeFilter" 
              onchange="YAHOO.capdematBo.request.search.filterSearchRequest('requestTypeFilter');">
              <option value=""></option>
              <g:each in="${allRequestTypes}" var="requestType">
                <option value="${requestType.id}" ${filters['requestTypeFilter'] == requestType.id.toString() ? 'selected' : ''}>
                  ${requestType.label}
                </option>
              </g:each>
            </select>

            <label for="stateFilter"><g:message code="property.state" /> :</label>
            <select id="stateFilter"
              onchange="YAHOO.capdematBo.request.search.filterSearchRequest('stateFilter');">
              <option value=""></option>
              <g:each in="${allStates}" var="state">
                <option value="${state}" ${filters['stateFilter'] == state.toString() ? 'selected' : ''}>
                  ${state}
                </option>
              </g:each>
            </select>
        
            <label for="lastInterveningAgentIdFilter"><g:message code="request.property.lastInterveningAgent" /> :</label>
            <select id="lastInterveningAgentIdFilter"
              onchange="YAHOO.capdematBo.request.search.filterSearchRequest('lastInterveningAgentIdFilter');">
              <option value=""></option>
              <g:each in="${allAgents}" var="agent">
                <option value="${agent.id}"
                    ${filters['lastInterveningAgentIdFilter'] == agent.id.toString() ? 'selected' : ''}>
                  ${agent.getLastName() != null ? agent.getLastName() + " " + agent.getFirstName() : agent.getLogin()}
                </option>
              </g:each>
            </select>

          </form>
        </div>
      </div>
      
    </div>
  
  </body>
</html>

