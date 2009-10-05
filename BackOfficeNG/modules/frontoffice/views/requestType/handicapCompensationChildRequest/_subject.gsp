


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.hccrSubject.label" /></legend>
    
      <label class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first " title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hccr.property.subjectBirthDate.label" /> *  <span><g:message code="hccr.property.subjectBirthDate.help" /></span></label>
            <input type="text" name="subjectBirthDate" value="${formatDate(formatName:'format.date',date:rqt.subjectBirthDate)}" 
                   class="required condition-isLessThan18-trigger  validate-date" title="<g:message code="hccr.property.subjectBirthDate.validationError" />" />
            

    
      <label class="required"><g:message code="hccr.property.subjectBirthCity.label" /> *  <span><g:message code="hccr.property.subjectBirthCity.help" /></span></label>
            <input type="text" name="subjectBirthCity" value="${rqt.subjectBirthCity?.toString()}" 
                    class="required  validate-city" title="<g:message code="hccr.property.subjectBirthCity.validationError" />"  maxlength="32" />
            

    
      <label class="required"><g:message code="hccr.property.subjectBirthCountry.label" /> *  <span><g:message code="hccr.property.subjectBirthCountry.help" /></span></label>
            <input type="text" name="subjectBirthCountry" value="${rqt.subjectBirthCountry?.toString()}" 
                    class="required  " title="<g:message code="hccr.property.subjectBirthCountry.validationError" />"  maxlength="50" />
            

    
      <label class="required condition-isLessThan18-filled"><g:message code="hccr.property.subjectParentalAuthorityHolder.label" /> *  <span><g:message code="hccr.property.subjectParentalAuthorityHolder.help" /></span></label>
            <select name="subjectParentalAuthorityHolder" class="required condition-isLessThan18-filled  validate-not-first" title="<g:message code="hccr.property.subjectParentalAuthorityHolder.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Father','Mother','Other']}">
                <option value="fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType_${it}" ${it == rqt.subjectParentalAuthorityHolder?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.subjectParentalAuthorityHolder" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <fieldset class="required condition-isLessThan18-filled">
    <legend><g:message code="hccr.property.father.label" /></legend>
    
      <label class=""><g:message code="hccr.property.fatherLastName.label" />   <span><g:message code="hccr.property.fatherLastName.help" /></span></label>
            <input type="text" name="fatherLastName" value="${rqt.fatherLastName?.toString()}" 
                    class="  validate-lastName" title="<g:message code="hccr.property.fatherLastName.validationError" />"  maxlength="38" />
            

    
      <label class=""><g:message code="hccr.property.fatherFirstName.label" />   <span><g:message code="hccr.property.fatherFirstName.help" /></span></label>
            <input type="text" name="fatherFirstName" value="${rqt.fatherFirstName?.toString()}" 
                    class="  validate-firstName" title="<g:message code="hccr.property.fatherFirstName.validationError" />"  maxlength="38" />
            

    
      <label class=""><g:message code="hccr.property.fatherJob.label" />   <span><g:message code="hccr.property.fatherJob.help" /></span></label>
            <input type="text" name="fatherJob" value="${rqt.fatherJob?.toString()}" 
                    class="  " title="<g:message code="hccr.property.fatherJob.validationError" />"  maxlength="60" />
            

    
      <label class=""><g:message code="hccr.property.fatherActivityReduction.label" />   <span><g:message code="hccr.property.fatherActivityReduction.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="condition-isFatherActivityReduction-trigger  validate-one-required boolean" title="" value="${it}" name="fatherActivityReduction" ${it == rqt.fatherActivityReduction ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isFatherActivityReduction-filled"><g:message code="hccr.property.fatherActivityReductionRatio.label" />   <span><g:message code="hccr.property.fatherActivityReductionRatio.help" /></span></label>
            <input type="text" name="fatherActivityReductionRatio" value="${rqt.fatherActivityReductionRatio?.toString()}" 
                    class="condition-isFatherActivityReduction-filled  validate-positiveInteger" title="<g:message code="hccr.property.fatherActivityReductionRatio.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required condition-isLessThan18-filled">
    <legend><g:message code="hccr.property.mother.label" /></legend>
    
      <label class=""><g:message code="hccr.property.motherLastName.label" />   <span><g:message code="hccr.property.motherLastName.help" /></span></label>
            <input type="text" name="motherLastName" value="${rqt.motherLastName?.toString()}" 
                    class="  validate-lastName" title="<g:message code="hccr.property.motherLastName.validationError" />"  maxlength="38" />
            

    
      <label class=""><g:message code="hccr.property.motherFirstName.label" />   <span><g:message code="hccr.property.motherFirstName.help" /></span></label>
            <input type="text" name="motherFirstName" value="${rqt.motherFirstName?.toString()}" 
                    class="  validate-firstName" title="<g:message code="hccr.property.motherFirstName.validationError" />"  maxlength="38" />
            

    
      <label class=""><g:message code="hccr.property.motherJob.label" />   <span><g:message code="hccr.property.motherJob.help" /></span></label>
            <input type="text" name="motherJob" value="${rqt.motherJob?.toString()}" 
                    class="  " title="<g:message code="hccr.property.motherJob.validationError" />"  maxlength="60" />
            

    
      <label class=""><g:message code="hccr.property.motherActivityReduction.label" />   <span><g:message code="hccr.property.motherActivityReduction.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="condition-isMotherActivityReduction-trigger  validate-one-required boolean" title="" value="${it}" name="motherActivityReduction" ${it == rqt.motherActivityReduction ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="condition-isMotherActivityReduction-filled"><g:message code="hccr.property.motherActivityReductionRatio.label" />   <span><g:message code="hccr.property.motherActivityReductionRatio.help" /></span></label>
            <input type="text" name="motherActivityReductionRatio" value="${rqt.motherActivityReductionRatio?.toString()}" 
                    class="condition-isMotherActivityReduction-filled  validate-positiveInteger" title="<g:message code="hccr.property.motherActivityReductionRatio.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required condition-isLessThan18-filled">
    <legend><g:message code="hccr.property.aseReferent.label" /></legend>
    
      <label class=""><g:message code="hccr.property.aseReferentLastName.label" />   <span><g:message code="hccr.property.aseReferentLastName.help" /></span></label>
            <input type="text" name="aseReferentLastName" value="${rqt.aseReferentLastName?.toString()}" 
                    class="  validate-lastName" title="<g:message code="hccr.property.aseReferentLastName.validationError" />"  maxlength="38" />
            

    
      <label class=""><g:message code="hccr.property.aseReferentDepartment.label" />   <span><g:message code="hccr.property.aseReferentDepartment.help" /></span></label>
            <input type="text" name="aseReferentDepartment" value="${rqt.aseReferentDepartment?.toString()}" 
                    class="  validate-departmentCode" title="<g:message code="hccr.property.aseReferentDepartment.validationError" />"  maxlength="2" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.referent.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.referentLastName.label" /> *  <span><g:message code="hccr.property.referentLastName.help" /></span></label>
            <input type="text" name="referentLastName" value="${rqt.referentLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="hccr.property.referentLastName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="hccr.property.referentFirstName.label" /> *  <span><g:message code="hccr.property.referentFirstName.help" /></span></label>
            <input type="text" name="referentFirstName" value="${rqt.referentFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="hccr.property.referentFirstName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="hccr.property.referentTitle.label" /> *  <span><g:message code="hccr.property.referentTitle.help" /></span></label>
            <select name="referentTitle" class="required condition-isReferentMadam-trigger  validate-not-first" title="<g:message code="hccr.property.referentTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.referentTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.referentTitle" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isReferentMadam-filled"><g:message code="hccr.property.referentMaidenName.label" /> *  <span><g:message code="hccr.property.referentMaidenName.help" /></span></label>
            <input type="text" name="referentMaidenName" value="${rqt.referentMaidenName?.toString()}" 
                    class="required condition-isReferentMadam-filled  validate-lastName" title="<g:message code="hccr.property.referentMaidenName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="hccr.property.referentBirthDate.label" /> *  <span><g:message code="hccr.property.referentBirthDate.help" /></span></label>
            <input type="text" name="referentBirthDate" value="${formatDate(formatName:'format.date',date:rqt.referentBirthDate)}" 
                   class="required  validate-date" title="<g:message code="hccr.property.referentBirthDate.validationError" />" />
            

    
      <label class="required"><g:message code="hccr.property.referentBirthCity.label" /> *  <span><g:message code="hccr.property.referentBirthCity.help" /></span></label>
            <input type="text" name="referentBirthCity" value="${rqt.referentBirthCity?.toString()}" 
                    class="required  validate-city" title="<g:message code="hccr.property.referentBirthCity.validationError" />"  maxlength="32" />
            

    
      <label class="required"><g:message code="hccr.property.referentBirthCountry.label" /> *  <span><g:message code="hccr.property.referentBirthCountry.help" /></span></label>
            <input type="text" name="referentBirthCountry" value="${rqt.referentBirthCountry?.toString()}" 
                    class="required  " title="<g:message code="hccr.property.referentBirthCountry.validationError" />"  maxlength="50" />
            

    
      <label class="required"><g:message code="hccr.property.referentFamilyStatus.label" /> *  <span><g:message code="hccr.property.referentFamilyStatus.help" /></span></label>
            <select name="referentFamilyStatus" class="required  validate-not-first" title="<g:message code="hccr.property.referentFamilyStatus.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
                <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == rqt.referentFamilyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.referentFamilyStatus" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hccr.property.referentFamilyDependents.label" /> *  <span><g:message code="hccr.property.referentFamilyDependents.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isReferentFamilyDependents-trigger  validate-one-required boolean" title="" value="${it}" name="referentFamilyDependents" ${it == rqt.referentFamilyDependents ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <label class="required condition-isReferentFamilyDependents-filled"><g:message code="hccr.property.familyDependents.label" /> <span><g:message code="hccr.property.familyDependents.help" /></span></label>
    <div class="collection-fieldset required condition-isReferentFamilyDependents-filled validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'familyDependents' ? editList?.index : ( rqt.familyDependents ? rqt.familyDependents.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required condition-isReferentFamilyDependents-filled">
    
        <label class="required"><g:message code="hccr.property.referentFamilyDependentLastName.label" /> *  <span><g:message code="hccr.property.referentFamilyDependentLastName.help" /></span></label>
            <input type="text" name="familyDependents[${listIndex}].referentFamilyDependentLastName" value="${editList?.familyDependents?.referentFamilyDependentLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="hccr.property.referentFamilyDependentLastName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="hccr.property.referentFamilyDependentFirstName.label" /> *  <span><g:message code="hccr.property.referentFamilyDependentFirstName.help" /></span></label>
            <input type="text" name="familyDependents[${listIndex}].referentFamilyDependentFirstName" value="${editList?.familyDependents?.referentFamilyDependentFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="hccr.property.referentFamilyDependentFirstName.validationError" />"  maxlength="38" />
            

    
        <label class="required"><g:message code="hccr.property.referentFamilyDependentBirthDate.label" /> *  <span><g:message code="hccr.property.referentFamilyDependentBirthDate.help" /></span></label>
            <input type="text" name="familyDependents[${listIndex}].referentFamilyDependentBirthDate" value="${formatDate(formatName:'format.date',date:editList?.familyDependents?.referentFamilyDependentBirthDate)}" 
                   class="required  validate-date" title="<g:message code="hccr.property.referentFamilyDependentBirthDate.validationError" />" />
            

    
        <label class="required"><g:message code="hccr.property.referentFamilyDependentActualSituation.label" /> *  <span><g:message code="hccr.property.referentFamilyDependentActualSituation.help" /></span></label>
            <select name="familyDependents[${listIndex}].referentFamilyDependentActualSituation" class="required  validate-not-first" title="<g:message code="hccr.property.referentFamilyDependentActualSituation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Schooling','Learning','MedicoSocial']}">
                <option value="fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType_${it}" ${it == editList?.familyDependents?.referentFamilyDependentActualSituation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.referentFamilyDependentActualSituation" /></option>
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
    
        <dt><g:message code="hccr.property.referentFamilyDependentLastName.label" /></dt>
        <dd>${it.referentFamilyDependentLastName?.toString()}</dd>
    
        <dt><g:message code="hccr.property.referentFamilyDependentFirstName.label" /></dt>
        <dd>${it.referentFamilyDependentFirstName?.toString()}</dd>
    
        <dt><g:message code="hccr.property.referentFamilyDependentBirthDate.label" /></dt>
        <dd><g:formatDate formatName="format.date" date="${it.referentFamilyDependentBirthDate}"/></dd>
    
        <dt><g:message code="hccr.property.referentFamilyDependentActualSituation.label" /></dt>
        
              <dd>
                <g:if test="${it.referentFamilyDependentActualSituation}">
                  <g:capdematEnumToField var="${it.referentFamilyDependentActualSituation}" i18nKeyPrefix="hccr.property.referentFamilyDependentActualSituation" />
                </g:if>
              </dd>
              
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-subject-familyDependents[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-subject-familyDependents[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

