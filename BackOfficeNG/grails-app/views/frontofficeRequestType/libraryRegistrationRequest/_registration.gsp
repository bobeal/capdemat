


  
    
            <label for="subjectId" class="required">
              <g:message code="request.property.subject.label" /> *
              <span><g:message code="request.property.subject.help" /></span>
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
            </label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['registration'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="lrr.property.subscription.label" /> *  <span><g:message code="lrr.property.subscription.help" /></span></label>
            <g:set var="subscriptionIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'subscription', 'i18nPrefixCode':'lrr.property.subscription', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.subscription.entries, 'depth':0]" />
            

  

  
    <label for="registrationNumber" class=""><g:message code="lrr.property.registrationNumber.label" />   <span><g:message code="lrr.property.registrationNumber.help" /></span></label>
            <input type="text" id="registrationNumber" name="registrationNumber" value="${rqt.registrationNumber?.toString()}" 
                    class="  validate-string ${rqt.stepStates['registration'].invalidFields.contains('registrationNumber') ? 'validation-failed' : ''}" title="<g:message code="lrr.property.registrationNumber.validationError" />"   />
            

  

