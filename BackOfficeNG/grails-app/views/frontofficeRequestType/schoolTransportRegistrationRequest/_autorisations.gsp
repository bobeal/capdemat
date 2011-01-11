


  
    <label class="required"><g:message code="strr.property.estMaternelleElementaireAutorisations.label" /> *  <span><g:message code="strr.property.estMaternelleElementaireAutorisations.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['autorisations'].invalidFields.contains('estMaternelleElementaireAutorisations') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estMaternelleElementaireAutorisations_${it ? 'yes' : 'no'}" class="required condition-estMaternelleElementaire-trigger  validate-one-required boolean" title="" value="${it}" name="estMaternelleElementaireAutorisations" ${it == rqt.estMaternelleElementaireAutorisations ? 'checked="checked"': ''} />
                <label for="estMaternelleElementaireAutorisations_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="autorisation" class="required condition-estMaternelleElementaire-filled"><g:message code="strr.property.autorisation.label" /> *  <span><g:message code="strr.property.autorisation.help" /></span></label>
            <select id="autorisation" name="autorisation" class="required condition-estMaternelleElementaire-filled condition-autoriseTiers-trigger condition-autoriseFrereOuSoeur-trigger  validate-not-first ${rqt.stepStates['autorisations'].invalidFields.contains('autorisation') ? 'validation-failed' : ''}" title="<g:message code="strr.property.autorisation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Seul','AvecFrereSoeur','AvecTiers']}">
                <option value="fr.cg95.cvq.business.request.school.AutorisationType_${it}" ${it == rqt.autorisation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="strr.property.autorisation" /></option>
              </g:each>
            </select>
            

  

  
    <div class="collection required condition-autoriseTiers-filled summary-box">
      <h4 class="required condition-autoriseTiers-filled"><g:message code="strr.property.tiersAutorises.label" /> 
        <span><g:message code="strr.property.tiersAutorises.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'autorisations', 'currentCollection':'tiersAutorises', 'collectionIndex':(rqt.tiersAutorises ? rqt.tiersAutorises.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.tiersAutorises}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="strr.property.tiersAutorises.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'autorisations', 'currentCollection':'tiersAutorises', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'autorisations', 'currentCollection':'tiersAutorises', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="strr.property.tiersNom.label" /></dt>
        <dd class="${rqt.stepStates['autorisations'].invalidFields.contains('tiersAutorises[' + index + '].tiersNom') ? 'validation-failed' : ''}">${it.tiersNom?.toString()}</dd>
    
        <dt><g:message code="strr.property.tiersPrenom.label" /></dt>
        <dd class="${rqt.stepStates['autorisations'].invalidFields.contains('tiersAutorises[' + index + '].tiersPrenom') ? 'validation-failed' : ''}">${it.tiersPrenom?.toString()}</dd>
    
        <dt><g:message code="strr.property.tiersTelephone.label" /></dt>
        <dd class="${rqt.stepStates['autorisations'].invalidFields.contains('tiersAutorises[' + index + '].tiersTelephone') ? 'validation-failed' : ''}">${it.tiersTelephone?.toString()}</dd>
    
        </dl>
      </div>
    </g:each>
    </div>
  

  
    <fieldset class="required condition-autoriseFrereOuSoeur-filled">
    <legend><g:message code="strr.property.frereOuSoeurAutorise.label" /></legend>
    
      <label for="frereOuSoeurNom" class="required"><g:message code="strr.property.frereOuSoeurNom.label" /> *  <span><g:message code="strr.property.frereOuSoeurNom.help" /></span></label>
            <input type="text" id="frereOuSoeurNom" name="frereOuSoeurNom" value="${rqt.frereOuSoeurNom?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['autorisations'].invalidFields.contains('frereOuSoeurNom') ? 'validation-failed' : ''}" title="<g:message code="strr.property.frereOuSoeurNom.validationError" />"  maxlength="38" />
            

    
      <label for="frereOuSoeurPrenom" class="required"><g:message code="strr.property.frereOuSoeurPrenom.label" /> *  <span><g:message code="strr.property.frereOuSoeurPrenom.help" /></span></label>
            <input type="text" id="frereOuSoeurPrenom" name="frereOuSoeurPrenom" value="${rqt.frereOuSoeurPrenom?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['autorisations'].invalidFields.contains('frereOuSoeurPrenom') ? 'validation-failed' : ''}" title="<g:message code="strr.property.frereOuSoeurPrenom.validationError" />"  maxlength="38" />
            

    
      <label for="frereOuSoeurEcole" class="required"><g:message code="strr.property.frereOuSoeurEcole.label" /> *  <span><g:message code="strr.property.frereOuSoeurEcole.help" /></span></label>
            <input type="text" id="frereOuSoeurEcole" name="frereOuSoeurEcole" value="${rqt.frereOuSoeurEcole?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['autorisations'].invalidFields.contains('frereOuSoeurEcole') ? 'validation-failed' : ''}" title="<g:message code="strr.property.frereOuSoeurEcole.validationError" />"   />
            

    
      <label for="frereOuSoeurClasse" class="required"><g:message code="strr.property.frereOuSoeurClasse.label" /> *  <span><g:message code="strr.property.frereOuSoeurClasse.help" /></span></label>
            <input type="text" id="frereOuSoeurClasse" name="frereOuSoeurClasse" value="${rqt.frereOuSoeurClasse?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['autorisations'].invalidFields.contains('frereOuSoeurClasse') ? 'validation-failed' : ''}" title="<g:message code="strr.property.frereOuSoeurClasse.validationError" />"   />
            

    
    </fieldset>
  

