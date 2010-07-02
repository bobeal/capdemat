<div id="menu">
  <g:if test="${!isLogin}">
    <a href="${createLink(controller:'frontofficeHome')}" class="${menu.current(elem:'home')}" accesskey="1">
      <span><g:message code="menu.home" /></span>
    </a>
  </g:if>
</div>
