


  
    <label class="required"><g:message code="bdr.property.format.label" /> *  <span><g:message code="bdr.property.format.help" /></span></label>
            <ul class="required ${rqt.stepStates['type'].invalidFields.contains('format') ? 'validation-failed' : ''}">
              <g:each in="${['FullCopy','ExtractWithRelationship','ExtractWithoutRelationship','MultilingualExtract']}">
              <li>
                <input type="radio" id="format_${it}" class="required condition-isWithRelationship-trigger  validate-one-required" value="fr.cg95.cvq.business.request.civil.BirthCertificateFormatType_${it}" name="format" ${it == rqt.format.toString() ? 'checked="checked"': ''} title="<g:message code="bdr.property.format.validationError" />" />
                <label for="format_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="bdr.property.format" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="condition-isWithRelationship-filled">
    <legend><g:message code="bdr.property.fatherInformation.label" /></legend>
    
      <label for="fatherLastName" class="required"><g:message code="bdr.property.fatherLastName.label" /> *  <span><g:message code="bdr.property.fatherLastName.help" /></span></label>
            <input type="text" id="fatherLastName" name="fatherLastName" value="${rqt.fatherLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['type'].invalidFields.contains('fatherLastName') ? 'validation-failed' : ''}" title="<g:message code="bdr.property.fatherLastName.validationError" />"  maxlength="38" />
            

    
      <label for="fatherFirstNames" class="required"><g:message code="bdr.property.fatherFirstNames.label" /> *  <span><g:message code="bdr.property.fatherFirstNames.help" /></span></label>
            <input type="text" id="fatherFirstNames" name="fatherFirstNames" value="${rqt.fatherFirstNames?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['type'].invalidFields.contains('fatherFirstNames') ? 'validation-failed' : ''}" title="<g:message code="bdr.property.fatherFirstNames.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="condition-isWithRelationship-filled">
    <legend><g:message code="bdr.property.motherInformation.label" /></legend>
    
      <label for="motherMaidenName" class="required"><g:message code="bdr.property.motherMaidenName.label" /> *  <span><g:message code="bdr.property.motherMaidenName.help" /></span></label>
            <input type="text" id="motherMaidenName" name="motherMaidenName" value="${rqt.motherMaidenName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['type'].invalidFields.contains('motherMaidenName') ? 'validation-failed' : ''}" title="<g:message code="bdr.property.motherMaidenName.validationError" />"  maxlength="38" />
            

    
      <label for="motherFirstNames" class="required"><g:message code="bdr.property.motherFirstNames.label" /> *  <span><g:message code="bdr.property.motherFirstNames.help" /></span></label>
            <input type="text" id="motherFirstNames" name="motherFirstNames" value="${rqt.motherFirstNames?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['type'].invalidFields.contains('motherFirstNames') ? 'validation-failed' : ''}" title="<g:message code="bdr.property.motherFirstNames.validationError" />"   />
            

    
    </fieldset>
  

  
    <label for="copies" class="required"><g:message code="bdr.property.copies.label" /> *  <span><g:message code="bdr.property.copies.help" /></span></label>
            <input type="text" id="copies" name="copies" value="${rqt.copies?.toString()}" 
                    class="required  validate-positiveInteger ${rqt.stepStates['type'].invalidFields.contains('copies') ? 'validation-failed' : ''}" title="<g:message code="bdr.property.copies.validationError" />"   />
            

  

  
    <label for="motive" class="required"><g:message code="bdr.property.motive.label" /> *  <span><g:message code="bdr.property.motive.help" /></span></label>
            <select id="motive" name="motive" class="required  validate-not-first ${rqt.stepStates['type'].invalidFields.contains('motive') ? 'validation-failed' : ''}" title="<g:message code="bdr.property.motive.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NotaryAct','NationalIdentityCard','FrenchNationalityCertificate','Marriage','Pacs','Passport','Pension','LegalProceedings','Other']}">
                <option value="fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType_${it}" ${it == rqt.motive?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="bdr.property.motive" /></option>
              </g:each>
            </select>
            

  

  
    <label for="comment" class=""><g:message code="bdr.property.comment.label" />   <span><g:message code="bdr.property.comment.help" /></span></label>
            <textarea id="comment" name="comment" class="  validate-regex ${rqt.stepStates['type'].invalidFields.contains('comment') ? 'validation-failed' : ''}" title="<g:message code="bdr.property.comment.validationError" />" rows="3" cols="" regex="^.{0,255}$" >${rqt.comment}</textarea>
            

  

