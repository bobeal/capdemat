var treeNodes = new Array();
var treeRoot = null;
var treeDiv = "";
var actionDiv = null;

function initXmlTree(divId, divDetail, divAction) {
	treeDiv = divId;
	hideDetails(document.getElementById(divDetail));
	actionDiv = document.getElementById(divAction);
	actionDiv.style.display = 'none';
	treeRoot = new TreeMenu("/BackOffice/images", "treeRoot", "_self", "", true, true);

	sendRequest('/BackOffice/treeManager.do', 'load', null, false, loadXmlTree, treeRoot);
}

function loadXmlTree(returnCode, text, treeRoot) {
	var xml = (new DOMParser()).parseFromString(text, "text/xml");
	
	var tree = xml.firstChild;

	var data = new DataNode(null);
	data.text = tree.getAttribute('label');
	data.addTreeNode(treeRoot.addItem(new TreeNode(data.text, '', '', true, true, 'treeHeader', '', '')));

    var index = treeNodes.length;
    treeNodes[index] = data;
    data.treeIndex = index;
    
	var nodes = tree.childNodes;
	for (i = 0; i < nodes.length; i++) {
		addXmlNode(data, nodes[i]);
	}
	
	loadSelectedIndex();
	displaySelect();
	drawTree();
}

function addXmlNode(parentNode, xmlNode) {
    var data = parentNode.addChild(new DataNode(parentNode));

	data.text = xmlNode.getAttribute('label');
	data.id = xmlNode.getAttribute('id');
	data.type = xmlNode.getAttribute('type');
	var expand = (xmlNode.getAttribute('expand') != null);

    var index = treeNodes.length;
    treeNodes[index] = data;
    data.treeIndex = index;
    
    var node = new TreeNode(data.text, 'folder_closed.png', 'javascript:displaySelect(' + index + ')', expand, true, 'treeNode', '', 'folder_opened.png')

	data.addTreeNode(node);

	var children = xmlNode.childNodes;
	for (var i = 0; i < children.length; i++) {
		if (children[i].nodeName == 'property')
			addXmlNodeProperty(data, children[i]);

		else if (children[i].nodeName == 'node')
			addXmlNode(data, children[i]);
	}
}

function addNode(parentNode, childNode) {
    parentNode.addChild(childNode);
		
    var index = treeNodes.length;
    treeNodes[index] = childNode;
    
    var node = new TreeNode(childNode.text, 'folder_closed.png', 'javascript:displaySelect(' + index + ')', false, true, 'treeNode', '', 'folder_opened.png')

	childNode.addTreeNode(node);
	
	return index;
}

function addXmlNodeProperty(data, xmlProperty) {
	data.addProperty(new NodeProperty(xmlProperty.getAttribute('key'), 
									  xmlProperty.getAttribute('value'),
									  xmlProperty.getAttribute('type')));
}

function drawTree() {
	
    var elem = document.getElementById(treeDiv);
    treeRoot.output = "";
	treeRoot.drawMenu();
    elem.innerHTML = treeRoot.output;
	elem.style.height = elem.parentNode.clientHeight;

    treeRoot.resetBranches();
}

function defaultDataNode(parentNode) {
    var data = new DataNode(parentNode);
    
    if (parentNode.type == 0) {
    	data.type = 1;
    	
    } else if ((parentNode.type == 1) || (parentNode.type == 2)) {
    	data.type = 2;
	    data.addProperty(new NodeProperty("message", "", "none"));
	    data.addProperty(new NodeProperty("supportMultiple", "false", "check"));
	    data.addProperty(new NodeProperty("supportQuota", "false", "check"));
	    data.addProperty(new NodeProperty("supportPriority", "false", "check"));
	    data.addProperty(new NodeProperty("labelPriority", "", "none"));
	    data.addProperty(new NodeProperty("supportPrecision", "false", "check"));
	    data.addProperty(new NodeProperty("labelPrecision", "", "none"));
	    
	} else if (parentNode.type == 3) {
    	data.type = 4;
	    data.addProperty(new NodeProperty("message", "", "text"));
	    data.addProperty(new NodeProperty("eventDate", "", "datetime"));
	    data.addProperty(new NodeProperty("reservationStartDate", "", "date"));
	    data.addProperty(new NodeProperty("reservationEndDate", "", "date"));
	    data.addProperty(new NodeProperty("quota", "", "text"));
	    data.addProperty(new NodeProperty("remainingPlaces", "", "none"));
	    
	} else if (parentNode.type == 4) {
    	data.type = 5;
	    data.addProperty(new NodeProperty("price", "", "text"));
	}
	return data;
}

function treatResult(returnCode, responseText, extraData) {
	if (returnCode == 200) {
		if (responseText != "") {
			var xml = (new DOMParser()).parseFromString(responseText, "text/xml");
			var node = xml.firstChild;
			if (node.getAttribute("refresh") == "true")
				document.location.reload(true);
			
			if (extraData.type == 4) {
				extraData.setProperty("quota", node.getAttribute("quota"))
				extraData.setProperty("remainingPlaces", node.getAttribute("remaining"))
				displaySelect();
			}
		}
	} else {
		alert(responseText);
	}
}

var selectedElements = null;
var selectedNode = null;
var selectedIndex = null;
var resetRootElements = null;
var resetSelectElements = null;

function hideDetails (detailElement) {
	var childNode = detailElement.firstChild;
	while (childNode != null) {
		if (childNode.style != null)
			childNode.style.display = "none";
		childNode = childNode.nextSibling;
	}
}

function displaySelect(index) {
	resetSelectedElements(true);
	
 	if (index == null)
 		index = selectedIndex;

	if (index != null) {  		
	    var dataNode = treeNodes[index];
	    if (rootNode(dataNode))
	    	resetRootDisplay();
	    else
	    	resetSelectDisplay();
	    
	    if (dataNode.ancestors == "")
	    	actionDiv.style.display = "none";
	    else
	    	actionDiv.style.display = "";
	    	
		setElementValue("ancestors", dataNode.ancestors, "", true);
		setElementValue("key", dataNode.id, "text", true);
		setElementValue("label", dataNode.text, "text", true);
	    for (i = 0; i < dataNode.properties.length; i++) {
			setElementValue(dataNode.properties[i].key, dataNode.properties[i].value, dataNode.properties[i].type, true)
	    }
	    selectedNode = dataNode;
	    saveSelectedIndex(index);
	}
}

function displayModify(show, hide) {
	updateDisplay(arguments);
	resetSelectedElements(false);

    var dataNode = treeNodes[selectedIndex];
	setElementValue("ancestors", dataNode.ancestors, "", true);
	setElementValue("key", dataNode.id, "text", true);
	setElementValue("label", dataNode.text, "text", false);
    for (i = 0; i < dataNode.properties.length; i++) {
		setElementValue(dataNode.properties[i].key, dataNode.properties[i].value, dataNode.properties[i].type, false)
    }
    
    selectedNode = dataNode;
}

function displayAdd(show, hide) {
	updateDisplay(arguments);
	resetSelectedElements(true);

    var dataNode = defaultDataNode(selectedNode);
	setElementValue("ancestors", dataNode.ancestors, "", true);
	setElementValue("key", dataNode.id, "text", false);
	setElementValue("label", dataNode.text, "text", false);
    for (i = 0; i < dataNode.properties.length; i++) {
		setElementValue(dataNode.properties[i].key, dataNode.properties[i].value, dataNode.properties[i].type, false)
    }

    selectedNode = dataNode;
}

function resetSelectDisplay() {
	if (arguments.length > 0)
		resetSelectElements = arguments;

	if (resetSelectElements != null)
		updateDisplay(resetSelectElements);
}

function resetRootDisplay() {
	if (arguments.length > 0)
		resetRootElements = arguments;

	if (resetRootElements != null)
		updateDisplay(resetRootElements);
}

function updateDisplay(displayElements) { 
	if (displayElements.length > 0) {
	    var elem = document.getElementById(displayElements[0]);
		if (elem != null)
			elem.style.display = '';
	
	    for (var i = 1; i < displayElements.length; i++) {
			elem = document.getElementById(displayElements[i]);
			if (elem != null)
				elem.style.display = 'none';
		}
	}
}

function resetSelectedElements(hide) {
    if (selectedElements != null) {
        for (var i = 0; i < selectedElements.length; i++) {
			if (selectedElements[i].value == null)
	            selectedElements[i].innerHTML = '&nbsp;';
    		else
            	selectedElements[i].value = '';
            	
            var parentElement = selectedElements[i].parentNode;
            if (hide)
				parentElement.style.display = 'none';
			else
				parentElement.style.display = '';
        }
        selectedElements = null;
    }
}

function setElementValue(key, value, type, displayOnly) {
    var elem = document.getElementById(key);
    if (elem != null) {

        if (selectedElements == null)
            selectedElements = new Array();

        var index = selectedElements.length;
        selectedElements[index] = elem;
		if (elem.value == null) {
			if (displayOnly) {
				if (type == "checkbox")
					value = (value == 'true') ? "x" : "";

				if ((value != null) && (value != ""))
		            elem.innerHTML = value;
		         else
		            elem.innerHTML = '&nbsp;';

			} else if (type == 'text') {
				var size = (value.length > 20) ? ' size="40"' : '';
	            elem.innerHTML = '<input type="text" class="input_text" value="' + value + '"' + size + '/>';

			} else if (type == 'checkbox') {
				var checked = (value == 'true') ? "checked" : "";
	            elem.innerHTML = '<input type="checkbox"' + checked + ' class="input_checkbox" value="true"/>';

			} else if ((type == 'date') || (type == 'datetime')) {
	            elem.innerHTML = dateInput(type, value);

			} else if (type == 'none') {
	            elem.innerHTML = value;
			}

		} else {
	        elem.value = value;
		}
        elem.parentNode.style.display = '';
    }
}

var months = new Array("janvier","février","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","décembre");

function dateInput(type, value) {
	var valueDate = parseDateString(value);
	
	// Days
	var html = "<select>\n";
	for (var i = 1; i < 32; i++) {
		var selected = (valueDate.getDate() == i) ? " selected=true" : "";
		html += "    <option value=\"" + formatNumber(i) + "/\"" + selected + ">" + i + "</option>\n";
	}
	html += "</select>\n";

	// Months
	html += "<select>\n";
	for (var i = 0; i < months.length; i++) {
		var selected = (valueDate.getMonth() == i) ? " selected=true" : "";
		html += "    <option value=\"" + formatNumber(i+1) + "/\"" + selected + ">" + months[i] + "</option>\n";
	}
	html += "</select>\n";

	// Years
	html += "<select>\n";
	var now = new Date();
	
	var i = now.getFullYear()
	for (var i = now.getFullYear(); i < now.getFullYear() + 2; i++) {
		var selected = (valueDate.getYear() == i) ? " selected=true" : "";
		html += "    <option value=\"" + i + "\"" + selected + ">" + i + "</option>\n";
	}
	html += "</select>\n";

	if (type == "datetime") {
		html += "<b>&nbsp;à&nbsp;</b>\n";
		// Hours
		html += "<select>\n";
		for (var i = 0; i < 24; i++) {
			var selected = (valueDate.getHours() == i) ? " selected=true" : "";
			html += "    <option value=\" " + formatNumber(i) + ":\"" + selected + ">" + formatNumber(i) + "</option>\n";
		}
		html += "</select>\n";
	
		// Minutes
		html += "<select>\n";
		for (var i = 0; i < 60; i += 15) {
			var selected = (valueDate.getMinutes() == i) ? " selected=true" : "";
			html += "    <option value=\"" + formatNumber(i) + "\"" + selected + ">" + formatNumber(i) + "</option>\n";
		}
		html += "</select>\n";
	}
	return html;
}

function parseDateString(dateString) {
	
	var start = 0;
	var end = dateString.indexOf( "/", start);
	var day = Number(dateString.substring(start,end));

	start = end + 1;
	end = dateString.indexOf("/", start);
	var month = Number(dateString.substring(start,end));

	start = end + 1;
	end = dateString.indexOf(" ", start);

	var year = 0;
	var hour = 0;
	var minutes = 0;
	var seconds = 0;
	
	if (end == -1) {
		year = Number(dateString.substring(start));
	} else {
		year = Number(dateString.substring(start,end));
	
		start = end + 1;
		end = dateString.indexOf(":", start);
		hour = Number(dateString.substring(start,end));
	
		start = end + 1;
		minutes = Number(dateString.substring(start));
	}	
	
	return new Date(year, month-1, day, hour, minutes, seconds);
}

function formatNumber(i) {
	if (i < 10)	
		return "0" + i;
		
	return i;
}

function modifyData() {
	saveData(selectedNode);
	displaySelect();

	var treeNode = selectedNode.getTreeNode();
    var elem = document.getElementById(treeNode.layerID);
	var textElem = elem.getElementsByTagName("span");
	textElem[0].innerHTML = treeNode.title;
	
	updateData(selectedNode);
}

function addData() {
    var parentNode = treeNodes[selectedIndex];
	var index = addNode(parentNode, selectedNode);
	saveData(selectedNode);
	
	updateData(selectedNode);
	displaySelect(index);
	drawTree();
}

function deleteData() {
	var parentNode = selectedNode.parentNode;
	var okDelete = false;

	if (rootNode(parentNode) && (parentNode.nbChildren() == 1))
		okDelete = window.confirm("\t\t\tATTENTION ! \n" + selectedNode.text + " est le dernier paramètre pour ce categorie, de ce fait la télé-procédure va être dépublié.\nVoulez vous continuer?");
	else
		okDelete = window.confirm("Voulez vous supprimer " + selectedNode.text + "?");

	if (okDelete) {
		parentNode.removeChild(selectedNode);
		parentNode.removeBranch(selectedNode);
		
		removeHtmlBranch(selectedNode);
		
		updateData(selectedNode);
		displaySelect(parentNode.treeIndex);
	}	
}

function rootNode(node) {
	return ((node.type == 1) || (node.type == 3));	
}

function removeHtmlBranch(dataNode) {
	for (var i = 0; i < dataNode.children.length; i++)
		removeHtmlBranch(dataNode.children[i]);

	var treeNode = dataNode.getTreeNode();
    var elem = document.getElementById(treeNode.layerID);
	if (elem != null)
		elem.parentNode.removeChild(elem);
}

function saveData(node) {
    if (selectedElements != null) {
        for (var i = 0; i < selectedElements.length; i++) {
        	var key = selectedElements[i].id;
			var elem = selectedElements[i].firstChild;
			if (elem != null) {
	        	var value = elem.value;

	        	var property = node.getProperty(key);
				if (property != null) {
					if (property.type == 'checkbox')
						value = (elem.checked) ? "true" : "false";
						
					else if ((property.type == "date")||(property.type == "datetime")) {
						value = "";
						while (elem != null) {
							if (elem.type == "select-one") {
								var si = elem.selectedIndex;
								if (si >= 0) {
									value += elem.options[si].value;
								}
							}
							elem = elem.nextSibling;
						}
					} else if (value == null) {
						value = selectedElements[i].innerHTML;
					}
				}
	
				node.setProperty(key, value);
			}
        }
    }
}

function updateData(dataNode) {
	sendRequest("/BackOffice/treeManager.do", "savexml", dataNode.writeParent(), true, treatResult, dataNode);
}

function saveSelectedIndex(index) {
    document.cookie = "SelectedIndex=" + treeNodes[1].id + ":" + index;
    selectedIndex = index;
}

function loadSelectedIndex() {
	var cookie = document.cookie.split('; ');

	for (var i=0; i < cookie.length; i++) {
		var crumb = cookie[i].split('=');
		if ('SelectedIndex' == crumb[0] && crumb[1]) {
			var typeIndex = crumb[1].split(':');
			if (typeIndex.length == 2) {
				if (typeIndex[0] == treeNodes[1].id) {
					selectedIndex = typeIndex[1] * 1;
				} else {
					selectedIndex = null;
				}
			} else {
				selectedIndex = crumb[1] * 1;
			}
		}
	}
}