


  
    
            <label for="subjectId" class="required">
              <g:message code="scssr.property.subject.label" /> *
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
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['subject'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="scssr.property.subjectBirthDate.label" /> *  <span><g:message code="scssr.property.subjectBirthDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthDate') ? 'validation-failed' : ''}"
                id="subjectBirthDate_day"
                name="subjectBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.subjectBirthDate?.date == it
                      || (rqt.subjectBirthDate == null && params['subjectBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthDate') ? 'validation-failed' : ''}"
                id="subjectBirthDate_month"
                name="subjectBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.subjectBirthDate?.month == (it - 1)
                      || (rqt.subjectBirthDate == null && params['subjectBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthDate') ? 'validation-failed' : ''}"
                id="subjectBirthDate_year"
                name="subjectBirthDate_year"
                value="${rqt.subjectBirthDate ? rqt.subjectBirthDate.year + 1900 : params['subjectBirthDate_year']}"
                title="<g:message code="scssr.property.subjectBirthDate.validationError" />" />
            </div>
            

  

  
    <label class="required"><g:message code="scssr.property.subjectDomiciliationDate.label" /> *  <span><g:message code="scssr.property.subjectDomiciliationDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['subject'].invalidFields.contains('subjectDomiciliationDate') ? 'validation-failed' : ''}"
                id="subjectDomiciliationDate_day"
                name="subjectDomiciliationDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.subjectDomiciliationDate?.date == it
                      || (rqt.subjectDomiciliationDate == null && params['subjectDomiciliationDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['subject'].invalidFields.contains('subjectDomiciliationDate') ? 'validation-failed' : ''}"
                id="subjectDomiciliationDate_month"
                name="subjectDomiciliationDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.subjectDomiciliationDate?.month == (it - 1)
                      || (rqt.subjectDomiciliationDate == null && params['subjectDomiciliationDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['subject'].invalidFields.contains('subjectDomiciliationDate') ? 'validation-failed' : ''}"
                id="subjectDomiciliationDate_year"
                name="subjectDomiciliationDate_year"
                value="${rqt.subjectDomiciliationDate ? rqt.subjectDomiciliationDate.year + 1900 : params['subjectDomiciliationDate_year']}"
                title="<g:message code="scssr.property.subjectDomiciliationDate.validationError" />" />
            </div>
            

  

  
    <label class="required"><g:message code="scssr.property.isOtherSituation.label" /> *  <span><g:message code="scssr.property.isOtherSituation.help" /></span></label>
            <ul class="required ${rqt.stepStates['subject'].invalidFields.contains('isOtherSituation') ? 'validation-failed' : ''}">
              <g:each in="${['TENANT','FREE_HOUSED','OTHER_SITUATION']}">
              <li>
                <input type="radio" id="isOtherSituation_${it}" class="required condition-isOtherSituation-trigger  validate-one-required" value="${it}" name="isOtherSituation" ${it == rqt.isOtherSituation.toString() ? 'checked="checked"': ''} title="<g:message code="scssr.property.isOtherSituation.validationError" />" />
                <label for="isOtherSituation_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="scssr.property.isOtherSituation" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="saintOuenOtherSituationDetails" class="required condition-isOtherSituation-filled"><g:message code="scssr.property.saintOuenOtherSituationDetails.label" /> *  <span><g:message code="scssr.property.saintOuenOtherSituationDetails.help" /></span></label>
            <input type="text" id="saintOuenOtherSituationDetails" name="saintOuenOtherSituationDetails" value="${rqt.saintOuenOtherSituationDetails?.toString()}" 
                    class="required condition-isOtherSituation-filled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('saintOuenOtherSituationDetails') ? 'validation-failed' : ''}" title="<g:message code="scssr.property.saintOuenOtherSituationDetails.validationError" />"   />
            

  

