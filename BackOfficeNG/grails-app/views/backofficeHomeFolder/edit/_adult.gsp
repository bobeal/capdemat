<div id="adult_" class="account">
  <h3>${message(code:'homeFolder.individual.header.newAdult')}</h3>
  <form id="addAdult" method="post" action="${g.createLink(action:'adult')}">
    <dl style="margin-top:1em">
      <dt class="required">${message(code:'homeFolder.adult.property.title')}</dt>
      <dd class="required">
        <select name="title">
          <g:each var="title" in="${fr.cg95.cvq.business.users.TitleType.allTitleTypes}">
            <option value="fr.cg95.cvq.business.users.TitleType_${title}" ${title == adult.title ? 'selected="selected"' : ''}>
              ${g.capdematEnumToText(var:title, i18nKeyPrefix:'homeFolder.adult.title')}
            </option>
          </g:each>
        </select>
      </dd>
      <dt class="required">${message(code:'homeFolder.individual.property.lastName')}</dt>
      <dd class="required">
        <input type="text" name="lastName" value="${adult.lastName}" />
      </dd>
      <dt class="required">${message(code:'homeFolder.individual.property.firstName')}</dt>
      <dd class="required">
        <input type="text" name="firstName" value="${adult.firstName}" />
      </dd>
    </dl>
    <dl style="margin-top:1em">
      <dt class="required">${message(code:'homeFolder.individual.property.address')}</dt>
      <dd id="adultAddress" class="required">
        <label>${message(code:'address.property.additionalDeliveryInformation')}</label>
        <input type="text" name="address.additionalDeliveryInformation" value="${adult?.address?.additionalDeliveryInformation}" maxlength="38" class="validate-addressLine38" />
        <label>${message(code:'address.property.additionalGeographicalInformation')}</label>
        <input type="text" name="address.additionalGeographicalInformation" value="${adult?.address?.additionalGeographicalInformation}" maxlength="38" class="validate-addressLine38" />
        <label>Numéro et <strong>${message(code:'address.property.streetName')} * </strong></label>
        <input type="text" id="adultAddress_streetNumber" name="address.streetNumber" value="${adult?.address?.streetNumber}" maxlength="5" class="line1 validate-streetNumber" />
        <input type="text" id="adultAddress_streetName" name="address.streetName" value="${adult?.address?.streetName}" maxlength="32" class="line2 validate-streetName" />
        <label>${message(code:'address.property.placeNameOrService')}</label>
        <input type="text" name="address.placeNameOrService" value="${adult?.address?.placeNameOrService}" maxlength="38" class="validate-addressLine38" />
        <label><strong>${message(code:'address.property.postalCode')} * - ${message(code:'address.property.city')} * </strong></label>
        <input type="text" id="adultAddress_postalCode" name="address.postalCode" value="${adult?.address?.postalCode}" maxlength="5" class="line1 validate-postalCode" />
        <input type="text" id="adultAddress_city" name="address.city" value="${adult?.address?.city}" maxlength="32" size="4" class="line2 validate-city" />
        <label>${message(code:'address.property.countryName')}</label>
        <input type="text" name="address.countryName" maxlength="38" class="validate-addressLine38" value="${adult?.address?.countryName}" />
        <input type="hidden" id="adultAddress_streetMatriculation" name="address.streetMatriculation" value="${adult?.address?.streetMatriculation}" />
        <input type="hidden" id="adultAddress_streetRivoliCode" name="address.streetRivoliCode" value="${adult?.address?.streetRivoliCode}" />
        <input type="hidden" id="adultAddress_cityInseeCode" name="address.cityInseeCode" value="${adult?.address?.cityInseeCode}" />
      </dd>
    </dl>
    <dl style="margin-top:1em">
      <dt class="required">${message(code:'homeFolder.adult.property.email')}</dt>
      <dd class="required">
        <input type="text" name="email" value="${adult.email}" />
      </dd>
      <dt>${message(code:'homeFolder.adult.property.homePhone')}</dt>
      <dd>
        <input type="text" name="homePhone" value="${adult.homePhone}" />
      </dd>
      <dt>${message(code:'homeFolder.adult.property.mobilePhone')}</dt>
      <dd>
        <input type="text" name="mobilePhone" value="${adult.mobilePhone}" />
      </dd>
    </dl>
    <dl style="margin-top:1em">
      <g:render template="edit/submit" model="['object':adult]" />
    </dl>
  </form>
</div>
