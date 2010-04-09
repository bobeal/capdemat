


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequester.label" /></legend>
    
      
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first " title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

    
      <label for="dhrRequesterBirthDate" class="required"><g:message code="dhr.property.dhrRequesterBirthDate.label" /> *  <span><g:message code="dhr.property.dhrRequesterBirthDate.help" /></span></label>
            <input type="text" id="dhrRequesterBirthDate" name="dhrRequesterBirthDate" value="${formatDate(formatName:'format.date',date:rqt.dhrRequesterBirthDate)}" 
                   class="required  validate-date" title="<g:message code="dhr.property.dhrRequesterBirthDate.validationError" />" />
            

    
      <label for="dhrRequesterBirthPlace" class="required"><g:message code="dhr.property.dhrRequesterBirthPlace.label" /> *  <span><g:message code="dhr.property.dhrRequesterBirthPlace.help" /></span></label>
            <input type="text" id="dhrRequesterBirthPlace" name="dhrRequesterBirthPlace" value="${rqt.dhrRequesterBirthPlace?.toString()}" 
                    class="required  validate-string" title="<g:message code="dhr.property.dhrRequesterBirthPlace.validationError" />"   />
            

    
      <label for="dhrRequesterNationality" class="required"><g:message code="dhr.property.dhrRequesterNationality.label" /> *  <span><g:message code="dhr.property.dhrRequesterNationality.help" /></span></label>
            <select id="dhrRequesterNationality" name="dhrRequesterNationality" class="required condition-isNonEuropean-trigger  validate-not-first" title="<g:message code="dhr.property.dhrRequesterNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
                <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == rqt.dhrRequesterNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrRequesterNationality" /></option>
              </g:each>
            </select>
            

    
      <label for="dhrRequesterFranceArrivalDate" class="required condition-isNonEuropean-filled"><g:message code="dhr.property.dhrRequesterFranceArrivalDate.label" /> *  <span><g:message code="dhr.property.dhrRequesterFranceArrivalDate.help" /></span></label>
            <input type="text" id="dhrRequesterFranceArrivalDate" name="dhrRequesterFranceArrivalDate" value="${formatDate(formatName:'format.date',date:rqt.dhrRequesterFranceArrivalDate)}" 
                   class="required condition-isNonEuropean-filled  validate-date" title="<g:message code="dhr.property.dhrRequesterFranceArrivalDate.validationError" />" />
            

    
      <label class="required condition-isNonEuropean-filled"><g:message code="dhr.property.dhrRequesterIsFrenchResident.label" /> *  <span><g:message code="dhr.property.dhrRequesterIsFrenchResident.help" /></span></label>
            <ul class="yes-no required condition-isNonEuropean-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="dhrRequesterIsFrenchResident_${it ? 'yes' : 'no'}" class="required condition-isNonEuropean-filled  validate-one-required boolean" title="" value="${it}" name="dhrRequesterIsFrenchResident" ${it == rqt.dhrRequesterIsFrenchResident ? 'checked="checked"': ''} />
                <label for="dhrRequesterIsFrenchResident_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequesterPensionPlan.label" /></legend>
    
      <label for="dhrPrincipalPensionPlan" class="required"><g:message code="dhr.property.dhrPrincipalPensionPlan.label" /> *  <span><g:message code="dhr.property.dhrPrincipalPensionPlan.help" /></span></label>
            <select id="dhrPrincipalPensionPlan" name="dhrPrincipalPensionPlan" class="required condition-isOtherPensionPlan-trigger  validate-not-first" title="<g:message code="dhr.property.dhrPrincipalPensionPlan.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType_${it}" ${it == rqt.dhrPrincipalPensionPlan?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrPrincipalPensionPlan" /></option>
              </g:each>
            </select>
            

    
      <label for="dhrPensionPlanDetail" class="required condition-isOtherPensionPlan-filled"><g:message code="dhr.property.dhrPensionPlanDetail.label" /> *  <span><g:message code="dhr.property.dhrPensionPlanDetail.help" /></span></label>
            <input type="text" id="dhrPensionPlanDetail" name="dhrPensionPlanDetail" value="${rqt.dhrPensionPlanDetail?.toString()}" 
                    class="required condition-isOtherPensionPlan-filled  validate-string" title="<g:message code="dhr.property.dhrPensionPlanDetail.validationError" />"   />
            

    
      <label for="dhrComplementaryPensionPlan" class="required"><g:message code="dhr.property.dhrComplementaryPensionPlan.label" /> *  <span><g:message code="dhr.property.dhrComplementaryPensionPlan.help" /></span></label>
            <input type="text" id="dhrComplementaryPensionPlan" name="dhrComplementaryPensionPlan" value="${rqt.dhrComplementaryPensionPlan?.toString()}" 
                    class="required  validate-string" title="<g:message code="dhr.property.dhrComplementaryPensionPlan.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequesterGuardian.label" /></legend>
    
      <label class="required"><g:message code="dhr.property.dhrRequesterHaveGuardian.label" /> *  <span><g:message code="dhr.property.dhrRequesterHaveGuardian.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="dhrRequesterHaveGuardian_${it ? 'yes' : 'no'}" class="required condition-haveGuardian-trigger  validate-one-required boolean" title="" value="${it}" name="dhrRequesterHaveGuardian" ${it == rqt.dhrRequesterHaveGuardian ? 'checked="checked"': ''} />
                <label for="dhrRequesterHaveGuardian_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="dhrGuardianMeasure" class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianMeasure.label" /> *  <span><g:message code="dhr.property.dhrGuardianMeasure.help" /></span></label>
            <select id="dhrGuardianMeasure" name="dhrGuardianMeasure" class="required condition-haveGuardian-filled  validate-not-first" title="<g:message code="dhr.property.dhrGuardianMeasure.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['safeguardingJustice','guardianship','curatorship']}">
                <option value="fr.cg95.cvq.business.request.social.DhrGuardianMeasureType_${it}" ${it == rqt.dhrGuardianMeasure?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrGuardianMeasure" /></option>
              </g:each>
            </select>
            

    
      <label for="dhrGuardianName" class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianName.label" /> *  <span><g:message code="dhr.property.dhrGuardianName.help" /></span></label>
            <input type="text" id="dhrGuardianName" name="dhrGuardianName" value="${rqt.dhrGuardianName?.toString()}" 
                    class="required condition-haveGuardian-filled  validate-lastName" title="<g:message code="dhr.property.dhrGuardianName.validationError" />"  maxlength="38" />
            

    
      <label class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianAddress.label" /> *  <span><g:message code="dhr.property.dhrGuardianAddress.help" /></span></label>
            <div class="address-fieldset required condition-haveGuardian-filled ">
            <label for="dhrGuardianAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.dhrGuardianAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrGuardianAddress.additionalDeliveryInformation" name="dhrGuardianAddress.additionalDeliveryInformation" />  
            <label for="dhrGuardianAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.dhrGuardianAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrGuardianAddress.additionalGeographicalInformation" name="dhrGuardianAddress.additionalGeographicalInformation" />
            <label for="dhrGuardianAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrGuardianAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${rqt.dhrGuardianAddress?.streetNumber}" size="5" maxlength="5" id="dhrGuardianAddress.streetNumber" name="dhrGuardianAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${rqt.dhrGuardianAddress?.streetName}" maxlength="32" id="dhrGuardianAddress.streetName" name="dhrGuardianAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrGuardianAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.dhrGuardianAddress?.placeNameOrService}" maxlength="38" id="dhrGuardianAddress.placeNameOrService" name="dhrGuardianAddress.placeNameOrService" />
            <label for="dhrGuardianAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrGuardianAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${rqt.dhrGuardianAddress?.postalCode}" size="5" maxlength="5" id="dhrGuardianAddress.postalCode" name="dhrGuardianAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${rqt.dhrGuardianAddress?.city}" maxlength="32" id="dhrGuardianAddress.city" name="dhrGuardianAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrGuardianAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${rqt.dhrGuardianAddress?.countryName}" maxlength="38" id="dhrGuardianAddress.countryName" name="dhrGuardianAddress.countryName" />
            </div>
            

    
    </fieldset>
  

