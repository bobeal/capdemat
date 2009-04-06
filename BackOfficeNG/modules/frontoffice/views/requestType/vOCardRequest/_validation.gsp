<h3><g:message code="vcr.step.adults.label" /></h3>
<g:each var="adult" in="${adults}" status="index">
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
</g:each>

<h3><g:message code="vcr.step.children.label" /></h3>
<g:each var="child" in="${children}" status="index">
  <dl>
    <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt>
    <dd>${child.lastName}</dd>

    <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
    <dd>${child.firstName}</dd>

    <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
    <dd>${child.firstName2}</dd>

    <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
    <dd>${child.firstName3}</dd>

    <dt><g:message code="homeFolder.child.property.sex" /> : </dt>
    <dd><g:capdematEnumToField var="${child.sex}" i18nKeyPrefix="homeFolder.child.sex" /></dd>

    <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
    <dd><span><g:formatDate formatName="format.date" date="${child.birthDate}"/></span></dd>

    <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
    <dd>${child.birthCity}</dd>

    <dt><g:message code="homeFolder.individual.property.birthPostalCode" /> : </dt>
    <dd>${child.birthPostalCode}</dd>

    <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
    <dd>${child.birthCountry}</dd>

    <dt><g:message code="homeFolder.child.property.legalResponsibles" /> : </dt>
    <dd>
      <ul>
      <g:each var="childLegalResponsible" in="${childrenLegalResponsibles['children[' + index + ']']}" >
        <li>
          ${childLegalResponsible.value.individual.lastName} ${childLegalResponsible.value.individual.firstName}
          <g:capdematEnumToFlag var="${childLegalResponsible.value.role}" i18nKeyPrefix="homeFolder.role" />
        </li>
      </g:each>
      </ul>
    </dd>
  </dl>
</g:each>

<h3>Suivi de la demande</h3>
<div class="required captcha">
  <label class="required">Saisissez le code de controle de l'image.</label>
  <jcaptcha:jpeg name="image" class="image"/>
  <input type="text" class="required response" value="" name="response"/>
</div>