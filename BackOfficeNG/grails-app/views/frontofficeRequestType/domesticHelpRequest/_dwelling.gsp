


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrCurrentDwelling.label" /></legend>
    
      <label class="required"><g:message code="dhr.property.dhrCurrentDwellingAddress.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="dhrCurrentDwellingAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.dhrCurrentDwellingAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrCurrentDwellingAddress.additionalDeliveryInformation" name="dhrCurrentDwellingAddress.additionalDeliveryInformation" />  
            <label for="dhrCurrentDwellingAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.dhrCurrentDwellingAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrCurrentDwellingAddress.additionalGeographicalInformation" name="dhrCurrentDwellingAddress.additionalGeographicalInformation" />
            <label for="dhrCurrentDwellingAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrCurrentDwellingAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${rqt.dhrCurrentDwellingAddress?.streetNumber}" size="5" maxlength="5" id="dhrCurrentDwellingAddress.streetNumber" name="dhrCurrentDwellingAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${rqt.dhrCurrentDwellingAddress?.streetName}" maxlength="32" id="dhrCurrentDwellingAddress.streetName" name="dhrCurrentDwellingAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrCurrentDwellingAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.dhrCurrentDwellingAddress?.placeNameOrService}" maxlength="38" id="dhrCurrentDwellingAddress.placeNameOrService" name="dhrCurrentDwellingAddress.placeNameOrService" />
            <label for="dhrCurrentDwellingAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrCurrentDwellingAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${rqt.dhrCurrentDwellingAddress?.postalCode}" size="5" maxlength="5" id="dhrCurrentDwellingAddress.postalCode" name="dhrCurrentDwellingAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${rqt.dhrCurrentDwellingAddress?.city}" maxlength="32" id="dhrCurrentDwellingAddress.city" name="dhrCurrentDwellingAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrCurrentDwellingAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.dhrCurrentDwellingAddress?.countryName}" maxlength="38" id="dhrCurrentDwellingAddress.countryName" name="dhrCurrentDwellingAddress.countryName" />
            </div>
            

    
      <label for="dhrCurrentDwellingPhone" class=""><g:message code="dhr.property.dhrCurrentDwellingPhone.label" />   <span><g:message code="dhr.property.dhrCurrentDwellingPhone.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingPhone" name="dhrCurrentDwellingPhone" value="${rqt.dhrCurrentDwellingPhone?.toString()}" 
                    class="  validate-phone" title="<g:message code="dhr.property.dhrCurrentDwellingPhone.validationError" />"  maxlength="10" />
            

    
      <label for="dhrCurrentDwellingKind" class="required"><g:message code="dhr.property.dhrCurrentDwellingKind.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingKind.help" /></span></label>
            <select id="dhrCurrentDwellingKind" name="dhrCurrentDwellingKind" class="required condition-isCurrentDwellingPlaceOfResidence-trigger  validate-not-first" title="<g:message code="dhr.property.dhrCurrentDwellingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['placeOfResidence','retirementHome','other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrDwellingKindType_${it}" ${it == rqt.dhrCurrentDwellingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingKind" /></option>
              </g:each>
            </select>
            

    
      <label for="dhrCurrentDwellingArrivalDate" class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingArrivalDate" name="dhrCurrentDwellingArrivalDate" value="${formatDate(formatName:'format.date',date:rqt.dhrCurrentDwellingArrivalDate)}" 
                   class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-date" title="<g:message code="dhr.property.dhrCurrentDwellingArrivalDate.validationError" />" />
            

    
      <label class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingStatus.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingStatus.help" /></span></label>
            <ul class="required condition-isCurrentDwellingPlaceOfResidence-filled">
              <g:each in="${['owner','tenant']}">
              <li>
                <input type="radio" id="dhrCurrentDwellingStatus_${it}" class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrDwellingStatusType_${it}" name="dhrCurrentDwellingStatus" ${it == rqt.dhrCurrentDwellingStatus.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrCurrentDwellingStatus.validationError" />" />
                <label for="dhrCurrentDwellingStatus_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingStatus" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="dhrCurrentDwellingNumberOfRoom" class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingNumberOfRoom" name="dhrCurrentDwellingNumberOfRoom" value="${rqt.dhrCurrentDwellingNumberOfRoom?.toString()}" 
                    class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-dhrDwellingNumberOfRoom" title="<g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.validationError" />"   />
            

    
      <label for="dhrCurrentDwellingNetArea" class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingNetArea.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingNetArea.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingNetArea" name="dhrCurrentDwellingNetArea" value="${rqt.dhrCurrentDwellingNetArea?.toString()}" 
                    class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-regex" title="<g:message code="dhr.property.dhrCurrentDwellingNetArea.validationError" />" regex="/^[1-9]$|^[1-9][0-9]$|^[1-4][0-9][0-9]$|^500$/"  />
            

    
    </fieldset>
  

  
    <div class="collection required">
    <h3>
      <g:message code="dhr.property.dhrPreviousDwelling.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="dhr.property.dhrPreviousDwelling.help" /></span>
      <button type="submit" name="submit-collectionAdd-dwelling-dhrPreviousDwelling">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.dhrPreviousDwelling}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="dhr.property.dhrPreviousDwelling.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-dwelling-dhrPreviousDwelling[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label class="required"><g:message code="dhr.property.dhrPreviousDwellingAddress.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrPreviousDwellingAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.additionalDeliveryInformation" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.additionalDeliveryInformation" />  
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrPreviousDwellingAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.additionalGeographicalInformation" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.additionalGeographicalInformation" />
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${listItem?.dhrPreviousDwellingAddress?.streetNumber}" size="5" maxlength="5" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.streetNumber" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${listItem?.dhrPreviousDwellingAddress?.streetName}" maxlength="32" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.streetName" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrPreviousDwellingAddress?.placeNameOrService}" maxlength="38" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.placeNameOrService" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.placeNameOrService" />
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${listItem?.dhrPreviousDwellingAddress?.postalCode}" size="5" maxlength="5" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.postalCode" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${listItem?.dhrPreviousDwellingAddress?.city}" maxlength="32" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.city" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.dhrPreviousDwellingAddress?.countryName}" maxlength="38" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.countryName" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.countryName" />
            </div>
            

        
          <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingKind" class="required"><g:message code="dhr.property.dhrPreviousDwellingKind.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingKind.help" /></span></label>
            <select id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingKind" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingKind" class="required condition-isPreviousDwellingPlaceOfResidence-trigger  validate-not-first" title="<g:message code="dhr.property.dhrPreviousDwellingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['placeOfResidence','retirementHome','other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrDwellingKindType_${it}" ${it == listItem?.dhrPreviousDwellingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingKind" /></option>
              </g:each>
            </select>
            

        
          <label class="required condition-isPreviousDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrPreviousDwellingStatus.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingStatus.help" /></span></label>
            <ul class="required condition-isPreviousDwellingPlaceOfResidence-filled">
              <g:each in="${['owner','tenant']}">
              <li>
                <input type="radio" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingStatus_${it}" class="required condition-isPreviousDwellingPlaceOfResidence-filled  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrDwellingStatusType_${it}" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingStatus" ${it == listItem?.dhrPreviousDwellingStatus.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrPreviousDwellingStatus.validationError" />" />
                <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingStatus_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingStatus" /></label>
              </li>
              </g:each>
            </ul>
            

        
          <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingArrivalDate" class="required"><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.help" /></span></label>
            <input type="text" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingArrivalDate" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingArrivalDate" value="${formatDate(formatName:'format.date',date:listItem?.dhrPreviousDwellingArrivalDate)}" 
                   class="required  validate-date" title="<g:message code="dhr.property.dhrPreviousDwellingArrivalDate.validationError" />" />
            

        
          <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingDepartureDate" class="required"><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.help" /></span></label>
            <input type="text" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingDepartureDate" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingDepartureDate" value="${formatDate(formatName:'format.date',date:listItem?.dhrPreviousDwellingDepartureDate)}" 
                   class="required  validate-date" title="<g:message code="dhr.property.dhrPreviousDwellingDepartureDate.validationError" />" />
            

        
          <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingComment" class="required"><g:message code="dhr.property.dhrPreviousDwellingComment.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingComment.help" /></span></label>
            <input type="text" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingComment" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingComment" value="${listItem?.dhrPreviousDwellingComment?.toString()}" 
                    class="required  validate-string" title="<g:message code="dhr.property.dhrPreviousDwellingComment.validationError" />"   />
            

        
      </fieldset>
    </g:each>
    </div>
  

