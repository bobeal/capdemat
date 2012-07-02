<%
accesskey = 0
%>
<div id="menu">
  <a href="${createLink(controller : 'frontofficeHome')}"
    class="${menu.current(elem : 'home')}" accesskey="${accesskey++}">
    <span>
      <g:message code="menu.home" />
    </span>
  </a>
  <a href="${createLink(controller : 'frontofficeRequestType')}"
    class="${menu.current(elem : 'requesttype')}" accesskey="${accesskey++}">
    <span>
      <g:message code="menu.services" />
    </span>
  </a>
  <a href="${createLink(controller : 'frontofficeHomeFolder')}"
    class="${menu.current(elem : 'homefolder') ? menu.current(elem : 'homefolder') : menu.current(elem : 'homefolderDocument')}" accesskey="${accesskey++}">
    <span>
      <g:message code="menu.accounts" />
    </span>
  </a>
  <a href="${createLink(controller : 'frontofficeRequest')}"
    class="${menu.current(elem : 'request') ? menu.current(elem : 'request') : menu.current(elem : 'requestDocument')}" accesskey="${accesskey++}">
    <span>
      <g:message code="menu.requests" />
    </span>
  </a>
  <a href="${createLink(controller : 'frontofficeDocument')}"
    class="${menu.current(elem : 'document')}" accesskey="${accesskey++}">
    <span>
      <g:message code="menu.documents" />
    </span>
  </a>
  <g:if test="${session.supportsActivitiesTab}">
    <a href="${createLink(controller : 'frontofficeActivity')}"
      class="${menu.current(elem : 'activity')}" accesskey="${accesskey++}">
      <span>
        <g:message code="menu.activities" />
      </span>
    </a>
  </g:if>
  <g:if test="${session.supportsPaymentsTab}">
    <a href="${createLink(controller : 'frontofficePayment')}"
      class="${menu.current(elem : 'payment')}" accesskey="${accesskey++}">
      <span>
        <g:message code="menu.payments" />
      </span>
    </a>
  </g:if>
</div>
