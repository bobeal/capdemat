


  
    <label class="required"><g:message code="sapr.property.saprEstRestauration.label" /> *  <span><g:message code="sapr.property.saprEstRestauration.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['activites'].invalidFields.contains('saprEstRestauration') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="saprEstRestauration_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="saprEstRestauration" ${it == rqt.saprEstRestauration ? 'checked="checked"': ''} />
                <label for="saprEstRestauration_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="required">
    <legend><g:message code="sapr.property.saprInscriptionPeriscolaire.label" /></legend>
    
      <label class="required"><g:message code="sapr.property.saprAccueilMatin.label" /> *  <span><g:message code="sapr.property.saprAccueilMatin.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['activites'].invalidFields.contains('saprAccueilMatin') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="saprAccueilMatin_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="saprAccueilMatin" ${it == rqt.saprAccueilMatin ? 'checked="checked"': ''} />
                <label for="saprAccueilMatin_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="sapr.property.saprAccueilSoir.label" /> *  <span><g:message code="sapr.property.saprAccueilSoir.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['activites'].invalidFields.contains('saprAccueilSoir') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="saprAccueilSoir_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="saprAccueilSoir" ${it == rqt.saprAccueilSoir ? 'checked="checked"': ''} />
                <label for="saprAccueilSoir_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="sapr.property.saprAccueilMercrediEtVacances.label" /> *  <span><g:message code="sapr.property.saprAccueilMercrediEtVacances.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['activites'].invalidFields.contains('saprAccueilMercrediEtVacances') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="saprAccueilMercrediEtVacances_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="saprAccueilMercrediEtVacances" ${it == rqt.saprAccueilMercrediEtVacances ? 'checked="checked"': ''} />
                <label for="saprAccueilMercrediEtVacances_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="sapr.property.saprEtudesSurveillees.label" /> *  <span><g:message code="sapr.property.saprEtudesSurveillees.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['activites'].invalidFields.contains('saprEtudesSurveillees') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="saprEtudesSurveillees_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="saprEtudesSurveillees" ${it == rqt.saprEtudesSurveillees ? 'checked="checked"': ''} />
                <label for="saprEtudesSurveillees_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    
            <ul ${rqt.stepStates['activites'].invalidFields.contains('saprReglementInterieur') ? 'class="validation-failed"' : ''}>
              <li>
                <input type="hidden" name="_saprReglementInterieur" /><!-- Grails 1.2.x convention to bind checkboxes. -->
                <input type="checkbox" id="saprReglementInterieur" name="saprReglementInterieur"
                       class="required  validate-acceptance"
                       title="${message(code:'sapr.property.saprReglementInterieur.validationError')}"
                       ${rqt.saprReglementInterieur ? 'checked="checked"' : ''} value="true" />
                <label for="saprReglementInterieur" class="required">
                  ${message(code:'sapr.property.saprReglementInterieur.label')}*
                  <g:if test="${availableRules.contains('saprReglementInterieur')}">
                  <a target="_blank"
                     href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'saprReglementInterieur']).encodeAsXML()}">
                    <span>${message(code:'request.action.consult.rules')}</span>
                  </a>
                  </g:if>
                  <span>${message(code:'sapr.property.saprReglementInterieur.help')}</span>
                </label>
              </li>
            </ul>
            

  

