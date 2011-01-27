<html>
  <head>
    <title>${message(code:'homeFolder.title.creation')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <style type="text/css">
      #request .steps p.help { margin-bottom: .5em; font-style: italic;}
      #request .datas form div p.error { text-align: left; }
      #request .datas form p { padding-left: 0; font-style: italic;}
    </style>
    <script type="text/javascript" src="${resource(dir : 'js/frontoffice', file : 'homeFolderCreation.js')}"></script>
  </head>
  <body>
    <div id="request" class="main-box">
      <h2>
        <g:if test="${!temporary}">
          <a href="${createLink(controller:'frontofficeHome')}" class="button">${message(code:'action.quit')}</a>
        </g:if>
        <g:translateRequestTypeLabel label="${params.requestTypeLabel}" />
        <g:if test="${!temporary}">
          <span>${message(code:'homeFolder.action.createAccount')}</span>
        </g:if>
      </h2>
      <div class="datas">
        <div class="${invalidFields && !invalidFields.isEmpty() ? 'invalid' : 'uncomplete'} form">
        <form action="${createLink(controller : 'frontofficeHomeFolder', action:'create')}" method="post">
          <input type="hidden" name="requestTypeLabel" value="${params.requestTypeLabel}" />
          <input type="hidden" name="requestSeasonId" value="${params.requestSeasonId}" />
          <div>
            <g:if test="${invalidFields && !invalidFields.isEmpty()}">
              <p class="error">${message(code:'form.error.invalidFields')}</p>
            </g:if>
            <g:render template="/frontofficeHomeFolder/adultCommonFields" />
            <fieldset>
              <legend>${message(code:'homeFolder.individual.header.connexionInformations')}</legend>
              <g:if test="${temporary}">
                <p>${message(code:'request.step.validation.help.followRequest')}</p>
                <label class="required">
                  ${message(code:'request.step.validation.label.followRequest')}
                </label>
                <ul class="yes-no required">
                  <li>
                    <input type="radio" class="required" value="false"
                      name="temporary" id="temporary_off"
                      ${params.boolean != null && params.boolean('temporary') ? '' : 'checked="checked"'} />
                    <label for="temporary_off">
                      <g:message code="message.yes" />
                    </label>
                  </li>
                  <li>
                    <input type="radio" class="required" value="true"
                      name="temporary" id="temporary_on"
                      ${params.boolean == null || params.boolean('temporary') ? 'checked="checked"' : ''} />
                    <label for="temporary_on">
                      <g:message code="message.no" />
                    </label>
                  </li>
                </ul>
                <div id="loginInformations" class="${params.boolean == null || params.boolean('temporary') ? 'hidden' : ''}">
              </g:if>
              <label for="password" class="required">
                ${message(code:'request.step.validation.label.choosePassword')}
                <span>(${message(code:'request.step.validation.help.choosePassword')})</span>
              </label>
              <input type="password" id="password" name="password" value=""
                class="required ${invalidFields.contains('password') ? 'validation-failed' : ''}"
                title="${message(code:'homeFolder.adult.property.password.validationError')}" />
              <label for="confirmPassword" class="required">${message(code:'request.step.validation.label.confirmPassword')}</label>
              <input type="password" id="confirmPassword" name="confirmPassword" value=""
                class="required ${invalidFields.contains('confirmPassword') ? 'validation-failed' : ''}"
                title="${message(code:'vcr.property.confirmPassword.validationError')}'" />
              <p>${message(code:'homeFolder.adult.help.question')}</p>
              <label for="question" class="required">
                ${message(code:'homeFolder.adult.property.question')}
              </label>
              <select id="question" name="question"
                class="required validate-not-first ${invalidFields.contains('question') ? 'validation-failed' : ''}"
                title="${message(code:'homeFolder.adult.property.question.validationError')}">
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
              <label for="answer" class="required">${message(code:'homeFolder.adult.property.answer')}</label>
              <input type="text" id="answer" name="answer" value="${adult?.answer}"
                class="required ${invalidFields.contains('answer') ? 'validation-failed' : ''}"
                title="${message(code:'homeFolder.adult.property.answer.validationError')}" />
              <g:if test="${temporary}">
                </div>
              </g:if>
              <label for="captchaText" class="required">
                ${message(code:'request.step.validation.label.typeTextInImage')}
              </label>
              <jcaptcha:jpeg name="captchaImage" alt="captcha" />
              <input type="text" id="captchaText" name="captchaText"
                class="required ${invalidFields.contains('captchaText') ? 'validation-failed' : ''}"
                title="${message(code:'request.step.validation.error.captcha')}" />
            </fieldset>
            <p style="text-align: center;">
              <input type="submit" style="font-size:1.2em;"
                value="${temporary ? message(code : 'homeFolder.action.createTemporaryAccountAndContinue') : message(code : 'homeFolder.action.createAccountAndContinue')}" />
            </p>
          </div>
        </form>
        </div>
      </div>
      <g:if test="${!temporary}">
        <div class="steps">
          <ul>
            <li class="">
              ${message(code:'homeFolder.message.whyCreateAccount')}
              <p class="help">
                ${message(code:'homeFolder.message.createAccount')}
              </p>
            </li>
            <li>
              ${message(code:'homeFolder.message.accountAdvantage')}
              <p class="help">${message(code:'homeFolder.message.accountAdvantage1')}</p>
              <p class="help">${message(code:'homeFolder.message.accountAdvantage2')}</p>
              <p class="help">${message(code:'homeFolder.message.accountAdvantage3')}</p>
            </li>
          </ul>
        </div>
      </g:if>
    </div>
  </body>
</html>
