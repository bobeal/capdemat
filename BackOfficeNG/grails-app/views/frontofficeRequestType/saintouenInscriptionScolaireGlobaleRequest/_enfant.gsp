


  
    
            <label for="subjectId" class="required">
              <g:message code="sisgr.property.subject.label" /> *
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
            

  

  
    <fieldset class="required">
    <legend><g:message code="sisgr.property.ecoleSecteur.label" /></legend>
    
      <label for="idEcoleSecteur" class="required"><g:message code="sisgr.property.idEcoleSecteur.label" /> *  <span><g:message code="sisgr.property.idEcoleSecteur.help" /></span></label>
            <input type="text" id="idEcoleSecteur" name="idEcoleSecteur" value="${rqt.idEcoleSecteur?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('idEcoleSecteur') ? 'validation-failed' : ''}" title="<g:message code="sisgr.property.idEcoleSecteur.validationError" />"   />
            

    
      <label for="labelEcoleSecteur" class="required"><g:message code="sisgr.property.labelEcoleSecteur.label" /> *  <span><g:message code="sisgr.property.labelEcoleSecteur.help" /></span></label>
            <input type="text" id="labelEcoleSecteur" name="labelEcoleSecteur" value="${rqt.labelEcoleSecteur?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('labelEcoleSecteur') ? 'validation-failed' : ''}" title="<g:message code="sisgr.property.labelEcoleSecteur.validationError" />"   />
            

    
    </fieldset>
  

  
    <label class="required"><g:message code="sisgr.property.estAllergique.label" /> *  <span><g:message code="sisgr.property.estAllergique.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['enfant'].invalidFields.contains('estAllergique') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estAllergique_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="estAllergique" ${it == rqt.estAllergique ? 'checked="checked"': ''} />
                <label for="estAllergique_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="sisgr.property.estHandicapeInvalidant.label" /> *  <span><g:message code="sisgr.property.estHandicapeInvalidant.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['enfant'].invalidFields.contains('estHandicapeInvalidant') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estHandicapeInvalidant_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="estHandicapeInvalidant" ${it == rqt.estHandicapeInvalidant ? 'checked="checked"': ''} />
                <label for="estHandicapeInvalidant_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

