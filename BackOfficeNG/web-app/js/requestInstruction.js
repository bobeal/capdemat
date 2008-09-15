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
}

YAHOO.util.Event.onDOMReady(initRequestInstruction);


// RequestNote managment
/*
function initAddRequestNote() {
    
    var submitNewRequestNoteButton = new YAHOO.widget.Button("submitNewRequestNote");
    submitNewRequestNoteButton.on("click", onSubmitNewRequestNote);
        
    function onSubmitNewRequestNote(ev) {
        doAddRequestNote();
    }
}
*/

YAHOO.util.Event.addListener("submitNewRequestNote","click",doAddRequestNote);

function doAddRequestNote() {
    var queryUrl = YAHOO.capdematBo.baseUrl + "/addRequestNote?" +  collectSearchFormValues('requestNoteForm');   
    doAjaxFormSubmitCall(handleAddRequestNoteSuccess, null, 'requestNoteForm');    
}

function handleAddRequestNoteSuccess(o) {
	var requestInformationTabs = new YAHOO.widget.TabView('requestInformation'); 
	// var requestNoteTab = requestInformationTabs.getTab(1); 
	var requestNoteTab = requestInformationTabs.get('activeTab');
	
	//requestNoteTab.refresh('contentVisible',true);
	//requestNoteTab.set('dataLoaded', false);
	requestNoteTab.set('contentVisible', true);
    // requestNoteTab.set('dataSrc', YAHOO.capdematBo.baseUrl + '/loadRequestNotes/' + YAHOO.capdematBo.requestId); 
}
/*
function handleAddRequestNoteSuccess(o) {
     doAjaxCall('/loadRequestNotes/'+ YAHOO.capdematBo.requestId, null);
}
*/
