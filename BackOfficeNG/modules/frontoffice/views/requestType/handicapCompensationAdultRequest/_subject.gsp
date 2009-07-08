


  
    <fieldset class="required">
    <legend><g:message code="hcar.property.hcarSubject.label" /></legend>
    
      <label class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first " title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hcar.property.subjectTitle.label" /> *  <span><g:message code="hcar.property.subjectTitle.help" /></span></label>
            <select name="subjectTitle" class="required condition-isMadam-trigger  validate-not-first" title="<g:message code="hcar.property.subjectTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.subjectTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hcar.property.subjectTitle" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isMadam-filled"><g:message code="hcar.property.subjectMaidenName.label" /> *  <span><g:message code="hcar.property.subjectMaidenName.help" /></span></label>
            <input type="text" name="subjectMaidenName" value="${rqt.subjectMaidenName?.toString()}" 
                    class="required condition-isMadam-filled  validate-lastName" title="<g:message code="hcar.property.subjectMaidenName.validationError" />"  maxLength="38"/>
            

    
      <label class="required"><g:message code="hcar.property.subjectBirthDate.label" /> *  <span><g:message code="hcar.property.subjectBirthDate.help" /></span></label>
            <input type="text" name="subjectBirthDate" value="${formatDate(formatName:'format.date',date:rqt.subjectBirthDate)}" 
                   class="required  validate-date" title="<g:message code="hcar.property.subjectBirthDate.validationError" />" />
            

    
      <label class="required"><g:message code="hcar.property.subjectBirthCity.label" /> *  <span><g:message code="hcar.property.subjectBirthCity.help" /></span></label>
            <input type="text" name="subjectBirthCity" value="${rqt.subjectBirthCity?.toString()}" 
                    class="required  validate-city" title="<g:message code="hcar.property.subjectBirthCity.validationError" />"  maxLength="32"/>
            

    
      <label class="required"><g:message code="hcar.property.subjectBirthCountry.label" /> *  <span><g:message code="hcar.property.subjectBirthCountry.help" /></span></label>
            <input type="text" name="subjectBirthCountry" value="${rqt.subjectBirthCountry?.toString()}" 
                    class="required  " title="<g:message code="hcar.property.subjectBirthCountry.validationError" />"  maxLength="50"/>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.legalAccess.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.legalAccessPresence.label" /> *  <span><g:message code="hcar.property.legalAccessPresence.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isLegalAccessPresence-trigger  validate-one-required boolean" title="" value="${it}" name="legalAccessPresence" ${it == rqt.legalAccessPresence ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessKind.label" /> *  <span><g:message code="hcar.property.legalAccessKind.help" /></span></label>
            <select name="legalAccessKind" class="required condition-isLegalAccessPresence-filled  validate-not-first" title="<g:message code="hcar.property.legalAccessKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['safeguardingJustice','guardianship','curatorship']}">
                <option value="fr.cg95.cvq.business.request.social.HcarLegalAccessKindType_${it}" ${it == rqt.legalAccessKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hcar.property.legalAccessKind" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeKind.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeKind.help" /></span></label>
            <select name="legalAccessRepresentativeKind" class="required condition-isLegalAccessPresence-filled condition-isOtherLegalAccessRepresentative-trigger  validate-not-first" title="<g:message code="hcar.property.legalAccessRepresentativeKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['FamilyMember','Agency','Other']}">
                <option value="fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType_${it}" ${it == rqt.legalAccessRepresentativeKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hcar.property.legalAccessRepresentativeKind" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isOtherLegalAccessRepresentative-filled"><g:message code="hcar.property.legalAccessRepresentativeKindDetail.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeKindDetail.help" /></span></label>
            <input type="text" name="legalAccessRepresentativeKindDetail" value="${rqt.legalAccessRepresentativeKindDetail?.toString()}" 
                    class="required condition-isOtherLegalAccessRepresentative-filled  " title="<g:message code="hcar.property.legalAccessRepresentativeKindDetail.validationError" />"  maxLength="80"/>
            

    
      <label class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeName.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeName.help" /></span></label>
            <input type="text" name="legalAccessRepresentativeName" value="${rqt.legalAccessRepresentativeName?.toString()}" 
                    class="required condition-isLegalAccessPresence-filled  validate-lastName" title="<g:message code="hcar.property.legalAccessRepresentativeName.validationError" />"  maxLength="38"/>
            

    
      <label class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeFirstName.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeFirstName.help" /></span></label>
            <input type="text" name="legalAccessRepresentativeFirstName" value="${rqt.legalAccessRepresentativeFirstName?.toString()}" 
                    class="required condition-isLegalAccessPresence-filled  validate-firstName" title="<g:message code="hcar.property.legalAccessRepresentativeFirstName.validationError" />"  maxLength="38"/>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.family.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.familyStatus.label" /> *  <span><g:message code="hcar.property.familyStatus.help" /></span></label>
            <select name="familyStatus" class="required  validate-not-first" title="<g:message code="hcar.property.familyStatus.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
                <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == rqt.familyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hcar.property.familyStatus" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hcar.property.familyFamilyDependents.label" /> *  <span><g:message code="hcar.property.familyFamilyDependents.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isFamilyDependents-trigger  validate-one-required boolean" title="" value="${it}" name="familyFamilyDependents" ${it == rqt.familyFamilyDependents ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="required condition-isFamilyDependents-filled"><g:message code="hcar.property.familyDependents.label" /> <span><g:message code="hcar.property.familyDependents.help" /></span></label>
    <div class="collection-fieldset required condition-isFamilyDependents-filled validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'familyDependents' ? editList?.index : ( rqt.familyDependents ? rqt.familyDependents.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required condition-isFamilyDependents-filled">
    
        <label class="required"><g:message code="hcar.property.familyDependentLastName.label" /> *  <span><g:message code="hcar.property.familyDependentLastName.help" /></span></label>
            <input type="text" name="familyDependents[${listIndex}].familyDependentLastName" value="${editList?.familyDependents?.familyDependentLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="hcar.property.familyDependentLastName.validationError" />"  maxLength="38"/>
            

    
        <label class="required"><g:message code="hcar.property.familyDependentFirstName.label" /> *  <span><g:message code="hcar.property.familyDependentFirstName.help" /></span></label>
            <input type="text" name="familyDependents[${listIndex}].familyDependentFirstName" value="${editList?.familyDependents?.familyDependentFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="hcar.property.familyDependentFirstName.validationError" />"  maxLength="38"/>
            

    
        <label class="required"><g:message code="hcar.property.familyDependentBirthDate.label" /> *  <span><g:message code="hcar.property.familyDependentBirthDate.help" /></span></label>
            <input type="text" name="familyDependents[${listIndex}].familyDependentBirthDate" value="${formatDate(formatName:'format.date',date:editList?.familyDependents?.familyDependentBirthDate)}" 
                   class="required  validate-date" title="<g:message code="hcar.property.familyDependentBirthDate.validationError" />" />
            

    
        <label class="required"><g:message code="hcar.property.familyDependentActualSituation.label" /> *  <span><g:message code="hcar.property.familyDependentActualSituation.help" /></span></label>
            <select name="familyDependents[${listIndex}].familyDependentActualSituation" class="required  validate-not-first" title="<g:message code="hcar.property.familyDependentActualSituation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Schooling','Learning','MedicoSocial']}">
                <option value="fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType_${it}" ${it == editList?.familyDependents?.familyDependentActualSituation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hcar.property.familyDependentActualSituation" /></option>
              </g:each>
            </select>
            

    
        <g:if test="${editList?.name == 'familyDependents'}">
          <input type="submit" id="submit-collectionModify-subject-familyDependents[${listIndex}]" name="submit-collectionModify-subject-familyDependents[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-subject-familyDependents[${listIndex}]" name="submit-collectionAdd-subject-familyDependents[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.familyDependents}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        <dt><g:message code="hcar.property.familyDependentLastName.label" /></dt>
        <dd>${it.familyDependentLastName?.toString()}</dd>
    
        <dt><g:message code="hcar.property.familyDependentFirstName.label" /></dt>
        <dd>${it.familyDependentFirstName?.toString()}</dd>
    
        <dt><g:message code="hcar.property.familyDependentBirthDate.label" /></dt>
        <dd><g:formatDate formatName="format.date" date="${it.familyDependentBirthDate}"/></dd>
    
        <dt><g:message code="hcar.property.familyDependentActualSituation.label" /></dt>
        
              <dd>
                <g:if test="${it.familyDependentActualSituation}">
                  <g:capdematEnumToField var="${it.familyDependentActualSituation}" i18nKeyPrefix="hcar.property.familyDependentActualSituation" />
                </g:if>
              </dd>
              
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-subject-familyDependents[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-subject-familyDependents[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

