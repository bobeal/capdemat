<g:if test="${!shortMode}">
  <g:each var="document" in="${documents}">
    <li>
      <a class="${document.state.cssClass} documentState_${document.id} ${document?.id?'':'not-supplied'} documentLink" id="displayDocPanel_${document.id}" 
        href="${createLink(controller:'backofficeDocumentInstruction')}/edit/${document.id}?dtid=${document.documentTypeId}&rid=${requestId}">
        <g:message code="${document.state.i18nKey}" />
      </a>
      ${document.name}
    </li>
  </g:each>
</g:if>
<g:else>
  <g:each var="document" status="i" in="${documents}">
    <g:if test="${document.id != 0}">
      <li>
        <a class="documentLink" id="displayDocPanel_${document.id}" 
          href="${createLink(controller:'backofficeDocumentInstruction')}/edit/${document.id}">
          ${document.name}</a> - ${document.pageNumber} <g:message code="property.pages"/>
         <g:if test="${document.endValidityDate}">
          (<g:message code="document.property.endValidityDate"/> : 
            <g:formatDate formatName="format.date" date="${document.endValidityDate}" />)
         </g:if>
      </li>
    </g:if>
  </g:each>
</g:else>