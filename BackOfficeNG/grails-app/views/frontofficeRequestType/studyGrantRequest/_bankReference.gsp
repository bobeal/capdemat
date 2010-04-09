


  
    <label class="required"><g:message code="sgr.property.isSubjectAccountHolder.label" /> *  <span><g:message code="sgr.property.isSubjectAccountHolder.help" /></span></label>
            <ul class="yes-no required ${invalidFields.contains('isSubjectAccountHolder') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isSubjectAccountHolder_${it ? 'yes' : 'no'}" class="required condition-isSubjectAccountHolder-trigger  validate-one-required boolean" title="" value="${it}" name="isSubjectAccountHolder" ${it == rqt.isSubjectAccountHolder ? 'checked="checked"': ''} />
                <label for="isSubjectAccountHolder_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="accountHolderTitle" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderTitle.label" /> *  <span><g:message code="sgr.property.accountHolderTitle.help" /></span></label>
            <select id="accountHolderTitle" name="accountHolderTitle" class="required condition-isSubjectAccountHolder-unfilled  validate-not-first ${invalidFields.contains('accountHolderTitle') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.accountHolderTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sgr.property.accountHolderTitle" /></option>
              </g:each>
            </select>
            

  

  
    <label for="accountHolderLastName" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderLastName.label" /> *  <span><g:message code="sgr.property.accountHolderLastName.help" /></span></label>
            <input type="text" id="accountHolderLastName" name="accountHolderLastName" value="${rqt.accountHolderLastName?.toString()}" 
                    class="required condition-isSubjectAccountHolder-unfilled  validate-lastName ${invalidFields.contains('accountHolderLastName') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderLastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="accountHolderFirstName" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderFirstName.label" /> *  <span><g:message code="sgr.property.accountHolderFirstName.help" /></span></label>
            <input type="text" id="accountHolderFirstName" name="accountHolderFirstName" value="${rqt.accountHolderFirstName?.toString()}" 
                    class="required condition-isSubjectAccountHolder-unfilled  validate-firstName ${invalidFields.contains('accountHolderFirstName') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderFirstName.validationError" />"  maxlength="38" />
            

  

  
    <label for="accountHolderBirthDate" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderBirthDate.label" /> *  <span><g:message code="sgr.property.accountHolderBirthDate.help" /></span></label>
            <input type="text" id="accountHolderBirthDate" name="accountHolderBirthDate" value="${formatDate(formatName:'format.date',date:rqt.accountHolderBirthDate)}" 
                   class="required condition-isSubjectAccountHolder-unfilled  validate-date ${invalidFields.contains('accountHolderBirthDate') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderBirthDate.validationError" />" />
            

  

  
    <label for="bankCode" class="required"><g:message code="sgr.property.bankCode.label" /> *  <span><g:message code="sgr.property.bankCode.help" /></span></label>
            <input type="text" id="bankCode" name="bankCode" value="${rqt.bankCode?.toString()}" 
                    class="required  validate-regex ${invalidFields.contains('bankCode') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.bankCode.validationError" />" regex="^\d{1,5}$" maxlength="5" />
            

  

  
    <label for="counterCode" class="required"><g:message code="sgr.property.counterCode.label" /> *  <span><g:message code="sgr.property.counterCode.help" /></span></label>
            <input type="text" id="counterCode" name="counterCode" value="${rqt.counterCode?.toString()}" 
                    class="required  validate-regex ${invalidFields.contains('counterCode') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.counterCode.validationError" />" regex="^\d{1,5}$" maxlength="5" />
            

  

  
    <label for="accountNumber" class="required"><g:message code="sgr.property.accountNumber.label" /> *  <span><g:message code="sgr.property.accountNumber.help" /></span></label>
            <input type="text" id="accountNumber" name="accountNumber" value="${rqt.accountNumber?.toString()}" 
                    class="required  validate-regex ${invalidFields.contains('accountNumber') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountNumber.validationError" />" regex="^[a-zA-Z0-9]{1,11}$" maxlength="11" />
            

  

  
    <label for="accountKey" class="required"><g:message code="sgr.property.accountKey.label" /> *  <span><g:message code="sgr.property.accountKey.help" /></span></label>
            <input type="text" id="accountKey" name="accountKey" value="${rqt.accountKey?.toString()}" 
                    class="required  validate-regex ${invalidFields.contains('accountKey') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountKey.validationError" />" regex="^\d{1,2}$" maxlength="2" />
            

  

