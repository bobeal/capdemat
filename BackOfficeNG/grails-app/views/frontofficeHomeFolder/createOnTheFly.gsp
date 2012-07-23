<html>
  <head>
    <title>${message(code:'homeFolder.title.creation')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <style type="text/css">
      #request .steps p.help { margin-bottom: .5em; font-style: italic;}
      #request .datas form { padding: 1em 0; }
      #request .datas form div p.error { text-align: left; }
      #request .datas form p { padding-left: 0; font-style: italic; }
    </style>
    <script type="text/javascript" src="${resource(dir : 'js/frontoffice', file : 'homeFolderCreation.js')}"></script>
    <g:if test="${flash.addressesReferentialEnabled}">
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css/common', file:'autocomplete.css')}" />
      <script type="text/javascript">
        zenexity.capdemat.contextPath = "${request.contextPath}";
      </script>
      <script type="text/javascript" src="${resource(dir:'js/common',file:'addressAutocomplete.js')}"></script>
      <script type="text/javascript" src="${resource(dir:'js/common',file:'autocomplete.js')}"></script>
    </g:if>
  </head>
  <body>
    <div id="request" class="main-box">
      <h2>
        <g:if test="${params.requestTypeLabel}">
          <g:if test="${!temporary}">
            <a href="${createLink(controller:'frontofficeHome')}" class="button">${message(code:'action.quit')}</a>
          </g:if>
          <g:translateRequestTypeLabel label="${params.requestTypeLabel}" />
          <g:if test="${!temporary}">
            <span>${message(code:'homeFolder.action.createAccount')}</span>
          </g:if>
          <g:else>
            <span>${message(code:'homeFolder.action.createTemporaryAccount')}</span>
          </g:else>
        </g:if>
        <g:else>
          ${message(code:'homeFolder.action.createAccount')}
        </g:else>
      </h2>
      <div class="datas">
        <div class="${flash.invalidFields?.any() ? 'invalid' : 'uncomplete'} form">
          <g:render template="/frontofficeHomeFolder/create/responsible"
            model="[ 'submitCode' : temporary ? 'homeFolder.action.createTemporaryAccountAndContinue' : 'homeFolder.action.createAccountAndContinue' ]" />
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
      <g:else>
        <div class="steps">
          <ul>
            <li class="">
              ${message(code:'homeFolder.message.whatTemporaryAccount')}
              <p class="help">
                ${message(code:'homeFolder.message.createTemporaryAccount')}
              </p>
            </li>
            <li>
              ${message(code:'homeFolder.message.whatFollowRequest')}
              <p class="help">
                ${message(code:'homeFolder.message.followRequestAdvantage')}
              </p>
            </li>
          </ul>
        </div>
      </g:else>
    </div>
  </body>
</html>
