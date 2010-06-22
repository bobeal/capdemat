


  
    <fieldset class="">
    <legend><g:message code="hcar.property.familyAssistance.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.isFamilyAssistance.label" /> *  <span><g:message code="hcar.property.isFamilyAssistance.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('isFamilyAssistance') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isFamilyAssistance_${it ? 'yes' : 'no'}" class="required condition-isFamilyAssistance-trigger  validate-one-required boolean" title="" value="${it}" name="isFamilyAssistance" ${it == rqt.isFamilyAssistance ? 'checked="checked"': ''} />
                <label for="isFamilyAssistance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection required condition-isFamilyAssistance-filled summary-box">
      <h4 class="required condition-isFamilyAssistance-filled"><g:message code="hcar.property.familyAssistanceMembers.label" /> 
        <span><g:message code="hcar.property.familyAssistanceMembers.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'familyAssistanceMembers', 'collectionIndex':(rqt.familyAssistanceMembers ? rqt.familyAssistanceMembers.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.familyAssistanceMembers}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="hcar.property.familyAssistanceMembers.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'familyAssistanceMembers', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'familyAssistanceMembers', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="hcar.property.familyAssistanceMemberRelationship.label" /></dt>
        <dd class="${rqt.stepStates['aid'].invalidFields.contains('familyAssistanceMembers[' + index + '].familyAssistanceMemberRelationship') ? 'validation-failed' : ''}">${it.familyAssistanceMemberRelationship?.toString()}</dd>
    
        <dt><g:message code="hcar.property.familyAssistanceMemberLastName.label" /></dt>
        <dd class="${rqt.stepStates['aid'].invalidFields.contains('familyAssistanceMembers[' + index + '].familyAssistanceMemberLastName') ? 'validation-failed' : ''}">${it.familyAssistanceMemberLastName?.toString()}</dd>
    
        <dt><g:message code="hcar.property.familyAssistanceMemberFirstName.label" /></dt>
        <dd class="${rqt.stepStates['aid'].invalidFields.contains('familyAssistanceMembers[' + index + '].familyAssistanceMemberFirstName') ? 'validation-failed' : ''}">${it.familyAssistanceMemberFirstName?.toString()}</dd>
    
        </dl>
      </div>
    </g:each>
    </div>
  

  
    <fieldset class="">
    <legend><g:message code="hcar.property.homeIntervention.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.homeInterventionHomeIntervenant.label" /> *  <span><g:message code="hcar.property.homeInterventionHomeIntervenant.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('homeInterventionHomeIntervenant') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="homeInterventionHomeIntervenant_${it ? 'yes' : 'no'}" class="required condition-isHomeIntervenant-trigger  validate-one-required boolean" title="" value="${it}" name="homeInterventionHomeIntervenant" ${it == rqt.homeInterventionHomeIntervenant ? 'checked="checked"': ''} />
                <label for="homeInterventionHomeIntervenant_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection condition-isHomeIntervenant-filled summary-box">
      <h4 class="condition-isHomeIntervenant-filled"><g:message code="hcar.property.homeIntervenants.label" /> 
        <span><g:message code="hcar.property.homeIntervenants.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'homeIntervenants', 'collectionIndex':(rqt.homeIntervenants ? rqt.homeIntervenants.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.homeIntervenants}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="hcar.property.homeIntervenants.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'homeIntervenants', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'homeIntervenants', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="hcar.property.homeIntervenantKind.label" /></dt>
        
              <dd class="${rqt.stepStates['aid'].invalidFields.contains('homeIntervenants[' + index + '].homeIntervenantKind') ? 'validation-failed' : ''}">
                <g:if test="${it.homeIntervenantKind}">
                  <g:capdematEnumToField var="${it.homeIntervenantKind}" i18nKeyPrefix="hcar.property.homeIntervenantKind" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="hcar.property.homeIntervenantDetails.label" /></dt>
        <dd class="${rqt.stepStates['aid'].invalidFields.contains('homeIntervenants[' + index + '].homeIntervenantDetails') ? 'validation-failed' : ''}">${it.homeIntervenantDetails?.toString()}</dd>
    
        </dl>
      </div>
    </g:each>
    </div>
  

  
    <fieldset class="">
    <legend><g:message code="hcar.property.care.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.careCareServices.label" /> *  <span><g:message code="hcar.property.careCareServices.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('careCareServices') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="careCareServices_${it ? 'yes' : 'no'}" class="required condition-isCareServices-trigger  validate-one-required boolean" title="" value="${it}" name="careCareServices" ${it == rqt.careCareServices ? 'checked="checked"': ''} />
                <label for="careCareServices_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection required condition-isCareServices-filled summary-box">
      <h4 class="required condition-isCareServices-filled"><g:message code="hcar.property.careServices.label" /> 
        <span><g:message code="hcar.property.careServices.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'careServices', 'collectionIndex':(rqt.careServices ? rqt.careServices.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.careServices}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="hcar.property.careServices.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'careServices', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'careServices', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="hcar.property.careServiceKind.label" /></dt>
        <dd class="${rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceKind') ? 'validation-failed' : ''}">${it.careServiceKind?.toString()}</dd>
    
        <dt><g:message code="hcar.property.careServiceCareServiceEmployer.label" /></dt>
        <dd class="${rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceCareServiceEmployer') ? 'validation-failed' : ''}"><g:message code="message.${it.careServiceCareServiceEmployer ? 'yes' : 'no'}" /></dd>
    
        <dt><g:message code="hcar.property.careServiceProviderName.label" /></dt>
        <dd class="${rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceProviderName') ? 'validation-failed' : ''}">${it.careServiceProviderName?.toString()}</dd>
    
        <dt><g:message code="hcar.property.careServiceProviderAddress.label" /></dt>
        
              <g:if test="${it.careServiceProviderAddress}">
                <dd class="${rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceProviderAddress') ? 'validation-failed' : ''}">
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceProviderAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}">${it.careServiceProviderAddress?.additionalDeliveryInformation}</p>
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceProviderAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}">${it.careServiceProviderAddress?.additionalGeographicalInformation}</p>
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceProviderAddress.streetNumber') || rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceProviderAddress.streetName') ? 'validation-failed' : ''}">${it.careServiceProviderAddress?.streetNumber} ${it.careServiceProviderAddress?.streetName}</p>
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceProviderAddress.placeNameOrService') ? 'validation-failed' : ''}">${it.careServiceProviderAddress?.placeNameOrService}</p>
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceProviderAddress.postalCode') || rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceProviderAddress.city') ? 'validation-failed' : ''}">${it.careServiceProviderAddress?.postalCode} ${it.careServiceProviderAddress?.city}</p>
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('careServices[' + index + '].careServiceProviderAddress.countryName') ? 'validation-failed' : ''}">${it.careServiceProviderAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        </dl>
      </div>
    </g:each>
    </div>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.facilities.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.facilitiesHousing.label" /> *  <span><g:message code="hcar.property.facilitiesHousing.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('facilitiesHousing') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="facilitiesHousing_${it ? 'yes' : 'no'}" class="required condition-isHousing-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesHousing" ${it == rqt.facilitiesHousing ? 'checked="checked"': ''} />
                <label for="facilitiesHousing_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="facilitiesHousingDetails" class="required condition-isHousing-filled"><g:message code="hcar.property.facilitiesHousingDetails.label" /> *  <span><g:message code="hcar.property.facilitiesHousingDetails.help" /></span></label>
            <input type="text" id="facilitiesHousingDetails" name="facilitiesHousingDetails" value="${rqt.facilitiesHousingDetails?.toString()}" 
                    class="required condition-isHousing-filled   ${rqt.stepStates['aid'].invalidFields.contains('facilitiesHousingDetails') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.facilitiesHousingDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.facilitiesTechnicalAssistance.label" /> *  <span><g:message code="hcar.property.facilitiesTechnicalAssistance.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('facilitiesTechnicalAssistance') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="facilitiesTechnicalAssistance_${it ? 'yes' : 'no'}" class="required condition-isTechnicalAssistance-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesTechnicalAssistance" ${it == rqt.facilitiesTechnicalAssistance ? 'checked="checked"': ''} />
                <label for="facilitiesTechnicalAssistance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="facilitiesTechnicalAssistanceDetails" class="required condition-isTechnicalAssistance-filled"><g:message code="hcar.property.facilitiesTechnicalAssistanceDetails.label" /> *  <span><g:message code="hcar.property.facilitiesTechnicalAssistanceDetails.help" /></span></label>
            <input type="text" id="facilitiesTechnicalAssistanceDetails" name="facilitiesTechnicalAssistanceDetails" value="${rqt.facilitiesTechnicalAssistanceDetails?.toString()}" 
                    class="required condition-isTechnicalAssistance-filled   ${rqt.stepStates['aid'].invalidFields.contains('facilitiesTechnicalAssistanceDetails') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.facilitiesTechnicalAssistanceDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.facilitiesCustomCar.label" /> *  <span><g:message code="hcar.property.facilitiesCustomCar.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('facilitiesCustomCar') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="facilitiesCustomCar_${it ? 'yes' : 'no'}" class="required condition-isCustomCar-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesCustomCar" ${it == rqt.facilitiesCustomCar ? 'checked="checked"': ''} />
                <label for="facilitiesCustomCar_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="facilitiesCustomCarDetails" class="required condition-isCustomCar-filled"><g:message code="hcar.property.facilitiesCustomCarDetails.label" /> *  <span><g:message code="hcar.property.facilitiesCustomCarDetails.help" /></span></label>
            <input type="text" id="facilitiesCustomCarDetails" name="facilitiesCustomCarDetails" value="${rqt.facilitiesCustomCarDetails?.toString()}" 
                    class="required condition-isCustomCar-filled   ${rqt.stepStates['aid'].invalidFields.contains('facilitiesCustomCarDetails') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.facilitiesCustomCarDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.facilitiesAnimalAid.label" /> *  <span><g:message code="hcar.property.facilitiesAnimalAid.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('facilitiesAnimalAid') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="facilitiesAnimalAid_${it ? 'yes' : 'no'}" class="required condition-isAnimalAid-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesAnimalAid" ${it == rqt.facilitiesAnimalAid ? 'checked="checked"': ''} />
                <label for="facilitiesAnimalAid_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="facilitiesAnimalAidDetails" class="required condition-isAnimalAid-filled"><g:message code="hcar.property.facilitiesAnimalAidDetails.label" /> *  <span><g:message code="hcar.property.facilitiesAnimalAidDetails.help" /></span></label>
            <input type="text" id="facilitiesAnimalAidDetails" name="facilitiesAnimalAidDetails" value="${rqt.facilitiesAnimalAidDetails?.toString()}" 
                    class="required condition-isAnimalAid-filled   ${rqt.stepStates['aid'].invalidFields.contains('facilitiesAnimalAidDetails') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.facilitiesAnimalAidDetails.validationError" />"  maxlength="60" />
            

    
      <label class="required"><g:message code="hcar.property.facilitiesSpecializedTransport.label" /> *  <span><g:message code="hcar.property.facilitiesSpecializedTransport.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('facilitiesSpecializedTransport') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="facilitiesSpecializedTransport_${it ? 'yes' : 'no'}" class="required condition-isSpecializedTransport-trigger  validate-one-required boolean" title="" value="${it}" name="facilitiesSpecializedTransport" ${it == rqt.facilitiesSpecializedTransport ? 'checked="checked"': ''} />
                <label for="facilitiesSpecializedTransport_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="facilitiesSpecializedTransportDetails" class="required condition-isSpecializedTransport-filled"><g:message code="hcar.property.facilitiesSpecializedTransportDetails.label" /> *  <span><g:message code="hcar.property.facilitiesSpecializedTransportDetails.help" /></span></label>
            <input type="text" id="facilitiesSpecializedTransportDetails" name="facilitiesSpecializedTransportDetails" value="${rqt.facilitiesSpecializedTransportDetails?.toString()}" 
                    class="required condition-isSpecializedTransport-filled   ${rqt.stepStates['aid'].invalidFields.contains('facilitiesSpecializedTransportDetails') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.facilitiesSpecializedTransportDetails.validationError" />"  maxlength="60" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.professionalSupport.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.professionalSupportProfessionals.label" /> *  <span><g:message code="hcar.property.professionalSupportProfessionals.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportProfessionals') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalSupportProfessionals_${it ? 'yes' : 'no'}" class="required condition-isProfessionals-trigger  validate-one-required boolean" title="" value="${it}" name="professionalSupportProfessionals" ${it == rqt.professionalSupportProfessionals ? 'checked="checked"': ''} />
                <label for="professionalSupportProfessionals_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isProfessionals-filled"><g:message code="hcar.property.professionalSupportDealsWithSameProfessional.label" /> *  <span><g:message code="hcar.property.professionalSupportDealsWithSameProfessional.help" /></span></label>
            <ul class="yes-no required condition-isProfessionals-filled ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportDealsWithSameProfessional') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalSupportDealsWithSameProfessional_${it ? 'yes' : 'no'}" class="required condition-isProfessionals-filled  validate-one-required boolean" title="" value="${it}" name="professionalSupportDealsWithSameProfessional" ${it == rqt.professionalSupportDealsWithSameProfessional ? 'checked="checked"': ''} />
                <label for="professionalSupportDealsWithSameProfessional_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection condition-isProfessionals-filled summary-box">
      <h4 class="condition-isProfessionals-filled"><g:message code="hcar.property.professionals.label" /> 
        <span><g:message code="hcar.property.professionals.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'professionals', 'collectionIndex':(rqt.professionals ? rqt.professionals.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.professionals}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="hcar.property.professionals.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'professionals', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'aid', 'currentCollection':'professionals', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="hcar.property.professionalLastName.label" /></dt>
        <dd class="${rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalLastName') ? 'validation-failed' : ''}">${it.professionalLastName?.toString()}</dd>
    
        <dt><g:message code="hcar.property.professionalFirstName.label" /></dt>
        <dd class="${rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalFirstName') ? 'validation-failed' : ''}">${it.professionalFirstName?.toString()}</dd>
    
        <dt><g:message code="hcar.property.professionalAddress.label" /></dt>
        
              <g:if test="${it.professionalAddress}">
                <dd class="${rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalAddress') ? 'validation-failed' : ''}">
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}">${it.professionalAddress?.additionalDeliveryInformation}</p>
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}">${it.professionalAddress?.additionalGeographicalInformation}</p>
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalAddress.streetNumber') || rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalAddress.streetName') ? 'validation-failed' : ''}">${it.professionalAddress?.streetNumber} ${it.professionalAddress?.streetName}</p>
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalAddress.placeNameOrService') ? 'validation-failed' : ''}">${it.professionalAddress?.placeNameOrService}</p>
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalAddress.postalCode') || rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalAddress.city') ? 'validation-failed' : ''}">${it.professionalAddress?.postalCode} ${it.professionalAddress?.city}</p>
                  <p class="${rqt.stepStates['aid'].invalidFields.contains('professionals[' + index + '].professionalAddress.countryName') ? 'validation-failed' : ''}">${it.professionalAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        </dl>
      </div>
    </g:each>
    </div>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.socialService.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.professionalSupportSocialServiceSupport.label" /> *  <span><g:message code="hcar.property.professionalSupportSocialServiceSupport.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceSupport') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalSupportSocialServiceSupport_${it ? 'yes' : 'no'}" class="required condition-isSocialServiceSupport-trigger  validate-one-required boolean" title="" value="${it}" name="professionalSupportSocialServiceSupport" ${it == rqt.professionalSupportSocialServiceSupport ? 'checked="checked"': ''} />
                <label for="professionalSupportSocialServiceSupport_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="professionalSupportSocialServiceName" class="required condition-isSocialServiceSupport-filled"><g:message code="hcar.property.professionalSupportSocialServiceName.label" /> *  <span><g:message code="hcar.property.professionalSupportSocialServiceName.help" /></span></label>
            <input type="text" id="professionalSupportSocialServiceName" name="professionalSupportSocialServiceName" value="${rqt.professionalSupportSocialServiceName?.toString()}" 
                    class="required condition-isSocialServiceSupport-filled   ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.professionalSupportSocialServiceName.validationError" />"  maxlength="60" />
            

    
      <label class="required condition-isSocialServiceSupport-filled"><g:message code="hcar.property.professionalSupportSocialServiceAddress.label" /> *  <span><g:message code="hcar.property.professionalSupportSocialServiceAddress.help" /></span></label>
            <div id="professionalSupportSocialServiceAddress" class="address required condition-isSocialServiceSupport-filled  ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceAddress') ? 'validation-failed' : ''}">
            <label for="professionalSupportSocialServiceAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.professionalSupportSocialServiceAddress?.additionalDeliveryInformation}" maxlength="38" id="professionalSupportSocialServiceAddress.additionalDeliveryInformation" name="professionalSupportSocialServiceAddress.additionalDeliveryInformation" />  
            <label for="professionalSupportSocialServiceAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.professionalSupportSocialServiceAddress?.additionalGeographicalInformation}" maxlength="38" id="professionalSupportSocialServiceAddress.additionalGeographicalInformation" name="professionalSupportSocialServiceAddress.additionalGeographicalInformation" />
            <label for="professionalSupportSocialServiceAddress_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="professionalSupportSocialServiceAddress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.professionalSupportSocialServiceAddress?.streetNumber}" size="5" maxlength="5" id="professionalSupportSocialServiceAddress_streetNumber" name="professionalSupportSocialServiceAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.professionalSupportSocialServiceAddress?.streetName}" maxlength="32" id="professionalSupportSocialServiceAddress_streetName" name="professionalSupportSocialServiceAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.professionalSupportSocialServiceAddress?.streetMatriculation}" id="professionalSupportSocialServiceAddress_streetMatriculation" name="professionalSupportSocialServiceAddress.streetMatriculation" />
            <input type="hidden" value="${rqt.professionalSupportSocialServiceAddress?.streetRivoliCode}" id="professionalSupportSocialServiceAddress_streetRivoliCode" name="professionalSupportSocialServiceAddress.streetRivoliCode" />
            <label for="professionalSupportSocialServiceAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.professionalSupportSocialServiceAddress?.placeNameOrService}" maxlength="38" id="professionalSupportSocialServiceAddress.placeNameOrService" name="professionalSupportSocialServiceAddress.placeNameOrService" />
            <label for="professionalSupportSocialServiceAddress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="professionalSupportSocialServiceAddress_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.professionalSupportSocialServiceAddress?.postalCode}" size="5" maxlength="5" id="professionalSupportSocialServiceAddress_postalCode" name="professionalSupportSocialServiceAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceAddress.city') ? 'validation-failed' : ''}" value="${rqt.professionalSupportSocialServiceAddress?.city}" maxlength="32" id="professionalSupportSocialServiceAddress_city" name="professionalSupportSocialServiceAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.professionalSupportSocialServiceAddress?.cityInseeCode}" id="professionalSupportSocialServiceAddress_cityInseeCode" name="professionalSupportSocialServiceAddress.cityInseeCode" />
            <label for="professionalSupportSocialServiceAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['aid'].invalidFields.contains('professionalSupportSocialServiceAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.professionalSupportSocialServiceAddress?.countryName}" maxlength="38" id="professionalSupportSocialServiceAddress.countryName" name="professionalSupportSocialServiceAddress.countryName" />
            </div>
            

    
    </fieldset>
  

