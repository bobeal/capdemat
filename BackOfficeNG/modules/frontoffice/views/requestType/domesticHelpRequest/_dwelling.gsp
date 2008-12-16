


  
    <fieldset class="">
    <legend><g:message code="dhr.property.dhrCurrentDwelling.label" /></legend> 
      
    
      <label class=" "><g:message code="dhr.property.dhrCurrentDwellingAddress.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingAddress.help" /></span></label>
      
        
          <div class="address-fieldset ">
          <label><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.additionalDeliveryInformation}" maxlength="38" name="dhrCurrentDwellingAddress.additionalDeliveryInformation"/>  
          <label><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.additionalGeographicalInformation}" maxlength="38" name="dhrCurrentDwellingAddress.additionalGeographicalInformation"/>
          <label class="required"><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
          <input type="text" class="line1" value="${dhr.dhrCurrentDwellingAddress.streetNumber}" maxlength="5" name="dhrCurrentDwellingAddress.streetNumber"/>
          <input type="text" class="line2 required" value="${dhr.dhrCurrentDwellingAddress.streetName}" maxlength="32" name="dhrCurrentDwellingAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
          <label><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.placeNameOrService}" maxlength="38" name="dhrCurrentDwellingAddress.placeNameOrService"/>
          <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
          <input type="text" class="line1 required" value="${dhr.dhrCurrentDwellingAddress.postalCode}" maxlength="5" name="dhrCurrentDwellingAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
          <input type="text" class="line2 required" value="${dhr.dhrCurrentDwellingAddress.city}" maxlength="32" name="dhrCurrentDwellingAddress.city" title="<g:message code="address.property.city.validationError" />" />
          <label><g:message code="address.property.countryName" /></label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.countryName}" maxlength="38" name="dhrCurrentDwellingAddress.countryName"/>
          </div>
          
      
    
      <label class=" "><g:message code="dhr.property.dhrCurrentDwellingPhone.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingPhone.help" /></span></label>
      
        <input name="dhrCurrentDwellingPhone" value="${dhr.dhrCurrentDwellingPhone}" class="   validate-phone" title="<g:message code="dhr.property.dhrCurrentDwellingPhone.validationError" />">
      
    
      <label class="isCurrentDwellingPlaceOfResidence-trigger  required"><g:message code="dhr.property.dhrCurrentDwellingKind.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingKind.help" /></span></label>
      
        
          <select name="dhrCurrentDwellingKind" class="isCurrentDwellingPlaceOfResidence-trigger  required validate-not-first" title="<g:message code="dhr.property.dhrCurrentDwellingKind.validationError" />">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['placeOfResidence','retirementHome','other']}">
              <option value="fr.cg95.cvq.business.request.social.DhrDwellingKindType_${it}" ${it == dhr.dhrCurrentDwellingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingKind" /></option>
            </g:each>
          </select>
          
      
    
      <label class="isCurrentDwellingPlaceOfResidence-filled  "><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.help" /></span></label>
      
        <input name="dhrCurrentDwellingArrivalDate" value="${formatDate(formatName:'format.date',date:dhr.dhrCurrentDwellingArrivalDate)}" class="isCurrentDwellingPlaceOfResidence-filled    validate-date-au" title="<g:message code="dhr.property.dhrCurrentDwellingArrivalDate.validationError" />">
      
    
      <label class="isCurrentDwellingPlaceOfResidence-filled  required"><g:message code="dhr.property.dhrCurrentDwellingStatus.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingStatus.help" /></span></label>
      
        
          <ul class="isCurrentDwellingPlaceOfResidence-filled ">
            <g:each in="${['owner','tenant']}">
            <li>
              <input type="radio" class="  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrDwellingStatusType_${it}" name="dhrCurrentDwellingStatus" ${it == dhr.dhrCurrentDwellingStatus.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrCurrentDwellingStatus.validationError" />" />
	            <g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingStatus" />
	          </li>
            </g:each>
          </ul>
          
      
    
      <label class="isCurrentDwellingPlaceOfResidence-filled  "><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.help" /></span></label>
      
        <input name="dhrCurrentDwellingNumberOfRoom" value="${dhr.dhrCurrentDwellingNumberOfRoom}" class="isCurrentDwellingPlaceOfResidence-filled    " title="<g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.validationError" />">
      
    
      <label class="isCurrentDwellingPlaceOfResidence-filled  "><g:message code="dhr.property.dhrCurrentDwellingNetArea.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingNetArea.help" /></span></label>
      
        <input name="dhrCurrentDwellingNetArea" value="${dhr.dhrCurrentDwellingNetArea}" class="isCurrentDwellingPlaceOfResidence-filled    " title="<g:message code="dhr.property.dhrCurrentDwellingNetArea.validationError" />">
      
    
    </fieldset>
  

  
    <!-- 
    <label class=" "><g:message code="dhr.property.dhrPreviousDwelling.label" /> <span><g:message code="dhr.property.dhrPreviousDwelling.help" /></span></label>
    TODO = ON TO MANY
    -->
  

