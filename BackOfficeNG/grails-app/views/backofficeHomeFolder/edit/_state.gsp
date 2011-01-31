<%
  def individual = adult != null ? adult : child
  def className = individual.class.simpleName.toLowerCase()
%>
<form id="${className}State_${individual.id}" method="post" action="${g.createLink(action:className)}">
<dt class="required">${message(code:'homeFolder.individual.property.state')}</dt>
<dd class="required">
  <select name="state">
    <g:each var="state" in="${fr.cg95.cvq.business.users.ActorState.allActorStates}">
      <option value="fr.cg95.cvq.business.users.ActorState_${state}" ${state == individual.state ? 'selected="selected"' : ''}>
        ${g.capdematEnumToText(var:state, i18nKeyPrefix:'actor.state')}
      </option>
    </g:each>
  </select>
</dd>
<g:render template="edit/submit" model="['object': individual, 'template': className + 'State']" />
</form>
