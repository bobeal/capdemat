function createPage404() {

	var html404 = '<div id="pict-error-404"><h1>Page non trouv??e</h1></div>';

	var strReferrer=document.referrer.toLowerCase();

	if (location.href.indexOf("noreferrer=true")>=0) strReferrer="";

	if (strReferrer.length==0) {

		//not referred from anything at all, apparently!
		var str='';
		str+='Les liens suivants peuvent vous aider ?? retrouver l\'information que vous recherchez :';
		str+='<ul><li><a href="/accueil" title="Page d\'accueil du portail citoyen">Page d\'accueil<\/a><\/li>';
		str+='<li><a href="/recherche" title="Moteur de recherche du portail citoyen">Moteur de recherche<\/a><\/li><\/ul>';
		str+='<hr \/>';
		str+='<h3>Les causes possibles de cette erreur sont :<\/h3>';
		str+='<ol type="a">';
		str+='  <li>Un de vos favoris est d??pass??<\/li>';
		str+='  <li>Vous avez tap? une mauvaise adresse URL dans votre navigateur<\/li>';
		str+='<\/ol>';
		html404 += str;

	}

	var blnSearchReferral = false;
	var blnInsiteReferral = false;

	var strSite = "";

	if (strReferrer.length!=0) {


		if (!blnSearchReferral) {

			// for referrals from other sites with broken links
			// ------------------------------------------------

			strSite = strReferrer;
			strSite = strSite.split("/");
			strSite = strSite[2];
			html404 += "Vous avez ??t?? incorrectement envoy?? ici depuis ce site : <strong><a href='" + strReferrer + "' target='_blank'>" + strSite + "</a></strong>";

		}

		html404+='<p>Les liens suivants peuvent vous aider ?? retrouver l\'information que vous recherchez :';
		html404+='<ul><li><a href="/accueil" title="Page d\'accueil du portail citoyen">Page d\'accueil<\/a><\/li>';
		html404+='<li><a href="/recherche" title="Moteur de recherche du portail citoyen">Moteur de recherche<\/a><\/li><\/ul>';
		html404+='<hr \/>';		

		if (!blnSearchReferral)	{

			// for referrals from other sites with broken links
			// ------------------------------------------------			

			blnInsiteReferral =(strReferrer.indexOf("www.p-i-c-t.org")>=0)

			//got here
			str='<div>';
			str+='<h3>Aidez nous ?? corriger l\'erreur</h3>';

			if (blnInsiteReferral)
				{str+='<p>Il semble qu\'un de nos propres liens soit cass??. Pour nous avertir de cette erreur, merci de cliquer sur le lien ci-dessous :</p>';}
			else
				{str+='<p>Un autre site ?? un pointeur incorrect vers notre site. Si vous souhaitez nous avertir ce cette erreur, merci de cliquer sur le lien ci-dessous :</p>';}

			str+='<a class="sendMail" href="mailto:pict-portail@googlegroups.com?subject=Lien cass?? sur www.p-i-c-t.org&body=Le lien '+document.location+' est cass?? (en provenance de '+strReferrer+')">Envoyer un email sur le mailing list de pict</a>';

			str+='<\/div>';

			html404 += str;

		}

	}

	document.getElementById('pict-error-404').innerHTML = html404;

}
