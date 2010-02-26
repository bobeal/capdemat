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
          <g:render template="itemDetails"/>
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
