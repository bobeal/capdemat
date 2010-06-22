


  
    <div class="collection  summary-box">
      <h4 class=""><g:message code="parr.property.authorizedIndividuals.label" /> 
        <span><g:message code="parr.property.authorizedIndividuals.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'authorization', 'currentCollection':'authorizedIndividuals', 'collectionIndex':(rqt.authorizedIndividuals ? rqt.authorizedIndividuals.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.authorizedIndividuals}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="parr.property.authorizedIndividuals.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'authorization', 'currentCollection':'authorizedIndividuals', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'authorization', 'currentCollection':'authorizedIndividuals', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="parr.property.lastName.label" /></dt>
        <dd class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].lastName') ? 'validation-failed' : ''}">${it.lastName?.toString()}</dd>
    
        <dt><g:message code="parr.property.firstName.label" /></dt>
        <dd class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].firstName') ? 'validation-failed' : ''}">${it.firstName?.toString()}</dd>
    
        <dt><g:message code="parr.property.address.label" /></dt>
        
              <g:if test="${it.address}">
                <dd class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].address') ? 'validation-failed' : ''}">
                  <p class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].address.additionalDeliveryInformation') ? 'validation-failed' : ''}">${it.address?.additionalDeliveryInformation}</p>
                  <p class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].address.additionalGeographicalInformation') ? 'validation-failed' : ''}">${it.address?.additionalGeographicalInformation}</p>
                  <p class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].address.streetNumber') || rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].address.streetName') ? 'validation-failed' : ''}">${it.address?.streetNumber} ${it.address?.streetName}</p>
                  <p class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].address.placeNameOrService') ? 'validation-failed' : ''}">${it.address?.placeNameOrService}</p>
                  <p class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].address.postalCode') || rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].address.city') ? 'validation-failed' : ''}">${it.address?.postalCode} ${it.address?.city}</p>
                  <p class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].address.countryName') ? 'validation-failed' : ''}">${it.address?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="parr.property.homePhone.label" /></dt>
        <dd class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].homePhone') ? 'validation-failed' : ''}">${it.homePhone?.toString()}</dd>
    
        <dt><g:message code="parr.property.officePhone.label" /></dt>
        <dd class="${rqt.stepStates['authorization'].invalidFields.contains('authorizedIndividuals[' + index + '].officePhone') ? 'validation-failed' : ''}">${it.officePhone?.toString()}</dd>
    
        </dl>
      </div>
    </g:each>
    </div>
  

