


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.hccrSubject.label" /></legend>
    
      
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['subject'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            <g:if test="${[fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL, fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_ADULT].contains(subjectPolicy)}">
              <a href="${createLink(controller : 'frontofficeHomeFolder', action : 'adult', params : ['mode' : 'edit', 'requestId' : rqt.id])}">
                <g:message code="homeFolder.action.addAdult" />
              </a>
            </g:if>
            <g:if test="${[fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL, fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_CHILD].contains(subjectPolicy)}">
              <a href="${createLink(controller : 'frontofficeHomeFolder', action : 'child', params : ['mode' : 'edit', 'requestId' : rqt.id])}">
                <g:message code="homeFolder.action.addChild" />
              </a>
            </g:if>
            

    
      <label class="required"><g:message code="hccr.property.subjectBirthDate.label" /> *  <span><g:message code="hccr.property.subjectBirthDate.help" /></span></label>
            <div class="date required condition-isLessThan18-trigger  validate-date required ">
              <select class="day ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthDate') ? 'validation-failed' : ''}"
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
              <select class="month ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthDate') ? 'validation-failed' : ''}"
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
                class="year ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthDate') ? 'validation-failed' : ''}"
                id="subjectBirthDate_year"
                name="subjectBirthDate_year"
                value="${rqt.subjectBirthDate ? rqt.subjectBirthDate.year + 1900 : params['subjectBirthDate_year']}"
                title="<g:message code="hccr.property.subjectBirthDate.validationError" />" />
            </div>
            

    
      <label for="subjectBirthCity" class="required"><g:message code="hccr.property.subjectBirthCity.label" /> *  <span><g:message code="hccr.property.subjectBirthCity.help" /></span></label>
            <input type="text" id="subjectBirthCity" name="subjectBirthCity" value="${rqt.subjectBirthCity?.toString()}" 
                    class="required  validate-city ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthCity') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.subjectBirthCity.validationError" />"  maxlength="32" />
            

    
      <label for="subjectBirthCountry" class="required"><g:message code="hccr.property.subjectBirthCountry.label" /> *  <span><g:message code="hccr.property.subjectBirthCountry.help" /></span></label>
            <input type="text" id="subjectBirthCountry" name="subjectBirthCountry" value="${rqt.subjectBirthCountry?.toString()}" 
                    class="required   ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthCountry') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.subjectBirthCountry.validationError" />"  maxlength="50" />
            

    
      <label for="subjectParentalAuthorityHolder" class="required condition-isLessThan18-filled"><g:message code="hccr.property.subjectParentalAuthorityHolder.label" /> *  <span><g:message code="hccr.property.subjectParentalAuthorityHolder.help" /></span></label>
            <select id="subjectParentalAuthorityHolder" name="subjectParentalAuthorityHolder" class="required condition-isLessThan18-filled  validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('subjectParentalAuthorityHolder') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.subjectParentalAuthorityHolder.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Father','Mother','Other']}">
                <option value="fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType_${it}" ${it == rqt.subjectParentalAuthorityHolder?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.subjectParentalAuthorityHolder" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <fieldset class="required condition-isLessThan18-filled">
    <legend><g:message code="hccr.property.father.label" /></legend>
    
      <label for="fatherLastName" class=""><g:message code="hccr.property.fatherLastName.label" />   <span><g:message code="hccr.property.fatherLastName.help" /></span></label>
            <input type="text" id="fatherLastName" name="fatherLastName" value="${rqt.fatherLastName?.toString()}" 
                    class="  validate-lastName ${rqt.stepStates['subject'].invalidFields.contains('fatherLastName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.fatherLastName.validationError" />"  maxlength="38" />
            

    
      <label for="fatherFirstName" class=""><g:message code="hccr.property.fatherFirstName.label" />   <span><g:message code="hccr.property.fatherFirstName.help" /></span></label>
            <input type="text" id="fatherFirstName" name="fatherFirstName" value="${rqt.fatherFirstName?.toString()}" 
                    class="  validate-firstName ${rqt.stepStates['subject'].invalidFields.contains('fatherFirstName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.fatherFirstName.validationError" />"  maxlength="38" />
            

    
      <label for="fatherJob" class=""><g:message code="hccr.property.fatherJob.label" />   <span><g:message code="hccr.property.fatherJob.help" /></span></label>
            <input type="text" id="fatherJob" name="fatherJob" value="${rqt.fatherJob?.toString()}" 
                    class="   ${rqt.stepStates['subject'].invalidFields.contains('fatherJob') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.fatherJob.validationError" />"  maxlength="60" />
            

    
      <label class=""><g:message code="hccr.property.fatherActivityReduction.label" />   <span><g:message code="hccr.property.fatherActivityReduction.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['subject'].invalidFields.contains('fatherActivityReduction') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="fatherActivityReduction_${it ? 'yes' : 'no'}" class="condition-isFatherActivityReduction-trigger  validate-one-required boolean" title="" value="${it}" name="fatherActivityReduction" ${it == rqt.fatherActivityReduction ? 'checked="checked"': ''} />
                <label for="fatherActivityReduction_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="fatherActivityReductionRatio" class="condition-isFatherActivityReduction-filled"><g:message code="hccr.property.fatherActivityReductionRatio.label" />   <span><g:message code="hccr.property.fatherActivityReductionRatio.help" /></span></label>
            <input type="text" id="fatherActivityReductionRatio" name="fatherActivityReductionRatio" value="${rqt.fatherActivityReductionRatio?.toString()}" 
                    class="condition-isFatherActivityReduction-filled  validate-positiveInteger ${rqt.stepStates['subject'].invalidFields.contains('fatherActivityReductionRatio') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.fatherActivityReductionRatio.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required condition-isLessThan18-filled">
    <legend><g:message code="hccr.property.mother.label" /></legend>
    
      <label for="motherLastName" class=""><g:message code="hccr.property.motherLastName.label" />   <span><g:message code="hccr.property.motherLastName.help" /></span></label>
            <input type="text" id="motherLastName" name="motherLastName" value="${rqt.motherLastName?.toString()}" 
                    class="  validate-lastName ${rqt.stepStates['subject'].invalidFields.contains('motherLastName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.motherLastName.validationError" />"  maxlength="38" />
            

    
      <label for="motherFirstName" class=""><g:message code="hccr.property.motherFirstName.label" />   <span><g:message code="hccr.property.motherFirstName.help" /></span></label>
            <input type="text" id="motherFirstName" name="motherFirstName" value="${rqt.motherFirstName?.toString()}" 
                    class="  validate-firstName ${rqt.stepStates['subject'].invalidFields.contains('motherFirstName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.motherFirstName.validationError" />"  maxlength="38" />
            

    
      <label for="motherJob" class=""><g:message code="hccr.property.motherJob.label" />   <span><g:message code="hccr.property.motherJob.help" /></span></label>
            <input type="text" id="motherJob" name="motherJob" value="${rqt.motherJob?.toString()}" 
                    class="   ${rqt.stepStates['subject'].invalidFields.contains('motherJob') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.motherJob.validationError" />"  maxlength="60" />
            

    
      <label class=""><g:message code="hccr.property.motherActivityReduction.label" />   <span><g:message code="hccr.property.motherActivityReduction.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['subject'].invalidFields.contains('motherActivityReduction') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="motherActivityReduction_${it ? 'yes' : 'no'}" class="condition-isMotherActivityReduction-trigger  validate-one-required boolean" title="" value="${it}" name="motherActivityReduction" ${it == rqt.motherActivityReduction ? 'checked="checked"': ''} />
                <label for="motherActivityReduction_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="motherActivityReductionRatio" class="condition-isMotherActivityReduction-filled"><g:message code="hccr.property.motherActivityReductionRatio.label" />   <span><g:message code="hccr.property.motherActivityReductionRatio.help" /></span></label>
            <input type="text" id="motherActivityReductionRatio" name="motherActivityReductionRatio" value="${rqt.motherActivityReductionRatio?.toString()}" 
                    class="condition-isMotherActivityReduction-filled  validate-positiveInteger ${rqt.stepStates['subject'].invalidFields.contains('motherActivityReductionRatio') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.motherActivityReductionRatio.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required condition-isLessThan18-filled">
    <legend><g:message code="hccr.property.aseReferent.label" /></legend>
    
      <label for="aseReferentLastName" class=""><g:message code="hccr.property.aseReferentLastName.label" />   <span><g:message code="hccr.property.aseReferentLastName.help" /></span></label>
            <input type="text" id="aseReferentLastName" name="aseReferentLastName" value="${rqt.aseReferentLastName?.toString()}" 
                    class="  validate-lastName ${rqt.stepStates['subject'].invalidFields.contains('aseReferentLastName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.aseReferentLastName.validationError" />"  maxlength="38" />
            

    
      <label for="aseReferentDepartment" class=""><g:message code="hccr.property.aseReferentDepartment.label" />   <span><g:message code="hccr.property.aseReferentDepartment.help" /></span></label>
            <input type="text" id="aseReferentDepartment" name="aseReferentDepartment" value="${rqt.aseReferentDepartment?.toString()}" 
                    class="  validate-departmentCode ${rqt.stepStates['subject'].invalidFields.contains('aseReferentDepartment') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.aseReferentDepartment.validationError" />"  maxlength="2" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.referent.label" /></legend>
    
      <label for="referentLastName" class="required"><g:message code="hccr.property.referentLastName.label" /> *  <span><g:message code="hccr.property.referentLastName.help" /></span></label>
            <input type="text" id="referentLastName" name="referentLastName" value="${rqt.referentLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['subject'].invalidFields.contains('referentLastName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentLastName.validationError" />"  maxlength="38" />
            

    
      <label for="referentFirstName" class="required"><g:message code="hccr.property.referentFirstName.label" /> *  <span><g:message code="hccr.property.referentFirstName.help" /></span></label>
            <input type="text" id="referentFirstName" name="referentFirstName" value="${rqt.referentFirstName?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['subject'].invalidFields.contains('referentFirstName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentFirstName.validationError" />"  maxlength="38" />
            

    
      <label for="referentTitle" class="required"><g:message code="hccr.property.referentTitle.label" /> *  <span><g:message code="hccr.property.referentTitle.help" /></span></label>
            <select id="referentTitle" name="referentTitle" class="required condition-isReferentMadam-trigger  validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('referentTitle') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.referentTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.referentTitle" /></option>
              </g:each>
            </select>
            

    
      <label for="referentMaidenName" class="required condition-isReferentMadam-filled"><g:message code="hccr.property.referentMaidenName.label" /> *  <span><g:message code="hccr.property.referentMaidenName.help" /></span></label>
            <input type="text" id="referentMaidenName" name="referentMaidenName" value="${rqt.referentMaidenName?.toString()}" 
                    class="required condition-isReferentMadam-filled  validate-lastName ${rqt.stepStates['subject'].invalidFields.contains('referentMaidenName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentMaidenName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="hccr.property.referentBirthDate.label" /> *  <span><g:message code="hccr.property.referentBirthDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['subject'].invalidFields.contains('referentBirthDate') ? 'validation-failed' : ''}"
                id="referentBirthDate_day"
                name="referentBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.referentBirthDate?.date == it
                      || (rqt.referentBirthDate == null && params['referentBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['subject'].invalidFields.contains('referentBirthDate') ? 'validation-failed' : ''}"
                id="referentBirthDate_month"
                name="referentBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.referentBirthDate?.month == (it - 1)
                      || (rqt.referentBirthDate == null && params['referentBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['subject'].invalidFields.contains('referentBirthDate') ? 'validation-failed' : ''}"
                id="referentBirthDate_year"
                name="referentBirthDate_year"
                value="${rqt.referentBirthDate ? rqt.referentBirthDate.year + 1900 : params['referentBirthDate_year']}"
                title="<g:message code="hccr.property.referentBirthDate.validationError" />" />
            </div>
            

    
      <label for="referentBirthCity" class="required"><g:message code="hccr.property.referentBirthCity.label" /> *  <span><g:message code="hccr.property.referentBirthCity.help" /></span></label>
            <input type="text" id="referentBirthCity" name="referentBirthCity" value="${rqt.referentBirthCity?.toString()}" 
                    class="required  validate-city ${rqt.stepStates['subject'].invalidFields.contains('referentBirthCity') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentBirthCity.validationError" />"  maxlength="32" />
            

    
      <label for="referentBirthCountry" class="required"><g:message code="hccr.property.referentBirthCountry.label" /> *  <span><g:message code="hccr.property.referentBirthCountry.help" /></span></label>
            <input type="text" id="referentBirthCountry" name="referentBirthCountry" value="${rqt.referentBirthCountry?.toString()}" 
                    class="required   ${rqt.stepStates['subject'].invalidFields.contains('referentBirthCountry') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentBirthCountry.validationError" />"  maxlength="50" />
            

    
      <label for="referentFamilyStatus" class="required"><g:message code="hccr.property.referentFamilyStatus.label" /> *  <span><g:message code="hccr.property.referentFamilyStatus.help" /></span></label>
            <select id="referentFamilyStatus" name="referentFamilyStatus" class="required  validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('referentFamilyStatus') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.referentFamilyStatus.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
                <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == rqt.referentFamilyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.referentFamilyStatus" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hccr.property.referentFamilyDependents.label" /> *  <span><g:message code="hccr.property.referentFamilyDependents.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['subject'].invalidFields.contains('referentFamilyDependents') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="referentFamilyDependents_${it ? 'yes' : 'no'}" class="required condition-isReferentFamilyDependents-trigger  validate-one-required boolean" title="" value="${it}" name="referentFamilyDependents" ${it == rqt.referentFamilyDependents ? 'checked="checked"': ''} />
                <label for="referentFamilyDependents_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="required condition-isReferentFamilyDependents-filled"><g:message code="hccr.property.familyDependents.label" /> <span><g:message code="hccr.property.familyDependents.help" /></span></label>
    <div class="collection required condition-isReferentFamilyDependents-filled summary-box">
    <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'subject', 'currentCollection':'familyDependents', 'collectionIndex':(rqt.familyDependents ? rqt.familyDependents.size() : 0)])}" />
      ${message(code:'request.action.newCollectionItem')}
    </a>
    <g:each var="it" in="${rqt.familyDependents}" status="index">
      <div class="item">
        <dl>
    
        <dt><g:message code="hccr.property.referentFamilyDependentLastName.label" /></dt>
        <dd class="${rqt.stepStates['subject'].invalidFields.contains('familyDependents[' + index + '].referentFamilyDependentLastName') ? 'validation-failed' : ''}">${it.referentFamilyDependentLastName?.toString()}</dd>
    
        <dt><g:message code="hccr.property.referentFamilyDependentFirstName.label" /></dt>
        <dd class="${rqt.stepStates['subject'].invalidFields.contains('familyDependents[' + index + '].referentFamilyDependentFirstName') ? 'validation-failed' : ''}">${it.referentFamilyDependentFirstName?.toString()}</dd>
    
        <dt><g:message code="hccr.property.referentFamilyDependentBirthDate.label" /></dt>
        <dd class="${rqt.stepStates['subject'].invalidFields.contains('familyDependents[' + index + '].referentFamilyDependentBirthDate') ? 'validation-failed' : ''}"><g:formatDate formatName="format.date" date="${it.referentFamilyDependentBirthDate}"/></dd>
    
        <dt><g:message code="hccr.property.referentFamilyDependentActualSituation.label" /></dt>
        
              <dd class="${rqt.stepStates['subject'].invalidFields.contains('familyDependents[' + index + '].referentFamilyDependentActualSituation') ? 'validation-failed' : ''}">
                <g:if test="${it.referentFamilyDependentActualSituation}">
                  <g:capdematEnumToField var="${it.referentFamilyDependentActualSituation}" i18nKeyPrefix="hccr.property.referentFamilyDependentActualSituation" />
                </g:if>
              </dd>
              
    
        </dl>
         <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'subject', 'currentCollection':'familyDependents', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'subject', 'currentCollection':'familyDependents', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
      </div>
    </g:each>
    </div>
  

