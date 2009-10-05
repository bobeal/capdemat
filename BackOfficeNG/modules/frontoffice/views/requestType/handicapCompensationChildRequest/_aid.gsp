


  
    <fieldset class="">
    <legend><g:message code="hccr.property.familyAssistance.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.isFamilyAssistance.label" /> *  <span><g:message code="hccr.property.isFamilyAssistance.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isFamilyAssistance-trigger  validate-one-required boolean" title="" value="${it}" name="isFamilyAssistance" ${it == rqt.isFamilyAssistance ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="required condition-isFamilyAssistance-filled"><g:message code="hccr.property.familyAssistanceMembers.label" /> <span><g:message code="hccr.property.familyAssistanceMembers.help" /></span></label>
    <div class="collection-fieldset required condition-isFamilyAssistance-filled validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'familyAssistanceMembers' ? editList?.index : ( rqt.familyAssistanceMembers ? rqt.familyAssistanceMembers.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required condition-isFamilyAssistance-filled">
    
        <label class="required"><g:message code="hccr.property.familyAssistanceMemberRelationship.label" /> *  <span><g:message code="hccr.property.familyAssistanceMemberRelationship.help" /></span></label>
            <input type="text" name="familyAssistanceMembers[${listIndex}].familyAssistanceMemberRelationship" value="${editList?.familyAssistanceMembers?.familyAssistanceMemberRelationship?.toString()}" 
                    class="required  " title="<g:message code="hccr.property.familyAssistanceMemberRelationship.validationError" />"  maxlength="60" />
            

    
        <label class="required"><g:message code="hccr.property.familyAssistanceMemberLastName.label" /> *  <span><g:message code="hccr.property.familyAssistanceMemberLastName.help" /></span></label>
            <input type="text" name="familyAssistanceMembers[${listIndex}].familyAssistanceMemberLastName" value="${editList?.familyAssistanceMembers?.familyAssistanceMemberLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="hccr.property.familyAssistanceMemberLastName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="hccr.property.familyAssistanceMemberFirstName.label" /> *  <span><g:message code="hccr.property.familyAssistanceMemberFirstName.help" /></span></label>
            <input type="text" name="familyAssistanceMembers[${listIndex}].familyAssistanceMemberFirstName" value="${editList?.familyAssistanceMembers?.familyAssistanceMemberFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="hccr.property.familyAssistanceMemberFirstName.validationError" />"  maxlength="38" />
            

    
        <g:if test="${editList?.name == 'familyAssistanceMembers'}">
          <input type="submit" id="submit-collectionModify-aid-familyAssistanceMembers" name="submit-collectionModify-aid-familyAssistanceMembers[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-aid-familyAssistanceMembers" name="submit-collectionAdd-aid-familyAssistanceMembers[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.familyAssistanceMembers}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="hccr.property.familyAssistanceMemberRelationship.label" /></dt>
        <dd>${it.familyAssistanceMemberRelationship?.toString()}</dd>
    
        <dt><g:message code="hccr.property.familyAssistanceMemberLastName.label" /></dt>
        <dd>${it.familyAssistanceMemberLastName?.toString()}</dd>
    
        <dt><g:message code="hccr.property.familyAssistanceMemberFirstName.label" /></dt>
        <dd>${it.familyAssistanceMemberFirstName?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-aid-familyAssistanceMembers[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-aid-familyAssistanceMembers[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

  
    <fieldset class="">
    <legend><g:message code="hccr.property.homeIntervention.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.homeInterventionHomeIntervenant.label" /> *  <span><g:message code="hccr.property.homeInterventionHomeIntervenant.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isHomeIntervenant-trigger  validate-one-required boolean" title="" value="${it}" name="homeInterventionHomeIntervenant" ${it == rqt.homeInterventionHomeIntervenant ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="condition-isHomeIntervenant-filled"><g:message code="hccr.property.homeIntervenants.label" /> <span><g:message code="hccr.property.homeIntervenants.help" /></span></label>
    <div class="collection-fieldset condition-isHomeIntervenant-filled validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'homeIntervenants' ? editList?.index : ( rqt.homeIntervenants ? rqt.homeIntervenants.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add condition-isHomeIntervenant-filled">
    
        <label class="required"><g:message code="hccr.property.homeIntervenantKind.label" /> *  <span><g:message code="hccr.property.homeIntervenantKind.help" /></span></label>
            <select name="homeIntervenants[${listIndex}].homeIntervenantKind" class="required condition-isOtherHomeIntervant-trigger  validate-not-first" title="<g:message code="hccr.property.homeIntervenantKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Carer','HomeHelp','Other']}">
                <option value="fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType_${it}" ${it == editList?.homeIntervenants?.homeIntervenantKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.homeIntervenantKind" /></option>
              </g:each>
            </select>
            

    
        <label class="required condition-isOtherHomeIntervant-filled"><g:message code="hccr.property.homeIntervenantDetails.label" /> *  <span><g:message code="hccr.property.homeIntervenantDetails.help" /></span></label>
            <input type="text" name="homeIntervenants[${listIndex}].homeIntervenantDetails" value="${editList?.homeIntervenants?.homeIntervenantDetails?.toString()}" 
                    class="required condition-isOtherHomeIntervant-filled  " title="<g:message code="hccr.property.homeIntervenantDetails.validationError" />"  maxlength="60" />
            

    
        <g:if test="${editList?.name == 'homeIntervenants'}">
          <input type="submit" id="submit-collectionModify-aid-homeIntervenants" name="submit-collectionModify-aid-homeIntervenants[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-aid-homeIntervenants" name="submit-collectionAdd-aid-homeIntervenants[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.homeIntervenants}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="hccr.property.homeIntervenantKind.label" /></dt>
        
              <dd>
                <g:if test="${it.homeIntervenantKind}">
                  <g:capdematEnumToField var="${it.homeIntervenantKind}" i18nKeyPrefix="hccr.property.homeIntervenantKind" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="hccr.property.homeIntervenantDetails.label" /></dt>
        <dd>${it.homeIntervenantDetails?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-aid-homeIntervenants[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-aid-homeIntervenants[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

  
    <fieldset class="">
    <legend><g:message code="hccr.property.care.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.careCareServices.label" /> *  <span><g:message code="hccr.property.careCareServices.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isCareServices-trigger  validate-one-required boolean" title="" value="${it}" name="careCareServices" ${it == rqt.careCareServices ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="required condition-isCareServices-filled"><g:message code="hccr.property.careServices.label" /> <span><g:message code="hccr.property.careServices.help" /></span></label>
    <div class="collection-fieldset required condition-isCareServices-filled validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'careServices' ? editList?.index : ( rqt.careServices ? rqt.careServices.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required condition-isCareServices-filled">
    
        <label class="required"><g:message code="hccr.property.careServiceKind.label" /> *  <span><g:message code="hccr.property.careServiceKind.help" /></span></label>
            <input type="text" name="careServices[${listIndex}].careServiceKind" value="${editList?.careServices?.careServiceKind?.toString()}" 
                    class="required  validate-string" title="<g:message code="hccr.property.careServiceKind.validationError" />"   />
            

    
        <label class="required"><g:message code="hccr.property.careServiceCareServiceEmployer.label" /> *  <span><g:message code="hccr.property.careServiceCareServiceEmployer.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isCareServiceEmployer-trigger  validate-one-required boolean" title="" value="${it}" name="careServices[${listIndex}].careServiceCareServiceEmployer" ${it == editList?.careServices?.careServiceCareServiceEmployer ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
        <label class="required condition-isCareServiceEmployer-unfilled"><g:message code="hccr.property.careServiceProviderName.label" /> *  <span><g:message code="hccr.property.careServiceProviderName.help" /></span></label>
            <input type="text" name="careServices[${listIndex}].careServiceProviderName" value="${editList?.careServices?.careServiceProviderName?.toString()}" 
                    class="required condition-isCareServiceEmployer-unfilled  validate-lastName" title="<g:message code="hccr.property.careServiceProviderName.validationError" />"  maxlength="38" />
            

    
        <label class="condition-isCareServiceEmployer-unfilled"><g:message code="hccr.property.careServiceProviderAddress.label" />   <span><g:message code="hccr.property.careServiceProviderAddress.help" /></span></label>
            <div class="address-fieldset condition-isCareServiceEmployer-unfilled ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${editList?.careServices?.careServiceProviderAddress?.additionalDeliveryInformation}" maxlength="38" name="careServices[${listIndex}].careServiceProviderAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${editList?.careServices?.careServiceProviderAddress?.additionalGeographicalInformation}" maxlength="38" name="careServices[${listIndex}].careServiceProviderAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${editList?.careServices?.careServiceProviderAddress?.streetNumber}" size="5" maxlength="5" name="careServices[${listIndex}].careServiceProviderAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${editList?.careServices?.careServiceProviderAddress?.streetName}" maxlength="32" name="careServices[${listIndex}].careServiceProviderAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${editList?.careServices?.careServiceProviderAddress?.placeNameOrService}" maxlength="38" name="careServices[${listIndex}].careServiceProviderAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${editList?.careServices?.careServiceProviderAddress?.postalCode}" size="5" maxlength="5" name="careServices[${listIndex}].careServiceProviderAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${editList?.careServices?.careServiceProviderAddress?.city}" maxlength="32" name="careServices[${listIndex}].careServiceProviderAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${editList?.careServices?.careServiceProviderAddress?.countryName}" maxlength="38" name="careServices[${listIndex}].careServiceProviderAddress.countryName"/>
            </div>
            

    
        <g:if test="${editList?.name == 'careServices'}">
          <input type="submit" id="submit-collectionModify-aid-careServices" name="submit-collectionModify-aid-careServices[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-aid-careServices" name="submit-collectionAdd-aid-careServices[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.careServices}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="hccr.property.careServiceKind.label" /></dt>
        <dd>${it.careServiceKind?.toString()}</dd>
    
        <dt><g:message code="hccr.property.careServiceCareServiceEmployer.label" /></dt>
        <dd><g:message code="message.${it.careServiceCareServiceEmployer ? 'yes' : 'no'}" /></dd>
    
        <dt><g:message code="hccr.property.careServiceProviderName.label" /></dt>
        <dd>${it.careServiceProviderName?.toString()}</dd>
    
        <dt><g:message code="hccr.property.careServiceProviderAddress.label" /></dt>
        
              <g:if test="${it.careServiceProviderAddress}">
                <dd>
                  <p>${it.careServiceProviderAddress?.additionalDeliveryInformation}</p>
                  <p>${it.careServiceProviderAddress?.additionalGeographicalInformation}</p>
                  <p>${it.careServiceProviderAddress?.streetNumber} ${it.careServiceProviderAddress?.streetName}</p>
                  <p>${it.careServiceProviderAddress?.placeNameOrService}</p>
                  <p>${it.careServiceProviderAddress?.postalCode} ${it.careServiceProviderAddress?.city}</p>
                  <p>${it.careServiceProviderAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-aid-careServices[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-aid-careServices[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.facilities.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.facilitiesHousing.label" /> *  <span><g:message code="hccr.property.facilitiesHousing.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isHousing-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesHousing" ${it == rqt.facilitiesHousing ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isHousing-filled"><g:message code="hccr.property.facilitiesHousingDetails.label" /> *  <span><g:message code="hccr.property.facilitiesHousingDetails.help" /></span></label>
            <input type="text" name="facilitiesHousingDetails" value="${rqt.facilitiesHousingDetails?.toString()}" 
                    class="required condition-isHousing-filled  " title="<g:message code="hccr.property.facilitiesHousingDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hccr.property.facilitiesTechnicalAssistance.label" /> *  <span><g:message code="hccr.property.facilitiesTechnicalAssistance.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isTechnicalAssistance-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesTechnicalAssistance" ${it == rqt.facilitiesTechnicalAssistance ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isTechnicalAssistance-filled"><g:message code="hccr.property.facilitiesTechnicalAssistanceDetails.label" /> *  <span><g:message code="hccr.property.facilitiesTechnicalAssistanceDetails.help" /></span></label>
            <input type="text" name="facilitiesTechnicalAssistanceDetails" value="${rqt.facilitiesTechnicalAssistanceDetails?.toString()}" 
                    class="required condition-isTechnicalAssistance-filled  " title="<g:message code="hccr.property.facilitiesTechnicalAssistanceDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hccr.property.facilitiesCustomCar.label" /> *  <span><g:message code="hccr.property.facilitiesCustomCar.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isCustomCar-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesCustomCar" ${it == rqt.facilitiesCustomCar ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isCustomCar-filled"><g:message code="hccr.property.facilitiesCustomCarDetails.label" /> *  <span><g:message code="hccr.property.facilitiesCustomCarDetails.help" /></span></label>
            <input type="text" name="facilitiesCustomCarDetails" value="${rqt.facilitiesCustomCarDetails?.toString()}" 
                    class="required condition-isCustomCar-filled  " title="<g:message code="hccr.property.facilitiesCustomCarDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hccr.property.facilitiesAnimalAid.label" /> *  <span><g:message code="hccr.property.facilitiesAnimalAid.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isAnimalAid-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesAnimalAid" ${it == rqt.facilitiesAnimalAid ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isAnimalAid-filled"><g:message code="hccr.property.facilitiesAnimalAidDetails.label" /> *  <span><g:message code="hccr.property.facilitiesAnimalAidDetails.help" /></span></label>
            <input type="text" name="facilitiesAnimalAidDetails" value="${rqt.facilitiesAnimalAidDetails?.toString()}" 
                    class="required condition-isAnimalAid-filled  " title="<g:message code="hccr.property.facilitiesAnimalAidDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hccr.property.facilitiesSpecializedTransport.label" /> *  <span><g:message code="hccr.property.facilitiesSpecializedTransport.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSpecializedTransport-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesSpecializedTransport" ${it == rqt.facilitiesSpecializedTransport ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isSpecializedTransport-filled"><g:message code="hccr.property.facilitiesSpecializedTransportDetails.label" /> *  <span><g:message code="hccr.property.facilitiesSpecializedTransportDetails.help" /></span></label>
            <input type="text" name="facilitiesSpecializedTransportDetails" value="${rqt.facilitiesSpecializedTransportDetails?.toString()}" 
                    class="required condition-isSpecializedTransport-filled  " title="<g:message code="hccr.property.facilitiesSpecializedTransportDetails.validationError" />"  maxlength="60" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.professionalSupport.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.professionalSupportProfessionals.label" /> *  <span><g:message code="hccr.property.professionalSupportProfessionals.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isProfessionals-trigger  validate-one-required boolean" title="" value="${it}" name="professionalSupportProfessionals" ${it == rqt.professionalSupportProfessionals ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isProfessionals-filled"><g:message code="hccr.property.professionalSupportDealsWithSameProfessional.label" /> *  <span><g:message code="hccr.property.professionalSupportDealsWithSameProfessional.help" /></span></label>
            <ul class="yes-no required condition-isProfessionals-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isProfessionals-filled  validate-one-required boolean" title="" value="${it}" name="professionalSupportDealsWithSameProfessional" ${it == rqt.professionalSupportDealsWithSameProfessional ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="condition-isProfessionals-filled"><g:message code="hccr.property.professionals.label" /> <span><g:message code="hccr.property.professionals.help" /></span></label>
    <div class="collection-fieldset condition-isProfessionals-filled validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'professionals' ? editList?.index : ( rqt.professionals ? rqt.professionals.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add condition-isProfessionals-filled">
    
        <label class="required"><g:message code="hccr.property.professionalLastName.label" /> *  <span><g:message code="hccr.property.professionalLastName.help" /></span></label>
            <input type="text" name="professionals[${listIndex}].professionalLastName" value="${editList?.professionals?.professionalLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="hccr.property.professionalLastName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="hccr.property.professionalFirstName.label" /> *  <span><g:message code="hccr.property.professionalFirstName.help" /></span></label>
            <input type="text" name="professionals[${listIndex}].professionalFirstName" value="${editList?.professionals?.professionalFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="hccr.property.professionalFirstName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="hccr.property.professionalAddress.label" /> *  <span><g:message code="hccr.property.professionalAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${editList?.professionals?.professionalAddress?.additionalDeliveryInformation}" maxlength="38" name="professionals[${listIndex}].professionalAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${editList?.professionals?.professionalAddress?.additionalGeographicalInformation}" maxlength="38" name="professionals[${listIndex}].professionalAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${editList?.professionals?.professionalAddress?.streetNumber}" size="5" maxlength="5" name="professionals[${listIndex}].professionalAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${editList?.professionals?.professionalAddress?.streetName}" maxlength="32" name="professionals[${listIndex}].professionalAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${editList?.professionals?.professionalAddress?.placeNameOrService}" maxlength="38" name="professionals[${listIndex}].professionalAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${editList?.professionals?.professionalAddress?.postalCode}" size="5" maxlength="5" name="professionals[${listIndex}].professionalAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${editList?.professionals?.professionalAddress?.city}" maxlength="32" name="professionals[${listIndex}].professionalAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${editList?.professionals?.professionalAddress?.countryName}" maxlength="38" name="professionals[${listIndex}].professionalAddress.countryName"/>
            </div>
            

    
        <g:if test="${editList?.name == 'professionals'}">
          <input type="submit" id="submit-collectionModify-aid-professionals" name="submit-collectionModify-aid-professionals[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-aid-professionals" name="submit-collectionAdd-aid-professionals[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.professionals}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="hccr.property.professionalLastName.label" /></dt>
        <dd>${it.professionalLastName?.toString()}</dd>
    
        <dt><g:message code="hccr.property.professionalFirstName.label" /></dt>
        <dd>${it.professionalFirstName?.toString()}</dd>
    
        <dt><g:message code="hccr.property.professionalAddress.label" /></dt>
        
              <g:if test="${it.professionalAddress}">
                <dd>
                  <p>${it.professionalAddress?.additionalDeliveryInformation}</p>
                  <p>${it.professionalAddress?.additionalGeographicalInformation}</p>
                  <p>${it.professionalAddress?.streetNumber} ${it.professionalAddress?.streetName}</p>
                  <p>${it.professionalAddress?.placeNameOrService}</p>
                  <p>${it.professionalAddress?.postalCode} ${it.professionalAddress?.city}</p>
                  <p>${it.professionalAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-aid-professionals[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-aid-professionals[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.socialService.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.socialServiceSupport.label" /> *  <span><g:message code="hccr.property.socialServiceSupport.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSocialServiceSupport-trigger  validate-one-required boolean" title="" value="${it}" name="socialServiceSupport" ${it == rqt.socialServiceSupport ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isSocialServiceSupport-filled"><g:message code="hccr.property.socialServiceName.label" /> *  <span><g:message code="hccr.property.socialServiceName.help" /></span></label>
            <input type="text" name="socialServiceName" value="${rqt.socialServiceName?.toString()}" 
                    class="required condition-isSocialServiceSupport-filled  " title="<g:message code="hccr.property.socialServiceName.validationError" />"  maxlength="60" />
            

    
      <label class="required condition-isSocialServiceSupport-filled"><g:message code="hccr.property.socialServiceAddress.label" /> *  <span><g:message code="hccr.property.socialServiceAddress.help" /></span></label>
            <div class="address-fieldset required condition-isSocialServiceSupport-filled ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.socialServiceAddress?.additionalDeliveryInformation}" maxlength="38" name="socialServiceAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.socialServiceAddress?.additionalGeographicalInformation}" maxlength="38" name="socialServiceAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.socialServiceAddress?.streetNumber}" size="5" maxlength="5" name="socialServiceAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.socialServiceAddress?.streetName}" maxlength="32" name="socialServiceAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.socialServiceAddress?.placeNameOrService}" maxlength="38" name="socialServiceAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.socialServiceAddress?.postalCode}" size="5" maxlength="5" name="socialServiceAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.socialServiceAddress?.city}" maxlength="32" name="socialServiceAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.socialServiceAddress?.countryName}" maxlength="38" name="socialServiceAddress.countryName"/>
            </div>
            

    
    </fieldset>
  

