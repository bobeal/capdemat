function addFamilyRequest(event) {
	if (event.ctrlKey)
		document.location.href='familyAction.do?action=requestf';
	else
		document.location.href='familyAction.do?action=request';
}
