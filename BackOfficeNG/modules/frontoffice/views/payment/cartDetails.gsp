<html>
  <head>
    <meta name="layout" content="fo_main"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'payment.css')}" />
  </head>
  <body>
  <div id="yui-main">
    <div id="main" class="yui-b">
      <div class="list-box">
        <h2><g:message code="payment.header.cartDetails"/></h2>
        <ul>
          <g:each in="${items}" var="${record}">
            <li>
              <p>
                <span class="payment-form" style="float:right">
                  <form id="invoceForm_${record.externalItemId}" method="post" action="${createLink(action:'removeCartItem')}">
                    <input type="submit" value="${message(code:'action.delete')}" />
                    <input type="hidden" name="externalItemId" value="${record.externalItemId}"/>
                    <input type="hidden" name="type" value="${record.type}"/>
                  </form>
                </span>
              </p>
              <g:if test="${record.type == 'invoices'}">
                <p>${record.label} - réf ${record.externalItemId}</p>
                <p>${record?.amount ? 'pour '+record.amount / 100 + ' €':''}</p>
                <p>
                  crée le <g:formatDate date="${record.issueDate}" formatName="format.date"/>
                  expire le <g:formatDate date="${record.expirationDate}" formatName="format.date"/>
                </p>
              </g:if>
              <g:elseif test="${record.type == 'depositAccounts'}">
                <p>${record.label} - réf ${record.externalItemId}</p>
                <p>${record?.amount ? 'pour '+record.amount / 100+' €':''}</p>
                <p>fait le <g:formatDate date="${record.oldValueDate}" formatName="format.date"/></p>
              </g:elseif>
              <g:elseif test="${record.type == 'ticketingContracts'}">
                <p>${record.label} pour ${record.subjectName} - réf ${record.externalItemId}</p>
                <p>${record.quantity} ticket(s) (${record.unitPrice / 100} € / piece) pour ${record.amount / 100} €</p>
                <p>crée le <g:formatDate date="${record.creationDate}" formatName="format.date"/></p>
              </g:elseif>
            </li>
          </g:each>
        </ul>
      </div>
    </div>
  </div>
  <!-- end of yui-main -->
  <div id="narrow" class="yui-b">
    <div class="requestBox action-list">
      <h3>
        <g:message code="payment.property.payment" />
      </h3>
      <div class="body">
        <p>Total items: ${session.payment?.purchaseItems?.size()}</p> 
        <p>Total cout : ${session.payment?.amount / 100} € </p>
        <div class="button-panel">
          <form action="${createLink(action:'pay')}" method="post">
            <input type="submit" value="${message(code:'action.pay')}" />
            <input type="hidden" name="callbackUrl" value="${paymentUrl}" />
          </form>
        </div>
      </div>
    </div>
    <div class="requestBox">
      <h3>
        <g:message code="header.display" />
      </h3>
      <div class="body">
        <a class="top-link" href="${createLink(action:'index')}">
          <g:message code="payment.header.accountStatus" />
        </a>
      </div>
    </div>
  </div>
  <!-- end of narrow -->
  </body>
</html>