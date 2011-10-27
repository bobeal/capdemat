


  
    <div class="collection  summary-box">
      <h4 class=""><g:message code="sagr.property.autreMembreBureau.label" /> 
        <span><g:message code="sagr.property.autreMembreBureau.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'bureau', 'currentCollection':'autreMembreBureau', 'collectionIndex':(rqt.autreMembreBureau ? rqt.autreMembreBureau.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.autreMembreBureau}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="sagr.property.autreMembreBureau.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'bureau', 'currentCollection':'autreMembreBureau', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'bureau', 'currentCollection':'autreMembreBureau', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="sagr.property.roleMembre.label" /></dt>
        
              <dd class="${rqt.stepStates['bureau'].invalidFields.contains('autreMembreBureau[' + index + '].roleMembre') ? 'validation-failed' : ''}">
                <g:if test="${it.roleMembre}">
                  <g:capdematEnumToField var="${it.roleMembre}" i18nKeyPrefix="sagr.property.roleMembre" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="sagr.property.nomMembre.label" /></dt>
        <dd class="${rqt.stepStates['bureau'].invalidFields.contains('autreMembreBureau[' + index + '].nomMembre') ? 'validation-failed' : ''}">${it.nomMembre?.toString()}</dd>
    
        <dt><g:message code="sagr.property.prenomMembre.label" /></dt>
        <dd class="${rqt.stepStates['bureau'].invalidFields.contains('autreMembreBureau[' + index + '].prenomMembre') ? 'validation-failed' : ''}">${it.prenomMembre?.toString()}</dd>
    
        <dt><g:message code="sagr.property.telephoneMembre.label" /></dt>
        <dd class="${rqt.stepStates['bureau'].invalidFields.contains('autreMembreBureau[' + index + '].telephoneMembre') ? 'validation-failed' : ''}">${it.telephoneMembre?.toString()}</dd>
    
        <dt><g:message code="sagr.property.emailMembre.label" /></dt>
        <dd class="${rqt.stepStates['bureau'].invalidFields.contains('autreMembreBureau[' + index + '].emailMembre') ? 'validation-failed' : ''}">${it.emailMembre?.toString()}</dd>
    
        </dl>
      </div>
    </g:each>
    </div>
  

