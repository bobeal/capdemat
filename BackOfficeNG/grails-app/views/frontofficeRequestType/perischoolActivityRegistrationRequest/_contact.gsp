


  
    <div class="collection  summary-box">
      <h4 class=""><g:message code="parr.property.contactIndividuals.label" /> 
        <span><g:message code="parr.property.contactIndividuals.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'contact', 'currentCollection':'contactIndividuals', 'collectionIndex':(rqt.contactIndividuals ? rqt.contactIndividuals.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.contactIndividuals}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="parr.property.contactIndividuals.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'contact', 'currentCollection':'contactIndividuals', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'contact', 'currentCollection':'contactIndividuals', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="parr.property.lastName.label" /></dt>
        <dd class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].lastName') ? 'validation-failed' : ''}">${it.lastName?.toString()}</dd>
    
        <dt><g:message code="parr.property.firstName.label" /></dt>
        <dd class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].firstName') ? 'validation-failed' : ''}">${it.firstName?.toString()}</dd>
    
        <dt><g:message code="parr.property.address.label" /></dt>
        
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
              
    
        <dt><g:message code="parr.property.homePhone.label" /></dt>
        <dd class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].homePhone') ? 'validation-failed' : ''}">${it.homePhone?.toString()}</dd>
    
        <dt><g:message code="parr.property.officePhone.label" /></dt>
        <dd class="${rqt.stepStates['contact'].invalidFields.contains('contactIndividuals[' + index + '].officePhone') ? 'validation-failed' : ''}">${it.officePhone?.toString()}</dd>
    
        </dl>
      </div>
    </g:each>
    </div>
  

