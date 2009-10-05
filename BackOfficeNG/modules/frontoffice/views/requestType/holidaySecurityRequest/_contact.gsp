


  
    <label class="required"><g:message code="hsr.property.otherContactLastName.label" /> *  <span><g:message code="hsr.property.otherContactLastName.help" /></span></label>
            <input type="text" name="otherContactLastName" value="${rqt.otherContactLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="hsr.property.otherContactLastName.validationError" />"  maxlength="38" />
            

  

  
    <label class="required"><g:message code="hsr.property.otherContactFirstName.label" /> *  <span><g:message code="hsr.property.otherContactFirstName.help" /></span></label>
            <input type="text" name="otherContactFirstName" value="${rqt.otherContactFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="hsr.property.otherContactFirstName.validationError" />"  maxlength="38" />
            

  

  
    <label class="required"><g:message code="hsr.property.otherContactAddress.label" /> *  <span><g:message code="hsr.property.otherContactAddress.help" /></span></label>
            <div class="address-fieldset required ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.otherContactAddress?.additionalDeliveryInformation}" maxlength="38" name="otherContactAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.otherContactAddress?.additionalGeographicalInformation}" maxlength="38" name="otherContactAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.otherContactAddress?.streetNumber}" size="5" maxlength="5" name="otherContactAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.otherContactAddress?.streetName}" maxlength="32" name="otherContactAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.otherContactAddress?.placeNameOrService}" maxlength="38" name="otherContactAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.otherContactAddress?.postalCode}" size="5" maxlength="5" name="otherContactAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.otherContactAddress?.city}" maxlength="32" name="otherContactAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.otherContactAddress?.countryName}" maxlength="38" name="otherContactAddress.countryName"/>
            </div>
            

  

  
    <label class="required"><g:message code="hsr.property.otherContactPhone.label" /> *  <span><g:message code="hsr.property.otherContactPhone.help" /></span></label>
            <input type="text" name="otherContactPhone" value="${rqt.otherContactPhone?.toString()}" 
                    class="required  validate-phone" title="<g:message code="hsr.property.otherContactPhone.validationError" />"  maxlength="10" />
            

  

