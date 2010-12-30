<html>
  <head>
    <title>
        ${message(code:'external.header.' + (editMode == 'edit' ? 'applicationGeneralData' : 'applicationCreation'))}
    </title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" >
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'externalApplicationEdit.js')}"></script>
    <script type="text/javascript">
        zenexity.capdemat.bong.externalApplicationEdit.editMode = '${editMode}';
        zenexity.capdemat.bong.externalApplicationEdit.appId = '${app?.id}';
    </script>
  </head>

  <body>
    <div id="yui-main">
      <div class="yui-b">

        <div class="head">
          <h1>${message(code:'external.header.applicationConfiguration')}</h1>
        </div>

        <div id="applicationGroupData" class="mainbox mainbox-yellow">
            <h2>${message(code:'external.header.' + (editMode == 'edit' ? 'applicationGeneralData' : 'applicationCreation'))}</h2>
            <div id="applicationMsg" class="invisible"></div>
            <form method="post" id="applicationForm" action="${createLink(action:'saveApplication')}">
              <div class="error" id="applicationFormErrors"></div>

              <label for="label" class="required"><g:message code="external.property.application.label" /> * :</label>
              <input type="text" name="label" class="required" size="40" 
                  title="${message(code:'external.error.application.labelRequired')}" value="${app?.label}"/>

              <label for="description" class="required"><g:message code="external.property.application.description" /> * :</label>
              <input type="text" name="description" size="40" class="required" 
                  title="${message(code:'external.error.application.descriptionRequired')}" value="${app?.description}"/>

              <g:if test="${!brokers.isEmpty()}">
                  <label for="brokers" class="required"><g:message code="external.property.application.brokers" /> * :</label>
                  <ul class="dataTree">
                      <g:each in="${brokers}" var="broker">
                        <li><input type="checkbox" name="brokers" value="${broker}" class="required validate-one-required"
                            <g:if test="${app?.brokers?.contains(broker)}">checked="checked"</g:if>>
                            ${broker}
                      </input></li>
                      </g:each>
                  </ul>
              </g:if>

              <p class="form-button">
                  <input type="hidden" name="id" value="${app?.id}" />
                  <g:if test="${editMode == 'create'}">
                    <input type="submit" name="submitApplication" value="${message(code:'action.create')}" />
                    <a id="cancelCreateApplication" href="${createLink(action:'applications')}">${message(code:'action.cancel')}</a>
                  </g:if>
                  <g:else>
                    <input type="submit" name="submitApplication" value="${message(code:'action.save')}" />
                  </g:else>
              </p>
            </form>
        </div>

        <g:if test="${editMode != 'create'}">

            <div id="homeFolders" class="mainbox mainbox-yellow">
            </div>

            <div id="import comptes" class="mainbox mainbox-yellow">
                <h2>${message(code:'external.header.import.homeFolders')}</h2>
                <form method="post" id="importHomeFoldersForm" class="localResourceUpload" action="${createLink(action : 'importHomeFolders', params:[id: app?.id])}">
                  <label for="csvFile">${message(code:'external.property.import.label.chooseFile')}:</label>
                  <input type="file" name="csvFile" />
                  <input type="submit" name="save" value="${message(code:'action.save')}" />
                </form>
            </div>

            <div class="mainbox mainbox-yellow">
                <h2>${message(code:'external.header.import.invoices')}</h2>
                <form method="post" id="importInvoicesForm" class="localResourceUpload" action="${createLink(action : 'importPayments', params:[type:'invoices',id: app?.id])}">
                  <label for="broker">${message(code:'external.property.import.label.chooseBroker')}:</label>
                  <select id="broker" name="broker">
                    <option value=""><g:message code="message.select.defaultOption" /></option>
                    <g:each in="${app?.brokers}">
                      <option value="${it}">${it}</option>
                    </g:each>
                  </select>
                  <label for="csvFile">${message(code:'external.property.import.label.chooseFile')}:</label>
                  <input type="file" name="csvFile" />
                  <input type="submit" name="save" value="${message(code:'action.save')}" />
                </form>
                
                <h3>${message(code:'external.header.import.invoicesDetail')}</h3>
                <form method="post" id="importInvoicesDetailForm" class="localResourceUpload" action="${createLink(action : 'importPaymentsDetail', params:[type:'invoicesDetail',id: app?.id])}">
                  <label for="csvFile">${message(code:'external.property.import.label.chooseFile')}:</label>
                  <input type="file" name="csvFile" />
                  <input type="submit" name="save" value="${message(code:'action.save')}" />
                </form>
            </div>

            <div class="mainbox mainbox-yellow">
                <h2>${message(code:'external.header.import.depositAccounts')}</h2>
                <form method="post" id="importDepositAccountsForm" class="localResourceUpload" action="${createLink(action : 'importPayments', params:[type:'accounts',id: app?.id])}">
                  <label for="broker">${message(code:'external.property.import.label.chooseBroker')}:</label>
                  <select id="broker" name="broker">
                    <option value=""><g:message code="message.select.defaultOption" /></option>
                    <g:each in="${app?.brokers}">
                      <option value="${it}">${it}</option>
                    </g:each>
                  </select>
                  <label for="csvFile">${message(code:'external.property.import.label.chooseFile')}:</label>
                  <input type="file" name="csvFile" />
                  <input type="submit" name="save" value="${message(code:'action.save')}" />
                </form>
                
                <h2>${message(code:'external.header.import.depositAccountsDetail')}</h2>
                <form method="post" id="importDepositAccountsDetailForm" class="localResourceUpload" action="${createLink(action : 'importPaymentsDetail', params:[type:'accountsDetail',id: app?.id])}">
                  <label for="csvFile">${message(code:'external.property.import.label.chooseFile')}:</label>
                  <input type="file" name="csvFile" />
                  <input type="submit" name="save" value="${message(code:'action.save')}" />
                </form>
            </div>

            <div class="mainbox mainbox-yellow">
                <h2>${message(code:'external.header.import.ticketingContracts')}</h2>
                <form method="post" id="importTicketingContractsForm" class="localResourceUpload" action="${createLink(action : 'importPayments', params:[type:'contracts',id: app?.id])}">
                  <label for="broker">${message(code:'external.property.import.label.chooseBroker')}:</label>
                  <select id="broker" name="broker">
                    <option value=""><g:message code="message.select.defaultOption" /></option>
                    <g:each in="${app?.brokers}">
                      <option value="${it}">${it}</option>
                    </g:each>
                  </select>
                  <label for="csvFile">${message(code:'external.property.import.label.chooseFile')}:</label>
                  <input type="file" name="csvFile" />
                  <input type="submit" name="save" value="${message(code:'action.save')}" />
                </form>
            </div>
        </g:if>
      </div>
    </div>

    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
      <div class="nobox">
        <h3>${message(code:'external.header.switchApplication')}</h3>
        <div class="body">
          <g:if test="${applications.size == 0}">
            ${message(code:'external.message.applications.noApplicationsDefined')}
          </g:if>
          <g:else>
            <form action="<g:createLink action="editApplication" />">
              <select id="changeApplication" name="id">
                <g:each in="${applications}">
                  <option value="${it.id}" ${it.id == app?.id ? 'selected' : ''}>${it.label}</option>
                </g:each>
              </select>
            </form>
          </g:else>
        </div>
      </div>
    </div>

  </body>
</html>
