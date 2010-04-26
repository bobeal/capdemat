


  
    <fieldset class="">
    <legend><g:message code="hcar.property.familyAssistance.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.isFamilyAssistance.label" /> *  <span><g:message code="hcar.property.isFamilyAssistance.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isFamilyAssistance_${it ? 'yes' : 'no'}" class="required condition-isFamilyAssistance-trigger  validate-one-required boolean" title="" value="${it}" name="isFamilyAssistance" ${it == rqt.isFamilyAssistance ? 'checked="checked"': ''} />
                <label for="isFamilyAssistance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection required condition-isFamilyAssistance-filled">
    <h3>
      <g:message code="hcar.property.familyAssistanceMembers.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="hcar.property.familyAssistanceMembers.help" /></span>
      <button type="submit" name="submit-collectionAdd-aid-familyAssistanceMembers">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.familyAssistanceMembers}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="hcar.property.familyAssistanceMembers.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-aid-familyAssistanceMembers[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label for="familyAssistanceMembers.${listIndex}.familyAssistanceMemberRelationship" class="required"><g:message code="hcar.property.familyAssistanceMemberRelationship.label" /> *  <span><g:message code="hcar.property.familyAssistanceMemberRelationship.help" /></span></label>
            <input type="text" id="familyAssistanceMembers.${listIndex}.familyAssistanceMemberRelationship" name="familyAssistanceMembers[${listIndex}].familyAssistanceMemberRelationship" value="${listItem?.familyAssistanceMemberRelationship?.toString()}" 
                    class="required  " title="<g:message code="hcar.property.familyAssistanceMemberRelationship.validationError" />"  maxlength="60" />
            

        
          <label for="familyAssistanceMembers.${listIndex}.familyAssistanceMemberLastName" class="required"><g:message code="hcar.property.familyAssistanceMemberLastName.label" /> *  <span><g:message code="hcar.property.familyAssistanceMemberLastName.help" /></span></label>
            <input type="text" id="familyAssistanceMembers.${listIndex}.familyAssistanceMemberLastName" name="familyAssistanceMembers[${listIndex}].familyAssistanceMemberLastName" value="${listItem?.familyAssistanceMemberLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="hcar.property.familyAssistanceMemberLastName.validationError" />"  maxlength="38" />
            

        
          <label for="familyAssistanceMembers.${listIndex}.familyAssistanceMemberFirstName" class="required"><g:message code="hcar.property.familyAssistanceMemberFirstName.label" /> *  <span><g:message code="hcar.property.familyAssistanceMemberFirstName.help" /></span></label>
            <input type="text" id="familyAssistanceMembers.${listIndex}.familyAssistanceMemberFirstName" name="familyAssistanceMembers[${listIndex}].familyAssistanceMemberFirstName" value="${listItem?.familyAssistanceMemberFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="hcar.property.familyAssistanceMemberFirstName.validationError" />"  maxlength="38" />
            

        
      </fieldset>
    </g:each>
    </div>
  

  
    <fieldset class="">
    <legend><g:message code="hcar.property.homeIntervention.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.homeInterventionHomeIntervenant.label" /> *  <span><g:message code="hcar.property.homeInterventionHomeIntervenant.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="homeInterventionHomeIntervenant_${it ? 'yes' : 'no'}" class="required condition-isHomeIntervenant-trigger  validate-one-required boolean" title="" value="${it}" name="homeInterventionHomeIntervenant" ${it == rqt.homeInterventionHomeIntervenant ? 'checked="checked"': ''} />
                <label for="homeInterventionHomeIntervenant_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection condition-isHomeIntervenant-filled">
    <h3>
      <g:message code="hcar.property.homeIntervenants.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="hcar.property.homeIntervenants.help" /></span>
      <button type="submit" name="submit-collectionAdd-aid-homeIntervenants">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.homeIntervenants}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="hcar.property.homeIntervenants.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-aid-homeIntervenants[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label for="homeIntervenants.${listIndex}.homeIntervenantKind" class="required"><g:message code="hcar.property.homeIntervenantKind.label" /> *  <span><g:message code="hcar.property.homeIntervenantKind.help" /></span></label>
            <select id="homeIntervenants.${listIndex}.homeIntervenantKind" name="homeIntervenants[${listIndex}].homeIntervenantKind" class="required condition-isOtherHomeIntervant-trigger  validate-not-first" title="<g:message code="hcar.property.homeIntervenantKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Carer','HomeHelp','Other']}">
                <option value="fr.cg95.cvq.business.request.social.HcarHomeIntervenantKindType_${it}" ${it == listItem?.homeIntervenantKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.homeIntervenantKind" /></option>
              </g:each>
            </select>
            

        
          <label for="homeIntervenants.${listIndex}.homeIntervenantDetails" class="required condition-isOtherHomeIntervant-filled"><g:message code="hcar.property.homeIntervenantDetails.label" /> *  <span><g:message code="hcar.property.homeIntervenantDetails.help" /></span></label>
            <input type="text" id="homeIntervenants.${listIndex}.homeIntervenantDetails" name="homeIntervenants[${listIndex}].homeIntervenantDetails" value="${listItem?.homeIntervenantDetails?.toString()}" 
                    class="required condition-isOtherHomeIntervant-filled  " title="<g:message code="hcar.property.homeIntervenantDetails.validationError" />"  maxlength="60" />
            

        
      </fieldset>
    </g:each>
    </div>
  

  
    <fieldset class="">
    <legend><g:message code="hcar.property.care.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.careCareServices.label" /> *  <span><g:message code="hcar.property.careCareServices.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="careCareServices_${it ? 'yes' : 'no'}" class="required condition-isCareServices-trigger  validate-one-required boolean" title="" value="${it}" name="careCareServices" ${it == rqt.careCareServices ? 'checked="checked"': ''} />
                <label for="careCareServices_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection required condition-isCareServices-filled">
    <h3>
      <g:message code="hcar.property.careServices.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="hcar.property.careServices.help" /></span>
      <button type="submit" name="submit-collectionAdd-aid-careServices">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.careServices}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="hcar.property.careServices.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-aid-careServices[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label for="careServices.${listIndex}.careServiceKind" class="required"><g:message code="hcar.property.careServiceKind.label" /> *  <span><g:message code="hcar.property.careServiceKind.help" /></span></label>
            <input type="text" id="careServices.${listIndex}.careServiceKind" name="careServices[${listIndex}].careServiceKind" value="${listItem?.careServiceKind?.toString()}" 
                    class="required  validate-string" title="<g:message code="hcar.property.careServiceKind.validationError" />"   />
            

        
          <label class="required"><g:message code="hcar.property.careServiceCareServiceEmployer.label" /> *  <span><g:message code="hcar.property.careServiceCareServiceEmployer.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="careServices.${listIndex}.careServiceCareServiceEmployer_${it ? 'yes' : 'no'}" class="required condition-isCareServiceEmployer-trigger  validate-one-required boolean" title="" value="${it}" name="careServices[${listIndex}].careServiceCareServiceEmployer" ${it == listItem?.careServiceCareServiceEmployer ? 'checked="checked"': ''} />
                <label for="careServices.${listIndex}.careServiceCareServiceEmployer_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

        
          <label for="careServices.${listIndex}.careServiceProviderName" class="required condition-isCareServiceEmployer-unfilled"><g:message code="hcar.property.careServiceProviderName.label" /> *  <span><g:message code="hcar.property.careServiceProviderName.help" /></span></label>
            <input type="text" id="careServices.${listIndex}.careServiceProviderName" name="careServices[${listIndex}].careServiceProviderName" value="${listItem?.careServiceProviderName?.toString()}" 
                    class="required condition-isCareServiceEmployer-unfilled  validate-lastName" title="<g:message code="hcar.property.careServiceProviderName.validationError" />"  maxlength="38" />
            

        
          <label class="condition-isCareServiceEmployer-unfilled"><g:message code="hcar.property.careServiceProviderAddress.label" />   <span><g:message code="hcar.property.careServiceProviderAddress.help" /></span></label>
            <div class="address-fieldset condition-isCareServiceEmployer-unfilled ">
            <label for="careServices.${listIndex}.careServiceProviderAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.careServiceProviderAddress?.additionalDeliveryInformation}" maxlength="38" id="careServices.${listIndex}.careServiceProviderAddress.additionalDeliveryInformation" name="careServices[${listIndex}].careServiceProviderAddress.additionalDeliveryInformation" />  
            <label for="careServices.${listIndex}.careServiceProviderAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.careServiceProviderAddress?.additionalGeographicalInformation}" maxlength="38" id="careServices.${listIndex}.careServiceProviderAddress.additionalGeographicalInformation" name="careServices[${listIndex}].careServiceProviderAddress.additionalGeographicalInformation" />
            <label for="careServices.${listIndex}.careServiceProviderAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="careServices.${listIndex}.careServiceProviderAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${listItem?.careServiceProviderAddress?.streetNumber}" size="5" maxlength="5" id="careServices.${listIndex}.careServiceProviderAddress.streetNumber" name="careServices[${listIndex}].careServiceProviderAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${listItem?.careServiceProviderAddress?.streetName}" maxlength="32" id="careServices.${listIndex}.careServiceProviderAddress.streetName" name="careServices[${listIndex}].careServiceProviderAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="careServices.${listIndex}.careServiceProviderAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.careServiceProviderAddress?.placeNameOrService}" maxlength="38" id="careServices.${listIndex}.careServiceProviderAddress.placeNameOrService" name="careServices[${listIndex}].careServiceProviderAddress.placeNameOrService" />
            <label for="careServices.${listIndex}.careServiceProviderAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="careServices.${listIndex}.careServiceProviderAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${listItem?.careServiceProviderAddress?.postalCode}" size="5" maxlength="5" id="careServices.${listIndex}.careServiceProviderAddress.postalCode" name="careServices[${listIndex}].careServiceProviderAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${listItem?.careServiceProviderAddress?.city}" maxlength="32" id="careServices.${listIndex}.careServiceProviderAddress.city" name="careServices[${listIndex}].careServiceProviderAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="careServices.${listIndex}.careServiceProviderAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.careServiceProviderAddress?.countryName}" maxlength="38" id="careServices.${listIndex}.careServiceProviderAddress.countryName" name="careServices[${listIndex}].careServiceProviderAddress.countryName" />
            </div>
            

        
      </fieldset>
    </g:each>
    </div>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.facilities.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.facilitiesHousing.label" /> *  <span><g:message code="hcar.property.facilitiesHousing.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="facilitiesHousing_${it ? 'yes' : 'no'}" class="required condition-isHousing-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesHousing" ${it == rqt.facilitiesHousing ? 'checked="checked"': ''} />
                <label for="facilitiesHousing_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="facilitiesHousingDetails" class="required condition-isHousing-filled"><g:message code="hcar.property.facilitiesHousingDetails.label" /> *  <span><g:message code="hcar.property.facilitiesHousingDetails.help" /></span></label>
            <input type="text" id="facilitiesHousingDetails" name="facilitiesHousingDetails" value="${rqt.facilitiesHousingDetails?.toString()}" 
                    class="required condition-isHousing-filled  " title="<g:message code="hcar.property.facilitiesHousingDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.facilitiesTechnicalAssistance.label" /> *  <span><g:message code="hcar.property.facilitiesTechnicalAssistance.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="facilitiesTechnicalAssistance_${it ? 'yes' : 'no'}" class="required condition-isTechnicalAssistance-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesTechnicalAssistance" ${it == rqt.facilitiesTechnicalAssistance ? 'checked="checked"': ''} />
                <label for="facilitiesTechnicalAssistance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="facilitiesTechnicalAssistanceDetails" class="required condition-isTechnicalAssistance-filled"><g:message code="hcar.property.facilitiesTechnicalAssistanceDetails.label" /> *  <span><g:message code="hcar.property.facilitiesTechnicalAssistanceDetails.help" /></span></label>
            <input type="text" id="facilitiesTechnicalAssistanceDetails" name="facilitiesTechnicalAssistanceDetails" value="${rqt.facilitiesTechnicalAssistanceDetails?.toString()}" 
                    class="required condition-isTechnicalAssistance-filled  " title="<g:message code="hcar.property.facilitiesTechnicalAssistanceDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.facilitiesCustomCar.label" /> *  <span><g:message code="hcar.property.facilitiesCustomCar.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="facilitiesCustomCar_${it ? 'yes' : 'no'}" class="required condition-isCustomCar-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesCustomCar" ${it == rqt.facilitiesCustomCar ? 'checked="checked"': ''} />
                <label for="facilitiesCustomCar_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="facilitiesCustomCarDetails" class="required condition-isCustomCar-filled"><g:message code="hcar.property.facilitiesCustomCarDetails.label" /> *  <span><g:message code="hcar.property.facilitiesCustomCarDetails.help" /></span></label>
            <input type="text" id="facilitiesCustomCarDetails" name="facilitiesCustomCarDetails" value="${rqt.facilitiesCustomCarDetails?.toString()}" 
                    class="required condition-isCustomCar-filled  " title="<g:message code="hcar.property.facilitiesCustomCarDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.facilitiesAnimalAid.label" /> *  <span><g:message code="hcar.property.facilitiesAnimalAid.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="facilitiesAnimalAid_${it ? 'yes' : 'no'}" class="required condition-isAnimalAid-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesAnimalAid" ${it == rqt.facilitiesAnimalAid ? 'checked="checked"': ''} />
                <label for="facilitiesAnimalAid_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="facilitiesAnimalAidDetails" class="required condition-isAnimalAid-filled"><g:message code="hcar.property.facilitiesAnimalAidDetails.label" /> *  <span><g:message code="hcar.property.facilitiesAnimalAidDetails.help" /></span></label>
            <input type="text" id="facilitiesAnimalAidDetails" name="facilitiesAnimalAidDetails" value="${rqt.facilitiesAnimalAidDetails?.toString()}" 
                    class="required condition-isAnimalAid-filled  " title="<g:message code="hcar.property.facilitiesAnimalAidDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.facilitiesSpecializedTransport.label" /> *  <span><g:message code="hcar.property.facilitiesSpecializedTransport.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="facilitiesSpecializedTransport_${it ? 'yes' : 'no'}" class="required condition-isSpecializedTransport-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesSpecializedTransport" ${it == rqt.facilitiesSpecializedTransport ? 'checked="checked"': ''} />
                <label for="facilitiesSpecializedTransport_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="facilitiesSpecializedTransportDetails" class="required condition-isSpecializedTransport-filled"><g:message code="hcar.property.facilitiesSpecializedTransportDetails.label" /> *  <span><g:message code="hcar.property.facilitiesSpecializedTransportDetails.help" /></span></label>
            <input type="text" id="facilitiesSpecializedTransportDetails" name="facilitiesSpecializedTransportDetails" value="${rqt.facilitiesSpecializedTransportDetails?.toString()}" 
                    class="required condition-isSpecializedTransport-filled  " title="<g:message code="hcar.property.facilitiesSpecializedTransportDetails.validationError" />"  maxlength="60" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.professionalSupport.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.professionalSupportProfessionals.label" /> *  <span><g:message code="hcar.property.professionalSupportProfessionals.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalSupportProfessionals_${it ? 'yes' : 'no'}" class="required condition-isProfessionals-trigger  validate-one-required boolean" title="" value="${it}" name="professionalSupportProfessionals" ${it == rqt.professionalSupportProfessionals ? 'checked="checked"': ''} />
                <label for="professionalSupportProfessionals_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isProfessionals-filled"><g:message code="hcar.property.professionalSupportDealsWithSameProfessional.label" /> *  <span><g:message code="hcar.property.professionalSupportDealsWithSameProfessional.help" /></span></label>
            <ul class="yes-no required condition-isProfessionals-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalSupportDealsWithSameProfessional_${it ? 'yes' : 'no'}" class="required condition-isProfessionals-filled  validate-one-required boolean" title="" value="${it}" name="professionalSupportDealsWithSameProfessional" ${it == rqt.professionalSupportDealsWithSameProfessional ? 'checked="checked"': ''} />
                <label for="professionalSupportDealsWithSameProfessional_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection condition-isProfessionals-filled">
    <h3>
      <g:message code="hcar.property.professionals.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="hcar.property.professionals.help" /></span>
      <button type="submit" name="submit-collectionAdd-aid-professionals">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.professionals}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="hcar.property.professionals.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-aid-professionals[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label for="professionals.${listIndex}.professionalLastName" class="required"><g:message code="hcar.property.professionalLastName.label" /> *  <span><g:message code="hcar.property.professionalLastName.help" /></span></label>
            <input type="text" id="professionals.${listIndex}.professionalLastName" name="professionals[${listIndex}].professionalLastName" value="${listItem?.professionalLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="hcar.property.professionalLastName.validationError" />"  maxlength="38" />
            

        
          <label for="professionals.${listIndex}.professionalFirstName" class="required"><g:message code="hcar.property.professionalFirstName.label" /> *  <span><g:message code="hcar.property.professionalFirstName.help" /></span></label>
            <input type="text" id="professionals.${listIndex}.professionalFirstName" name="professionals[${listIndex}].professionalFirstName" value="${listItem?.professionalFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="hcar.property.professionalFirstName.validationError" />"  maxlength="38" />
            

        
          <label class="required"><g:message code="hcar.property.professionalAddress.label" /> *  <span><g:message code="hcar.property.professionalAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="professionals.${listIndex}.professionalAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.professionalAddress?.additionalDeliveryInformation}" maxlength="38" id="professionals.${listIndex}.professionalAddress.additionalDeliveryInformation" name="professionals[${listIndex}].professionalAddress.additionalDeliveryInformation" />  
            <label for="professionals.${listIndex}.professionalAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.professionalAddress?.additionalGeographicalInformation}" maxlength="38" id="professionals.${listIndex}.professionalAddress.additionalGeographicalInformation" name="professionals[${listIndex}].professionalAddress.additionalGeographicalInformation" />
            <label for="professionals.${listIndex}.professionalAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="professionals.${listIndex}.professionalAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${listItem?.professionalAddress?.streetNumber}" size="5" maxlength="5" id="professionals.${listIndex}.professionalAddress.streetNumber" name="professionals[${listIndex}].professionalAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${listItem?.professionalAddress?.streetName}" maxlength="32" id="professionals.${listIndex}.professionalAddress.streetName" name="professionals[${listIndex}].professionalAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="professionals.${listIndex}.professionalAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.professionalAddress?.placeNameOrService}" maxlength="38" id="professionals.${listIndex}.professionalAddress.placeNameOrService" name="professionals[${listIndex}].professionalAddress.placeNameOrService" />
            <label for="professionals.${listIndex}.professionalAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="professionals.${listIndex}.professionalAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${listItem?.professionalAddress?.postalCode}" size="5" maxlength="5" id="professionals.${listIndex}.professionalAddress.postalCode" name="professionals[${listIndex}].professionalAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${listItem?.professionalAddress?.city}" maxlength="32" id="professionals.${listIndex}.professionalAddress.city" name="professionals[${listIndex}].professionalAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="professionals.${listIndex}.professionalAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.professionalAddress?.countryName}" maxlength="38" id="professionals.${listIndex}.professionalAddress.countryName" name="professionals[${listIndex}].professionalAddress.countryName" />
            </div>
            

        
      </fieldset>
    </g:each>
    </div>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.socialService.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.professionalSupportSocialServiceSupport.label" /> *  <span><g:message code="hcar.property.professionalSupportSocialServiceSupport.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalSupportSocialServiceSupport_${it ? 'yes' : 'no'}" class="required condition-isSocialServiceSupport-trigger  validate-one-required boolean" title="" value="${it}" name="professionalSupportSocialServiceSupport" ${it == rqt.professionalSupportSocialServiceSupport ? 'checked="checked"': ''} />
                <label for="professionalSupportSocialServiceSupport_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="professionalSupportSocialServiceName" class="required condition-isSocialServiceSupport-filled"><g:message code="hcar.property.professionalSupportSocialServiceName.label" /> *  <span><g:message code="hcar.property.professionalSupportSocialServiceName.help" /></span></label>
            <input type="text" id="professionalSupportSocialServiceName" name="professionalSupportSocialServiceName" value="${rqt.professionalSupportSocialServiceName?.toString()}" 
                    class="required condition-isSocialServiceSupport-filled  " title="<g:message code="hcar.property.professionalSupportSocialServiceName.validationError" />"  maxlength="60" />
            

    
      <label class="required condition-isSocialServiceSupport-filled"><g:message code="hcar.property.professionalSupportSocialServiceAddress.label" /> *  <span><g:message code="hcar.property.professionalSupportSocialServiceAddress.help" /></span></label>
            <div class="address-fieldset required condition-isSocialServiceSupport-filled ">
            <label for="professionalSupportSocialServiceAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.professionalSupportSocialServiceAddress?.additionalDeliveryInformation}" maxlength="38" id="professionalSupportSocialServiceAddress.additionalDeliveryInformation" name="professionalSupportSocialServiceAddress.additionalDeliveryInformation" />  
            <label for="professionalSupportSocialServiceAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.professionalSupportSocialServiceAddress?.additionalGeographicalInformation}" maxlength="38" id="professionalSupportSocialServiceAddress.additionalGeographicalInformation" name="professionalSupportSocialServiceAddress.additionalGeographicalInformation" />
            <label for="professionalSupportSocialServiceAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="professionalSupportSocialServiceAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${rqt.professionalSupportSocialServiceAddress?.streetNumber}" size="5" maxlength="5" id="professionalSupportSocialServiceAddress.streetNumber" name="professionalSupportSocialServiceAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${rqt.professionalSupportSocialServiceAddress?.streetName}" maxlength="32" id="professionalSupportSocialServiceAddress.streetName" name="professionalSupportSocialServiceAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="professionalSupportSocialServiceAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.professionalSupportSocialServiceAddress?.placeNameOrService}" maxlength="38" id="professionalSupportSocialServiceAddress.placeNameOrService" name="professionalSupportSocialServiceAddress.placeNameOrService" />
            <label for="professionalSupportSocialServiceAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="professionalSupportSocialServiceAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${rqt.professionalSupportSocialServiceAddress?.postalCode}" size="5" maxlength="5" id="professionalSupportSocialServiceAddress.postalCode" name="professionalSupportSocialServiceAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${rqt.professionalSupportSocialServiceAddress?.city}" maxlength="32" id="professionalSupportSocialServiceAddress.city" name="professionalSupportSocialServiceAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="professionalSupportSocialServiceAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.professionalSupportSocialServiceAddress?.countryName}" maxlength="38" id="professionalSupportSocialServiceAddress.countryName" name="professionalSupportSocialServiceAddress.countryName" />
            </div>
            

    
    </fieldset>
  

