<html>
  <head>
    <title>${message(code:'payment.title')}</title>
    <meta name="layout" content="fo_main"/>
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'payment.css')}" />
    <script type="text/javascript" src="${resource(dir:'js/frontoffice', file:'payment.js')}"></script>
  </head>
  <body>
    <div id="yui-main">
      <div id="main" class="yui-b">
        <g:if test="${displayedMessage}">
          <div class="information-box">${displayedMessage}</div>
        </g:if>
        <g:else>
          <g:if test="${!invoices.isEmpty()}">
            <div id="invoices" class="list-box">
              <h2><g:message code="payment.header.invoices"/></h2>
              <g:render template="invoices"/>
            </div>
          </g:if>
          <g:if test="${!depositAccounts.isEmpty()}">
            <div id="depositAccounts" class="list-box">
              <h2><g:message code="payment.header.depositAccounts"/></h2>
              <g:render template="depositAccounts"/>
            </div>
          </g:if>
          <g:if test="${!ticketingContracts.isEmpty()}">
            <div id="ticketingContracts" class="list-box">
              <h2><g:message code="payment.header.ticketingContracts"/></h2>
              <g:render template="ticketingContracts" />
            </div>
          </g:if>
          <g:if test="${invoices.isEmpty() && depositAccounts.isEmpty() && ticketingContracts.isEmpty()}">
            <div class="information-box">
              <g:message code="payment.message.noElementsToPay" />
            </div>
          </g:if>
        </g:else>
      </div>
    </div>
    <!-- end of yui-main -->
    <div id="narrow" class="yui-b">
      <g:if test="${!displayedMessage}">
        <g:render template="cart"/>
      </g:if>
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
