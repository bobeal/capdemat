function initCategory() {
    
    var editMode = YAHOO.capdematBo.editMode;
    var categoryId = YAHOO.capdematBo.categoryId;
    
    // to reset categoryData context
    function resetCategoryDataDiv() {
        var categoryDataDiv = new YAHOO.util.Element('categoryData');
 
        // reset any previously displayed error
        document.getElementById('categoryFormErrors').innerHTML = '';
        // reset any previously entered data
        // document.getElementById('categoryForm').reset();
        // reset any previously failed fields
        var failedElmts = categoryDataDiv.getElementsByClassName('validation-failed', null);
        YAHOO.util.Dom.removeClass(failedElmts, 'validation-failed');
    }
    
	  var handleSaveCategorySuccess = function(o) {
        var response = YAHOO.lang.JSON.parse(o.responseText);
		    if (response.status === "ok") {
		      if (response.create) {
              fireCategorySelectedEvent(response.id);
            	} else {
            	    // it was an update, context is already set up
            	    // TODO update the category's name (WTF?!)
            	    
            	    // Is message useful
            	    displayResponseResult('success', response.success_msg);
          	      resetCategoryDataDiv();
            	}
		    } else {
			    var el = document.getElementById('categoryFormErrors');
			    el.innerHTML = response.error_msg;
		    }
	  };
	
    function decorateCategoryFormButtons() {
        var submitSaveCategoryButton = new YAHOO.widget.Button("submitSaveCategory");
        // bind form validation
        submitSaveCategoryButton.on("click", FIC_checkForm, document.getElementById('categoryFormErrors'));
        // bind async form submission
        submitSaveCategoryButton.on("click", onSubmitSaveCategoryClick);

        if (editMode === 'create') {
            var cancelCreateCategory = new YAHOO.widget.Button("cancelCreateCategory");
        } 
    }
    
    // async submit of category creation form
    // only called if FIC_checkForm has validated all fields, either event is cancelled
    function onSubmitSaveCategoryClick(ev) {
        if (editMode === "create") {
            document.getElementById('categoryForm').submit();
        } else 
            doAjaxFormSubmitCall(handleSaveCategorySuccess, null, 'categoryForm');
    }
    
    // Create our custom event and listeners to handle category selection
    YAHOO.capdematBo.categorySelectedEvent = new YAHOO.util.CustomEvent('categorySelectedEvent');
    YAHOO.capdematBo.categorySelectedEvent.subscribe(loadCategoryForm);
    YAHOO.capdematBo.categorySelectedEvent.subscribe(loadCategoryRequests);
    YAHOO.capdematBo.categorySelectedEvent.subscribe(loadCategoryAgents);
    
    var handleLoadCategoryFormSuccess = function(o) {
        var element = document.getElementById('categoryData');
        element.innerHTML = o.responseText;
        resetCategoryDataDiv();
        decorateCategoryFormButtons();
    }
      
    function loadCategoryForm(type, args) {
        doAjaxCall('/loadCategoryForm/' + categoryId , handleLoadCategoryFormSuccess, null);
    }
    
    var handleLoadCategoryRequestsSuccess = function(o) {
        var element = document.getElementById('categoryRequestTypes');
        element.innerHTML = o.responseText;
    }
      
    function loadCategoryRequests(type, args) {
        if (editMode === 'create') {
             YAHOO.util.Dom.addClass('categoryRequestTypesBox', 'invisible');
        } else
            doAjaxCall('/loadCategoryRequestTypesTemplate/' + categoryId, handleLoadCategoryRequestsSuccess, [categoryId]);
    }
    
    var handleLoadCategoryAgentsSuccess = function(o) {
        var element = document.getElementById('categoryAgents');
        element.innerHTML = o.responseText;
    }
      
    function loadCategoryAgents(type, args) {
        if (editMode === 'create') {
            YAHOO.util.Dom.addClass('categoryAgentsBox', 'invisible');
        } else
            doAjaxCall('/loadCategoryAgentsTemplate/' + categoryId, handleLoadCategoryAgentsSuccess, [categoryId]);
    }
    
    fireCategorySelectedEvent();
}

YAHOO.util.Event.onDOMReady(initCategory);

function fireCategorySelectedEvent() {
    // TODO : is the first argument used ?
    YAHOO.capdematBo.categorySelectedEvent.fire();
};

