<%
 def individual = adult != null ? adult : child
%>
<dt class="required">${message(code:'homeFolder.individual.property.state')}</dt>
<dd class="required">${g.capdematEnumToFlag(var:individual.state, i18nKeyPrefix:'actor.state')}</dd>
