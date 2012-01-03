<html>
  <head>
    <title>${message(code:'homeFolder.title.admin')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
  </head>
  <body>
    <g:if test="${flash.errorMessage}"><div class="error-box"><p>${flash.errorMessage}</p></div></g:if>
    <div class="yui-g">
      <div class="yui-u first main-box">
        <form id="adultImportedAccount_${adult?.id}" method="post" action="${createLink(action:'editImportedAccount')}">

          <label for="email" class="required">
            ${message(code:'homeFolder.adult.property.email')} *
            <span>
              ${message(code:'homeFolder.adult.property.email.help')}
            </span>
          </label>
          <input type="text" id="email" name="email" value=""
              class="required validate-email ${invalidFields?.contains('email') ? 'validation-failed' : ''}"
              title="${message(code:'homeFolder.adult.property.email.validationError')}" autocomplete="off" />

        <input type="hidden" id="homePhone" name="homePhone" value="${adult?.homePhone}"
            class="validate-phone ${invalidFields?.contains('homePhone') ? 'validation-failed' : ''}"
            title="${message(code:'homeFolder.adult.property.homePhone.validationError')}" />

        <input type="hidden" id="mobilePhone" name="mobilePhone" value="${adult?.mobilePhone}"
            class="validate-mobilePhone ${invalidFields?.contains('mobilePhone') ? 'validation-failed' : ''}"
            title="${message(code:'homeFolder.adult.property.mobilePhone.validationError')}" />

        <input type="hidden" id="officePhone" name="officePhone" value="${adult?.officePhone}"
            class="validate-phone ${invalidFields?.contains('officePhone') ? 'validation-failed' : ''}"
            title="${message(code:'homeFolder.adult.property.officePhone.validationError')}" />

          <label class="required" for="oldPassword"><g:message code="homeFolder.adult.property.oldPassword"/> * :</label>
          <input type="password" id="oldPassword" name="oldPassword" value="" class="required" autocomplete="off" />

          <label class="required" for="newPassword">
            <g:message code="homeFolder.adult.property.newPassword"/> * :
            <span class="help">
              (<g:message code="homeFolder.adult.property.newPassword.legend" args="${[passwordMinLength]}"/>)
            </span>
          </label>
          <input type="password" id="newPassword" name="newPassword" value="" class="required" autocomplete="off" />

          <label class="required" for="newPasswordConfirmation"><g:message code="homeFolder.adult.property.newPasswordConfirmation"/> * :</label>
          <input type="password" id="newPasswordConfirmation" name="newPasswordConfirmation" value="" class="required" autocomplete="off" />

          <label for="question" class="required"><g:message code="homeFolder.adult.property.question" /> * :</label>
          <select id="question" name="question" class="required validate-not-first">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['q1','q2','q3','q4']}">
              <option value="<g:message code='homeFolder.adult.question.${it}' />"${message(code:'homeFolder.adult.question.' + it) == question.toString() ? 'selected="selected"': ''}>
                <g:message code="homeFolder.adult.question.${it}" />
              </option>
            </g:each>
          </select>

          <label for="answer" class="required"><g:message code="homeFolder.adult.property.answer" /> * :</label>
          <input type="text" id="answer" name="answer" value="${adult?.answer}" class="required" />

          <p class="submit-form">
            <input type="submit" value="${message(code:'action.save')}" />
            <input type="submit" name="cancel" value="${message(code:'action.cancel')}" />
          </p>
        </form>
      </div>
      <div class="yui-u main-box">
          <h2>${message(code:'homeFolder.importedAccount.information.title')}</h2>
          <p>${message(code:'homeFolder.importedAccount.information.body')}</p>
      </div>
    </div>
  </body>
</html>
