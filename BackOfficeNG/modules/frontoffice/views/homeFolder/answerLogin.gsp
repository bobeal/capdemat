<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'homefolder.css')}" />
  </head>
  <body>
    <g:if test="${flash.errorMessage}"><div class="error-box"><p>${flash.errorMessage}</p></div></g:if>
    <div class="yui-g login-box">
      <div class="yui-u first">
        <form action="${createLink(action:'resetPassword')}" method="post">
          <label class="required" for="login"><g:message code="enter.login" /></label>
          <input type="text" name="login" class="required" />
          <input type="hidden" name="comesFromLoginStep" value="true" style="display : none;" />
          <input type="submit" value="${message(code:'action.confirm')}" />
        </form>
      </div>
    </div>
  </body>
</html>
