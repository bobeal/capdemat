
  <g:set var="currentCollectionItem" value="${rqt?.autreMembreBureau.size() > collectionIndex ? rqt.autreMembreBureau.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'sagr.property.autreMembreBureau.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label for="autreMembreBureau.${collectionIndex}.roleMembre" class="required"><g:message code="sagr.property.roleMembre.label" /> *  <span><g:message code="sagr.property.roleMembre.help" /></span></label>
            <select id="autreMembreBureau.${collectionIndex}.roleMembre" name="autreMembreBureau[${collectionIndex}].roleMembre" class="required  validate-not-first ${rqt.stepStates['bureau'].invalidFields.contains('autreMembreBureau['+collectionIndex+'].roleMembre') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.roleMembre.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['TRESORIER','SECRETAIRE']}">
                <option value="${it}" ${it == currentCollectionItem?.roleMembre?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sagr.property.roleMembre" /></option>
              </g:each>
            </select>
            

  
    <label for="autreMembreBureau.${collectionIndex}.nomMembre" class="required"><g:message code="sagr.property.nomMembre.label" /> *  <span><g:message code="sagr.property.nomMembre.help" /></span></label>
            <input type="text" id="autreMembreBureau.${collectionIndex}.nomMembre" name="autreMembreBureau[${collectionIndex}].nomMembre" value="${currentCollectionItem?.nomMembre?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['bureau'].invalidFields.contains('autreMembreBureau['+collectionIndex+'].nomMembre') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nomMembre.validationError" />"  maxlength="38" />
            

  
    <label for="autreMembreBureau.${collectionIndex}.prenomMembre" class="required"><g:message code="sagr.property.prenomMembre.label" /> *  <span><g:message code="sagr.property.prenomMembre.help" /></span></label>
            <input type="text" id="autreMembreBureau.${collectionIndex}.prenomMembre" name="autreMembreBureau[${collectionIndex}].prenomMembre" value="${currentCollectionItem?.prenomMembre?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['bureau'].invalidFields.contains('autreMembreBureau['+collectionIndex+'].prenomMembre') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.prenomMembre.validationError" />"  maxlength="38" />
            

  
    <label for="autreMembreBureau.${collectionIndex}.telephoneMembre" class=""><g:message code="sagr.property.telephoneMembre.label" />   <span><g:message code="sagr.property.telephoneMembre.help" /></span></label>
            <input type="text" id="autreMembreBureau.${collectionIndex}.telephoneMembre" name="autreMembreBureau[${collectionIndex}].telephoneMembre" value="${currentCollectionItem?.telephoneMembre?.toString()}" 
                    class="  validate-phone ${rqt.stepStates['bureau'].invalidFields.contains('autreMembreBureau['+collectionIndex+'].telephoneMembre') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.telephoneMembre.validationError" />"  maxlength="10" />
            

  
    <label for="autreMembreBureau.${collectionIndex}.emailMembre" class=""><g:message code="sagr.property.emailMembre.label" />   <span><g:message code="sagr.property.emailMembre.help" /></span></label>
            <input type="text" id="autreMembreBureau.${collectionIndex}.emailMembre" name="autreMembreBureau[${collectionIndex}].emailMembre" value="${currentCollectionItem?.emailMembre?.toString()}" 
                    class="  validate-email ${rqt.stepStates['bureau'].invalidFields.contains('autreMembreBureau['+collectionIndex+'].emailMembre') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.emailMembre.validationError" />"   />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'bureau'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
