


  
    <label for="taxHouseholdLastName" class="required"><g:message code="sgr.property.taxHouseholdLastName.label" /> *  <span><g:message code="sgr.property.taxHouseholdLastName.help" /></span></label>
            <input type="text" id="taxHouseholdLastName" name="taxHouseholdLastName" value="${rqt.taxHouseholdLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="sgr.property.taxHouseholdLastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="taxHouseholdFirstName" class="required"><g:message code="sgr.property.taxHouseholdFirstName.label" /> *  <span><g:message code="sgr.property.taxHouseholdFirstName.help" /></span></label>
            <input type="text" id="taxHouseholdFirstName" name="taxHouseholdFirstName" value="${rqt.taxHouseholdFirstName?.toString()}" 
                    class="required  validate-firstName" title="<g:message code="sgr.property.taxHouseholdFirstName.validationError" />"  maxlength="38" />
            

  

  
    <label class="required"><g:message code="sgr.property.taxHouseholdCity.label" /> *  <span><g:message code="sgr.property.taxHouseholdCity.help" /></span></label>
            <g:set var="taxHouseholdCityIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'taxHouseholdCity', 'i18nPrefixCode':'sgr.property.taxHouseholdCity', 'htmlClass':'required condition-isTaxHouseholdCityOther-trigger  ', 
                              'lrEntries': lrTypes.taxHouseholdCity.entries, 'depth':0]" />
            

  

  
    <label for="taxHouseholdCityPrecision" class="required condition-isTaxHouseholdCityOther-filled"><g:message code="sgr.property.taxHouseholdCityPrecision.label" /> *  <span><g:message code="sgr.property.taxHouseholdCityPrecision.help" /></span></label>
            <input type="text" id="taxHouseholdCityPrecision" name="taxHouseholdCityPrecision" value="${rqt.taxHouseholdCityPrecision?.toString()}" 
                    class="required condition-isTaxHouseholdCityOther-filled  validate-string" title="<g:message code="sgr.property.taxHouseholdCityPrecision.validationError" />"   />
            

  

  
    <label for="taxHouseholdIncome" class="required"><g:message code="sgr.property.taxHouseholdIncome.label" /> *  <span><g:message code="sgr.property.taxHouseholdIncome.help" /></span></label>
            <input type="text" id="taxHouseholdIncome" name="taxHouseholdIncome" value="${rqt.taxHouseholdIncome?.toString()}" 
                    class="required  validate-regex" title="<g:message code="sgr.property.taxHouseholdIncome.validationError" />" regex="^\d+(?:\.\d{1,2})?$"  />
            

  

