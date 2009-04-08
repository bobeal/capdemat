 <g:if test="${isRequestCreation}">
   <div id="main-menu">
     <a class="disable"><span><g:message code="menu.home" /></span></a>
     <a class="disable"><span><g:message code="menu.services" /></span></a>
     <a class="disable"><span><g:message code="menu.accounts" /></span></a>
     <a class="disable"><span><g:message code="menu.requests" /></span></a>
     <a class="disable"><span><g:message code="menu.documents" /></span></a>
     <a class="disable"><span><g:message code="menu.activities" /></span></a>
     <a class="disable"><span><g:message code="menu.payments" /></span></a>
   </div>
 </g:if>
 <g:elseif test="${!isLogin}">
   <div id="main-menu">
     <a href="${createLink(controller:'frontofficeHome')}" 
        class="${menu.current(elem:'home')}" >
        <span>
          <g:message code="menu.home" />
        </span>
     </a>
     <a href="${createLink(controller:'frontofficeRequestType')}" 
        class="${menu.current(elem:'requesttype')}" >
        <span>
          <g:message code="menu.services" />
        </span>
     </a>
     <a href="${createLink(controller:'frontofficeHomeFolder')}" 
        class="${menu.current(elem:'homefolder')}" >
        <span>
          <g:message code="menu.accounts" />
        </span>
     </a>
     <a href="${createLink(controller:'frontofficeRequest')}" 
       class="${menu.current(elem:'request')}">
       <span>
         <g:message code="menu.requests" />
       </span>
     </a>
     <a href="${createLink(controller:'frontofficeDocument')}" 
        class="${menu.current(elem:'document')}">
        <span>
          <g:message code="menu.documents" />
        </span>
     </a>
     <a href="${createLink(controller:'frontofficeActivity')}" 
        class="${menu.current(elem:'activity')}">
        <span>
          <g:message code="menu.activities" />
        </span>
     </a>
     <a href="${createLink(controller:'frontofficePayment')}" 
        class="${menu.current(elem:'payment')}" >
        <span>
          <g:message code="menu.payments" />
        </span>
     </a>
   </div>
 </g:elseif>