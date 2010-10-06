


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label for="section" class="required"><g:message code="srr.property.section.label" /> *  <span><g:message code="srr.property.section.help" /></span></label>
            <select id="section" name="section" class="required  validate-not-first ${stepStates != null && stepStates['registration']?.invalidFields?.contains('section') ? 'validation-failed' : ''}" title="<g:message code="srr.property.section.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['BeforeFirstSection','FirstSection','SecondSection','ThirdSection','CP','CE1','CE2','CM1','CM2','CLISS','Unknown']}">
                <option value="fr.cg95.cvq.business.users.SectionType_${it}" ${it == rqt.section?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="srr.property.section" /></option>
              </g:each>
            </select>
            

  

  
    <label for="urgencyPhone" class="required"><g:message code="srr.property.urgencyPhone.label" /> *  <span><g:message code="srr.property.urgencyPhone.help" /></span></label>
            <input type="text" id="urgencyPhone" name="urgencyPhone" value="${rqt.urgencyPhone?.toString()}" 
                    class="required  validate-phone ${stepStates != null && stepStates['registration']?.invalidFields?.contains('urgencyPhone') ? 'validation-failed' : ''}" title="<g:message code="srr.property.urgencyPhone.validationError" />"  maxlength="10" />
            

  

  
    <fieldset class="required">
    <legend><g:message code="srr.property.currentSchool.label" /></legend>
    
      <label for="currentSchoolName" class=""><g:message code="srr.property.currentSchoolName.label" />   <span><g:message code="srr.property.currentSchoolName.help" /></span></label>
            <input type="text" id="currentSchoolName" name="currentSchoolName" value="${rqt.currentSchoolName?.toString()}" 
                    class="  validate-string ${stepStates != null && stepStates['registration']?.invalidFields?.contains('currentSchoolName') ? 'validation-failed' : ''}" title="<g:message code="srr.property.currentSchoolName.validationError" />"   />
            

    
      <label for="currentSchoolAddress" class=""><g:message code="srr.property.currentSchoolAddress.label" />   <span><g:message code="srr.property.currentSchoolAddress.help" /></span></label>
            <textarea id="currentSchoolAddress" name="currentSchoolAddress" class="  validate-textarea ${stepStates != null && stepStates['registration']?.invalidFields?.contains('currentSchoolAddress') ? 'validation-failed' : ''}" title="<g:message code="srr.property.currentSchoolAddress.validationError" />" rows="3" cols=""  >${rqt.currentSchoolAddress}</textarea>
            

    
      <label for="currentSection" class=""><g:message code="srr.property.currentSection.label" />   <span><g:message code="srr.property.currentSection.help" /></span></label>
            <select id="currentSection" name="currentSection" class="  validate-select ${stepStates != null && stepStates['registration']?.invalidFields?.contains('currentSection') ? 'validation-failed' : ''}" title="<g:message code="srr.property.currentSection.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['BeforeFirstSection','FirstSection','SecondSection','ThirdSection','CP','CE1','CE2','CM1','CM2','CLISS','Unknown']}">
                <option value="fr.cg95.cvq.business.users.SectionType_${it}" ${it == rqt.currentSection?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="srr.property.currentSection" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

