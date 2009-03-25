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
          <p><g:message code="answer.question" /></p>
          <label class="required" for="answer">${question}</label>
          <input type="text" name="answer" class="required" />
          <input type="hidden" name="login" value="${login}" style="display : none;" />
          <input type="submit" value="${message(code:'action.confirm')}" />
        </form>
      </div>
    </div>
  </body>
</html>
