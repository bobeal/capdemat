<g:each var="document" in="${documents}">
  <li>
    <a class="${document.state.cssClass} documentState_${document.id} ${document?.id?'':'not-supplied'} documentLink" id="displayDocPanel_${document.id}" 
      href="${createLink(controller:'backofficeDocumentInstruction')}/edit/${document.id}?dtid=${document.documentTypeId}&rid=${request.id}">
      <g:message code="${document.state.i18nKey}" />
    </a>
    ${document.name}
  </li>
</g:each>