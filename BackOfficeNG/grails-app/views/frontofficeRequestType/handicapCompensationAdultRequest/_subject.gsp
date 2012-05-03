


  
    <fieldset class="required">
    <legend><g:message code="hcar.property.hcarSubject.label" /></legend>
    
      
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${stepStates != null && stepStates['subject']?.invalidFields?.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

    
      <label for="subjectTitle" class="required"><g:message code="hcar.property.subjectTitle.label" /> *  <span><g:message code="hcar.property.subjectTitle.help" /></span></label>
            <select id="subjectTitle" name="subjectTitle" class="required condition-isMadam-trigger  validate-not-first ${stepStates != null && stepStates['subject']?.invalidFields?.contains('subjectTitle') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.subjectTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.subjectTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.subjectTitle" /></option>
              </g:each>
            </select>
            

    
      <label for="subjectMaidenName" class="required condition-isMadam-filled"><g:message code="hcar.property.subjectMaidenName.label" /> *  <span><g:message code="hcar.property.subjectMaidenName.help" /></span></label>
            <input type="text" id="subjectMaidenName" name="subjectMaidenName" value="${rqt.subjectMaidenName?.toString()}" 
                    class="required condition-isMadam-filled  validate-lastName ${stepStates != null && stepStates['subject']?.invalidFields?.contains('subjectMaidenName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.subjectMaidenName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="hcar.property.subjectBirthDate.label" /> *  <span><g:message code="hcar.property.subjectBirthDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${stepStates != null && stepStates['subject']?.invalidFields?.contains('subjectBirthDate') ? 'validation-failed' : ''}"
                id="subjectBirthDate_day"
                name="subjectBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.subjectBirthDate?.date == it
                      || (rqt.subjectBirthDate == null && params['subjectBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['subject']?.invalidFields?.contains('subjectBirthDate') ? 'validation-failed' : ''}"
                id="subjectBirthDate_month"
                name="subjectBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.subjectBirthDate?.month == (it - 1)
                      || (rqt.subjectBirthDate == null && params['subjectBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${stepStates != null && stepStates['subject']?.invalidFields?.contains('subjectBirthDate') ? 'validation-failed' : ''}"
                id="subjectBirthDate_year"
                name="subjectBirthDate_year"
                value="${rqt.subjectBirthDate ? rqt.subjectBirthDate.year + 1900 : params['subjectBirthDate_year']}"
                title="<g:message code="hcar.property.subjectBirthDate.validationError" />" />
            </div>
            

    
      <label for="subjectBirthCity" class="required"><g:message code="hcar.property.subjectBirthCity.label" /> *  <span><g:message code="hcar.property.subjectBirthCity.help" /></span></label>
            <input type="text" id="subjectBirthCity" name="subjectBirthCity" value="${rqt.subjectBirthCity?.toString()}" 
                    class="required  validate-city ${stepStates != null && stepStates['subject']?.invalidFields?.contains('subjectBirthCity') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.subjectBirthCity.validationError" />"  maxlength="32" />
            

    
      <label for="subjectBirthCountry" class="required"><g:message code="hcar.property.subjectBirthCountry.label" /> *  <span><g:message code="hcar.property.subjectBirthCountry.help" /></span></label>
            <input type="text" id="subjectBirthCountry" name="subjectBirthCountry" value="${rqt.subjectBirthCountry?.toString()}" 
                    class="required   ${stepStates != null && stepStates['subject']?.invalidFields?.contains('subjectBirthCountry') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.subjectBirthCountry.validationError" />"  maxlength="50" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.legalAccess.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.legalAccessPresence.label" /> *  <span><g:message code="hcar.property.legalAccessPresence.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['subject']?.invalidFields?.contains('legalAccessPresence') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="legalAccessPresence_${it ? 'yes' : 'no'}" class="required condition-isLegalAccessPresence-trigger  validate-one-required boolean" title="" value="${it}" name="legalAccessPresence" ${it == rqt.legalAccessPresence ? 'checked="checked"': ''} />
                <label for="legalAccessPresence_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="legalAccessKind" class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessKind.label" /> *  <span><g:message code="hcar.property.legalAccessKind.help" /></span></label>
            <select id="legalAccessKind" name="legalAccessKind" class="required condition-isLegalAccessPresence-filled  validate-not-first ${stepStates != null && stepStates['subject']?.invalidFields?.contains('legalAccessKind') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.legalAccessKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['safeguardingJustice','guardianship','curatorship']}">
                <option value="fr.cg95.cvq.business.request.social.HcarLegalAccessKindType_${it}" ${it == rqt.legalAccessKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.legalAccessKind" /></option>
              </g:each>
            </select>
            

    
      <label for="legalAccessRepresentativeKind" class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeKind.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeKind.help" /></span></label>
            <select id="legalAccessRepresentativeKind" name="legalAccessRepresentativeKind" class="required condition-isLegalAccessPresence-filled condition-isOtherLegalAccessRepresentative-trigger  validate-not-first ${stepStates != null && stepStates['subject']?.invalidFields?.contains('legalAccessRepresentativeKind') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.legalAccessRepresentativeKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['FamilyMember','Agency','Other']}">
                <option value="fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType_${it}" ${it == rqt.legalAccessRepresentativeKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.legalAccessRepresentativeKind" /></option>
              </g:each>
            </select>
            

    
      <label for="legalAccessRepresentativeKindDetail" class="required condition-isOtherLegalAccessRepresentative-filled"><g:message code="hcar.property.legalAccessRepresentativeKindDetail.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeKindDetail.help" /></span></label>
            <input type="text" id="legalAccessRepresentativeKindDetail" name="legalAccessRepresentativeKindDetail" value="${rqt.legalAccessRepresentativeKindDetail?.toString()}" 
                    class="required condition-isOtherLegalAccessRepresentative-filled   ${stepStates != null && stepStates['subject']?.invalidFields?.contains('legalAccessRepresentativeKindDetail') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.legalAccessRepresentativeKindDetail.validationError" />"  maxlength="80" />
            

    
      <label for="legalAccessRepresentativeName" class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeName.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeName.help" /></span></label>
            <input type="text" id="legalAccessRepresentativeName" name="legalAccessRepresentativeName" value="${rqt.legalAccessRepresentativeName?.toString()}" 
                    class="required condition-isLegalAccessPresence-filled  validate-lastName ${stepStates != null && stepStates['subject']?.invalidFields?.contains('legalAccessRepresentativeName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.legalAccessRepresentativeName.validationError" />"  maxlength="38" />
            

    
      <label for="legalAccessRepresentativeFirstName" class="required condition-isLegalAccessPresence-filled"><g:message code="hcar.property.legalAccessRepresentativeFirstName.label" /> *  <span><g:message code="hcar.property.legalAccessRepresentativeFirstName.help" /></span></label>
            <input type="text" id="legalAccessRepresentativeFirstName" name="legalAccessRepresentativeFirstName" value="${rqt.legalAccessRepresentativeFirstName?.toString()}" 
                    class="required condition-isLegalAccessPresence-filled  validate-firstName ${stepStates != null && stepStates['subject']?.invalidFields?.contains('legalAccessRepresentativeFirstName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.legalAccessRepresentativeFirstName.validationError" />"  maxlength="38" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.family.label" /></legend>
    
      <label for="familyStatus" class="required"><g:message code="hcar.property.familyStatus.label" /> *  <span><g:message code="hcar.property.familyStatus.help" /></span></label>
            <select id="familyStatus" name="familyStatus" class="required  validate-not-first ${stepStates != null && stepStates['subject']?.invalidFields?.contains('familyStatus') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyStatus.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','Separated','PACS','Other']}">
                <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == rqt.familyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.familyStatus" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hcar.property.familyFamilyDependents.label" /> *  <span><g:message code="hcar.property.familyFamilyDependents.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['subject']?.invalidFields?.contains('familyFamilyDependents') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="familyFamilyDependents_${it ? 'yes' : 'no'}" class="required condition-isFamilyDependents-trigger  validate-one-required boolean" title="" value="${it}" name="familyFamilyDependents" ${it == rqt.familyFamilyDependents ? 'checked="checked"': ''} />
                <label for="familyFamilyDependents_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="required condition-isFamilyDependents-filled"><g:message code="hcar.property.familyDependents.label" /> <span><g:message code="hcar.property.familyDependents.help" /></span></label>
    <div class="collection-fieldset required condition-isFamilyDependents-filled validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'familyDependents' ? editList?.index : ( rqt.familyDependents ? rqt.familyDependents.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required condition-isFamilyDependents-filled">
    
        <label for="familyDependents.${listIndex}.familyDependentLastName" class="required"><g:message code="hcar.property.familyDependentLastName.label" /> *  <span><g:message code="hcar.property.familyDependentLastName.help" /></span></label>
            <input type="text" id="familyDependents.${listIndex}.familyDependentLastName" name="familyDependents[${listIndex}].familyDependentLastName" value="${editList?.familyDependents?.familyDependentLastName?.toString()}" 
                    class="required  validate-lastName ${stepStates != null && stepStates['subject']?.invalidFields?.contains('familyDependents.familyDependentLastName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyDependentLastName.validationError" />"  maxlength="38" />
            

    
        <label for="familyDependents.${listIndex}.familyDependentFirstName" class="required"><g:message code="hcar.property.familyDependentFirstName.label" /> *  <span><g:message code="hcar.property.familyDependentFirstName.help" /></span></label>
            <input type="text" id="familyDependents.${listIndex}.familyDependentFirstName" name="familyDependents[${listIndex}].familyDependentFirstName" value="${editList?.familyDependents?.familyDependentFirstName?.toString()}" 
                    class="required  validate-firstName ${stepStates != null && stepStates['subject']?.invalidFields?.contains('familyDependents.familyDependentFirstName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyDependentFirstName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="hcar.property.familyDependentBirthDate.label" /> *  <span><g:message code="hcar.property.familyDependentBirthDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${stepStates != null && stepStates['subject']?.invalidFields?.contains('familyDependents.familyDependentBirthDate') ? 'validation-failed' : ''}"
                id="familyDependents.${listIndex}.familyDependentBirthDate_day"
                name="familyDependents[${listIndex}].familyDependentBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${editList?.familyDependents?.familyDependentBirthDate?.date == it
                      || (editList?.familyDependents?.familyDependentBirthDate == null && params['familyDependents[${listIndex}].familyDependentBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['subject']?.invalidFields?.contains('familyDependents.familyDependentBirthDate') ? 'validation-failed' : ''}"
                id="familyDependents.${listIndex}.familyDependentBirthDate_month"
                name="familyDependents[${listIndex}].familyDependentBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${editList?.familyDependents?.familyDependentBirthDate?.month == (it - 1)
                      || (editList?.familyDependents?.familyDependentBirthDate == null && params['familyDependents[${listIndex}].familyDependentBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${stepStates != null && stepStates['subject']?.invalidFields?.contains('familyDependents.familyDependentBirthDate') ? 'validation-failed' : ''}"
                id="familyDependents.${listIndex}.familyDependentBirthDate_year"
                name="familyDependents[${listIndex}].familyDependentBirthDate_year"
                value="${editList?.familyDependents?.familyDependentBirthDate ? editList?.familyDependents?.familyDependentBirthDate.year + 1900 : params['familyDependents.familyDependentBirthDate_year']}"
                title="<g:message code="hcar.property.familyDependentBirthDate.validationError" />" />
            </div>
            

    
        <label for="familyDependents.${listIndex}.familyDependentActualSituation" class="required"><g:message code="hcar.property.familyDependentActualSituation.label" /> *  <span><g:message code="hcar.property.familyDependentActualSituation.help" /></span></label>
            <select id="familyDependents.${listIndex}.familyDependentActualSituation" name="familyDependents[${listIndex}].familyDependentActualSituation" class="required  validate-not-first ${stepStates != null && stepStates['subject']?.invalidFields?.contains('familyDependents.familyDependentActualSituation') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.familyDependentActualSituation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Schooling','Learning','MedicoSocial']}">
                <option value="fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType_${it}" ${it == editList?.familyDependents?.familyDependentActualSituation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.familyDependentActualSituation" /></option>
              </g:each>
            </select>
            

    
        <g:if test="${editList?.name == 'familyDependents'}">
          <input type="submit" id="submit-collectionModify-subject-familyDependents" name="submit-collectionModify-subject-familyDependents[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-subject-familyDependents" name="submit-collectionAdd-subject-familyDependents[${listIndex}]" value="${message(code:'action.add')}" />
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
  

