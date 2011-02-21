


  
    
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
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['enfant'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <fieldset class="required">
    <legend><g:message code="hcrr.property.centreSejours.label" /></legend>
    
      <label for="idCentreSejours" class="required"><g:message code="hcrr.property.idCentreSejours.label" /> *  <span><g:message code="hcrr.property.idCentreSejours.help" /></span></label>
            <input type="text" id="idCentreSejours" name="idCentreSejours" value="${rqt.idCentreSejours?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('idCentreSejours') ? 'validation-failed' : ''}" title="<g:message code="hcrr.property.idCentreSejours.validationError" />"   />
            

    
      <label for="labelCentreSejours" class="required"><g:message code="hcrr.property.labelCentreSejours.label" /> *  <span><g:message code="hcrr.property.labelCentreSejours.help" /></span></label>
            <input type="text" id="labelCentreSejours" name="labelCentreSejours" value="${rqt.labelCentreSejours?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('labelCentreSejours') ? 'validation-failed' : ''}" title="<g:message code="hcrr.property.labelCentreSejours.validationError" />"   />
            

    
    </fieldset>
  

