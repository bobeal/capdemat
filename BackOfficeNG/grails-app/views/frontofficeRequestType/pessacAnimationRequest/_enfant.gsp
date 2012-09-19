


  
    
            <label for="subjectId" class="required">
              <g:message code="par.property.subject.label" /> *
              <span><g:message code="request.property.subject.help" /></span>
              <g:if test="${rqt.stepStates[currentStep].state != 'complete' && !rqt.requestType.getStepAccountCompletion()}">
                <g:if test="${!fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_NONE.equals(subjectPolicy)}">
                  <g:if test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_ADULT.equals(subjectPolicy)}">
                    <span>(<a id="addSubjectLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                  </g:if>
                  <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_CHILD.equals(subjectPolicy)}">
                    <span>(<a id="addSubjectLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                  </g:elseif>
                  <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL.equals(subjectPolicy)}">
                    <span>(<a id="addAdultLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addAdult" /></a>
                    <g:message code="message.or" />
                    <a id="addChildLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addChild" /></a>)</span>
                  </g:elseif>
                </g:if>
              </g:if>
            </label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['enfant'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label for="telephoneSujet" class=""><g:message code="par.property.telephoneSujet.label" />   <span><g:message code="par.property.telephoneSujet.help" /></span></label>
            <input type="text" id="telephoneSujet" name="telephoneSujet" value="${rqt.telephoneSujet?.toString()}" 
                    class="  validate-mobilePhone ${rqt.stepStates['enfant'].invalidFields.contains('telephoneSujet') ? 'validation-failed' : ''}" title="<g:message code="par.property.telephoneSujet.validationError" />"  maxlength="10" />
            

  

  
    <label for="emailSujet" class=""><g:message code="par.property.emailSujet.label" />   <span><g:message code="par.property.emailSujet.help" /></span></label>
            <input type="text" id="emailSujet" name="emailSujet" value="${rqt.emailSujet?.toString()}" 
                    class="  validate-email ${rqt.stepStates['enfant'].invalidFields.contains('emailSujet') ? 'validation-failed' : ''}" title="<g:message code="par.property.emailSujet.validationError" />"   />
            

  

  
    
              <label class="">
                <g:message code="par.property.acceptationReglementInterieur.label" /> 
                <g:if test="${availableRules.contains('acceptationReglementInterieur')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'acceptationReglementInterieur']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="par.property.acceptationReglementInterieur.help" /></span>
              </label>
              <ul class="yes-no  ${rqt.stepStates['enfant'].invalidFields.contains('acceptationReglementInterieur') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="acceptationReglementInterieur_${it ? 'yes' : 'no'}" class="  " title="" value="${it}" name="acceptationReglementInterieur" ${it == rqt.acceptationReglementInterieur ? 'checked="checked"': ''} />
                    <label for="acceptationReglementInterieur_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

