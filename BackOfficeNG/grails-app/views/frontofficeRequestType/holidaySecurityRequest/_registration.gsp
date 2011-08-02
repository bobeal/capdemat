


  
    
            <label for="subjectId" class="required">
              <g:message code="hsr.property.subject.label" /> *
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
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first autofill-subjectMobilePhone-trigger ${rqt.stepStates['registration'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="hsr.property.absenceStartDate.label" /> *  <span><g:message code="hsr.property.absenceStartDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['registration'].invalidFields.contains('absenceStartDate') ? 'validation-failed' : ''}"
                id="absenceStartDate_day"
                name="absenceStartDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.absenceStartDate?.date == it
                      || (rqt.absenceStartDate == null && params['absenceStartDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['registration'].invalidFields.contains('absenceStartDate') ? 'validation-failed' : ''}"
                id="absenceStartDate_month"
                name="absenceStartDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.absenceStartDate?.month == (it - 1)
                      || (rqt.absenceStartDate == null && params['absenceStartDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['registration'].invalidFields.contains('absenceStartDate') ? 'validation-failed' : ''}"
                id="absenceStartDate_year"
                name="absenceStartDate_year"
                value="${rqt.absenceStartDate ? rqt.absenceStartDate.year + 1900 : params['absenceStartDate_year']}"
                title="<g:message code="hsr.property.absenceStartDate.validationError" />" />
            </div>
            

  

  
    <label class="required"><g:message code="hsr.property.absenceEndDate.label" /> *  <span><g:message code="hsr.property.absenceEndDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['registration'].invalidFields.contains('absenceEndDate') ? 'validation-failed' : ''}"
                id="absenceEndDate_day"
                name="absenceEndDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.absenceEndDate?.date == it
                      || (rqt.absenceEndDate == null && params['absenceEndDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['registration'].invalidFields.contains('absenceEndDate') ? 'validation-failed' : ''}"
                id="absenceEndDate_month"
                name="absenceEndDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.absenceEndDate?.month == (it - 1)
                      || (rqt.absenceEndDate == null && params['absenceEndDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['registration'].invalidFields.contains('absenceEndDate') ? 'validation-failed' : ''}"
                id="absenceEndDate_year"
                name="absenceEndDate_year"
                value="${rqt.absenceEndDate ? rqt.absenceEndDate.year + 1900 : params['absenceEndDate_year']}"
                title="<g:message code="hsr.property.absenceEndDate.validationError" />" />
            </div>
            

  

