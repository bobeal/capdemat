<%@ taglib prefix="g" uri="/web-app/WEB-INF/tld/grails.tld" %>
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
  <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'configuration.css')}" >
  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'categoryEdit.js')}"></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'categoryRequests.js')}"></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'categoryAgents.js')}"></script>
  <script type="text/javascript">
    YAHOO.capdematBo.categoryId = '${category?.id}';
    YAHOO.capdematBo.editMode = '${editMode}';
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
          <h2><g:message code="menu.requests" /></h2>
          <div class="editableListSwithcher">
            <form id="sortRequestTypeForm" method="post" action="<g:createLink action="requestTypes" />" />
              <select name="orderRequestTypeBy" onchange="sortRequestTypes();">
                <option value="">sort by</option>
                <option value="label">by label</option>
                <option value="categoryName">by category</option>
              </select>
              <input type="hidden" name="id" value="${category?.id}" />

              <a id="viewCategoryRequestTypesLink" class="current" onclick="viewRequestTypes('Category');">view actived</a> / 
              <a id="viewAllRequestTypesLink" onclick="viewRequestTypes('All');">view all</a>
            </form>
          </div>
          <ul id="categoryRequestTypes" class="editableList">
          </ul>
        </div>
        
        <div id="categoryAgentsBox" class="mainbox mainbox-yellow">
          <h2><g:message code="category.header.agents" /></h2>
          <div class="editableListSwithcher">
            <form id="sortAgentForm" method="post" action="<g:createLink action="agents" />" />
              <select name="orderAgentBy" onchange="sortAgents();">
                <option value="">sort by</option>
                <option value="lastName">by Name</option>
              </select>
              <input type="hidden" name="id" value="${category?.id}" />

              <a id="viewCategoryAgentsLink" class="current" onclick="viewAgents('Category');">view actived</a> / 
              <a id="viewAllAgentsLink" onclick="viewAgents('All');">view all</a>
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
              <select name="categoryId" id="categoryId" style="width: 100%;"
                onchange="submit();">
                <option value=""></option>
                <g:each in="${categories}" var="category">
                  <option value="${category.id}">${category.name}</option>
                </g:each>
              </select>
            </form>
          </g:if>
        </div>
      </div>
    </div>
    
  </body>
</html>


