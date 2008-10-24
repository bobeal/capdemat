(function() {
	var zcc = zenexity.capdemat.common;
	
	function initRequestTypeSeasons(requestTypeId) {
			
		YAHOO.capdematBo.calendar.cal = new Array(5);
						YAHOO.util.Event.onDOMReady(YAHOO.capdematBo.calendar.init, 
														{id : 2, label : "registrationStart"});
					YAHOO.util.Event.onDOMReady(YAHOO.capdematBo.calendar.init, 
														{id : 3, label : "registrationEnd"});
				YAHOO.util.Event.onDOMReady(YAHOO.capdematBo.calendar.init, 
														{id : 4, label : "effectStart"});
					YAHOO.util.Event.onDOMReady(YAHOO.capdematBo.calendar.init, 
														{id : 5, label : "effectEnd"});
				YAHOO.util.Event.onDOMReady(YAHOO.capdematBo.calendar.init, 
														{id : 6, label : "validationAuthorizationStart"})
		//save form button
		var submitSaveSeasonButton = new YAHOO.widget.Button("submitSaveSeason");
		submitSaveSeasonButton.on("click", FIC_checkForm, 
					document.getElementById('dialogRequestTypeSeasonsFormError'));
		submitSaveSeasonButton.on("click",onSubmitSaveSeasonClick);
		
		function onSubmitSaveSeasonClick(ev){
			zcc.doAjaxFormSubmitCall('requestTypeSeasonsForm',null,handleSaveRequestTypeSeasonsSuccess);
		}
		var handleSaveRequestTypeSeasonsSuccess = function(o) {
			
			var response = YAHOO.lang.JSON.parse(o.responseText);
			if (response.status == "ok") {
					 zcc.doAjaxCall('/loadRequestTypeSeasonsList/' +  requestTypeId ,
					 [response.seasonUuid,response.seasonLabel] ,
					 handleLoadRequestTypeSeasonsListSuccess);
					}else {
				var el = document.getElementById('dialogRequestTypeSeasonsFormError');
				el.innerHTML = response.error_msg;
			}          
			 }
			var handleLoadRequestTypeSeasonsListSuccess = function(o) {
	
					// compute and prepare received information
				var nodeToInsert = document.createElement('li');
					var textToInsert = o.responseText;
					
					var liInfo = textToInsert.substring(textToInsert.lastIndexOf('<li'),
					 textToInsert.lastIndexOf('</form>'));
					var liIdIndex = liInfo.substring(liInfo.indexOf('<li'),liInfo.indexOf('<span'));
					var seasonUuid = liIdIndex.substring(liIdIndex.indexOf('id')+4,liIdIndex.lastIndexOf('\"'));
					nodeToInsert.setAttribute('id',seasonUuid);
					var spanInfo = textToInsert.substring(textToInsert.indexOf('<div id="seasonsList"'),
					textToInsert.indexOf('</form>'));
					var element = document.getElementById('requestTypeSeasonsList');
					element.innerHTML = spanInfo
					handleStyleButton();
					
					var divForm = document.getElementById("requestTypeSeasonsConfiguration");
			divForm.style.visibility = 'hidden';
			} 
			 handleStyleButton();
	}
	function handleStyleButton(){
		var submitAddSeasonButton = new YAHOO.widget.Button("addSeason");
		submitAddSeasonButton.on("click",onSubmitAddSeasonClick);
		
		var submitCancelSeasonButton = new YAHOO.widget.Button("submitCancelSeason");
		submitCancelSeasonButton.on("click",onSubmitCancelSeasonClick);
		
		var divForm = document.getElementById("requestTypeSeasonsConfiguration");
		
		//show the add form button
		
		function onSubmitAddSeasonClick(ev){
		 // reset any previously entered data
		 document.getElementById('requestTypeSeasonsForm').reset();
		 divForm.style.visibility = 'visible';
		 // reset any previously displayed error
		 document.getElementById('dialogRequestTypeSeasonsFormError').innerHTML = '';
		}
		//cancel form button
		 
		function onSubmitCancelSeasonClick(ev){
		 divForm.style.visibility = 'hidden';
		}
	}
	
	var deleteConfirmationDialog;
	function askSeasonDeleteConfirmation(requestTypeId, seasonUuid, seasonLabel) {  
				
			var handleLoadRequestTypeSubmenuFormSuccess = function(o) {
			
					var textToInsert = o.responseText;
					var spanInfo = textToInsert.substring(textToInsert.indexOf('<div id="seasonsList"'),
					textToInsert.indexOf('</form>'));
					var element = document.getElementById('requestTypeSeasonsList');
					element.innerHTML = spanInfo
					handleStyleButton();
			}
	
			var handleDeleteSeasonSuccess = function(o) {
					if (zcc.validateAndFilterResponse(o)) {
					 var response = YAHOO.lang.JSON.parse(o.responseText);
					 var liId = response.uuid;
					 var elementToRemove = document.getElementById(liId);
					 var seasonListContainer = new YAHOO.util.Element('seasonListContainer');
					 seasonListContainer.removeChild(elementToRemove);
				
           zcc.Notifier.processMessage('success',response.success_msg);
					}
			}
			
			var handleConfirmDelete = function() {
					zcc.doAjaxCall('/deleteSeasons/' + requestTypeId + '/' + seasonUuid, [], handleDeleteSeasonSuccess);
					//this.hide();
			}
			
			if (!deleteConfirmationDialog) {
					var content ={ body : "Confirmez-vous la suppression de la saison " + seasonLabel + " ?"};    
					deleteConfirmationDialog = 
							new zcc.ConfirmationDialog(content,handleConfirmDelete);
			}
			deleteConfirmationDialog.show();
	}
	
}());