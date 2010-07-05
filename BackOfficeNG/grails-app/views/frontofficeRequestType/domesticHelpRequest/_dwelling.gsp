


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrCurrentDwelling.label" /></legend>
    
      <label class="required"><g:message code="dhr.property.dhrCurrentDwellingAddress.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingAddress.help" /></span></label>
            <div id="dhrCurrentDwellingAddress" class="address-fieldset required  ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingAddress') ? 'validation-failed' : ''}">
            <label for="dhrCurrentDwellingAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrCurrentDwellingAddress.additionalDeliveryInformation" name="dhrCurrentDwellingAddress.additionalDeliveryInformation" />  
            <label for="dhrCurrentDwellingAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrCurrentDwellingAddress.additionalGeographicalInformation" name="dhrCurrentDwellingAddress.additionalGeographicalInformation" />
            <label for="dhrCurrentDwellingAddress_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrCurrentDwellingAddress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.streetNumber}" size="5" maxlength="5" id="dhrCurrentDwellingAddress_streetNumber" name="dhrCurrentDwellingAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.streetName}" maxlength="32" id="dhrCurrentDwellingAddress_streetName" name="dhrCurrentDwellingAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.dhrCurrentDwellingAddress?.streetMatriculation}" id="dhrCurrentDwellingAddress_streetMatriculation" name="dhrCurrentDwellingAddress.streetMatriculation" />
            <input type="hidden" value="${rqt.dhrCurrentDwellingAddress?.streetRivoliCode}" id="dhrCurrentDwellingAddress_streetRivoliCode" name="dhrCurrentDwellingAddress.streetRivoliCode" />
            <label for="dhrCurrentDwellingAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.placeNameOrService}" maxlength="38" id="dhrCurrentDwellingAddress.placeNameOrService" name="dhrCurrentDwellingAddress.placeNameOrService" />
            <label for="dhrCurrentDwellingAddress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrCurrentDwellingAddress_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.postalCode}" size="5" maxlength="5" id="dhrCurrentDwellingAddress_postalCode" name="dhrCurrentDwellingAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingAddress.city') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.city}" maxlength="32" id="dhrCurrentDwellingAddress_city" name="dhrCurrentDwellingAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.dhrCurrentDwellingAddress?.cityInseeCode}" id="dhrCurrentDwellingAddress_cityInseeCode" name="dhrCurrentDwellingAddress.cityInseeCode" />
            <label for="dhrCurrentDwellingAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.countryName}" maxlength="38" id="dhrCurrentDwellingAddress.countryName" name="dhrCurrentDwellingAddress.countryName" />
            </div>
            

    
      <label for="dhrCurrentDwellingPhone" class=""><g:message code="dhr.property.dhrCurrentDwellingPhone.label" />   <span><g:message code="dhr.property.dhrCurrentDwellingPhone.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingPhone" name="dhrCurrentDwellingPhone" value="${rqt.dhrCurrentDwellingPhone?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingPhone') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrCurrentDwellingPhone.validationError" />"  maxlength="10" />
            

    
      <label for="dhrCurrentDwellingKind" class="required"><g:message code="dhr.property.dhrCurrentDwellingKind.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingKind.help" /></span></label>
            <select id="dhrCurrentDwellingKind" name="dhrCurrentDwellingKind" class="required condition-isCurrentDwellingPlaceOfResidence-trigger  validate-not-first ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingKind') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrCurrentDwellingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['placeOfResidence','retirementHome','other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrDwellingKindType_${it}" ${it == rqt.dhrCurrentDwellingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingKind" /></option>
              </g:each>
            </select>
            

    
      <label for="dhrCurrentDwellingArrivalDate" class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingArrivalDate" name="dhrCurrentDwellingArrivalDate" value="${formatDate(formatName:'format.date',date:rqt.dhrCurrentDwellingArrivalDate)}" 
                   class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-date ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingArrivalDate') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrCurrentDwellingArrivalDate.validationError" />" />
            

    
      <label class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingStatus.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingStatus.help" /></span></label>
            <ul class="required condition-isCurrentDwellingPlaceOfResidence-filled ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingStatus') ? 'validation-failed' : ''}">
              <g:each in="${['owner','tenant']}">
              <li>
                <input type="radio" id="dhrCurrentDwellingStatus_${it}" class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrDwellingStatusType_${it}" name="dhrCurrentDwellingStatus" ${it == rqt.dhrCurrentDwellingStatus.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrCurrentDwellingStatus.validationError" />" />
                <label for="dhrCurrentDwellingStatus_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingStatus" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="dhrCurrentDwellingNumberOfRoom" class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingNumberOfRoom" name="dhrCurrentDwellingNumberOfRoom" value="${rqt.dhrCurrentDwellingNumberOfRoom?.toString()}" 
                    class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-dhrDwellingNumberOfRoom ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingNumberOfRoom') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.validationError" />"   />
            

    
      <label for="dhrCurrentDwellingNetArea" class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingNetArea.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingNetArea.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingNetArea" name="dhrCurrentDwellingNetArea" value="${rqt.dhrCurrentDwellingNetArea?.toString()}" 
                    class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-regex ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrCurrentDwellingNetArea') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrCurrentDwellingNetArea.validationError" />" regex="^[1-9]$|^[1-9][0-9]$|^[1-4][0-9][0-9]$|^500$"  />
            

    
    </fieldset>
  

  
    <label class="required"><g:message code="dhr.property.dhrPreviousDwelling.label" /> <span><g:message code="dhr.property.dhrPreviousDwelling.help" /></span></label>
    <div class="collection-fieldset required validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'dhrPreviousDwelling' ? editList?.index : ( rqt.dhrPreviousDwelling ? rqt.dhrPreviousDwelling.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required">
    
        <label class="required"><g:message code="dhr.property.dhrPreviousDwellingAddress.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingAddress.help" /></span></label>
            <div id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress" class="address-fieldset required  ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingAddress') ? 'validation-failed' : ''}">
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.additionalDeliveryInformation" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.additionalDeliveryInformation" />  
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.additionalGeographicalInformation" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.additionalGeographicalInformation" />
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingAddress.streetNumber') ? 'validation-failed' : ''}" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.streetNumber}" size="5" maxlength="5" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_streetNumber" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingAddress.streetName') ? 'validation-failed' : ''}" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.streetName}" maxlength="32" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_streetName" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.streetMatriculation}" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_streetMatriculation" name="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.streetMatriculation" />
            <input type="hidden" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.streetRivoliCode}" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_streetRivoliCode" name="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.streetRivoliCode" />
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.placeNameOrService}" maxlength="38" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.placeNameOrService" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.placeNameOrService" />
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingAddress.postalCode') ? 'validation-failed' : ''}" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.postalCode}" size="5" maxlength="5" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_postalCode" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingAddress.city') ? 'validation-failed' : ''}" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.city}" maxlength="32" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_city" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.cityInseeCode}" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress_cityInseeCode" name="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.cityInseeCode" />
            <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingAddress.countryName') ? 'validation-failed' : ''}" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.countryName}" maxlength="38" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingAddress.countryName" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.countryName" />
            </div>
            

    
        <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingKind" class="required"><g:message code="dhr.property.dhrPreviousDwellingKind.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingKind.help" /></span></label>
            <select id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingKind" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingKind" class="required condition-isPreviousDwellingPlaceOfResidence-trigger  validate-not-first ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingKind') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrPreviousDwellingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['placeOfResidence','retirementHome','other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrDwellingKindType_${it}" ${it == editList?.dhrPreviousDwelling?.dhrPreviousDwellingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingKind" /></option>
              </g:each>
            </select>
            

    
        <label class="required condition-isPreviousDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrPreviousDwellingStatus.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingStatus.help" /></span></label>
            <ul class="required condition-isPreviousDwellingPlaceOfResidence-filled ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingStatus') ? 'validation-failed' : ''}">
              <g:each in="${['owner','tenant']}">
              <li>
                <input type="radio" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingStatus_${it}" class="required condition-isPreviousDwellingPlaceOfResidence-filled  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrDwellingStatusType_${it}" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingStatus" ${it == editList?.dhrPreviousDwelling?.dhrPreviousDwellingStatus.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrPreviousDwellingStatus.validationError" />" />
                <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingStatus_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingStatus" /></label>
              </li>
              </g:each>
            </ul>
            

    
        <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingArrivalDate" class="required"><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.help" /></span></label>
            <input type="text" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingArrivalDate" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingArrivalDate" value="${formatDate(formatName:'format.date',date:editList?.dhrPreviousDwelling?.dhrPreviousDwellingArrivalDate)}" 
                   class="required  validate-date ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingArrivalDate') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrPreviousDwellingArrivalDate.validationError" />" />
            

    
        <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingDepartureDate" class="required"><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.help" /></span></label>
            <input type="text" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingDepartureDate" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingDepartureDate" value="${formatDate(formatName:'format.date',date:editList?.dhrPreviousDwelling?.dhrPreviousDwellingDepartureDate)}" 
                   class="required  validate-date ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingDepartureDate') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrPreviousDwellingDepartureDate.validationError" />" />
            

    
        <label for="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingComment" class="required"><g:message code="dhr.property.dhrPreviousDwellingComment.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingComment.help" /></span></label>
            <input type="text" id="dhrPreviousDwelling.${listIndex}.dhrPreviousDwellingComment" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingComment" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingComment?.toString()}" 
                    class="required  validate-string ${stepStates != null && stepStates['dwelling']?.invalidFields.contains('dhrPreviousDwelling.dhrPreviousDwellingComment') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrPreviousDwellingComment.validationError" />"   />
            

    
        <g:if test="${editList?.name == 'dhrPreviousDwelling'}">
          <input type="submit" id="submit-collectionModify-dwelling-dhrPreviousDwelling" name="submit-collectionModify-dwelling-dhrPreviousDwelling[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-dwelling-dhrPreviousDwelling" name="submit-collectionAdd-dwelling-dhrPreviousDwelling[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.dhrPreviousDwelling}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingAddress.label" /></dt>
        
              <g:if test="${it.dhrPreviousDwellingAddress}">
                <dd>
                  <p>${it.dhrPreviousDwellingAddress?.additionalDeliveryInformation}</p>
                  <p>${it.dhrPreviousDwellingAddress?.additionalGeographicalInformation}</p>
                  <p>${it.dhrPreviousDwellingAddress?.streetNumber} ${it.dhrPreviousDwellingAddress?.streetName}</p>
                  <p>${it.dhrPreviousDwellingAddress?.placeNameOrService}</p>
                  <p>${it.dhrPreviousDwellingAddress?.postalCode} ${it.dhrPreviousDwellingAddress?.city}</p>
                  <p>${it.dhrPreviousDwellingAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingKind.label" /></dt>
        
              <dd>
                <g:if test="${it.dhrPreviousDwellingKind}">
                  <g:capdematEnumToField var="${it.dhrPreviousDwellingKind}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingKind" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingStatus.label" /></dt>
        
              <dd>
                <g:if test="${it.dhrPreviousDwellingStatus}">
                  <g:capdematEnumToField var="${it.dhrPreviousDwellingStatus}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingStatus" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.label" /></dt>
        <dd><g:formatDate formatName="format.date" date="${it.dhrPreviousDwellingArrivalDate}"/></dd>
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.label" /></dt>
        <dd><g:formatDate formatName="format.date" date="${it.dhrPreviousDwellingDepartureDate}"/></dd>
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingComment.label" /></dt>
        <dd>${it.dhrPreviousDwellingComment?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-dwelling-dhrPreviousDwelling[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-dwelling-dhrPreviousDwelling[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

