


  
    <label class="required"><g:message code="rsr.property.contactKind.label" /> *  <span><g:message code="rsr.property.contactKind.help" /></span></label>
            <ul class="required">
              <g:each in="${['Requester','Other']}">
              <li>
                <input type="radio" class="required condition-isOtherContact-trigger validate-one-required" value="fr.cg95.cvq.business.request.social.RsrContactKindType_${it}" name="contactKind" ${it == rqt.contactKind.toString() ? 'checked="checked"': ''} title="<g:message code="rsr.property.contactKind.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="rsr.property.contactKind" />
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="required condition-isOtherContact-filled">
    <legend><g:message code="rsr.property.firstContact.label" /></legend>
    
      <label class="required"><g:message code="rsr.property.contactLastName.label" /> *  <span><g:message code="rsr.property.contactLastName.help" /></span></label>
            <input type="text" name="contactLastName" value="${rqt.contactLastName}" 
                    class="required validate-lastName" title="<g:message code="rsr.property.contactLastName.validationError" />"  maxLength="38"/>
            

    
      <label class="required"><g:message code="rsr.property.contactFirstName.label" /> *  <span><g:message code="rsr.property.contactFirstName.help" /></span></label>
            <input type="text" name="contactFirstName" value="${rqt.contactFirstName}" 
                    class="required validate-firstName" title="<g:message code="rsr.property.contactFirstName.validationError" />"  maxLength="38"/>
            

    
      <label class="required"><g:message code="rsr.property.contactPhone.label" /> *  <span><g:message code="rsr.property.contactPhone.help" /></span></label>
            <input type="text" name="contactPhone" value="${rqt.contactPhone}" 
                    class="required validate-phone" title="<g:message code="rsr.property.contactPhone.validationError" />"  maxLength="10"/>
            

    
    </fieldset>
  

  
    <fieldset class="required condition-isOtherContact-filled">
    <legend><g:message code="rsr.property.secondContact.label" /></legend>
    
      <label class=""><g:message code="rsr.property.secondContactLastName.label" />   <span><g:message code="rsr.property.secondContactLastName.help" /></span></label>
            <input type="text" name="secondContactLastName" value="${rqt.secondContactLastName}" 
                    class=" validate-lastName" title="<g:message code="rsr.property.secondContactLastName.validationError" />"  maxLength="38"/>
            

    
      <label class=""><g:message code="rsr.property.secondContactFirstName.label" />   <span><g:message code="rsr.property.secondContactFirstName.help" /></span></label>
            <input type="text" name="secondContactFirstName" value="${rqt.secondContactFirstName}" 
                    class=" validate-firstName" title="<g:message code="rsr.property.secondContactFirstName.validationError" />"  maxLength="38"/>
            

    
      <label class=""><g:message code="rsr.property.secondContactPhone.label" />   <span><g:message code="rsr.property.secondContactPhone.help" /></span></label>
            <input type="text" name="secondContactPhone" value="${rqt.secondContactPhone}" 
                    class=" validate-phone" title="<g:message code="rsr.property.secondContactPhone.validationError" />"  maxLength="10"/>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="rsr.property.trustee.label" /></legend>
    
      <label class=""><g:message code="rsr.property.trusteeLastName.label" />   <span><g:message code="rsr.property.trusteeLastName.help" /></span></label>
            <input type="text" name="trusteeLastName" value="${rqt.trusteeLastName}" 
                    class=" validate-lastName" title="<g:message code="rsr.property.trusteeLastName.validationError" />"  maxLength="38"/>
            

    
      <label class=""><g:message code="rsr.property.trusteeFirstName.label" />   <span><g:message code="rsr.property.trusteeFirstName.help" /></span></label>
            <input type="text" name="trusteeFirstName" value="${rqt.trusteeFirstName}" 
                    class=" validate-firstName" title="<g:message code="rsr.property.trusteeFirstName.validationError" />"  maxLength="38"/>
            

    
      <label class=""><g:message code="rsr.property.trusteePhone.label" />   <span><g:message code="rsr.property.trusteePhone.help" /></span></label>
            <input type="text" name="trusteePhone" value="${rqt.trusteePhone}" 
                    class=" validate-phone" title="<g:message code="rsr.property.trusteePhone.validationError" />"  maxLength="10"/>
            

    
    </fieldset>
  

