


  
    
            <label for="subjectId" class="required">
              <g:message code="request.property.subject.label" /> *
              <span><g:message code="request.property.subject.help" /></span>
              <g:if test="${rqt.stepStates[currentStep].state != 'complete'}">
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
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['registration'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="rarr.property.recreationActivity.label" /> *  <span><g:message code="rarr.property.recreationActivity.help" /></span></label>
            <g:set var="recreationActivityIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'recreationActivity', 'i18nPrefixCode':'rarr.property.recreationActivity', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.recreationActivity.entries, 'depth':0]" />
            

  

  
    <label for="urgencyPhone" class="required"><g:message code="rarr.property.urgencyPhone.label" /> *  <span><g:message code="rarr.property.urgencyPhone.help" /></span></label>
            <input type="text" id="urgencyPhone" name="urgencyPhone" value="${rqt.urgencyPhone?.toString()}" 
                    class="required  validate-phone ${rqt.stepStates['registration'].invalidFields.contains('urgencyPhone') ? 'validation-failed' : ''}" title="<g:message code="rarr.property.urgencyPhone.validationError" />"  maxlength="10" />
            

  

