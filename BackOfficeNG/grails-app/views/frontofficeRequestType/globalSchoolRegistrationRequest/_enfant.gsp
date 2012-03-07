


  
    
            <label for="subjectId" class="required">
              <g:message code="gsrr.property.subject.label" /> *
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
            

  

  
    <label class="required"><g:message code="gsrr.property.estDerogation.label" /> *  <span><g:message code="gsrr.property.estDerogation.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['enfant'].invalidFields.contains('estDerogation') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estDerogation_${it ? 'yes' : 'no'}" class="required condition-estDerogation-trigger  validate-one-required boolean" title="" value="${it}" name="estDerogation" ${it == rqt.estDerogation ? 'checked="checked"': ''} />
                <label for="estDerogation_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="required condition-estDerogation-filled">
    <legend><g:message code="gsrr.property.ecoleDerogation.label" /></legend>
    
      <label for="idEcoleDerog" class="required"><g:message code="gsrr.property.idEcoleDerog.label" /> *  <span><g:message code="gsrr.property.idEcoleDerog.help" /></span></label>
            <input type="text" id="idEcoleDerog" name="idEcoleDerog" value="${rqt.idEcoleDerog?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('idEcoleDerog') ? 'validation-failed' : ''}" title="<g:message code="gsrr.property.idEcoleDerog.validationError" />"   />
            

    
      <label for="labelEcoleDerog" class="required"><g:message code="gsrr.property.labelEcoleDerog.label" /> *  <span><g:message code="gsrr.property.labelEcoleDerog.help" /></span></label>
            <input type="text" id="labelEcoleDerog" name="labelEcoleDerog" value="${rqt.labelEcoleDerog?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('labelEcoleDerog') ? 'validation-failed' : ''}" title="<g:message code="gsrr.property.labelEcoleDerog.validationError" />"   />
            

    
    </fieldset>
  

  
    <label class="required condition-estDerogation-filled"><g:message code="gsrr.property.motifsDerogationEcole.label" /> *  <span><g:message code="gsrr.property.motifsDerogationEcole.help" /></span></label>
            <g:set var="motifsDerogationEcoleIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'motifsDerogationEcole', 'i18nPrefixCode':'gsrr.property.motifsDerogationEcole', 'htmlClass':'required condition-estDerogation-filled  ', 
                              'lrEntries': lrTypes.motifsDerogationEcole.entries, 'depth':0]" />
            

  

  
    <label for="informationsComplementairesDerogation" class="condition-estDerogation-filled"><g:message code="gsrr.property.informationsComplementairesDerogation.label" />   <span><g:message code="gsrr.property.informationsComplementairesDerogation.help" /></span></label>
            <textarea id="informationsComplementairesDerogation" name="informationsComplementairesDerogation" class="condition-estDerogation-filled  validate-regex ${rqt.stepStates['enfant'].invalidFields.contains('informationsComplementairesDerogation') ? 'validation-failed' : ''}" title="<g:message code="gsrr.property.informationsComplementairesDerogation.validationError" />" rows="10" cols="" regex="^[\w\W]{0,1024}$" maxlength="1024">${rqt.informationsComplementairesDerogation}</textarea>
            

  

  
    <fieldset class="required condition-estDerogation-unfilled">
    <legend><g:message code="gsrr.property.ecoleSecteur.label" /></legend>
    
      <label for="idEcoleSecteur" class="required"><g:message code="gsrr.property.idEcoleSecteur.label" /> *  <span><g:message code="gsrr.property.idEcoleSecteur.help" /></span></label>
            <input type="text" id="idEcoleSecteur" name="idEcoleSecteur" value="${rqt.idEcoleSecteur?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('idEcoleSecteur') ? 'validation-failed' : ''}" title="<g:message code="gsrr.property.idEcoleSecteur.validationError" />"   />
            

    
      <label for="labelEcoleSecteur" class="required"><g:message code="gsrr.property.labelEcoleSecteur.label" /> *  <span><g:message code="gsrr.property.labelEcoleSecteur.help" /></span></label>
            <input type="text" id="labelEcoleSecteur" name="labelEcoleSecteur" value="${rqt.labelEcoleSecteur?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('labelEcoleSecteur') ? 'validation-failed' : ''}" title="<g:message code="gsrr.property.labelEcoleSecteur.validationError" />"   />
            

    
    </fieldset>
  

