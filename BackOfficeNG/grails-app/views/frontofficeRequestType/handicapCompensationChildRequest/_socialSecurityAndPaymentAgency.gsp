


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.socialSecurity.label" /></legend>
    
      <label for="socialSecurityMemberShipKind" class="required"><g:message code="hccr.property.socialSecurityMemberShipKind.label" /> *  <span><g:message code="hccr.property.socialSecurityMemberShipKind.help" /></span></label>
            <select id="socialSecurityMemberShipKind" name="socialSecurityMemberShipKind" class="required condition-isSocialSecurityMemberShip-trigger  validate-not-first ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityMemberShipKind') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.socialSecurityMemberShipKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Insured','Claimant','NoMemberShip']}">
                <option value="fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType_${it}" ${it == rqt.socialSecurityMemberShipKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.socialSecurityMemberShipKind" /></option>
              </g:each>
            </select>
            

    
      <label for="socialSecurityNumber" class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hccr.property.socialSecurityNumber.label" /> *  <span><g:message code="hccr.property.socialSecurityNumber.help" /></span></label>
            <input type="text" id="socialSecurityNumber" name="socialSecurityNumber" value="${rqt.socialSecurityNumber?.toString()}" 
                    class="required condition-isSocialSecurityMemberShip-filled   ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityNumber') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.socialSecurityNumber.validationError" />"   />
            

    
      <label for="socialSecurityAgencyName" class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hccr.property.socialSecurityAgencyName.label" /> *  <span><g:message code="hccr.property.socialSecurityAgencyName.help" /></span></label>
            <input type="text" id="socialSecurityAgencyName" name="socialSecurityAgencyName" value="${rqt.socialSecurityAgencyName?.toString()}" 
                    class="required condition-isSocialSecurityMemberShip-filled   ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityAgencyName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.socialSecurityAgencyName.validationError" />"  maxlength="50" />
            

    
      <label class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hccr.property.socialSecurityAgencyAddress.label" /> *  <span><g:message code="hccr.property.socialSecurityAgencyAddress.help" /></span></label>
            <div class="address-fieldset required condition-isSocialSecurityMemberShip-filled  ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityAgencyAddress') ? 'validation-failed' : ''}">
            <label for="socialSecurityAgencyAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityAgencyAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.socialSecurityAgencyAddress?.additionalDeliveryInformation}" maxlength="38" id="socialSecurityAgencyAddress.additionalDeliveryInformation" name="socialSecurityAgencyAddress.additionalDeliveryInformation" />  
            <label for="socialSecurityAgencyAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityAgencyAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.socialSecurityAgencyAddress?.additionalGeographicalInformation}" maxlength="38" id="socialSecurityAgencyAddress.additionalGeographicalInformation" name="socialSecurityAgencyAddress.additionalGeographicalInformation" />
            <label for="socialSecurityAgencyAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="socialSecurityAgencyAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityAgencyAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.socialSecurityAgencyAddress?.streetNumber}" size="5" maxlength="5" id="socialSecurityAgencyAddress.streetNumber" name="socialSecurityAgencyAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityAgencyAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.socialSecurityAgencyAddress?.streetName}" maxlength="32" id="socialSecurityAgencyAddress.streetName" name="socialSecurityAgencyAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.socialSecurityAgencyAddress?.streetMatriculation}" id="socialSecurityAgencyAddress.streetMatriculation" name="socialSecurityAgencyAddress.streetMatriculation" />
            <label for="socialSecurityAgencyAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityAgencyAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.socialSecurityAgencyAddress?.placeNameOrService}" maxlength="38" id="socialSecurityAgencyAddress.placeNameOrService" name="socialSecurityAgencyAddress.placeNameOrService" />
            <label for="socialSecurityAgencyAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="socialSecurityAgencyAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityAgencyAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.socialSecurityAgencyAddress?.postalCode}" size="5" maxlength="5" id="socialSecurityAgencyAddress.postalCode" name="socialSecurityAgencyAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityAgencyAddress.city') ? 'validation-failed' : ''}" value="${rqt.socialSecurityAgencyAddress?.city}" maxlength="32" id="socialSecurityAgencyAddress.city" name="socialSecurityAgencyAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.socialSecurityAgencyAddress?.cityInseeCode}" id="socialSecurityAgencyAddress.cityInseeCode" name="socialSecurityAgencyAddress.cityInseeCode" />
            <label for="socialSecurityAgencyAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('socialSecurityAgencyAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.socialSecurityAgencyAddress?.countryName}" maxlength="38" id="socialSecurityAgencyAddress.countryName" name="socialSecurityAgencyAddress.countryName" />
            </div>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.paymentAgency.label" /></legend>
    
      <label for="paymentAgencyBeneficiary" class="required"><g:message code="hccr.property.paymentAgencyBeneficiary.label" /> *  <span><g:message code="hccr.property.paymentAgencyBeneficiary.help" /></span></label>
            <select id="paymentAgencyBeneficiary" name="paymentAgencyBeneficiary" class="required condition-isPaymentAgencyBeneficiary-trigger  validate-not-first ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyBeneficiary') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.paymentAgencyBeneficiary.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['CAF','MSA','Other','NoMemberShip']}">
                <option value="fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType_${it}" ${it == rqt.paymentAgencyBeneficiary?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.paymentAgencyBeneficiary" /></option>
              </g:each>
            </select>
            

    
      <label for="paymentAgencyBeneficiaryNumber" class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hccr.property.paymentAgencyBeneficiaryNumber.label" /> *  <span><g:message code="hccr.property.paymentAgencyBeneficiaryNumber.help" /></span></label>
            <input type="text" id="paymentAgencyBeneficiaryNumber" name="paymentAgencyBeneficiaryNumber" value="${rqt.paymentAgencyBeneficiaryNumber?.toString()}" 
                    class="required condition-isPaymentAgencyBeneficiary-filled   ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyBeneficiaryNumber') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.paymentAgencyBeneficiaryNumber.validationError" />"  maxlength="20" />
            

    
      <label for="paymentAgencyName" class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hccr.property.paymentAgencyName.label" /> *  <span><g:message code="hccr.property.paymentAgencyName.help" /></span></label>
            <input type="text" id="paymentAgencyName" name="paymentAgencyName" value="${rqt.paymentAgencyName?.toString()}" 
                    class="required condition-isPaymentAgencyBeneficiary-filled   ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.paymentAgencyName.validationError" />"  maxlength="50" />
            

    
      <label class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hccr.property.paymentAgencyAddress.label" /> *  <span><g:message code="hccr.property.paymentAgencyAddress.help" /></span></label>
            <div class="address-fieldset required condition-isPaymentAgencyBeneficiary-filled  ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyAddress') ? 'validation-failed' : ''}">
            <label for="paymentAgencyAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.paymentAgencyAddress?.additionalDeliveryInformation}" maxlength="38" id="paymentAgencyAddress.additionalDeliveryInformation" name="paymentAgencyAddress.additionalDeliveryInformation" />  
            <label for="paymentAgencyAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.paymentAgencyAddress?.additionalGeographicalInformation}" maxlength="38" id="paymentAgencyAddress.additionalGeographicalInformation" name="paymentAgencyAddress.additionalGeographicalInformation" />
            <label for="paymentAgencyAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="paymentAgencyAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.paymentAgencyAddress?.streetNumber}" size="5" maxlength="5" id="paymentAgencyAddress.streetNumber" name="paymentAgencyAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.paymentAgencyAddress?.streetName}" maxlength="32" id="paymentAgencyAddress.streetName" name="paymentAgencyAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.paymentAgencyAddress?.streetMatriculation}" id="paymentAgencyAddress.streetMatriculation" name="paymentAgencyAddress.streetMatriculation" />
            <label for="paymentAgencyAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.paymentAgencyAddress?.placeNameOrService}" maxlength="38" id="paymentAgencyAddress.placeNameOrService" name="paymentAgencyAddress.placeNameOrService" />
            <label for="paymentAgencyAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="paymentAgencyAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.paymentAgencyAddress?.postalCode}" size="5" maxlength="5" id="paymentAgencyAddress.postalCode" name="paymentAgencyAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyAddress.city') ? 'validation-failed' : ''}" value="${rqt.paymentAgencyAddress?.city}" maxlength="32" id="paymentAgencyAddress.city" name="paymentAgencyAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.paymentAgencyAddress?.cityInseeCode}" id="paymentAgencyAddress.cityInseeCode" name="paymentAgencyAddress.cityInseeCode" />
            <label for="paymentAgencyAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['socialSecurityAndPaymentAgency']?.invalidFields.contains('paymentAgencyAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.paymentAgencyAddress?.countryName}" maxlength="38" id="paymentAgencyAddress.countryName" name="paymentAgencyAddress.countryName" />
            </div>
            

    
    </fieldset>
  

