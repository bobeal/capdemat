




  
    <label class="required"><g:message code="sgr.property.taxHouseholdLastName.label" /> *  <span><g:message code="sgr.property.taxHouseholdLastName.help" /></span></label>
    
            <input type="text" name="taxHouseholdLastName" value="${rqt.taxHouseholdLastName}" 
                    class="required validate-lastName" title="<g:message code="sgr.property.taxHouseholdLastName.validationError" />"  maxLength="38"/>
            
  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdFirstName.label" /> *  <span><g:message code="sgr.property.taxHouseholdFirstName.help" /></span></label>
    
            <input type="text" name="taxHouseholdFirstName" value="${rqt.taxHouseholdFirstName}" 
                    class="required validate-firstName" title="<g:message code="sgr.property.taxHouseholdFirstName.validationError" />"  maxLength="38"/>
            
  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdAddress.label" /> *  <span><g:message code="sgr.property.taxHouseholdAddress.help" /></span></label>
    
            <div class="address-fieldset required">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.taxHouseholdAddress?.additionalDeliveryInformation}" maxlength="38" name="taxHouseholdAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.taxHouseholdAddress?.additionalGeographicalInformation}" maxlength="38" name="taxHouseholdAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.taxHouseholdAddress?.streetNumber}" maxlength="5" name="taxHouseholdAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.taxHouseholdAddress?.streetName}" maxlength="32" name="taxHouseholdAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.taxHouseholdAddress?.placeNameOrService}" maxlength="38" name="taxHouseholdAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.taxHouseholdAddress?.postalCode}" maxlength="5" name="taxHouseholdAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.taxHouseholdAddress?.city}" maxlength="32" name="taxHouseholdAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.taxHouseholdAddress?.countryName}" maxlength="38" name="taxHouseholdAddress.countryName"/>
            </div>
            
  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdPhone.label" /> *  <span><g:message code="sgr.property.taxHouseholdPhone.help" /></span></label>
    
            <input type="text" name="taxHouseholdPhone" value="${rqt.taxHouseholdPhone}" 
                    class="required validate-phone" title="<g:message code="sgr.property.taxHouseholdPhone.validationError" />"  maxLength="10"/>
            
  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdIncome.label" /> *  <span><g:message code="sgr.property.taxHouseholdIncome.help" /></span></label>
    
            <input type="text" name="taxHouseholdIncome" value="${rqt.taxHouseholdIncome}" 
                    class="required validate-double" title="<g:message code="sgr.property.taxHouseholdIncome.validationError" />"  />
            
  

