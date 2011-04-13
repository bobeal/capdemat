


  
    <label class="required"><g:message code="mdr.property.format.label" /> *  <span><g:message code="mdr.property.format.help" /></span></label>
            <ul class="required ${rqt.stepStates['type'].invalidFields.contains('format') ? 'validation-failed' : ''}">
              <g:each in="${['FULL_COPY','EXTRACT_WITH_RELATIONSHIP','EXTRACT_WITHOUT_RELATIONSHIP','MULTILINGUAL_EXTRACT']}">
              <li>
                <input type="radio" id="format_${it}" class="required condition-isWithRelationship-trigger  validate-one-required" value="${it}" name="format" ${it == rqt.format.toString() ? 'checked="checked"': ''} title="<g:message code="mdr.property.format.validationError" />" />
                <label for="format_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="mdr.property.format" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="copies" class="required"><g:message code="mdr.property.copies.label" /> *  <span><g:message code="mdr.property.copies.help" /></span></label>
            <input type="text" id="copies" name="copies" value="${rqt.copies?.toString()}" 
                    class="required  validate-positiveInteger ${rqt.stepStates['type'].invalidFields.contains('copies') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.copies.validationError" />"   />
            

  

  
    <label for="motive" class=""><g:message code="mdr.property.motive.label" />   <span><g:message code="mdr.property.motive.help" /></span></label>
            <select id="motive" name="motive" class="  validate-select ${rqt.stepStates['type'].invalidFields.contains('motive') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.motive.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NOTARY_ACT','FRENCH_NATIONALITY_CERTIFICATE','MARITAL_REGIME_CHANGE','FRENCH_NATIONALITY_ACQUISITION_DECLARATION','DIVORCE_SEPARATION','PASSPORT','PENSION','OTHER']}">
                <option value="${it}" ${it == rqt.motive?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mdr.property.motive" /></option>
              </g:each>
            </select>
            

  

  
    <label for="comment" class=""><g:message code="mdr.property.comment.label" />   <span><g:message code="mdr.property.comment.help" /></span></label>
            <textarea id="comment" name="comment" class="  validate-regex ${rqt.stepStates['type'].invalidFields.contains('comment') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.comment.validationError" />" rows="3" cols="" regex="[\w\W]{0,255}$" maxlength="255">${rqt.comment}</textarea>
            

  

  
    <label for="relationship" class="required condition-isWithRelationship-filled"><g:message code="mdr.property.relationship.label" /> *  <span><g:message code="mdr.property.relationship.help" /></span></label>
            <select id="relationship" name="relationship" class="required condition-isWithRelationship-filled  validate-not-first ${rqt.stepStates['type'].invalidFields.contains('relationship') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.relationship.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['HUSBAND','WIFE']}">
                <option value="${it}" ${it == rqt.relationship?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mdr.property.relationship" /></option>
              </g:each>
            </select>
            

  

  
    <fieldset class="condition-isWithRelationship-filled">
    <legend><g:message code="mdr.property.fatherInformation.label" /></legend>
    
      <label for="fatherLastName" class="required"><g:message code="mdr.property.fatherLastName.label" /> *  <span><g:message code="mdr.property.fatherLastName.help" /></span></label>
            <input type="text" id="fatherLastName" name="fatherLastName" value="${rqt.fatherLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['type'].invalidFields.contains('fatherLastName') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.fatherLastName.validationError" />"  maxlength="38" />
            

    
      <label for="fatherFirstNames" class="required"><g:message code="mdr.property.fatherFirstNames.label" /> *  <span><g:message code="mdr.property.fatherFirstNames.help" /></span></label>
            <input type="text" id="fatherFirstNames" name="fatherFirstNames" value="${rqt.fatherFirstNames?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['type'].invalidFields.contains('fatherFirstNames') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.fatherFirstNames.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="condition-isWithRelationship-filled">
    <legend><g:message code="mdr.property.motherInformation.label" /></legend>
    
      <label for="motherMaidenName" class="required"><g:message code="mdr.property.motherMaidenName.label" /> *  <span><g:message code="mdr.property.motherMaidenName.help" /></span></label>
            <input type="text" id="motherMaidenName" name="motherMaidenName" value="${rqt.motherMaidenName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['type'].invalidFields.contains('motherMaidenName') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.motherMaidenName.validationError" />"  maxlength="38" />
            

    
      <label for="motherFirstNames" class="required"><g:message code="mdr.property.motherFirstNames.label" /> *  <span><g:message code="mdr.property.motherFirstNames.help" /></span></label>
            <input type="text" id="motherFirstNames" name="motherFirstNames" value="${rqt.motherFirstNames?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['type'].invalidFields.contains('motherFirstNames') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.motherFirstNames.validationError" />"   />
            

    
    </fieldset>
  

