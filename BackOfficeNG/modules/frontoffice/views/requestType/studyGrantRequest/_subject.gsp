




  
    <fieldset class="required">
    <legend><g:message code="sgr.property.subjetInformations.label" /></legend> 
      
    <label class="required"><g:message code="request.property.subjectName" /> *</label>
    <select name="subjectId" class="required validate-not-first" title="<g:message code="request.subject.validationError" /> ">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${subjects}">
        <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
      </g:each>
    </select>
      
    
      <label class="required"><g:message code="sgr.property.subjectPhone.label" /> * <span><g:message code="sgr.property.subjectPhone.help" /></span></label>
      
            <input type="text" name="subjectPhone" value="${rqt.subjectPhone}" 
                    class="required validate-phone" title="<g:message code="sgr.property.subjectPhone.validationError" />"  maxLength="10"/>
            
    
      <label class="required"><g:message code="sgr.property.subjectMobilePhone.label" /> * <span><g:message code="sgr.property.subjectMobilePhone.help" /></span></label>
      
            <input type="text" name="subjectMobilePhone" value="${rqt.subjectMobilePhone}" 
                    class="required validate-phone" title="<g:message code="sgr.property.subjectMobilePhone.validationError" />"  maxLength="10"/>
            
    
      <label class="required"><g:message code="sgr.property.subjectEmail.label" /> * <span><g:message code="sgr.property.subjectEmail.help" /></span></label>
      
            <input type="text" name="subjectEmail" value="${rqt.subjectEmail}" 
                    class="required validate-email" title="<g:message code="sgr.property.subjectEmail.validationError" />"  />
            
    
      <label class="required"><g:message code="sgr.property.subjectBirthDate.label" /> * <span><g:message code="sgr.property.subjectBirthDate.help" /></span></label>
      
            <input type="text" name="subjectBirthDate" value="${formatDate(formatName:'format.date',date:rqt.subjectBirthDate)}" 
                   class="required validate-date" title="<g:message code="sgr.property.subjectBirthDate.validationError" />" />
            
    
      <label class="required"><g:message code="sgr.property.subjectBirthPlace.label" /> * <span><g:message code="sgr.property.subjectBirthPlace.help" /></span></label>
      
            <input type="text" name="subjectBirthPlace" value="${rqt.subjectBirthPlace}" 
                    class="required validate-string" title="<g:message code="sgr.property.subjectBirthPlace.validationError" />"  />
            
    
      <label class="required"><g:message code="sgr.property.hasParentsAddress.label" /> * <span><g:message code="sgr.property.hasParentsAddress.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-livesWithParents-trigger validate-boolean" title="" value="${it}" name="hasParentsAddress" ${it == rqt.hasParentsAddress ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-livesWithParents-unfilled"><g:message code="sgr.property.subjectAddress.label" /> * <span><g:message code="sgr.property.subjectAddress.help" /></span></label>
      
            <div class="address-fieldset required condition-livesWithParents-unfilled">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.subjectAddress?.additionalDeliveryInformation}" maxlength="38" name="subjectAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.subjectAddress?.additionalGeographicalInformation}" maxlength="38" name="subjectAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.subjectAddress?.streetNumber}" maxlength="5" name="subjectAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.subjectAddress?.streetName}" maxlength="32" name="subjectAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.subjectAddress?.placeNameOrService}" maxlength="38" name="subjectAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.subjectAddress?.postalCode}" maxlength="5" name="subjectAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.subjectAddress?.city}" maxlength="32" name="subjectAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.subjectAddress?.countryName}" maxlength="38" name="subjectAddress.countryName"/>
            </div>
            
    
    </fieldset>
  

