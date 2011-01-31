<div id="child_${child.id}" class="account collapse">
  <a class="toggle">${message(code:'action.expand')} / ${message(code:'action.collapse')}</a>
  <dl class="edit state collapse">
    <g:render template="static/childState" model="['child':child]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.identity')}</h3>
  <dl class="edit identity collapse">
    <g:render template="static/childIdentity" model="['child':child]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.responsibles')}</h3>
  <dl class="edit responsibles collapse">
    <g:render template="static/childResponsibles" model="['child':child, 'roleOwners': roleOwners]" />
  </dl>
</div>
