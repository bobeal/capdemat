


  
    
            <label for="subjectId" class="required">
              <g:message code="ladrr.property.subject.label" /> *
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
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['subject'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="ladrr.property.atelierEveil.label" /> *  <span><g:message code="ladrr.property.atelierEveil.help" /></span></label>
            <g:set var="atelierEveilIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'atelierEveil', 'i18nPrefixCode':'ladrr.property.atelierEveil', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.atelierEveil.entries, 'depth':0]" />
            

  

  
    <label for="atelierEveilPrecisionChoix" class=""><g:message code="ladrr.property.atelierEveilPrecisionChoix.label" />   <span><g:message code="ladrr.property.atelierEveilPrecisionChoix.help" /></span></label>
            <textarea id="atelierEveilPrecisionChoix" name="atelierEveilPrecisionChoix" class="  validate-regex ${rqt.stepStates['subject'].invalidFields.contains('atelierEveilPrecisionChoix') ? 'validation-failed' : ''}" title="<g:message code="ladrr.property.atelierEveilPrecisionChoix.validationError" />" rows="3" cols="" regex="^[\w\W]{0,255}$" maxlength="255">${rqt.atelierEveilPrecisionChoix}</textarea>
            

  

