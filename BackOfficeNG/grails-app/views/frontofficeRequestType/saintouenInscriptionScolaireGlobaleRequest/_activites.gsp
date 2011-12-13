


  
    <label class="required"><g:message code="sisgr.property.estRestauration.label" /> *  <span><g:message code="sisgr.property.estRestauration.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['activites'].invalidFields.contains('estRestauration') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estRestauration_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="estRestauration" ${it == rqt.estRestauration ? 'checked="checked"': ''} />
                <label for="estRestauration_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="required">
    <legend><g:message code="sisgr.property.inscriptionPeriscolaire.label" /></legend>
    
      <label class="required"><g:message code="sisgr.property.accueilMatin.label" /> *  <span><g:message code="sisgr.property.accueilMatin.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['activites'].invalidFields.contains('accueilMatin') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="accueilMatin_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="accueilMatin" ${it == rqt.accueilMatin ? 'checked="checked"': ''} />
                <label for="accueilMatin_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="sisgr.property.accueilSoir.label" /> *  <span><g:message code="sisgr.property.accueilSoir.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['activites'].invalidFields.contains('accueilSoir') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="accueilSoir_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="accueilSoir" ${it == rqt.accueilSoir ? 'checked="checked"': ''} />
                <label for="accueilSoir_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="sisgr.property.accueilMercrediEtVacances.label" /> *  <span><g:message code="sisgr.property.accueilMercrediEtVacances.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['activites'].invalidFields.contains('accueilMercrediEtVacances') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="accueilMercrediEtVacances_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="accueilMercrediEtVacances" ${it == rqt.accueilMercrediEtVacances ? 'checked="checked"': ''} />
                <label for="accueilMercrediEtVacances_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="sisgr.property.etudesSurveillees.label" /> *  <span><g:message code="sisgr.property.etudesSurveillees.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['activites'].invalidFields.contains('etudesSurveillees') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="etudesSurveillees_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="etudesSurveillees" ${it == rqt.etudesSurveillees ? 'checked="checked"': ''} />
                <label for="etudesSurveillees_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    
            <ul ${rqt.stepStates['activites'].invalidFields.contains('reglementInterieur') ? 'class="validation-failed"' : ''}>
              <li>
                <input type="hidden" name="_reglementInterieur" /><!-- Grails 1.2.x convention to bind checkboxes. -->
                <input type="checkbox" id="reglementInterieur" name="reglementInterieur"
                       class="required  validate-acceptance"
                       title="${message(code:'sisgr.property.reglementInterieur.validationError')}"
                       ${rqt.reglementInterieur ? 'checked="checked"' : ''} value="true" />
                <label for="reglementInterieur" class="required">
                  ${message(code:'sisgr.property.reglementInterieur.label')}*
                  <g:if test="${availableRules.contains('reglementInterieur')}">
                  <a target="_blank"
                     href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'reglementInterieur']).encodeAsXML()}">
                    <span>${message(code:'request.action.consult.rules')}</span>
                  </a>
                  </g:if>
                  <span>${message(code:'sisgr.property.reglementInterieur.help')}</span>
                </label>
              </li>
            </ul>
            

  

