


  
    <fieldset class="">
    <legend><g:message code="dhr.property.dhrRequester.label" /></legend> 
      
    <label><g:message code="request.property.subjectName" /></label>
    <select name="subjectId" class="required validate-not-first" title="request.subject.validationError">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${subjects}">
        <option value="${it.key}" ${it.key == dhr.subjectId ? 'selected="selected"': ''}>${it.value}</option>
      </g:each>
    </select>
      
    
      <label class=""><g:message code="dhr.property.dhrRequesterBirthDate.label" /> <span><g:message code="dhr.property.dhrRequesterBirthDate.help" /></span></label>
      
        <input name="dhrRequesterBirthDate" value="${formatDate(formatName:'format.date',date:dhr.dhrRequesterBirthDate)}" class=" required  validate-date-au" title="<g:message code="dhr.property.dhrRequesterBirthDate.validationError" />">
      
    
      <label class=""><g:message code="dhr.property.dhrRequesterBirthPlace.label" /> <span><g:message code="dhr.property.dhrRequesterBirthPlace.help" /></span></label>
      
        <input name="dhrRequesterBirthPlace" value="${dhr.dhrRequesterBirthPlace}" class=" required  validate-string" title="<g:message code="dhr.property.dhrRequesterBirthPlace.validationError" />">
      
    
      <label class="isNonEuropean-trigger "><g:message code="dhr.property.dhrRequesterNationality.label" /> <span><g:message code="dhr.property.dhrRequesterNationality.help" /></span></label>
      
        
          <select name="dhrRequesterNationality" class="isNonEuropean-trigger  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
              <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == dhr.dhrRequesterNationality?.toString() ? 'selected="selected"': ''}><g:message code="dhr.property.dhrRequesterNationality.${it}" /></option>
            </g:each>
          </select>
          
      
    
      <label class="isNonEuropean-filled "><g:message code="dhr.property.dhrRequesterFranceArrivalDate.label" /> <span><g:message code="dhr.property.dhrRequesterFranceArrivalDate.help" /></span></label>
      
        <input name="dhrRequesterFranceArrivalDate" value="${formatDate(formatName:'format.date',date:dhr.dhrRequesterFranceArrivalDate)}" class="isNonEuropean-filled    validate-date-au" title="<g:message code="dhr.property.dhrRequesterFranceArrivalDate.validationError" />">
      
    
      <label class="isNonEuropean-filled "><g:message code="dhr.property.dhrRequesterIsFrenchResident.label" /> <span><g:message code="dhr.property.dhrRequesterIsFrenchResident.help" /></span></label>
      
        
          <ul class="isNonEuropean-filled ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="isNonEuropean-filled   validate-one-required" title="" value="${it}" name="dhrRequesterIsFrenchResident" ${it == dhr.dhrRequesterIsFrenchResident ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
      
    
    </fieldset>
  

  
    <fieldset class="">
    <legend><g:message code="dhr.property.dhrRequesterPensionPlan.label" /></legend> 
      
    
      <label class="isOtherPensionPlan-trigger "><g:message code="dhr.property.dhrPrincipalPensionPlan.label" /> <span><g:message code="dhr.property.dhrPrincipalPensionPlan.help" /></span></label>
      
        
          <select name="dhrPrincipalPensionPlan" class="isOtherPensionPlan-trigger  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
              <option value="fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType_${it}" ${it == dhr.dhrPrincipalPensionPlan?.toString() ? 'selected="selected"': ''}><g:message code="dhr.property.dhrPrincipalPensionPlan.${it}" /></option>
            </g:each>
          </select>
          
      
    
      <label class="isOtherPensionPlan-filled "><g:message code="dhr.property.dhrPensionPlanDetail.label" /> <span><g:message code="dhr.property.dhrPensionPlanDetail.help" /></span></label>
      
        <input name="dhrPensionPlanDetail" value="${dhr.dhrPensionPlanDetail}" class="isOtherPensionPlan-filled    validate-string" title="<g:message code="dhr.property.dhrPensionPlanDetail.validationError" />">
      
    
      <label class=""><g:message code="dhr.property.dhrComplementaryPensionPlan.label" /> <span><g:message code="dhr.property.dhrComplementaryPensionPlan.help" /></span></label>
      
        <input name="dhrComplementaryPensionPlan" value="${dhr.dhrComplementaryPensionPlan}" class=" required  validate-string" title="<g:message code="dhr.property.dhrComplementaryPensionPlan.validationError" />">
      
    
    </fieldset>
  

  
    <fieldset class="">
    <legend><g:message code="dhr.property.dhrRequesterGuardian.label" /></legend> 
      
    
      <label class="haveGuardian-trigger "><g:message code="dhr.property.dhrRequesterHaveGuardian.label" /> <span><g:message code="dhr.property.dhrRequesterHaveGuardian.help" /></span></label>
      
        
          <ul class="haveGuardian-trigger ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="haveGuardian-trigger  required validate-one-required" title="" value="${it}" name="dhrRequesterHaveGuardian" ${it == dhr.dhrRequesterHaveGuardian ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
      
    
      <label class="haveGuardian-filled "><g:message code="dhr.property.dhrGuardianMeasure.label" /> <span><g:message code="dhr.property.dhrGuardianMeasure.help" /></span></label>
      
        
          <select name="dhrGuardianMeasure" class="haveGuardian-filled   validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['safeguardingJustice','guardianship','curatorship']}">
              <option value="fr.cg95.cvq.business.request.social.DhrGuardianMeasureType_${it}" ${it == dhr.dhrGuardianMeasure?.toString() ? 'selected="selected"': ''}><g:message code="dhr.property.dhrGuardianMeasure.${it}" /></option>
            </g:each>
          </select>
          
      
    
      <label class="haveGuardian-filled "><g:message code="dhr.property.dhrGuardianName.label" /> <span><g:message code="dhr.property.dhrGuardianName.help" /></span></label>
      
        <input name="dhrGuardianName" value="${dhr.dhrGuardianName}" class="haveGuardian-filled    validate-lastname" title="<g:message code="dhr.property.dhrGuardianName.validationError" />">
      
    
      <label class="haveGuardian-filled "><g:message code="dhr.property.dhrGuardianAddress.label" /> <span><g:message code="dhr.property.dhrGuardianAddress.help" /></span></label>
      
        
          <div class="address-fieldset haveGuardian-filled ">
          <label><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" value="${dhr.dhrGuardianAddress.additionalDeliveryInformation}" maxlength="38" name="dhrGuardianAddress.additionalDeliveryInformation"/>  
          <label><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" value="${dhr.dhrGuardianAddress.additionalGeographicalInformation}" maxlength="38" name="dhrGuardianAddress.additionalGeographicalInformation"/>
          <label><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
          <input type="text" class="line1" value="${dhr.dhrGuardianAddress.streetNumber}" maxlength="5" name="dhrGuardianAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrGuardianAddress.streetName}" maxlength="32" name="dhrGuardianAddress.streetName" title="<g:message code="request.error.required" />" />
          <label><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" value="${dhr.dhrGuardianAddress.placeNameOrService}" maxlength="38" name="dhrGuardianAddress.placeNameOrService"/>
          <label><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
          <input type="text" class="line1" value="${dhr.dhrGuardianAddress.postalCode}" maxlength="5" name="dhrGuardianAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrGuardianAddress.city}" maxlength="32" name="dhrGuardianAddress.city" title="<g:message code="request.error.required" />" />
          <label><g:message code="address.property.countryName" /></label>
          <input type="text" value="${dhr.dhrGuardianAddress.countryName}" maxlength="38" name="dhrGuardianAddress.countryName"/>
          </div>
          
      
    
    </fieldset>
  

           
