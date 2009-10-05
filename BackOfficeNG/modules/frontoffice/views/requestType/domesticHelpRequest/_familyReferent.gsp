


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrFamilyReferent.label" /></legend>
    
      <label class="required"><g:message code="dhr.property.dhrHaveFamilyReferent.label" /> *  <span><g:message code="dhr.property.dhrHaveFamilyReferent.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-haveFamilyReferent-trigger  validate-one-required boolean" title="" value="${it}" name="dhrHaveFamilyReferent" ${it == rqt.dhrHaveFamilyReferent ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-haveFamilyReferent-filled"><g:message code="dhr.property.dhrReferentName.label" /> *  <span><g:message code="dhr.property.dhrReferentName.help" /></span></label>
            <input type="text" name="dhrReferentName" value="${rqt.dhrReferentName?.toString()}" 
                    class="required condition-haveFamilyReferent-filled  validate-lastName" title="<g:message code="dhr.property.dhrReferentName.validationError" />"  maxlength="38" />
            

    
      <label class="required condition-haveFamilyReferent-filled"><g:message code="dhr.property.dhrReferentFirstName.label" /> *  <span><g:message code="dhr.property.dhrReferentFirstName.help" /></span></label>
            <input type="text" name="dhrReferentFirstName" value="${rqt.dhrReferentFirstName?.toString()}" 
                    class="required condition-haveFamilyReferent-filled  validate-firstName" title="<g:message code="dhr.property.dhrReferentFirstName.validationError" />"  maxlength="38" />
            

    
      <label class="required condition-haveFamilyReferent-filled"><g:message code="dhr.property.dhrReferentAddress.label" /> *  <span><g:message code="dhr.property.dhrReferentAddress.help" /></span></label>
            <div class="address-fieldset required condition-haveFamilyReferent-filled ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.dhrReferentAddress?.additionalDeliveryInformation}" maxlength="38" name="dhrReferentAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.dhrReferentAddress?.additionalGeographicalInformation}" maxlength="38" name="dhrReferentAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.dhrReferentAddress?.streetNumber}" size="5" maxlength="5" name="dhrReferentAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.dhrReferentAddress?.streetName}" maxlength="32" name="dhrReferentAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.dhrReferentAddress?.placeNameOrService}" maxlength="38" name="dhrReferentAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.dhrReferentAddress?.postalCode}" size="5" maxlength="5" name="dhrReferentAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.dhrReferentAddress?.city}" maxlength="32" name="dhrReferentAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.dhrReferentAddress?.countryName}" maxlength="38" name="dhrReferentAddress.countryName"/>
            </div>
            

    
    </fieldset>
  

