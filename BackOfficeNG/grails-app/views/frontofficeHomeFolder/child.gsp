<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'data-detail.css')}" />
  </head>
  <body>
    <div class="main-box data-detail">
      <g:if test="${!child.born}">
        <h2><g:message code="request.subject.childNoBorn" args="${[child.fullName]}" /></h2>
      </g:if>
      <g:else>
        <h2>${child.firstName} ${child.lastName}</h2>
      </g:else>
      <div class="yui-g">
        <h3><g:message code="homeFolder.individual.header.generalInformations" /></h3>
        <div class="yui-u first">
          <dl>
            <dt><g:message code="property.creationDate" /> : </dt>
            <dd><g:formatDate formatName="format.date" date="${child.creationDate}"/></dd>
            <dt><g:message code="property.state" /> : </dt>
            <dd><g:capdematEnumToFlag var="${child.state}" i18nKeyPrefix="user.state" /></dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <g:if test="${!roleOwners.isEmpty()}">
              <dt><g:message code="homeFolder.child.property.legalResponsibles" /> :</dt>
              <dd>
                <g:each var="roleOwner" in="${roleOwners}">
                  <p>
                    ${roleOwner.fullName}
                    <g:each in="${roleOwner.getIndividualRoles(child.id)}">
                      <g:capdematEnumToFlag var="${it.role}" i18nKeyPrefix="homeFolder.role" />
                    </g:each>
                  </p>
                </g:each>
              </dd>
            </g:if>
          </dl>
        </div>
      </div>
      <div class="yui-g">
        <h3><g:message code="homeFolder.individual.header.civilInformations" /></h3>
        <div class="yui-u first">
          <dl>
            <dt><g:message code="homeFolder.child.property.sex" /> : </dt>
            <dd><g:capdematEnumToText var="${child.sex}" i18nKeyPrefix="homeFolder.child.property.sex"/></dd>
            <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt>
            <dd>${child.lastName}</dd>
            <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
            <dd>${child.firstName}</dd>
            <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
            <dd>${child.firstName3}</dd>
            <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
            <dd>${child.firstName3}</dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
            <dd><g:formatDate formatName="format.date" date="${child.birthDate}"/></dd>
            <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
            <dd>${child.birthCity}</dd>
            <dt><g:message code="homeFolder.individual.property.birthPostalCode" /> : </dt>
            <dd>${child.birthPostalCode}</dd>
            <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
            <dd>${child.birthCountry}</dd>
           </dl>
        </div>
      </div>
      <div class="yui-g">
        <h3><g:message code="homeFolder.individual.header.contactInformations" /></h3>
        <div class="yui-u first">
          <dl>
            <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
            <dd>
              <div>
                <g:if test="${child.address.additionalDeliveryInformation}">
                  <p>${child.address.additionalDeliveryInformation}</p>
                </g:if>
                <g:if test="${child.address.additionalGeographicalInformation}">
                  <p>${child.address.additionalGeographicalInformation}</p>
                </g:if>
                <p>${child.address.streetNumber} ${child.address.streetName}</p>
                <g:if test="${child.address.placeNameOrService}">
                  <p>${child.address.placeNameOrService}</p>
                </g:if>
                <p>${child.address.postalCode} ${child.address.city}</p>
                <g:if test="${child.address.countryName}">
                  <p>${child.address.countryName}</p>
                </g:if>
              </div>
            </dd>
          </dl>
        </div>
        <div class="yui-u">
        </div>
      </div>
    </div>
  </body>
</html>
