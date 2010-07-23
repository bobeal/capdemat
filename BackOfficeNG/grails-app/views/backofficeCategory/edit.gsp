<html>
  <head>
  <title>
    <g:if test="${editMode == 'edit'}">
      <g:message code="category.header.configuration" args="${[category?.name]}" />
    </g:if>
    <g:else>
      <g:message code="category.header.creation" />
    </g:else>            
  </title>
  <meta name="layout" content="main" />
  <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" >
  <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'categoryEdit.js')}"></script>
  <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'categoryRequests.js')}"></script>
  <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'categoryAgents.js')}"></script>
  <script type="text/javascript">
    zenexity.capdemat.bong.categoryId = '${category?.id}';
    zenexity.capdemat.bong.editMode = '${editMode}';
  </script>
  </head>
  
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>
            <g:if test="${editMode == 'edit'}">
              <g:message code="category.header.configuration" args="${[category?.name]}" />
            </g:if>
            <g:else>
              <g:message code="category.header.creation" />
            </g:else>
          </h1>
        </div>
      
        <div class="mainbox mainbox-yellow">
          <div id="categoryData"></div>
        </div>

        <div id="categoryRequestTypesBox" class="mainbox mainbox-yellow">
          <h2><g:message code="category.header.requests" /></h2>
          <div class="editableListSwithcher">
            <form id="sortRequestTypeForm" method="post" action="${createLink(action:'requestTypes')}" />
              <select name="orderRequestTypeBy">
                <option class="sortRequestTypes" value="label" ${orderRequestTypeBy == 'label' ? 'selected' : ''}>
                  <g:message code="category.filter.byLabel" />
                </option>
                <option class="sortRequestTypes" value="categoryName" ${orderRequestTypeBy == 'categoryName' ? 'selected' : ''}>
                  <g:message code="category.filter.byCategory" />
                </option>
              </select>
              <input type="hidden" name="id" value="${category?.id}" />
              <input type="hidden" name="scope" id="scope" value="${scope}" />

              <a id="viewRequestTypes_Category" class="viewRequestTypes current">
                <g:message code="filter.viewBounded" />
              </a> / 
              <a id="viewRequestTypes_All" class="viewRequestTypes">
                <g:message code="filter.viewAll" />
              </a>
            </form>
          </div>
          <ul id="categoryRequestTypes" class="editableList">
          </ul>
        </div>
        
        <div id="categoryAgentsBox" class="mainbox mainbox-yellow">
          <h2><g:message code="category.header.users" /></h2>
          <div class="editableListSwithcher">
            <form id="sortAgentsForm" method="post" action="<g:createLink action="users" />" />
              <input type="hidden" name="id" value="${category?.id}" />

              <a id="viewAgents_Category" class="viewAgents current">
                <g:message code="filter.viewBounded" />
              </a> / 
              <a id="viewAgents_All" class="viewAgents">
                <g:message code="filter.viewAll" />
              </a>
            </form>
          </div>
          <ul id="categoryAgents" class="editableList">
          </ul>
        </div>
      
      </div>
    </div>
    
    <div id="narrow" class="yui-b">
      <div class="nobox">
        <h3><g:message code="category.header.switchCategory" /></h3>
        <div class="body">
          <g:if test="${categories.size == 0}">
            <g:message code="category.message.noCategoryDefined" />
          </g:if>
          <g:if test="${categories.size > 0}">
            <form action="<g:createLink action="edit" />">
              <select name="categoryId" id="categoryId">
                <g:each in="${categories}">
                  <option value="${it.id}" ${it.id == category?.id ? 'selected' : ''}>${it.name}</option>
                </g:each>
              </select>
            </form>
          </g:if>
        </div>
      </div>
    </div>
    
  </body>
</html>


