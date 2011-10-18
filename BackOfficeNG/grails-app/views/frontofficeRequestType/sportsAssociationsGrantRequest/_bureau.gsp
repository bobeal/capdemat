


  
    <label for="roleDemandeur" class="required"><g:message code="sagr.property.roleDemandeur.label" /> *  <span><g:message code="sagr.property.roleDemandeur.help" /></span></label>
            <select id="roleDemandeur" name="roleDemandeur" class="required condition-estPresident-trigger  validate-not-first ${rqt.stepStates['bureau'].invalidFields.contains('roleDemandeur') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.roleDemandeur.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['PRESIDENT','TRESORIER','SECRETAIRE']}">
                <option value="${it}" ${it == rqt.roleDemandeur?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sagr.property.roleDemandeur" /></option>
              </g:each>
            </select>
            

  

  
    <fieldset class="required condition-estPresident-unfilled">
    <legend><g:message code="sagr.property.precisionPresident.label" /></legend>
    
      <label for="nomPresident" class="required"><g:message code="sagr.property.nomPresident.label" /> *  <span><g:message code="sagr.property.nomPresident.help" /></span></label>
            <input type="text" id="nomPresident" name="nomPresident" value="${rqt.nomPresident?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['bureau'].invalidFields.contains('nomPresident') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nomPresident.validationError" />"  maxlength="38" />
            

    
      <label for="prenomPresident" class="required"><g:message code="sagr.property.prenomPresident.label" /> *  <span><g:message code="sagr.property.prenomPresident.help" /></span></label>
            <input type="text" id="prenomPresident" name="prenomPresident" value="${rqt.prenomPresident?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['bureau'].invalidFields.contains('prenomPresident') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.prenomPresident.validationError" />"  maxlength="38" />
            

    
      <label for="telephonePresident" class=""><g:message code="sagr.property.telephonePresident.label" />   <span><g:message code="sagr.property.telephonePresident.help" /></span></label>
            <input type="text" id="telephonePresident" name="telephonePresident" value="${rqt.telephonePresident?.toString()}" 
                    class="  validate-phone ${rqt.stepStates['bureau'].invalidFields.contains('telephonePresident') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.telephonePresident.validationError" />"  maxlength="10" />
            

    
      <label for="emailPresident" class=""><g:message code="sagr.property.emailPresident.label" />   <span><g:message code="sagr.property.emailPresident.help" /></span></label>
            <input type="text" id="emailPresident" name="emailPresident" value="${rqt.emailPresident?.toString()}" 
                    class="  validate-email ${rqt.stepStates['bureau'].invalidFields.contains('emailPresident') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.emailPresident.validationError" />"   />
            

    
    </fieldset>
  

  
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
  

