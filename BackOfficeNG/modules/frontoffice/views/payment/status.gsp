<html>
  <head>
    <meta name="layout" content="fo_main" />
  </head>
  
  <body>
    <div id="yui-main"> 
      <div id="main" class="yui-b">
        <div class="information-box">
            Un paiement est en cours de traitement et il est possible qu'une ou des factures 
            apparaissent ici alors que vous venez de la ou les régler.
            Nous vous conseillons de n'effectuer aucun paiement pour le moment et de 
            réessayer ultérieurement.
        </div>
      </div> 
    </div> 
    <!-- end of yui-main -->
    
    <div id="narrow" class="yui-b">
      <div id="requestSubject" class="narrow-box">
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

