<form method="POST" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  
  <fieldset>
    <label><g:message code="address.property.additionalDeliveryInformation" /></label>
    <input name="${propertyNameTp}.additionalDeliveryInformation" type="text" maxlength="38"
        value="${propertyValue.additionalDeliveryInformation}"/>
        
    <label><g:message code="address.property.additionalGeographicalInformation" /></label>
    <input name="${propertyNameTp}.additionalGeographicalInformation" type="text" maxlength="38"
        value="${propertyValue.additionalGeographicalInformation}" />
    
    <label>
      <g:message code="address.property.streetNumber" />
       - 
      <g:message code="address.property.streetName" />
    </label>
    <input name="${propertyNameTp}.streetNumber" type="text" maxlength="5" 
        value="${propertyValue.streetNumber}" class="line1" />
    
    <input name="${propertyNameTp}.streetName" type="text" maxlength="32"
        value="${propertyValue.streetName}" class="line2 ${required}" 
        title="<g:message code="address.property.streetName" /> - <g:message code="request.error.required" />" />
    
    <label><g:message code="address.property.placeNameOrService" /></label>    
    <input name="${propertyNameTp}.placeNameOrService" type="text" maxlength="38"
        value="${propertyValue.placeNameOrService}" />
    
    <label>
      <g:message code="address.property.postalCode" />
       - 
      <g:message code="address.property.city" />
    </label>
    <input name="${propertyNameTp}.postalCode" type="text" maxlength="5"
        value="${propertyValue.postalCode}" class="line1" />
   
    <input name="${propertyNameTp}.city" type="text" maxlength="32" value="${propertyValue.city}" 
        class="line2 ${required}" 
        title="<g:message code="address.property.city" /> - <g:message code="request.error.required" />" />
    
    <label><g:message code="address.property.countryName" /></label>
    <input name="${propertyNameTp}.countryName" type="text" maxlength="38" value="${propertyValue.countryName}" /> 
  </fieldset>
  
  <input name="requestId" type="hidden" value="${requestId}" />
  <input name="individualId" type="hidden" value="${individualId}" />

  <input type="button" value="modify" class="submit" />
  <input type="button" value="discard" class="discard" />
</form>
