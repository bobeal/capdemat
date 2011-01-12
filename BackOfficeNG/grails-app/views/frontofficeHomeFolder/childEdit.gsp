<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <script type="text/javascript" src="${resource(dir:'js/frontoffice',file:'homeFolder.js')}"></script>
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'data-detail.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <style type="text/css">
      #request .datas form {padding-top: 1em;}
      #request .steps p.help { margin-bottom: .5em; font-style: italic;}
      #request form div p.error { text-align: left; }
    </style>
  </head>
  <body>
    <div id="request" class="main-box">
      <h2>
        <a href="${createLink(action : 'index')}" class="button">${message(code:'action.cancel')}</a>
        <g:if test="${child.id}">
          <g:if test="${!child.isChildBorn}">
            <g:message code="request.subject.childNoBorn" args="${[child.fullName]}" />
          </g:if>
          <g:else>
            ${child.firstName} ${child.lastName}
          </g:else>
          <span>${message(code:'homeFolder.header.modifyChildInformations')}</span>
        </g:if>
        <g:else>
          ${message(code:'homeFolder.header.createChild')}
        </g:else>
      </h2>
      <div class="datas">
        <form action="${createLink(controller : 'frontofficeHomeFolder', action:'child')}" method="post" class="${invalidFields && !invalidFields.isEmpty() ? 'invalid' : 'uncomplete'}">
          <input type="hidden" name="requestId" value="${params.requestId}" />
          <g:render template="childCommonFields" />
          <p style="text-align: center; font-size: 1.3em;">
            <g:if test="${child.id}">
              <input type="submit" value="${message(code:'action.modify')}" />
            </g:if>
            <g:else>
              <input type="submit" value="${message(code:'action.create')}" />
            </g:else>
          </p>
        </form>
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
