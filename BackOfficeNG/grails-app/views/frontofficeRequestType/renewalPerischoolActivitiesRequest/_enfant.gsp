


  
    
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
            

  

  
    <label class="required"><g:message code="rpar.property.estRestauration.label" /> *  <span><g:message code="rpar.property.estRestauration.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['enfant'].invalidFields.contains('estRestauration') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estRestauration_${it ? 'yes' : 'no'}" class="required condition-estRestauration-trigger  validate-one-required boolean" title="" value="${it}" name="estRestauration" ${it == rqt.estRestauration ? 'checked="checked"': ''} />
                <label for="estRestauration_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required condition-estRestauration-filled"><g:message code="rpar.property.regimeAlimentaireRenouvellement.label" /> *  <span><g:message code="rpar.property.regimeAlimentaireRenouvellement.help" /></span></label>
            <g:set var="regimeAlimentaireRenouvellementIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'regimeAlimentaireRenouvellement', 'i18nPrefixCode':'rpar.property.regimeAlimentaireRenouvellement', 'htmlClass':'required condition-estRestauration-filled  ', 
                              'lrEntries': lrTypes.regimeAlimentaireRenouvellement.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="rpar.property.estPeriscolaire.label" /> *  <span><g:message code="rpar.property.estPeriscolaire.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['enfant'].invalidFields.contains('estPeriscolaire') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estPeriscolaire_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="estPeriscolaire" ${it == rqt.estPeriscolaire ? 'checked="checked"': ''} />
                <label for="estPeriscolaire_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

