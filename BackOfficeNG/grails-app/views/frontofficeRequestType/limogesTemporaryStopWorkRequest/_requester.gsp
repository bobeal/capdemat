


  
    <label for="requesterType" class="required"><g:message code="ltswr.property.requesterType.label" /> *  <span><g:message code="ltswr.property.requesterType.help" /></span></label>
            <select id="requesterType" name="requesterType" class="required condition-isLandlord-trigger condition-isContractor-trigger condition-isCollectivity-trigger condition-forAll-trigger condition-forContractorCollectivity-trigger  validate-not-first ${rqt.stepStates['requester'].invalidFields.contains('requesterType') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.requesterType.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['LANDLORD','CONTRACTOR','COLLECTIVITY']}">
                <option value="${it}" ${it == rqt.requesterType?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="ltswr.property.requesterType" /></option>
              </g:each>
            </select>
            

  

  
    <label for="civility" class="required condition-isLandlord-filled"><g:message code="ltswr.property.civility.label" /> *  <span><g:message code="ltswr.property.civility.help" /></span></label>
            <select id="civility" name="civility" class="required condition-isLandlord-filled  validate-not-first ${rqt.stepStates['requester'].invalidFields.contains('civility') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.civility.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['MISTER','MADAM','MISS','AGENCY','UNKNOWN']}">
                <option value="${it}" ${it == rqt.civility?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="ltswr.property.civility" /></option>
              </g:each>
            </select>
            

  

  
    <label for="lastName" class="required condition-isLandlord-filled"><g:message code="ltswr.property.lastName.label" /> *  <span><g:message code="ltswr.property.lastName.help" /></span></label>
            <input type="text" id="lastName" name="lastName" value="${rqt.lastName?.toString()}" 
                    class="required condition-isLandlord-filled  validate-lastName ${rqt.stepStates['requester'].invalidFields.contains('lastName') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.lastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="firstName" class="required condition-isLandlord-filled"><g:message code="ltswr.property.firstName.label" /> *  <span><g:message code="ltswr.property.firstName.help" /></span></label>
            <input type="text" id="firstName" name="firstName" value="${rqt.firstName?.toString()}" 
                    class="required condition-isLandlord-filled  validate-firstName ${rqt.stepStates['requester'].invalidFields.contains('firstName') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.firstName.validationError" />"  maxlength="38" />
            

  

  
    <label for="contractorName" class="required condition-isContractor-filled"><g:message code="ltswr.property.contractorName.label" /> *  <span><g:message code="ltswr.property.contractorName.help" /></span></label>
            <input type="text" id="contractorName" name="contractorName" value="${rqt.contractorName?.toString()}" 
                    class="required condition-isContractor-filled  validate-string ${rqt.stepStates['requester'].invalidFields.contains('contractorName') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.contractorName.validationError" />"   />
            

  

  
    <label for="collectivityName" class="required condition-isCollectivity-filled"><g:message code="ltswr.property.collectivityName.label" /> *  <span><g:message code="ltswr.property.collectivityName.help" /></span></label>
            <input type="text" id="collectivityName" name="collectivityName" value="${rqt.collectivityName?.toString()}" 
                    class="required condition-isCollectivity-filled  validate-string ${rqt.stepStates['requester'].invalidFields.contains('collectivityName') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.collectivityName.validationError" />"   />
            

  

  
    <label for="address" class="required condition-forAll-filled"><g:message code="ltswr.property.address.label" /> *  <span><g:message code="ltswr.property.address.help" /></span></label>
            <textarea id="address" name="address" class="required condition-forAll-filled  validate-textarea ${rqt.stepStates['requester'].invalidFields.contains('address') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.address.validationError" />" rows="5" cols=""  >${rqt.address}</textarea>
            

  

  
    <label for="phoneNumber" class="required condition-forAll-filled"><g:message code="ltswr.property.phoneNumber.label" /> *  <span><g:message code="ltswr.property.phoneNumber.help" /></span></label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="${rqt.phoneNumber?.toString()}" 
                    class="required condition-forAll-filled  validate-phone ${rqt.stepStates['requester'].invalidFields.contains('phoneNumber') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.phoneNumber.validationError" />"  maxlength="10" />
            

  

  
    <label for="faxNumber" class="condition-forContractorCollectivity-filled"><g:message code="ltswr.property.faxNumber.label" />   <span><g:message code="ltswr.property.faxNumber.help" /></span></label>
            <input type="text" id="faxNumber" name="faxNumber" value="${rqt.faxNumber?.toString()}" 
                    class="condition-forContractorCollectivity-filled  validate-phone ${rqt.stepStates['requester'].invalidFields.contains('faxNumber') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.faxNumber.validationError" />"  maxlength="10" />
            

  

  
    <label for="mail" class="condition-forAll-filled"><g:message code="ltswr.property.mail.label" />   <span><g:message code="ltswr.property.mail.help" /></span></label>
            <input type="text" id="mail" name="mail" value="${rqt.mail?.toString()}" 
                    class="condition-forAll-filled  validate-email ${rqt.stepStates['requester'].invalidFields.contains('mail') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.mail.validationError" />"   />
            

  

