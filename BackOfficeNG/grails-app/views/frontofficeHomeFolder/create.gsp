<html>
  <head>
    <title>${message(code:'homeFolder.title.admin')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  <body>
    <g:if test="${flash.errorMessage}"><div class="error-box"><p>${flash.errorMessage}</p></div></g:if>
    <div class="yui-g">
      <div class="yui-u first main-box">
        <h2><g:message code="account.header.editPassword"/><p>${invalidFields}</p></h2>
        <form action="${createLink(controller : 'frontofficeHomeFolder', action:'create')}" method="post">
          <input type="hidden" name="requestTypeLabel" value="${params.requestTypeLabel}" />

          <label for="title" class="required">
            <g:message code="homeFolder.adult.property.title" />
          </label>
          <select id="title" name="title"
            class="required validate-not-first ${invalidFields.contains('title') ? 'validation-failed' : ''}"
            title="<g:message code="homeFolder.adult.property.title.validationError" />">
            <option value="">
              <g:message code="message.select.defaultOption" />
            </option>
            <g:each in="${fr.cg95.cvq.business.users.TitleType.allTitleTypes}">
              <option value="fr.cg95.cvq.business.users.TitleType_${it}"
                ${it == adult?.title ? 'selected="selected"': ''}>
                <g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.title" />
              </option>
            </g:each>
          </select>

          <label for="lastName" class="required">
            <g:message code="homeFolder.individual.property.lastName" />
          </label>
          <input type="text" id="lastName" name="lastName" value="${adult?.lastName}"
            class="required validate-lastName ${invalidFields.contains('lastName') ? 'validation-failed' : ''}"
            title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />

          <label for="firstName" class="required">
            <g:message code="homeFolder.individual.property.firstName" />
          </label>
          <input type="text" id="firstName" name="firstName" value="${adult?.firstName}"
            class="required validate-firstName ${invalidFields.contains('firstName') ? 'validation-failed' : ''}"
            title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />

          <label for="email" class="required">
            <g:message code="homeFolder.adult.property.email" /> <span><g:message code="homeFolder.adult.property.email.help" /></span>
          </label>
          <input type="text" id="email" name="email" value="${adult?.email}"
            class="required validate-email ${invalidFields.contains('email') ? 'validation-failed' : ''}"
            title="<g:message code="homeFolder.adult.property.email.validationError" />" />

          <label for="password" class="required">
            <g:message code="request.step.validation.label.choosePassword" /> <span>(<g:message code="request.step.validation.help.choosePassword" />)</span>
          </label>
          <input type="password" id="password" name="password" value=""
            class="required ${invalidFields.contains('password') ? 'validation-failed' : ''}"
            title="<g:message code="homeFolder.adult.property.password.validationError" />" />

          <label for="confirmPassword" class="required">
            <g:message code="request.step.validation.label.confirmPassword" />
          </label>
          <input type="password" id="confirmPassword" name="confirmPassword" value=""
            class="required ${invalidFields.contains('confirmPassword') ? 'validation-failed' : ''}"
            title="<g:message code="vcr.property.confirmPassword.validationError" />" />

          <label for="question" class="required">
            <g:message code="homeFolder.adult.property.question" />
          </label>
          <select id="question" name="question"
            class="required validate-not-first ${invalidFields.contains('question') ? 'validation-failed' : ''}"
            title="<g:message code='homeFolder.adult.property.question.validationError' />">
            <option value="">${message(code:'message.select.defaultOption')}</option>
            <g:each in="${['q1','q2','q3','q4']}">
              <option value="${message(code:'homeFolder.adult.question.' + it)}"
                <g:if test="${message(code:'homeFolder.adult.question.' + it).equals(individual?.question)}"> selected="selected"</g:if>>
                ${message(code:'homeFolder.adult.question.' + it)}
              </option>
            </g:each>
          </select>

          <label for="answer" class="required">
            ${message(code:'homeFolder.adult.property.answer')}
          </label>
          <input type="text" id="answer" name="answer" value="${individual?.answer}"
            class="required ${invalidFields.contains('answer') ? 'validation-failed' : ''}"
            title="${message(code:'homeFolder.adult.property.answer.validationError')}" />

          <label for="captchaText" class="required">
            ${message(code:'request.step.validation.label.typeTextInImage')}
          </label>
          <div class="captcha">
            <jcaptcha:jpeg name="captchaImage" alt="captcha" />
            <input type="text" id="captchaText" name="captchaText" class="required"
              title="${message(code:'request.step.validation.error.captcha')}" />
          </div>

          <p class="submit-form">
            <input type="submit" value="${message(code:'action.save')}" />
            <input type="submit" name="cancel" value="${message(code:'action.cancel')}" />
          </p>
        </form>
      </div>
      <div class="yui-u main-box">
        <h2><g:message code="account.header.editPassword"/></h2>
        <g:if test="${flash.loginError}">
          <p class="error">${flash.loginError}</p>
        </g:if>
        <form action="${createLink(controller : 'frontofficeHome', action:'login')}" method="post">
          <input type="hidden" name="requestTypeLabel" value="${params.requestTypeLabel}" />
          <label class="required">
            <g:message code="homeFolder.adult.property.login" />
            <input type="text" name="login" value="" class="required"
              title="<g:message code="homeFolder.adult.property.login.validationError" />" />
          </label>
          <label class="required">
            <g:message code="request.step.validation.label.choosePassword" /> <span>(<g:message code="request.step.validation.help.choosePassword" />)</span>
            <input type="password" name="password" value="" class="required"
              title="<g:message code="homeFolder.adult.property.password.validationError" />" />
          </label>
          <p class="submit-form">
            <input type="submit" value="${message(code:'action.login')}" />
          </p>
        </form>
      </div>
    </div>
  </body>
</html>
