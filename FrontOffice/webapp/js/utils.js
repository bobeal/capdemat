function setFocus(formname,controlname) {

	var focusControl = null

	if ((document.forms != null) && (document.forms[formname].elements != null)) {
		if (controlname == null) {
			var i = 0;
			while ((i < document.forms[formname].elements.length) && (focusControl == null)) {		
				var inputElement = document.forms[formname].elements[i++];
				if((inputElement.type !=  null) &&
					(inputElement.type != "hidden") && 
					!inputElement.disabled && 
					isVisible(inputElement)) {
					focusControl = inputElement;
				}
			}
		} else {
			focusControl = document.forms[formname].elements[controlname];
		}
		if ((focusControl != null) && (focusControl.type != "hidden") && 
			!focusControl.disabled && isVisible(focusControl)) {
			focusControl.focus();
		}
	}
}

var selectedRow = -1;

function validateRow(divAccounts, groupId, accountId, divValue, rowType) {
	var resultTable = document.getElementById(divAccounts);
	var rowValue = document.getElementById(divValue);
	if (resultTable != null) {
		var purchaseValue = "";
		var resultLabel = ""
		
		var tr = resultTable.rows[selectedRow*1];
		var td = tr.cells[tr.cells.length-1];
		switch (rowType) {
			case 1:  
				resultLabel = "Facture réglée";
				purchaseValue = "1";
				break;
				
			case 2:  
				var amount = new Number(rowValue.value.replace(/,/, "."));
				resultLabel = "Dépôt : " + amount.toFixed(2) + " &euro;";
				purchaseValue = rowValue.value;
				break;
				
			case 3:  
				resultLabel = "Achat : " + rowValue.value + " tickets";
				purchaseValue = rowValue.value;
				break;
				
			default:
				td.innerText = "no type defined";
		}
		var url = "purchase.do?group=" + groupId + "&id=" + accountId + "&value=" + purchaseValue;
		var responseState = sendRequest(url, null, null, false, null, null);
		if (responseState == 200) {
			td.innerHTML = resultLabel;
			resultTable.rows[selectedRow + 1].style.display='none';
			selectedRow = -1;
			window.location.reload();
			
		} else if (responseState == 400) {
			alert("La valeur saisie n'est pas correcte. (code d'erreur " + responseState + ")");
		} else if (responseState == 502) {
			alert("Cet item ne peut être réglé en même temps que les autres items du caddy");
		} else if (responseState == 501) {
			alert("Cet item ne peut être réglé sur ce site");
		} else {
			alert("Le serveur est actuellement indisponible. Veuillez réessayer ultérieurement. (" + responseState + ")");
		}
	}
}

function openTableRow(divAccounts, selectedIndex) {
	var resultTable = document.getElementById(divAccounts);
	if (resultTable != null) {
		if (selectedRow != -1)
			resultTable.rows[selectedRow + 1].style.display='none';
			
		if (selectedRow == selectedIndex) {
			selectedRow = -1;

		} else {
			selectedRow = selectedIndex;
		
			if ((selectedIndex >= 0) && (selectedIndex < resultTable.rows.length)) {
				if (resultTable.rows[selectedIndex*1 + 1].style.display=='none') {
					resultTable.rows[selectedIndex*1 + 1].style.display='';
				}
			}
		}
	}
}

var ruler = null;

function stringLength(text, textFont) {
	if (ruler == null) {
		ruler = document.createElement("span");
		ruler.style.visibility = "hidden";
		var bodyTag = document.getElementById('container');
		bodyTag.appendChild(ruler);
	}
	if ((textFont != null) && (textFont != ""))
		ruler.style.font = textFont;
	else
		ruler.style.font = "12px Verdana";
	ruler.innerHTML = text;
	return ruler.offsetWidth;
}

function resizeManager() {
	var divForm = document.getElementById("form");
	var divAction = document.getElementById("action");
	if (divForm != null) {
		divForm.style.left = divForm.offsetLeft;
		if (divAction != null)
			divForm.style.left = divAction.offsetLeft + divAction.offsetWidth + 10;
		divForm.style.width = document.body.offsetWidth - getSizeFromCSS(divForm.style.left) - 30;		
	}
}

function checkButtonLabelLength() {
	var allElements = document.getElementsByTagName("div");
	for (var i = 0; i < allElements.length; i++) {
		if ((allElements[i].className == "select") || 
			(allElements[i].className == "action")){
			var divButton = allElements[i];
			var buttonText = divButton.firstChild.innerHTML;
			adjustButtonLayout(divButton, buttonText, 0);
			
		} else if (allElements[i].parentNode.id == "button-area") {
			var divButton = allElements[i];
			var buttonText = divButton.innerHTML;

			adjustButtonLayout(divButton, buttonText, 0);
		}
	}
}

function adjustButtonLayout(divButton, buttonText) {
	var textLength = stringLength(buttonText, getStyleProperty(divButton, "font"));
	var divWidth = getSizeFromCSS(getStyleProperty(divButton, "width")); 

	if (textLength > divWidth) {
		var paddingTop = getSizeFromCSS(getStyleProperty(divButton, "padding-top"));
		var height = getSizeFromCSS(getStyleProperty(divButton, "height"));
		divButton.style.paddingTop = 0;
		divButton.style.height = height + paddingTop + "px";
	}
}

function getSizeFromCSS(cssSize) {
	var pos = cssSize.indexOf("px");
	if (pos > 0)
		var test = cssSize.substr(0,pos);
		return cssSize.substr(0,pos) * 1;
		
	var pos = cssSize.indexOf("pt");
	if (pos > 0)
		var test = cssSize.substr(0,pos);
		return cssSize.substr(0,pos) * 1;
		
	var pos = cssSize.indexOf("%");
	if (pos > 0)
		var test = cssSize.substr(0,pos);
		return cssSize.substr(0,pos) * 1;
		
	return cssSize * 1;
}

function getStyleProperty(element,styleProp)
{
	if (element.currentStyle)
		var propValue = element.currentStyle[formatStyleProp(styleProp)];
		
	else if (window.getComputedStyle)
		var propValue = window.getComputedStyle(element,null).getPropertyValue(styleProp);

	return propValue;
}

function formatStyleProp(styleProp) {
	var formatProp = "";
	var props = styleProp.split("-");
	for (var i = 0; i < props.length; i++) {
		formatProp += firstUpper(props[i]);
	}
	return firstLower(formatProp);
} 

function firstUpper(s) {
	return s.substring(0,1).toUpperCase() + s.substring(1);
}

function firstLower(s) {
	return s.substring(0,1).toLowerCase() + s.substring(1);
}

function popup(popupPage) {
	window.open(popupPage,'popup','resizable=yes,top=30,left=140,width=820,height=740');
}
