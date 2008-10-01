function initCategory() {
    
    var editMode = YAHOO.capdematBo.editMode;
    var categoryId = YAHOO.capdematBo.categoryId;
    
    // to reset categoryData context
    function resetCategoryDataDiv() { 
        // reset any previously displayed error
        document.getElementById('categoryFormErrors').innerHTML = '';
        
        // reset any previously failed fields
        var failedElmts = YAHOO.util.Selector.query('input.validation-failed', "categoryData");
        YAHOO.util.Dom.removeClass(failedElmts, 'validation-failed');
    }
    
	
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
        doAjaxFormSubmitCall(
            function(o) {
                var response = YAHOO.lang.JSON.parse(o.responseText);
                if (response.status === "ok") {
                    if (editMode === "create")
                        window.location = YAHOO.capdematBo.baseUrl + "/edit/" + response.id ;
                    else {
              	      // Is message useful
              	      displayResponseResult('success', response.success_msg);
            	        resetCategoryDataDiv();
          	        }
                } else {
                    displayResponseResult("modelError", response.error_msg);
                }
            },
            null, 
            'categoryForm');
    }
    
    // Create our custom event and listeners to handle category selection
    YAHOO.capdematBo.categorySelectedEvent = new YAHOO.util.CustomEvent('categorySelectedEvent');
    YAHOO.capdematBo.categorySelectedEvent.subscribe(loadCategoryForm);
    YAHOO.capdematBo.categorySelectedEvent.subscribe(loadCategoryRequests);
    YAHOO.capdematBo.categorySelectedEvent.subscribe(loadCategoryAgents);
      
    function loadCategoryForm(type, args) {
        doAjaxCall(
            '/loadCategoryForm/' + categoryId ,
            function(o) {
                YAHOO.util.Dom.get('categoryData').innerHTML = o.responseText;
                resetCategoryDataDiv();
                decorateCategoryFormButtons();
            },
            null);
    }
      
    function loadCategoryRequests(type, args) {
        if (editMode === 'create')
             YAHOO.util.Dom.addClass('categoryRequestTypesBox', 'invisible');
        else
            doAjaxCall(
                "/requestTypes/?id=" + categoryId + "&scope=Category", 
                function(o) {
                    YAHOO.util.Dom.get('categoryRequestTypes').innerHTML = o.responseText;
                }, 
                null);
    }
      
    function loadCategoryAgents(type, args) {
        if (editMode === 'create')
            YAHOO.util.Dom.addClass('categoryAgentsBox', 'invisible');
        else
            doAjaxCall(
                "/agents/?id=" + categoryId + "&scope=Category",
                function(o) {
                    YAHOO.util.Dom.get('categoryAgents').innerHTML = o.responseText;
                },
                [categoryId]);
    }
    
    fireCategorySelectedEvent();
}

YAHOO.util.Event.onDOMReady(initCategory);

function fireCategorySelectedEvent() {
    // TODO : is the first argument used ?
    YAHOO.capdematBo.categorySelectedEvent.fire();
};

