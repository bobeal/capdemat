


  
    <label class=""><g:message code="parr.property.authorizedIndividuals.label" /> <span><g:message code="parr.property.authorizedIndividuals.help" /></span></label>
    <div class="collection-fieldset  validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'authorizedIndividuals' ? editList?.index : ( rqt.authorizedIndividuals ? rqt.authorizedIndividuals.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add ">
    
        <label class="required"><g:message code="parr.property.lastName.label" /> *  <span><g:message code="parr.property.lastName.help" /></span></label>
            <input type="text" name="authorizedIndividuals[${listIndex}].lastName" value="${editList?.authorizedIndividuals?.lastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="parr.property.lastName.validationError" />"  maxLength="38"/>
            

    
        <label class="required"><g:message code="parr.property.firstName.label" /> *  <span><g:message code="parr.property.firstName.help" /></span></label>
            <input type="text" name="authorizedIndividuals[${listIndex}].firstName" value="${editList?.authorizedIndividuals?.firstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="parr.property.firstName.validationError" />"  maxLength="38"/>
            

    
        <label class="required"><g:message code="parr.property.address.label" /> *  <span><g:message code="parr.property.address.help" /></span></label>
            <div class="address-fieldset required ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${editList?.authorizedIndividuals?.address?.additionalDeliveryInformation}" maxlength="38" name="authorizedIndividuals[${listIndex}].address.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${editList?.authorizedIndividuals?.address?.additionalGeographicalInformation}" maxlength="38" name="authorizedIndividuals[${listIndex}].address.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${editList?.authorizedIndividuals?.address?.streetNumber}" size="5" maxlength="5" name="authorizedIndividuals[${listIndex}].address.streetNumber"/>
            <input type="text" class="line2 required" value="${editList?.authorizedIndividuals?.address?.streetName}" maxlength="32" name="authorizedIndividuals[${listIndex}].address.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${editList?.authorizedIndividuals?.address?.placeNameOrService}" maxlength="38" name="authorizedIndividuals[${listIndex}].address.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${editList?.authorizedIndividuals?.address?.postalCode}" size="5" maxlength="5" name="authorizedIndividuals[${listIndex}].address.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${editList?.authorizedIndividuals?.address?.city}" maxlength="32" name="authorizedIndividuals[${listIndex}].address.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${editList?.authorizedIndividuals?.address?.countryName}" maxlength="38" name="authorizedIndividuals[${listIndex}].address.countryName"/>
            </div>
            

    
        <label class=""><g:message code="parr.property.homePhone.label" />   <span><g:message code="parr.property.homePhone.help" /></span></label>
            <input type="text" name="authorizedIndividuals[${listIndex}].homePhone" value="${editList?.authorizedIndividuals?.homePhone?.toString()}" 
                    class="  validate-phone" title="<g:message code="parr.property.homePhone.validationError" />"  maxLength="10"/>
            

    
        <label class=""><g:message code="parr.property.officePhone.label" />   <span><g:message code="parr.property.officePhone.help" /></span></label>
            <input type="text" name="authorizedIndividuals[${listIndex}].officePhone" value="${editList?.authorizedIndividuals?.officePhone?.toString()}" 
                    class="  validate-phone" title="<g:message code="parr.property.officePhone.validationError" />"  maxLength="10"/>
            

    
        <g:if test="${editList?.name == 'authorizedIndividuals'}">
          <input type="submit" id="submit-collectionModify-authorization-authorizedIndividuals[${listIndex}]" name="submit-collectionModify-authorization-authorizedIndividuals[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-authorization-authorizedIndividuals[${listIndex}]" name="submit-collectionAdd-authorization-authorizedIndividuals[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.authorizedIndividuals}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="parr.property.lastName.label" /></dt>
        <dd>${it.lastName?.toString()}</dd>
    
        <dt><g:message code="parr.property.firstName.label" /></dt>
        <dd>${it.firstName?.toString()}</dd>
    
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
        <dd>${it.homePhone?.toString()}</dd>
    
        <dt><g:message code="parr.property.officePhone.label" /></dt>
        <dd>${it.officePhone?.toString()}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-authorization-authorizedIndividuals[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-authorization-authorizedIndividuals[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

