


  
    <label class="required"><g:message code="sgr.property.isSubjectAccountHolder.label" /> *  <span><g:message code="sgr.property.isSubjectAccountHolder.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSubjectAccountHolder-trigger  validate-one-required" title="" value="${it}" name="isSubjectAccountHolder" ${it == rqt.isSubjectAccountHolder ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderTitle.label" /> *  <span><g:message code="sgr.property.accountHolderTitle.help" /></span></label>
            <select name="accountHolderTitle" class="required condition-isSubjectAccountHolder-unfilled  validate-not-first" title="<g:message code="sgr.property.accountHolderTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.accountHolderTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="sgr.property.accountHolderTitle" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderLastName.label" /> *  <span><g:message code="sgr.property.accountHolderLastName.help" /></span></label>
            <input type="text" name="accountHolderLastName" value="${rqt.accountHolderLastName?.toString()}" 
                    class="required condition-isSubjectAccountHolder-unfilled  validate-lastName" title="<g:message code="sgr.property.accountHolderLastName.validationError" />"  maxLength="38"/>
            

  

  
    <label class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderFirstName.label" /> *  <span><g:message code="sgr.property.accountHolderFirstName.help" /></span></label>
            <input type="text" name="accountHolderFirstName" value="${rqt.accountHolderFirstName?.toString()}" 
                    class="required condition-isSubjectAccountHolder-unfilled  validate-firstName" title="<g:message code="sgr.property.accountHolderFirstName.validationError" />"  maxLength="38"/>
            

  

  
    <label class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderBirthDate.label" /> *  <span><g:message code="sgr.property.accountHolderBirthDate.help" /></span></label>
            <input type="text" name="accountHolderBirthDate" value="${formatDate(formatName:'format.date',date:rqt.accountHolderBirthDate)}" 
                   class="required condition-isSubjectAccountHolder-unfilled  validate-date" title="<g:message code="sgr.property.accountHolderBirthDate.validationError" />" />
            

  

  
    <label class="required"><g:message code="sgr.property.bankCode.label" /> *  <span><g:message code="sgr.property.bankCode.help" /></span></label>
            <input type="text" name="bankCode" value="${rqt.bankCode?.toString()}" 
                    class="required  validate-regex" title="<g:message code="sgr.property.bankCode.validationError" />" regex="^\d{1,5}$" maxLength="5"/>
            

  

  
    <label class="required"><g:message code="sgr.property.counterCode.label" /> *  <span><g:message code="sgr.property.counterCode.help" /></span></label>
            <input type="text" name="counterCode" value="${rqt.counterCode?.toString()}" 
                    class="required  validate-regex" title="<g:message code="sgr.property.counterCode.validationError" />" regex="^\d{1,5}$" maxLength="5"/>
            

  

  
    <label class="required"><g:message code="sgr.property.accountNumber.label" /> *  <span><g:message code="sgr.property.accountNumber.help" /></span></label>
            <input type="text" name="accountNumber" value="${rqt.accountNumber?.toString()}" 
                    class="required  validate-regex" title="<g:message code="sgr.property.accountNumber.validationError" />" regex="^[a-zA-Z0-9]{1,11}$" maxLength="11"/>
            

  

  
    <label class="required"><g:message code="sgr.property.accountKey.label" /> *  <span><g:message code="sgr.property.accountKey.help" /></span></label>
            <input type="text" name="accountKey" value="${rqt.accountKey?.toString()}" 
                    class="required  validate-regex" title="<g:message code="sgr.property.accountKey.validationError" />" regex="^(?:O[1-9])|(?:[1-8]\d)|(?:9[0-7])$" maxLength="2"/>
            

  

