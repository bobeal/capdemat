


  
    <label for="roleDemandeur" class="required"><g:message code="sagr.property.roleDemandeur.label" /> *  <span><g:message code="sagr.property.roleDemandeur.help" /></span></label>
            <select id="roleDemandeur" name="roleDemandeur" class="required condition-estPresident-trigger  validate-not-first ${rqt.stepStates['president'].invalidFields.contains('roleDemandeur') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.roleDemandeur.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['PRESIDENT','TRESORIER','SECRETAIRE']}">
                <option value="${it}" ${it == rqt.roleDemandeur?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sagr.property.roleDemandeur" /></option>
              </g:each>
            </select>
            

  

  
    <fieldset class="required condition-estPresident-unfilled">
    <legend><g:message code="sagr.property.precisionPresident.label" /></legend>
    
      <label for="nomPresident" class="required"><g:message code="sagr.property.nomPresident.label" /> *  <span><g:message code="sagr.property.nomPresident.help" /></span></label>
            <input type="text" id="nomPresident" name="nomPresident" value="${rqt.nomPresident?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['president'].invalidFields.contains('nomPresident') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nomPresident.validationError" />"  maxlength="38" />
            

    
      <label for="prenomPresident" class="required"><g:message code="sagr.property.prenomPresident.label" /> *  <span><g:message code="sagr.property.prenomPresident.help" /></span></label>
            <input type="text" id="prenomPresident" name="prenomPresident" value="${rqt.prenomPresident?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['president'].invalidFields.contains('prenomPresident') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.prenomPresident.validationError" />"  maxlength="38" />
            

    
      <label for="telephonePresident" class=""><g:message code="sagr.property.telephonePresident.label" />   <span><g:message code="sagr.property.telephonePresident.help" /></span></label>
            <input type="text" id="telephonePresident" name="telephonePresident" value="${rqt.telephonePresident?.toString()}" 
                    class="  validate-phone ${rqt.stepStates['president'].invalidFields.contains('telephonePresident') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.telephonePresident.validationError" />"  maxlength="10" />
            

    
      <label for="emailPresident" class=""><g:message code="sagr.property.emailPresident.label" />   <span><g:message code="sagr.property.emailPresident.help" /></span></label>
            <input type="text" id="emailPresident" name="emailPresident" value="${rqt.emailPresident?.toString()}" 
                    class="  validate-email ${rqt.stepStates['president'].invalidFields.contains('emailPresident') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.emailPresident.validationError" />"   />
            

    
    </fieldset>
  

