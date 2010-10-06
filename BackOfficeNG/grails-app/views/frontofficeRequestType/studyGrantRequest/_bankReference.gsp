


  
    <label class="required"><g:message code="sgr.property.isSubjectAccountHolder.label" /> *  <span><g:message code="sgr.property.isSubjectAccountHolder.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('isSubjectAccountHolder') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isSubjectAccountHolder_${it ? 'yes' : 'no'}" class="required condition-isSubjectAccountHolder-trigger  validate-one-required boolean" title="" value="${it}" name="isSubjectAccountHolder" ${it == rqt.isSubjectAccountHolder ? 'checked="checked"': ''} />
                <label for="isSubjectAccountHolder_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="accountHolderTitle" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderTitle.label" /> *  <span><g:message code="sgr.property.accountHolderTitle.help" /></span></label>
            <select id="accountHolderTitle" name="accountHolderTitle" class="required condition-isSubjectAccountHolder-unfilled  validate-not-first ${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('accountHolderTitle') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.accountHolderTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sgr.property.accountHolderTitle" /></option>
              </g:each>
            </select>
            

  

  
    <label for="accountHolderLastName" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderLastName.label" /> *  <span><g:message code="sgr.property.accountHolderLastName.help" /></span></label>
            <input type="text" id="accountHolderLastName" name="accountHolderLastName" value="${rqt.accountHolderLastName?.toString()}" 
                    class="required condition-isSubjectAccountHolder-unfilled  validate-lastName ${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('accountHolderLastName') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderLastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="accountHolderFirstName" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderFirstName.label" /> *  <span><g:message code="sgr.property.accountHolderFirstName.help" /></span></label>
            <input type="text" id="accountHolderFirstName" name="accountHolderFirstName" value="${rqt.accountHolderFirstName?.toString()}" 
                    class="required condition-isSubjectAccountHolder-unfilled  validate-firstName ${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('accountHolderFirstName') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderFirstName.validationError" />"  maxlength="38" />
            

  

  
    <label class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderBirthDate.label" /> *  <span><g:message code="sgr.property.accountHolderBirthDate.help" /></span></label>
            <div class="date required condition-isSubjectAccountHolder-unfilled  validate-date required condition-isSubjectAccountHolder-unfilled ">
              <select class="day ${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('accountHolderBirthDate') ? 'validation-failed' : ''}"
                id="accountHolderBirthDate_day"
                name="accountHolderBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.accountHolderBirthDate?.date == it
                      || (rqt.accountHolderBirthDate == null && params['accountHolderBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('accountHolderBirthDate') ? 'validation-failed' : ''}"
                id="accountHolderBirthDate_month"
                name="accountHolderBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.accountHolderBirthDate?.month == (it - 1)
                      || (rqt.accountHolderBirthDate == null && params['accountHolderBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('accountHolderBirthDate') ? 'validation-failed' : ''}"
                id="accountHolderBirthDate_year"
                name="accountHolderBirthDate_year"
                value="${rqt.accountHolderBirthDate ? rqt.accountHolderBirthDate.year + 1900 : params['accountHolderBirthDate_year']}"
                title="<g:message code="sgr.property.accountHolderBirthDate.validationError" />" />
            </div>
            

  

  
    <label for="frenchRIB" class="required"><g:message code="sgr.property.frenchRIB.label" /> *  <span><g:message code="sgr.property.frenchRIB.help" /></span></label>
            <div class="address-fieldset required   ${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('frenchRIB') ? 'validation-failed' : ''}">
            <label for="frenchRIB.bankCode"><g:message code="frenchRIB.property.bankCode" /></label>
            <input type="text" class="${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('frenchRIB.bankCode') ? 'validation-failed' : ''}" value="${rqt.frenchRIB?.bankCode}" maxlength="5" id="frenchRIB.bankCode" name="frenchRIB.bankCode" />
            <label for="frenchRIB.counterCode"><g:message code="frenchRIB.property.counterCode" /></label>
            <input type="text" class="${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('frenchRIB.counterCode') ? 'validation-failed' : ''}" value="${rqt.frenchRIB?.counterCode}" maxlength="5" id="frenchRIB.counterCode" name="frenchRIB.counterCode" />
            <label for="frenchRIB.accountNumber"><g:message code="frenchRIB.property.accountNumber" /></label>
            <input type="text" class="${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('frenchRIB.accountNumber') ? 'validation-failed' : ''}" value="${rqt.frenchRIB?.accountNumber}" maxlength="11" id="frenchRIB.accountNumber" name="frenchRIB.accountNumber" />
            <label for="frenchRIB.accountKey"><g:message code="frenchRIB.property.accountKey" /></label>
            <input type="text" class="${stepStates != null && stepStates['bankReference']?.invalidFields?.contains('frenchRIB.accountKey') ? 'validation-failed' : ''}" value="${rqt.frenchRIB?.accountKey}" maxlength="2" id="frenchRIB.accountKey" name="frenchRIB.accountKey" />
            </div>
            

  

