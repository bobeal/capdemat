


  
    
            <label for="subjectId" class="required">
              <g:message code="scjar.property.subject.label" /> *
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
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['sujet'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="scjar.property.dateNaissance.label" /> *  <span><g:message code="scjar.property.dateNaissance.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['sujet'].invalidFields.contains('dateNaissance') ? 'validation-failed' : ''}"
                id="dateNaissance_day"
                name="dateNaissance_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.dateNaissance?.date == it
                      || (rqt.dateNaissance == null && params['dateNaissance_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['sujet'].invalidFields.contains('dateNaissance') ? 'validation-failed' : ''}"
                id="dateNaissance_month"
                name="dateNaissance_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.dateNaissance?.month == (it - 1)
                      || (rqt.dateNaissance == null && params['dateNaissance_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['sujet'].invalidFields.contains('dateNaissance') ? 'validation-failed' : ''}"
                id="dateNaissance_year"
                name="dateNaissance_year"
                value="${rqt.dateNaissance ? rqt.dateNaissance.year + 1900 : params['dateNaissance_year']}"
                title="<g:message code="scjar.property.dateNaissance.validationError" />" />
            </div>
            

  

  
    <label class="required"><g:message code="scjar.property.sexe.label" /> *  <span><g:message code="scjar.property.sexe.help" /></span></label>
            <ul class="required ${rqt.stepStates['sujet'].invalidFields.contains('sexe') ? 'validation-failed' : ''}">
              <g:each in="${['MALE','FEMALE']}">
              <li>
                <input type="radio" id="sexe_${it}" class="required  validate-one-required" value="${it}" name="sexe" ${it == rqt.sexe.toString() ? 'checked="checked"': ''} title="<g:message code="scjar.property.sexe.validationError" />" />
                <label for="sexe_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="scjar.property.sexe" /></label>
              </li>
              </g:each>
            </ul>
            

  

