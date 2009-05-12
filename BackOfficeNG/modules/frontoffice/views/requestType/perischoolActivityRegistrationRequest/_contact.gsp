


  
    <label class=""><g:message code="parr.property.contactIndividuals.label" /> <span><g:message code="parr.property.contactIndividuals.help" /></span></label>
    <div class="collection-fieldset  validation-scope">
      <g:set var="listIndex" value="${editList?.name == 'contactIndividuals' ? editList?.index : ( rqt.contactIndividuals ? rqt.contactIndividuals.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add ">
    
        <label class="required"><g:message code="parr.property.lastName.label" /> *  <span><g:message code="parr.property.lastName.help" /></span></label>
            <input type="text" name="contactIndividuals[${listIndex}].lastName" value="${editList?.contactIndividuals?.lastName}" 
                    class="required  validate-lastName" title="<g:message code="parr.property.lastName.validationError" />"  maxLength="38"/>
            

    
        <label class="required"><g:message code="parr.property.firstName.label" /> *  <span><g:message code="parr.property.firstName.help" /></span></label>
            <input type="text" name="contactIndividuals[${listIndex}].firstName" value="${editList?.contactIndividuals?.firstName}" 
                    class="required  validate-firstName" title="<g:message code="parr.property.firstName.validationError" />"  maxLength="38"/>
            

    
        <label class="required"><g:message code="parr.property.address.label" /> *  <span><g:message code="parr.property.address.help" /></span></label>
            <div class="address-fieldset required ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${editList?.contactIndividuals?.address?.additionalDeliveryInformation}" maxlength="38" name="contactIndividuals[${listIndex}].address.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${editList?.contactIndividuals?.address?.additionalGeographicalInformation}" maxlength="38" name="contactIndividuals[${listIndex}].address.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${editList?.contactIndividuals?.address?.streetNumber}" maxlength="5" name="contactIndividuals[${listIndex}].address.streetNumber"/>
            <input type="text" class="line2 required" value="${editList?.contactIndividuals?.address?.streetName}" maxlength="32" name="contactIndividuals[${listIndex}].address.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${editList?.contactIndividuals?.address?.placeNameOrService}" maxlength="38" name="contactIndividuals[${listIndex}].address.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${editList?.contactIndividuals?.address?.postalCode}" maxlength="5" name="contactIndividuals[${listIndex}].address.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${editList?.contactIndividuals?.address?.city}" maxlength="32" name="contactIndividuals[${listIndex}].address.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${editList?.contactIndividuals?.address?.countryName}" maxlength="38" name="contactIndividuals[${listIndex}].address.countryName"/>
            </div>
            

    
        <label class=""><g:message code="parr.property.homePhone.label" />   <span><g:message code="parr.property.homePhone.help" /></span></label>
            <input type="text" name="contactIndividuals[${listIndex}].homePhone" value="${editList?.contactIndividuals?.homePhone}" 
                    class="  validate-phone" title="<g:message code="parr.property.homePhone.validationError" />"  maxLength="10"/>
            

    
        <label class=""><g:message code="parr.property.officePhone.label" />   <span><g:message code="parr.property.officePhone.help" /></span></label>
            <input type="text" name="contactIndividuals[${listIndex}].officePhone" value="${editList?.contactIndividuals?.officePhone}" 
                    class="  validate-phone" title="<g:message code="parr.property.officePhone.validationError" />"  maxLength="10"/>
            

    
        <g:if test="${editList?.name == 'contactIndividuals'}">
          <input type="submit" id="submit-collectionModify-contact-contactIndividuals[${listIndex}]" name="submit-collectionModify-contact-contactIndividuals[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-contact-contactIndividuals[${listIndex}]" name="submit-collectionAdd-contact-contactIndividuals[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.contactIndividuals}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="parr.property.lastName.label" /></dt>
        <dd>${it.lastName}</dd>
    
        <dt><g:message code="parr.property.firstName.label" /></dt>
        <dd>${it.firstName}</dd>
    
        <dt><g:message code="parr.property.address.label" /></dt>
        
              <g:if test="${it.address}">
                <dd>
                  <p>${it.address?.additionalDeliveryInformation}</p>
                  <p>${it.address?.additionalGeographicalInformation}</p>
                  <p>${it.address?.streetNumber} ${it.address?.streetName}</p>
                  <p>${it.address?.placeNameOrService}</p>
                  <p>${it.address?.postalCode} ${it.address?.city}</p>
                  <p>${it.address?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="parr.property.homePhone.label" /></dt>
        <dd>${it.homePhone}</dd>
    
        <dt><g:message code="parr.property.officePhone.label" /></dt>
        <dd>${it.officePhone}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-contact-contactIndividuals[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-contact-contactIndividuals[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

