//
//Cartevaloise 
//
//Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
//Reserved.
//
//Developed by René le Clercq
//
//This program is free software; you can redistribute it and/or
//modify it under the terms of the GNU General Public License as
//published by the Free Software Foundation; either version 2 of the
//License, or (at your option) any later version.
// 
//This program is distributed in the hope that it will be useful, but
//WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//General Public License for more details.
// 
//You should have received a copy of the GNU General Public License
//along with this program; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
//02111-1307, USA.

function processConfirm(message, action) {
	var cancelWindow = window.confirm(message);
	if (null != cancelWindow) {
		if (true == cancelWindow) {
			document.location.href = action;
		}
	}
}

function processCheck(message, action, condition) {
	if (condition == true) {
		document.location.href=action;
	} else {
		window.alert(message);
	}  
}

var processedDefaultButton = false;
function processDefaultButton(evnt) {
	var event = evnt;

	if (event == null)
		event = window.event;

	if (event.keyCode == 13) {
		var tagElement = (event.srcElement != null) ? event.srcElement : event.target;
		if (!processedDefaultButton && (tagElement.tagName !='TEXTAREA')) {
			var buttonDiv = document.getElementById("defaultbutton");
			if (buttonDiv != null) {
				if (buttonDiv.onclick != null) {
					processedDefaultButton = true;
					buttonDiv.onclick();
				} else if (buttonDiv.href != null) {
					document.location.href = buttonDiv.href;
				}
			}
		}
		return false;
	}
	return true;
}

function processSubmit(action) {
	for (var i = 0; i < document.forms.length; i++) {
		sf = document.forms[i];
		if (sf.name != "") {
			if (sf.action != null) {
		     	if (((sf.action.match("#") != null) && (sf.action.match("#").length > 0)) ||
		     		 (sf.action.indexOf(action) != -1)) {
					sf.action = action;
					submitForm(sf);
		     	}
		    }
		}
	}
}

function processValidate(action) {
	sf = document.forms["processvalidate"];
	if (sf != null) {
		sf.action = action;
		submitForm(sf);
	}
}

function validateRequest() {
	processSubmit('validateRequest.do');
}

function cancelRequest() {
	processConfirm(abortRequestMessage,"endProcess.do");
}

function blurRegion(divRegion, opacity) {
	var element = document.getElementById(divRegion);
	blurElement(element, opacity);
}

function blurElement(element, opacity) {
	if (element != null) {
		if (element.style != null) {
			element.style.filter = "alpha(opacity=" + opacity + ")";
			element.style.MozOpacity = "." + (100-opacity);
		}
		var child = element.firstChild;
		while (child != null) {
			blurElement(child, opacity);
			child = child.nextSibling;
		}
	}
}