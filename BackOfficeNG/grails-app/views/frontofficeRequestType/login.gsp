<html>
  <head>
    <title>${message(code : "home.portal.title", args : [session.currentSiteDisplayTitle])}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <style type="text/css">
      .main-box ul    { padding: 0 1em 1em 1.5em; font-size: 1.1em; font-style: italic; }
      .main-box ul li { list-style-type: disc; }
      .warning { font-size: 1.2em; color: #FF4907; margin: 5px 0;}
    </style>
  </head>
  <body>
    <g:if test="${flash.errorMessage}">
      <div class="error-box">
        <p>${flash.errorMessage}</p>
      </div>
    </g:if>
    <div class="yui-g">
      <div class="yui-u first main-box">
        <h2>${message(code:'account.message.useAccountToFillRequest')}</h2>
        <p class="warning">${message(code :'account.message.localAuthorityInformation')}</p>
        <form action="${createLink(controller : 'frontofficeHome', action : 'login')}" method="post">
          <input type="hidden" name="callback" value="${params.callback}" />
          <input type="hidden" name="errorURL"
            value="${createLink(controller : 'frontofficeRequestType', action : 'login', params : ['requestTypeLabel' : params.requestTypeLabel, 'callback' : params.callback])}" />
          <label for="login" class="required">
            ${message(code:'homeFolder.adult.property.login')}
          </label>
          <input type="text" id="login" name="login" value="" class="required"
            title="${message(code:'homeFolder.adult.property.login.validationError')}" />
          <label for="password" class="required">
            ${message(code:'homeFolder.adult.property.password')}
          </label>
          <input type="password" id="password" name="password" value="" class="required"
            title="${message(code:'homeFolder.adult.property.password.validationError')}" />
          <input type="submit" value="${message(code:'action.login')}" />
          <a href="${createLink(controller:'frontofficeHomeFolder', action:'resetPassword')}">
            ${message(code:'account.message.forgottenPassword')}
          </a>
        </form>
      </div>
      <div class="yui-u main-box">
        <g:if test="${temporary}">
          <h2>${message(code : "account.message.noAccount")}</h2>
          <p>${message(code : "homeFolder.message.outOfAccount0")}&nbsp;:</p>
          <ul>
            <li>${message(code : "homeFolder.message.outOfAccount1")}</li>
            <li>${message(code : "homeFolder.message.outOfAccount2")}</li>
          </ul>
          <p>
            <a style="font-size: 1.5em;"
              href="${createLink(controller : 'frontofficeHomeFolder', action : 'create',
                params : ['requestTypeLabel' : params.requestTypeLabel])}">
              ${message(code:'action.begin')}
            </a>
          </p>
        </g:if>
        <g:else>
          <h2>${message(code:'homeFolder.action.createAccount')}</h2>
          <p>${message(code:'homeFolder.message.accountAdvantage0')}:</p>
          <ul>
            <li>${message(code:'homeFolder.message.accountAdvantage1')}</li>
            <li>${message(code:'homeFolder.message.accountAdvantage2')}</li>
            <li>${message(code:'homeFolder.message.accountAdvantage3')}</li>
          </ul>
          <p class="warning">${message(code:'homeFolder.message.createAccount.warning')}</p>
          <p>
            <a style="font-size: 1.5em;" href="${createLink(controller : 'frontofficeHomeFolder', action : 'create',
              params : ['requestTypeLabel' : params.requestTypeLabel] + params)}">
              ${message(code:'homeFolder.action.wishCreateAccount')}
            </a>
          </p>
        </g:else>
      </div>
    </div>
  </body>
</html>
