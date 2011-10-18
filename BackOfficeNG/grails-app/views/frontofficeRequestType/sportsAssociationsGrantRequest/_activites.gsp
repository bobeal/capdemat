


  
    <div class="collection required summary-box">
      <h4 class="required"><g:message code="sagr.property.activiteAssociation.label" /> 
        <span><g:message code="sagr.property.activiteAssociation.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'activites', 'currentCollection':'activiteAssociation', 'collectionIndex':(rqt.activiteAssociation ? rqt.activiteAssociation.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.activiteAssociation}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="sagr.property.activiteAssociation.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'activites', 'currentCollection':'activiteAssociation', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'activites', 'currentCollection':'activiteAssociation', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="sagr.property.sportPratique.label" /></dt>
        
              <dd class="${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation[' + index + '].sportPratique') ? 'validation-failed' : ''}">
                <g:if test="${it.sportPratique}">
                  <g:capdematEnumToField var="${it.sportPratique}" i18nKeyPrefix="sagr.property.sportPratique" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="sagr.property.sportPratiquePrecision.label" /></dt>
        <dd class="${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation[' + index + '].sportPratiquePrecision') ? 'validation-failed' : ''}">${it.sportPratiquePrecision?.toString()}</dd>
    
        <dt><g:message code="sagr.property.federationSportive.label" /></dt>
        
              <dd class="${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation[' + index + '].federationSportive') ? 'validation-failed' : ''}">
                <g:if test="${it.federationSportive}">
                  <g:capdematEnumToField var="${it.federationSportive}" i18nKeyPrefix="sagr.property.federationSportive" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="sagr.property.federationSportivePrecision.label" /></dt>
        <dd class="${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation[' + index + '].federationSportivePrecision') ? 'validation-failed' : ''}">${it.federationSportivePrecision?.toString()}</dd>
    
        <dt><g:message code="sagr.property.numeroAffiliationActivite.label" /></dt>
        <dd class="${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation[' + index + '].numeroAffiliationActivite') ? 'validation-failed' : ''}">${it.numeroAffiliationActivite?.toString()}</dd>
    
        <dt><g:message code="sagr.property.nombreLicencieMineurActivite.label" /></dt>
        <dd class="${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation[' + index + '].nombreLicencieMineurActivite') ? 'validation-failed' : ''}">${it.nombreLicencieMineurActivite?.toString()}</dd>
    
        <dt><g:message code="sagr.property.nombreLicencieMajeurActivite.label" /></dt>
        <dd class="${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation[' + index + '].nombreLicencieMajeurActivite') ? 'validation-failed' : ''}">${it.nombreLicencieMajeurActivite?.toString()}</dd>
    
        </dl>
      </div>
    </g:each>
    </div>
  

