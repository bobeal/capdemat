




  
    <label class="required"><g:message code="sgr.property.studentCivility.label" /> *  <span><g:message code="sgr.property.studentCivility.help" /></span></label>
    
            <select name="studentCivility" class="required validate-not-first" title="<g:message code="sgr.property.studentCivility.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.studentCivility?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="sgr.property.studentCivility" /></option>
              </g:each>
            </select>
            
  

  
    <label class="required"><g:message code="sgr.property.studentLastName.label" /> *  <span><g:message code="sgr.property.studentLastName.help" /></span></label>
    
            <input type="text" name="studentLastName" value="${rqt.studentLastName}" 
                    class="required validate-lastName" title="<g:message code="sgr.property.studentLastName.validationError" />"  maxLength="38"/>
            
  

  
    <label class="required"><g:message code="sgr.property.studentFirstName.label" /> *  <span><g:message code="sgr.property.studentFirstName.help" /></span></label>
    
            <input type="text" name="studentFirstName" value="${rqt.studentFirstName}" 
                    class="required validate-firstName" title="<g:message code="sgr.property.studentFirstName.validationError" />"  maxLength="38"/>
            
  

  
    <fieldset class="required">
    <legend><g:message code="sgr.property.studentAddress.label" /></legend> 
      
    
    </fieldset>
  

  
    <label class="required"><g:message code="sgr.property.studentPhone.label" /> *  <span><g:message code="sgr.property.studentPhone.help" /></span></label>
    
            <input type="text" name="studentPhone" value="${rqt.studentPhone}" 
                    class="required validate-phone" title="<g:message code="sgr.property.studentPhone.validationError" />"  maxLength="10"/>
            
  

  
    <label class="required"><g:message code="sgr.property.studentMobilePhone.label" /> *  <span><g:message code="sgr.property.studentMobilePhone.help" /></span></label>
    
            <input type="text" name="studentMobilePhone" value="${rqt.studentMobilePhone}" 
                    class="required validate-phone" title="<g:message code="sgr.property.studentMobilePhone.validationError" />"  maxLength="10"/>
            
  

  
    <label class="required"><g:message code="sgr.property.studentEmail.label" /> *  <span><g:message code="sgr.property.studentEmail.help" /></span></label>
    
            <input type="text" name="studentEmail" value="${rqt.studentEmail}" 
                    class="required validate-email" title="<g:message code="sgr.property.studentEmail.validationError" />"  />
            
  

  
    <label class="required"><g:message code="sgr.property.studentBirthDate.label" /> *  <span><g:message code="sgr.property.studentBirthDate.help" /></span></label>
    
            <input type="text" name="studentBirthDate" value="${formatDate(formatName:'format.date',date:rqt.studentBirthDate)}" 
                   class="required validate-date" title="<g:message code="sgr.property.studentBirthDate.validationError" />" />
            
  

  
    <label class="required"><g:message code="sgr.property.studentBirthPlace.label" /> *  <span><g:message code="sgr.property.studentBirthPlace.help" /></span></label>
    
            <input type="text" name="studentBirthPlace" value="${rqt.studentBirthPlace}" 
                    class="required validate-string" title="<g:message code="sgr.property.studentBirthPlace.validationError" />"  />
            
  

