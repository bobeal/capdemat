<html>
  <head>
    <title>${message(code:'homeFolder.title.creation')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <style type="text/css">
      #request form div input[type="text"],
      #request form div input[type="password"],
      #request form div select,
      #request form div textarea,
      #request .address { width: 95%; }
      #request .address input[type="text"].line2 { width: 81%; }
%{--      #request form div h3 { margin-bottom: 0; }--}%
%{--      #request form div fieldset { background:#eee; margin:-1.5em 0 0; padding: 0 1em 1em; }--}%
%{--      #request form div legend { margin:2em 0 0 !important; padding:1em 0; }--}%
      #request .steps p.help { margin-bottom: .5em; font-style: italic;}
      #request form div p.error { text-align: left; }
    </style>
  </head>
  <body>

%{--    id="request" give access to form selector in request.css, but has no semantic value here --}%
    <div id="request" class="main-box">
      <h2>
        <a href="${createLink(controller:'frontofficeHome')}" class="button">${message(code:'action.quit')}</a>
        <g:translateRequestTypeLabel label="${params.requestTypeLabel}" />
        <span>${message(code:'homeFolder.action.createAccount')}</span>
      </h2>
%{--      <p>${message(code:'homeFolder.message.createAccount')}</p>--}%
      <div class="datas">
        <form action="${createLink(controller : 'frontofficeHomeFolder', action:'create')}" method="post" class="${invalidFields && !invalidFields.isEmpty() ? 'invalid' : 'uncomplete'}">
          <input type="hidden" name="requestTypeLabel" value="${params.requestTypeLabel}" />
          <input type="hidden" name="requestSeasonId" value="${params.requestSeasonId}" />
          <div>
%{--          <div class="yui-g">--}%
%{--             <h3>--}%
%{--              ${message(code:'homeFolder.action.createAccount')}              --}%
              <g:if test="${invalidFields && !invalidFields.isEmpty()}">
                <p class="error">${message(code:'form.error.invalidFields')}</p>
              </g:if>
%{--             </h3>--}%
%{--            <div class="yui-u first">--}%
              <g:render template="/frontofficeHomeFolder/adultCommonFields" />
%{--            </div>--}%
%{--            <div class="yui-u">--}%
              <fieldset>
                <legend>${message(code:'homeFolder.individual.header.connexionInformations')}</legend>
                  <label for="password" class="required">
                    ${message(code:'request.step.validation.label.choosePassword')}
                    <span>(${message(code:'request.step.validation.help.choosePassword')})</span>
                  </label>
                  <input type="password" id="password" name="password" value=""
                    class="required ${invalidFields.contains('password') ? 'validation-failed' : ''}"
                    title="${message(code:'homeFolder.adult.property.password.validationError')}" />
                  <label for="confirmPassword" class="required">${message(code:'request.step.validation.label.confirmPassword')}'</label>
                  <input type="password" id="confirmPassword" name="confirmPassword" value=""
                    class="required ${invalidFields.contains('confirmPassword') ? 'validation-failed' : ''}"
                    title="${message(code:'vcr.property.confirmPassword.validationError')}'" />

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

                  <label for="captchaText" class="required">
                    ${message(code:'request.step.validation.label.typeTextInImage')}
                  </label>
                  <jcaptcha:jpeg name="captchaImage" alt="captcha" />
                  <input type="text" id="captchaText" name="captchaText"
                    class="required ${invalidFields.contains('captchaText') ? 'validation-failed' : ''}"
                    title="${message(code:'request.step.validation.error.captcha')}" />
                </fieldset>
                <p style="text-align: center;">
                  <input type="submit" value="${message(code:'homeFolder.action.createAccountAndContinue')}" style="font-size:1.2em;" />
                </p>
%{--              </div>--}%
          </div>
        </form>
      </div>
      <div  class="steps">
        <ul>
          <li class="">
            Pourquoi créer un compte ?
            <p class="help">
              ${message(code:'homeFolder.message.createAccount')}
            </p>
          </li>
          <li>
          Quels avantages ?
          <p class="help">Gérer vos données administratives et déclarer les membres de votre foyer</p>
          <p class="help">Accéder à des démarches en ligne pour vous ou un membre de votre foyer</p>
          <p class="help">Suivre l'avancement de vos demandes</p>
          </li>
        <ul>
      </div>  
    </div>
  </body>
</html>
