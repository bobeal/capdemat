(function() {
  var zcc = zenexity.capdemat.common;
  
  function initRequestTypeForms(requestTypeId) {
      
      var submitAddRequestTypeFormsButton = new YAHOO.widget.Button("submitAddRequestTypeForms");
      submitAddRequestTypeFormsButton.on("click", FIC_checkForm, 
          document.getElementById('dialogRequestTypeFormsFormError'));
      // bind async form submission
      submitAddRequestTypeFormsButton.on("click", onSubmitSaveRequestTypeFormsClick);
      
      // async submit of request type configuration form
      // only called if FIC_checkForm has validated all fields, either event is cancelled
      function onSubmitSaveRequestTypeFormsClick(ev) {
          zcc.doAjaxFormSubmitCall('requestTypeFormsForm', null,handleSaveRequestTypeFormsSuccess, true);
      }
      
      var handleSaveRequestTypeFormsSuccess = function(o) {
          var response = YAHOO.lang.JSON.parse(o.responseText);
          if (response.status == "ok") {
  //            loadRequestTypeForms(response.requestTypeId);
              zcc.displayResponseResult('success', response.success_msg);
              
          } else {
              var el = document.getElementById('dialogRequestTypeFormsFormError');
              el.innerHTML = response.error_msg;
          }
      };
      
      var handleLoadRequestTypeFormsSuccess = function(o) {
          var response = YAHOO.lang.JSON.parse(o.responseText);
          
          // build the datatable
          var myDataSource = new YAHOO.util.DataSource(response.result);
          myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
          myDataSource.responseSchema = { 
              fields: ["name","filename"] 
          }; 
          var myColumnDefs = [
              {key:"name", label:"Nom"},
              {key:"filename", label:"Fichier"},
              {label:"Action"}
          ];
          var myDataTable = new YAHOO.widget.DataTable("requestTypeFormsTable", myColumnDefs, myDataSource); 
      }
        
      function loadRequestTypeForms(requestTypeId) {
          zcc.doAjaxCall('/loadRequestTypeForms/' + requestTypeId, null, handleLoadRequestTypeFormsSuccess);
      }
      
  //    loadRequestTypeForms(requestTypeId);
      
      function onButtonClick(p_oEvent) {
          document.getElementById('xslFoFile').click();
  //            YAHOO.log("You clicked button: " + this.get("id"), "info", "example1");      
      }
  }
}());