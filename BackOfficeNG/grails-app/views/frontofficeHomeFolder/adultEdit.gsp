<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'data-detail.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <style type="text/css">
      #request .datas form { padding: 1em 0; }
      #request .steps p.help { margin-bottom: .5em; font-style: italic;}
      #request form div p.error { text-align: left; }
    </style>
  </head>
  <body>
    <div id="request" class="main-box">
      <h2>
        <a href="${createLink(action : 'index')}" class="button">${message(code:'action.cancel')}</a>
        <g:if test="${adult.id}">
          ${adult.firstName} ${adult.lastName}
          <span>${message(code:'homeFolder.header.modifyAdultInformations')}</span>
        </g:if>
        <g:else>
          ${message(code:'homeFolder.header.createAdult')}
        </g:else>
      </h2>
      <div class="datas">
        <div class="${invalidFields && !invalidFields.isEmpty() ? 'invalid' : 'uncomplete'} form">
        <form action="${createLink(controller : 'frontofficeHomeFolder', action:'adult')}" method="post">
          <input type="hidden" name="requestId" value="${params.requestId}" />
          <g:render template="adultCommonFields" />
          <p style="text-align: center; font-size: 1.3em;">
            <g:if test="${adult.id}">
              <input type="submit" value="${message(code:'action.modify')}" />
            </g:if>
            <g:else>
              <input type="submit" value="${message(code:'action.create')}" />
            </g:else>
          </p>
        </form>
        </div>
      </div>
     <div  class="steps">
        <ul>
          <li>
            ${message(code:'homeFolder.message.whenModifyAccount')}
            <p class="help">
              ${message(code:'homeFolder.message.whenModifyAccount1')}
            </p>
            <p class="help">
              ${message(code:'homeFolder.message.whenModifyAccount2')}
            </p>
          </li>
          <li>
            ${message(code:'homeFolder.message.accountModificationInstruction')}
            <p class="help">${message(code:'homeFolder.message.accountModificationInstruction1')}</p>
          </li>
        <ul>
      </div>
    </div>
  </body>
</html>
