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
                <p>
                  <g:message code="payment.header.invoice"/>
                  ${record.label} <g:message code="message.of"/> ${record.amount ? record.amount / 100 + ' €':''}
                  (<g:message code="message.ref"/> ${record.externalItemId})
                </p>
                <p>
                  <g:message code="payment.header.issueAt"/>
                  <g:formatDate date="${record.issueDate}" formatName="format.date"/> - 
                  <g:message code="payment.header.expireAt"/>
                  <g:formatDate date="${record.expirationDate}" formatName="format.date"/>
                </p>
              </g:if>
              <g:elseif test="${record.type == 'depositAccounts'}">
                <p>
                  <g:message code="payment.header.account"/> ${record.label} 
                  (<g:message code="message.ref"/> ${record.externalItemId})
                </p>
                <p>
                  <g:message code="payment.header.depositOf"/>
                  ${record.amount ? record.amount / 100 + ' €':''}
                </p>
              </g:elseif>
              <g:elseif test="${record.type == 'ticketingContracts'}">
                <p>
                  <g:message code="payment.header.account"/> 
                  ${record.label} <g:message code="message.of"/> ${record.subjectName} 
                  (<g:message code="message.ref"/> ${record.externalItemId})
                </p>
                <p>
                  <g:message code="payment.header.purchaseOfTickets" 
                    args="${[record.quantity,record.unitPrice / 100,record.amount / 100]}" />
                </p>
              </g:elseif>
            </li>
          </g:each>
        </ul>
      </div>
    </div>
  </div>
  <!-- end of yui-main -->
  <g:render template="cart"/>
  <div id="narrow" class="yui-b">
    <div class="narrow-box">
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