<html>
  <head>
    <title><g:message code="localAuthority.header.configuration" /></title>
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'localAuthorityIdentity.js')}"></script>
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
            <label class="required" for="postalCode">
              <g:message code="address.property.postalCode" /> * :
            </label>
            <input type="text" class="required validate-number" minlength="5" maxlength="5" size="5" name="postalCode" value="${postalCode}" />
            <label class="required" for="displayTitle">
              <g:message code="localAuthority.property.displayTitle" /> :
            </label>
            <input type="text" class="required" size="60" maxlength="100" name="displayTitle" value="${displayTitle}" />
            <label class="required" for="serverNames">
              <g:message code="localAuthority.property.serverNames" /> :
            </label>
            <textarea cols="58" rows="5" name="serverNames" class="required">${serverNames}</textarea>
            <div class="form-button">
              <input id="save" type="button" value="${message(code:'action.save')}" />
            </div>
          </form>
        </div>
        <!-- <div id="serverNamesBox" class="mainbox mainbox-yellow">
          <h2><g:message code="localAuthority.header.setup.identity" /></h2>
          <form method="post" id="identityForm" action="${createLink(action : 'identity')}">
            <div class="error" id="identityFormErrors"></div>
            <label for="postalCode">
              <g:message code="address.property.postalCode" /> :
            </label>
            <input type="text" class="required validate-number" minlength="5" maxlength="5" name="postalCode" value="${postalCode}" />
            <input type="text" class="required validate-alphanum" maxlength="100" name="displayTitle" value="${displayTitle}" />
            <input id="save" type="button" value="${message(code:'action.save')}" />
          </form>
        </div> -->
      </div>
    </div>
    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="localAuthority.header"
        data="${subMenuEntries}" />
    </div>
  </body>
</html>
