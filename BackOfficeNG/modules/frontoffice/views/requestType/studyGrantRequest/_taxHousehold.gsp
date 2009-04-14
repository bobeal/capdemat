


  
    <label class="required"><g:message code="sgr.property.taxHouseholdLastName.label" /> *  <span><g:message code="sgr.property.taxHouseholdLastName.help" /></span></label>
            <input type="text" name="taxHouseholdLastName" value="${rqt.taxHouseholdLastName}" 
                    class="required validate-lastName" title="<g:message code="sgr.property.taxHouseholdLastName.validationError" />"  maxLength="38"/>
            

  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdFirstName.label" /> *  <span><g:message code="sgr.property.taxHouseholdFirstName.help" /></span></label>
            <input type="text" name="taxHouseholdFirstName" value="${rqt.taxHouseholdFirstName}" 
                    class="required validate-firstName" title="<g:message code="sgr.property.taxHouseholdFirstName.validationError" />"  maxLength="38"/>
            

  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdPostalCode.label" /> *  <span><g:message code="sgr.property.taxHouseholdPostalCode.help" /></span></label>
            <input type="text" name="taxHouseholdPostalCode" value="${rqt.taxHouseholdPostalCode}" 
                    class="required validate-postalCode" title="<g:message code="sgr.property.taxHouseholdPostalCode.validationError" />"  maxLength="5"/>
            

  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdCity.label" /> *  <span><g:message code="sgr.property.taxHouseholdCity.help" /></span></label>
            <input type="text" name="taxHouseholdCity" value="${rqt.taxHouseholdCity}" 
                    class="required validate-city" title="<g:message code="sgr.property.taxHouseholdCity.validationError" />"  maxLength="32"/>
            

  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdIncome.label" /> *  <span><g:message code="sgr.property.taxHouseholdIncome.help" /></span></label>
            <input type="text" name="taxHouseholdIncome" value="${rqt.taxHouseholdIncome}" 
                    class="required validate-regex" title="<g:message code="sgr.property.taxHouseholdIncome.validationError" />" regex="^\d+(?:\.\d{1,2})?$" />
            

  

