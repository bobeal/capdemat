




  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequester.label" /></legend> 
      
    <label class="required"><g:message code="request.property.subjectName" /> *</label>
    <select name="subjectId" class="required validate-not-first" title="<g:message code="request.subject.validationError" /> ">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${subjects}">
        <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
      </g:each>
    </select>
      
    
      <label class="required"><g:message code="dhr.property.dhrRequesterBirthDate.label" /> * <span><g:message code="dhr.property.dhrRequesterBirthDate.help" /></span></label>
      
            <input type="text" name="dhrRequesterBirthDate" value="${formatDate(formatName:'format.date',date:rqt.dhrRequesterBirthDate)}" 
                   class="required validate-date" title="<g:message code="dhr.property.dhrRequesterBirthDate.validationError" />" />
            
    
      <label class="required"><g:message code="dhr.property.dhrRequesterBirthPlace.label" /> * <span><g:message code="dhr.property.dhrRequesterBirthPlace.help" /></span></label>
      
            <input type="text" name="dhrRequesterBirthPlace" value="${rqt.dhrRequesterBirthPlace}" 
                    class="required validate-string" title="<g:message code="dhr.property.dhrRequesterBirthPlace.validationError" />" />
            
    
      <label class="required"><g:message code="dhr.property.dhrRequesterNationality.label" /> * <span><g:message code="dhr.property.dhrRequesterNationality.help" /></span></label>
      
            <select name="dhrRequesterNationality" class="required condition-isNonEuropean-trigger validate-not-first" title="<g:message code="dhr.property.dhrRequesterNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
                <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == rqt.dhrRequesterNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrRequesterNationality" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isNonEuropean-filled"><g:message code="dhr.property.dhrRequesterFranceArrivalDate.label" /> * <span><g:message code="dhr.property.dhrRequesterFranceArrivalDate.help" /></span></label>
      
            <input type="text" name="dhrRequesterFranceArrivalDate" value="${formatDate(formatName:'format.date',date:rqt.dhrRequesterFranceArrivalDate)}" 
                   class="required condition-isNonEuropean-filled validate-date" title="<g:message code="dhr.property.dhrRequesterFranceArrivalDate.validationError" />" />
            
    
      <label class="required condition-isNonEuropean-filled"><g:message code="dhr.property.dhrRequesterIsFrenchResident.label" /> * <span><g:message code="dhr.property.dhrRequesterIsFrenchResident.help" /></span></label>
      
            <ul class="required condition-isNonEuropean-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isNonEuropean-filled validate-boolean" title="" value="${it}" name="dhrRequesterIsFrenchResident" ${it == rqt.dhrRequesterIsFrenchResident ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequesterPensionPlan.label" /></legend> 
      
    
      <label class="required"><g:message code="dhr.property.dhrPrincipalPensionPlan.label" /> * <span><g:message code="dhr.property.dhrPrincipalPensionPlan.help" /></span></label>
      
            <select name="dhrPrincipalPensionPlan" class="required condition-isOtherPensionPlan-trigger validate-not-first" title="<g:message code="dhr.property.dhrPrincipalPensionPlan.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType_${it}" ${it == rqt.dhrPrincipalPensionPlan?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrPrincipalPensionPlan" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isOtherPensionPlan-filled"><g:message code="dhr.property.dhrPensionPlanDetail.label" /> * <span><g:message code="dhr.property.dhrPensionPlanDetail.help" /></span></label>
      
            <input type="text" name="dhrPensionPlanDetail" value="${rqt.dhrPensionPlanDetail}" 
                    class="required condition-isOtherPensionPlan-filled validate-string" title="<g:message code="dhr.property.dhrPensionPlanDetail.validationError" />" />
            
    
      <label class="required"><g:message code="dhr.property.dhrComplementaryPensionPlan.label" /> * <span><g:message code="dhr.property.dhrComplementaryPensionPlan.help" /></span></label>
      
            <input type="text" name="dhrComplementaryPensionPlan" value="${rqt.dhrComplementaryPensionPlan}" 
                    class="required validate-string" title="<g:message code="dhr.property.dhrComplementaryPensionPlan.validationError" />" />
            
    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequesterGuardian.label" /></legend> 
      
    
      <label class="required"><g:message code="dhr.property.dhrRequesterHaveGuardian.label" /> * <span><g:message code="dhr.property.dhrRequesterHaveGuardian.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-haveGuardian-trigger validate-boolean" title="" value="${it}" name="dhrRequesterHaveGuardian" ${it == rqt.dhrRequesterHaveGuardian ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianMeasure.label" /> * <span><g:message code="dhr.property.dhrGuardianMeasure.help" /></span></label>
      
            <select name="dhrGuardianMeasure" class="required condition-haveGuardian-filled validate-not-first" title="<g:message code="dhr.property.dhrGuardianMeasure.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['safeguardingJustice','guardianship','curatorship']}">
                <option value="fr.cg95.cvq.business.request.social.DhrGuardianMeasureType_${it}" ${it == rqt.dhrGuardianMeasure?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrGuardianMeasure" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianName.label" /> * <span><g:message code="dhr.property.dhrGuardianName.help" /></span></label>
      
            <input type="text" name="dhrGuardianName" value="${rqt.dhrGuardianName}" 
                    class="required condition-haveGuardian-filled validate-lastName" title="<g:message code="dhr.property.dhrGuardianName.validationError" />" />
            
    
      <label class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianAddress.label" /> * <span><g:message code="dhr.property.dhrGuardianAddress.help" /></span></label>
      
            <div class="address-fieldset required condition-haveGuardian-filled">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.dhrGuardianAddress?.additionalDeliveryInformation}" maxlength="38" name="dhrGuardianAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.dhrGuardianAddress?.additionalGeographicalInformation}" maxlength="38" name="dhrGuardianAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.dhrGuardianAddress?.streetNumber}" maxlength="5" name="dhrGuardianAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.dhrGuardianAddress?.streetName}" maxlength="32" name="dhrGuardianAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.dhrGuardianAddress?.placeNameOrService}" maxlength="38" name="dhrGuardianAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.dhrGuardianAddress?.postalCode}" maxlength="5" name="dhrGuardianAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.dhrGuardianAddress?.city}" maxlength="32" name="dhrGuardianAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.dhrGuardianAddress?.countryName}" maxlength="38" name="dhrGuardianAddress.countryName"/>
            </div>
            
    
    </fieldset>
  

