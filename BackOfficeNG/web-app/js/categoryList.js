zenexity.capdemat.bong.categoryList = function() {
  var zcc = zenexity.capdemat.common;
  var yuel = YAHOO.util.Element;
  var zcb = zenexity.capdemat.bong;
  
  var deleteConfirmationDialog;
  
  var handleConfirmDelete = function() {
    var id = zcb.categoryList.categoryId;
    zcc.doAjaxCall(
      '/delete/' + id,
       null,
      function(o) {
        if (zcc.validateAndFilterResponse(o)) {
          var response = YAHOO.lang.JSON.parse(o.responseText);
          var liId = "category-" + response.id;
          var elementToRemove = YAHOO.util.Dom.get(liId);
          var categoryListContainer = new yuel('categoriesList');
          categoryListContainer.removeChild(elementToRemove);
    
          zcc.displayResponseResult('success', response.success_msg);
        }
      });
  }

  return {
    askCategoryDeleteConfirmation : function(categoryId, name, confirmMessage) {
      zcb.categoryList.categoryId = categoryId;
      zcb.categoryList.confirmationDialog.setBody(confirmMessage);
      zcb.categoryList.confirmationDialog.show();
        //askCategoryDeleteConfirmation(categoryId, name, confirmMessage)
    },
    confirmationDialog : undefined ,
    categoryId: undefined,
    init : function() {
      zcb.categoryList.confirmationDialog = new zcc.ConfirmationDialog(
        {body:'Sure?'},handleConfirmDelete);
      
    }
  };
  
}();

YAHOO.util.Event.onDOMReady(zenexity.capdemat.bong.categoryList.init);
