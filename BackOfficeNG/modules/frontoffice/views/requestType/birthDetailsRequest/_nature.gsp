


  
    <label for="requesterQuality" class="required"><g:message code="bdr.property.requesterQuality.label" /> *  <span><g:message code="bdr.property.requesterQuality.help" /></span></label>
            <select id="requesterQuality" name="requesterQuality" class="required condition-isOtherRequesterQuality-trigger  validate-not-first" title="<g:message code="bdr.property.requesterQuality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Requester','Spouse','Parent','GrandParent','Child','LegalRepresentant','Agent','HeirFamily','Heir','Authorized','LawyerNotary','Other']}">
                <option value="fr.cg95.cvq.business.request.civil.BirthRequesterQualityType_${it}" ${it == rqt.requesterQuality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="bdr.property.requesterQuality" /></option>
              </g:each>
            </select>
            

  

  
    <label for="requesterQualityPrecision" class="condition-isOtherRequesterQuality-filled"><g:message code="bdr.property.requesterQualityPrecision.label" />   <span><g:message code="bdr.property.requesterQualityPrecision.help" /></span></label>
            <input type="text" id="requesterQualityPrecision" name="requesterQualityPrecision" value="${rqt.requesterQualityPrecision?.toString()}" 
                    class="condition-isOtherRequesterQuality-filled  validate-string" title="<g:message code="bdr.property.requesterQualityPrecision.validationError" />"   />
            

  

  
    <label for="birthLastName" class="required"><g:message code="bdr.property.birthLastName.label" /> *  <span><g:message code="bdr.property.birthLastName.help" /></span></label>
            <input type="text" id="birthLastName" name="birthLastName" value="${rqt.birthLastName?.toString()}" 
                    class="required  validate-lastName" title="<g:message code="bdr.property.birthLastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="birthMarriageName" class=""><g:message code="bdr.property.birthMarriageName.label" />   <span><g:message code="bdr.property.birthMarriageName.help" /></span></label>
            <input type="text" id="birthMarriageName" name="birthMarriageName" value="${rqt.birthMarriageName?.toString()}" 
                    class="  validate-lastName" title="<g:message code="bdr.property.birthMarriageName.validationError" />"  maxlength="38" />
            

  

  
    <label for="birthFirstNames" class="required"><g:message code="bdr.property.birthFirstNames.label" /> *  <span><g:message code="bdr.property.birthFirstNames.help" /></span></label>
            <input type="text" id="birthFirstNames" name="birthFirstNames" value="${rqt.birthFirstNames?.toString()}" 
                    class="required  validate-string" title="<g:message code="bdr.property.birthFirstNames.validationError" />"   />
            

  

  
    <label for="birthDate" class="required"><g:message code="bdr.property.birthDate.label" /> *  <span><g:message code="bdr.property.birthDate.help" /></span></label>
            <input type="text" id="birthDate" name="birthDate" value="${formatDate(formatName:'format.date',date:rqt.birthDate)}" 
                   class="required  validate-date" title="<g:message code="bdr.property.birthDate.validationError" />" />
            

  

  
    <label for="birthCity" class="required"><g:message code="bdr.property.birthCity.label" /> *  <span><g:message code="bdr.property.birthCity.help" /></span></label>
            <input type="text" id="birthCity" name="birthCity" value="${rqt.birthCity?.toString()}" 
                    class="required  validate-city" title="<g:message code="bdr.property.birthCity.validationError" />"  maxlength="32" />
            

  

  
    <label for="birthPostalCode" class="required"><g:message code="bdr.property.birthPostalCode.label" /> *  <span><g:message code="bdr.property.birthPostalCode.help" /></span></label>
            <input type="text" id="birthPostalCode" name="birthPostalCode" value="${rqt.birthPostalCode?.toString()}" 
                    class="required  validate-departmentCode" title="<g:message code="bdr.property.birthPostalCode.validationError" />"  maxlength="2" />
            

  

