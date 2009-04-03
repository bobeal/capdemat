<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'homefolder.css')}" />
  </head>
  <body>
    <g:if test="${flash.errorMessage}"><div class="error-box"><p>${flash.errorMessage}</p></div></g:if>
    <div class="yui-g login-box">
      <div class="yui-u first">
        <form id="editPassword" class="editable-list-form"
          action="${createLink(action:'editPassword')}" method="post">
          <label class="required" for="oldPassword"><g:message code="homeFolder.adult.property.oldPassword"/> * :</label>
          <input type="password" name="oldPassword" value="" minlength="${passwordMinLength}" class="required" />
          <label class="required" for="newPassword"><g:message code="homeFolder.adult.property.newPassword"/> * :</label>
          <input type="password" name="newPassword" value="" minlength="${passwordMinLength}" class="required" />
          <span class="legend"><g:message code="homeFolder.adult.property.newPassword.legend" args="${[passwordMinLength]}"/></span>
          <label class="required" for="newPasswordConfirmation"><g:message code="homeFolder.adult.property.newPasswordConfirmation"/> * :</label>
          <input type="password" name="newPasswordConfirmation" value="" minlength="${passwordMinLength}"  class="required" />
          <p class="same-line">
            <input type="submit" value="${message(code:'action.save')}" />
            <input type="submit" name="cancel" value="${message(code:'action.cancel')}" />
          </p>
        </form>
      </div>
    </div>
  </body>
</html>
