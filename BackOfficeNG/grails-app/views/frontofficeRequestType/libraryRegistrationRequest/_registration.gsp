


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['registration'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            <g:if test="${[fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL, fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_ADULT].contains(subjectPolicy)}">
              <a href="${createLink(controller : 'frontofficeHomeFolder', action : 'adult', params : ['mode' : 'edit', 'requestId' : rqt.id])}">
                <g:message code="homeFolder.action.addAdult" />
              </a>
            </g:if>
            <g:if test="${[fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL, fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_CHILD].contains(subjectPolicy)}">
              <a href="${createLink(controller : 'frontofficeHomeFolder', action : 'child', params : ['mode' : 'edit', 'requestId' : rqt.id])}">
                <g:message code="homeFolder.action.addChild" />
              </a>
            </g:if>
            

  

  
    <label class="required"><g:message code="lrr.property.subscription.label" /> *  <span><g:message code="lrr.property.subscription.help" /></span></label>
            <g:set var="subscriptionIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'subscription', 'i18nPrefixCode':'lrr.property.subscription', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.subscription.entries, 'depth':0]" />
            

  

  
    <label for="registrationNumber" class=""><g:message code="lrr.property.registrationNumber.label" />   <span><g:message code="lrr.property.registrationNumber.help" /></span></label>
            <input type="text" id="registrationNumber" name="registrationNumber" value="${rqt.registrationNumber?.toString()}" 
                    class="  validate-string ${rqt.stepStates['registration'].invalidFields.contains('registrationNumber') ? 'validation-failed' : ''}" title="<g:message code="lrr.property.registrationNumber.validationError" />"   />
            

  

