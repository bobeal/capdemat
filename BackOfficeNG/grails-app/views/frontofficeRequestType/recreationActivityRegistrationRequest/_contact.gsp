


  
    <div class="collection ">
    <h3>
      <g:message code="rarr.property.contactIndividuals.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="rarr.property.contactIndividuals.help" /></span>
      <button type="submit" name="submit-collectionAdd-contact-contactIndividuals">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.contactIndividuals}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="rarr.property.contactIndividuals.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-contact-contactIndividuals[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label for="contactIndividuals.${listIndex}.lastName" class="required"><g:message code="rarr.property.lastName.label" /> *  <span><g:message code="rarr.property.lastName.help" /></span></label>
            <input type="text" id="contactIndividuals.${listIndex}.lastName" name="contactIndividuals[${listIndex}].lastName" value="${listItem?.lastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="rarr.property.lastName.validationError" />"  maxlength="38" />
            

        
          <label for="contactIndividuals.${listIndex}.firstName" class="required"><g:message code="rarr.property.firstName.label" /> *  <span><g:message code="rarr.property.firstName.help" /></span></label>
            <input type="text" id="contactIndividuals.${listIndex}.firstName" name="contactIndividuals[${listIndex}].firstName" value="${listItem?.firstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="rarr.property.firstName.validationError" />"  maxlength="38" />
            

        
          <label class="required"><g:message code="rarr.property.address.label" /> *  <span><g:message code="rarr.property.address.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="contactIndividuals.${listIndex}.address.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${listItem?.address?.additionalDeliveryInformation}" maxlength="38" id="contactIndividuals.${listIndex}.address.additionalDeliveryInformation" name="contactIndividuals[${listIndex}].address.additionalDeliveryInformation" />  
            <label for="contactIndividuals.${listIndex}.address.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${listItem?.address?.additionalGeographicalInformation}" maxlength="38" id="contactIndividuals.${listIndex}.address.additionalGeographicalInformation" name="contactIndividuals[${listIndex}].address.additionalGeographicalInformation" />
            <label for="contactIndividuals.${listIndex}.address.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="contactIndividuals.${listIndex}.address.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1" value="${listItem?.address?.streetNumber}" size="5" maxlength="5" id="contactIndividuals.${listIndex}.address.streetNumber" name="contactIndividuals[${listIndex}].address.streetNumber" />
            <input type="text" class="line2 required" value="${listItem?.address?.streetName}" maxlength="32" id="contactIndividuals.${listIndex}.address.streetName" name="contactIndividuals[${listIndex}].address.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="contactIndividuals.${listIndex}.address.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${listItem?.address?.placeNameOrService}" maxlength="38" id="contactIndividuals.${listIndex}.address.placeNameOrService" name="contactIndividuals[${listIndex}].address.placeNameOrService" />
            <label for="contactIndividuals.${listIndex}.address.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="contactIndividuals.${listIndex}.address.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required" value="${listItem?.address?.postalCode}" size="5" maxlength="5" id="contactIndividuals.${listIndex}.address.postalCode" name="contactIndividuals[${listIndex}].address.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${listItem?.address?.city}" maxlength="32" id="contactIndividuals.${listIndex}.address.city" name="contactIndividuals[${listIndex}].address.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="contactIndividuals.${listIndex}.address.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" value="${listItem?.address?.countryName}" maxlength="38" id="contactIndividuals.${listIndex}.address.countryName" name="contactIndividuals[${listIndex}].address.countryName" />
            </div>
            

        
          <label for="contactIndividuals.${listIndex}.homePhone" class=""><g:message code="rarr.property.homePhone.label" />   <span><g:message code="rarr.property.homePhone.help" /></span></label>
            <input type="text" id="contactIndividuals.${listIndex}.homePhone" name="contactIndividuals[${listIndex}].homePhone" value="${listItem?.homePhone?.toString()}" 
                    class="  validate-phone" title="<g:message code="rarr.property.homePhone.validationError" />"  maxlength="10" />
            

        
          <label for="contactIndividuals.${listIndex}.officePhone" class=""><g:message code="rarr.property.officePhone.label" />   <span><g:message code="rarr.property.officePhone.help" /></span></label>
            <input type="text" id="contactIndividuals.${listIndex}.officePhone" name="contactIndividuals[${listIndex}].officePhone" value="${listItem?.officePhone?.toString()}" 
                    class="  validate-phone" title="<g:message code="rarr.property.officePhone.validationError" />"  maxlength="10" />
            

        
      </fieldset>
    </g:each>
    </div>
  

