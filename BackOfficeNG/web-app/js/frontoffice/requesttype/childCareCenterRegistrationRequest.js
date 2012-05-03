YAHOO.namespace("request.child.care.center");

var yrccc = YAHOO.request.child.care.center;
var yu = YAHOO.util;
var yue = yu.Event;
var yuel = yu.Element;
var yud = yu.Dom;
var yw = YAHOO.widget;
var yuc = yu.Connect;
var yus = yu.Selector;

yrccc.requestCreation = function() {
	
	var Validator = function(e){
		var targetEl = yue.getTarget(e);
        targetEl.value = targetEl.value.replace(/[^\d]/g, "");
	}
	
	var formatValid = function(e){
		var targetEl = yue.getTarget(e);
		if(targetEl.value.length == 5) {
			targetEl.value = targetEl.value.substring(0,2) + ":" + targetEl.value.substring(3,5);
		} else if(targetEl.value.length < 1){
			targetEl.value = "";
		} else if(targetEl.value.length < 5){
			if(targetEl.value.length == 4){
				targetEl.value = targetEl.value.substring(0,2) + ":" + targetEl.value.substring(2,4);
			} else if(targetEl.value.length == 3){
				if(targetEl.value.substring(0,1) == '1'){
					targetEl.value = targetEl.value.substring(0,2) + ":" + targetEl.value.substring(2,3) + "0";
				} else {
					targetEl.value = "0" + targetEl.value.substring(0,1) + ":" + targetEl.value.substring(1,3);
					
				}
			} else if(targetEl.value.length < 3){
				targetEl.value = targetEl.value.substring(0,2) + ":00"; 
			}
		} 
		//alert(targetEl.value.substring(0,1));
		/*if(targetEl.value.substring(0,1) != "0" || targetEl.value.substring(0,1) != "1" || targetEl.value.substring(0,1) != "2"){
			targetEl.value = "";
		}*/
	}
	
	yue.on(yus.query('#requestTabView form div input[type="text"].periodDay'), "keyup", Validator);
	
	yue.on(yus.query('#requestTabView form div input[type="text"].periodDay'), "focusout", formatValid);
	
    var getElementToHide = yud.getElementsByClassName("hide");
	function showToBorn(e){
		var value = this.options[this.selectedIndex].innerHTML;
		if(value == "NOUVEL ENFANT A NAITRE"){
			for(var i = 0; i < getElementToHide.length; i++){
				yud.setStyle(getElementToHide[i], "display", "block");
			}
		} else {
			for(var i = 0; i < getElementToHide.length; i++){
				yud.setStyle(getElementToHide[i], "display", "none");
			}

		}
	}

	var subjectId = yud.get("subjectId");
	if(subjectId.options[subjectId.selectedIndex].innerHTML == "NOUVEL ENFANT A NAITRE"){
			for(var i = 0; i < getElementToHide.length; i++){
				yud.setStyle(getElementToHide[i], "display", "block");
			}
	} else {
		for(var i = 0; i < getElementToHide.length; i++){
				yud.setStyle(getElementToHide[i], "display", "none");
			}
	}
	yue.addListener(subjectId, "change", showToBorn);


	//var prenom = yud.get("subjectChoiceFirstName");
	//prenom.disabled = true;
	var male = yud.get("subjectChoiceGender_Male");
	var female = yud.get("subjectChoiceGender_Female");
	var unknown = yud.get("subjectChoiceGender_Unknown");



	if(male.checked){

	} else if (female.checked){

	} else {
		unknown.checked = true;
	}

}

yue.onDOMReady(yrccc.requestCreation);
