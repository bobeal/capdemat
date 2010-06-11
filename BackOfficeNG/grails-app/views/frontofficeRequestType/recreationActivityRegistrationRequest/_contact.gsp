


  
    <label class=""><g:message code="rarr.property.contactIndividuals.label" /> <span><g:message code="rarr.property.contactIndividuals.help" /></span></label>
    <div class="collection-fieldset  summary-box">
    <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'contact', 'currentCollection':'contactIndividuals', 'collectionIndex':(rqt.contactIndividuals ? rqt.contactIndividuals.size() : 0)])}" />
      ${message(code:'request.action.newCollectionItem')}
    </a>
    <g:each var="it" in="${rqt.contactIndividuals}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="rarr.property.lastName.label" /></dt>
        <dd class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].lastName') ? 'validation-failed' : ''}">${it.lastName?.toString()}</dd>
    
        <dt><g:message code="rarr.property.firstName.label" /></dt>
        <dd class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].firstName') ? 'validation-failed' : ''}">${it.firstName?.toString()}</dd>
    
        <dt><g:message code="rarr.property.address.label" /></dt>
        
              <g:if test="${it.address}">
                <dd class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].address') ? 'validation-failed' : ''}">
                  <p class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].address.additionalDeliveryInformation') ? 'validation-failed' : ''}">${it.address?.additionalDeliveryInformation}</p>
                  <p class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].address.additionalGeographicalInformation') ? 'validation-failed' : ''}">${it.address?.additionalGeographicalInformation}</p>
                  <p class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].address.streetNumber') || rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].address.streetName') ? 'validation-failed' : ''}">${it.address?.streetNumber} ${it.address?.streetName}</p>
                  <p class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].address.placeNameOrService') ? 'validation-failed' : ''}">${it.address?.placeNameOrService}</p>
                  <p class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].address.postalCode') || rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].address.city') ? 'validation-failed' : ''}">${it.address?.postalCode} ${it.address?.city}</p>
                  <p class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].address.countryName') ? 'validation-failed' : ''}">${it.address?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="rarr.property.homePhone.label" /></dt>
        <dd class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].homePhone') ? 'validation-failed' : ''}">${it.homePhone?.toString()}</dd>
    
        <dt><g:message code="rarr.property.officePhone.label" /></dt>
        <dd class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].officePhone') ? 'validation-failed' : ''}">${it.officePhone?.toString()}</dd>
    
        </dl>
         <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'contact', 'currentCollection':'contactIndividuals', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'contact', 'currentCollection':'contactIndividuals', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
      </fieldset>
    </g:each>
    </div>
  

