


  
    
            <label for="subjectId" class="required">
              <g:message code="lcrr.property.subject.label" /> *
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
            

  

  
    <label class="required"><g:message code="lcrr.property.estDerogation.label" /> *  <span><g:message code="lcrr.property.estDerogation.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['enfant'].invalidFields.contains('estDerogation') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estDerogation_${it ? 'yes' : 'no'}" class="required condition-estDerogation-trigger  validate-one-required boolean" title="" value="${it}" name="estDerogation" ${it == rqt.estDerogation ? 'checked="checked"': ''} />
                <label for="estDerogation_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required condition-estDerogation-filled"><g:message code="lcrr.property.motifsDerogationCentreLoisirs.label" /> *  <span><g:message code="lcrr.property.motifsDerogationCentreLoisirs.help" /></span></label>
            <g:set var="motifsDerogationCentreLoisirsIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'motifsDerogationCentreLoisirs', 'i18nPrefixCode':'lcrr.property.motifsDerogationCentreLoisirs', 'htmlClass':'required condition-estDerogation-filled  ', 
                              'lrEntries': lrTypes.motifsDerogationCentreLoisirs.entries, 'depth':0]" />
            

  

  
    <fieldset class="required">
    <legend><g:message code="lcrr.property.centresLoisirs.label" /></legend>
    
      <label for="idCentreLoisirs" class="required"><g:message code="lcrr.property.idCentreLoisirs.label" /> *  <span><g:message code="lcrr.property.idCentreLoisirs.help" /></span></label>
            <input type="text" id="idCentreLoisirs" name="idCentreLoisirs" value="${rqt.idCentreLoisirs?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('idCentreLoisirs') ? 'validation-failed' : ''}" title="<g:message code="lcrr.property.idCentreLoisirs.validationError" />"   />
            

    
      <label for="labelCentreLoisirs" class="required"><g:message code="lcrr.property.labelCentreLoisirs.label" /> *  <span><g:message code="lcrr.property.labelCentreLoisirs.help" /></span></label>
            <input type="text" id="labelCentreLoisirs" name="labelCentreLoisirs" value="${rqt.labelCentreLoisirs?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('labelCentreLoisirs') ? 'validation-failed' : ''}" title="<g:message code="lcrr.property.labelCentreLoisirs.validationError" />"   />
            

    
    </fieldset>
  

  
    <label class="required"><g:message code="lcrr.property.estTransport.label" /> *  <span><g:message code="lcrr.property.estTransport.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['enfant'].invalidFields.contains('estTransport') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estTransport_${it ? 'yes' : 'no'}" class="required condition-estTransport-trigger  validate-one-required boolean" title="" value="${it}" name="estTransport" ${it == rqt.estTransport ? 'checked="checked"': ''} />
                <label for="estTransport_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="required condition-estTransport-filled">
    <legend><g:message code="lcrr.property.transports.label" /></legend>
    
      <label for="idLigne" class="required"><g:message code="lcrr.property.idLigne.label" /> *  <span><g:message code="lcrr.property.idLigne.help" /></span></label>
            <input type="text" id="idLigne" name="idLigne" value="${rqt.idLigne?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('idLigne') ? 'validation-failed' : ''}" title="<g:message code="lcrr.property.idLigne.validationError" />"   />
            

    
      <label for="labelLigne" class="required"><g:message code="lcrr.property.labelLigne.label" /> *  <span><g:message code="lcrr.property.labelLigne.help" /></span></label>
            <input type="text" id="labelLigne" name="labelLigne" value="${rqt.labelLigne?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('labelLigne') ? 'validation-failed' : ''}" title="<g:message code="lcrr.property.labelLigne.validationError" />"   />
            

    
      <label for="idArret" class="required"><g:message code="lcrr.property.idArret.label" /> *  <span><g:message code="lcrr.property.idArret.help" /></span></label>
            <input type="text" id="idArret" name="idArret" value="${rqt.idArret?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('idArret') ? 'validation-failed' : ''}" title="<g:message code="lcrr.property.idArret.validationError" />"   />
            

    
      <label for="labelArret" class="required"><g:message code="lcrr.property.labelArret.label" /> *  <span><g:message code="lcrr.property.labelArret.help" /></span></label>
            <input type="text" id="labelArret" name="labelArret" value="${rqt.labelArret?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('labelArret') ? 'validation-failed' : ''}" title="<g:message code="lcrr.property.labelArret.validationError" />"   />
            

    
    </fieldset>
  

