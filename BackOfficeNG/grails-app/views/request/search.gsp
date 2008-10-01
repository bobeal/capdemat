<html>
  <head>
    <title><g:message code="request.header.simpleSearch" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'request.js')}"></script>
  </head>
  <body>

    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
        <g:if test="${mode == 'simple'}">
           <div class="txt-right">
            <g:message code="action.goToSimpleSearch" /> |
            <a href="${createLink(action:'search')}?mode=advanced"><g:message code="action.goToAdvancedSearch" /></a>
          </div>
          <div id="search-form">
            <g:render template="simpleSearchForm" />
          </div>
        </g:if>
        <g:else>
          <div class="txt-right">
            <a href="${createLink(action:'search')}?mode=simple"><g:message code="action.goToSimpleSearch" /></a> |
            <g:message code="action.goToAdvancedSearch" />
          </div>
          <div id="search-form">
            <g:render template="advancedSearchForm" />
          </div>
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
            <label for="categoryId"><g:message code="property.category" /> :</label>
            <select name="categoryIdFilter" id="categoryIdFilter" 
              onchange="YAHOO.capdematBo.request.search.filterSearchRequest('categoryIdFilter');">
              <option value=""></option>
              <g:each in="${allCategories}" var="category">
                <option value="${category.id}" ${filters['categoryIdFilter'] == category.id.toString() ? 'selected' : ''}>
                  ${category.name}
                </option>
              </g:each>
            </select>
            
            <label for="requestType"><g:message code="property.requestType" /> :</label>
            <select name="requestTypeFilter" id="requestTypeFilter" 
              onchange="YAHOO.capdematBo.request.search.filterSearchRequest('requestTypeFilter');" style="width:100%;">
              <option value=""></option>
              <g:each in="${allRequestTypes}" var="requestType">
                <option value="${requestType.id}" ${filters['requestTypeFilter'] == requestType.id.toString() ? 'selected' : ''}>
                  ${requestType.label}
                </option>
              </g:each>
            </select>
          </form>
        </div>
      </div>
      
    </div>
  
  </body>
</html>

