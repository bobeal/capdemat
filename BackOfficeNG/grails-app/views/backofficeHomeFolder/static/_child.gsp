<div id="child_${child.id}" class="individual collapse">
  <g:if test="${child?.state?.toString() != 'Archived'}">
  <a class="confirmRemoveIndividual" style="float: right;">${message(code:'action.delete')}</a>
  </g:if>
  <a class="toggle">${message(code:'action.expand')} / ${message(code:'action.collapse')}</a>
  <dl class="${child?.state?.toString() != 'Archived' ? 'edit' : ''} individual-state required collapse">
    <g:render template="static/state" model="['user':child]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.identity')}</h3>
  <dl class="${child?.state?.toString() != 'Archived' ? 'edit' : ''} individual-identity required collapse">
    <g:render template="static/childIdentity" model="['individual':child]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.responsibles')}</h3>
  <dl class="${child?.state?.toString() != 'Archived' ? 'edit' : ''} child-responsibles required collapse">
    <g:render template="static/responsibles" model="['child':child, 'roleOwners': roleOwners]" />
  </dl>
  <g:each var="homeMapping" in="${homeMappings}">
   <g:set var="individualsMappings" value="${homeMapping.individualsMappings.groupBy { it.individualId }}" />
    <g:each var="mapping" in="${individualsMappings[child.id]}">
    <h3>${homeMapping.externalServiceLabel}</h3>
     <dl class="${child?.state?.toString() != 'Archived' ? 'edit' : ''} individual-${homeMapping.externalServiceLabel.replace(" ", "#")}-mapping required collapse">
       <g:render template="static/mapping" model="['mapping':mapping]" />
      </dl>
    </g:each>
  </g:each>
</div>
