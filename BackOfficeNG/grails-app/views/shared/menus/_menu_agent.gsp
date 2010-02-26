 <g:if test="${isRequestCreation}">
   <div id="menu">
     <a class="disable"><span><g:message code="menu.services" /></span></a>
   </div>
 </g:if>
 <g:elseif test="${!isLogin}">
   <div id="menu">
     <a href="${createLink(controller:'frontofficeRequestType')}" 
        class="${menu.current(elem:'requesttype')}" accesskey="1">
        <span>
          <g:message code="menu.services" />
        </span>
     </a>
   </div>
 </g:elseif>
