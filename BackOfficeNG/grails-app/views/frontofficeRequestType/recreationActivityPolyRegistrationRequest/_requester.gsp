


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${stepStates != null && stepStates['requester']?.invalidFields?.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="raprr.property.recreationPolyActivity.label" /> *  <span><g:message code="raprr.property.recreationPolyActivity.help" /></span></label>
            <g:set var="recreationPolyActivityIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'recreationPolyActivity', 'i18nPrefixCode':'raprr.property.recreationPolyActivity', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.recreationPolyActivity.entries, 'depth':0]" />
            

  

  
    <label for="urgencyPolyPhone" class="required"><g:message code="raprr.property.urgencyPolyPhone.label" /> *  <span><g:message code="raprr.property.urgencyPolyPhone.help" /></span></label>
            <input type="text" id="urgencyPolyPhone" name="urgencyPolyPhone" value="${rqt.urgencyPolyPhone?.toString()}" 
                    class="required  validate-phone ${stepStates != null && stepStates['requester']?.invalidFields?.contains('urgencyPolyPhone') ? 'validation-failed' : ''}" title="<g:message code="raprr.property.urgencyPolyPhone.validationError" />"  maxlength="10" />
            

  

