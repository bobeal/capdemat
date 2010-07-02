 <g:if test="${!isLogin}">
   <div id="menu">
     <a href="${createLink(controller:'frontofficeRequestType')}" 
        class="${menu.current(elem:'requesttype')}" accesskey="1">
        <span>
          <g:message code="menu.services" />
        </span>
     </a>
   </div>
 </g:if>
