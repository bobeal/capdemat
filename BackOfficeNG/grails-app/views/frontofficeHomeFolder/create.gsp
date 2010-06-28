<html>
  <head>
    <title>${message(code:'homeFolder.title.creation')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'data-detail.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  <body>
    <g:if test="${invalidFields && !invalidFields.isEmpty()}">
      <div class="error-box">
        <p><g:message code="form.error.invalidFields" /></p>
      </div>
    </g:if>
    <div class="main-box data-detail">
      <h2><g:message code="homeFolder.action.createAccount"/></h2>
      <form action="${createLink(controller : 'frontofficeHomeFolder', action:'create')}" method="post">
        <input type="hidden" name="requestTypeLabel" value="${params.requestTypeLabel}" />
        <g:render template="/frontofficeHomeFolder/adultCommonFields" />
        <div class="yui-g">
          <h3><g:message code="homeFolder.individual.header.connexionInformations" /></h3>
          <div class="yui-u first">
            <label for="password" class="required">
              <g:message code="request.step.validation.label.choosePassword" />
              <span>(<g:message code="request.step.validation.help.choosePassword" />)</span>
            </label>
            <input type="password" id="password" name="password" value=""
              class="required ${invalidFields.contains('password') ? 'validation-failed' : ''}"
              title="<g:message code="homeFolder.adult.property.password.validationError" />" />
            <label for="question" class="required">
              <g:message code="homeFolder.adult.property.question" />
            </label>
            <select id="question" name="question"
              class="required validate-not-first ${invalidFields.contains('question') ? 'validation-failed' : ''}"
              title="<g:message code='homeFolder.adult.property.question.validationError' />">
              <option value="">${message(code:'message.select.defaultOption')}</option>
              <g:each in="${['q1','q2','q3','q4']}">
                <option value="${message(code:'homeFolder.adult.question.' + it)}"
                  <g:if test="${message(code:'homeFolder.adult.question.' + it).equals(adult?.question)}">
                    selected="selected"
                  </g:if>>
                  ${message(code:'homeFolder.adult.question.' + it)}
                </option>
              </g:each>
            </select>
          </div>
          <div class="yui-u">
            <label for="confirmPassword" class="required">
              <g:message code="request.step.validation.label.confirmPassword" />
            </label>
            <input type="password" id="confirmPassword" name="confirmPassword" value=""
              class="required ${invalidFields.contains('confirmPassword') ? 'validation-failed' : ''}"
              title="<g:message code="vcr.property.confirmPassword.validationError" />" />
            <label for="answer" class="required">
              ${message(code:'homeFolder.adult.property.answer')}
            </label>
            <input type="text" id="answer" name="answer" value="${adult?.answer}"
              class="required ${invalidFields.contains('answer') ? 'validation-failed' : ''}"
              title="${message(code:'homeFolder.adult.property.answer.validationError')}" />
          </div>
        </div>
        <div class="yui-gb">
          <div class="yui-u first">
            <jcaptcha:jpeg name="captchaImage" alt="captcha" />
          </div>
          <div class="yui-u">
            <label for="captchaText" class="required">
              ${message(code:'request.step.validation.label.typeTextInImage')}
            </label>
            <input type="text" id="captchaText" name="captchaText"
              class="required ${invalidFields.contains('captchaText') ? 'validation-failed' : ''}"
              title="${message(code:'request.step.validation.error.captcha')}" />
          </div>
          <div class="yui-u">
            <input type="submit" value="${message(code:'action.create')}" />
          </div>
        </div>
      </form>
    </div>
  </body>
</html>
