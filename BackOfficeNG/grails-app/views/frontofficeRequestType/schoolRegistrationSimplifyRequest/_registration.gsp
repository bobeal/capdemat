


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="srsr.property.section.label" /> *  <span><g:message code="srsr.property.section.help" /></span></label>
            <g:set var="sectionIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'section', 'i18nPrefixCode':'srsr.property.section', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.section.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="srsr.property.existRegistration.label" /> *  <span><g:message code="srsr.property.existRegistration.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['registration']?.invalidFields?.contains('existRegistration') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="existRegistration_${it ? 'yes' : 'no'}" class="required condition-isExistRegistration-trigger  validate-one-required boolean" title="" value="${it}" name="existRegistration" ${it == rqt.existRegistration ? 'checked="checked"': ''} />
                <label for="existRegistration_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="currentSchoolName" class="required condition-isExistRegistration-filled"><g:message code="srsr.property.currentSchoolName.label" /> *  <span><g:message code="srsr.property.currentSchoolName.help" /></span></label>
            <input type="text" id="currentSchoolName" name="currentSchoolName" value="${rqt.currentSchoolName?.toString()}" 
                    class="required condition-isExistRegistration-filled  validate-string ${stepStates != null && stepStates['registration']?.invalidFields?.contains('currentSchoolName') ? 'validation-failed' : ''}" title="<g:message code="srsr.property.currentSchoolName.validationError" />"   />
            

  

  
    <label for="currentSchoolAddress" class="required condition-isExistRegistration-filled"><g:message code="srsr.property.currentSchoolAddress.label" /> *  <span><g:message code="srsr.property.currentSchoolAddress.help" /></span></label>
            <textarea id="currentSchoolAddress" name="currentSchoolAddress" class="required condition-isExistRegistration-filled  validate-textarea ${stepStates != null && stepStates['registration']?.invalidFields?.contains('currentSchoolAddress') ? 'validation-failed' : ''}" title="<g:message code="srsr.property.currentSchoolAddress.validationError" />" rows="3" cols=""  >${rqt.currentSchoolAddress}</textarea>
            

  

  
    <label for="currentSchoolLevel" class="required condition-isExistRegistration-filled"><g:message code="srsr.property.currentSchoolLevel.label" /> *  <span><g:message code="srsr.property.currentSchoolLevel.help" /></span></label>
            <input type="text" id="currentSchoolLevel" name="currentSchoolLevel" value="${rqt.currentSchoolLevel?.toString()}" 
                    class="required condition-isExistRegistration-filled  validate-string ${stepStates != null && stepStates['registration']?.invalidFields?.contains('currentSchoolLevel') ? 'validation-failed' : ''}" title="<g:message code="srsr.property.currentSchoolLevel.validationError" />"   />
            

  

  
    <label for="emergencyContactName" class="required"><g:message code="srsr.property.emergencyContactName.label" /> *  <span><g:message code="srsr.property.emergencyContactName.help" /></span></label>
            <input type="text" id="emergencyContactName" name="emergencyContactName" value="${rqt.emergencyContactName?.toString()}" 
                    class="required  validate-string ${stepStates != null && stepStates['registration']?.invalidFields?.contains('emergencyContactName') ? 'validation-failed' : ''}" title="<g:message code="srsr.property.emergencyContactName.validationError" />"   />
            

  

  
    <label for="emergencyPhone" class="required"><g:message code="srsr.property.emergencyPhone.label" /> *  <span><g:message code="srsr.property.emergencyPhone.help" /></span></label>
            <input type="text" id="emergencyPhone" name="emergencyPhone" value="${rqt.emergencyPhone?.toString()}" 
                    class="required  validate-string ${stepStates != null && stepStates['registration']?.invalidFields?.contains('emergencyPhone') ? 'validation-failed' : ''}" title="<g:message code="srsr.property.emergencyPhone.validationError" />"  maxlength="10" />
            

  

