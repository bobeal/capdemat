


  
    <fieldset class="">
    <legend><g:message code="dhr.property.dhrFamilyReferent.label" /></legend>
    
      <label class="haveFamilyReferent-trigger "><g:message code="dhr.property.dhrHaveFamilyReferent.label" /> <span><g:message code="dhr.property.dhrHaveFamilyReferent.help" /></span></label>
      
        
          <ul class="haveFamilyReferent-trigger ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="haveFamilyReferent-trigger  required validate-one-required" title="" value="${it}" name="dhrHaveFamilyReferent" ${it == dhr.dhrHaveFamilyReferent ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
      
    
      <label class="haveFamilyReferent-filled "><g:message code="dhr.property.dhrReferentName.label" /> <span><g:message code="dhr.property.dhrReferentName.help" /></span></label>
      
        <input name="dhrReferentName" value="${dhr.dhrReferentName}" class="haveFamilyReferent-filled    validate-lastname" title="<g:message code="dhr.property.dhrReferentName.validationError" />">
      
    
      <label class="haveFamilyReferent-filled "><g:message code="dhr.property.dhrReferentFirstName.label" /> <span><g:message code="dhr.property.dhrReferentFirstName.help" /></span></label>
      
        <input name="dhrReferentFirstName" value="${dhr.dhrReferentFirstName}" class="haveFamilyReferent-filled    validate-firstname" title="<g:message code="dhr.property.dhrReferentFirstName.validationError" />">
      
    
      <label class="haveFamilyReferent-filled "><g:message code="dhr.property.dhrReferentAddress.label" /> <span><g:message code="dhr.property.dhrReferentAddress.help" /></span></label>
      
        
          <div class="address-fieldset haveFamilyReferent-filled ">
          <label><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" value="${dhr.dhrReferentAddress.additionalDeliveryInformation}" maxlength="38" name="dhrReferentAddress.additionalDeliveryInformation"/>  
          <label><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" value="${dhr.dhrReferentAddress.additionalGeographicalInformation}" maxlength="38" name="dhrReferentAddress.additionalGeographicalInformation"/>
          <label><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
          <input type="text" class="line1" value="${dhr.dhrReferentAddress.streetNumber}" maxlength="5" name="dhrReferentAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrReferentAddress.streetName}" maxlength="32" name="dhrReferentAddress.streetName" title="<g:message code="request.error.required" />" />
          <label><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" value="${dhr.dhrReferentAddress.placeNameOrService}" maxlength="38" name="dhrReferentAddress.placeNameOrService"/>
          <label><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
          <input type="text" class="line1" value="${dhr.dhrReferentAddress.postalCode}" maxlength="5" name="dhrReferentAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrReferentAddress.city}" maxlength="32" name="dhrReferentAddress.city" title="<g:message code="request.error.required" />" />
          <label><g:message code="address.property.countryName" /></label>
          <input type="text" value="${dhr.dhrReferentAddress.countryName}" maxlength="38" name="dhrReferentAddress.countryName"/>
          </div>
          
      
    
    </fieldset>
  

           
