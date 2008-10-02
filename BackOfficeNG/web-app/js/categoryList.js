(function() {
  var zcc = zenexity.capdemat.common;
  
  var deleteConfirmationDialog;
  askCategoryDeleteConfirmation = function (categoryId, name, confirmMessage) {
      var id = categoryId;
       
      var handleDeleteCategorySuccess = function(o) {
          if (zcc.validateAndFilterResponse(o)) {
              var response = YAHOO.lang.JSON.parse(o.responseText);
              var liId = "category-" + response.id;
              var elementToRemove = document.getElementById(liId);
              var categoryListContainer = new YAHOO.util.Element('categoriesList');
              categoryListContainer.removeChild(elementToRemove);
  
              zcc.displayResponseResult('success', response.success_msg);
          }
      }
  
      var handleConfirmDelete = function() {
          zcc.doAjaxCall('/delete/' + id, null, handleDeleteCategorySuccess);
          this.hide();
      }
      
  //    if (!deleteConfirmationDialog) {
          deleteConfirmationDialog = 
              new zcc.deleteConfirmationDialog(null,handleConfirmDelete,confirmMessage);
  //    }
      
      deleteConfirmationDialog.setBody(confirmMessage);
      deleteConfirmationDialog.show();
  }

}());