<div class="account-fieldset required validation-scope">
  <g:set var="listIndex" value="${editList?.name == 'children' ? editList?.index : ( individuals?.children ? individuals?.children.size() : 0 ) }" />
  <fieldset class="account-fieldset-add required">
    <div class="yui-g">
      <div class="yui-u first">
      <label class="required"><g:message code="homeFolder.individual.property.lastName" /></label>
      <input type="text" name="_individuals.children[${listIndex}].lastName" value="${editList?.children?.lastName}"
        class="required validate-lastName" title="<g:message code="homeFolder.individual.property.lastName.validationError" />">

      <label class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
      <input type="text" name="_individuals.children[${listIndex}].firstName" value="${editList?.children?.firstName}"
      class="required validate-firstName" title="<g:message code="homeFolder.individual.property.firstName.validationError" />">
    </div>
      
    <div class="yui-u">
      <label class="required"><g:message code="homeFolder.child.property.sex" /></label>
      <select name="_individuals.children[${listIndex}].sex" class="required validate-not-first" title="<g:message code="homeFolder.child.property.sex.validationError" />">
        <option value=""><g:message code="message.select.defaultOption" /></option>
        <g:each in="${['Male','Female']}">
          <option value="fr.cg95.cvq.business.users.SexType_${it}" ${it == editList?.children?.sex?.toString() ? 'selected="selected"': ''}>
              <g:capdematEnumToField var="${it}" i18nKeyPrefix="homeFolder.child.sex" />
          </option>
        </g:each>
      </select>

      <label class="required"><g:message code="homeFolder.individual.property.birthDate" /> <span><g:message code="homeFolder.individual.property.birthDate.help" /></span></label>
      <input type="text" name="_individuals.children[${listIndex}].birthDate" value="${formatDate(formatName:'format.date',date:editList?.children?.birthDate)}"
        class="required validate-date" title="<g:message code="homeFolder.individual.property.birthDate.validationError" />">
      </div>
    </div>
    
    <input type="hidden" name="individuals" />
    <input type="hidden" name="objectToBind" value="individuals" />
    <g:if test="${editList?.name == 'children'}">
      <input type="submit" id="submit-collectionModify-children-children[${listIndex}]" name="submit-collectionModify-children-children[${listIndex}]" value="${message(code:'action.save')}" />
      <input type="submit" id="submit-collectionCancel-children-children[${listIndex}]" name="submit-collectionCancel-children-children[${listIndex}]" value="${message(code:'action.cancel')}" />
    </g:if>
    <g:else>
      <input type="submit" id="submit-collectionAdd-children-children[${listIndex}]" name="submit-collectionAdd-children-children[${listIndex}]" value="${message(code:'action.add')}" />
    </g:else>
  </fieldset>
  <div class="error" id="stepForm-children-error"> </div>

  <g:each var="it" in="${individuals?.children}" status="index">
  <fieldset class="account-fieldset-edit">
    <h4>
      ${it.firstName} ${it.lastName}
      <input type="hidden" name="objectToManage[${index}]" value="individuals" />
      <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-children-children[${index}]" />
      <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-children-children[${index}]" />
    </h4>
    <dl>
      <!--
      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt>
      <dd>${it.lastName}</dd>

      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd>${it.firstName}</dd>
      -->
      <dt><g:message code="homeFolder.child.property.sex" /> : </dt>
      <dd><g:capdematEnumToField var="${it.sex}" i18nKeyPrefix="homeFolder.child.sex" /></dd>

      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd><span><g:formatDate formatName="format.date" date="${it.birthDate}"/></span></dd>
    </dl>
  </fieldset>
  </g:each>
</div>

