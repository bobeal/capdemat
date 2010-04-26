


  
    <div class="collection ">
    <h3>
      <g:message code="parr.property.authorizedIndividuals.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="parr.property.authorizedIndividuals.help" /></span>
      <button type="submit" name="submit-collectionAdd-authorization-authorizedIndividuals">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.authorizedIndividuals}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="parr.property.authorizedIndividuals.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-authorization-authorizedIndividuals[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label for="authorizedIndividuals.${listIndex}.lastName" class="required"><g:message code="parr.property.lastName.label" /> *  <span><g:message code="parr.property.lastName.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${listIndex}.lastName" name="authorizedIndividuals[${listIndex}].lastName" value="${listItem?.lastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="parr.property.lastName.validationError" />"  maxlength="38" />
            

        
          <label for="authorizedIndividuals.${listIndex}.firstName" class="required"><g:message code="parr.property.firstName.label" /> *  <span><g:message code="parr.property.firstName.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${listIndex}.firstName" name="authorizedIndividuals[${listIndex}].firstName" value="${listItem?.firstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="parr.property.firstName.validationError" />"  maxlength="38" />
            

        
          <label class="required"><g:message code="parr.property.address.label" /> *  <span><g:message code="parr.property.address.help" /></span></label>
            <div class="address-fieldset required ">
            <label for="authorizedIndividuals.${listIndex}.address.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.address?.additionalDeliveryInformation}" maxlength="38" id="authorizedIndividuals.${listIndex}.address.additionalDeliveryInformation" name="authorizedIndividuals[${listIndex}].address.additionalDeliveryInformation" />  
            <label for="authorizedIndividuals.${listIndex}.address.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.address?.additionalGeographicalInformation}" maxlength="38" id="authorizedIndividuals.${listIndex}.address.additionalGeographicalInformation" name="authorizedIndividuals[${listIndex}].address.additionalGeographicalInformation" />
            <label for="authorizedIndividuals.${listIndex}.address.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="authorizedIndividuals.${listIndex}.address.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="${listItem?.address?.streetNumber}" size="5" maxlength="5" id="authorizedIndividuals.${listIndex}.address.streetNumber" name="authorizedIndividuals[${listIndex}].address.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="${listItem?.address?.streetName}" maxlength="32" id="authorizedIndividuals.${listIndex}.address.streetName" name="authorizedIndividuals[${listIndex}].address.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="authorizedIndividuals.${listIndex}.address.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.address?.placeNameOrService}" maxlength="38" id="authorizedIndividuals.${listIndex}.address.placeNameOrService" name="authorizedIndividuals[${listIndex}].address.placeNameOrService" />
            <label for="authorizedIndividuals.${listIndex}.address.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="authorizedIndividuals.${listIndex}.address.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="${listItem?.address?.postalCode}" size="5" maxlength="5" id="authorizedIndividuals.${listIndex}.address.postalCode" name="authorizedIndividuals[${listIndex}].address.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="${listItem?.address?.city}" maxlength="32" id="authorizedIndividuals.${listIndex}.address.city" name="authorizedIndividuals[${listIndex}].address.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="authorizedIndividuals.${listIndex}.address.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="${listItem?.address?.countryName}" maxlength="38" id="authorizedIndividuals.${listIndex}.address.countryName" name="authorizedIndividuals[${listIndex}].address.countryName" />
            </div>
            

        
          <label for="authorizedIndividuals.${listIndex}.homePhone" class=""><g:message code="parr.property.homePhone.label" />   <span><g:message code="parr.property.homePhone.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${listIndex}.homePhone" name="authorizedIndividuals[${listIndex}].homePhone" value="${listItem?.homePhone?.toString()}" 
                    class="  validate-phone" title="<g:message code="parr.property.homePhone.validationError" />"  maxlength="10" />
            

        
          <label for="authorizedIndividuals.${listIndex}.officePhone" class=""><g:message code="parr.property.officePhone.label" />   <span><g:message code="parr.property.officePhone.help" /></span></label>
            <input type="text" id="authorizedIndividuals.${listIndex}.officePhone" name="authorizedIndividuals[${listIndex}].officePhone" value="${listItem?.officePhone?.toString()}" 
                    class="  validate-phone" title="<g:message code="parr.property.officePhone.validationError" />"  maxlength="10" />
            

        
      </fieldset>
    </g:each>
    </div>
  

