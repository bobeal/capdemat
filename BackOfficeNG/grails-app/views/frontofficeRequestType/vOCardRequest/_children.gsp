<div class="collection">
  <input type="hidden" name="individuals" />
  <input type="hidden" name="objectToBind" value="individuals" />
  <button type="submit" value="${message(code:'action.add')}" name="submit-collectionAdd-children-children">
    <a>${message(code:'homeFolder.action.addNewChild')}</a>
  </button>
  <g:each var="listItem" in="${individuals?.children}" status="listIndex">
    <fieldset class="individual add">
    <h4>
      <g:if test="${listItem.lastName != null}">
        ${listItem?.firstName} ${listItem?.lastName}
      </g:if>
      <g:else>
        ${message(code:'homeFolder.message.newChild')}
      </g:else>
    <button type="submit" name="submit-collectionDelete-children-children[${listIndex}]">
      (<a>${message(code:'action.remove')}</a>)
    </buttom>
    </h4>
      <div class="yui-g">
        <div class="yui-u first">
          <label for="_individuals.children.${listIndex}.lastName" class="required"><g:message code="homeFolder.individual.property.lastName" /></label>
          <input type="text" id="_individuals.children.${listIndex}.lastName" name="_individuals.children[${listIndex}].lastName" value="${listItem?.lastName}"
            class="required validate-lastName" title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />

          <label for="_individuals.children.${listIndex}.firstName" class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
          <input type="text" id="_individuals.children.${listIndex}.firstName" name="_individuals.children[${listIndex}].firstName" value="${listItem?.firstName}"
          class="required validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />
        </div>

        <div class="yui-u">
          <label for="_individuals.children.${listIndex}.sex" class="required"><g:message code="homeFolder.child.property.sex" /></label>
          <select id="_individuals.children.${listIndex}.sex" name="_individuals.children[${listIndex}].sex" class="required validate-not-first" title="<g:message code="homeFolder.child.property.sex.validationError" />">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['Male','Female']}">
              <option value="fr.cg95.cvq.business.users.SexType_${it}" ${it == listItem?.sex?.toString() ? 'selected="selected"': ''}>
                  <g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.child.property.sex" />
              </option>
            </g:each>
          </select>

          <label for="_individuals.children.${listIndex}.birthDate" class="required"><g:message code="homeFolder.individual.property.birthDate" /> <span><g:message code="homeFolder.individual.property.birthDate.help" /></span></label>
          <input type="text" id="_individuals.children.${listIndex}.birthDate" name="_individuals.children[${listIndex}].birthDate" value="${formatDate(formatName:'format.date',date:listItem?.birthDate)}"
            class="required validate-date" title="<g:message code="homeFolder.individual.property.birthDate.validationError" />" />
        </div>
      </div>
    </fieldset>
  </g:each>
  <div class="error" id="stepForm-children-error"> </div>
</div>

