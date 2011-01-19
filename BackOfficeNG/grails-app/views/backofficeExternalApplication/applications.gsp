<html>
  <head>
    <title>${message(code:'external.header.applications')} /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" >
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'externalApplications.js')}"></script>
  </head>
  
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>${message(code:'external.header.applicationsList')}</h1>
        </div>

        <div id="applicationMsg" class="invisible"></div>
        <div class="createConfigurationItem">
          <a href="${createLink(action:'createApplication')}"><g:message code="action.create"/></a>
        </div>

        <g:if test="${applications.size == 0}">
          ${message(code:'external.message.applications.noApplicationsDefined')}
        </g:if>
        <g:else>

          <ul class="overviewConfigurationList" id="applications">
            <g:each in="${applications}" var="record">
            <li id="application-${record.application.id}">
              <h3>
                <a href="${createLink(action:'editApplication',id:record.application.id)}">${record.application.label}</a>
                <span>(${record.application.description})</span>
                <span>
                  <img id="confirmDelete_${record.application.id}"
                    src="${resource(dir:'images/icons',file:'16-delete.png')}"
                    alt="${message(code:'external.message.applications.confirmDelete',args:[record.application?.label])}" />
                </span>
              </h3>
              <div>
              ${message(code:'external.property.application.supportedBrokers')} : 
              <g:each in="${record.application.brokers}" var="broker">
                ${broker} 
              </g:each>
              </div>
              <div class="yui-g">
                <div class="data yui-u first">
                    <h4>${message(code:'external.header.account')} (${record.application.externalHomeFolders.size()})</h4>
                    <p>${message(code:'external.property.application.externalAccount.free')} : ${record.freeAccount}</p>
                    <p>${message(code:'external.property.application.externalAccount.binded')} : ${record.bindedAccount}</p>
                    <p>${message(code:'external.property.application.externalAccount.ignored')} : ${record.ignoredAccount}</p>
                </div>
                <div class="data yui-u">
                    <h4>${message(code:'external.property.application.externalAccountItems')}</h4>
                    <p>${message(code:'external.property.application.externalInvoices')} : ${record.invoices}</p>
                    <p>${message(code:'external.property.application.externalDepositAccounts')} : ${record.deposits}</p>
                    <p>${message(code:'external.property.application.externalTicketingContracts')} : ${record.contracts}</p>
                </div>
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