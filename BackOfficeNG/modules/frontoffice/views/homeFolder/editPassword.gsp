<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice/common', file:'form.css')}" />
  </head>
  <body>
    <g:if test="${flash.errorMessage}"><div class="error-box"><p>${flash.errorMessage}</p></div></g:if>
    <div class="yui-g">
      <div class="yui-u first">
        <form action="${createLink(action:'editPassword')}" method="post">

          <fieldset>
              
            <legend><g:message code="account.header.editPassword"/></legend>

            <label class="required" for="oldPassword"><g:message code="homeFolder.adult.property.oldPassword"/> * :</label>
            <input type="password" name="oldPassword" value="" minlength="${passwordMinLength}" class="required" />

            <label class="required" for="newPassword">
              <g:message code="homeFolder.adult.property.newPassword"/> * :
              <span class="help">
                (<g:message code="homeFolder.adult.property.newPassword.legend" args="${[passwordMinLength]}"/>)
              </span>
            </label>
            <input type="password" name="newPassword" value="" minlength="${passwordMinLength}" class="required" />

            <label class="required" for="newPasswordConfirmation"><g:message code="homeFolder.adult.property.newPasswordConfirmation"/> * :</label>
            <input type="password" name="newPasswordConfirmation" value="" minlength="${passwordMinLength}"  class="required" />
          </fieldset>

          <p class="submit-form">
            <input type="submit" value="${message(code:'action.save')}" />
            <input type="submit" name="cancel" value="${message(code:'action.cancel')}" />
          </p>
        </form>
      </div>
    </div>
  </body>
</html>
