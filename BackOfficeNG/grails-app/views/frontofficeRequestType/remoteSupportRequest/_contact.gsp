


  
    <label class="required"><g:message code="rsr.property.contactKind.label" /> *  <span><g:message code="rsr.property.contactKind.help" /></span></label>
            <ul class="required ${rqt.stepStates['contact'].invalidFields.contains('contactKind') ? 'validation-failed' : ''}">
              <g:each in="${['REQUESTER','OTHER']}">
              <li>
                <input type="radio" id="contactKind_${it}" class="required condition-isOtherContact-trigger  validate-one-required" value="${it}" name="contactKind" ${it == rqt.contactKind.toString() ? 'checked="checked"': ''} title="<g:message code="rsr.property.contactKind.validationError" />" />
                <label for="contactKind_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="rsr.property.contactKind" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="required condition-isOtherContact-filled">
    <legend><g:message code="rsr.property.firstContact.label" /></legend>
    
      <label for="contactLastName" class="required"><g:message code="rsr.property.contactLastName.label" /> *  <span><g:message code="rsr.property.contactLastName.help" /></span></label>
            <input type="text" id="contactLastName" name="contactLastName" value="${rqt.contactLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['contact'].invalidFields.contains('contactLastName') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.contactLastName.validationError" />"  maxlength="38" />
            

    
      <label for="contactFirstName" class="required"><g:message code="rsr.property.contactFirstName.label" /> *  <span><g:message code="rsr.property.contactFirstName.help" /></span></label>
            <input type="text" id="contactFirstName" name="contactFirstName" value="${rqt.contactFirstName?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['contact'].invalidFields.contains('contactFirstName') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.contactFirstName.validationError" />"  maxlength="38" />
            

    
      <label for="contactPhone" class="required"><g:message code="rsr.property.contactPhone.label" /> *  <span><g:message code="rsr.property.contactPhone.help" /></span></label>
            <input type="text" id="contactPhone" name="contactPhone" value="${rqt.contactPhone?.toString()}" 
                    class="required  validate-phone ${rqt.stepStates['contact'].invalidFields.contains('contactPhone') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.contactPhone.validationError" />"  maxlength="10" />
            

    
    </fieldset>
  

  
    <fieldset class="required condition-isOtherContact-filled">
    <legend><g:message code="rsr.property.secondContact.label" /></legend>
    
      <label for="secondContactLastName" class=""><g:message code="rsr.property.secondContactLastName.label" />   <span><g:message code="rsr.property.secondContactLastName.help" /></span></label>
            <input type="text" id="secondContactLastName" name="secondContactLastName" value="${rqt.secondContactLastName?.toString()}" 
                    class="  validate-lastName ${rqt.stepStates['contact'].invalidFields.contains('secondContactLastName') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.secondContactLastName.validationError" />"  maxlength="38" />
            

    
      <label for="secondContactFirstName" class=""><g:message code="rsr.property.secondContactFirstName.label" />   <span><g:message code="rsr.property.secondContactFirstName.help" /></span></label>
            <input type="text" id="secondContactFirstName" name="secondContactFirstName" value="${rqt.secondContactFirstName?.toString()}" 
                    class="  validate-firstName ${rqt.stepStates['contact'].invalidFields.contains('secondContactFirstName') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.secondContactFirstName.validationError" />"  maxlength="38" />
            

    
      <label for="secondContactPhone" class=""><g:message code="rsr.property.secondContactPhone.label" />   <span><g:message code="rsr.property.secondContactPhone.help" /></span></label>
            <input type="text" id="secondContactPhone" name="secondContactPhone" value="${rqt.secondContactPhone?.toString()}" 
                    class="  validate-phone ${rqt.stepStates['contact'].invalidFields.contains('secondContactPhone') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.secondContactPhone.validationError" />"  maxlength="10" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="rsr.property.trustee.label" /></legend>
    
      <label for="trusteeLastName" class=""><g:message code="rsr.property.trusteeLastName.label" />   <span><g:message code="rsr.property.trusteeLastName.help" /></span></label>
            <input type="text" id="trusteeLastName" name="trusteeLastName" value="${rqt.trusteeLastName?.toString()}" 
                    class="  validate-lastName ${rqt.stepStates['contact'].invalidFields.contains('trusteeLastName') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.trusteeLastName.validationError" />"  maxlength="38" />
            

    
      <label for="trusteeFirstName" class=""><g:message code="rsr.property.trusteeFirstName.label" />   <span><g:message code="rsr.property.trusteeFirstName.help" /></span></label>
            <input type="text" id="trusteeFirstName" name="trusteeFirstName" value="${rqt.trusteeFirstName?.toString()}" 
                    class="  validate-firstName ${rqt.stepStates['contact'].invalidFields.contains('trusteeFirstName') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.trusteeFirstName.validationError" />"  maxlength="38" />
            

    
      <label for="trusteePhone" class=""><g:message code="rsr.property.trusteePhone.label" />   <span><g:message code="rsr.property.trusteePhone.help" /></span></label>
            <input type="text" id="trusteePhone" name="trusteePhone" value="${rqt.trusteePhone?.toString()}" 
                    class="  validate-phone ${rqt.stepStates['contact'].invalidFields.contains('trusteePhone') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.trusteePhone.validationError" />"  maxlength="10" />
            

    
    </fieldset>
  

