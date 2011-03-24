<div id="child_${child.id}" class="individual collapse">
  <a class="confirmRemoveIndividual" style="float: right;">${message(code:'action.delete')}</a>
  <a class="toggle">${message(code:'action.expand')} / ${message(code:'action.collapse')}</a>
  <dl class="${adult?.state?.toString() != 'Archived' ? 'edit' : ''} individual-state required collapse">
    <g:render template="static/state" model="['user':child]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.identity')}</h3>
  <dl class="${adult?.state?.toString() != 'Archived' ? 'edit' : ''} individual-identity required collapse">
    <g:render template="static/childIdentity" model="['individual':child]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.responsibles')}</h3>
  <dl class="${adult?.state?.toString() != 'Archived' ? 'edit' : ''} child-responsibles required collapse">
    <g:render template="static/responsibles" model="['child':child, 'roleOwners': roleOwners]" />
  </dl>
</div>
