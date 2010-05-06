<html>
  <head>
    <title><g:message code="localAuthority.header.configuration" /></title>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'localAuthorityAddressesReferential.js')}"></script>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="localAuthority.header.configuration" /></h1>
        </div>
        <div id="addressesReferentialBox" class="mainbox mainbox-yellow">
          <h2><g:message code="localAuthority.header.setup.addressesReferential" /></h2>
          <form method="post" id="addressesReferentialForm" action="${createLink(action : 'addressesReferential')}">
            <div class="error" id="addressesReferentialFormErrors"></div>
            <p class="field">
              <label for="token">
                <g:message code="localAuthority.property.token" /> :
              </label>
              <input type="text" class="required" size="50" maxlength="100" name="token" value="${token}" />
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
