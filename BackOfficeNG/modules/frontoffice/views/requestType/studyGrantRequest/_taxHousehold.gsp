


  
    <label class="required"><g:message code="sgr.property.taxHouseholdLastName.label" /> *  <span><g:message code="sgr.property.taxHouseholdLastName.help" /></span></label>
            <input type="text" name="taxHouseholdLastName" value="${rqt.taxHouseholdLastName}" 
                    class="required  validate-lastName" title="<g:message code="sgr.property.taxHouseholdLastName.validationError" />"  maxLength="38"/>
            

  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdFirstName.label" /> *  <span><g:message code="sgr.property.taxHouseholdFirstName.help" /></span></label>
            <input type="text" name="taxHouseholdFirstName" value="${rqt.taxHouseholdFirstName}" 
                    class="required  validate-firstName" title="<g:message code="sgr.property.taxHouseholdFirstName.validationError" />"  maxLength="38"/>
            

  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdPostalCode.label" /> *  <span><g:message code="sgr.property.taxHouseholdPostalCode.help" /></span></label>
            <input type="text" name="taxHouseholdPostalCode" value="${rqt.taxHouseholdPostalCode}" 
                    class="required  validate-regex" title="<g:message code="sgr.property.taxHouseholdPostalCode.validationError" />" regex="^77[0-9]{3}$" maxLength="5"/>
            

  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdCity.label" /> *  <span><g:message code="sgr.property.taxHouseholdCity.help" /></span></label>
            <g:set var="taxHouseholdCityIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'taxHouseholdCity', 'i18nPrefixCode':'sgr.property.taxHouseholdCity', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.taxHouseholdCity.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdIncome.label" /> *  <span><g:message code="sgr.property.taxHouseholdIncome.help" /></span></label>
            <input type="text" name="taxHouseholdIncome" value="${rqt.taxHouseholdIncome}" 
                    class="required  validate-regex" title="<g:message code="sgr.property.taxHouseholdIncome.validationError" />" regex="^\d+(?:\.\d{1,2})?$" />
            

  

