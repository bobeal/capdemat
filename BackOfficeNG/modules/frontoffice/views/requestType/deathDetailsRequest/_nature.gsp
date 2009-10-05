


  
    <label class="required"><g:message code="ddr.property.deathLastName.label" /> *  <span><g:message code="ddr.property.deathLastName.help" /></span></label>
            <input type="text" name="deathLastName" value="${rqt.deathLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="ddr.property.deathLastName.validationError" />"  maxlength="38" />
            

  

  
    <label class="required"><g:message code="ddr.property.deathFirstNames.label" /> *  <span><g:message code="ddr.property.deathFirstNames.help" /></span></label>
            <input type="text" name="deathFirstNames" value="${rqt.deathFirstNames?.toString()}" 
                    class="required  validate-string" title="<g:message code="ddr.property.deathFirstNames.validationError" />"   />
            

  

  
    <label class="required"><g:message code="ddr.property.deathDate.label" /> *  <span><g:message code="ddr.property.deathDate.help" /></span></label>
            <input type="text" name="deathDate" value="${formatDate(formatName:'format.date',date:rqt.deathDate)}" 
                   class="required  validate-date" title="<g:message code="ddr.property.deathDate.validationError" />" />
            

  

  
    <label class="required"><g:message code="ddr.property.deathCity.label" /> *  <span><g:message code="ddr.property.deathCity.help" /></span></label>
            <input type="text" name="deathCity" value="${rqt.deathCity?.toString()}" 
                    class="required  validate-city" title="<g:message code="ddr.property.deathCity.validationError" />"  maxlength="32" />
            

  

  
    <label class="required"><g:message code="ddr.property.deathPostalCode.label" /> *  <span><g:message code="ddr.property.deathPostalCode.help" /></span></label>
            <input type="text" name="deathPostalCode" value="${rqt.deathPostalCode?.toString()}" 
                    class="required  validate-departmentCode" title="<g:message code="ddr.property.deathPostalCode.validationError" />"  maxlength="2" />
            

  

