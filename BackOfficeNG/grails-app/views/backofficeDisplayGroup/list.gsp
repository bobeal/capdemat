<html>
  <head>
    <title>${message(code:'displayGroup.header.list')}</title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'displayGroupList.js')}"></script>
  </head>

  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>${message(code:'displayGroup.header.list')}</h1>
        </div>
        
        <div id="displayGroupMsg" class="invisible"></div>
        <p class="createConfigurationItem">
          <a href="${createLink(action:'create')}">${message(code:'action.create')}</a>
        </p>
        <g:if test="${displayGroups.size == 0}">
          ${message(code:'displayGroup.message.noDisplayGroup')}
        </g:if>
        <g:else>
          <ul id="displayGroups" class="overviewConfigurationList">
            <g:each in="${displayGroups}" var="displayGroup">
            <li>
              <h3>
                <a href="${createLink(action:'edit',id:displayGroup.id)}">${displayGroup.label}</a>
                <img id="confirmDelete_${displayGroup.id}" 
                     src="${resource(dir:'images/icons',file:'16-delete.png')}"
                     alt="${message(code:'displayGroup.message.confirmDelete',args:[displayGroup?.label])}" />
              </h3>
              <div>
                <g:each in="${requestTypesByDisplayGroup[displayGroup.id]}" var="requestType">
                  <g:if test="${requestType.active}">
                    ${requestType.label}
                  </g:if>
                  <g:else>
                    <span class="disabled">${requestType.label}</span>
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

