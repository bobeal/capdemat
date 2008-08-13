
function addresseTypeAhead(city, code) {
    var autoCity = new AutoSuggestControl(document.getElementById(city), 
    					new RemoteSuggestions("town"), document.getElementById(code));
    var autoPostalCode = new AutoSuggestControl(document.getElementById(code), 
    					new RemoteSuggestions("postalcode", true), document.getElementById(city));
}


/**
 * An autosuggest textbox control.
 * @class
 * @scope public
 */
function AutoSuggestControl(oTextbox /*:HTMLInputElement*/, 
                            oProvider /*:SuggestionProvider*/,
                            oExtrabox) {
    
    /**
     * The currently selected suggestions.
     * @scope private
     */   
    this.cur /*:int*/ = -1;

    /**
     * The dropdown list layer.
     * @scope private
     */
    this.layer = null;
    
    /**
     * Suggestion provider for the autosuggest feature.
     * @scope private.
     */
    this.provider /*:SuggestionProvider*/ = oProvider;
    
    /**
     * The textbox to capture.
     * @scope private
     */
    this.textbox /*:HTMLInputElement*/ = oTextbox;
    
    /**
     * The value of the textbox as input by the user
     * @scope private
     */
    this.value = "";
    
    /**
     * The extra box to use.
     * @scope private
     */
    this.extrabox /*:HTMLInputElement*/ = oExtrabox;
    
    /**
     * The value of the extrabox as input by the user
     * @scope private
     */
    this.extravalue = "";
    this.initialextra = "";
    
    //initialize the control
    this.init();
    
}

/**
 * Autosuggests one or more suggestions for what the user has typed.
 * If no suggestions are passed in, then no autosuggest occurs.
 * @scope private
 * @param aSuggestions An array of suggestion strings.
 * @param bTypeAhead If the control should provide a type ahead suggestion.
 */
AutoSuggestControl.prototype.autosuggest = function (aSuggestions /*:Array*/,
                                                     bTypeAhead /*:boolean*/) {
    
    //make sure there's at least one suggestion
    this.cur = -1;
    if ((aSuggestions != null) && (aSuggestions.length > 0)) {
        if (bTypeAhead) {
        	this.cur = 0;
			var extra = "";
            this.typeAhead(aSuggestions[0]);
			if (this.extrabox != null)
				this.extrabox.value = aSuggestions[1];
        }
        
        this.showSuggestions(aSuggestions);
    } else {
        this.hideSuggestions();
    }
};

/**
 * Creates the dropdown layer to display multiple suggestions.
 * @scope private
 */
AutoSuggestControl.prototype.createDropDown = function () {

    var oThis = this;

    //create the layer and assign styles
    this.layer = document.createElement("div");
    this.layer.className = "suggestions";
    this.layer.style.visibility = "hidden";
    this.layer.style.width = this.textbox.offsetWidth +"px";

    //when the user clicks on the a suggestion, get the text (innerHTML)
    //and place it into a textbox
    this.layer.onmousedown = 
    this.layer.onmouseup = 
    this.layer.onmouseover = function (oEvent) {
        oEvent = oEvent || window.event;
        oTarget = oEvent.target || oEvent.srcElement;

        if (oEvent.type == "mousedown") {
            oThis.textbox.value = oTarget.firstChild.nodeValue;
            oThis.value = oThis.textbox.value;
            
            if (oThis.extrabox != null) {
	            oThis.extrabox.value = getListValue(oTarget.firstChild);
	            oThis.extravalue = oThis.extrabox.value;
            }
            oThis.hideSuggestions();
            
        } else if (oEvent.type == "mouseover") {
            oThis.highlightSuggestion(oTarget);
        } else {
            oThis.textbox.focus();
        }
    };
    
    
    document.body.appendChild(this.layer);
};

function getListValue(child) {
// Remove comment tag from arround the value
	return child.nextSibling.innerHTML.substring(4,child.nextSibling.innerHTML.length-3);
}

/**
 * Gets the left coordinate of the textbox.
 * @scope private
 * @return The left coordinate of the textbox in pixels.
 */
AutoSuggestControl.prototype.getLeft = function () /*:int*/ {

    var oNode = this.textbox;
    var iLeft = 0;
    
    while(oNode.tagName != "BODY") {
        iLeft += oNode.offsetLeft;
        oNode = oNode.offsetParent;        
    }
    
    return iLeft;
};

/**
 * Gets the top coordinate of the textbox.
 * @scope private
 * @return The top coordinate of the textbox in pixels.
 */
AutoSuggestControl.prototype.getTop = function () /*:int*/ {

    var oNode = this.textbox;
    var iTop = 0;
    
    while(oNode.tagName != "BODY") {
        iTop += oNode.offsetTop;
        oNode = oNode.offsetParent;
    }
    
    return iTop;
};

/**
 * Handles four keydown events.
 * @scope private
 * @param oEvent The event object for the keydown event.
 */
AutoSuggestControl.prototype.handleKeyDown = function (oEvent /*:Event*/) {

    switch(oEvent.keyCode) {
        case 38: //up arrow
            this.previousSuggestion();
            break;
        case 40: //down arrow 
            this.nextSuggestion();
            break;
        case 27: //escape
            this.hideSuggestions();
            break;
        case 9: //tab
            this.value = this.textbox.value;
            if (this.extrabox != null)
	            this.extravalue = this.extrabox.value;
            this.hideSuggestions();
            break;
        case 13: //enter
            this.value = this.textbox.value;
            if (this.extrabox != null)
	            this.extravalue = this.extrabox.value;
            this.hideSuggestions();
            break;
    }

};

/**
 * Handles keyup events.
 * @scope private
 * @param oEvent The event object for the keyup event.
 */
AutoSuggestControl.prototype.handleKeyUp = function (oEvent /*:Event*/) {

    var iKeyCode = oEvent.keyCode;

    //for backspace (8) and delete (46), shows suggestions without typeahead
    if (iKeyCode == 8 || iKeyCode == 46) {
        this.provider.requestSuggestions(this, false);
        
    //make sure not to interfere with non-character keys
    } else if (iKeyCode < 32 || (iKeyCode >= 33 && iKeyCode < 46) || (iKeyCode >= 112 && iKeyCode <= 123)) {
        //ignore
    } else {
        //request suggestions from the suggestion provider with typeahead
        this.provider.requestSuggestions(this, true);
    }
};

/**
 * Hides the suggestion dropdown.
 * @scope private
 */
AutoSuggestControl.prototype.hideSuggestions = function () {
    if (this.cur > -1) {
		this.textbox.value = this.value;
	    if (this.extrabox != null)
			this.extrabox.value = this.extravalue;
    }
	this.layer.style.visibility = "hidden";
};

/**
 * Highlights the given node in the suggestions dropdown.
 * @scope private
 * @param oSuggestionNode The node representing a suggestion in the dropdown.
 */
AutoSuggestControl.prototype.highlightSuggestion = function (oSuggestionNode) {
    
    for (var i=0; i < this.layer.childNodes.length; i++) {
        var oNode = this.layer.childNodes[i];
        if (oNode == oSuggestionNode) {
            oNode.className = "current"
        } else if (oNode.className == "current") {
            oNode.className = "";
        }
    }
};

/**
 * Initializes the textbox with event handlers for
 * auto suggest functionality.
 * @scope private
 */
AutoSuggestControl.prototype.init = function () {

    //save a reference to this object
    var oThis = this;
    
    //assign the onkeyup event handler
    this.textbox.onkeyup = function (oEvent) {
    
        //check for the proper location of the event object
        if (!oEvent) {
            oEvent = window.event;
        }    
        
        //call the handleKeyUp() method with the event object
        oThis.handleKeyUp(oEvent);
    };
    
    //assign onkeydown event handler
    this.textbox.onkeydown = function (oEvent) {
    
        //check for the proper location of the event object
        if (!oEvent) {
            oEvent = window.event;
        }    
        
        //call the handleKeyDown() method with the event object
        oThis.handleKeyDown(oEvent);
    };
    
    //assign onblur event handler (hides suggestions)    
    this.textbox.onblur = function () {
        oThis.hideSuggestions();
    };
    
    //assign onfocus event handler (shows suggestions)    
    this.textbox.onfocus = function () {
		if (oThis.extrabox != null)
			oThis.initialextra = oThis.extrabox.value;
		else
			oThis.initialextra = ""
        oThis.provider.requestSuggestions(oThis, false);
    };
    
    //create the suggestions dropdown
    this.createDropDown();
};

/**
 * Highlights the next suggestion in the dropdown and
 * places the suggestion into the textbox.
 * @scope private
 */
AutoSuggestControl.prototype.nextSuggestion = function () {
    var cSuggestionNodes = this.layer.childNodes;

    if (cSuggestionNodes.length > 0 && this.cur < cSuggestionNodes.length-1) {
        var oNode = cSuggestionNodes[++this.cur];
        this.highlightSuggestion(oNode);
        this.textbox.value = oNode.firstChild.nodeValue; 
		if (this.extrabox != null)
			this.extrabox.value = getListValue(oNode.firstChild);
    }
};

/**
 * Highlights the previous suggestion in the dropdown and
 * places the suggestion into the textbox.
 * @scope private
 */
AutoSuggestControl.prototype.previousSuggestion = function () {
    var cSuggestionNodes = this.layer.childNodes;

    if (cSuggestionNodes.length > 0 && this.cur > 0) {
        var oNode = cSuggestionNodes[--this.cur];
        this.highlightSuggestion(oNode);
        this.textbox.value = oNode.firstChild.nodeValue;   
		if (this.extrabox != null)
			this.extrabox.value = getListValue(oNode.firstChild);
    }
};

/**
 * Selects a range of text in the textbox.
 * @scope public
 * @param iStart The start index (base 0) of the selection.
 * @param iLength The number of characters to select.
 */
AutoSuggestControl.prototype.selectRange = function (iStart /*:int*/, iLength /*:int*/) {

    //use text ranges for Internet Explorer
    if (this.textbox.createTextRange) {
        var oRange = this.textbox.createTextRange(); 
        oRange.moveStart("character", iStart); 
        oRange.moveEnd("character", iLength - this.textbox.value.length);      
        oRange.select();
        
    //use setSelectionRange() for Mozilla
    } else if (this.textbox.setSelectionRange) {
        this.textbox.setSelectionRange(iStart, iLength);
    }     

    //set focus back to the textbox
    this.textbox.focus();      
}; 

/**
 * Builds the suggestion layer contents, moves it into position,
 * and displays the layer.
 * @scope private
 * @param aSuggestions An array of suggestions for the control.
 */
AutoSuggestControl.prototype.showSuggestions = function (aSuggestions /*:Array*/) {
    
    var oDiv = null;
    this.layer.innerHTML = "";  //clear contents of the layer
    
    for (var i=0; i < aSuggestions.length; i++) {
        oDiv = document.createElement("div");
        oDiv.appendChild(document.createTextNode(aSuggestions[i]));
		if (this.extrabox != null)
			oDiv.appendChild(document.createComment(aSuggestions[++i]));

        this.layer.appendChild(oDiv);
    }
    
    this.layer.style.left = this.getLeft() + "px";
    this.layer.style.top = (this.getTop()+this.textbox.offsetHeight) + "px";
    this.layer.style.visibility = "visible";

};

/**
 * Inserts a suggestion into the textbox, highlighting the 
 * suggested part of the text.
 * @scope private
 * @param sSuggestion The suggestion for the textbox.
 */
AutoSuggestControl.prototype.typeAhead = function (sSuggestion /*:String*/) {

    //check for support of typeahead functionality
    if (this.textbox.createTextRange || this.textbox.setSelectionRange){
        var iLen = this.textbox.value.length; 
        this.textbox.value = sSuggestion; 
        this.selectRange(iLen, sSuggestion.length);
    }
};


/**
 * Provides suggestions.
 * @class
 * @scope public
 */
function RemoteSuggestions(suggestionType, noTypeAhead) {

    if (typeof XMLHttpRequest != "undefined") {
        this.http = new XMLHttpRequest();
    } else if (typeof ActiveXObject != "undefined") {
        this.http = new ActiveXObject("MSXML2.XmlHttp");
    } else {
        alert("No XMLHttpRequest object available. This functionality will not work.");
    }
	this.suggestionType = suggestionType;
	this.noTypeAhead = (noTypeAhead != null) ? noTypeAhead : false;
}

/**
 * Request suggestions for the given autosuggest control. 
 * @scope protected
 * @param oAutoSuggestControl The autosuggest control to provide suggestions for.
 */
RemoteSuggestions.prototype.requestSuggestions = function (oAutoSuggestControl /*:AutoSuggestControl*/,
                                                          bTypeAhead /*:boolean*/) {

    var oHttp = this.http;
    var noTypeAhead = this.noTypeAhead;

	oAutoSuggestControl.value = oAutoSuggestControl.textbox.value;
	                                                             
    //if there is already a live request, cancel it
    if (oHttp.readyState != 0) {
        oHttp.abort();
    }                 
    
    //build the URL
    var sURL = "autoSuggest.do?type=" + this.suggestionType + 
    						 "&userInput=" + encodeURIComponent(oAutoSuggestControl.textbox.value);

    if (oAutoSuggestControl.extrabox != null)
//		sURL = sURL + "&additionalUserInput=" + encodeURIComponent(oAutoSuggestControl.extrabox.value);
		sURL = sURL + "&additionalUserInput=" + encodeURIComponent(oAutoSuggestControl.initialextra);
    
    //open connection to states.txt file
    oHttp.open("get", sURL , true);
    oHttp.onreadystatechange = function () {
        if (oHttp.readyState == 4) {
            //evaluate the returned text JavaScript (an array)
            var aSuggestions = eval(oHttp.responseText);
        
            //provide suggestions to the control

            if (noTypeAhead)
            	bTypeAhead = false;
            oAutoSuggestControl.autosuggest(aSuggestions, bTypeAhead);        
        }    
    };
    oHttp.send(null);
    

};