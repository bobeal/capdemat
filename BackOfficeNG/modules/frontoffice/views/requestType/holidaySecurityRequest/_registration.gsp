


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first autofill-subjectMobilePhone-trigger" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label for="absenceStartDate" class="required"><g:message code="hsr.property.absenceStartDate.label" /> *  <span><g:message code="hsr.property.absenceStartDate.help" /></span></label>
            <input type="text" id="absenceStartDate" name="absenceStartDate" value="${formatDate(formatName:'format.date',date:rqt.absenceStartDate)}" 
                   class="required  validate-date" title="<g:message code="hsr.property.absenceStartDate.validationError" />" />
            

  

  
    <label for="absenceEndDate" class="required"><g:message code="hsr.property.absenceEndDate.label" /> *  <span><g:message code="hsr.property.absenceEndDate.help" /></span></label>
            <input type="text" id="absenceEndDate" name="absenceEndDate" value="${formatDate(formatName:'format.date',date:rqt.absenceEndDate)}" 
                   class="required  validate-date" title="<g:message code="hsr.property.absenceEndDate.validationError" />" />
            

  

