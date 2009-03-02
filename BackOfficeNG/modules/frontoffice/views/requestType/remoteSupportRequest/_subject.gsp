




  
    <fieldset class="required">
    <legend><g:message code="rsr.property.rsrSubject.label" /></legend> 
      
    <label class="required"><g:message code="request.property.subjectName" /> *</label>
    <select name="subjectId" class="required validate-not-first" title="<g:message code="request.subject.validationError" /> ">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${subjects}">
        <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
      </g:each>
    </select>
      
    
      <label class="required"><g:message code="rsr.property.subjectTitle.label" /> * <span><g:message code="rsr.property.subjectTitle.help" /></span></label>
      
            <select name="subjectTitle" class="required validate-not-first" title="<g:message code="rsr.property.subjectTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.subjectTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="rsr.property.subjectTitle" /></option>
              </g:each>
            </select>
            
    
      <label class="required"><g:message code="rsr.property.subjectBirthDate.label" /> * <span><g:message code="rsr.property.subjectBirthDate.help" /></span></label>
      
            <input type="text" name="subjectBirthDate" value="${formatDate(formatName:'format.date',date:rqt.subjectBirthDate)}" 
                   class="required validate-date" title="<g:message code="rsr.property.subjectBirthDate.validationError" />" />
            
    
      <label class="required"><g:message code="rsr.property.subjectResideWith.label" /> * <span><g:message code="rsr.property.subjectResideWith.help" /></span></label>
      
            <ul class="required">
              <g:each in="${['Alone','Couple','Family']}">
              <li>
                <input type="radio" class="required validate-one-required" value="fr.cg95.cvq.business.request.social.RsrSubjectResideWithType_${it}" name="subjectResideWith" ${it == rqt.subjectResideWith.toString() ? 'checked="checked"': ''} title="<g:message code="rsr.property.subjectResideWith.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="rsr.property.subjectResideWith" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="rsr.property.subjectIsTaxable.label" /> * <span><g:message code="rsr.property.subjectIsTaxable.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="subjectIsTaxable" ${it == rqt.subjectIsTaxable ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="rsr.property.subjectIsAPABeneficiary.label" /> * <span><g:message code="rsr.property.subjectIsAPABeneficiary.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="subjectIsAPABeneficiary" ${it == rqt.subjectIsAPABeneficiary ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="rsr.property.subjectIsDisabledPerson.label" /> * <span><g:message code="rsr.property.subjectIsDisabledPerson.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="subjectIsDisabledPerson" ${it == rqt.subjectIsDisabledPerson ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="rsr.property.requestInformation.label" /></legend> 
      
    
      <label class="required"><g:message code="rsr.property.requestInformationRequestKind.label" /> * <span><g:message code="rsr.property.requestInformationRequestKind.help" /></span></label>
      
            <ul class="required">
              <g:each in="${['Individual','Couple']}">
              <li>
                <input type="radio" class="required condition-isCoupleRequest-trigger validate-one-required" value="fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType_${it}" name="requestInformationRequestKind" ${it == rqt.requestInformationRequestKind.toString() ? 'checked="checked"': ''} title="<g:message code="rsr.property.requestInformationRequestKind.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="rsr.property.requestInformationRequestKind" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required"><g:message code="rsr.property.requestInformationEmergency.label" /> * <span><g:message code="rsr.property.requestInformationEmergency.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isEmergency-trigger validate-boolean" title="" value="${it}" name="requestInformationEmergency" ${it == rqt.requestInformationEmergency ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-isEmergency-filled"><g:message code="rsr.property.requestInformationEmergencyMotive.label" /> * <span><g:message code="rsr.property.requestInformationEmergencyMotive.help" /></span></label>
      
            <textarea name="requestInformationEmergencyMotive" class="required condition-isEmergency-filled validate-textarea" title="<g:message code="rsr.property.requestInformationEmergencyMotive.validationError" />" rows="3">${rqt.requestInformationEmergencyMotive}</textarea>
            
    
    </fieldset>
  

  
    <fieldset class="required condition-isCoupleRequest-filled">
    <legend><g:message code="rsr.property.spouse.label" /></legend> 
      
    
      <label class="required"><g:message code="rsr.property.spouseLastName.label" /> * <span><g:message code="rsr.property.spouseLastName.help" /></span></label>
      
            <input type="text" name="spouseLastName" value="${rqt.spouseLastName}" 
                    class="required validate-lastName" title="<g:message code="rsr.property.spouseLastName.validationError" />" />
            
    
      <label class="required"><g:message code="rsr.property.spouseFirstName.label" /> * <span><g:message code="rsr.property.spouseFirstName.help" /></span></label>
      
            <input type="text" name="spouseFirstName" value="${rqt.spouseFirstName}" 
                    class="required validate-firstName" title="<g:message code="rsr.property.spouseFirstName.validationError" />" />
            
    
      <label class="required"><g:message code="rsr.property.spouseTitle.label" /> * <span><g:message code="rsr.property.spouseTitle.help" /></span></label>
      
            <select name="spouseTitle" class="required validate-not-first" title="<g:message code="rsr.property.spouseTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.spouseTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="rsr.property.spouseTitle" /></option>
              </g:each>
            </select>
            
    
      <label class="required"><g:message code="rsr.property.spouseBirthDate.label" /> * <span><g:message code="rsr.property.spouseBirthDate.help" /></span></label>
      
            <input type="text" name="spouseBirthDate" value="${formatDate(formatName:'format.date',date:rqt.spouseBirthDate)}" 
                   class="required validate-date" title="<g:message code="rsr.property.spouseBirthDate.validationError" />" />
            
    
      <label class="required"><g:message code="rsr.property.spouseIsDisabledPerson.label" /> * <span><g:message code="rsr.property.spouseIsDisabledPerson.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="spouseIsDisabledPerson" ${it == rqt.spouseIsDisabledPerson ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
    </fieldset>
  

