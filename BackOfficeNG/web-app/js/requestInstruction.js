// RequestInstruction TabView Initialization
function initRequestInstruction() {
	// TabView 1 (Request's History and Notes)
	var requestInformationTabview = new YAHOO.widget.TabView();
    
    requestInformationTabview.addTab( new YAHOO.widget.Tab({
        label: 'Historique',
        dataSrc: YAHOO.capdematBo.baseUrl + '/loadRequestHistory/' + YAHOO.capdematBo.requestId,
        cacheData: true,
        active: true
    }));
    requestInformationTabview.addTab( new YAHOO.widget.Tab({
        label: 'Commentaires',
        dataSrc: YAHOO.capdematBo.baseUrl + '/loadRequestNotes/' + YAHOO.capdematBo.requestId,
        cacheData: false
    }));
    requestInformationTabview.addTab( new YAHOO.widget.Tab({
        label: 'Compte',
        dataSrc: YAHOO.capdematBo.baseUrl + '/loadHomeFolderData',
        cacheData: true
    }));
    requestInformationTabview.addTab( new YAHOO.widget.Tab({
        label: 'Demandes',
        dataSrc: YAHOO.capdematBo.baseUrl + '/loadHomeFolderRequests/' + YAHOO.capdematBo.requestId,
        cacheData: true
    }));
    
    requestInformationTabview.appendTo('requestInformation');
    
    var requestDataTabView = new YAHOO.widget.TabView('requestData');
    
    
    // Instantiate a Panel from markup 
    YAHOO.capdematBo.instructionStatePanel = new YAHOO.widget.Panel(
            "instructionStatePanel", 
            { width: "135%", 
              visible: false, 
              constraintoviewport: true,
              draggable: false,
              underlay: "none",
              close: false
            }
    ); 
    YAHOO.capdematBo.instructionStatePanel.render();
}

YAHOO.util.Event.onDOMReady(initRequestInstruction);

/*
function handleAddRequestNoteSuccess(o) {
	var requestInformationTabs = new YAHOO.widget.TabView('requestInformation'); 
	var requestNoteTab = requestInformationTabs.get('activeTab');
	requestNoteTab.set('contentVisible', true);
}

function doAddRequestNote() {
    var queryUrl = YAHOO.capdematBo.baseUrl + "/addRequestNote?" +  collectSearchFormValues('requestNoteForm');   
    doAjaxFormSubmitCall(handleAddRequestNoteSuccess, null, 'requestNoteForm');    
}

YAHOO.util.Event.addListener("submitNewRequestNote","click",doAddRequestNote);
*/


/*
 * Request Instruction Worflow managment
 */

var handlegetStatePossibleTransitionSuccess = function(o) {
   YAHOO.capdematBo.instructionStatePanel.setBody(o.responseText);
   YAHOO.capdematBo.instructionStatePanel.show();
}

function getStatePossibleTransition(stateCssClass, stateType) {
    doAjaxCall(
            '/getStatePossibleTransition/'
                    + '?stateCssClass=' + stateCssClass 
                    + '&stateType=' + stateType,
            handlegetStatePossibleTransitionSuccess,
            null);
}

function switchStatePanel(targetEl) {
    var targetBgColor = YAHOO.util.Dom.getStyle(targetEl, "background-color");  
    YAHOO.util.Dom.setStyle(YAHOO.capdematBo.instructionStatePanel.id, "border-color", targetBgColor);
    
    YAHOO.capdematBo.instructionStatePanel.cfg.setProperty("context", [targetEl,"tr","br"])
    if (! YAHOO.capdematBo.instructionStatePanel.cfg.getProperty("visible")) {
        getStatePossibleTransition(targetEl.className, targetEl.id);
    }
    else
        YAHOO.capdematBo.instructionStatePanel.hide();
}

function requestStateEventdispatcher(e) {
    var targetEl = YAHOO.util.Event.getTarget(e);
    
    if (targetEl.className === "cancelRequestStateChange")
        YAHOO.capdematBo.instructionStatePanel.hide();
    else if (targetEl.className.indexOf("tag-") != -1 && targetEl.className != "tag-not_provided")
        switchStatePanel(targetEl);
}

YAHOO.util.Event.addListener('narrow', 'click', requestStateEventdispatcher);



