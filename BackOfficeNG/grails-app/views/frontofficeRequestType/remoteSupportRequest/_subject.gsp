


  
    <fieldset class="required">
    <legend><g:message code="rsr.property.rsrSubject.label" /></legend>
    
      
            <label for="subjectId" class="required">
              <g:message code="request.property.subject.label" /> *
              <span><g:message code="request.property.subject.help" /></span>
              <g:if test="${!fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_NONE.equals(subjectPolicy)}">
                <g:if test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_ADULT.equals(subjectPolicy)}">
                  <span>(<a id="addSubjectLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                </g:if>
                <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_CHILD.equals(subjectPolicy)}">
                  <span>(<a id="addSubjectLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                </g:elseif>
                <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL.equals(subjectPolicy)}">
                  <span>(<a id="addAdultLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addAdult" /></a>
                  <g:message code="message.or" />
                  <a id="addChildLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addChild" /></a>)</span>
                </g:elseif>
              </g:if>
            </label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first autofill-subjectFilling-trigger ${rqt.stepStates['subject'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

    
      <label for="subjectTitle" class="required"><g:message code="rsr.property.subjectTitle.label" /> *  <span><g:message code="rsr.property.subjectTitle.help" /></span></label>
            <select id="subjectTitle" name="subjectTitle" class="required autofill-subjectFilling-listener-Title validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('subjectTitle') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.subjectTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.subjectTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="rsr.property.subjectTitle" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="rsr.property.subjectBirthDate.label" /> *  <span><g:message code="rsr.property.subjectBirthDate.help" /></span></label>
            <div class="date required autofill-subjectFilling-listener-BirthDate validate-date required autofill-subjectFilling-listener-BirthDate">
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
                title="<g:message code="rsr.property.subjectBirthDate.validationError" />" />
            </div>
            

    
      <label class="required"><g:message code="rsr.property.subjectResideWith.label" /> *  <span><g:message code="rsr.property.subjectResideWith.help" /></span></label>
            <ul class="required ${rqt.stepStates['subject'].invalidFields.contains('subjectResideWith') ? 'validation-failed' : ''}">
              <g:each in="${['Alone','Couple','Family']}">
              <li>
                <input type="radio" id="subjectResideWith_${it}" class="required  validate-one-required" value="fr.cg95.cvq.business.request.social.RsrSubjectResideWithType_${it}" name="subjectResideWith" ${it == rqt.subjectResideWith.toString() ? 'checked="checked"': ''} title="<g:message code="rsr.property.subjectResideWith.validationError" />" />
                <label for="subjectResideWith_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="rsr.property.subjectResideWith" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="rsr.property.subjectIsTaxable.label" /> *  <span><g:message code="rsr.property.subjectIsTaxable.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['subject'].invalidFields.contains('subjectIsTaxable') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="subjectIsTaxable_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="subjectIsTaxable" ${it == rqt.subjectIsTaxable ? 'checked="checked"': ''} />
                <label for="subjectIsTaxable_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="rsr.property.subjectIsAPABeneficiary.label" /> *  <span><g:message code="rsr.property.subjectIsAPABeneficiary.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['subject'].invalidFields.contains('subjectIsAPABeneficiary') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="subjectIsAPABeneficiary_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="subjectIsAPABeneficiary" ${it == rqt.subjectIsAPABeneficiary ? 'checked="checked"': ''} />
                <label for="subjectIsAPABeneficiary_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="rsr.property.subjectIsDisabledPerson.label" /> *  <span><g:message code="rsr.property.subjectIsDisabledPerson.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['subject'].invalidFields.contains('subjectIsDisabledPerson') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="subjectIsDisabledPerson_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="subjectIsDisabledPerson" ${it == rqt.subjectIsDisabledPerson ? 'checked="checked"': ''} />
                <label for="subjectIsDisabledPerson_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="rsr.property.requestInformation.label" /></legend>
    
      <label class="required"><g:message code="rsr.property.requestInformationRequestKind.label" /> *  <span><g:message code="rsr.property.requestInformationRequestKind.help" /></span></label>
            <ul class="required ${rqt.stepStates['subject'].invalidFields.contains('requestInformationRequestKind') ? 'validation-failed' : ''}">
              <g:each in="${['Individual','Couple']}">
              <li>
                <input type="radio" id="requestInformationRequestKind_${it}" class="required condition-isCoupleRequest-trigger  validate-one-required" value="fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType_${it}" name="requestInformationRequestKind" ${it == rqt.requestInformationRequestKind.toString() ? 'checked="checked"': ''} title="<g:message code="rsr.property.requestInformationRequestKind.validationError" />" />
                <label for="requestInformationRequestKind_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="rsr.property.requestInformationRequestKind" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="rsr.property.requestInformationEmergency.label" /> *  <span><g:message code="rsr.property.requestInformationEmergency.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['subject'].invalidFields.contains('requestInformationEmergency') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="requestInformationEmergency_${it ? 'yes' : 'no'}" class="required condition-isEmergency-trigger  validate-one-required boolean" title="" value="${it}" name="requestInformationEmergency" ${it == rqt.requestInformationEmergency ? 'checked="checked"': ''} />
                <label for="requestInformationEmergency_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="requestInformationEmergencyMotive" class="required condition-isEmergency-filled"><g:message code="rsr.property.requestInformationEmergencyMotive.label" /> *  <span><g:message code="rsr.property.requestInformationEmergencyMotive.help" /></span></label>
            <textarea id="requestInformationEmergencyMotive" name="requestInformationEmergencyMotive" class="required condition-isEmergency-filled  validate-textarea ${rqt.stepStates['subject'].invalidFields.contains('requestInformationEmergencyMotive') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.requestInformationEmergencyMotive.validationError" />" rows="3" cols=""  maxlength="180">${rqt.requestInformationEmergencyMotive}</textarea>
            

    
    </fieldset>
  

  
    <fieldset class="required condition-isCoupleRequest-filled">
    <legend><g:message code="rsr.property.spouse.label" /></legend>
    
      <label for="spouseLastName" class="required"><g:message code="rsr.property.spouseLastName.label" /> *  <span><g:message code="rsr.property.spouseLastName.help" /></span></label>
            <input type="text" id="spouseLastName" name="spouseLastName" value="${rqt.spouseLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['subject'].invalidFields.contains('spouseLastName') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.spouseLastName.validationError" />"  maxlength="38" />
            

    
      <label for="spouseFirstName" class="required"><g:message code="rsr.property.spouseFirstName.label" /> *  <span><g:message code="rsr.property.spouseFirstName.help" /></span></label>
            <input type="text" id="spouseFirstName" name="spouseFirstName" value="${rqt.spouseFirstName?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['subject'].invalidFields.contains('spouseFirstName') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.spouseFirstName.validationError" />"  maxlength="38" />
            

    
      <label for="spouseTitle" class="required"><g:message code="rsr.property.spouseTitle.label" /> *  <span><g:message code="rsr.property.spouseTitle.help" /></span></label>
            <select id="spouseTitle" name="spouseTitle" class="required  validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('spouseTitle') ? 'validation-failed' : ''}" title="<g:message code="rsr.property.spouseTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.spouseTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="rsr.property.spouseTitle" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="rsr.property.spouseBirthDate.label" /> *  <span><g:message code="rsr.property.spouseBirthDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['subject'].invalidFields.contains('spouseBirthDate') ? 'validation-failed' : ''}"
                id="spouseBirthDate_day"
                name="spouseBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.spouseBirthDate?.date == it
                      || (rqt.spouseBirthDate == null && params['spouseBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['subject'].invalidFields.contains('spouseBirthDate') ? 'validation-failed' : ''}"
                id="spouseBirthDate_month"
                name="spouseBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.spouseBirthDate?.month == (it - 1)
                      || (rqt.spouseBirthDate == null && params['spouseBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['subject'].invalidFields.contains('spouseBirthDate') ? 'validation-failed' : ''}"
                id="spouseBirthDate_year"
                name="spouseBirthDate_year"
                value="${rqt.spouseBirthDate ? rqt.spouseBirthDate.year + 1900 : params['spouseBirthDate_year']}"
                title="<g:message code="rsr.property.spouseBirthDate.validationError" />" />
            </div>
            

    
      <label class="required"><g:message code="rsr.property.spouseIsDisabledPerson.label" /> *  <span><g:message code="rsr.property.spouseIsDisabledPerson.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['subject'].invalidFields.contains('spouseIsDisabledPerson') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="spouseIsDisabledPerson_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="spouseIsDisabledPerson" ${it == rqt.spouseIsDisabledPerson ? 'checked="checked"': ''} />
                <label for="spouseIsDisabledPerson_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

