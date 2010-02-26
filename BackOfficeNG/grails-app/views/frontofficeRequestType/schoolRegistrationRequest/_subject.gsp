


  
    <label class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select name="subjectId" class="required validate-not-first " title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="srr.property.section.label" /> *  <span><g:message code="srr.property.section.help" /></span></label>
            <select name="section" class="required  validate-not-first" title="<g:message code="srr.property.section.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['BeforeFirstSection','FirstSection','SecondSection','ThirdSection','CP','CE1','CE2','CM1','CM2','CLISS','Unknown']}">
                <option value="fr.cg95.cvq.business.users.SectionType_${it}" ${it == rqt.section?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="srr.property.section" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="srr.property.urgencyPhone.label" /> *  <span><g:message code="srr.property.urgencyPhone.help" /></span></label>
            <input type="text" name="urgencyPhone" value="${rqt.urgencyPhone}" 
                    class="required  validate-phone" title="<g:message code="srr.property.urgencyPhone.validationError" />"  maxLength="10"/>
            

  

  
    <fieldset class="required">
    <legend><g:message code="srr.property.currentSchool.label" /></legend>
    
      <label class=""><g:message code="srr.property.currentSchoolName.label" />   <span><g:message code="srr.property.currentSchoolName.help" /></span></label>
            <input type="text" name="currentSchoolName" value="${rqt.currentSchoolName}" 
                    class="  validate-string" title="<g:message code="srr.property.currentSchoolName.validationError" />"  />
            

    
      <label class=""><g:message code="srr.property.currentSchoolAddress.label" />   <span><g:message code="srr.property.currentSchoolAddress.help" /></span></label>
            <textarea name="currentSchoolAddress" class="  validate-textarea" title="<g:message code="srr.property.currentSchoolAddress.validationError" />" rows="3" >${rqt.currentSchoolAddress}</textarea>
            

    
      <label class=""><g:message code="srr.property.currentSection.label" />   <span><g:message code="srr.property.currentSection.help" /></span></label>
            <select name="currentSection" class="  validate-not-first" title="<g:message code="srr.property.currentSection.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['BeforeFirstSection','FirstSection','SecondSection','ThirdSection','CP','CE1','CE2','CM1','CM2','CLISS','Unknown']}">
                <option value="fr.cg95.cvq.business.users.SectionType_${it}" ${it == rqt.currentSection?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="srr.property.currentSection" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

