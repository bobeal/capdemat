<html>
  <head>
    <title>${message(code:'homeFolder.title.creation')}</title>
    <meta name="layout" content="fo_main" />
    <g:if test="${flash.addressesReferentialEnabled}">
      <link rel="stylesheet" type="text/css" href="${resource(dir : 'css/common', file : 'autocomplete.css')}" />
      <script type="text/javascript">
        zenexity.capdemat.contextPath = "${request.contextPath}";
      </script>
      <script type="text/javascript" src="${resource(dir : 'js/common',file : 'addressAutocomplete.js')}"></script>
      <script type="text/javascript" src="${resource(dir : 'js/common',file : 'autocomplete.js')}"></script>
    </g:if>
    <script type="text/javascript" src="${resource(dir : 'js/frontoffice', file : 'homeFolder.js')}"></script>
    <link rel="stylesheet" type="text/css" href="${resource(dir : 'css/frontoffice/common', file : 'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir : 'css/frontoffice', file : 'homefolder.css')}" />
  </head>
  <body>
    <div class="individual box">

      <h2>${message(code : 'homeFolder.action.createAccount')}</h2>

      <div class="main ${flash.invalidFields?.any() ? 'Invalid' : 'Uncomplete'}">
        <g:render template="/frontofficeHomeFolder/create/responsible"
          model="[ 'submitCode' : 'homeFolder.action.continueCreation' ]" />
      </div>

      <!-- Side actions
      <div class="side">
          <div class="action">
          </div>
      </div>
      -->

    </div>
  </body>
</html>
