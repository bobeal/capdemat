<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<html>
  <head>
    <title>Service de paiement de CapWebCT</title>
    <meta name="keywords"
          content="Conseil Général, Val d'Oise, Paiement" />
    <meta name="description"
          content="Page de login du service d'authentification de CapWebCT" />
    <meta name="author" content="Benoit Orihuela" />
    <link rel="stylesheet" href="/ServiceExporter/css/serviceexporter.css" 
          type="text/css" media="all" />
  </head>
  <body>
    <img src="/ServiceExporter/img/cvq_bandeau_cg95.jpg" />
    <div id="header">
      <h1>Service de paiement de CapWebCT</h1>
    </div>
    <form name="fakePaymentForm" method="post" action="<c:url value="/payment/fake_payment_form.html"/>" >
      <fieldset>
        <legend>Détails du paiement</legend>
        <p>Montant à payer : <b><c:out value="${amount}"/> &euro;</b></p>
        <spring:bind path="paymentData.reference">
          <input type='hidden' name='cvqReference' value="<c:out value='${cvqReference}'/>" />
        </spring:bind>
        <spring:bind path="paymentData.callbackUrl">
          <input type="hidden" name="callbackUrl" value="<c:out value='${callbackUrl}'/>" />
        </spring:bind>
        <spring:bind path="paymentData.cardNumber">
          <label for="cardNumber">Numéro de carte : </label>
          <input type="text" id="cardNumber" name="cardNumber"/>
          <br/>
          (Paiement accepté : 0123456789 / refusé : 9999999999 / annulé : 0000000000)
          <br/>
        </spring:bind>
        <spring:bind path="paymentData.cardKey">
          <label for="cardKey">Clé : </label>
          <input type="text" id="cardKey" name="cardKey"/>
          <br/>
        </spring:bind>
        <spring:bind path="paymentData.email">
          <label for="email">Email : </label>
          <input type="text" id="email" name="email" value="<c:out value="${email}" />" />
          <br/>
        </spring:bind>
        <label for="submit">&nbsp;</label>
        <input type="submit" id="submit" name="Payer" value="Payer"/>
      </fieldset>
    </form>
  </body>  
</html>
