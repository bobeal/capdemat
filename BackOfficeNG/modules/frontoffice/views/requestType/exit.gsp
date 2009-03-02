<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  
  <body>
    <div class="main-box requestExit">
      <h2>${requestTypeLabel}</h2>
      <div class="link">
        <p><a href="${createLink(controller:'frontofficeRequest',action:'summary',id:rqt?.id)}">Voir le résumé de ma demande</a></p>
        <p><a href="${createLink(controller:'frontofficeRequestType')}">Saisir une nouvelle demande</a></p>
        <p><a href="${createLink(controller:'frontofficeHome')}">Retour à l'accueil</a></p>
      </div>
      <div class="info">
      <p>Votre demande a bien été transmise</p>
      <p>Numéro de dossier ${rqt?.id}</p>
      </div>
    </div>
  </body>
</html>

