<g:if test="${!isChildLegalResponsibleEdit}">

<label class="required"><g:message code="homeFolder.property.children" /></label>
<div class="collection-fieldset required validation-scope">

  <g:set var="listIndex" value="${currentChild.id}" />
  <fieldset class="collection-fieldset-add required">
    <label class="required"><g:message code="homeFolder.individual.property.lastName" /></label>
    <input type="text" name="lastName" value="${currentChild.child.lastName}"
      class="required validate-lastName" title="<g:message code="homeFolder.individual.property.lastName.validationError" />">

    <label class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
    <input type="text" name="firstName" value="${currentChild.child.firstName}"
      class="required validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />">

    <label><g:message code="homeFolder.individual.property.firstName2" /></label>
    <input type="text" name="firstName2" value="${currentChild.child.firstName2}"
      class="validate-firstName" title="<g:message code="homeFolder.individual.property.firstName2.validationError" />">

    <label><g:message code="homeFolder.individual.property.firstName3" /></label>
    <input type="text" name="firstName3" value="${currentChild.child.firstName3}"
      class="validate-firstName" title="<g:message code="homeFolder.individual.property.firstName3.validationError" />">

    <label class="required"><g:message code="homeFolder.child.property.sex" /></label>
    <select name="sex" class="required validate-not-first" title="<g:message code="homeFolder.child.property.sex.validationError" />">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${['Male','Female']}">
        <option value="fr.cg95.cvq.business.users.SexType_${it}" ${it == currentChild.child.sex?.toString() ? 'selected="selected"': ''}>
            <g:capdematEnumToField var="${it}" i18nKeyPrefix="homeFolder.child.sex" />
        </option>
      </g:each>
    </select>

    <label class="required"><g:message code="homeFolder.individual.property.birthDate" /> <span><g:message code="homeFolder.individual.property.birthDate.help" /></span></label>
    <input type="text" name="birthDate" value="${formatDate(formatName:'format.date',date:currentChild.child.birthDate)}"
      class="required validate-date" title="<g:message code="homeFolder.individual.property.birthDate.validationError" />">

    <label><g:message code="homeFolder.individual.property.birthCity" /></label>
    <input type="text" name="birthCity" value="${currentChild.child.birthCity}"
      class="validate-city" title="<g:message code="homeFolder.individual.property.birthCity.validationError" />">

    <label><g:message code="homeFolder.individual.property.birthPostalCode" /></label>
    <input type="text" name="birthPostalCode" value="${currentChild.child.birthPostalCode}"
      class="validate-postalcode" title="<g:message code="homeFolder.individual.property.birthPostalCode.validationError" />">

    <label><g:message code="homeFolder.individual.property.birthCountry" /></label>
    <select name="birthCountry">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${['EuropeanUnion','OutsideEuropeanUnion']}">
        <option value="<g:message code='vcr.birthCountry.${StringUtils.pascalToCamelCase(it)}' />" 
					${message(code:'vcr.birthCountry.' + StringUtils.pascalToCamelCase(it)) == currentChild.child.birthCountry?.toString() ? 'selected="selected"': ''}>
          <g:capdematEnumToField var="${it}" i18nKeyPrefix="vcr.birthCountry" />
        </option>
      </g:each>
    </select>

    <g:if test="${!adults.isEmpty()}">
    <div class="legalResponsiblesList">
    <fieldset>
      <legend><g:message code="vcr.property.childAdultLegalResponsibles" /> :</legend>
      <span><g:message code="vcr.property.childAdultLegalResponsibles.help" /> </span>
      <ul>
        <g:each var="adult" in="${adults}" status="index">
          <g:set var="checked" value="${currentChild.adultLegalResponsibles == null ? false : (currentChild.adultLegalResponsibles['adults[' + index + ']'] == true ? true : false) }" />
          <li>
            <div class="name">
                ${adult.lastName} ${adult.firstName}
             </div>
             <div class="check">
                <input id="LR_adults[${index}]" type="checkbox" name="LR_adults[${index}]" ${checked == true ? 'checked="checked"': ''} />
             </div>
            <div class="endLine"></div>
          <li/>
        </g:each>
      </ul>
    </fieldset>
    </div>
    </g:if>

    <div class="legalResponsiblesList">
    <fieldset>
      <legend><g:message code="vcr.property.childLegalResponsibles" /> :</legend>

      <g:if test="${currentChild.legalResponsibles.isEmpty()}">
        <span><g:message code="vcr.property.childLegalResponsibles.help" /></span>
      </g:if>

      <g:if test="${!adults.isEmpty() && currentChild.legalResponsibles.isEmpty()}">
        <span><g:message code="vcr.property.childLegalResponsiblesAdultsNotEmpty.help" /></span>
      </g:if>

      <g:if test="${!currentChild.legalResponsibles.isEmpty()}">
        <ul>
        <g:each var="legalResponsible" in="${currentChild.legalResponsibles}" status="index">
          <li>
            <div class="name">
              ${legalResponsible.individual.lastName} ${legalResponsible.individual.firstName} <g:capdematEnumToFlag var="${legalResponsible.role}" i18nKeyPrefix="homeFolder.role" />
              <input id="LR_legalResponsibles[${legalResponsible.id}]" type="hidden" name="LR_legalResponsibles[${legalResponsible.id}]" />
            </div>
            <div class="action">
              <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-children-currentLegalResponsibles[${legalResponsible.id}]-fromChildren" />
              <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-children-currentLegalResponsibles[${legalResponsible.id}]-fromChildren" />
            </div>
            <div class="endLine"></div>
          <li/>
        </g:each>
        </ul>
      </g:if>
      <div name="legalResponsibleAdd">
        <input type="submit" name="submit-legalResponsibleAdd-children-childId[${listIndex}]"
          value="${message(code:'vcr.action.addLegalResponsibles')}" />
      </div>
    </fieldset>
    </div>

    <g:if test="${children.isEmpty() || currentChild.id == children.size()}">
      <input type="submit" id="submit-collectionAdd-children-children[${listIndex}]" name="submit-collectionAdd-children-children[${listIndex}]" value="${message(code:'action.add')}" />
    </g:if>
    <g:else>
      <input type="submit" id="submit-collectionModify-children-children[${listIndex}]" name="submit-collectionModify-children-children[${listIndex}]" value="${message(code:'action.save')}" />
      <input type="submit" id="submit-collectionCancel-children-children[${listIndex}]" name="submit-collectionCancel-children-children[${listIndex}]" value="${message(code:'action.cancel')}" />
    </g:else>
  </fieldset>
  <div class="error" id="stepForm-children-error"> </div>

  <g:each var="child" in="${children}" status="index">
  <fieldset class="collection-fieldset-edit">
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
        <g:each var="childLegalResponsible" in="${childrenLegalResponsibles['children[' + index + ']']}" status="clrIndex">
          <li>
            ${childLegalResponsible.value.individual.lastName} ${childLegalResponsible.value.individual.firstName}
            <g:capdematEnumToFlag var="${childLegalResponsible.value.role}" i18nKeyPrefix="homeFolder.role" />
          </li>
        </g:each>
        </ul>
      </dd>
    </dl>
    <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-children-children[${index}]" />
    <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-children-children[${index}]" />
  </fieldset>
  </g:each>
</div>
</g:if>
<g:else>
    <g:render template="/frontofficeRequestType/vOCardRequest/legalResponsibles" />
</g:else>
