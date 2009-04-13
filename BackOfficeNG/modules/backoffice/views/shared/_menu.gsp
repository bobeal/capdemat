<h1><a class="logo">CapDémat</a></h1>
<div id="userInfo">
  ${session.currentUser} 
  - <a href="${createLinkTo(dir:'',file:'casLogout.gsp')}"><g:message code="action.logout" /></a>
  - <a href="${createLink(controller:'localAuthorityResource',action:'pdf',id:'helpBo')}"
       target="blank"><g:message code="header.help" /></a>
</div>
<div id="menu">
  <g:if test="${session.currentCredentialBean.hasSiteAgentRole()}">
    <a id="taskBoardMenuItem" href="<g:createLink controller='backofficeRequest' action='taskBoard' />">
      <g:message code="menu.taskBoard" />
    </a>
    <a id="requestMenuItem" href="<g:createLink controller='backofficeRequest'/>">
      <g:message code="menu.search" />
    </a>
    <a id="statisticsMenuItem" href="<g:createLink controller='backofficeStatistic'/>">
      <g:message code="menu.statistics" />
    </a>
    <a id="requestTypeMenuItem" href="<g:createLink controller='backofficeRequestType'/>">
      <g:message code="menu.requestTypes" />
    </a>
  </g:if>
  <g:if test="${session.currentCredentialBean.hasSiteAdminRole()}">
    <a id="localAuthorityMenuItem" href="<g:createLink controller='backofficeLocalAuthority'/>">
      <g:message code="menu.localAuthority" />
    </a>
    <a id="categoryMenuItem" href="<g:createLink controller='backofficeCategory'/>">
      <g:message code="menu.categories" />
    </a>
    <a id="paymentMenuItem" href="<g:createLink controller='backofficePayment'/>">
      <g:message code="menu.payments" />
    </a>
    <a id="userMenuItem" href="<g:createLink controller='backofficeUser'/>">
      <g:message code="menu.users" />
    </a>
  </g:if>
</div>

