


  
    <fieldset class="required">
    <legend><g:message code="hcar.property.hcarSubject.label" /></legend>
    
      
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first " title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

    
      <label for="subjectTitle" class="required"><g:message code="hcar.property.subjectTitle.label" /> *  <span><g:message code="hcar.property.subjectTitle.help" /></span></label>
            <select id="subjectTitle" name="subjectTitle" class="required condition-isMadam-trigger  validate-not-first" title="<g:message code="hcar.property.subjectTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.subjectTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.subjectTitle" /></option>
              </g:each>
            </select>
            

    
      <label for="subjectMaidenName" class="required condition-isMadam-filled"><g:message code="hcar.property.subjectMaidenName.label" /> *  <span><g:message code="hcar.property.subjectMaidenName.help" /></span></label>
            <input type="text" id="subjectMaidenName" name="subjectMaidenName" value="${rqt.subjectMaidenName?.toString()}" 
                    class="required condition-isMadam-filled  validate-lastName" title="<g:message code="hcar.property.subjectMaidenName.validationError" />"  maxlength="38" />
            

    
      <label for="subjectBirthDate" class="required"><g:message code="hcar.property.subjectBirthDate.label" /> *  <span><g:message code="hcar.property.subjectBirthDate.help" /></span></label>
            <input type="text" id="subjectBirthDate" name="subjectBirthDate" value="${formatDate(formatName:'format.date',date:rqt.subjectBirthDate)}" 
                   class="required  validate-date" title="<g:message code="hcar.property.subjectBirthDate.validationError" />" />
            

    
      <label for="subjectBirthCity" class="required"><g:message code="hcar.property.subjectBirthCity.label" /> *  <span><g:message code="hcar.property.subjectBirthCity.help" /></span></label>
            <input type="text" id="subjectBirthCity" name="subjectBirthCity" value="${rqt.subjectBirthCity?.toString()}" 
                    class="required  validate-city" title="<g:message code="hcar.property.subjectBirthCity.validationError" />"  maxlength="32" />
            

    
      <label for="subjectBirthCountry" class="required"><g:message code="hcar.property.subjectBirthCountry.label" /> *  <span><g:message code="hcar.property.subjectBirthCountry.help" /></span></label>
            <input type="text" id="subjectBirthCountry" name="subjectBirthCountry" value="${rqt.subjectBirthCountry?.toString()}" 
                    class="required  " title="<g:message code="hcar.property.subjectBirthCountry.validationError" />"  maxlength="50" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.legalAccess.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.legalAccessPresence.label" /> *  <span><g:message code="hcar.property.legalAccessPresence.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="legalAccessPresence_${it ? 'yes' : 'no'}" class="required condition-isLegalAccessPresence-trigger  validate-one-required boolean" title="" value="${it}" name="legalAccessPresence" ${it == rqt.legalAccessPresence ? 'checked="checked"': ''} />
                <label for="legalAccessPresence_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="legalAccessKind" class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessKind.label" /> *  <span><g:message code="hcar.property.legalAccessKind.help" /></span></label>
            <select id="legalAccessKind" name="legalAccessKind" class="required condition-isLegalAccessPresence-filled  validate-not-first" title="<g:message code="hcar.property.legalAccessKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['safeguardingJustice','guardianship','curatorship']}">
                <option value="fr.cg95.cvq.business.request.social.HcarLegalAccessKindType_${it}" ${it == rqt.legalAccessKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.legalAccessKind" /></option>
              </g:each>
            </select>
            

    
      <label for="legalAccessRepresentativeKind" class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeKind.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeKind.help" /></span></label>
            <select id="legalAccessRepresentativeKind" name="legalAccessRepresentativeKind" class="required condition-isLegalAccessPresence-filled condition-isOtherLegalAccessRepresentative-trigger  validate-not-first" title="<g:message code="hcar.property.legalAccessRepresentativeKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['FamilyMember','Agency','Other']}">
                <option value="fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType_${it}" ${it == rqt.legalAccessRepresentativeKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.legalAccessRepresentativeKind" /></option>
              </g:each>
            </select>
            

    
      <label for="legalAccessRepresentativeKindDetail" class="required condition-isOtherLegalAccessRepresentative-filled"><g:message code="hcar.property.legalAccessRepresentativeKindDetail.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeKindDetail.help" /></span></label>
            <input type="text" id="legalAccessRepresentativeKindDetail" name="legalAccessRepresentativeKindDetail" value="${rqt.legalAccessRepresentativeKindDetail?.toString()}" 
                    class="required condition-isOtherLegalAccessRepresentative-filled  " title="<g:message code="hcar.property.legalAccessRepresentativeKindDetail.validationError" />"  maxlength="80" />
            

    
      <label for="legalAccessRepresentativeName" class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeName.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeName.help" /></span></label>
            <input type="text" id="legalAccessRepresentativeName" name="legalAccessRepresentativeName" value="${rqt.legalAccessRepresentativeName?.toString()}" 
                    class="required condition-isLegalAccessPresence-filled  validate-lastName" title="<g:message code="hcar.property.legalAccessRepresentativeName.validationError" />"  maxlength="38" />
            

    
      <label for="legalAccessRepresentativeFirstName" class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeFirstName.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeFirstName.help" /></span></label>
            <input type="text" id="legalAccessRepresentativeFirstName" name="legalAccessRepresentativeFirstName" value="${rqt.legalAccessRepresentativeFirstName?.toString()}" 
                    class="required condition-isLegalAccessPresence-filled  validate-firstName" title="<g:message code="hcar.property.legalAccessRepresentativeFirstName.validationError" />"  maxlength="38" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.family.label" /></legend>
    
      <label for="familyStatus" class="required"><g:message code="hcar.property.familyStatus.label" /> *  <span><g:message code="hcar.property.familyStatus.help" /></span></label>
            <select id="familyStatus" name="familyStatus" class="required  validate-not-first" title="<g:message code="hcar.property.familyStatus.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
                <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == rqt.familyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.familyStatus" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hcar.property.familyFamilyDependents.label" /> *  <span><g:message code="hcar.property.familyFamilyDependents.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="familyFamilyDependents_${it ? 'yes' : 'no'}" class="required condition-isFamilyDependents-trigger  validate-one-required boolean" title="" value="${it}" name="familyFamilyDependents" ${it == rqt.familyFamilyDependents ? 'checked="checked"': ''} />
                <label for="familyFamilyDependents_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <div class="collection required condition-isFamilyDependents-filled">
    <h3>
      <g:message code="hcar.property.familyDependents.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="hcar.property.familyDependents.help" /></span>
      <button type="submit" name="submit-collectionAdd-subject-familyDependents">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.familyDependents}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="hcar.property.familyDependents.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-subject-familyDependents[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
          <label for="familyDependents.${listIndex}.familyDependentLastName" class="required"><g:message code="hcar.property.familyDependentLastName.label" /> *  <span><g:message code="hcar.property.familyDependentLastName.help" /></span></label>
            <input type="text" id="familyDependents.${listIndex}.familyDependentLastName" name="familyDependents[${listIndex}].familyDependentLastName" value="${listItem?.familyDependentLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="hcar.property.familyDependentLastName.validationError" />"  maxlength="38" />
            

        
          <label for="familyDependents.${listIndex}.familyDependentFirstName" class="required"><g:message code="hcar.property.familyDependentFirstName.label" /> *  <span><g:message code="hcar.property.familyDependentFirstName.help" /></span></label>
            <input type="text" id="familyDependents.${listIndex}.familyDependentFirstName" name="familyDependents[${listIndex}].familyDependentFirstName" value="${listItem?.familyDependentFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="hcar.property.familyDependentFirstName.validationError" />"  maxlength="38" />
            

        
          <label for="familyDependents.${listIndex}.familyDependentBirthDate" class="required"><g:message code="hcar.property.familyDependentBirthDate.label" /> *  <span><g:message code="hcar.property.familyDependentBirthDate.help" /></span></label>
            <input type="text" id="familyDependents.${listIndex}.familyDependentBirthDate" name="familyDependents[${listIndex}].familyDependentBirthDate" value="${formatDate(formatName:'format.date',date:listItem?.familyDependentBirthDate)}" 
                   class="required  validate-date" title="<g:message code="hcar.property.familyDependentBirthDate.validationError" />" />
            

        
          <label for="familyDependents.${listIndex}.familyDependentActualSituation" class="required"><g:message code="hcar.property.familyDependentActualSituation.label" /> *  <span><g:message code="hcar.property.familyDependentActualSituation.help" /></span></label>
            <select id="familyDependents.${listIndex}.familyDependentActualSituation" name="familyDependents[${listIndex}].familyDependentActualSituation" class="required  validate-not-first" title="<g:message code="hcar.property.familyDependentActualSituation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Schooling','Learning','MedicoSocial']}">
                <option value="fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType_${it}" ${it == listItem?.familyDependentActualSituation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.familyDependentActualSituation" /></option>
              </g:each>
            </select>
            

        
      </fieldset>
    </g:each>
    </div>
  

