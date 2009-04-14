<div class="login-box request-login-box">
  <h2 class="request-creation">${message(code:'account.message.useAccountToFillRequest')}</h2>
  <form id="loginForm" method="post" action="${createLink(controller : 'frontofficeHome', action:'login')}">
    <g:if test="${error}">
      <div class="login-error">${error}</div>
    </g:if>
    <label for="login"><g:message code="account.property.login"/></label>
    <input type="text" id="login" name="login" style="width: 50%;"/>
    <label for="password"><g:message code="account.property.password"/></label>
    <input type="password" id="password" name="password" style="width: 50%;"/>
    <input type="submit" value="${message(code:'action.login')}" />
    <input type="hidden" name="requestTypeLabel" class="hidden" value="${requestTypeLabel}" />
  </form>
</div>
