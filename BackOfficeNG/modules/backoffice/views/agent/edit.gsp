<%@ taglib prefix="g" uri="/web-app/WEB-INF/tld/grails.tld" %>
<html>
  <head>
  <title>
    <g:message code="agent.header.configuration" args="${[agent.lastName, agent.firstName]}" />           
  </title>
  <meta name="layout" content="main" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" >
  <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'agentEdit.js')}"></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'agentCategories.js')}"></script>
  <script type="text/javascript">
    zenexity.capdemat.bong.agentId = '${agent?.id}';
  </script>
  </head>
  
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>
            <g:message code="agent.header.configuration" args="${[agent.lastName, agent.firstName]}" />
          </h1>
        </div>
      
        <div class="mainbox mainbox-yellow">
          <h2><g:message code="agent.header.agent" /></h2>
          <dl id="agent" class="tableDisplay">
            <dt><g:message code="agent.property.lastName" /> : </dt>
            <dd>${agent.lastName}</dd>
            
            <dt><g:message code="agent.property.firstName" /> : </dt>
            <dd>${agent.firstName}</dd>
            
            <dt><g:message code="agent.property.login" /> : </dt>
            <dd>${agent.login}</dd>

            <dt><g:message code="agent.property.sitesRoles" /> : </dt>
            <dd>
							<g:each in="${agent.sitesRoles}" var="siteRoles">
                <g:message code="agent.siteProfile.${siteRoles.profile.toString().toLowerCase()}" /> <br />
              </g:each>
						</dd>
          </dl>
        </div>
        
        <div id="agentCategoriesBox" class="mainbox mainbox-yellow">
          <h2><g:message code="agent.header.categories" /></h2>
          <div class="editableListSwithcher">
            <form id="sortCategoryForm" method="post" action="<g:createLink action="categories" />" />
              <input type="hidden" name="id" value="${agent?.id}" />

              <a id="viewAgentCategoriesLink" class="current"
                onclick="zenexity.capdemat.bong.agentCategory.viewCategories('Agent');">
                <g:message code="filter.viewBounded" />
              </a> / 
              <a id="viewAllCategoriesLink" 
                onclick="zenexity.capdemat.bong.agentCategory.viewCategories('All');">
                <g:message code="filter.viewAll" />
              </a>
            </form>
          </div>
          <ul id="agentCategories" class="editableList">
          </ul>
        </div>
      </div>
    </div>  
    
    
    <div id="narrow" class="yui-b">
      <div class="nobox">
        <h3><g:message code="agent.header.switchAgent" /></h3>
        <div class="body">
          <g:if test="${agents.size == 0}">
            <g:message code="agent.message.noAgentDefined" />
          </g:if>
          <g:if test="${agents.size > 0}">
            <form action="<g:createLink action="edit" />">
              <select name="agentId" id="agentId" onchange="submit();">
                <option value=""></option>
                <g:each in="${agents}" var="agent">
                  <option value="${agent.id}" ${agent.id == Long.valueOf(params.id) ? 'selected' : ''}>
                    ${agent.lastName} ${agent.firstName}
                  </option>>
                </g:each>
              </select>
            </form>
          </g:if>
        </div>
      </div>
    </div>

  </body>
</html>
