<html>
  <head>
    <title><g:message code="agent.header.list" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" >
  </head>
  
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <div class="txt-right">
            <a href="${createLink(controller:'backofficeCategory', action:'list')}">${message(code:'category.header.list')}</a>
            | ${message(code:'agent.header.list')}
          </div>
          <h1><g:message code="agent.header.list" /></h1>
        </div>
          
        <g:if test="${agents.size == 0}">
          <g:message code="agent.message.noAgentDefined" />
        </g:if>
        <g:else>
          <ul class="overviewConfigurationList" id="agentsList">
            <g:each in="${agents}" var="agent">
            <li id="agent-${agent.id}">
              <h3>
                <a href="${createLink(action:'edit',id:agent.id)}">
                  <g:if test="${agent.lastName || agent.firstName}">
                    ${agent.lastName} ${agent.firstName}
                  </g:if>
                  <g:else>
                    ${agent.login}
                  </g:else>
                </a>
                <span>- ${agent.login}</span>
				<span>- 
				    <g:each in="${agent.sitesRoles}" var="siteRoles">
                        <g:message code="agent.siteProfile.${siteRoles.profile.toString().toLowerCase()}" />
                    </g:each>
				<span>
              </h3>
            </li>
            </g:each>
          </ul>
        </g:else>
      </div>
    </div>

    <div id="narrow" class="yui-b">   
      <div class="nobox">
        <h3><g:message code="agent.header.overview" /></h3>
        <div class="body">
          <p>
            Cette page présente les utilisateurs actuellement définis et les catégories 
            qui leur sont rattachées.
          </p>
          <p>
            En cliquant sur un utilisateur, vous pouvez voir et modifier le détail de sa
            configuration.
          </p>
       </div>
      </div>
%{--      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />--}%
    </div>

  </body>
</html>


