<label class="required"><g:message code="homeFolder.property.adults" /></label>
<div class="collection-fieldset required validation-scope">
  <g:set var="listIndex" value="${editList?.name == 'adults' ? editList?.index : ( adults ? adults.size() : 0 ) }" />
  <fieldset class="collection-fieldset-add required">
    <label class="required"><g:message code="homeFolder.adult.property.title" /></label>
    <select name="title" class="required validate-not-first condition-isMadam-trigger" title="<g:message code="homeFolder.adult.property.title.validationError" />">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${['Mister','Madam','Miss','Agency']}">
        <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == editList?.adults?.title?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="homeFolder.adult.title" /></option>
      </g:each>
    </select>

    <label class="required"><g:message code="homeFolder.individual.property.lastName" /></label>
    <input type="text" name="lastName" value="${editList?.adults?.lastName}"
      class="required validate-lastName" title="<g:message code="homeFolder.individual.property.lastName.validationError" />">

    <label class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
    <input type="text" name="firstName" value="${editList?.adults?.firstName}"
      class="required validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />">

    <label><g:message code="homeFolder.individual.property.firstName2" /></label>
    <input type="text" name="firstName2" value="${editList?.adults?.firstName2}"
      class="validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />">

    <label><g:message code="homeFolder.individual.property.firstName3" /></label>
    <input type="text" name="firstName3" value="${editList?.adults?.firstName3}"
      class="validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />">

    <label class="required condition-isMadam-filled"><g:message code="homeFolder.adult.property.maidenName" /></label>
    <input type="text" name="maidenName" value="${editList?.adults?.maidenName}"
      class="required condition-isMadam-filled validate-lastName" title="<g:message code="homeFolder.adult.property.maidenName.validationError" />">

    <label><g:message code="homeFolder.adult.property.nameOfUse" /></label>
    <input type="text" name="nameOfUse" value="${editList?.adults?.nameOfUse}"
      class="validate-lastName" title="<g:message code="homeFolder.adult.property.nameOfUse.validationError" />">

    <label class="required"><g:message code="homeFolder.adult.property.familyStatus" /></label>
    <select name="familyStatus" class="required validate-not-first" title="<g:message code="homeFolder.adult.property.familyStatus.validationError" />">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','Pacs','Other']}">
        <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == editList?.adults?.familyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></option>
      </g:each>
    </select>

    <label><g:message code="homeFolder.individual.property.birthDate" /> <span><g:message code="homeFolder.individual.property.birthDate.help" /></span></label>
    <input type="text" name="birthDate" value="${formatDate(formatName:'format.date',date:editList?.adults?.birthDate)}"
      class="validate-date" title="<g:message code="homeFolder.individual.property.birthDate.validationError" />">

    <label><g:message code="homeFolder.individual.property.birthPostalCode" /></label>
    <input type="text" name="birthPostalCode" value="${editList?.adults?.birthPostalCode}"
      class="validate-postalcode" title="<g:message code="homeFolder.individual.property.birthPostalCode.validationError" />">

    <label><g:message code="homeFolder.individual.property.birthCity" /></label>
    <input type="text" name="birthCity" value="${editList?.adults?.birthCity}"
      class="validate-city" title="<g:message code="homeFolder.individual.property.birthCity.validationError" />">

    <label><g:message code="homeFolder.individual.property.birthCountry" /></label>
    <select name="birthCountry">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${['EuropeanUnion','OutsideEuropeanUnion']}">
        <option value="<g:message code='vcr.birthCountry.${it}' />" ${message(code:'vcr.birthCountry.' + it) == editList?.adults?.birthCountry?.toString() ? 'selected="selected"': ''}>
          <g:message code="vcr.birthCountry.${it}" />
        </option>
      </g:each>
    </select>

    <label class="required"><g:message code="homeFolder.individual.property.address" /></label>
    <div class="address-fieldset required">
      <label><g:message code="address.property.additionalDeliveryInformation" /></label>
      <input type="text" value="${editList?.adults?.adress?.additionalDeliveryInformation}" maxlength="38" name="adress.additionalDeliveryInformation"/>
      <label><g:message code="address.property.additionalGeographicalInformation" /></label>
      <input type="text" value="${editList?.adults?.adress?.additionalGeographicalInformation}" maxlength="38" name="adress.additionalGeographicalInformation"/>
      <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /></strong></label>
      <input type="text" class="line1" value="${editList?.adults?.adress?.streetNumber}" maxlength="5" name="adress.streetNumber"/>
      <input type="text" class="line2 required" value="${editList?.adults?.adress?.streetName}" maxlength="32" name="adress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
      <label><g:message code="address.property.placeNameOrService" /></label>
      <input type="text" value="${editList?.adults?.adress?.placeNameOrService}" maxlength="38" name="adress.placeNameOrService"/>
      <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
      <input type="text" class="line1 required validate-postalcode" value="${editList?.adults?.adress?.postalCode}" maxlength="5" name="adress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
      <input type="text" class="line2 required validate-city" value="${editList?.adults?.adress?.city}" maxlength="32" name="adress.city" title="<g:message code="address.property.city.validationError" />" />
      <label><g:message code="address.property.countryName" /></label>
      <input type="text" value="${editList?.adults?.adress?.countryName}" maxlength="38" name="adress.countryName"/>
    </div>

    <label class="required"><g:message code="homeFolder.adult.property.email" /> <span><g:message code="homeFolder.adult.property.email.help" /></span></label>
    <input type="text" name="email" value="${editList?.adults?.email}"
      class="required validate-email" title="<g:message code="homeFolder.adult.property.email.validationError" />">

    <fieldset class="required">
      <legend><g:message code="vcr.property.phones" /></legend>

      <label><g:message code="homeFolder.adult.property.homePhone" /> <span><g:message code="homeFolder.adult.property.homePhone.help" /></span></label>
      <input type="text" name="homePhone" value="${editList?.adults?.homePhone}"
        class="validate-phone" title="<g:message code="homeFolder.adult.property.homePhone.validationError" />">

      <label><g:message code="homeFolder.adult.property.mobilePhone" /> <span><g:message code="homeFolder.adult.property.mobilePhone.help" /></span></label>
      <input type="text" name="mobilePhone" value="${editList?.adults?.mobilePhone}"
        class="validate-phone" title="<g:message code="homeFolder.adult.property.mobilePhone.validationError" />">

      <label><g:message code="homeFolder.adult.property.officePhone" /> <span><g:message code="homeFolder.adult.property.officePhone.help" /></span></label>
      <input type="text" name="officePhone" value="${editList?.adults?.officePhone}"
        class="validate-phone" title="<g:message code="homeFolder.adult.property.officePhone.validationError" />">

    </fieldset>

    <label><g:message code="homeFolder.adult.property.profession" /></label>
    <input type="text" name="profession" value="${editList?.adults?.profession}"
      class="validate-string" title="<g:message code="homeFolder.adult.property.profession.validationError" />">

    <label><g:message code="homeFolder.adult.property.cfbn" /></label>
    <input type="text" name="cfbn" value="${editList?.adults?.cfbn}"
      class="validate-cfbn" title="<g:message code="homeFolder.adult.property.cfbn.validationError" />">

    <g:if test="${editList?.name == 'adults'}">
      <input type="submit" id="submit-collectionModify-adults-adults[${listIndex}]" name="submit-collectionModify-adults-adults[${listIndex}]" value="${message(code:'action.save')}" />
      <input type="submit" id="submit-collectionCancel-adults-adults[${listIndex}]" name="submit-collectionCancel-adults-adults[${listIndex}]" value="${message(code:'action.cancel')}" />
    </g:if>
    <g:else>
      <input type="submit" id="submit-collectionAdd-adults-adults[${listIndex}]" name="submit-collectionAdd-adults-adults[${listIndex}]" value="${message(code:'action.add')}" />
    </g:else>
    </fieldset>

    <div class="error" id="stepForm-adults-error"> </div>

    <g:each var="adult" in="${adults}" status="index">
    <fieldset class="collection-fieldset-edit">
    <dl>
      <dt><g:message code="homeFolder.adult.property.title" /> : </dt>
      <dd> <g:capdematEnumToField var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" /></dd>

      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt>
      <dd>${adult.lastName}</dd>

      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd>${adult.firstName}</dd>

      <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
      <dd>${adult.firstName2}</dd>

      <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
      <dd>${adult.firstName3}</dd>

      <dt><g:message code="homeFolder.adult.property.maidenName" /> : </dt>
      <dd>${adult.maidenName}</dd>

      <dt><g:message code="homeFolder.adult.property.nameOfUse" /> : </dt>
      <dd>${adult.nameOfUse}</dd>

      <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
      <dd> <g:capdematEnumToField var="${adult.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></dd>

      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd><span><g:formatDate formatName="format.date" date="${adult.birthDate}"/></span></dd>

      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd>${adult.birthCity}</dd>

      <dt><g:message code="homeFolder.individual.property.birthPostalCode" /> : </dt>
      <dd>${adult.birthPostalCode}</dd>

      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd>${adult.birthCountry}</dd>

      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd>
        <div>
          <p class="additionalDeliveryInformation">${adult.adress.additionalDeliveryInformation}</p>
          <p class="additionalGeographicalInformation">${adult.adress.additionalGeographicalInformation}</p>
          <span class="streetNumber">${adult.adress.streetNumber}</span>
          <span class="streetName">${adult.adress.streetName}</span>
          <p class="placeNameOrService">${adult.adress.placeNameOrService}</p>
          <span class="postalCode">${adult.adress.postalCode}</span>
          <span class="city">${adult.adress.city}</span>
          <p class="countryName">${adult.adress.countryName}</p>
        </div>
      </dd>

      <dt><g:message code="homeFolder.adult.property.email" /> : </dt>
      <dd>${adult.email}</dd>

      <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
      <dd>${adult.homePhone}</dd>

      <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
      <dd>${adult.mobilePhone}</dd>

      <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
      <dd>${adult.officePhone}</dd>

      <dt><g:message code="homeFolder.adult.property.profession" /> : </dt>
      <dd>${adult.profession}</dd>

      <dt><g:message code="homeFolder.adult.property.cfbn" /> : </dt>
      <dd>${adult.cfbn}</dd>

    </dl>
    <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-adults-adults[${index}]" />
    <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-adults-adults[${index}]" />
  </fieldset>
  </g:each>
</div>

 