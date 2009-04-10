


  
    <label class="required"><g:message code="bdr.property.requesterQuality.label" /> *  <span><g:message code="bdr.property.requesterQuality.help" /></span></label>
            <select name="requesterQuality" class="required condition-isOtherRequesterQuality-trigger validate-not-first" title="<g:message code="bdr.property.requesterQuality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Requester','Spouse','Parent','GrandParent','Child','LegalRepresentant','Agent','HeirFamily','Heir','Authorized','LawyerNotary','Other']}">
                <option value="fr.cg95.cvq.business.request.civil.BirthRequesterQualityType_${it}" ${it == rqt.requesterQuality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="bdr.property.requesterQuality" /></option>
              </g:each>
            </select>
            

  

  
    <label class="condition-isOtherRequesterQuality-filled"><g:message code="bdr.property.requesterQualityPrecision.label" />   <span><g:message code="bdr.property.requesterQualityPrecision.help" /></span></label>
            <input type="text" name="requesterQualityPrecision" value="${rqt.requesterQualityPrecision}" 
                    class="condition-isOtherRequesterQuality-filled validate-string" title="<g:message code="bdr.property.requesterQualityPrecision.validationError" />"  />
            

  

  
    <label class="required"><g:message code="bdr.property.birthLastName.label" /> *  <span><g:message code="bdr.property.birthLastName.help" /></span></label>
            <input type="text" name="birthLastName" value="${rqt.birthLastName}" 
                    class="required validate-lastName" title="<g:message code="bdr.property.birthLastName.validationError" />"  maxLength="38"/>
            

  

  
    <label class=""><g:message code="bdr.property.birthMarriageName.label" />   <span><g:message code="bdr.property.birthMarriageName.help" /></span></label>
            <input type="text" name="birthMarriageName" value="${rqt.birthMarriageName}" 
                    class=" validate-lastName" title="<g:message code="bdr.property.birthMarriageName.validationError" />"  maxLength="38"/>
            

  

  
    <label class="required"><g:message code="bdr.property.birthFirstNames.label" /> *  <span><g:message code="bdr.property.birthFirstNames.help" /></span></label>
            <input type="text" name="birthFirstNames" value="${rqt.birthFirstNames}" 
                    class="required validate-string" title="<g:message code="bdr.property.birthFirstNames.validationError" />"  />
            

  

  
    <label class="required"><g:message code="bdr.property.birthDate.label" /> *  <span><g:message code="bdr.property.birthDate.help" /></span></label>
            <input type="text" name="birthDate" value="${formatDate(formatName:'format.date',date:rqt.birthDate)}" 
                   class="required validate-date" title="<g:message code="bdr.property.birthDate.validationError" />" />
            

  

  
    <label class="required"><g:message code="bdr.property.birthCity.label" /> *  <span><g:message code="bdr.property.birthCity.help" /></span></label>
            <input type="text" name="birthCity" value="${rqt.birthCity}" 
                    class="required validate-city" title="<g:message code="bdr.property.birthCity.validationError" />"  maxLength="32"/>
            

  

  
    <label class="required"><g:message code="bdr.property.birthPostalCode.label" /> *  <span><g:message code="bdr.property.birthPostalCode.help" /></span></label>
            <input type="text" name="birthPostalCode" value="${rqt.birthPostalCode}" 
                    class="required validate-departmentCode" title="<g:message code="bdr.property.birthPostalCode.validationError" />"  maxLength="2"/>
            

  

