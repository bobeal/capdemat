<g:each in="${adults}" var="adult">

  <h3>
    <g:capdematEnumToText var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title"/>
    ${adult.firstName} ${adult.lastName}
  </h3>
  <div class="yui-g">
    <div class="yui-u first">
      <dl>
        <dt><g:message code="homeFolder.adult.property.title"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].title" class="${action}-editField validate-capdematEnum javatype-fr.cg95.cvq.business.users.TitleType">
          <g:capdematEnumToField var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title"/>
        </dd>

        <dt><g:message code="homeFolder.adult.property.familyStatus"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].familyStatus" class="${action}-editField validate-capdematEnum javatype-fr.cg95.cvq.business.users.FamilyStatusType">
          <g:capdematEnumToField var="${adult.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus"/>
        </dd>

        <dt><g:message code="homeFolder.individual.property.lastName"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].lastName" class="${action}-editField validate-lastname required-true i18n-homeFolder.individual.property.lastName">
          <span>${adult.lastName}</span>
        </dd>

        <dt><g:message code="homeFolder.adult.property.maidenName"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].maidenName" class="${action}-editField validate-lastname i18n-homeFolder.adult.property.maidenName">
          <span>${adult.maidenName}</span>
        </dd>

        <dt><g:message code="homeFolder.adult.property.nameOfUse"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].nameOfUse" class="${action}-editField validate-lastname i18n-homeFolder.adult.property.nameOfUse">
          <span>${adult.nameOfUse}</span>
        </dd>

        <dt><g:message code="homeFolder.individual.property.firstName"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].firstName" class="${action}-editField validate-firstname required-true i18n-homeFolder.individual.property.firstName">
          <span>${adult.firstName}</span>
        </dd>

        <dt><g:message code="homeFolder.individual.property.firstName2"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].firstName2" class="${action}-editField validate-firstname i18n-homeFolder.individual.property.firstName2">
          <span>${adult.firstName3}</span>
        </dd>

        <dt><g:message code="homeFolder.individual.property.firstName3"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].firstName3" class="${action}-editField validate-firstname i18n-homeFolder.individual.property.firstName3">
          <span>${adult.firstName3}</span>
        </dd>
      </dl>

      <dl>
        <dt><g:message code="homeFolder.individual.property.birthDate"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].birthDate" class="${action}-editField validate-date i18n-homeFolder.individual.property.birthDate">
          <span><g:formatDate formatName="format.date" date="${adult.birthDate}"/></span>
        </dd>

        <dt><g:message code="homeFolder.individual.property.birthPostalCode"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].birthPostalCode" class="${action}-editField validate-postalcode i18n-homeFolder.individual.property.birthPostalCode">
          <span>${adult.birthPostalCode}</span>
        </dd>

        <dt><g:message code="homeFolder.individual.property.birthCity"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].birthCity" class="${action}-editField validate-city i18n-homeFolder.individual.property.birthCity">
          <span>${adult.birthCity}</span>
        </dd>

        <dt><g:message code="homeFolder.individual.property.birthCountry"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].birthCountry" class="${action}-editField validate-string i18n-homeFolder.individual.property.birthCountry">
          <span>${adult.birthCountry}</span>
        </dd>

      </dl>
    </div>

    <div class="yui-u">
      <dl>
        <dt><g:message code="homeFolder.individual.property.address"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].adress" class="${action}-editField validate-address required-true">
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

        <dt><g:message code="homeFolder.adult.property.email"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].email" class="${action}-editField validate-email required-true i18n-homeFolder.adult.property.email">
          <span>${adult.email}</span>
        </dd>

        <dt><g:message code="homeFolder.adult.property.homePhone"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].homePhone" class="${action}-editField validate-phone required-true i18n-homeFolder.adult.property.homePhone">
          <span>${adult.homePhone}</span>
        </dd>

        <dt><g:message code="homeFolder.adult.property.mobilePhone"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].mobilePhone" class="${action}-editField validate-phone i18n-homeFolder.adult.property.mobilePhone">
          <span>${adult.mobilePhone}</span>
        </dd>

        <dt><g:message code="homeFolder.adult.property.officePhone"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].officePhone" class="${action}-editField validate-phone i18n-homeFolder.adult.property.OfficePhone">
          <span>${adult.officePhone}</span>
        </dd>

        <dt><g:message code="homeFolder.adult.property.profession"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].profession" class="${action}-editField validate-string i18n-homeFolder.adult.property.profession">
          <span>${adult.profession}</span>
        </dd>
      </dl>

      <dl>
        <dt><g:message code="homeFolder.adult.property.cfbn"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].cfbn" class="action-editField validate-string required-true i18n-homeFolder.adult.property.cfbn">
          <span>${adult.cfbn}</span>
        </dd>
        <dt><g:message code="homeFolder.adult.property.login"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].login" class="action-editField validate-string required-true i18n-homeFolder.adult.property.login">
          <span>${adult.login}</span>
        </dd>
        <dt><g:message code="homeFolder.adult.property.question"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].question" class="action-editField validate-string required-true i18n-homeFolder.adult.property.question">
          <span>${adult.question}</span>
        </dd>
        <dt><g:message code="homeFolder.adult.property.answer"/> :</dt>
        <dd id="homeFolder.individual[${adult.id}].answer" class="action-editField validate-string required-true i18n-homeFolder.adult.property.answer">
          <span>${adult.answer}</span>
        </dd>
      </dl>

    </div>
  </div>

</g:each> 