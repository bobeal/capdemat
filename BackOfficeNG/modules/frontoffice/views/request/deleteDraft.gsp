<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css"
          href="${createLinkTo(dir:'css/frontoffice', file:'dashboard.css')}" />
  </head>
  <body>
    <div class="confirm-box">
      <h2><g:message code="request.header.deleteDraft"
                     args="${[request.label,request.id]}"/></h2>
      <p class="confirm-message">
        <g:message code="request.message.draftRemovalConfirmationMessage"/>
      </p>
      <p class="confirm-warning">
        <span><g:message code="request.message.draftRemovalConfirmationWarning"/></span>
      </p>
      <div class="confirm-form">
        <form method="post">
          <input type="hidden" name="id" value="${request.id}" />
          <input type="submit" name="confirm" value="${message(code:'action.confirm')}" />
          <a href="${module.createLink(module:'frontoffice',controller:'Home')}">
            <g:message code="action.cancel"/>
          </a>
        </form>
      </div>
    </div>
  </body>
</html>
