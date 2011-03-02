<form id="state_${user.id}" method="post" action="${g.createLink(action : "state", id : user.id)}">
  <dt class="required">${message(code:'homeFolder.individual.property.state')}</dt>
  <dd class="required">
    <select name="state">
      <g:each var="state" in="${states}">
        <option value="${state}" ${state == user.state ? 'selected="selected"' : ''}>
          ${g.capdematEnumToText(var:state, i18nKeyPrefix:'user.state')}
        </option>
      </g:each>
    </select>
  </dd>
  <g:render template="edit/submit" model="['object': user]" />
</form>
