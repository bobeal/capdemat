<html>
  <head>
    <title>${message(code:'homeFolder.title.admin')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice/common', file:'form.css')}" />
  </head>
  <body>
    <g:if test="${flash.errorMessage}"><div class="error-box"><p>${flash.errorMessage}</p></div></g:if>
    <div class="yui-g">
      <div class="yui-u first main-box">
        <h2><g:message code="account.header.enterLogin" /></h2>
        <form action="${createLink(action:'resetPassword')}" method="post">
          <label class="required" for="login"><g:message code="account.property.login" /></label>
          <input type="text" name="login" id="login" class="required" />
          <input type="hidden" name="comesFromLoginStep" value="true" style="display : none;" />
          <input type="submit" value="${message(code:'action.confirm')}" />
        </form>
      </div>
    </div>
  </body>
</html>
