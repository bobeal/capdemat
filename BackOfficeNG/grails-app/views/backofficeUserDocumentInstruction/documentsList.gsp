<g:each var="document" in="${documents}">
  <li>
    <a class="${document.state.cssClass} documentState_${document.id} ${document?.id?'':'not-supplied'} documentLink" 
      id="${!agentCanWrite && document.id == 0 ? 'doNothing' : 'displayDocPanel_'+document.id}_${UUID.randomUUID().toString().substring(0,4)}" 
      href="${createLink(controller:'backofficeUserDocumentInstruction', action : 'edit', id : document.id, params : ['dtid' : document.documentTypeId, 'homeFolderId' : homeFolderId])}">
      <g:message code="${document.state.i18nKey}" />
    </a>
    <g:if test="${document?.id}">
      <a class="removeDocument" id="removeDocument_${document.id}"> </a>
    </g:if>
    ${document.name}
  </li>
</g:each>

