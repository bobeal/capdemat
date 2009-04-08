 <g:if test="${isRequestCreation}">
   <div id="main-menu">
     <a class="disable"><span><g:message code="menu.services" /></span></a>
   </div>
 </g:if>
 <g:elseif test="${!isLogin}">
   <div id="main-menu">
     <a href="${createLink(controller:'frontofficeRequestType')}" 
        class="${menu.current(elem:'requesttype')}" >
        <span>
          <g:message code="menu.services" />
        </span>
     </a>
   </div>
 </g:elseif>