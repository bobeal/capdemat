<html>
<head>
  <title>Service de paiement de CAP BANQUE</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style type="text/css">
	body {
		padding:0; margin:0;
		font-family:Arial, Helvetica, sans-serif; font-size:0.65em;
		text-align:center;
	}
	#header {
		min-height:70px;
		background:#2D2D2D;
		text-align:center;
	}
	#header img {
		margin-bottom:-80px;
		border:5px solid #FFFFFF; -moz-border-radius:5px; -webkit-border-radius:5px; border-radius:5px;
    }
	h1 {
		margin:1.5em 0;
		color:#e00;
		font-size:2rem;
		text-align:center;
	}
	form {
		margin:0 auto;
		width:600px;
		font-size:1.0rem;
	}
	form p { margin:0;}
	.total {font-weight:bold;}
	form .row {
		clear:both;
		margin-bottom:15px;
	}
	form .row .colLeft, form .row label {
		float:left;
		width:30%;
		color:#333;
		text-align:right;
		font-size:0.9rem;
	}
	form .row .colRight { 
		margin-left:31%; 
		text-align:left;
	}
	form .row .colRight span {
		color:#999;
		font-style:italic; font-size:0.7rem;
	}
	form .row .colRight label {
		float:none;
		width:100%;
	}
	form .submit {margin-top:20px;}
	form .submit input {height:2em; width:15em;}
	form #cardKey {width:50px;}
</style>
<body>
<div id="header">
	<img src="../images/cap_banque.png" alt="Logo Collectivité" />
</div>
<h1>Service de paiement de CAP BANQUE</h1>
<form name="fakePaymentForm" method="post" action="${createLink(action:'process')}">
  <fieldset>
    <legend>Détails du paiement</legend>
    <div class="row">
    	<p class="colLeft">Montant à payer : </p>
        <p class="colRight total">${params.amount} &euro;</p>
    </div>
    <input type='hidden' name='cvqReference' value="${params.cvqReference}"/>
    <input type="hidden" name="callbackUrl" value="${params.callbackUrl}"/>
    <div class="row">
    	<label for="cardNumber">Numéro de carte :</label></p>
    	<p class="colRight"><input type="text" id="cardNumber" name="cardNumber"/> <span>(Paiement accepté : 0123456789 / refusé : 9999999999 / annulé : 0000000000)</span><br />
	    <img src="../images/CB_crypto.gif" width="300px" /><label for="cardKey">Cryptogramme : </label><input type="text" id="cardKey" name="cardKey"/></p>
    </div>
    <div class="row">
    	<label for="email">E-mail :</label>
    	<p class="colRight"><input type="text" id="email" name="email" value="${params.email}"/></p>
    </div>
    <div class="row submit">
    	<input type="submit" id="submit" name="Payer" value="Payer"/>
    </div>
  </fieldset>
</form>
</body>
</html>
