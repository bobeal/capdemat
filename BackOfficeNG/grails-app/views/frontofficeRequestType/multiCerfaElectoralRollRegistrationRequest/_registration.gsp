


  
    <fieldset class="required">
    <legend><g:message code="mcerrr.property.subjectSheet.label" /></legend>
    
      
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first autofill-autoFillName-trigger ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

    
      <label for="subjectChoiceTitle" class="required"><g:message code="mcerrr.property.subjectChoiceTitle.label" /> *  <span><g:message code="mcerrr.property.subjectChoiceTitle.help" /></span></label>
            <select id="subjectChoiceTitle" name="subjectChoiceTitle" class="required condition-isMadam-trigger autofill-autoFillName-listener-Title validate-not-first ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceTitle') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.subjectChoiceTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcerrr.property.subjectChoiceTitle" /></option>
              </g:each>
            </select>
            

    
      <label for="subjectChoiceLastName" class="required"><g:message code="mcerrr.property.subjectChoiceLastName.label" /> *  <span><g:message code="mcerrr.property.subjectChoiceLastName.help" /></span></label>
            <input type="text" id="subjectChoiceLastName" name="subjectChoiceLastName" value="${rqt.subjectChoiceLastName?.toString()}" 
                    class="required autofill-autoFillName-listener-LastName validate-string ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceLastName') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceLastName.validationError" />"   />
            

    
      <label for="subjectChoiceMaidenName" class="required condition-isMadam-filled"><g:message code="mcerrr.property.subjectChoiceMaidenName.label" /> *  <span><g:message code="mcerrr.property.subjectChoiceMaidenName.help" /></span></label>
            <input type="text" id="subjectChoiceMaidenName" name="subjectChoiceMaidenName" value="${rqt.subjectChoiceMaidenName?.toString()}" 
                    class="required condition-isMadam-filled autofill-autoFillName-listener-MaidenName validate-string ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceMaidenName') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceMaidenName.validationError" />"   />
            

    
      <label for="subjectChoiceFirstName" class="required"><g:message code="mcerrr.property.subjectChoiceFirstName.label" /> *  <span><g:message code="mcerrr.property.subjectChoiceFirstName.help" /></span></label>
            <input type="text" id="subjectChoiceFirstName" name="subjectChoiceFirstName" value="${rqt.subjectChoiceFirstName?.toString()}" 
                    class="required autofill-autoFillName-listener-FirstName validate-string ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceFirstName') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceFirstName.validationError" />"   />
            

    
      <label class=""><g:message code="mcerrr.property.subjectChoiceAddress.label" />   <span><g:message code="mcerrr.property.subjectChoiceAddress.help" /></span></label>
            <div class="address-fieldset  autofill-autoFillName-listener-Adress ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceAddress') ? 'validation-failed' : ''}">
            <label for="subjectChoiceAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.subjectChoiceAddress?.additionalDeliveryInformation}" maxlength="38" id="subjectChoiceAddress.additionalDeliveryInformation" name="subjectChoiceAddress.additionalDeliveryInformation" />  
            <label for="subjectChoiceAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.subjectChoiceAddress?.additionalGeographicalInformation}" maxlength="38" id="subjectChoiceAddress.additionalGeographicalInformation" name="subjectChoiceAddress.additionalGeographicalInformation" />
            <label for="subjectChoiceAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="subjectChoiceAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.subjectChoiceAddress?.streetNumber}" size="5" maxlength="5" id="subjectChoiceAddress.streetNumber" name="subjectChoiceAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.subjectChoiceAddress?.streetName}" maxlength="32" id="subjectChoiceAddress.streetName" name="subjectChoiceAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="subjectChoiceAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.subjectChoiceAddress?.placeNameOrService}" maxlength="38" id="subjectChoiceAddress.placeNameOrService" name="subjectChoiceAddress.placeNameOrService" />
            <label for="subjectChoiceAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="subjectChoiceAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.subjectChoiceAddress?.postalCode}" size="5" maxlength="5" id="subjectChoiceAddress.postalCode" name="subjectChoiceAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceAddress.city') ? 'validation-failed' : ''}" value="${rqt.subjectChoiceAddress?.city}" maxlength="32" id="subjectChoiceAddress.city" name="subjectChoiceAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="subjectChoiceAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.subjectChoiceAddress?.countryName}" maxlength="38" id="subjectChoiceAddress.countryName" name="subjectChoiceAddress.countryName" />
            </div>
            

    
      <label for="subjectChoiceHomePhone" class=""><g:message code="mcerrr.property.subjectChoiceHomePhone.label" />   <span><g:message code="mcerrr.property.subjectChoiceHomePhone.help" /></span></label>
            <input type="text" id="subjectChoiceHomePhone" name="subjectChoiceHomePhone" value="${rqt.subjectChoiceHomePhone?.toString()}" 
                    class=" autofill-autoFillName-listener-HomePhone validate-phone ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceHomePhone') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceHomePhone.validationError" />"  maxlength="10" />
            

    
      <label for="subjectChoiceMobilPhone" class=""><g:message code="mcerrr.property.subjectChoiceMobilPhone.label" />   <span><g:message code="mcerrr.property.subjectChoiceMobilPhone.help" /></span></label>
            <input type="text" id="subjectChoiceMobilPhone" name="subjectChoiceMobilPhone" value="${rqt.subjectChoiceMobilPhone?.toString()}" 
                    class=" autofill-autoFillName-listener-MobilePhone validate-phone ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceMobilPhone') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceMobilPhone.validationError" />"  maxlength="10" />
            

    
      <label for="subjectChoiceProPhone" class=""><g:message code="mcerrr.property.subjectChoiceProPhone.label" />   <span><g:message code="mcerrr.property.subjectChoiceProPhone.help" /></span></label>
            <input type="text" id="subjectChoiceProPhone" name="subjectChoiceProPhone" value="${rqt.subjectChoiceProPhone?.toString()}" 
                    class=" autofill-autoFillName-listener-OfficePhone validate-phone ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceProPhone') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceProPhone.validationError" />"  maxlength="10" />
            

    
      <label for="subjectChoiceEmail" class=""><g:message code="mcerrr.property.subjectChoiceEmail.label" />   <span><g:message code="mcerrr.property.subjectChoiceEmail.help" /></span></label>
            <input type="text" id="subjectChoiceEmail" name="subjectChoiceEmail" value="${rqt.subjectChoiceEmail?.toString()}" 
                    class=" autofill-autoFillName-listener-Email validate-email ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceEmail') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceEmail.validationError" />"   />
            

    
      <label for="subjectChoiceBirthDate"  class="required"><g:message code="mcerrr.property.subjectChoiceBirthDate.label" /> *  <span><g:message code="mcerrr.property.subjectChoiceBirthDate.help" /></span></label>
           	<input type="text" size="15" maxlength="10" readonly="readonly" id="subjectChoiceBirthDate" name="subjectChoiceBirthDate" 
           		value="<g:formatDate formatName="format.date" date="${rqt.subjectChoiceBirthDate}"/>" class="date required autofill-autoFillName-listener-BirthDate validate-date required autofill-autoFillName-listener-BirthDate" title="" />
            <button id="dateBtn" type="button"><img height="18" width="18" src="${resource(dir:'images/icons/',file:'calbtn.gif')}"></button> 
            

    
      <label for="subjectChoiceBirthCity" class="required"><g:message code="mcerrr.property.subjectChoiceBirthCity.label" /> *  <span><g:message code="mcerrr.property.subjectChoiceBirthCity.help" /></span></label>
            <input type="text" id="subjectChoiceBirthCity" name="subjectChoiceBirthCity" value="${rqt.subjectChoiceBirthCity?.toString()}" 
                    class="required autofill-autoFillName-listener-BirthCity validate-city ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceBirthCity') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceBirthCity.validationError" />"  maxlength="32" />
            

    
      <label for="subjectChoiceBirthPostalCode" class="required"><g:message code="mcerrr.property.subjectChoiceBirthPostalCode.label" /> *  <span><g:message code="mcerrr.property.subjectChoiceBirthPostalCode.help" /></span></label>
            <input type="text" id="subjectChoiceBirthPostalCode" name="subjectChoiceBirthPostalCode" value="${rqt.subjectChoiceBirthPostalCode?.toString()}" 
                    class="required autofill-autoFillName-listener-BirthPostalCode validate-postalCode ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceBirthPostalCode') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceBirthPostalCode.validationError" />"  maxlength="5" />
            

    
      <label for="subjectChoiceBirthCountry" class="required"><g:message code="mcerrr.property.subjectChoiceBirthCountry.label" /> *  <span><g:message code="mcerrr.property.subjectChoiceBirthCountry.help" /></span></label>
            <select id="subjectChoiceBirthCountry" name="subjectChoiceBirthCountry" class="required autofill-autoFillName-listener-BirthCountry validate-not-first ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectChoiceBirthCountry') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.subjectChoiceBirthCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.subjectChoiceBirthCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcerrr.property.subjectChoiceBirthCountry" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

