<html>
  <head>
    <title><g:message code="requestArchives.header.index" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="requestArchives.header.index" /></h1>
        </div>
        <div class="mainbox mainbox-yellow">
          <form method="post" action="">
            <p class="field">
              <label for="password"><g:message code="account.property.password"/> :</label>
              <input type="password" id="password" name="password" value="" />
            </p>
            <div class="form-button">
              <input type="submit" value="${message(code:'action.login')}"/>
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
