




  
    <fieldset class="required">
    <legend><g:message code="hcar.property.socialSecurity.label" /></legend> 
      
    
      <label class="required"><g:message code="hcar.property.socialSecurityMemberShipKind.label" /> * <span><g:message code="hcar.property.socialSecurityMemberShipKind.help" /></span></label>
      
            <select name="socialSecurityMemberShipKind" class="required condition-isSocialSecurityMemberShip-trigger validate-not-first" title="<g:message code="hcar.property.socialSecurityMemberShipKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Insured','Claimant','NoMemberShip']}">
                <option value="fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType_${it}" ${it == rqt.socialSecurityMemberShipKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hcar.property.socialSecurityMemberShipKind" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hcar.property.socialSecurityNumber.label" /> * <span><g:message code="hcar.property.socialSecurityNumber.help" /></span></label>
      
            <input type="text" name="socialSecurityNumber" value="${rqt.socialSecurityNumber}" 
                    class="required condition-isSocialSecurityMemberShip-filled " title="<g:message code="hcar.property.socialSecurityNumber.validationError" />" />
            
    
      <label class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hcar.property.socialSecurityAgencyName.label" /> * <span><g:message code="hcar.property.socialSecurityAgencyName.help" /></span></label>
      
            <input type="text" name="socialSecurityAgencyName" value="${rqt.socialSecurityAgencyName}" 
                    class="required condition-isSocialSecurityMemberShip-filled " title="<g:message code="hcar.property.socialSecurityAgencyName.validationError" />" />
            
    
      <label class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hcar.property.socialSecurityAgencyAddress.label" /> * <span><g:message code="hcar.property.socialSecurityAgencyAddress.help" /></span></label>
      
            <div class="address-fieldset required condition-isSocialSecurityMemberShip-filled">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.socialSecurityAgencyAddress?.additionalDeliveryInformation}" maxlength="38" name="socialSecurityAgencyAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.socialSecurityAgencyAddress?.additionalGeographicalInformation}" maxlength="38" name="socialSecurityAgencyAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.socialSecurityAgencyAddress?.streetNumber}" maxlength="5" name="socialSecurityAgencyAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.socialSecurityAgencyAddress?.streetName}" maxlength="32" name="socialSecurityAgencyAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.socialSecurityAgencyAddress?.placeNameOrService}" maxlength="38" name="socialSecurityAgencyAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.socialSecurityAgencyAddress?.postalCode}" maxlength="5" name="socialSecurityAgencyAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.socialSecurityAgencyAddress?.city}" maxlength="32" name="socialSecurityAgencyAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.socialSecurityAgencyAddress?.countryName}" maxlength="38" name="socialSecurityAgencyAddress.countryName"/>
            </div>
            
    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.paymentAgency.label" /></legend> 
      
    
      <label class="required"><g:message code="hcar.property.paymentAgencyBeneficiary.label" /> * <span><g:message code="hcar.property.paymentAgencyBeneficiary.help" /></span></label>
      
            <select name="paymentAgencyBeneficiary" class="required condition-isPaymentAgencyBeneficiary-trigger validate-not-first" title="<g:message code="hcar.property.paymentAgencyBeneficiary.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['CAF','MSA','Other','NoMemberShip']}">
                <option value="fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType_${it}" ${it == rqt.paymentAgencyBeneficiary?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hcar.property.paymentAgencyBeneficiary" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hcar.property.paymentAgencyBeneficiaryNumber.label" /> * <span><g:message code="hcar.property.paymentAgencyBeneficiaryNumber.help" /></span></label>
      
            <input type="text" name="paymentAgencyBeneficiaryNumber" value="${rqt.paymentAgencyBeneficiaryNumber}" 
                    class="required condition-isPaymentAgencyBeneficiary-filled " title="<g:message code="hcar.property.paymentAgencyBeneficiaryNumber.validationError" />" />
            
    
      <label class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hcar.property.paymentAgencyName.label" /> * <span><g:message code="hcar.property.paymentAgencyName.help" /></span></label>
      
            <input type="text" name="paymentAgencyName" value="${rqt.paymentAgencyName}" 
                    class="required condition-isPaymentAgencyBeneficiary-filled " title="<g:message code="hcar.property.paymentAgencyName.validationError" />" />
            
    
      <label class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hcar.property.paymentAgencyAddress.label" /> * <span><g:message code="hcar.property.paymentAgencyAddress.help" /></span></label>
      
            <div class="address-fieldset required condition-isPaymentAgencyBeneficiary-filled">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.paymentAgencyAddress?.additionalDeliveryInformation}" maxlength="38" name="paymentAgencyAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.paymentAgencyAddress?.additionalGeographicalInformation}" maxlength="38" name="paymentAgencyAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.paymentAgencyAddress?.streetNumber}" maxlength="5" name="paymentAgencyAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.paymentAgencyAddress?.streetName}" maxlength="32" name="paymentAgencyAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.paymentAgencyAddress?.placeNameOrService}" maxlength="38" name="paymentAgencyAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.paymentAgencyAddress?.postalCode}" maxlength="5" name="paymentAgencyAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.paymentAgencyAddress?.city}" maxlength="32" name="paymentAgencyAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.paymentAgencyAddress?.countryName}" maxlength="38" name="paymentAgencyAddress.countryName"/>
            </div>
            
    
    </fieldset>
  

