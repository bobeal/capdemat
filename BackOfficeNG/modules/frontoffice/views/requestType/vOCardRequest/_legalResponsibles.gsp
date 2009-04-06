<label class="required"><g:message code="homeFolder.property.legalResponsibles" /></label>
<div class="collection-fieldset required validation-scope">
  <g:set var="listIndex" value="${editList?.name == 'currentLegalResponsibles' ? editList?.index : ( currentChild.legalResponsibles ? currentChild.legalResponsibles.size() : 0 ) }" />
  <fieldset class="collection-fieldset-add required">
    <label class="required"><g:message code="vcr.property.legalResponsibleRole" /></label>
    <select name="role" class="required validate-not-first">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${['ClrFather','ClrMother','ClrTutor']}">
        <option value="fr.cg95.cvq.business.users.RoleType_${it}" ${it == editList?.currentLegalResponsibles?.role ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="homeFolder.role" /></option>
      </g:each>
    </select>

    <label class="required"><g:message code="homeFolder.adult.property.title" /> </label>
    <select name="title" class="required validate-not-first condition-isLegalResponsibleMadam-trigger" title="<g:message code="homeFolder.adult.property.title.validationError" />">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${['Mister','Madam','Miss','Agency']}">
        <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == editList?.currentLegalResponsibles?.individual?.title?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="homeFolder.adult.title" /></option>
      </g:each>
    </select>

    <label class="required"><g:message code="homeFolder.individual.property.lastName" /></label>
    <input type="text" name="lastName" value="${editList?.currentLegalResponsibles?.individual?.lastName}"
      class="required validate-lastName" title="<g:message code="homeFolder.individual.property.lastName.validationError" />">

    <label class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
    <input type="text" name="firstName" value="${editList?.currentLegalResponsibles?.individual?.firstName}"
      class="required validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />">

    <label><g:message code="homeFolder.individual.property.firstName2" /></label>
    <input type="text" name="firstName2" value="${editList?.currentLegalResponsibles?.individual?.firstName2}"
      class="validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />">

    <label><g:message code="homeFolder.individual.property.firstName3" /></label>
    <input type="text" name="firstName3" value="${editList?.currentLegalResponsibles?.individual?.firstName3}"
      class="validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />">

    <label class="required condition-isLegalResponsibleMadam-filled"><g:message code="homeFolder.adult.property.maidenName" /></label>
    <input type="text" name="maidenName" value="${editList?.currentLegalResponsibles?.individual?.maidenName}"
      class="required condition-isLegalResponsibleMadam-filled validate-lastName" title="<g:message code="homeFolder.adult.property.maidenName.validationError" />">

    <label><g:message code="homeFolder.adult.property.nameOfUse" /></label>
    <input type="text" name="nameOfUse" value="${editList?.currentLegalResponsibles?.individual?.nameOfUse}"
      class="validate-lastName" title="<g:message code="homeFolder.adult.property.nameOfUse.validationError" />">

    <label class="required"><g:message code="homeFolder.adult.property.familyStatus" /></label>
    <select name="familyStatus" class="required validate-not-first" title="<g:message code="homeFolder.adult.property.familyStatus.validationError" />">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','Pacs','Other']}">
        <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == editList?.currentLegalResponsibles?.individual?.familyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></option>
      </g:each>
    </select>

    <label><g:message code="homeFolder.individual.property.birthDate" /> <span><g:message code="homeFolder.individual.property.birthDate.help" /></span></label>
    <input type="text" name="birthDate" value="${formatDate(formatName:'format.date',date:editList?.currentLegalResponsibles?.individual?.birthDate)}"
      class="validate-date" title="<g:message code="homeFolder.individual.property.birthDate.validationError" />">

    <label><g:message code="homeFolder.individual.property.birthPostalCode" /></label>
    <input type="text" name="birthPostalCode" value="${editList?.currentLegalResponsibles?.individual?.birthPostalCode}"
      class="validate-postalcode" title="<g:message code="homeFolder.individual.property.birthPostalCode.validationError" />">

    <label><g:message code="homeFolder.individual.property.birthCity" /></label>
    <input type="text" name="birthCity" value="${editList?.currentLegalResponsibles?.individual?.birthCity}"
      class="validate-city" title="<g:message code="homeFolder.individual.property.birthCity.validationError" />">

    <label><g:message code="homeFolder.individual.property.birthCountry" /></label>
    <select name="birthCountry">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${['EuropeanUnion','OutsideEuropeanUnion']}">
        <option value="<g:message code='vcr.birthCountry.${it}' />" ${message(code:'vcr.birthCountry.' + it) == editList?.currentLegalResponsibles?.individual?.birthCountry?.toString() ? 'selected="selected"': ''}>
          <g:message code="vcr.birthCountry.${it}" />
        </option>
      </g:each>
    </select>

    <label class="required"><g:message code="homeFolder.individual.property.address" /></label>
    <div class="address-fieldset required">
      <label><g:message code="address.property.additionalDeliveryInformation" /></label>
      <input type="text" value="${editList?.currentLegalResponsibles?.individual?.adress?.additionalDeliveryInformation}" maxlength="38" name="adress.additionalDeliveryInformation"/>
      <label><g:message code="address.property.additionalGeographicalInformation" /></label>
      <input type="text" value="${editList?.currentLegalResponsibles?.individual?.adress?.additionalGeographicalInformation}" maxlength="38" name="adress.additionalGeographicalInformation"/>
      <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /></strong></label>
      <input type="text" class="line1" value="${editList?.currentLegalResponsibles?.individual?.adress?.streetNumber}" maxlength="5" name="adress.streetNumber"/>
      <input type="text" class="line2 required" value="${editList?.currentLegalResponsibles?.individual?.adress?.streetName}" maxlength="32" name="adress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
      <label><g:message code="address.property.placeNameOrService" /></label>
      <input type="text" value="${editList?.currentLegalResponsibles?.individual?.adress?.placeNameOrService}" maxlength="38" name="adress.placeNameOrService"/>
      <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
      <input type="text" class="line1 required validate-postalcode" value="${editList?.currentLegalResponsibles?.individual?.adress?.postalCode}" maxlength="5" name="adress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
      <input type="text" class="line2 required validate-city" value="${editList?.currentLegalResponsibles?.individual?.adress?.city}" maxlength="32" name="adress.city" title="<g:message code="address.property.city.validationError" />" />
      <label><g:message code="address.property.countryName" /></label>
      <input type="text" value="${editList?.currentLegalResponsibles?.individual?.adress?.countryName}" maxlength="38" name="adress.countryName"/>
    </div>

    <label class="required"><g:message code="homeFolder.adult.property.email" /> <span><g:message code="homeFolder.adult.property.email.help" /></span></label>
    <input type="text" name="email" value="${editList?.currentLegalResponsibles?.individual?.email}"
      class="required validate-email" title="<g:message code="homeFolder.adult.property.email.validationError" />">
    <fieldset class="required">
      <legend><g:message code="vcr.property.phones" /></legend>

      <label><g:message code="homeFolder.adult.property.homePhone" /> <span><g:message code="homeFolder.adult.property.homePhone.help" /></span></label>
      <input type="text" name="homePhone" value="${editList?.currentLegalResponsibles?.individual?.homePhone}"
        class="validate-phone" title="<g:message code="homeFolder.adult.property.homePhone.validationError" />">

      <label><g:message code="homeFolder.adult.property.mobilePhone" /><span><g:message code="homeFolder.adult.property.mobilePhone.help" /></span></label>
      <input type="text" name="mobilePhone" value="${editList?.currentLegalResponsibles?.individual?.mobilePhone}"
        class="validate-phone" title="<g:message code="homeFolder.adult.property.mobilePhone.validationError" />">

      <label><g:message code="homeFolder.adult.property.officePhone" /><span><g:message code="homeFolder.adult.property.officePhone.help" /></span></label>
      <input type="text" name="officePhone" value="${editList?.currentLegalResponsibles?.individual?.officePhone}"
        class="validate-phone" title="<g:message code="homeFolder.adult.property.officePhone.validationError" />">

    </fieldset>

    <label><g:message code="homeFolder.adult.property.profession" /></label>
    <input type="text" name="profession" value="${editList?.currentLegalResponsibles?.individual?.profession}"
      class="validate-string" title="<g:message code="homeFolder.adult.property.profession.validationError" />">

    <label><g:message code="homeFolder.adult.property.cfbn" /></label>
    <input type="text" name="cfbn" value="${editList?.currentLegalResponsibles?.individual?.cfbn}"
      class="validate-cfbn" title="<g:message code="homeFolder.adult.property.cfbn.validationError" />">

    <g:if test="${editList?.name == 'currentLegalResponsibles'}">
      <input type="submit" id="submit-collectionModify-children-currentLegalResponsibles[${listIndex}]" name="submit-collectionModify-children-currentLegalResponsibles[${listIndex}]" value="${message(code:'action.save')}" />
      <input type="submit" id="submit-collectionCancel-children-currentLegalResponsibles[${listIndex}]" name="submit-collectionCancel-children-currentLegalResponsibles[${listIndex}]" value="${message(code:'action.cancel')}" />
    </g:if>
    <g:else>
      <input type="submit" id="submit-collectionAdd-children-currentLegalResponsibles[${listIndex}]" name="submit-collectionAdd-children-currentLegalResponsibles[${listIndex}]" value="${message(code:'action.add')}" />
    </g:else>
    </fieldset>

    <div class="error" id="stepForm-children-error"> </div>

    <g:each var="legalResponsible" in="${currentChild.legalResponsibles}" status="index">
    <fieldset class="collection-fieldset-edit">
    <dl>
      <dt><g:message code="vcr.property.legalResponsibleRole" /></dt>
      <dd> <g:capdematEnumToField var="${legalResponsible.role}" i18nKeyPrefix="homeFolder.role" /></dd>

      <dt><g:message code="homeFolder.adult.property.title" /> : </dt>
      <dd> <g:capdematEnumToField var="${legalResponsible.individual.title}" i18nKeyPrefix="homeFolder.adult.title" /></dd>

      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt>
      <dd>${legalResponsible.individual.lastName}</dd>

      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd>${legalResponsible.individual.firstName}</dd>

      <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
      <dd>${legalResponsible.individual.firstName2}</dd>

      <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
      <dd>${legalResponsible.individual.firstName3}</dd>

      <dt><g:message code="homeFolder.adult.property.maidenName" /> : </dt>
      <dd>${legalResponsible.individual.maidenName}</dd>

      <dt><g:message code="homeFolder.adult.property.nameOfUse" /> : </dt>
      <dd>${legalResponsible.individual.nameOfUse}</dd>

      <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
      <dd> <g:capdematEnumToField var="${legalResponsible.individual.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></dd>

      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd><span><g:formatDate formatName="format.date" date="${legalResponsible.individual.birthDate}"/></span></dd>

      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd>${legalResponsible.individual.birthCity}</dd>

      <dt><g:message code="homeFolder.individual.property.birthPostalCode" /> : </dt>
      <dd>${legalResponsible.individual.birthPostalCode}</dd>

      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd>${legalResponsible.individual.birthCountry}</dd>

      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd>
        <div>
          <p class="additionalDeliveryInformation">${legalResponsible.individual.adress.additionalDeliveryInformation}</p>
          <p class="additionalGeographicalInformation">${legalResponsible.individual.adress.additionalGeographicalInformation}</p>
          <span class="streetNumber">${legalResponsible.individual.adress.streetNumber}</span>
          <span class="streetName">${legalResponsible.individual.adress.streetName}</span>
          <p class="placeNameOrService">${legalResponsible.individual.adress.placeNameOrService}</p>
          <span class="postalCode">${legalResponsible.individual.adress.postalCode}</span>
          <span class="city">${legalResponsible.individual.adress.city}</span>
          <p class="countryName">${legalResponsible.individual.adress.countryName}</p>
        </div>
      </dd>

      <dt><g:message code="homeFolder.adult.property.email" /> : </dt>
      <dd>${legalResponsible.individual.email}</dd>

      <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
      <dd>${legalResponsible.individual.homePhone}</dd>

      <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
      <dd>${legalResponsible.individual.mobilePhone}</dd>

      <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
      <dd>${legalResponsible.individual.officePhone}</dd>

      <dt><g:message code="homeFolder.adult.property.profession" /> : </dt>
      <dd>${legalResponsible.individual.profession}</dd>

      <dt><g:message code="homeFolder.adult.property.cfbn" /> : </dt>
      <dd>${legalResponsible.individual.cfbn}</dd>
      
    </dl>
    <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-children-currentLegalResponsibles[${index}]" />
    <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-children-currentLegalResponsibles[${index}]" />
  </fieldset>
  </g:each>
</div>

 