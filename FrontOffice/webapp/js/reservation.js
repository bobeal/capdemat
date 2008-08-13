var reservations = new Array();
var reservationServlet = "";
var dataType = null;
var maxSubscriberPlaces = null;
var maxFullPlaces = null;
var maxHalfPlaces = null;
var guiType = "";

function initXmlReservation(servletAction, divId, gui) {
	reservationServlet = servletAction;
	guiType = gui;
	sendRequest(servletAction, 'load', null, false, loadXmlReservation, divId);
}

function loadXmlReservation(text, divId) {
	var xml = (new DOMParser()).parseFromString(text, "text/xml");

	dataType = xml.firstChild.getAttribute("type");
	maxSubscriberPlaces = xml.firstChild.getAttribute("maxSubscriberPlaces");
	maxFullPlaces = xml.firstChild.getAttribute("maxFullPlaces");
	maxHalfPlaces = xml.firstChild.getAttribute("maxHalfPlaces");

	var nodes = xml.firstChild.childNodes;

	for (i = 0; i < nodes.length; i++) {
		addXmlReservation(nodes[i]);
	}
	writeReservations(divId);
	resetDisplayDetail();
}

function addXmlReservation(node) {
	if (node.nodeType == 1) {
		var reservation = addReservation(
							node.getAttribute("key"), 
							node.getAttribute("text"), 
							node.getAttribute("message")
							);

		if (dataType == "ticket") {
			reservation.setDate(node.getAttribute("date"));
			reservation.setAvailable(node.getAttribute("available"));

		} else if (dataType == "referential") {
			reservation.setPrecision(node.getAttribute("precision"));
			reservation.setPriority(node.getAttribute("priority"));
			reservation.setPrecisionLabel(node.getAttribute("precisionLabel"));
			reservation.setPriorityLabel(node.getAttribute("priorityLabel"));
		}			

		var children = node.childNodes;
		for (var i = 0; i < children.length; i++) {
			reservation.addXmlDetail(children[i]);
		}
	}
}

function addReservation(key, text, message) {
    var newIndex = reservations.length;
	reservation = new ReservationItem(null);
	reservation.setKey(key);
	reservation.setText(text);
	if (message == null)
		message = "";
	reservation.setMessage(message);

	reservation.setIndex(newIndex);
    reservations[newIndex] = reservation;
    
    return reservations[newIndex];
}

function getReservation(index) {
	if ((index >= 0) && (index < reservations.length))
		return reservations[index];
		
	return null;
}

function hasReservations() {
	for (var i = 0; i < reservations.length; i++) {
		if (reservations[i].getAllReserved() > 0)
			return true;
	}
	return false;	
}

function hasReferential() {
	updateReferential();
	for (var i = 0; i < reservations.length; i++) {
		if (reservations[i].hasSelection())
			return true;
	}
	return false;	
}

function updateReferential() {
	var buffer = ""
	for (var i = 0; i < reservations.length; i++) {
		reservations[i].getSelection();
		buffer += reservations[i].writeSelection("");
	}
	if (buffer != "") {
		buffer = "<data>" + buffer + "</data>";
		sendRequest(reservationServlet, "savexml", buffer, false, treatResult, null);
	}
}

function displayReservations() {
	var resultString = "";
	for (var i = 0; i < reservations.length; i++) {
		resultString += reservations[i].display();
	}
	return resultString;
}

var trIndex = 0;
function writeReservations(id) {
	var resultString = "";
	if ((guiType != null) && (guiType == "new")) {
		if (dataType == "ticket") {
	        resultString += '<table class="ticket_table_header">\n';
	        resultString += '  <tr>\n';
	        resultString += '    <th class="th th1"><h1 class="title">TITRE DU SPECTACLE</h1></th>\n';
	        resultString += '    <th class="th th2"><h1 class="title">DATE</h1></th>\n';
	        resultString += '    <th class="th th3"><h1 class="title">PLACES DISPONIBLES</h1></th>\n';
	        resultString += '    <th class="th th4"><h1 class="title">EN ATTENTE</h1></th>\n';
	        resultString += '  </tr>\n';
	        resultString += '</table>\n';
	        resultString += '<div class="overflow">\n';
	        resultString += '  <table class="ticket_table_body" id="TicketTable" cellpadding="0" cellspacing="0">\n';
			trIndex = 0;
		} else if (dataType == "referential") {
        	resultString += '<ul class="dropdown_list">\n';
		}
	}

	for (var i = 0; i < reservations.length; i++) {
		resultString += reservations[i].write();
	}
	if ((guiType != null) && (guiType == "new")) {
		if (dataType == "ticket") {
	        resultString += '    <tr class="tr_last">\n';
	        resultString += '      <td colspan="4" class="td"></td>\n';
	        resultString += '    </tr>\n';
	        resultString += '  </table>\n';
	        resultString += '</div>\n';
		} else if (dataType == "referential") {
        	resultString += '</ul>\n';
		}
	}
    var elem = document.getElementById(id);
    elem.innerHTML = resultString;
    return resultString;
}

function resetDisplayDetail() {
	for (var i = 0; i < reservations.length; i++) {
		reservations[i].resetDisplayDetail();
	}
}

function toggleDetail() { // More than one argument can be passed to be toggled
    for (var i = 0; i < arguments.length; i++) {
	    var toggleDiv = document.getElementById(arguments[i]);
		if (toggleDiv != null) {
	        if (toggleDiv.style.display != 'none')
	        	toggleDiv.style.display = 'none';
	        else
	        	toggleDiv.style.display = '';
	    }
    }
}

function toggleTableRow(indexString) {
	var spectacle = findReservation(indexString);

	if (spectacle.getNbChildren() > 0) {
		var ticketTable = document.getElementById("TicketTable");
		if (ticketTable != null) {
			var trClassName = ticketTable.rows[spectacle.getTrIndex()].className;
			var posSelected = trClassName.indexOf(' selected')
			var childrenHidden = true;
			for (var i = 0; i <= spectacle.getNbChildren(); i++) {
				var index = spectacle.getTrIndex() + 1 + i;
				if (index < ticketTable.rows.length) {
					if (ticketTable.rows[index].style.display != 'none') {
						ticketTable.rows[index].style.display = 'none';
						childrenHidden = true;
					} else {
						ticketTable.rows[index].style.display = '';
						childrenHidden = false;
					}
				}
			}
			if (childrenHidden) {
				if (posSelected != -1)
					ticketTable.rows[spectacle.getTrIndex()].className = trClassName.substring(0, posSelected);
			} else {
				if (posSelected == -1)
					ticketTable.rows[spectacle.getTrIndex()].className += ' selected';
			}
		}
	}
}

function toggleReferential(id) {
	var element = document.getElementById(id);
	
	var style = null;
	var clazz = element.className;

	if (clazz == 'element open') {
		element.className = 'element close';
		style='none';

	} else if (clazz == 'element close') {
		element.className = 'element open';
		style='';
	}
	
	if (style != null) {
		var child = element.firstChild.nextSibling;
		while (child != null) {
			if ((typeof child.style != 'undefined') && (child.tagName != "A")){
				child.style.display = style;
			}
			child = child.nextSibling;
		}
	}
}

function findReservation(indexString) {
	var indices = indexString.split('-');
	var i = 0;
	var spectacle = getReservation(indices[i++]);
	while (i < indices.length) {
		spectacle = spectacle.getDetail(indices[i++]);
	}
	return spectacle;
}

function reservePlaces(indexString) {
	var spectacle = findReservation(indexString);

	if (checkRequestedPlaces(indexString)) {
		var i = 0;
		var detailElement = document.getElementById('detail-' + indexString + "-" + i);
		while (detailElement != null) {
			var detailItem = spectacle.getDetail(i);
			detailItem.setReserved(detailElement.value * 1);
			i++;
			detailElement = document.getElementById('detail-' + indexString + "-" + i);
		}
		var reservation = spectacle;
		while (reservation != null) {
			var id = reservation.getIndexString();
			var available = document.getElementById('available-' + id);
			var reserved = document.getElementById('reserved-' + id);
		
			setElementLabel(available, reservation.writeAvailable());
			setElementLabel(reserved, reservation.writeReserved());
	
			reservation = reservation.getParent();		
		}
		
		updateReservation(spectacle);
	}
}

function setElementLabel(htmlElement, newText) {
	if ((guiType != null) && (guiType == "new")) {
		var oldInnerHtml = htmlElement.innerHTML;
		var dummy = oldInnerHtml.toLowerCase();
		anchorStart = dummy.indexOf("<a");
		anchorStart = dummy.indexOf(">", anchorStart) + 1;
		anchorEnd = dummy.indexOf("</a>");
		
		htmlElement.innerHTML = oldInnerHtml.substring(0, anchorStart) + newText + oldInnerHtml.substring(anchorEnd);

	} else {
		htmlElement.innerHTML = newText;
	}
}

function requestedPlaces(indexString) {
	var spectacle = findReservation(indexString);
	var i = 0;
	var nbPlaces = 0;
	var detailElement = document.getElementById('detail-' + indexString + "-" + i);
	while (detailElement != null) {
		nbPlaces += detailElement.value * 1
		i++;
		detailElement = document.getElementById('detail-' + indexString + "-" + i);
	}
	return nbPlaces;
}

function checkRequestedPlaces(indexString) {
	var spectacle = findReservation(indexString);
	var i = 0;
	var nbPlaces = 0;
	var nbSubscriberPlaces = 0;
	var nbFullPlaces = 0;
	var nbHalfPlaces = 0;
	var detailElement = document.getElementById('detail-' + indexString + "-" + i);
	while (detailElement != null) {
		if (maxSubscriberPlaces != null) {		
			var detailItem = spectacle.getDetail(i);
			if (detailItem.isSubscriberPrice())
				nbSubscriberPlaces += detailElement.value * 1
		}
		if (maxFullPlaces != null) {		
			var detailItem = spectacle.getDetail(i);
			if (detailItem.isFullPrice())
				nbFullPlaces += detailElement.value * 1
		}
		if (maxHalfPlaces != null) {		
			var detailItem = spectacle.getDetail(i);
			if (detailItem.isHalfPrice())
				nbHalfPlaces += detailElement.value * 1
		}
		nbPlaces += detailElement.value * 1
		i++;
		detailElement = document.getElementById('detail-' + indexString + "-" + i);
	}
	if (((maxFullPlaces != null) && (nbFullPlaces > maxFullPlaces)) ||
		((maxHalfPlaces != null) && (nbHalfPlaces > maxHalfPlaces))) {
		alert("Votre abonnement vous autorise " + maxFullPlaces + " places à plein tarif et " + maxHalfPlaces + " places à tarif réduit.");
		return false;
	}
	if ((maxSubscriberPlaces != null) && (nbSubscriberPlaces > maxSubscriberPlaces)) {
		alert("Le maximum de places à tarif privilégé pour votre abonnement est " + maxSubscriberPlaces + ".");
		return false;
	}
	if (nbPlaces > spectacle.getAllAvailable()) {
		alert("Il n'y a pas assez de places disponibles.");
		return false;
	}
	return true;
}

function updateReservation(reservation) {
	var buffer = reservation.writeData("");
//	alert(buffer);
	sendRequest(reservationServlet, "savexml", buffer, true, treatResult, reservation);
}

function treatResult(responseText, extraData) {
	if (responseText.length > 0) {
// Parse the response text to get the remaining places available on the server
// Check the difference between remaining places from server and client, apply 
// the difference to the available field on the client.
		var xml = (new DOMParser()).parseFromString(responseText, "text/xml");
		var node = xml.firstChild.firstChild;
		
		extraData.setAvailable(node.getAttribute("available") * 1);

		var id = extraData.getIndexString();
		var available = document.getElementById('available-' + id);
		available.innerHTML = extraData.writeAvailable();
	}
}

function getValue(value) {
	if ((value == null) || (value == 0))
		return "";
		
	return value;
}

// ReservationItem object
    function ReservationItem(parentItem) {
    	this.key = "";
    	this.text = "";
    	this.message = "";
    	
    	this.date = "";
		this.available = "";
		this.reserved = "";
		this.price = "";
		this.subscriberPrice = false;
		this.fullPrice = false;
		this.halfPrice = false;
		
		this.selected = false;
		this.precision = "";
		this.priority = "";
		this.precisionLabel = "";
		this.priorityLabel = "";
		
		this.index = 0;
		this.trIndex = 0;
    	this.parentItem = parentItem;
		this.children = new Array();
		this.displayDetail = true;
    }
    
    ReservationItem.prototype.getRemaining = function() {
		return this.getAllAvailable() - this.getAllReserved();    	
	}
	
    ReservationItem.prototype.getAllAvailable = function() {
		var count = 0;
		if (this.available != null)
			count = this.available * 1;
		
		for (var i = 0; i < this.children.length; i++) {
			var detailItem = this.children[i];
			count += detailItem.getAllAvailable();
		}
		return count;
    }
	    
    ReservationItem.prototype.getAllReserved = function() {
		var count = 0;
		if (this.reserved != null)
			count = this.reserved * 1;
		
		for (var i = 0; i < this.children.length; i++) {
			var detailItem = this.children[i];
			count += detailItem.getAllReserved();
		}
		return count;
    }
	    
    ReservationItem.prototype.getTotalPrice = function() {
		var totalPrice = 0;
		if (this.price != null)
    		totalPrice = this.price * this.reserved;

		for (var i = 0; i < this.children.length; i++) {
			var detailItem = this.children[i];
			totalPrice += detailItem.getTotalPrice();
		}
		return totalPrice;
    }
    
	ReservationItem.prototype.getSelection = function() {
		this.selected = false;
		if (this.children.length == 0) {
			var index = this.getIndexString();
			var elem = document.getElementById("detail-" + index);
			if (elem != null)
				this.selected = elem.checked;

			elem = document.getElementById("precision-" + index);
			if (elem != null)
				this.setPrecision(elem.value);

			elem = document.getElementById("priority-" + index);
			if (elem != null)
				this.setPriority(elem.value);

							
		} else {
			for (var i = 0; i < this.children.length; i++) {
				var child = this.children[i];
				if (child.getSelection())
					this.selected = true;
			}
		}
		return this.selected;
	}
	
	ReservationItem.prototype.hasSelection = function() {
		return this.selected;
	}
	
	ReservationItem.prototype.addXmlDetail = function(node) {
		if (node.nodeType == 1) {
			var detail = this.addDetail(node.getAttribute("key"), 
										node.getAttribute("text"));
										
			if (dataType == "ticket") {
				detail.setDate(node.getAttribute("date"));
				detail.setAvailable(node.getAttribute("available"));
				detail.setReserved(node.getAttribute("reserved"));
				detail.setPrice(node.getAttribute("price"));
				detail.setSubscriberPrice(node.getAttribute("subscriber") != null);
				detail.setFullPrice(node.getAttribute("full") != null);
				detail.setHalfPrice(node.getAttribute("half") != null);

			} else if (dataType == "referential") {
				detail.setSelected(node.getAttribute("selected"));
				detail.setPrecision(node.getAttribute("precision"));
				detail.setPriority(node.getAttribute("priority"));
				detail.setPrecisionLabel(node.getAttribute("precisionLabel"));
				detail.setPriorityLabel(node.getAttribute("priorityLabel"));
			}			
			var children = node.childNodes;
			for (var i = 0; i < children.length; i++) {
				detail.addXmlDetail(children[i]);
			}
		}
	}

    ReservationItem.prototype.addDetail = function(key, text) {
        var newIndex = this.children.length;
		detail = new ReservationItem(this);
		detail.setKey(key);
		detail.setText(text);

		detail.setIndex(newIndex);
        this.children[newIndex] = detail;
        
		this.setDisplayDetail(false);
		if (this.getParent() != null)
			this.getParent().setDisplayDetail(true);
		
        return this.children[newIndex];
    }
    
    ReservationItem.prototype.getDetail = function(index) {
		if ((index >= 0) && (index < this.children.length))
			return this.children[index];
			
		return null;
    }
    
	ReservationItem.prototype.resetDisplayDetail = function() {
		if (this.children.length > 0) {
			for (var i = 0; i < this.children.length; i++) {
				this.children[i].resetDisplayDetail();
			}
				
			if (!this.selected) {
				if ((guiType != null) && (guiType == "new")) {
					if (dataType == 'ticket')
						toggleTableRow(this.getIndexString());
					if (dataType == 'referential')
						toggleReferential(this.getIndexString());
				} else {
					var index = this.getIndexString();
				    toggleDetail("detail-" + index);
				    toggleDetail("precision-" + index);
				    toggleDetail("priority-" + index);
				}
			}
		}
	}

    ReservationItem.prototype.display = function(indent) {
		if (indent == null) indent = "    ";
		
    	var resultString = this.text + ": " + 
    						this.getRemaining() + " places available, " + 
    						this.getAllReserved() + " places reserved, " + 
    						this.getTotalPrice() + " euros\n";
		for (var i = 0; i < this.children.length; i++) {
			var detailItem = this.children[i];
			resultString += indent + detailItem.display(indent + "    ");
		}
		return resultString;
	}
	
	ReservationItem.prototype.writeData = function(indent) {
		var buffer = indent + "<data key=\"" + this.getKey() + "\"";
		
		if (this.children.length == 0)
			buffer += " reserved=\"" + this.getReserved() + "\"";
		
		buffer += ">\n";
		
		for (var i = 0; i < this.children.length; i++)
			buffer += this.children[i].writeData(indent + "  ");
			
		buffer +=indent + "</data>\n";
		
		return buffer;
	}
	
	ReservationItem.prototype.writeSelection = function(indent) {
		var buffer = "";
		if (this.selected) {
			buffer += indent + "<data key=\"" + this.getKey() + "\"";
			buffer += " selected=\"" + this.selected + "\"";
			
			if (this.children.length == 0) {
				buffer += " precision=\"" + this.getPrecision() + "\"";
				buffer += " priority=\"" + this.getPriority() + "\"";
			}
			buffer += ">\n";
			
			for (var i = 0; i < this.children.length; i++)
				buffer += this.children[i].writeSelection(indent + "  ");
				
			buffer +=indent + "</data>\n";
		}
		return buffer;
	}
	
	ReservationItem.prototype.writeAvailable = function() {
		var buffer = "";
		if (this.getRemaining() == 1)
			buffer = this.getRemaining() + " place disponible";
		else
			buffer = this.getRemaining() + " places disponibles";
			
		return buffer;
	}
	
	ReservationItem.prototype.writeReserved = function() {
		var buffer = "";
		var allReserved = this.getAllReserved();
		var totalPrice = this.getTotalPrice();
		
		if (allReserved == 0)
			buffer = "&nbsp;";
		else if (allReserved == 1)
			buffer = "<b>" + allReserved + "</b> place réservée : <b>" + totalPrice + " &euro;</b>"
		else
			buffer = "<b>" + allReserved + "</b> places réservées : <b>" + totalPrice + " &euro;</b>"

		return buffer;
	}
	
	ReservationItem.prototype.write = function(parentIndex) {
		if ((this.children.length > 0) || (parentIndex == null))
			return this.writeReservation(parentIndex);
		else
			return this.writeDetail(parentIndex);
	}
	
	ReservationItem.prototype.writeReservation = function(parentIndex) {
		if ((guiType != null) && (guiType == "new")) {
			if (dataType == "ticket")
				return this.writeNewReservation(parentIndex);

			if (dataType == "referential")
				return this.writeNewReferential(parentIndex);
		}
		var index = this.getIndexString();

		var toggleArguments = "'detail-" + index + "'"; 
		if (dataType == "referential") {
			if (this.getPrecisionLabel() != null)
				toggleArguments += ",'precision-" + index + "'";
			if (this.getPriorityLabel() != null)
				toggleArguments += ",'priority-" + index + "'";
		}
			
		var buffer = "<div class=\"reservation\">\n";
		buffer += "  <div class=\"reservation-header\" onclick=\"javascript:toggleDetail(" + toggleArguments + ");\">\n";
		buffer += "    <div class=\"title\">" + this.getText() + "</div>\n";
		if (dataType == "ticket") {
			buffer += "    <div class=\"available\" id=\"available-" + index + "\">\n";
			buffer += "      " + this.writeAvailable() + "\n";
			buffer += "    </div>\n";
			buffer += "    <div class=\"reserved\" id=\"reserved-" + index + "\">\n";
			buffer += "      " + this.writeReserved() + "\n";
			buffer += "    </div>\n";
			buffer += "    <div class=\"subtitle\">\n";
			buffer += "      <div class=\"date\">" + this.getDate() + "</div>\n";
			buffer += "      <div class=\"info\">" + this.getMessage() + "</div>\n";
			buffer += "    </div>\n";
			
		} else if (dataType == "referential") {
			if (this.getPrecisionLabel() != null) {
				buffer += "    <div class=\"precision\" id=\"precision-" + index + "\">\n";
				buffer += "      " + this.getPrecisionLabel() + "\n";
				buffer += "    </div>\n";
			}
			if (this.getPriorityLabel() != null) {
				buffer += "    <div class=\"priority\" id=\"priority-" + index + "\">\n";
				buffer += "      " + this.getPriorityLabel() + "\n";
				buffer += "    </div>\n";
			}
			buffer += "    <div class=\"subtitle\">\n";
			buffer += "      <div class=\"info\">" + this.getMessage() + "</div>\n";
			buffer += "    </div>\n";
		}
		buffer += "  </div>\n";
		if (this.hasGrandChildren())
			buffer += "  <div class=\"reservation\" id=\"detail-" + index + "\">\n";
		else {
			buffer += "  <div class=\"detail\" id=\"detail-" + index + "\">\n";
		}
		var reduction = false;
		for (var i = 0; i < this.children.length; i++) {
			var detailItem = this.children[i];
			buffer += detailItem.write(index);
			
			if (detailItem.isSubscriberPrice() || detailItem.isFullPrice() || detailItem.isHalfPrice())
				reduction = true;
		}
		if (reduction)
			buffer += "     <div class=\"info\">** Tarif abonné</div>\n";
		buffer += "  </div>\n";

		buffer += "</div>\n";
		
		return buffer;
	}
	
	ReservationItem.prototype.writeDetail = function(parentIndex) {
		if ((guiType != null) && (guiType == "new")) {
			if (dataType == "ticket")
				return this.writeNewTicketDetail(parentIndex);

			if (dataType == "referential")
				return this.writeNewReferentialDetail(parentIndex);
		}
		var index = this.getIndexString();
		var buffer = "";
		
		buffer +="    <div class=\"detail-field\">\n";

		if (dataType == "ticket") {
			buffer += "      <label for=\"detail-" + index + "\">\n";
			buffer += "        " + this.getText();
			if (this.isSubscriberPrice() || this.isFullPrice() || this.isHalfPrice())
				buffer += " **";
			buffer += "\n";
			buffer += "      </label>\n";
			buffer += "      <div class=\"price\">\n";
		   	buffer += "        " + this.getPrice() + " &euro;\n";
		   	buffer += "      </div>\n";
			buffer += "      <div class=\"field\">\n";
		   	buffer += "        <input type=\"text\" id=\"detail-" + index + "\" maxlength=\"2\" size=\"2\" value=\"" + getValue(this.getReserved()) + "\"/>\n";
		   	buffer += "      </div>\n";
			if (this.getIndex() == this.getParent().getNbChildren()-1) {
		   		buffer += "      <div class=\"enabled-button\" onclick=\"javascript:reservePlaces('" + parentIndex + "');\">\n";
		   		buffer += "        Réserver\n";
		   		buffer += "      </div>\n";
			}
		} else if (dataType == "referential") {
			var checked = (this.selected) ? "checked" : "";
			buffer += "      <label for=\"detail-" + index + "\">\n";
			buffer += "        <input type=\"checkbox\" id=\"detail-" + index + "\" value=\"ok\" " + checked + "/> " + this.getText() + "\n";
			buffer += "      </label>\n";
			if (this.getParent().getPrecisionLabel() != null) {
				buffer += "      <div class=\"precision\">\n";
			   	buffer += "        <input type=\"text\" id=\"precision-" + index + "\" size=\"10\" value=\"" + getValue(this.getPrecision()) + "\"/>\n";
			   	buffer += "      </div>\n";
			}
			if (this.getParent().getPriorityLabel() != null) {
				buffer += "      <div class=\"priority\">\n";
			   	buffer += "        <input type=\"text\" id=\"priority-" + index + "\" maxlength=\"2\" size=\"2\" value=\"" + getValue(this.getPriority()) + "\"/>\n";
			   	buffer += "      </div>\n";
			}
		}
		buffer += "    </div>\n";
		
		return buffer;
	}
	
	ReservationItem.prototype.writeNewReservation = function(parentIndex) {
		var index = this.getIndexString();

		var trClass = "";
		if (this.index == 0)
			trClass = ' class="tr_first"';
			
		var buffer = "";
		var argument = "'" + index + "'"
        buffer += '    <tr' + trClass + '>\n';
        buffer += '      <td class="td td1"><p class="paragraph"><a href="javascript:toggleTableRow(' + argument + ');" title="">' + this.writeTitle() + '</a></p></td>\n';
        buffer += '      <td class="td td2"><p class="paragraph"><a href="javascript:toggleTableRow(' + argument + ');" title="">' + this.getDate() + '</a></p></td>\n';
        buffer += '      <td class="td td3" id="available-' + index + '"><p class="paragraph"><a href="javascript:toggleTableRow(' + argument + ');" title="">' + this.writeAvailable() + '</a></p></td>\n';
        buffer += '      <td class="td td4" id="reserved-' + index + '"><p class="paragraph"><a href="javascript:toggleTableRow(' + argument + ');" title="">' + this.writeReserved() + '</a></p></td>\n';
        buffer += '    </tr>\n';
		this.trIndex = trIndex++;		

		var reduction = false;
		for (var i = 0; i < this.children.length; i++) {
			var detailItem = this.children[i];
			buffer += detailItem.write(index);
			
			if (detailItem.isSubscriberPrice() || detailItem.isFullPrice() || detailItem.isHalfPrice())
				reduction = true;
		}
		if (reduction)
			buffer += "";
		return buffer;
	}

	ReservationItem.prototype.writeNewReferential = function(parentIndex) {
		var index = this.getIndexString();
		var argument = "'" + index +"'";

		var buffer = '';
        buffer += '<li class="element open" id="' + index + '">\n';
        buffer += '<a href="javascript:toggleReferential(' + argument + ');" title="" class="element_link"><span class="custom_color"></span>' + this.writeTitle().toUpperCase() + '</a>\n';
		if (this.hasGrandChildren()) {
       		buffer += '<ul class="sublist">\n';
			for (var i = 0; i < this.children.length; i++) {
				var detailItem = this.children[i];
				if (detailItem.children.length > 0) {
					buffer += detailItem.write(index);
				}
			}
       		buffer += '</ul>\n';
       		
		} else {
			if (this.getPrecisionLabel() != null)
	        	buffer += '<div class="element_th">NIVEAU</div>\n';
			if (this.getPriorityLabel() != null)
	        	buffer += '<div class="element_th">PRIORITE</div>\n';
		}
		var leaf = false;
		for (var i = 0; i < this.children.length; i++) {
			var detailItem = this.children[i];
			if (detailItem.children.length == 0) {
				if (!leaf) {
   					buffer += '<table class="table_type101">\n';
					leaf = true;
				}
				buffer += detailItem.write(index);
			}
		}
		if (leaf)
	   		buffer += '</table>\n';

   		buffer += '</li>\n';
/**		
        buffer += '      <li class="element open">\n';
        buffer += '        <a href="#" title="" class="element_link"><span class="custom_color"></span>INSTRUMENT</a>\n';
        buffer += '        <div class="element_th">NIVEAU</div>\n';
        buffer += '        <div class="element_th">PRIORITE</div>\n';
        buffer += '        <table class="table_type101">\n';
        buffer += '          <tr>\n';
        buffer += '            <td class="td td1">\n';
        buffer += '              <input type="checkbox" id="instrument_guitare" name="instrument" value="guitare" class="input_checkbox" /><label for="instrument_guitare" class="label">Guitare</label>\n';
        buffer += '            </td>\n';
        buffer += '            <td class="td td2"><input type="text" id="instrument_level_guitare" name="instrument_level" class="input_text" /></td>\n';
        buffer += '            <td class="td td3"><input type="text" id="instrument_priority_guitare" name="instrument_priority" class="input_text" /></td>\n';
        buffer += '          </tr>\n';
        buffer += '          <tr>\n';
        buffer += '            <td class="td td1">\n';
        buffer += '              <input type="checkbox" id="instrument_piano" name="instrument" value="piano" class="input_checkbox" /><label for="instrument_piano" class="label">Piano</label>\n';
        buffer += '            </td>\n';
        buffer += '            <td class="td td2"><input type="text" id="instrument_level_piano" name="instrument_level" class="input_text" /></td>\n';
        buffer += '            <td class="td td3"><input type="text" id="instrument_priority_piano" name="instrument_priority" class="input_text" /></td>\n';
        buffer += '          </tr>\n';
        buffer += '          <tr>\n';
        buffer += '            <td class="td td1">\n';
        buffer += '              <input type="checkbox" id="instrument_harmonica" name="instrument" value="harmonica" class="input_checkbox" /><label for="instrument_harmonica" class="label">Harmonica</label>\n';
        buffer += '            </td>\n';
        buffer += '            <td class="td td2"><input type="text" id="instrument_level_harmonica" name="instrument_level" class="input_text" /></td>\n';
        buffer += '            <td class="td td3"><input type="text" id="instrument_priority_harmonica" name="instrument_priority" class="input_text" /></td>\n';
        buffer += '          </tr>\n';
        buffer += '        </table>\n';
        buffer += '      </li>\n';
        buffer += '      <li class="element open">\n';
        buffer += '        <a href="#" title="" class="element_link"><span class="custom_color"></span>ACTIVITE D&quote;ENSEMBLE</a>\n';
        buffer += '        <div class="element_th">PRIORITE</div>\n';
        buffer += '        <table class="table_type101">\n';
        buffer += '          <tr>\n';
        buffer += '            <td class="td td1">\n';
        buffer += '              <input type="checkbox" id="activite_chambre" name="activite" value="chambre" class="input_checkbox" checked="checked" /><label for="activite_chambre" class="label">Musique de chambre</label>\n';
        buffer += '            </td>\n';
        buffer += '            <td class="td td3"><input type="text" id="activite_priority_chambre" name="activite_priority" class="input_text" value="1" /></td>\n';
        buffer += '          </tr>\n';
        buffer += '          <tr>\n';
        buffer += '            <td class="td td1">\n';
        buffer += '              <input type="checkbox" id="activite_orchestre" name="activite" value="orchestre" class="input_checkbox" /><label for="activite_orchestre" class="label">Orchestre</label>\n';
        buffer += '            </td>\n';
        buffer += '            <td class="td td3"><input type="text" id="activite_priority_orchestre" name="activite_priority" class="input_text" /></td>\n';
        buffer += '          </tr>\n';
        buffer += '          <tr>\n';
        buffer += '            <td class="td td1">\n';
        buffer += '              <input type="checkbox" id="activite_jazz" name="activite" value="jazz" class="input_checkbox" checked="checked" /><label for="activite_jazz" class="label">Jazz</label>\n';
        buffer += '            </td>\n';
        buffer += '            <td class="td td3"><input type="text" id="activite_priority_jazz" name="activite_priority" class="input_text" value="2" /></td>\n';
        buffer += '          </tr>\n';
        buffer += '          <tr>\n';
        buffer += '            <td class="td td1">\n';
        buffer += '              <input type="checkbox" id="activite_rock" name="activite" value="rock" class="input_checkbox" /><label for="activite_rock" class="label">Rock</label>\n';
        buffer += '            </td>\n';
        buffer += '            <td class="td td3"><input type="text" id="activite_priority_rock" name="activite_priority" class="input_text" /></td>\n';
        buffer += '          </tr>\n';
        buffer += '        </table>\n';
        buffer += '      </li>\n';
        buffer += '      <li class="element element_form_row">\n';
        buffer += '        <input type="checkbox" id="formation_musicale" name="formation_musicale" value="rock" class="input_checkbox"  checked="checked" /><label for="formation_musicale" class="label"><strong>FORMATION MUSICALE (lorem ipsum sum est...)</strong></label>\n';
        buffer += '      </li>\n';
        buffer += '    </ul>\n';
        buffer += '  </li>\n';
        buffer += ' </ul>\n';
*/
		return buffer;
	}
	
	ReservationItem.prototype.writeTitle = function() {
		if ((this.getMessage() != null) && (this.getMessage() != ""))
			return this.getText() + " (" + this.getMessage() + ")";
			
		return this.getText();
	}
	
	ReservationItem.prototype.writeNewTicketDetail = function(parentIndex) {
		var index = this.getIndexString();
		var argument = "'" + parentIndex +"'";

		var buffer = "";
		
        buffer += '    <tr class="selected_notice">\n';
        buffer += '      <td colspan="2" class="td td-text"><p class="paragraph">' + this.writeTicketDetail() + '</p></td>\n';
        buffer += '      <td colspan="2" class="td td-data"><input type="text" id="detail-' + index + '" maxlength="2" size="2" value="' + getValue(this.getReserved()) + '"/></td>\n';
        buffer += '    </tr>\n';
		this.trIndex = trIndex++;		
		if (this.getIndex() == this.getParent().getNbChildren()-1) {
	        buffer += '    <tr class="selected_button">\n';
	        buffer += '      <td colspan="2" class="td td-text">&nbsp;</td>\n';
	        buffer += '      <td colspan="2" class="td td-data"><p class="paragraph submit"><a href="javascript:reservePlaces(' + argument + ');" title="">Acheter</a></td>\n';
	        buffer += '    </tr>\n';
			trIndex++;
		}

		return buffer;
	}
	
	ReservationItem.prototype.writeTicketDetail = function() {
		var buffer = '> ' + this.getText() + ' : ' + this.getPrice() + "&euro;\n";
		if (this.isSubscriberPrice() || this.isFullPrice() || this.isHalfPrice())
			buffer += " **";
			
		return buffer;
	}
	
	ReservationItem.prototype.writeNewReferentialDetail = function(parentIndex) {
		var index = this.getIndexString();

		var buffer = "";
		var title = "";
				
		var checked = (this.selected) ? "checked" : "";

        buffer += '<tr>\n';
        buffer += '<td class="td td1">\n';
        buffer += '<input type="checkbox" id="detail-' + index + '" name="detail-' + index + '" value="ok" class="input_checkbox" '+ checked +'/>';
        buffer += '<label for="detail-' + index + '" class="label">' + this.getText() + '</label>\n';

        buffer += '</td>\n';
		if (this.getParent().getPrecisionLabel() != null) {
        	buffer += '  <td class="td td2"><input type="text" id="precision-' + index + '" value="' + getValue(this.getPrecision()) + '" class="input_text" /></td>\n';
		}
		if (this.getParent().getPriorityLabel() != null) {
	        buffer += '  <td class="td td3"><input type="text" id="priority-' + index + '" value="' + getValue(this.getPriority()) + '" class="input_text" /></td>\n';
		}
        buffer += '</tr>\n';

		return buffer;
	}
	
	ReservationItem.prototype.getIndexString = function() {
		var indexString = "" + this.index;
		
		var parent = this.getParent();
		while (parent != null) {
			indexString = parent.getIndex() + "-" + indexString;
			parent = parent.getParent();
		}
		return indexString;
	}
	
    ReservationItem.prototype.hasGrandChildren = function() {
		for (var i = 0; i < this.children.length; i++) {
			var detailItem = this.children[i];
			if (detailItem.getNbChildren() > 0)
				return true;
		}
		return false;
    }
	
    ReservationItem.prototype.setKey = function(key) {
    	this.key = key;	
    }
    
    ReservationItem.prototype.getKey = function() {
    	return this.key;
    }
    
    ReservationItem.prototype.setText = function(text) {
    	this.text = text;	
    }
    
    ReservationItem.prototype.getText = function() {
    	return this.text;
    }
    
    ReservationItem.prototype.setMessage = function(message) {
    	this.message = message;	
    }
    
    ReservationItem.prototype.getMessage = function() {
    	return this.message;
    }
    
    ReservationItem.prototype.setDate = function(date) {
    	this.date = date;	
    }
    
    ReservationItem.prototype.getDate = function() {
    	return this.date;
    }
    
    ReservationItem.prototype.setAvailable = function(available) {
    	this.available = available;	
    }
    
    ReservationItem.prototype.getAvailable = function() {
    	return this.available;
    }
    
    ReservationItem.prototype.setReserved = function(reserved) {
    	this.reserved = reserved;	
    }
    
    ReservationItem.prototype.getReserved = function() {
    	return this.reserved;
    }
    
    ReservationItem.prototype.setPrice = function(price) {
    	this.price = price;	
    }
    
    ReservationItem.prototype.getPrice = function() {
    	return this.price;
    }
    
    ReservationItem.prototype.setSubscriberPrice = function(subscriberPrice) {
    	this.subscriberPrice = subscriberPrice;	
    }
    
    ReservationItem.prototype.isSubscriberPrice = function() {
    	return this.subscriberPrice;
    }
    
    ReservationItem.prototype.setFullPrice = function(fullPrice) {
    	this.fullPrice = fullPrice;	
    }
    
    ReservationItem.prototype.isFullPrice = function() {
    	return this.fullPrice;
    }
    
    ReservationItem.prototype.setHalfPrice = function(halfPrice) {
    	this.halfPrice = halfPrice;	
    }
    
    ReservationItem.prototype.isHalfPrice = function() {
    	return this.halfPrice;
    }
    
    ReservationItem.prototype.setSelected = function(selected) {
		if (selected== "true") {
	    	this.selected = true;
	    	if (this.getParent() != null)
		    	this.getParent().setSelected(selected);
		} else {
	    	this.selected = false;	
		}
    }
    
    ReservationItem.prototype.setPrecision = function(precision) {
    	this.precision = precision;	
    }
    
    ReservationItem.prototype.getPrecision = function() {
    	return this.precision;
    }
    
    ReservationItem.prototype.setPriority = function(priority) {
    	this.priority = priority;	
    }
    
    ReservationItem.prototype.getPriority = function() {
    	return this.priority;
    }
    
    ReservationItem.prototype.setPrecisionLabel = function(precisionLabel) {
    	this.precisionLabel = precisionLabel;	
    }
    
    ReservationItem.prototype.getPrecisionLabel = function() {
    	return this.precisionLabel;
    }
    
    ReservationItem.prototype.setPriorityLabel = function(priorityLabel) {
    	this.priorityLabel = priorityLabel;	
    }
    
    ReservationItem.prototype.getPriorityLabel = function() {
    	return this.priorityLabel;
    }
    
    ReservationItem.prototype.setIndex = function(index) {
    	this.index = index;	
    }
    
    ReservationItem.prototype.getIndex = function() {
    	return this.index;
    }
    
    ReservationItem.prototype.setTrIndex = function(trIndex) {
    	this.trIndex = trIndex;	
    }
    
    ReservationItem.prototype.getTrIndex = function() {
    	return this.trIndex;
    }
    
    ReservationItem.prototype.getParent = function() {
    	return this.parentItem;
    }
    
    ReservationItem.prototype.getNbChildren = function() {
    	return this.children.length;
    }
    
    ReservationItem.prototype.setDisplayDetail = function(displayDetail) {
    	this.displayDetail = displayDetail;	
    }
    
    ReservationItem.prototype.isDisplayDetail = function() {
    	return this.displayDetail;
    }
