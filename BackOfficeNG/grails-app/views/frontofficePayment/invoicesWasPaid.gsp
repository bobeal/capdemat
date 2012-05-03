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
          <g:if test="${!invoicesPaid.isEmpty()}">
            <div id="invoices" class="list-box">
              <h2><g:message code="payment.header.invoices.paid"/></h2>
              <g:render template="invoicesPaid"/>
            </div>
          </g:if>
          
          <g:if test="${invoicesPaid.isEmpty()}">
            <div class="information-box">
              <g:message code="payment.message.noElementsToPay" />
            </div>
          </g:if>
        
      </div>
    </div>
    <!-- end of yui-main -->
    <div id="narrow" class="yui-b">
      <div class="narrow-box">
          <h3>
           <g:message code="header.display" />
          </h3>
          <div class="body">
            <a class="top-link" href="${createLink(action:'index')}">
              <g:message code="payment.header.accountAndCartStatus" />
            </a>
          </div>
        </div>
    </div>
    <!-- end of narrow -->
    
  </body>
</html>
