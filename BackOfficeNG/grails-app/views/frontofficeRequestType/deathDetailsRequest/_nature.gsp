


  
    <label for="deathLastName" class="required"><g:message code="ddr.property.deathLastName.label" /> *  <span><g:message code="ddr.property.deathLastName.help" /></span></label>
            <input type="text" id="deathLastName" name="deathLastName" value="${rqt.deathLastName?.toString()}" 
                    class="required  validate-lastName ${invalidFields.contains('deathLastName') ? 'validation-failed' : ''}" title="<g:message code="ddr.property.deathLastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="deathFirstNames" class="required"><g:message code="ddr.property.deathFirstNames.label" /> *  <span><g:message code="ddr.property.deathFirstNames.help" /></span></label>
            <input type="text" id="deathFirstNames" name="deathFirstNames" value="${rqt.deathFirstNames?.toString()}" 
                    class="required  validate-string ${invalidFields.contains('deathFirstNames') ? 'validation-failed' : ''}" title="<g:message code="ddr.property.deathFirstNames.validationError" />"   />
            

  

  
    <label for="deathDate" class="required"><g:message code="ddr.property.deathDate.label" /> *  <span><g:message code="ddr.property.deathDate.help" /></span></label>
            <input type="text" id="deathDate" name="deathDate" value="${formatDate(formatName:'format.date',date:rqt.deathDate)}" 
                   class="required  validate-date ${invalidFields.contains('deathDate') ? 'validation-failed' : ''}" title="<g:message code="ddr.property.deathDate.validationError" />" />
            

  

  
    <label for="deathCity" class="required"><g:message code="ddr.property.deathCity.label" /> *  <span><g:message code="ddr.property.deathCity.help" /></span></label>
            <input type="text" id="deathCity" name="deathCity" value="${rqt.deathCity?.toString()}" 
                    class="required  validate-city ${invalidFields.contains('deathCity') ? 'validation-failed' : ''}" title="<g:message code="ddr.property.deathCity.validationError" />"  maxlength="32" />
            

  

  
    <label for="deathPostalCode" class="required"><g:message code="ddr.property.deathPostalCode.label" /> *  <span><g:message code="ddr.property.deathPostalCode.help" /></span></label>
            <input type="text" id="deathPostalCode" name="deathPostalCode" value="${rqt.deathPostalCode?.toString()}" 
                    class="required  validate-departmentCode ${invalidFields.contains('deathPostalCode') ? 'validation-failed' : ''}" title="<g:message code="ddr.property.deathPostalCode.validationError" />"  maxlength="2" />
            

  

