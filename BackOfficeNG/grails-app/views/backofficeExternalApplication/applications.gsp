<html>
  <head>
    <title><g:message code="external.header.applications" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" >
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'externalApplications.js')}"></script>
  </head>
  
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="external.header.applicationsList" /></h1>
        </div>

        <div id="applicationMsg" class="invisible"></div>
        <div class="createConfigurationItem">
          <a href="${createLink(action:'createApplication')}"><g:message code="action.create"/></a>
        </div>

        <g:if test="${applications.size == 0}">
          <g:message code="external.message.applications.noApplicationsDefined" />
        </g:if>
        <g:else>

          <ul class="overviewConfigurationList" id="applications">
            <g:each in="${applications}" var="application">
            <li id="application-${application.id}">
              <h3>
                <a href="${createLink(action:'editApplication',id:application.id)}">${application.label}</a>
                <span>
                  <img id="confirmDelete_${application.id}"
                    src="${resource(dir:'images/icons',file:'16-delete.png')}"
                    alt="${message(code:'external.message.applications.confirmDelete',args:[application?.label])}" />
                </span>
              </h3>
              <div>
                  ${application.description}
              </div>
            </li>
            </g:each>
          </ul>
        </g:else>
      </div>
    </div>

    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
    </div>

  </body>
</html>