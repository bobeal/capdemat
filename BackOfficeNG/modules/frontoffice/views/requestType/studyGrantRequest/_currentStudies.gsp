




  
    <fieldset class="required">
    <legend><g:message code="sgr.property.aLevelsInformations.label" /></legend> 
      
    
      <label class="required"><g:message code="sgr.property.isInLastYear.label" /> * <span><g:message code="sgr.property.isInLastYear.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-notInLastYear-trigger validate-boolean" title="" value="${it}" name="isInLastYear" ${it == rqt.isInLastYear ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-notInLastYear-filled"><g:message code="sgr.property.lastYearDate.label" /> * <span><g:message code="sgr.property.lastYearDate.help" /></span></label>
      
            <input type="text" name="lastYearDate" value="${rqt.lastYearDate}" 
                    class="required condition-notInLastYear-filled validate-regex" title="<g:message code="sgr.property.lastYearDate.validationError" />" regex="^\d{2,4}$" maxLength="4"/>
            
    
      <label class="required condition-notInLastYear-filled"><g:message code="sgr.property.lastYearType.label" /> * <span><g:message code="sgr.property.lastYearType.help" /></span></label>
      
            <input type="text" name="lastYearType" value="${rqt.lastYearType}" 
                    class="required condition-notInLastYear-filled validate-string" title="<g:message code="sgr.property.lastYearType.validationError" />"  />
            
    
    </fieldset>
  

  
    <fieldset class="required condition-notInLastYear-filled">
    <legend><g:message code="sgr.property.currentStudiesInformations.label" /></legend> 
      
    
      <label class="required"><g:message code="sgr.property.currentStudies.label" /> * <span><g:message code="sgr.property.currentStudies.help" /></span></label>
      
            <select name="currentStudies" class="required condition-isInAbroadInternship-trigger condition-isInSandwichCourses-trigger condition-isInOtherStudies-trigger validate-not-first" title="<g:message code="sgr.property.currentStudies.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['licence1','licence2','licence3','licencePro','master','master1','master2','bts1','bts2','dut1','dut2','sandwichCourses','abroadInternship','otherStudies']}">
                <option value="fr.cg95.cvq.business.request.school.CurrentStudiesType_${it}" ${it == rqt.currentStudies?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="sgr.property.currentStudies" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isInSandwichCourses-filled"><g:message code="sgr.property.sandwichCoursesLabel.label" /> * <span><g:message code="sgr.property.sandwichCoursesLabel.help" /></span></label>
      
            <input type="text" name="sandwichCoursesLabel" value="${rqt.sandwichCoursesLabel}" 
                    class="required condition-isInSandwichCourses-filled validate-string" title="<g:message code="sgr.property.sandwichCoursesLabel.validationError" />"  />
            
    
      <label class="required condition-isInAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipStartDate.label" /> * <span><g:message code="sgr.property.abroadInternshipStartDate.help" /></span></label>
      
            <input type="text" name="abroadInternshipStartDate" value="${formatDate(formatName:'format.date',date:rqt.abroadInternshipStartDate)}" 
                   class="required condition-isInAbroadInternship-filled validate-date" title="<g:message code="sgr.property.abroadInternshipStartDate.validationError" />" />
            
    
      <label class="required condition-isInAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipEndDate.label" /> * <span><g:message code="sgr.property.abroadInternshipEndDate.help" /></span></label>
      
            <input type="text" name="abroadInternshipEndDate" value="${formatDate(formatName:'format.date',date:rqt.abroadInternshipEndDate)}" 
                   class="required condition-isInAbroadInternship-filled validate-date" title="<g:message code="sgr.property.abroadInternshipEndDate.validationError" />" />
            
    
      <label class="required condition-isInOtherStudies-filled"><g:message code="sgr.property.otherStudiesLabel.label" /> * <span><g:message code="sgr.property.otherStudiesLabel.help" /></span></label>
      
            <input type="text" name="otherStudiesLabel" value="${rqt.otherStudiesLabel}" 
                    class="required condition-isInOtherStudies-filled validate-string" title="<g:message code="sgr.property.otherStudiesLabel.validationError" />"  />
            
    
    </fieldset>
  

