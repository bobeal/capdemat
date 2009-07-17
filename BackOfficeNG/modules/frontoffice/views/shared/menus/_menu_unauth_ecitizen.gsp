<div id="menu">
  <g:if test="${isRequestCreation}">
     <a class="disable"><span><g:message code="menu.home" /></span></a>
  </g:if>
  <g:elseif test="${!isLogin}">
    <a href="${createLink(controller:'frontofficeHome')}" class="${menu.current(elem:'home')}" >
      <span><g:message code="menu.home" /></span>
    </a>
  </g:elseif>
</div>
