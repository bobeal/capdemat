<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css"
          href="${resource(dir:'css/frontoffice', file:'dashboard.css')}" />
  </head>
  <body>
    <div class="confirmation-box">
      <h2><g:message code="request.header.deleteDraft" args="${[rqt.label,rqt.id]}"/></h2>
      <p><g:message code="request.message.draftRemovalConfirmationMessage"/></p>
      <p><g:message code="request.message.draftRemovalConfirmationWarning"/></p>
      <form method="post">
        <input type="hidden" name="id" value="${rqt.id}" />
        <input type="submit" name="confirm" value="${message(code:'action.confirm')}" />
        <a href="${module.createLink(module:'frontoffice',controller:'Home')}">
          <g:message code="action.cancel"/>
        </a>
      </form>
    </div>
  </body>
</html>
