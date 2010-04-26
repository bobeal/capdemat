<form method="post" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  
  <fieldset>
    <label><g:message code="address.property.additionalDeliveryInformation" /></label>
    <input name="${propertyName}.additionalDeliveryInformation" type="text" maxlength="38" class="validate-addressLine38"
        value="${propertyValue.additionalDeliveryInformation}"/>
        
    <label><g:message code="address.property.additionalGeographicalInformation" /></label>
    <input name="${propertyName}.additionalGeographicalInformation" type="text" maxlength="38" class="validate-addressLine38"
        value="${propertyValue.additionalGeographicalInformation}" />
    
    <label>
      <g:message code="address.property.streetNumber" />
       - 
      <strong><g:message code="address.property.streetName" /> * </strong>
    </label>
    <input name="${propertyName}.streetNumber" type="text" maxlength="5" 
        value="${propertyValue.streetNumber}" class="line1 validate-streetNumber" />
    
    <input name="${propertyName}.streetName" type="text" maxlength="32"
        value="${propertyValue.streetName}" class="line2 ${required} validate-streetName"
        title="<g:message code="address.property.streetName" /> - <g:message code="request.error.required" />" />
    
    <label><g:message code="address.property.placeNameOrService" /></label>    
    <input name="${propertyName}.placeNameOrService" type="text" maxlength="38" class="validate-addressLine38"
        value="${propertyValue.placeNameOrService}" />
    
    <label>
      <strong><g:message code="address.property.postalCode" /> * </strong>
       - 
      <strong><g:message code="address.property.city" /> * </strong>
    </label>
    <input name="${propertyName}.postalCode" type="text" maxlength="5"
        value="${propertyValue.postalCode}" class="line1 validate-postalCode" />
   
    <input name="${propertyName}.city" type="text" maxlength="32" value="${propertyValue.city}" 
        class="line2 ${required} validate-city" 
        title="<g:message code="address.property.city" /> - <g:message code="request.error.required" />" />
    
    <label><g:message code="address.property.countryName" /></label>
    <input name="${propertyName}.countryName" type="text" maxlength="38"  class="validate-addressLine38" 
      value="${propertyValue.countryName}" /> 
  </fieldset>
  
  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="<g:message code="action.save" />" />
  <input type="button" class="revertField" value="<g:message code="action.cancel" />" />
</form>
