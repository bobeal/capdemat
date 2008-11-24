zenexity.capdemat.bong.categoryEdit = function() {
  
  var zcb = zenexity.capdemat.bong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  var ywb = YAHOO.widget.Button;
  
  var editMode;
  var categoryId;
  
  // to reset categoryData context
  function resetCategoryDataDiv() { 
    // reset any previously displayed error
    yud.get('categoryFormErrors').innerHTML = '';
    
    // reset any previously failed fields
    var failedElmts = yus.query('input.validation-failed', "categoryData");
    yud.removeClass(failedElmts, 'validation-failed');
  }
  
  function decorateCategoryFormButtons() {
    var submitSaveCategoryButton = new ywb("submitSaveCategory");
    // bind form validation
    submitSaveCategoryButton.on("click", FIC_checkForm, yud.get('categoryFormErrors'));
    // bind async form submission
    submitSaveCategoryButton.on("click", onSubmitSaveCategoryClick);
  
    if (editMode === 'create') {
      var cancelCreateCategory = new ywb("cancelCreateCategory");
    } 
  }
  
  // async submit of category creation form
  // only called if FIC_checkForm has validated all fields, either event is cancelled
  function onSubmitSaveCategoryClick(ev) {
    zct.doAjaxFormSubmitCall('categoryForm',null,
    function(o) {
      var response = ylj.parse(o.responseText);
      if (response.status === "ok") {
        if (editMode === "create")
          window.location = zcb.baseUrl + "/edit/" + response.id ;
        else {
          // Is message useful
          zct.Notifier.processMessage('success',response.success_msg);
          resetCategoryDataDiv();
        }
      } else {
        zct.Notifier.processMessage('modelError',response.success_msg);
      }
    });
  }
  
  // Create our custom event and listeners to handle category selection
  zcb.categorySelectedEvent = new YAHOO.util.CustomEvent('categorySelectedEvent');
  zcb.categorySelectedEvent.subscribe(loadCategoryForm);
  zcb.categorySelectedEvent.subscribe(loadCategoryRequests);
  zcb.categorySelectedEvent.subscribe(loadCategoryAgents);
  
  function loadCategoryForm(type, args) {
    zct.doAjaxCall(
        '/loadCategoryForm/' + categoryId ,null,
        function(o) {
          yud.get('categoryData').innerHTML = o.responseText;
          resetCategoryDataDiv();
          decorateCategoryFormButtons();
        });
  }
  
  function loadCategoryRequests(type, args) {
    if (editMode === 'create')
      yud.addClass('categoryRequestTypesBox', 'invisible');
    else
    zct.doAjaxCall(
        "/requestTypes/?id=" + categoryId + "&scope=Category",
        null,
        function(o) {
        yud.get('categoryRequestTypes').innerHTML = o.responseText;
        });
  }
  
  function loadCategoryAgents(type, args) {
    if (editMode === 'create')
      yud.addClass('categoryAgentsBox', 'invisible');
    else
    zct.doAjaxCall(
        "/agents/?id=" + categoryId + "&scope=Category",
        [categoryId],
        function(o) {
        yud.get('categoryAgents').innerHTML = o.responseText;
        });
  }
  
  return { 
    init : function() {
        editMode = zcb.editMode;
        categoryId = zcb.categoryId;
        (function() {
          // TODO : is the first argument used ?
          zcb.categorySelectedEvent.fire();
        })();
      } 
  };

}();

YAHOO.util.Event.onDOMReady(zenexity.capdemat.bong.categoryEdit.init);

