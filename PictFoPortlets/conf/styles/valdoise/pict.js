
// page 404
importScript('scripts/page404.js');
var initFunctions = new Array();

function initStyle() {	

	try {
	
		// ajout d'un lien sur le moteur de recherche
		{
			rechercheLabel = document.getElementById('pict-global-search-label');
			rechercheLabel.title = 'Aller ? la page de recherche';
			rechercheLabel.onclick = function(e) {
				document.location = '/recherche';
				return false;
			}
		}

		// modification du footer
		{
			credits = document.getElementById('pict-credit');
			credits.innerHTML = 'propuls? par <a style="font-weight:bold; color:#ef55b5" href="@trac/wiki/PictForge">pict forge</a>, cr?? par <a style="font-weight:bold; color:#9ddb46" href="http://www.zenexity.fr">zenexity</a>';
		}
		
		for (i=0;i<initFunctions.length;i++) {
			var func = initFunctions[i];
			try {
				func();
			} catch (e) {
				alert ('erreur d\'initialisation de ' + func + ',' +e);
			}
		}

	} catch(e) { }

	try {
	
		// page 404
		if( document.getElementById('pict-error-404') ) {
				createPage404()
		}

		
		

	} catch(e) { }

	// afficher pict
	{
		document.getElementById('pict').style.display = 'block';
	}

}
