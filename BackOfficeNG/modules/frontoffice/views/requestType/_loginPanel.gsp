<div class="information-box outOfAccount-login-box">
  <p>${message(code:'account.message.useAccountToFillRequest')}</p>
  <form method="post" action="${createLink(controller : 'frontofficeHome', action:'login')}">
    <g:if test="${flash.loginError}">
      <p class="error">${flash.loginError}</p>
    </g:if>
    <label for="login"><g:message code="account.property.login"/></label>
    <input type="text" id="login" name="login" class="text" />
    <label for="password"><g:message code="account.property.password"/></label>
    <input type="password" id="password" name="password" class="text" />
    <input type="submit" value="${message(code:'action.login')}" />
    <input type="hidden" name="requestTypeLabel" class="hidden" value="${requestTypeLabel}" />
  </form>
</div>
