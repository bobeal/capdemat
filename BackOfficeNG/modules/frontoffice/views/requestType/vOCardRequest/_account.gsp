<label class="required"><g:message code="vcr.property.homeFolderResponsible" /></label>
<select name="homeFolderResponsible" class="required validate-not-first" title="<g:message code='vcr.property.homeFolderResponsible.validationError' />">
  <option value=""><g:message code="message.select.defaultOption" /></option>
  <g:each var="adult" in="${adults}" status="index">
    <option value="adults[${index}]" ${account.homeFolderResponsible == 'adults[' +index + ']' ? 'selected="selected"': ''}>
      ${adult.lastName} ${adult.firstName}
    </option>
  </g:each>
</select>

<fieldset class="required">
  <legend><g:message code="vcr.property.passwords" /></legend>
  <label class="required"><g:message code="homeFolder.adult.property.password" /></label>
  <input type="password" name="password" value="${account.password}" minlength="8"
    class="required" title="<g:message code='homeFolder.adult.property.password.validationError' />">

  <label class="required"><g:message code="vcr.property.confirmPassword" /></label>
  <input type="password" name="confirmPassword" value="${account.confirmPassword}" minlength="8"
    class="required" title="<g:message code='vcr.property.confirmPassword.validationError' />">

</fieldset>

<fieldset class="required">
  <legend><g:message code="vcr.property.reminder" /></legend>

  <label class="required"><g:message code="homeFolder.adult.property.question" /></label>
  <select name="question" class="required validate-not-first" title="<g:message code='homeFolder.adult.property.question.validationError' />">
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each in="${['q1','q2','q3','q4']}">
      <option value="<g:message code='homeFolder.adult.question.${it}' />" ${message(code:'homeFolder.adult.question.' + it) == account.question.toString() ? 'selected="selected"': ''}>
        <g:message code="homeFolder.adult.question.${it}" />
      </option>
    </g:each>
  </select>

  <label class="required"><g:message code="homeFolder.adult.property.answer" /></label>
  <input type="text" name="answer" value="${account.answer}"
  class="required" title="<g:message code="homeFolder.adult.property.answer.validationError" />">

</fieldset>

