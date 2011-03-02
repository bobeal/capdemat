<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'data-detail.css')}" />
  </head>
  <body>
    <div class="main-box data-detail">
      <h2>${adult.firstName} ${adult.lastName}</h2>
      <div class="yui-g">
        <h3><g:message code="homeFolder.individual.header.generalInformations" /></h3>
        <div class="yui-u first">
          <dl>
            <dt><g:message code="property.creationDate" /> : </dt>
            <dd><g:formatDate formatName="format.date" date="${adult.creationDate}"/></dd>
            <dt><g:message code="property.state" /> : </dt>
            <dd><g:capdematEnumToFlag var="${adult.state}" i18nKeyPrefix="user.state" /></dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <g:if test="${!ownerRoles.homeFolder.isEmpty()}">
              <dt><g:message code="homeFolder.adult.property.homeFolderRoles" /> : </dt>
              <dd>
                <g:each var="ownerRole" in="${ownerRoles.homeFolder}">
                  <g:capdematEnumToFlag var="${ownerRole.role}" i18nKeyPrefix="homeFolder.role" />
                </g:each>
              </dd>
            </g:if>
            <g:if test="${!ownerRoles.individual.isEmpty()}">
              <dt><g:message code="homeFolder.adult.property.individualRoles" /> : </dt>
              <dd>
                <g:each var="ownerRole" in="${ownerRoles.individual}">
                  <p>
                    ${ownerRole.subjectName}
                    <g:capdematEnumToFlag var="${ownerRole.role}" i18nKeyPrefix="homeFolder.role" />
                  </p>
                </g:each>
              </dd>
            </g:if>
            <g:if test="${!subjectRoles.isEmpty()}">
              <dt><g:message code="homeFolder.adult.property.subjectRoles" /> : </dt>
              <dd>
                <g:each var="subjectRole" in="${subjectRoles}">
                  <p>
                    ${subjectRole.fullName}
                    <g:each var="role" in="${subjectRole.roles}">
                      <g:capdematEnumToFlag var="${role}" i18nKeyPrefix="homeFolder.role" />
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
            <dt><g:message code="homeFolder.adult.property.title" /> : </dt>
            <dd><g:capdematEnumToField var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" /></dd>
            <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt>
            <dd>${adult.lastName}</dd>
            <dt><g:message code="homeFolder.adult.property.maidenName" /> : </dt>
            <dd>${adult.maidenName}</dd>
            <dt><g:message code="homeFolder.adult.property.nameOfUse" /> : </dt>
            <dd>${adult.nameOfUse}</dd>
            <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
            <dd>${adult.firstName}</dd>
            <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
            <dd>${adult.firstName3}</dd>
            <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
            <dd>${adult.firstName3}</dd>
            <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
            <dd><g:capdematEnumToField var="${adult.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
            <dd><g:formatDate formatName="format.date" date="${adult.birthDate}"/></dd>
            <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
            <dd>${adult.birthCity}</dd>
            <dt><g:message code="homeFolder.individual.property.birthPostalCode" /> : </dt>
            <dd>${adult.birthPostalCode}</dd>
            <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
            <dd>${adult.birthCountry}</dd>
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
                <g:if test="${adult.address.additionalDeliveryInformation}">
                  <p>${adult.address.additionalDeliveryInformation}</p>
                </g:if>
                <g:if test="${adult.address.additionalGeographicalInformation}">
                  <p>${adult.address.additionalGeographicalInformation}</p>
                </g:if>
                <p>${adult.address.streetNumber} ${adult.address.streetName}</p>
                <g:if test="${adult.address.placeNameOrService}">
                  <p>${adult.address.placeNameOrService}</p>
                </g:if>
                <p>${adult.address.postalCode} ${adult.address.city}</p>
                <g:if test="${adult.address.countryName}">
                  <p>${adult.address.countryName}</p>
                </g:if>
              </div>
            </dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <dt><g:message code="homeFolder.adult.property.email" /> : </dt>
            <dd>${adult.email}</dd>
            <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
            <dd>${adult.homePhone}</dd>
            <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
            <dd>${adult.mobilePhone}</dd>
            <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
            <dd>${adult.officePhone}</dd>
          </dl>
        </div>
      </div>
      <div class="yui-g">
        <h3><g:message code="homeFolder.individual.header.connexionInformations" /></h3>
        <div class="yui-u first">
          <dl>
            <dt><g:message code="homeFolder.adult.property.login" /> : </dt>
            <dd>${adult.login}</dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <dt><g:message code="homeFolder.adult.property.question" /> : </dt>
            <dd>${adult.question}</dd>
            <dt><g:message code="homeFolder.adult.property.answer" /> : </dt>
            <dd>${adult.answer}</dd>
          </dl>
        </div>
      </div>
      <div class="yui-g">
        <h3><g:message code="homeFolder.individual.header.otherInformations" /></h3>
        <div class="yui-u first">
          <dl>
            <dt><g:message code="homeFolder.adult.property.profession" /> : </dt>
            <dd>${adult.profession}</dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <dt><g:message code="homeFolder.adult.property.cfbn" /> : </dt>
            <dd>${adult.cfbn}</dd>
          </dl>
        </div>
      </div>
    </div>
  </body>
</html>
