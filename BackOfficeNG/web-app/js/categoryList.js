zenexity.capdemat.bong.categoryList = function() {
  var zcc = zenexity.capdemat.common;
  var yuel = YAHOO.util.Element;
  
  var deleteConfirmationDialog;
  askCategoryDeleteConfirmation = function (categoryId, name, confirmMessage) {
    var id = categoryId;
    
    var handleConfirmDelete = function() {
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
      
      this.hide();
    }
    
    deleteConfirmationDialog = 
      new zcc.deleteConfirmationDialog(null,handleConfirmDelete,confirmMessage);
    
    deleteConfirmationDialog.setBody(confirmMessage);
    deleteConfirmationDialog.show();
  }

  return {
    askCategoryDeleteConfirmation : 
      function(categoryId, name, confirmMessage) {
        askCategoryDeleteConfirmation(categoryId, name, confirmMessage) 
      }
  };
  
}();
