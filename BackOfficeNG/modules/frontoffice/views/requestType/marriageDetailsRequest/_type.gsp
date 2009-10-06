


  
    <label class="required"><g:message code="mdr.property.format.label" /> *  <span><g:message code="mdr.property.format.help" /></span></label>
            <ul class="required">
              <g:each in="${['FullCopy','ExtractWithRelationship','ExtractWithoutRelationship','MultilingualExtract']}">
              <li>
                <input type="radio" class="required condition-isWithRelationship-trigger  validate-one-required" value="fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType_${it}" name="format" ${it == rqt.format.toString() ? 'checked="checked"': ''} title="<g:message code="mdr.property.format.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="mdr.property.format" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="mdr.property.copies.label" /> *  <span><g:message code="mdr.property.copies.help" /></span></label>
            <input type="text" name="copies" value="${rqt.copies?.toString()}" 
                    class="required  validate-positiveInteger" title="<g:message code="mdr.property.copies.validationError" />"   />
            

  

  
    <label class=""><g:message code="mdr.property.comment.label" />   <span><g:message code="mdr.property.comment.help" /></span></label>
            <textarea name="comment" class="  validate-textarea" title="<g:message code="mdr.property.comment.validationError" />" rows="3" cols="" >${rqt.comment}</textarea>
            

  

  
    <label class=""><g:message code="mdr.property.motive.label" />   <span><g:message code="mdr.property.motive.help" /></span></label>
            <select name="motive" class="  validate-select" title="<g:message code="mdr.property.motive.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NotaryAct','FrenchNationalityCertificate','MaritalRegimeChange','FrenchNationalityAcquisitionDeclaration','DivorceSeparation','Passport','Pension','Other']}">
                <option value="fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType_${it}" ${it == rqt.motive?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mdr.property.motive" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required condition-isWithRelationship-filled"><g:message code="mdr.property.relationship.label" /> *  <span><g:message code="mdr.property.relationship.help" /></span></label>
            <select name="relationship" class="required condition-isWithRelationship-filled  validate-not-first" title="<g:message code="mdr.property.relationship.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Husband','Wife']}">
                <option value="fr.cg95.cvq.business.request.civil.MarriageRelationshipType_${it}" ${it == rqt.relationship?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mdr.property.relationship" /></option>
              </g:each>
            </select>
            

  

  
    <fieldset class="condition-isWithRelationship-filled">
    <legend><g:message code="mdr.property.fatherInformation.label" /></legend>
    
      <label class="required"><g:message code="mdr.property.fatherLastName.label" /> *  <span><g:message code="mdr.property.fatherLastName.help" /></span></label>
            <input type="text" name="fatherLastName" value="${rqt.fatherLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="mdr.property.fatherLastName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="mdr.property.fatherFirstNames.label" /> *  <span><g:message code="mdr.property.fatherFirstNames.help" /></span></label>
            <input type="text" name="fatherFirstNames" value="${rqt.fatherFirstNames?.toString()}" 
                    class="required  validate-string" title="<g:message code="mdr.property.fatherFirstNames.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="condition-isWithRelationship-filled">
    <legend><g:message code="mdr.property.motherInformation.label" /></legend>
    
      <label class="required"><g:message code="mdr.property.motherMaidenName.label" /> *  <span><g:message code="mdr.property.motherMaidenName.help" /></span></label>
            <input type="text" name="motherMaidenName" value="${rqt.motherMaidenName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="mdr.property.motherMaidenName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="mdr.property.motherFirstNames.label" /> *  <span><g:message code="mdr.property.motherFirstNames.help" /></span></label>
            <input type="text" name="motherFirstNames" value="${rqt.motherFirstNames?.toString()}" 
                    class="required  validate-string" title="<g:message code="mdr.property.motherFirstNames.validationError" />"   />
            

    
    </fieldset>
  

