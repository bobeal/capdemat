<html>
  <head>
    <title><g:message code="localAuthority.header.requestsConfiguration" /></title>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'localAuthorityRequests.js')}"></script>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="localAuthority.header.requestsConfiguration" /></h1>
        </div>
        <div id="draftsBox" class="mainbox mainbox-yellow">
          <h2><g:message code="localAuthority.header.setupDrafts" /></h2>
          <form method="post" id="draftsForm" action="${createLink(action:'requests')}">
            <div class="error" id="draftsFormErrors"> </div>
            <p class="field">
              <label for="draftLiveDuration">
                <g:message code="requestAdmin.property.draftLiveDuration" /> :
                <!-- <span> (<g:message code="property.days" />) </span> -->
              </label>
              <input type="text" name="draftLiveDuration"
                value="${globalRequestTypeConfiguration.draftLiveDuration}"
              class="required validate-positiveInteger" />
            </p>
            <p class="field">
              <label for="draftNotificationBeforeDelete">
                <g:message code="requestAdmin.property.draftNotificationBeforeDelete" /> :
                <!-- <span> (<g:message code="property.days" />) </span> -->
              </label>
              <input type="text" name="draftNotificationBeforeDelete"
                value="${globalRequestTypeConfiguration.draftNotificationBeforeDelete}"
                class="required validate-positiveInteger" />
            </p>
            <div class="form-button">
              <input id="save_drafts" type="button" value="${message(code:'action.save')}" />
            </div>
          </form>
        </div>
        <div id="meansOfContactBox" class="mainbox mainbox-yellow">
          <h2><g:message code="localAuthority.header.meansOfContactConfiguration" /></h2>
          <div id="meansOfContactContainer"></div>
        </div>
        <div id="platformConfigurationBox" class="mainbox mainbox-yellow">
          <h2><g:message code="localAuthority.header.setup.platformConfiguration" /></h2>
          <form method="post" id="platformConfigurationForm" action="${createLink(action : 'requests')}">
            <div class="error" id="platformConfigurationFormErrors"></div>
            <p class="field">
              <label>
                <g:message code="localAuthority.property.documentDigitalizationEnabled" /> :
              </label>
              <input type="radio" class="required validate-one-required"
                name="documentDigitalizationEnabled" value="1"
                <g:if test="${documentDigitalizationEnabled == true}">
                  checked="checked"
                </g:if> />
              <g:message code="message.yes" />
              <input type="radio" class="required validate-one-required"
                name="documentDigitalizationEnabled" value="0"
                <g:if test="${documentDigitalizationEnabled == false}">
                  checked="checked"
                </g:if> />
              <g:message code="message.no" />
            </p>
            <p class="field">
              <label>
                <g:message code="requestAdmin.property.requestsCreationNotificationEnabled" /> :
              </label>
              <input type="radio" class="required validate-one-required"
                name="requestsCreationNotificationEnabled" value="1"
                <g:if test="${globalRequestTypeConfiguration.requestsCreationNotificationEnabled == true}">
                  checked="checked"
                </g:if> />
              <g:message code="message.yes" />
              <input type="radio" class="required validate-one-required"
                name="requestsCreationNotificationEnabled" value="0"
                <g:if test="${globalRequestTypeConfiguration.requestsCreationNotificationEnabled == false}">
                  checked="checked"
                </g:if> />
              <g:message code="message.no" />
            </p>
            <p class="field">
              <label>
                <g:message code="requestAdmin.property.instructionAlertsEnabled" /> :
              </label>
              <input type="radio" class="required validate-one-required"
                name="instructionAlertsEnabled" value="1"
                <g:if test="${globalRequestTypeConfiguration.instructionAlertsEnabled == true}">
                  checked="checked"
                </g:if> />
              <g:message code="message.yes" />
              <input type="radio" class="required validate-one-required"
                name="instructionAlertsEnabled" value="0"
                <g:if test="${globalRequestTypeConfiguration.instructionAlertsEnabled == false}">
                  checked="checked"
                </g:if> />
              <g:message code="message.no" />
            </p>
            <p class="field">
              <label>
                <g:message code="requestAdmin.property.instructionAlertsDetailed" /> :
              </label>
              <input type="radio" class="required validate-one-required"
                name="instructionAlertsDetailed" value="1"
                <g:if test="${globalRequestTypeConfiguration.instructionAlertsDetailed == true}">
                  checked="checked"
                </g:if> />
              <g:message code="message.yes" />
              <input type="radio" class="required validate-one-required"
                name="instructionAlertsDetailed" value="0"
                <g:if test="${globalRequestTypeConfiguration.instructionAlertsDetailed == false}">
                  checked="checked"
                </g:if> />
              <g:message code="message.no" />
            </p>
            <p class="field">
              <label for="instructionAlertDelay">
                <g:message code="requestType.property.instructionAlertDelay" /> :
              </label>
              <input type="text" class="required validate-number" size="3"
                name="instructionAlertDelay" id="instructionAlertDelay"
                value="${globalRequestTypeConfiguration.instructionAlertDelay}" />
              <g:message code="property.days" />
            </p>
            <p class="field">
              <label for="instructionMaxDelay">
                <g:message code="requestType.property.instructionMaxDelay" /> :
              </label>
              <input type="text" class="required validate-number" name="instructionMaxDelay"
                id="instructionMaxDelay" size="3"
                value="${globalRequestTypeConfiguration.instructionMaxDelay}" />
              <g:message code="property.days" />
            </p>
            <p class="field">
              <label for="requestLockMaxDelay">
                <g:message code="requestAdmin.property.requestLockMaxDelay" /> :
              </label>
              <input type="text" class="required validate-number" name="requestLockMaxDelay"
                id="requestLockMaxDelay" size="5"
                value="${globalRequestTypeConfiguration.requestLockMaxDelay}" />
              <g:message code="property.minutes" />
            </p>
            <div class="form-button">
              <input id="save_platformConfiguration" type="button" value="${message(code:'action.save')}" />
            </div>
          </form>
        </div>
      </div>
    </div>
    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
    </div>
  </body>
</html>
