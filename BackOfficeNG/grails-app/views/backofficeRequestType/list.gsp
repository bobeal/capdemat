<html>
  <head>
    <title><g:message code="requestType.header.list" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" ></link>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'requestTypeList.js')}"></script>
  </head>
  
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="requestType.header.list" /></h1>
        </div>
        
        <ul class="overviewConfigurationList">
        <g:each in="${requestTypes}" var="requestType">
          <li>
            <g:if test="${requestType.active}">
              <span  class="tag-enable"><g:message code="property.active" /></span>
            </g:if>
            <g:else>
              <span class="tag-disable"><g:message code="property.inactive" /></span>
            </g:else>
            <h3>
              <a href="${createLink(action : 'forms', id : requestType.id)}">
              ${requestType.label}
              </a>
              <span>
                <g:if test="${requestType.categoryName}">
                  - <g:message code="property.category" /> : ${requestType.categoryName}
                </g:if>
                <g:else>
                  - <g:message code="requestType.message.noCategoryAssociated" /> 
                </g:else>
              </span>
            </h3>
          </li>
         </g:each>
         </ul>
      </div>
    </div>

    <!-- filters -->
    <div id="narrow" class="yui-b">
      <menu:subMenu i18nPrefix="header" data="${subMenuEntries}" />
      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form method="post" id="requestTypeListFilters" action="${createLink(action:'list')}">
            <input type="hidden" id="filterBy" name="filterBy" value="${filterBy}" />
            <label for="categoryIdFilter"><g:message code="property.category" /> :</label>
            <select id="categoryIdFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allCategories}" var="category">
                <option value="${category.id}" ${filters['categoryIdFilter'] == category.id.toString() ? 'selected' : ''}>
                  ${category.name}
                </option>
              </g:each>
            </select>
            <label for="stateFilter"><g:message code="property.state" /> :</label>
            <select id="stateFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <option value="true" ${filters['stateFilter'] == 'true' ? 'selected' : ''}>
                <g:message code="property.active" />
              </option>
              <option value="false" ${filters['stateFilter'] == 'false' ? 'selected' : ''}>
                <g:message code="property.inactive" />
              </option>
            </select>
          </form>
        </div>
      </div> 
    </div>
    
  </body>
</html>

