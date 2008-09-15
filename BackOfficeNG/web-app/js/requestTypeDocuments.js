function initRequestTypeDocuments(requestTypeId) {
	
    var handleLoadAllDocumentTypesSuccess = function(o) {
        var response = YAHOO.lang.JSON.parse(o.responseText);
        
        // build the datatable
        var myDataSource = new YAHOO.util.DataSource(response.result);
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        myDataSource.responseSchema = { 
            fields: ["id","name","selector"] 
        }; 
        var myColumnDefs = [
            {key:"selector", label:"&nbsp;", formatter:YAHOO.widget.DataTable.formatCheckbox},
            {key:"id", label:"Identifiant", sortable:true},
            {key:"name", label:"Nom", sortable:true}
        ];
        var myConfigs = {
            paginated:true, // Enables built-in client-side pagination
            paginator:{ // Configurable options
                containers: null, // Create container DIVs dynamically
                currentPage: 1, // Show page 1
                dropdownOptions: [10,20,50], // Show these in the rows-per-page dropdown
                pageLinks: 0, // Show links to all pages
                rowsPerPage: 20 // Show up to 500 rows per page
            }
        };
        var myDataTable = new YAHOO.widget.DataTable("requestTypeDocumentsTable", 
            myColumnDefs, myDataSource, myConfigs); 
        
        function handleAssociateDocumentToRequestTypeSuccess(o) {
			var response = YAHOO.lang.JSON.parse(o.responseText);
			
			if (response.status == "ok") {
				var dataTable = o.argument[0];
				var record = o.argument[1];
				dataTable.getRecordSet().updateKey(record, "selector", o.argument[2].checked);
				dataTable.refreshRow(record);

				displayResponseResult('success', response.success_msg);
			} else {
                displayResponseResult('modelError', response.error_msg);
			}
        }
        
        myDataTable.subscribe("checkboxClickEvent", 
            function(oArgs) {

                var elCheckbox = oArgs.target;
                var elRecord = this.getRecord(elCheckbox);
                
                var url = '';
                url += '/modifyDocumentAssociation/'
                    + o.argument[0] + '/?documentId=' + elRecord.getData("id");
                if (elCheckbox.checked)
                	url += '&operation=add';
                else
                	url += '&operation=remove';
                doAjaxCall(url, handleAssociateDocumentToRequestTypeSuccess, 
                    [this,elRecord,elCheckbox]);
            }
        );
    }
      
    doAjaxCall('/loadAllDocumentTypes/' + requestTypeId, handleLoadAllDocumentTypesSuccess,
        [requestTypeId]);
}
