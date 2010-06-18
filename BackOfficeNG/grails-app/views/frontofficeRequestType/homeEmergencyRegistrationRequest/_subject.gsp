


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['subject'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
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
            

  

  
    <label class="required"><g:message code="herr.property.dateDepart.label" /> *  <span><g:message code="herr.property.dateDepart.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['subject'].invalidFields.contains('dateDepart') ? 'validation-failed' : ''}"
                id="dateDepart_day"
                name="dateDepart_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.dateDepart?.date == it
                      || (rqt.dateDepart == null && params['dateDepart_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['subject'].invalidFields.contains('dateDepart') ? 'validation-failed' : ''}"
                id="dateDepart_month"
                name="dateDepart_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.dateDepart?.month == (it - 1)
                      || (rqt.dateDepart == null && params['dateDepart_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['subject'].invalidFields.contains('dateDepart') ? 'validation-failed' : ''}"
                id="dateDepart_year"
                name="dateDepart_year"
                value="${rqt.dateDepart ? rqt.dateDepart.year + 1900 : params['dateDepart_year']}"
                title="<g:message code="herr.property.dateDepart.validationError" />" />
            </div>
            

  

  
    <label for="duree" class="required"><g:message code="herr.property.duree.label" /> *  <span><g:message code="herr.property.duree.help" /></span></label>
            <input type="text" id="duree" name="duree" value="${rqt.duree?.toString()}" 
                    class="required  validate-regex ${rqt.stepStates['subject'].invalidFields.contains('duree') ? 'validation-failed' : ''}" title="<g:message code="herr.property.duree.validationError" />" regex="[0-9]{1,2}$" maxlength="2" />
            

  

  
    <label for="telephone" class="required"><g:message code="herr.property.telephone.label" /> *  <span><g:message code="herr.property.telephone.help" /></span></label>
            <input type="text" id="telephone" name="telephone" value="${rqt.telephone?.toString()}" 
                    class="required  validate-phone ${rqt.stepStates['subject'].invalidFields.contains('telephone') ? 'validation-failed' : ''}" title="<g:message code="herr.property.telephone.validationError" />"  maxlength="10" />
            

  

