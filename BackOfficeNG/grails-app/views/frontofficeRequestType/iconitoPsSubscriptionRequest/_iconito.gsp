


  
    <label for="invoiceBarCode" class="required"><g:message code="ipsr.property.invoiceBarCode.label" /> *  <span><g:message code="ipsr.property.invoiceBarCode.help" /></span></label>
            <input type="text" id="invoiceBarCode" name="invoiceBarCode" value="${rqt.invoiceBarCode?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['iconito'].invalidFields.contains('invoiceBarCode') ? 'validation-failed' : ''}" title="<g:message code="ipsr.property.invoiceBarCode.validationError" />"   />
            

  

