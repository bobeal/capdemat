<html>
  <head>
    <title><g:message code="category.header.list" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" >
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'categoryList.js')}"></script>
  </head>
  
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <div class="txt-right">
            ${message(code:'category.header.list')}
            | <a href="${createLink(controller:'backofficeAgent', action:'list')}">${message(code:'agent.header.list')}</a>
          </div>
          <h1><g:message code="category.header.list" /></h1>
        </div>
      
        <div class="createConfigurationItem">
          <a href="${createLink(action:'create')}"><g:message code="action.create"/></a>
        </div>
          
        <g:if test="${categories.size == 0}">
          <g:message code="category.message.noCategoryDefined" />
        </g:if>
        <g:else>
          <ul class="overviewConfigurationList" id="categoriesList">
            <g:each in="${categories}" var="category">
            <li id="category-${category.id}">
              <input type="hidden" id="categoryMessage_${category.id}"
                value="${message(code:'category.message.askConfirmDelete',args:[category.name])}" />
              <h3>
                <a href="${createLink(action:'edit',id:category.id)}">${category.name}</a>
                <span>- ${category.primaryEmail}</span>
                <span>
                  <img id="deleteEntry_${category.id}"
                    src="${resource(dir:'images/icons',file:'16-delete.png')}"
                    alt="<g:message code="request.action.removeCategory" />">
                </span>
              </h3>
              <div>
                <g:each in="${requestTypesByCategory[category.id]}" var="requestType">
                  <g:if test="${requestType.active}">
                    ${requestType.label}
                  </g:if>
                  <g:else>
                    <span class="disabled">
                      ${requestType.label}
                    </span>
                  </g:else>
                  - 
                </g:each>
              </div>
            </li>
            </g:each>
          </ul>
        </g:else>
      </div>
    </div>

    <div id="narrow" class="yui-b">   
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
      <div class="nobox">
        <h3><g:message code="category.header.overview" /></h3>
        <div class="body">
          <p>
            Cette page présente les catégories actuellement définies et les téléservices 
            qui leur sont rattachés.
          </p>
          <p>
            Les téléservices marqués en <span style="color:red;">rouge</span> sont inactifs.
          </p>
          <p>
            En cliquant sur une catégorie, vous pouvez voir et modifier le détail de sa
            configuration.
          </p>
       </div>
      </div>
      <g:if test="${orphanRequestTypes.size > 0}">
        <div class="nobox yellow">
          <h3><g:message code="category.header.orphanRequestTypes" /></h3>
          <div class="body">
            <ul>
            <g:each in="${orphanRequestTypes}">
              <li>
              <g:if test="${it.active}">${it.label}</g:if>
              <g:else><span class="disabled">${it.label}</span></g:else>
              </li>
            </g:each>
            </ul>
          </div>
        </div>
      </g:if>
    </div>

  </body>
</html>


