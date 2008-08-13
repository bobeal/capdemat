function processChildSubmit(action) {
	if (validateLegalResponsibles())
		processSubmit(action);
	else
		alert("Un enfant doit avoir entre 1 et 3 responsables légaux !");
}

function processAccountSubmit(action) {
	if (validatePassword())
		processSubmit(action);
	else
		alert("Les 2 mots de passe doivent être identiques et faire au moins 8 caractères !");
}

function validateLegalResponsibles() {
	var inputElements = document.getElementsByTagName("INPUT");
	var legalResponsibles = 0
	for (var i=0; i < inputElements.length; i++) {
		if (inputElements[i].checked) {
			legalResponsibles++;
		}
	}
	var externalResponsibles = document.getElementById("extern");
	if ((externalResponsibles != null) && (trim(externalResponsibles.innerHTML).length > 0))
		for (var i = 0; i < externalResponsibles.childNodes.length; i++) {
			if (externalResponsibles.childNodes[i].nodeType == 1) {
				legalResponsibles++;
			}
		}
	return (legalResponsibles > 0) && (legalResponsibles <= 3);
}

function validatePassword(){
	var password = document.getElementById('loginPassword').value;
	var passwordConfirm = document.getElementById('loginConfirmPassword').value;
	 
	return (password == passwordConfirm);
}

