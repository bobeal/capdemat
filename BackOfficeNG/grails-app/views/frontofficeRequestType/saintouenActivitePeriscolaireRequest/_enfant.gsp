


  
    
            <label for="subjectId" class="required">
              <g:message code="sapr.property.subject.label" /> *
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
            

  

  
    <label class="required"><g:message code="sapr.property.ecoleInscription.label" /> *  <span><g:message code="sapr.property.ecoleInscription.help" /></span></label>
            <ul class="required ${rqt.stepStates['enfant'].invalidFields.contains('ecoleInscription') ? 'validation-failed' : ''}">
              <g:each in="${['ECOLE_SAINTOUEN','COLLEGE','ECOLE_PRIVEE','ECOLE_HORS_SAINTOUEN']}">
              <li>
                <input type="radio" id="ecoleInscription_${it}" class="required  validate-one-required" value="${it}" name="ecoleInscription" ${it == rqt.ecoleInscription.toString() ? 'checked="checked"': ''} title="<g:message code="sapr.property.ecoleInscription.validationError" />" />
                <label for="ecoleInscription_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="sapr.property.ecoleInscription" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="sapr.property.saprEstAllergique.label" /> *  <span><g:message code="sapr.property.saprEstAllergique.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['enfant'].invalidFields.contains('saprEstAllergique') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="saprEstAllergique_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="saprEstAllergique" ${it == rqt.saprEstAllergique ? 'checked="checked"': ''} />
                <label for="saprEstAllergique_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="sapr.property.saprEstHandicapeInvalidant.label" /> *  <span><g:message code="sapr.property.saprEstHandicapeInvalidant.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['enfant'].invalidFields.contains('saprEstHandicapeInvalidant') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="saprEstHandicapeInvalidant_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="saprEstHandicapeInvalidant" ${it == rqt.saprEstHandicapeInvalidant ? 'checked="checked"': ''} />
                <label for="saprEstHandicapeInvalidant_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

