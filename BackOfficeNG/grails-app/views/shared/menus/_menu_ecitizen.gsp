<div id="menu">
  <a href="${createLink(controller : 'frontofficeHome')}"
    class="${menu.current(elem : 'home')}" accesskey="0">
    <span>
      <g:message code="menu.home" />
    </span>
  </a>
  <a href="${createLink(controller : 'frontofficeHomeFolder')}"
    class="${menu.current(elem : 'homefolder') ? menu.current(elem : 'homefolder') : menu.current(elem : 'homefolderDocument')}" accesskey="2">
    <span>
      <g:message code="menu.accounts" />
    </span>
  </a>
  <a href="${createLink(controller : 'frontofficeRequest')}"
    class="${menu.current(elem : 'request')}" accesskey="3">
    <span>
      <g:message code="menu.requests" />
    </span>
  </a>
  <a href="${createLink(controller : 'frontofficeDocument')}"
    class="${menu.current(elem : 'document')}" accesskey="4">
    <span>
      <g:message code="menu.documents" />
    </span>
  </a>
  <g:if test="${session.supportsActivitiesTab}">
    <a href="${createLink(controller : 'frontofficeActivity')}"
      class="${menu.current(elem : 'activity')}" accesskey="5">
      <span>
        <g:message code="menu.activities" />
      </span>
    </a>
  </g:if>
  <g:if test="${session.supportsPaymentsTab}">
    <a href="${createLink(controller : 'frontofficePayment')}"
      class="${menu.current(elem : 'payment')}" accesskey="6">
      <span>
        <g:message code="menu.payments" />
      </span>
    </a>
  </g:if>
</div>
