<html>
  <head>
    <meta name="layout" content="fo_main"/>
  </head>
  <body>
  <div id="yui-main">
    <div id="main" class="yui-b">
      <div class="list-box">
        <h2><g:message code="payment.header.paymentDetails"/></h2>
        <ul>
          <g:each in="${items}" var="${record}">
            <li>
              <p>
                <span class="payment-form" style="float:right">
                  <form id="invoceForm_${record.reference}" method="post" action="${createLink(action:'removeCartItem')}"> 
                    <button type="submit" title="${message(code:'action.removeCartItem')}">
                      <img src="${createLinkTo(dir:'images',file:'delete.png')}" 
                        alt="${message(code:'action.removeCartItem')}" />
                    </button>
                    <input type="hidden" name="externalItemId" value="${record.reference}"/>
                    <input type="hidden" name="type" value="${record.type}"/>
                  </form>
                </span>
              </p>
              <g:if test="${record.type == 'invoices'}">
                <p>${record.label} - réf ${record.reference}</p>
                <p>${record?.amount ? 'pour '+record.amount / 100 + ' €':''}</p>
                <p>
                  crée le <g:formatDate date="${record.issueDate}" formatName="format.date"/>
                  expire le <g:formatDate date="${record.expirationDate}" formatName="format.date"/>
                </p>
              </g:if>
              <g:elseif test="${record.type == 'depositAccounts'}">
                <p>${record.label} - réf ${record.reference}</p>
                <p>${record?.amount ? 'pour '+record.amount / 100+' €':''}</p>
                <p>fait le <g:formatDate date="${record.oldValueDate}" formatName="format.date"/></p>
              </g:elseif>
              <g:elseif test="${record.type == 'ticketingContracts'}">
                <p>${record.label} pour ${record.subjectName} - réf ${record.reference}</p>
                <p>${record.quantity} ticket(s) (${record.unitPrice / 100} € / piece) pour ${record.amount / 100} €</p>
                <p>crée le <g:formatDate date="${record.creationDate}" formatName="format.date"/></p>
              </g:elseif>
            </li>
          </g:each>
        </ul>
      </div>
      <p>
        <a href="${paymentUrl}" target="_self">GO</a>
      </p>
    </div>
  </div>
  <!-- end of yui-main -->
  <div id="narrow" class="yui-b">
    <div id="requestSubject" class="requestBox">
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