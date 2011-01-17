<html>
  <head>
    <title>${message(code:'payment.title.details')}</title>
    <meta name="layout" content="fo_main"/>
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css/frontoffice', file: 'payment.css')}"/>
  </head>
  <body>
    <div id="yui-main">
      <div id="main" class="yui-b">
        <div class="list-box">
          <h2><g:message code="payment.property.items.details" /></h2>
            <g:if test="${!invoices.isEmpty()}">
                <h3><g:message code="payment.header.invoices" /></h3>
                <ul>
                  <g:each var="record" in="${invoices}">
                    <li>
                      <h3>${record.label} - <g:message code="payment.item.property.invoiceId" /> ${record.id}</h3>
                      <p>
                        <g:message code="payment.property.amount" /> : ${(record.amount / 100).floatValue()} €
                        - <g:message code="payment.header.issueAt" /> <g:formatDate formatName="format.date" date="${record.issueDate}"/>
                      </p>
                    </li>
                  </g:each>
                </ul>
            </g:if>
            <g:if test="${!deposits.isEmpty()}">
                <h3><g:message code="payment.header.depositAccounts" /></h3>
                <ul>
                  <g:each var="record" in="${deposits}">
                    <li>
                      <h3><g:message code="payment.header.account" /> "${record.label}"</h3>
                      <p>
                        <g:message code="payment.item.property.deposit" /> : ${(record.amount / 100).floatValue()} €
                        - <g:message code="payment.item.property.oldValue" /> : ${(record.oldValue / 100).floatValue()} €
                      </p>
                    </li>
                  </g:each>
                </ul>
            </g:if>
            <g:if test="${!contracts.isEmpty()}">
                <h3><g:message code="payment.header.ticketingContracts" /></h3>
                <ul>
                  <g:each var="record" in="${contracts}">
                    <li>
                      <h3><g:message code="payment.header.account" /> "${record.label}"</h3>
                      <p>
                        <g:message code="payment.header.purchaseOfTickets" 
                        args="${[record.quantity,(record.unitPrice/100),(record.amount/100)]}"/>
                      </p>
                    </li>
                  </g:each>
                </ul>
            </g:if>
        </div>
      </div>
    </div>
    <!-- end of yui-main -->
    <div class="yui-b">
      <g:render template="cart"/>
      <div id="requestSubject" class="narrow-box">
        <h3>
          <g:message code="header.display"/>
        </h3>
        <div class="body">
          <a class="top-link" href="${createLink(action: 'index')}">
            <g:message code="payment.header.accountStatus"/>
          </a>
        </div>
      </div>
    </div>
  </body>
</html>