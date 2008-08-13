YAHOO.namespace("payment_module");

// used to switch the visual look of a selected element in a list
// item with the given id will be applied the given classname
// other items with the given classname will set it removed
// currently used by the main menu and the category menu
function swichSelectedItemDisplay(itemId, className) {
	// first, deselect any previously selected item
	var elements = YAHOO.util.Dom.getElementsByClassName(className);
	var i = 0;
    for (i=0;i < elements.length; i++) {
    	var element = elements[i];
        YAHOO.util.Dom.removeClass(elements[i], className); 
    }
    // then add the class name to the newly selected item
    var selectedItem = document.getElementById(itemId);
    YAHOO.util.Dom.addClass(selectedItem, className); 
}

// issue an AJAX call based on YUI Connection component
function doAjaxCall(callUrl,successCallback,successCallbackArgs) {
    var callback = {
        //failure: handleUnexpectedError
    };
    if (successCallback)
        callback.success = successCallback;
    if (successCallbackArgs)
        callback.argument = successCallbackArgs;
    var transaction = YAHOO.util.Connect.asyncRequest('GET', callUrl, callback, null);
}

// issue an AJAX form submit call based on YUI Connection component
function doAjaxFormSubmitCall(successCallback,successCallbackArgs,formId,withFileUpload) {
   	var formElement = new YAHOO.util.Element(formId);
   	// to retrieve form values
   	if (withFileUpload)
       	YAHOO.util.Connect.setForm(document.getElementById(formId), true);
   	else
       	YAHOO.util.Connect.setForm(document.getElementById(formId));    
   	var callback = {};
   	if (successCallback)
       	callback.success = successCallback;
   	if (successCallbackArgs)
       	callback.argument = successCallbackArgs;
   	var url = formElement.get('action');
   	var transaction = YAHOO.util.Connect.asyncRequest('POST', url, callback, null);
}
			

var handleConfirmationDialogCancel = function() { 
	this.hide();
}
function loadConfirmationDialog(handleConfirmDelete,header,body,yes_message,no_message) {
    var confirmDeleteDialog = new YAHOO.widget.SimpleDialog("deleteDialog", { 
        width: "20em", 
        modal:true,
        visible:true,
        draggable:false,
        fixedcenter:true});
    var myButtons = [ { text:yes_message, handler:handleConfirmDelete, isDefault:true },
				  { text:no_message, handler:handleConfirmationDialogCancel } ];
	confirmDeleteDialog.cfg.queueProperty("buttons", myButtons);
    confirmDeleteDialog.setHeader(header);
    confirmDeleteDialog.setBody(body);
    confirmDeleteDialog.cfg.setProperty("icon",YAHOO.widget.SimpleDialog.ICON_WARN); 
    confirmDeleteDialog.render("bd");
    confirmDeleteDialog.show();
}

function setMenu() {
	swichSelectedItemDisplay(YAHOO.payment_module.currentMenu + 'MenuItem', 'selected-menu-item');
}

YAHOO.util.Event.onDOMReady(setMenu);

