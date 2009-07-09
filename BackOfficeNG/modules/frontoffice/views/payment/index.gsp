<html>
  <head>
    <meta name="layout" content="fo_main"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'payment.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice', file:'payment.js')}"></script>
  </head>
  <body>
    <g:if test="${displayedMessage}">
      <div class="information-box">${displayedMessage}</div>
    </g:if>
    <g:else>
  <div id="yui-main">
    <div id="main" class="yui-b">
      <g:if test="${!invoices.isEmpty()}">
      <div class="list-box">
        <h2><g:message code="payment.header.invoices"/></h2>
        <g:render template="invoices"/>
      </div>
      </g:if>
      <g:if test="${!depositAccounts.isEmpty()}">
      <div class="list-box">
        <h2><g:message code="payment.header.depositAccounts"/></h2>
        <g:render template="depositAccounts"/>
      </div>
      </g:if>
      <g:if test="${!ticketingContracts.isEmpty()}">
      <div class="list-box">
        <h2><g:message code="payment.header.ticketingContracts"/></h2>
        <g:render template="ticketingContracts"/>
      </div>
      </g:if>
      <g:if test="${invoices.isEmpty() && depositAccounts.isEmpty() && ticketingContracts.isEmpty()}">
		<div class="information-box">
	  	  <g:message code="payment.message.noElementsToPay" />
		</div>
      </g:if>
    </div>
  </div>
  <!-- end of yui-main -->

  <g:render template="cart"/>
  </g:else>
  <div id="narrow" class="yui-b">
    <div class="narrow-box">
      <h3>
        <g:message code="header.display"/>
      </h3>
      <div class="body">
        <a class="top-link" href="${createLink(action: 'history')}">
          <g:message code="payment.header.paymentsHistory"/>
        </a>
      </div>
    </div>
  </div>
  <!-- end of narrow -->
  </body>
</html>

