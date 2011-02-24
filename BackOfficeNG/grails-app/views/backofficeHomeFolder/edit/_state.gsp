<form id="state_${actor.id}" method="post" action="${g.createLink(action : actorType + "State", id : actor.id)}">
  <dt class="required">${message(code:'homeFolder.individual.property.state')}</dt>
  <dd class="required">
    <select name="state">
      <g:each var="state" in="${states}">
        <option value="${state}" ${state == actor.state ? 'selected="selected"' : ''}>
          ${g.capdematEnumToText(var:state, i18nKeyPrefix:'actor.state')}
        </option>
      </g:each>
    </select>
  </dd>
  <g:render template="edit/submit" model="['object': actor]" />
</form>
