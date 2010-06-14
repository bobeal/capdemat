<fieldset>
  <legend>${message(code:documentType.i18nKey)} <span>${message(code:'request.step.document.formats')}</span></legend>
  <label>${message(code:'document.header.description')}</label>
  <input type="text" name="ecitizenNote" value="${document?.ecitizenNote}"/>
  
  <g:each var="data" in="${document?.datas}" status="index">
    <label>${message(code:'document.header.page')} ${index + 1} ${message(code:'document.message.typeFileRequest')} ${data.contentType}</label>
    <input type="file" name="documentData-${index}"/>
    <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}?isRequestCreation=true&pn=${data.index}" target="blank" title="${message(code:'document.message.preview.longdesc')}">
      ${message(code:'document.message.preview')}
    </a>
    <a href="${createLink(controller:'frontofficeRequestDocument', action:'deletePage', params:['requestId':rqt.id, 'documentTypeId':documentType.id, 'documentId':document?.id, 'pageIndex':index])}">
      ${message(code:'action.delete')}
    </a>
  </g:each>
  
  <g:set var="i" value="${0}" />
  <g:set var="pageNumber" value="${document.datas?.size()}" />
  <g:while test="${i < documentNewPages}">
    <label>${message(code:'document.header.newPage')} ${i +1}</label>
    <input type="file" name="documentData-${pageNumber + i}" />
    <% i++ %>
  </g:while>
  <p>
    <a href="${createLink(controller:'frontofficeRequestDocument', action:'edit', params:['requestId':rqt.id, 'documentTypeId':documentType.id, 'documentId':document?.id, 'documentNewPages':documentNewPages+1])}">
      ${message(code:'document.action.addNewPage')}
    </a>
  </p>
</fieldset>

<p class="document-button">
  <input type="hidden" name="requestId" value="${rqt.id}" />
  <input type="hidden" name="documentTypeId" value="${documentType.id}" />
  <input type="hidden" name="documentId" value="${document?.id}" />
  <input type="submit" name="save" value="${message(code:'action.save')}" />
  <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'document'])}">
    ${message(code:'action.cancel')}
  </a>
</p>

