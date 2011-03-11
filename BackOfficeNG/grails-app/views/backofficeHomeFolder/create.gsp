<html>
  <head>
    <title>${message(code:'homeFolder.title.creation')}</title>
    <meta name="layout" content="main" />
    <g:if test="${flash.addressesReferentialEnabled}">
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css/common', file:'autocomplete.css')}" />
      <script type="text/javascript">
        zenexity.capdemat.contextPath = "${request.contextPath}";
      </script>
      <script type="text/javascript" src="${resource(dir:'js/common',file:'addressAutocomplete.js')}"></script>
      <script type="text/javascript" src="${resource(dir:'js/common',file:'autocomplete.js')}"></script>
    </g:if>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'contact.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'homeFolderDetails.js')}"></script>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice/common/yui-skin/',file:'container.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'homeFolder.css')}" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>${message(code:'homeFolder.title.creation')}</h1>
        </div>

        <div id="homeFolder" class="mainbox mainbox-yellow">
          <h2>${message(code:'homeFolder.search.isHomeFolderResponsible')}</h2>

          <div class="account">
            <form id="createHomeFolder"  method="post" action="${g.createLink(action:'create')}">
              <div class="yui-g">
                <div class="yui-u first">
                  <h3>${message(code:'homeFolder.individual.header.identity')}</h3>
                  <dl>
                    <dt class="required">${message(code:'homeFolder.adult.property.title')}</dt>
                    <dd class="required">
                      <select name="title">
                        <g:each var="title" in="${fr.cg95.cvq.business.users.TitleType.allTitleTypes}">
                          <option value="fr.cg95.cvq.business.users.TitleType_${title}">
                            ${g.capdematEnumToText(var:title, i18nKeyPrefix:'homeFolder.adult.title')}
                          </option>
                        </g:each>
                      </select>
                    </dd>
                    <dt>${message(code:'homeFolder.adult.property.familyStatus')}</dt>
                    <dd>
                      <select name="familyStatus">
                        <g:each var="familyStatus" in="${fr.cg95.cvq.business.users.FamilyStatusType.allFamilyStatusTypes}">
                          <option value="fr.cg95.cvq.business.users.FamilyStatusType_${familyStatus}">
                            ${g.capdematEnumToText(var:familyStatus, i18nKeyPrefix:'homeFolder.adult.familyStatus')}
                          </option>
                        </g:each>
                      </select>
                    </dd>
                    <dt class="required">${message(code:'homeFolder.individual.property.lastName')}</dt>
                    <dd class="required"><input type="text" name="lastName" /></dd>
                    <dt class="required">${message(code:'homeFolder.individual.property.firstName')}</dt>
                    <dd class="required"><input type="text" name="firstName" /></dd>
                  </dl>
                  <h3>${message(code:'homeFolder.individual.header.contact')}</h3>
                  <dl>
                    <dt class="required">${message(code:'homeFolder.adult.property.email')}</dt>
                    <dd class="required"><input type="text" name="email" /></dd>
                    <dt>${message(code:'homeFolder.adult.property.homePhone')}</dt>
                    <dd><input type="text" name="homePhone" /></dd>
                    <dt>${message(code:'homeFolder.adult.property.mobilePhone')}</dt>
                    <dd><input type="text" name="mobilePhone" /></dd>
                    <dt>${message(code:'homeFolder.adult.property.officePhone')}</dt>
                    <dd><input type="text" name="officePhone" /></dd>
                  </dl>
                </div>
                <div class="yui-u">
                  <h3>${message(code:'homeFolder.individual.header.address')}</h3>
                  <dl>
                    <dt class="required">${message(code:'homeFolder.individual.property.address')}</dt>
                    <dd class="required">
                      <label>${message(code:'address.property.additionalDeliveryInformation')}</label>
                      <input type="text" name="address.additionalDeliveryInformation" maxlength="38" />
                      <label>${message(code:'address.property.additionalGeographicalInformation')}</label>
                      <input type="text" name="address.additionalGeographicalInformation" maxlength="38" />
                      <label>Numéro et <strong>${message(code:'address.property.streetName')} * </strong></label>
                      <input type="text" id="address_streetNumber" name="address.streetNumber"  maxlength="5" class="line1" />
                      <input type="text" id="address_streetName" name="address.streetName"  maxlength="32" class="line2" />
                      <label>${message(code:'address.property.placeNameOrService')}</label>
                      <input type="text" name="address.placeNameOrService" maxlength="38" />
                      <label><strong>${message(code:'address.property.postalCode')} * - ${message(code:'address.property.city')} * </strong></label>
                      <input type="text" id="address_postalCode" name="address.postalCode" maxlength="5" class="line1" />
                      <input type="text" id="address_city" name="address.city" maxlength="32" size="4" class="line2" />
                      <label>${message(code:'address.property.countryName')}</label>
                      <input type="text" name="address.countryName" maxlength="38" />
                      <input type="hidden" id="address_streetMatriculation" name="address.streetMatriculation" />
                      <input type="hidden" id="address_streetRivoliCode" name="address.streetRivoliCode" />
                      <input type="hidden" id="address_cityInseeCode" name="address.cityInseeCode"  />
                    </dl>
                    <h3>${message(code:'homeFolder.individual.header.connexion')}</h3>
                    <dl>
                      <dt class="required">${message(code:'request.step.validation.label.choosePassword')}</dt>
                      <dd><input type="password" name="password" value="" /></dd>
                      <dt class="required">${message(code:'request.step.validation.label.confirmPassword')}</dt>
                      <dd><input type="password" name="confirmPassword" value="" /></dd>
                      <dt class="required">${message(code:'homeFolder.adult.property.question')}</dt>
                      <dd>
                        <select id="question" name="question">
                          <option value="">${message(code:'message.select.defaultOption')}</option>
                          <g:each in="${['q1','q2','q3','q4']}">
                            <option value="${message(code:'homeFolder.adult.question.' + it)}">
                              ${message(code:'homeFolder.adult.question.' + it)}
                            </option>
                          </g:each>
                        </select>
                      </dd>
                      <dt class="required">${message(code:'homeFolder.adult.property.answer')}</dt>
                      <dd><input type="text" name="answer" /></dd>
                    </dd>
                  </dl>
                </div>
              </div>
              <p style="text-align: center; margin-top: 1em;">
                <input type="submit" name="submit" value="${message(code:'action.save')}" class="create" />
                <a href="${g.createLink(action:'search')}">${message(code:'action.cancel')}</a>
              </p>
            </div>
          </form>
        </div>
      </div>
    </div>
    <div id="narrow" class="yui-b">

      <!-- home folder state -->
      <div class="nobox taskstate">
        <h3>${message(code:'header.help')}</h3>
        <div class="body">
          <p>${message(code:'homeFolder.message.creationHelp')}</p>
        </div>
      </div>
    </div>

  </body>
</html>
