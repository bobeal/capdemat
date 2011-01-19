<html>
  <head>
    <title>${message(code : "home.portal.title", args : [session.currentSiteDisplayTitle])}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <style type="text/css">
      .main-box ul    { padding: 0 1em 1em 1.5em; font-size: 1.1em; font-style: italic; }
      .main-box ul li { list-style-type: disc; }
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
        <form action="${createLink(controller : 'frontofficeHome', action : 'login')}" method="post">
          <input type="hidden" name="targetURL"
            value="${createLink(controller : 'frontofficeRequestType', action : 'start', id : params.requestTypeLabel)}" />
          <input type="hidden" name="errorURL"
            value="${createLink(controller : 'frontofficeRequestType', action : 'login', params : ['requestTypeLabel' : params.requestTypeLabel])}" />
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
        </form>
      </div>
      <div class="yui-u main-box">
        <h2>${message(code:'homeFolder.action.createAccount')}</h2>
          <p>${message(code:'homeFolder.message.accountAdvantage0')}:</p>
          <ul>
            <li>${message(code:'homeFolder.message.accountAdvantage1')}</li>
            <li>${message(code:'homeFolder.message.accountAdvantage2')}</li>
            <li>${message(code:'homeFolder.message.accountAdvantage3')}</li>
          </ul>
          <p>
            <a style="font-size: 1.5em;" href="${createLink(controller : 'frontofficeHomeFolder', action : 'create',
              params : ['requestTypeLabel' : params.requestTypeLabel])}">
              ${message(code:'homeFolder.action.wishCreateAccount')}
            </a>
          </p>
      </div>
    </div>
  </body>
</html>
