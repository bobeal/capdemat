


  
    
            <label for="subjectId" class="required">
              <g:message code="request.property.subject.label" /> *
              <span><g:message code="request.property.subject.help" /></span>
              <g:if test="${!fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_NONE.equals(subjectPolicy)}">
                <span>(<g:message code="request.message.addSubject" />
                <g:if test="${[fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL, fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_ADULT].contains(subjectPolicy)}">
                  <a href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}">
                    <g:message code="homeFolder.action.addAdult" /></a>
                </g:if>
                <g:if test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL.equals(subjectPolicy)}">
                  <g:message code="message.or" />
                </g:if>
                <g:if test="${[fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL, fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_CHILD].contains(subjectPolicy)}">
                  <a href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}">
                    <g:message code="homeFolder.action.addChild" /></a>
                </g:if>
                )</span>
              </g:if>
            </label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['registration'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="parr.property.perischoolActivity.label" /> *  <span><g:message code="parr.property.perischoolActivity.help" /></span></label>
            <g:set var="perischoolActivityIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'perischoolActivity', 'i18nPrefixCode':'parr.property.perischoolActivity', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.perischoolActivity.entries, 'depth':0]" />
            

  

  
    <label for="urgencyPhone" class="required"><g:message code="parr.property.urgencyPhone.label" /> *  <span><g:message code="parr.property.urgencyPhone.help" /></span></label>
            <input type="text" id="urgencyPhone" name="urgencyPhone" value="${rqt.urgencyPhone?.toString()}" 
                    class="required  validate-phone ${rqt.stepStates['registration'].invalidFields.contains('urgencyPhone') ? 'validation-failed' : ''}" title="<g:message code="parr.property.urgencyPhone.validationError" />"  maxlength="10" />
            

  

