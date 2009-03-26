 <g:if test="${isRequestCreation}">
   <div id="main-menu">
     <a class="disable"><span><g:message code="menu.accounts" /></span></a>
   </div>
 </g:if>
 <g:elseif test="${!isLogin}">
   <div id="main-menu">
     <a href="${createLink(controller:'frontofficeHomeFolder')}" 
        class="${menu.current(elem:'homefolder')}" >
        <span>
          <g:message code="menu.accounts" />
        </span>
     </a>
   </div>
 </g:elseif>