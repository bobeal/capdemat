<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  
  <body>
    <div class="main-box requestExit">
      <h2>${requestTypeLabel}</h2>
      <div class="info">
        <p>Votre demande a bien été transmise !</p>
        <p>Le numéro de suivi de votre demande est le ${rqt.id}</p>
      </div>
      <div class="link">
        Vous pouvez maintenant :
        <ul>
          <li>
            <a href="${createLink(controller:'frontofficeRequest',action:'summary',id:rqt.id)}">
              Voir le résumé de votre demande
            </a>
          </li>
          <li>
            <a href="${createLink(controller:'frontofficeRequestType')}">
              Saisir une nouvelle demande
            </a>
          </li>
          <li>
            <a href="${createLink(controller:'frontofficeHome')}">
              Retourner à l'accueil
            </a>
          </li>
        </ul>
      </div>
    </div>
  </body>
</html>

