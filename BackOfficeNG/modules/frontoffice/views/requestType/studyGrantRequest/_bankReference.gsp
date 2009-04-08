




  
    <label class="required"><g:message code="sgr.property.bankCode.label" /> *  <span><g:message code="sgr.property.bankCode.help" /></span></label>
    
            <input type="text" name="bankCode" value="${rqt.bankCode}" 
                    class="required validate-regex" title="<g:message code="sgr.property.bankCode.validationError" />" regex="^\d{1,5}$" maxLength="5"/>
            
  

  
    <label class="required"><g:message code="sgr.property.counterCode.label" /> *  <span><g:message code="sgr.property.counterCode.help" /></span></label>
    
            <input type="text" name="counterCode" value="${rqt.counterCode}" 
                    class="required validate-regex" title="<g:message code="sgr.property.counterCode.validationError" />" regex="^\d{1,5}$" maxLength="5"/>
            
  

  
    <label class="required"><g:message code="sgr.property.accountNumber.label" /> *  <span><g:message code="sgr.property.accountNumber.help" /></span></label>
    
            <input type="text" name="accountNumber" value="${rqt.accountNumber}" 
                    class="required validate-regex" title="<g:message code="sgr.property.accountNumber.validationError" />" regex="^[a-zA-Z0-9]{1,11}$" maxLength="11"/>
            
  

  
    <label class="required"><g:message code="sgr.property.accountKey.label" /> *  <span><g:message code="sgr.property.accountKey.help" /></span></label>
    
            <input type="text" name="accountKey" value="${rqt.accountKey}" 
                    class="required validate-regex" title="<g:message code="sgr.property.accountKey.validationError" />" regex="^(?:O[1-9])|(?:[1-8]\d)|(?:9[0-7])$" maxLength="2"/>
            
  

