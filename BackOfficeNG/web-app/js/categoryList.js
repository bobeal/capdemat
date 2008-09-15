var deleteConfirmationDialog;
askCategoryDeleteConfirmation = function (categoryId, name, confirmMessage) {
    var id = categoryId;
     
    var handleDeleteCategorySuccess = function(o) {
        if (validateAndFilterResponse(o)) {
            var response = YAHOO.lang.JSON.parse(o.responseText);
            var liId = "category-" + response.id;
            var elementToRemove = document.getElementById(liId);
            var categoryListContainer = new YAHOO.util.Element('categoriesList');
            categoryListContainer.removeChild(elementToRemove);

            displayResponseResult('success', response.success_msg);
        }
    }

    var handleConfirmDelete = function() {
        doAjaxCall('/delete/' + id, handleDeleteCategorySuccess, null);
        this.hide();
    }
    
//    if (!deleteConfirmationDialog) {
        deleteConfirmationDialog = 
            new YAHOO.capdematBo.deleteConfirmationDialog(null,handleConfirmDelete,confirmMessage);
//    }
    
    deleteConfirmationDialog.setBody(confirmMessage);
    deleteConfirmationDialog.show();
}
