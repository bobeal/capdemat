<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice/common', file:'form.css')}" />
  </head>
  <body>
    <g:if test="${flash.errorMessage}"><div class="error-box"><p>${flash.errorMessage}</p></div></g:if>
    <div class="yui-g">
      <div class="yui-u first main-box">
        <h2><g:message code="account.header.editPassword"/></h2>
        <form action="${createLink(action:'editPassword')}" method="post">

          <label class="required" for="oldPassword"><g:message code="homeFolder.adult.property.oldPassword"/> * :</label>
          <input type="password" id="oldPassword" name="oldPassword" value="" class="required" />

          <label class="required" for="newPassword">
            <g:message code="homeFolder.adult.property.newPassword"/> * :
            <span class="help">
              (<g:message code="homeFolder.adult.property.newPassword.legend" args="${[passwordMinLength]}"/>)
            </span>
          </label>
          <input type="password" id="newPassword" name="newPassword" value="" class="required" />

          <label class="required" for="newPasswordConfirmation"><g:message code="homeFolder.adult.property.newPasswordConfirmation"/> * :</label>
          <input type="password" id="newPasswordConfirmation" name="newPasswordConfirmation" value="" class="required" />

          <p class="submit-form">
            <input type="submit" value="${message(code:'action.save')}" />
            <input type="submit" name="cancel" value="${message(code:'action.cancel')}" />
          </p>
        </form>
      </div>
    </div>
  </body>
</html>
