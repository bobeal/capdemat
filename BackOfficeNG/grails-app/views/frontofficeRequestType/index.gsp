<html>
  <head>
    <title>${message(code:'request.title.services')}</title>
    <meta name="layout" content="fo_main" />
    <style type="text/css">
        .box .half1 { width: 49%; float: left; }
        .box .half2 { width: 49%; float: right; }
        .information-box { display: block; }
    </style>
  </head>

  <body>
    ${message(code:'services.message.localAuthorityInformationTop', default:'')}

    <div class="box">
      <div class="half1">
        <g:render template="/shared/services" model="['groups':groups[0]]" />
      </div>
      <div class="half2">
        <g:render template="/shared/services" model="['groups':groups[1]]" />
      </div>
    </div>

    ${message(code:'services.message.localAuthorityInformationBottom', default:'')}
  </body>
</html>
