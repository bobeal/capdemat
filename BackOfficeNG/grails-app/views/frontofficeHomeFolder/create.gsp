<html>
  <head>
    <title>${message(code:'homeFolder.title.admin')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'data-detail.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  <body>
    <g:if test="${flash.errorMessage}">
      <div class="error-box">
        <p>${flash.errorMessage}</p>
      </div>
    </g:if>
    <div class="main-box data-detail">
      <h2>${message(code:'account.message.useAccountToFillRequest')}</h2>
      <div class="yui-gb">
        <form action="${createLink(controller : 'frontofficeHome', action : 'login')}" method="post">
          <input type="hidden" name="requestTypeLabel" value="${params.requestTypeLabel}" />
          <div class="yui-u first">
            <label class="required">
              <g:message code="homeFolder.adult.property.login" />
              <input type="text" name="login" value="" class="required"
                title="<g:message code="homeFolder.adult.property.login.validationError" />" />
            </label>
          </div>
          <div class="yui-u">
            <label class="required">
              <g:message code="homeFolder.adult.property.password" />
              <input type="password" name="password" value="" class="required"
                title="<g:message code="homeFolder.adult.property.password.validationError" />" />
            </label>
          </div>
          <div class="yui-u">
            <input type="submit" value="${message(code:'action.login')}" />
          </div>
        </form>
      </div>
    </div>
    <g:if test="${invalidFields && !invalidFields.isEmpty()}">
      <div class="error-box">
        <p><g:message code="form.error.invalidFields" /></p>
      </div>
    </g:if>
    <div class="main-box data-detail">
      <h2><g:message code="homeFolder.action.createAccount"/></h2>
      <form action="${createLink(controller : 'frontofficeHomeFolder', action:'create')}" method="post">
        <input type="hidden" name="requestTypeLabel" value="${params.requestTypeLabel}" />
        <div class="yui-gb">
          <h3><g:message code="homeFolder.individual.header.civilInformations" /></h3>
          <div class="yui-u first">
            <label for="title" class="required">
              <g:message code="homeFolder.adult.property.title" />
            </label>
            <select id="title" name="title"
              class="required validate-not-first ${invalidFields.contains('title') ? 'validation-failed' : ''}"
              title="<g:message code="homeFolder.adult.property.title.validationError" />">
              <option value="">
                <g:message code="message.select.defaultOption" />
              </option>
              <g:each in="${fr.cg95.cvq.business.users.TitleType.allTitleTypes}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}"
                  ${it == adult?.title ? 'selected="selected"': ''}>
                  <g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.title" />
                </option>
              </g:each>
            </select>
          </div>
          <div class="yui-u">
            <label for="lastName" class="required">
              <g:message code="homeFolder.individual.property.lastName" />
            </label>
            <input type="text" id="lastName" name="lastName" value="${adult?.lastName}"
              class="required validate-lastName ${invalidFields.contains('lastName') ? 'validation-failed' : ''}"
              title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />
          </div>
          <div class="yui-u">
            <label for="firstName" class="required">
              <g:message code="homeFolder.individual.property.firstName" />
            </label>
            <input type="text" id="firstName" name="firstName" value="${adult?.firstName}"
              class="required validate-firstName ${invalidFields.contains('firstName') ? 'validation-failed' : ''}"
              title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />
          </div>
        </div>
        <div class="yui-g">
          <h3><g:message code="homeFolder.individual.header.contactInformations" /></h3>
          <div class="yui-u first">
            <label class="required"><g:message code="homeFolder.individual.property.address" /></label>
            <div class="address-fieldset required ${invalidFields.contains('adress') ? 'validation-failed' : ''}">
              <label for="adress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
              <input type="text" class="validate-addressLine38 ${invalidFields.contains('adress.additionalDeliveryInformation') ? 'validation-failed' : ''}" maxlength="38" id="adress.additionalDeliveryInformation" name="adress.additionalDeliveryInformation"
                value="${adult?.adress?.additionalDeliveryInformation}" />
              <label for="adress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
              <input type="text" class="validate-addressLine38 ${invalidFields.contains('adress.additionalGeographicalInformation') ? 'validation-failed' : ''}" maxlength="38" id="adress.additionalGeographicalInformation" name="adress.additionalGeographicalInformation"
                value="${adult?.adress?.additionalGeographicalInformation}" />
              <label for="adress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
              <label for="adress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
              <input type="text" class="line1 validate-streetNumber ${invalidFields.contains('adress.streetNumber') ? 'validation-failed' : ''}" size="5" maxlength="5" id="adress.streetNumber" name="adress.streetNumber"
                value="${adult?.adress?.streetNumber}" />
              <input type="text" class="line2 required validate-streetName ${invalidFields.contains('adress.streetName') ? 'validation-failed' : ''}" maxlength="32" id="adress.streetName" name="adress.streetName" title="<g:message code="address.property.streetName.validationError" />"
                value="${adult?.adress?.streetName}" />
              <label for="adress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
              <input type="text" class="validate-addressLine38 ${invalidFields.contains('adress.placeNameOrService') ? 'validation-failed' : ''}" maxlength="38" id="adress.placeNameOrService" name="adress.placeNameOrService"
                value="${adult?.adress?.placeNameOrService}" />
              <label for="adress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
              <label for="adress.city" class="required"><g:message code="address.property.city" /> *</label><br />
              <input type="text" class="line1 required validate-postalCode ${invalidFields.contains('adress.postalCode') ? 'validation-failed' : ''}" size="5" maxlength="5" id="adress.postalCode" name="adress.postalCode" title="<g:message code="address.property.postalCode.validationError" />"
                value="${adult?.adress?.postalCode}" />
              <input type="text" class="line2 required validate-city ${invalidFields.contains('adress.city') ? 'validation-failed' : ''}" maxlength="32" id="adress.city" name="adress.city" title="<g:message code="address.property.city.validationError" />"
                value="${adult?.adress?.city}" />
              <label for="adress.countryName"><g:message code="address.property.countryName" /></label>
              <input type="text" class="validate-addressLine38 ${invalidFields.contains('adress.countryName') ? 'validation-failed' : ''}" maxlength="38" id="adress.countryName" name="adress.countryName"
                value="${adult?.adress?.countryName}" />
            </div>
          </div>
          <div class="yui-u">
            <label for="email" class="required">
              <g:message code="homeFolder.adult.property.email" /> <span><g:message code="homeFolder.adult.property.email.help" /></span>
            </label>
            <input type="text" id="email" name="email" value="${adult?.email}"
              class="required validate-email ${invalidFields.contains('email') ? 'validation-failed' : ''}"
              title="<g:message code="homeFolder.adult.property.email.validationError" />" />
            <label class="required">
              <g:message code="homeFolder.adult.label.phones" />
              <span>(<g:message code="homeFolder.adult.label.phones.help" />)</span>
            </label>
            <div id="adultPhones"
              class="address-fieldset ${invalidFields.contains('adultPhones') ? 'validation-failed' : ''}">
              <label for="homePhone">
                <g:message code="homeFolder.adult.property.homePhone" />
                <span><g:message code="homeFolder.adult.property.homePhone.help" /></span>
              </label>
              <input type="text" id="homePhone" name="homePhone" value="${adult?.homePhone}"
                class="validate-phone ${invalidFields.contains('homePhone') ? 'validation-failed' : ''}"
                title="<g:message code="homeFolder.adult.property.homePhone.validationError" />" />
              <label for="mobilePhone">
                <g:message code="homeFolder.adult.property.mobilePhone" />
                <span><g:message code="homeFolder.adult.property.mobilePhone.help" /></span>
              </label>
              <input type="text" id="mobilePhone" name="mobilePhone" value="${adult?.mobilePhone}"
                class="validate-mobilePhone ${invalidFields.contains('mobilePhone') ? 'validation-failed' : ''}"
                title="<g:message code="homeFolder.adult.property.mobilePhone.validationError" />" />
              <label for="officePhone">
                <g:message code="homeFolder.adult.property.officePhone" />
                <span><g:message code="homeFolder.adult.property.officePhone.help" /></span>
              </label>
              <input type="text" id="officePhone" name="officePhone" value="${adult?.officePhone}"
                class="validate-phone ${invalidFields.contains('officePhone') ? 'validation-failed' : ''}"
                title="<g:message code="homeFolder.adult.property.officePhone.validationError" />" />
            </div>
          </div>
        </div>
        <div class="yui-g">
          <h3><g:message code="homeFolder.individual.header.connexionInformations" /></h3>
          <div class="yui-u first">
            <label for="password" class="required">
              <g:message code="request.step.validation.label.choosePassword" /> <span>(<g:message code="request.step.validation.help.choosePassword" />)</span>
            </label>
            <input type="password" id="password" name="password" value=""
              class="required ${invalidFields.contains('password') ? 'validation-failed' : ''}"
              title="<g:message code="homeFolder.adult.property.password.validationError" />" />
            <label for="question" class="required">
              <g:message code="homeFolder.adult.property.question" />
            </label>
            <select id="question" name="question"
              class="required validate-not-first ${invalidFields.contains('question') ? 'validation-failed' : ''}"
              title="<g:message code='homeFolder.adult.property.question.validationError' />">
              <option value="">${message(code:'message.select.defaultOption')}</option>
              <g:each in="${['q1','q2','q3','q4']}">
                <option value="${message(code:'homeFolder.adult.question.' + it)}"
                  <g:if test="${message(code:'homeFolder.adult.question.' + it).equals(adult?.question)}"> selected="selected"</g:if>>
                  ${message(code:'homeFolder.adult.question.' + it)}
                </option>
              </g:each>
            </select>
          </div>
          <div class="yui-u">
            <label for="confirmPassword" class="required">
              <g:message code="request.step.validation.label.confirmPassword" />
            </label>
            <input type="password" id="confirmPassword" name="confirmPassword" value=""
              class="required ${invalidFields.contains('confirmPassword') ? 'validation-failed' : ''}"
              title="<g:message code="vcr.property.confirmPassword.validationError" />" />
            <label for="answer" class="required">
              ${message(code:'homeFolder.adult.property.answer')}
            </label>
            <input type="text" id="answer" name="answer" value="${adult?.answer}"
              class="required ${invalidFields.contains('answer') ? 'validation-failed' : ''}"
              title="${message(code:'homeFolder.adult.property.answer.validationError')}" />
          </div>
        </div>
        <div class="yui-gb">
          <div class="yui-u first">
            <jcaptcha:jpeg name="captchaImage" alt="captcha" />
          </div>
          <div class="yui-u">
            <label for="captchaText" class="required">
              ${message(code:'request.step.validation.label.typeTextInImage')}
            </label>
            <input type="text" id="captchaText" name="captchaText" class="required"
              title="${message(code:'request.step.validation.error.captcha')}" />
          </div>
          <div class="yui-u">
            <input type="submit" value="${message(code:'action.create')}" />
          </div>
        </div>
      </form>
    </div>
  </body>
</html>
