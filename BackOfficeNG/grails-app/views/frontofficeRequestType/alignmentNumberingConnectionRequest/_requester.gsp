


  
    
              <g:render template="/frontofficeRequestType/widget/requester" model="['requester':requester, 'hasHomeFolder':hasHomeFolder]" />
            

  

  
    <label class="required"><g:message code="ancr.property.isAccountAddress.label" /> *  <span><g:message code="ancr.property.isAccountAddress.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['requester']?.invalidFields.contains('isAccountAddress') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isAccountAddress_${it ? 'yes' : 'no'}" class="required condition-isSameAddress-trigger  validate-one-required boolean" title="" value="${it}" name="isAccountAddress" ${it == rqt.isAccountAddress ? 'checked="checked"': ''} />
                <label for="isAccountAddress_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required condition-isSameAddress-unfilled"><g:message code="ancr.property.otherAddress.label" /> *  <span><g:message code="ancr.property.otherAddress.help" /></span></label>
            <div class="address-fieldset required condition-isSameAddress-unfilled  ${stepStates != null && stepStates['requester']?.invalidFields.contains('otherAddress') ? 'validation-failed' : ''}">
            <label for="otherAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['requester']?.invalidFields.contains('otherAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.otherAddress?.additionalDeliveryInformation}" maxlength="38" id="otherAddress.additionalDeliveryInformation" name="otherAddress.additionalDeliveryInformation" />  
            <label for="otherAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['requester']?.invalidFields.contains('otherAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.otherAddress?.additionalGeographicalInformation}" maxlength="38" id="otherAddress.additionalGeographicalInformation" name="otherAddress.additionalGeographicalInformation" />
            <label for="otherAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="otherAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['requester']?.invalidFields.contains('otherAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.otherAddress?.streetNumber}" size="5" maxlength="5" id="otherAddress.streetNumber" name="otherAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['requester']?.invalidFields.contains('otherAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.otherAddress?.streetName}" maxlength="32" id="otherAddress.streetName" name="otherAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="" id="otherAddress_streetMatriculation" name="otherAddress.streetMatriculation" />
            <label for="otherAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['requester']?.invalidFields.contains('otherAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.otherAddress?.placeNameOrService}" maxlength="38" id="otherAddress.placeNameOrService" name="otherAddress.placeNameOrService" />
            <label for="otherAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="otherAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="hidden" value="" id="otherAddress_cityInseeCode" name="otherAddress.cityInseeCode" />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['requester']?.invalidFields.contains('otherAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.otherAddress?.postalCode}" size="5" maxlength="5" id="otherAddress.postalCode" name="otherAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['requester']?.invalidFields.contains('otherAddress.city') ? 'validation-failed' : ''}" value="${rqt.otherAddress?.city}" maxlength="32" id="otherAddress.city" name="otherAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="otherAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['requester']?.invalidFields.contains('otherAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.otherAddress?.countryName}" maxlength="38" id="otherAddress.countryName" name="otherAddress.countryName" />
            </div>
            

  

