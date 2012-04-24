<div id="hd">
  <div class="top">
    <g:if test="${session.currentCredentialBean?.ecitizen && !(session.currentCredentialBean.ecitizen.homeFolder.temporary)}">
      <em>${session.currentEcitizenName}</em> <a class="menu" href="${createLink(controller:'frontofficeHome', action:session.proxyAgent ? 'logoutAgent': 'logout')}">${message(code:'action.logout')}</a>
    </g:if>
    <g:elseif test="${isLogin}">
      <form action="${createLink(controller:'frontofficeHome', action:'login')}" method="post">
        <g:if test="${error}"><p class="error">${error}</p></g:if>
        <label for="login">${message(code:'account.property.login')}</label>
        <input type="text" class="text" name="login" id="login"/>
        <label for="password">${message(code:'account.property.password')}</label>
        <input type="password" class="text" name="password" id="password"/>
        <input type="submit" class="button" value="${message(code:'action.login')}"/>
        <a href="${createLink(controller:'frontofficeHomeFolder', action:'resetPassword')}">${message(code:'account.message.forgottenPassword')}</a>
      </form>
    </g:elseif>
    <a href="${createLink(controller:'localAuthorityResource', action:'resource', id:'helpFo')}" class="menu" target="blank">${message(code:'menu.help')}</a>
    <a href="${createLink(controller:'localAuthorityResource', action:'resource', id:'faqFo')}" class="menu" target="blank">${message(code:'menu.faq')}</a>
  </div>
</div>
