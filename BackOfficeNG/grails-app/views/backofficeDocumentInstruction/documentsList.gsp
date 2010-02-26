<g:if test="${!shortMode}">
  <g:each var="document" in="${documents}">
    <li>
      <a class="${document.state.cssClass} documentState_${document.id} ${document?.id?'':'not-supplied'} documentLink" 
        id="${!agentCanWrite && document.id == 0 ? 'doNothing' : 'displayDocPanel_'+document.id}_${UUID.randomUUID().toString().substring(0,4)}" 
        href="${createLink(controller:'backofficeDocumentInstruction', action : 'edit', id : document.id, params : ['dtid' : document.documentTypeId, 'requestId' : requestId])}">
        <g:message code="${document.state.i18nKey}" />
      </a>
      <g:if test="${document?.id}">
        <a class="removeDocument" id="removeDocument_${document.id}"> </a>
      </g:if>
      ${document.name}
    </li>
  </g:each>
</g:if>
<g:else>
  <g:each var="document" status="i" in="${documents}">
    <g:if test="${document.id != 0}">
      <li>
        <a class="removeDocument" id="removeDocument_${document.id}"> </a>
        <a class="documentLink" id="displayDocPanel_${document.id}" 
          href="${createLink(controller:'backofficeDocumentInstruction', action : 'edit', id : document.id, params : ['dtid' : document.documentTypeId, 'requestId' : requestId])}">
          ${document.name}</a> - ${document.pageNumber} <g:message code="property.pages"/>
         <g:if test="${document.endValidityDate}">
          (<g:message code="document.property.endValidityDate"/> : 
            <g:formatDate formatName="format.date" date="${document.endValidityDate}" />)
         </g:if>
      </li>
    </g:if>
  </g:each>
</g:else>
