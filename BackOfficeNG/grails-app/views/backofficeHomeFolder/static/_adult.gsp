<div id="adult_${adult.id}" class="individual collapse">
  <a class="confirmRemoveIndividual" style="float: right;">${message(code:'action.delete')}</a>
  <a class="toggle">${message(code:'action.expand')} / ${message(code:'action.collapse')}</a>
  <dl class="${adult?.state?.toString() != 'Archived' ? 'edit' : ''} individual-state required collapse">
    <g:render template="static/state" model="['user':adult]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.identity')}</h3>
  <dl class="${adult?.state?.toString() != 'Archived' ? 'edit' : ''} individual-identity required collapse">
    <g:render template="static/adultIdentity" model="['individual':adult]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.address')}</h3>
  <dl class="${adult?.state?.toString() != 'Archived' ? 'edit' : ''} adult-address collapse">
    <g:render template="static/address" model="['user':adult]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.contact')}</h3>
  <dl class="${adult?.state?.toString() != 'Archived' ? 'edit' : ''} adult-contact collapse">
    <g:render template="static/contact" model="['adult':adult]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.connexion')}</h3>
  <dl class="collapse">
    <g:render template="static/connexion" model="['adult':adult]" />
  </dl>
  <g:each var="homeMapping" in="${homeMappings}">
  
   <g:set var="individualsMappings" value="${homeMapping.individualsMappings.groupBy { it.individualId }}" />
    <g:each var="mapping" in="${individualsMappings[adult.id]}">
     <h3>${homeMapping.externalServiceLabel}</h3>
     <dl class="${adult?.state?.toString() != 'Archived' ? 'edit' : ''} individual-${homeMapping.externalServiceLabel.replace(" ", "#")}-mapping required collapse">
       <g:render template="static/mapping" model="['mapping':mapping]" />
      </dl>
    </g:each>
  </g:each>
</div>
