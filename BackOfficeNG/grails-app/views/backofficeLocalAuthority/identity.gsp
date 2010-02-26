<html>
  <head>
    <title><g:message code="localAuthority.header.configuration" /></title>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'localAuthorityIdentity.js')}"></script>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="localAuthority.header.configuration" /></h1>
        </div>
        <div id="identityBox" class="mainbox mainbox-yellow">
          <h2><g:message code="localAuthority.header.setup.identity" /></h2>
          <form method="post" id="identityForm" action="${createLink(action : 'identity')}">
            <div class="error" id="identityFormErrors"></div>
            <p class="field">
              <label for="displayTitle">
                <g:message code="localAuthority.property.displayTitle" /> :
              </label>
              <input type="text" class="required" size="50" maxlength="100" name="displayTitle" value="${displayTitle}" />
            </p>
            <p class="field">
              <label for="postalCode">
                <g:message code="address.property.postalCode" /> :
              </label>
              <input type="text" class="required validate-number" minlength="5" maxlength="5" size="5" name="postalCode" value="${postalCode}" />
            </p>
            <p class="field">
              <label for="adminEmail">
                <g:message code="localAuthority.property.adminEmail" /> :
              </label>
              <input type="text" class="validate-email" size="50" name="adminEmail" value="${adminEmail}" />
            </p>
            <p class="field">
              <label for="serverNames">
                <g:message code="localAuthority.property.serverNames" /> :
              </label>
              <textarea cols="50" rows="5" name="serverNames" class="required">${serverNames}</textarea>
            </p>
            <div class="form-button">
              <input id="save" type="button" value="${message(code:'action.save')}" />
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
