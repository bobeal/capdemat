<html>
  <head>
    <title>${message(code:'home.title.login')}</title>
    <meta name="layout" content="fo_main" />
   <!-- TODO : extract styles for form styles -->
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  
  <body>
    <g:if test="${flash.successMessage}">
      <div class="success-box"><p>${flash.successMessage}</p></div>
    </g:if>
      <g:render template="/shared/services" />
  </body>
</html>

