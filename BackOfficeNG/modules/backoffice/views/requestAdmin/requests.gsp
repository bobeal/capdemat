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
                <g:message code="localAuthority.property.draftLiveDuration" /> :
                <!-- <span> (<g:message code="property.days" />) </span> -->
              </label>
              <input type="text" name="draftLiveDuration" value="${draftLiveDuration}"
              class="required validate-positiveInteger" />
            </p>
            <p class="field">
              <label for="draftNotificationBeforeDelete">
                <g:message code="localAuthority.property.draftNotificationBeforeDelete" /> :
                <!-- <span> (<g:message code="property.days" />) </span> -->
              </label>
              <input type="text" name="draftNotificationBeforeDelete"
                value="${draftNotificationBeforeDelete}"
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
              <input type="radio" class="required validate-one-required" name="documentDigitalizationEnabled" value="1" <g:if test="${documentDigitalizationEnabled == true}">checked="checked"</g:if>/>
              <g:message code="message.yes" />
              <input type="radio" class="required validate-one-required" name="documentDigitalizationEnabled" value="0" <g:if test="${documentDigitalizationEnabled == false}">checked="checked"</g:if>/>
              <g:message code="message.no" />
            </p>
            <p class="field">
              <label>
                <g:message code="localAuthority.property.requestsCreationNotificationEnabled" /> :
              </label>
              <input type="radio" class="required validate-one-required" name="requestsCreationNotificationEnabled" value="1" <g:if test="${requestsCreationNotificationEnabled == true}">checked="checked"</g:if>/>
              <g:message code="message.yes" />
              <input type="radio" class="required validate-one-required" name="requestsCreationNotificationEnabled" value="0" <g:if test="${requestsCreationNotificationEnabled == false}">checked="checked"</g:if>/>
              <g:message code="message.no" />
            </p>
            <p class="field">
              <label>
                <g:message code="localAuthority.property.instructionAlertsEnabled" /> :
              </label>
              <input type="radio" class="required validate-one-required" name="instructionAlertsEnabled" value="1" <g:if test="${instructionAlertsEnabled == true}">checked="checked"</g:if>/>
              <g:message code="message.yes" />
              <input type="radio" class="required validate-one-required" name="instructionAlertsEnabled" value="0" <g:if test="${instructionAlertsEnabled == false}">checked="checked"</g:if>/>
              <g:message code="message.no" />
            </p>
            <p class="field">
              <label>
                <g:message code="localAuthority.property.instructionAlertsDetailed" /> :
              </label>
              <input type="radio" class="required validate-one-required" name="instructionAlertsDetailed" value="1" <g:if test="${instructionAlertsDetailed == true}">checked="checked"</g:if>/>
              <g:message code="message.yes" />
              <input type="radio" class="required validate-one-required" name="instructionAlertsDetailed" value="0" <g:if test="${instructionAlertsDetailed == false}">checked="checked"</g:if>/>
              <g:message code="message.no" />
            </p>
            <p class="field">
              <label for="instructionDefaultAlertDelay">
                <g:message code="localAuthority.property.instructionDefaultAlertDelay" /> :
              </label>
              <input type="text" class="required validate-number" name="instructionDefaultAlertDelay" id="instructionDefaultAlertDelay" value="${instructionDefaultAlertDelay}" size="3" />
              <g:message code="property.days" />
            </p>
            <p class="field">
              <label for="instructionDefaultMaxDelay">
                <g:message code="localAuthority.property.instructionDefaultMaxDelay" /> :
              </label>
              <input type="text" class="required validate-number" name="instructionDefaultMaxDelay" id="instructionDefaultMaxDelay" value="${instructionDefaultMaxDelay}" size="3" />
              <g:message code="property.days" />
            </p>
            <p class="field">
              <label for="requestLockMaxDelay">
                <g:message code="localAuthority.property.requestLockMaxDelay" /> :
              </label>
              <input type="text" class="required validate-number" name="requestLockMaxDelay" id="requestLockMaxDelay" value="${requestLockMaxDelay}" size="5" />
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
