


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrTaxesAmount.label" /></legend>
    
      <label for="dhrIncomeTax" class=""><g:message code="dhr.property.dhrIncomeTax.label" />   <span><g:message code="dhr.property.dhrIncomeTax.help" /></span></label>
            <input type="text" id="dhrIncomeTax" name="dhrIncomeTax" value="${rqt.dhrIncomeTax?.toString()}" 
                    class="  validate-positiveInteger ${rqt.stepStates['taxes'].invalidFields.contains('dhrIncomeTax') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrIncomeTax.validationError" />"   />
            

    
      <label for="localRate" class=""><g:message code="dhr.property.localRate.label" />   <span><g:message code="dhr.property.localRate.help" /></span></label>
            <input type="text" id="localRate" name="localRate" value="${rqt.localRate?.toString()}" 
                    class="  validate-positiveInteger ${rqt.stepStates['taxes'].invalidFields.contains('localRate') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.localRate.validationError" />"   />
            

    
      <label for="propertyTaxes" class=""><g:message code="dhr.property.propertyTaxes.label" />   <span><g:message code="dhr.property.propertyTaxes.help" /></span></label>
            <input type="text" id="propertyTaxes" name="propertyTaxes" value="${rqt.propertyTaxes?.toString()}" 
                    class="  validate-positiveInteger ${rqt.stepStates['taxes'].invalidFields.contains('propertyTaxes') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.propertyTaxes.validationError" />"   />
            

    
      <label for="professionalTaxes" class=""><g:message code="dhr.property.professionalTaxes.label" />   <span><g:message code="dhr.property.professionalTaxes.help" /></span></label>
            <input type="text" id="professionalTaxes" name="professionalTaxes" value="${rqt.professionalTaxes?.toString()}" 
                    class="  validate-positiveInteger ${rqt.stepStates['taxes'].invalidFields.contains('professionalTaxes') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.professionalTaxes.validationError" />"   />
            

    
    </fieldset>
  

