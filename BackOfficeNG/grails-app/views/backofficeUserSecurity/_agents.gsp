<h2>${message(code:'user.header.agentPermissions')}</h2>
<div class="editableListSwithcher">
  <a class="view allowed ${view == 'allowed' ? 'current' : ''}">${message(code:'user.filter.allowed')}</a> 
  / <a class="view all ${view == 'all' ? 'current' : ''}">${message(code:'user.filter.all')}</a>
</div>
<ul class="editableList">
  <g:each in="${agents}" var="agent">
    <li id="agent_${agent.id}" class="${mapRules[agent.id] ? '' : 'notBelong'}">
      <a class="disallow"><span>${message(code:'category.action.unassociate')}</span></a>
      <a class="configure"><span>${message(code:'category.action.edit')}</span></a>
      <span class="itemName ${agent.active ? 'active' : ''}">
        ${agent.lastName} ${agent.firstName}
      </span>
      ${g.tag(var:mapRules.get(agent.id, fr.cg95.cvq.business.users.UserSecurityProfile.READ), i18n:'user.securityProfile')}
    </li>
  </g:each>
</ul>
