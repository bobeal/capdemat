<html>
<head>
  <title>Service de paiement de CapWebCT</title>
  <meta name="keywords" content="Conseil Général, Val d'Oise, Paiement"/>
  <meta name="description" content="Page de login du service d'authentification de CapWebCT"/>
  <meta name="author" content="Benoit Orihuela"/>
  <link rel="stylesheet" href="/ServiceExporter/css/serviceexporter.css" type="text/css" media="all"/>
</head>
<body>
<img src="/ServiceExporter/img/cvq_bandeau_cg95.jpg"/>
<div id="header">
  <h1>Service de paiement de CapWebCT</h1>
</div>
<form name="fakePaymentForm" method="post" action="${createLink(action:'process')}">
  <fieldset>
    <legend>Détails du paiement</legend>
    <p>Montant à payer : <b>${params.amount} &euro;</b></p>
    <input type='hidden' name='cvqReference' value="${params.cvqReference}"/>
    <input type="hidden" name="callbackUrl" value="${params.callbackUrl}"/>
    <label for="cardNumber">Numéro de carte :</label>
    <input type="text" id="cardNumber" name="cardNumber"/>
    <br/>
    (Paiement accepté : 0123456789 / refusé : 9999999999 / annulé : 0000000000)
    <br/>
    <label for="cardKey">Clé :</label>
    <input type="text" id="cardKey" name="cardKey"/>
    <br/>
    <label for="email">Email :</label>
    <input type="text" id="email" name="email" value="${params.email}"/>
    <br/>
    <label for="submit">&nbsp;</label>
    <input type="submit" id="submit" name="Payer" value="Payer"/>
  </fieldset>
</form>
</body>
</html>