


  
    <label for="requesterQuality" class=""><g:message code="mdr.property.requesterQuality.label" />   <span><g:message code="mdr.property.requesterQuality.help" /></span></label>
            <select id="requesterQuality" name="requesterQuality" class="condition-isOtherRequesterQuality-trigger  validate-select ${rqt.stepStates['nature'].invalidFields.contains('requesterQuality') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.requesterQuality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Requester','Spouse','Parent','GrandParent','Child','LegalRepresentant','Agent','HeirFamily','Heir','Authorized','LawyerNotary','Other']}">
                <option value="fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType_${it}" ${it == rqt.requesterQuality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mdr.property.requesterQuality" /></option>
              </g:each>
            </select>
            

  

  
    <label for="requesterQualityPrecision" class="condition-isOtherRequesterQuality-filled"><g:message code="mdr.property.requesterQualityPrecision.label" />   <span><g:message code="mdr.property.requesterQualityPrecision.help" /></span></label>
            <input type="text" id="requesterQualityPrecision" name="requesterQualityPrecision" value="${rqt.requesterQualityPrecision?.toString()}" 
                    class="condition-isOtherRequesterQuality-filled  validate-string ${rqt.stepStates['nature'].invalidFields.contains('requesterQualityPrecision') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.requesterQualityPrecision.validationError" />"   />
            

  

  
    <fieldset class="required">
    <legend><g:message code="mdr.property.marriageHusband.label" /></legend>
    
      <label for="marriageHusbandLastName" class="required"><g:message code="mdr.property.marriageHusbandLastName.label" /> *  <span><g:message code="mdr.property.marriageHusbandLastName.help" /></span></label>
            <input type="text" id="marriageHusbandLastName" name="marriageHusbandLastName" value="${rqt.marriageHusbandLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['nature'].invalidFields.contains('marriageHusbandLastName') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.marriageHusbandLastName.validationError" />"  maxlength="38" />
            

    
      <label for="marriageHusbandFirstNames" class="required"><g:message code="mdr.property.marriageHusbandFirstNames.label" /> *  <span><g:message code="mdr.property.marriageHusbandFirstNames.help" /></span></label>
            <input type="text" id="marriageHusbandFirstNames" name="marriageHusbandFirstNames" value="${rqt.marriageHusbandFirstNames?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['nature'].invalidFields.contains('marriageHusbandFirstNames') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.marriageHusbandFirstNames.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="mdr.property.marriageWife.label" /></legend>
    
      <label for="marriageWifeLastName" class="required"><g:message code="mdr.property.marriageWifeLastName.label" /> *  <span><g:message code="mdr.property.marriageWifeLastName.help" /></span></label>
            <input type="text" id="marriageWifeLastName" name="marriageWifeLastName" value="${rqt.marriageWifeLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['nature'].invalidFields.contains('marriageWifeLastName') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.marriageWifeLastName.validationError" />"  maxlength="38" />
            

    
      <label for="marriageWifeFirstNames" class="required"><g:message code="mdr.property.marriageWifeFirstNames.label" /> *  <span><g:message code="mdr.property.marriageWifeFirstNames.help" /></span></label>
            <input type="text" id="marriageWifeFirstNames" name="marriageWifeFirstNames" value="${rqt.marriageWifeFirstNames?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['nature'].invalidFields.contains('marriageWifeFirstNames') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.marriageWifeFirstNames.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="mdr.property.marriage.label" /></legend>
    
      <label class="required"><g:message code="mdr.property.marriageDate.label" /> *  <span><g:message code="mdr.property.marriageDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['nature'].invalidFields.contains('marriageDate') ? 'validation-failed' : ''}"
                id="marriageDate_day"
                name="marriageDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.marriageDate?.date == it
                      || (rqt.marriageDate == null && params['marriageDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['nature'].invalidFields.contains('marriageDate') ? 'validation-failed' : ''}"
                id="marriageDate_month"
                name="marriageDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.marriageDate?.month == (it - 1)
                      || (rqt.marriageDate == null && params['marriageDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['nature'].invalidFields.contains('marriageDate') ? 'validation-failed' : ''}"
                id="marriageDate_year"
                name="marriageDate_year"
                value="${rqt.marriageDate ? rqt.marriageDate.year + 1900 : params['marriageDate_year']}"
                title="<g:message code="mdr.property.marriageDate.validationError" />" />
            </div>
            

    
      <label for="marriageCity" class="required"><g:message code="mdr.property.marriageCity.label" /> *  <span><g:message code="mdr.property.marriageCity.help" /></span></label>
            <input type="text" id="marriageCity" name="marriageCity" value="${rqt.marriageCity?.toString()}" 
                    class="required  validate-city ${rqt.stepStates['nature'].invalidFields.contains('marriageCity') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.marriageCity.validationError" />"  maxlength="32" />
            

    
      <label for="marriagePostalCode" class="required"><g:message code="mdr.property.marriagePostalCode.label" /> *  <span><g:message code="mdr.property.marriagePostalCode.help" /></span></label>
            <input type="text" id="marriagePostalCode" name="marriagePostalCode" value="${rqt.marriagePostalCode?.toString()}" 
                    class="required  validate-departmentCode ${rqt.stepStates['nature'].invalidFields.contains('marriagePostalCode') ? 'validation-failed' : ''}" title="<g:message code="mdr.property.marriagePostalCode.validationError" />"  maxlength="2" />
            

    
    </fieldset>
  

