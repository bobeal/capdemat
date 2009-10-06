


  
    <label class="required"><g:message code="bdr.property.format.label" /> *  <span><g:message code="bdr.property.format.help" /></span></label>
            <ul class="required">
              <g:each in="${['FullCopy','ExtractWithRelationship','ExtractWithoutRelationship','MultilingualExtract']}">
              <li>
                <input type="radio" class="required condition-isWithRelationship-trigger  validate-one-required" value="fr.cg95.cvq.business.request.civil.BirthCertificateFormatType_${it}" name="format" ${it == rqt.format.toString() ? 'checked="checked"': ''} title="<g:message code="bdr.property.format.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="bdr.property.format" />
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="condition-isWithRelationship-filled">
    <legend><g:message code="bdr.property.fatherInformation.label" /></legend>
    
      <label class="required"><g:message code="bdr.property.fatherLastName.label" /> *  <span><g:message code="bdr.property.fatherLastName.help" /></span></label>
            <input type="text" name="fatherLastName" value="${rqt.fatherLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="bdr.property.fatherLastName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="bdr.property.fatherFirstNames.label" /> *  <span><g:message code="bdr.property.fatherFirstNames.help" /></span></label>
            <input type="text" name="fatherFirstNames" value="${rqt.fatherFirstNames?.toString()}" 
                    class="required  validate-string" title="<g:message code="bdr.property.fatherFirstNames.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="condition-isWithRelationship-filled">
    <legend><g:message code="bdr.property.motherInformation.label" /></legend>
    
      <label class="required"><g:message code="bdr.property.motherMaidenName.label" /> *  <span><g:message code="bdr.property.motherMaidenName.help" /></span></label>
            <input type="text" name="motherMaidenName" value="${rqt.motherMaidenName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="bdr.property.motherMaidenName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="bdr.property.motherFirstNames.label" /> *  <span><g:message code="bdr.property.motherFirstNames.help" /></span></label>
            <input type="text" name="motherFirstNames" value="${rqt.motherFirstNames?.toString()}" 
                    class="required  validate-string" title="<g:message code="bdr.property.motherFirstNames.validationError" />"   />
            

    
    </fieldset>
  

  
    <label class="required"><g:message code="bdr.property.copies.label" /> *  <span><g:message code="bdr.property.copies.help" /></span></label>
            <input type="text" name="copies" value="${rqt.copies?.toString()}" 
                    class="required  validate-positiveInteger" title="<g:message code="bdr.property.copies.validationError" />"   />
            

  

  
    <label class="required"><g:message code="bdr.property.motive.label" /> *  <span><g:message code="bdr.property.motive.help" /></span></label>
            <select name="motive" class="required  validate-not-first" title="<g:message code="bdr.property.motive.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NotaryAct','NationalIdentityCard','FrenchNationalityCertificate','Marriage','Pacs','Passport','Pension','LegalProceedings','Other']}">
                <option value="fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType_${it}" ${it == rqt.motive?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="bdr.property.motive" /></option>
              </g:each>
            </select>
            

  

  
    <label class=""><g:message code="bdr.property.comment.label" />   <span><g:message code="bdr.property.comment.help" /></span></label>
            <textarea name="comment" class="  validate-textarea" title="<g:message code="bdr.property.comment.validationError" />" rows="3" cols="" >${rqt.comment}</textarea>
            

  

