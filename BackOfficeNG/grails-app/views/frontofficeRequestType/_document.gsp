<fieldset>
  <legend>${message(code:documentType.i18nKey)} <span>${message(code:'request.step.document.formats')}</span></legend>
  <label>${message(code:'document.header.description')}</label>
  <input type="text" name="ecitizenNote" value="${document?.ecitizenNote}"/>

  <g:each var="data" in="${document?.datas}" status="index">
    <label ${index == 0 ? 'class="required"' : ''}>${message(code:'document.header.page')} ${index + 1} ${message(code:'document.message.typeFileRequest')} ${data.contentType}</label>
    <input type="file" name="documentData-${index}"/>
    <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}?isRequestCreation=true&pn=${index}" target="blank" title="${message(code:'document.message.preview.longdesc')}">
      ${message(code:'document.message.preview')}
    </a>
    <g:if test="${index > 0}">
      <a href="${createLink(controller:'frontofficeRequestDocument', action:'deletePage', params:['requestId':rqt.id, 'documentTypeId':documentType.id, 'documentId':document?.id, 'pageIndex':index])}">
        ${message(code:'action.delete')}
      </a>
    </g:if>
  </g:each>

  <label ${!document ? 'class="required"' : ''}>${message(code:'document.header.newPage')}</label>
  <input type="file" name="documentData-${document != null ? document.datas.size() : 0}" />
</fieldset>

<p class="document-button">
  <input type="hidden" name="requestId" value="${rqt.id}" />
  <input type="hidden" name="documentTypeId" value="${documentType.id}" />
  <input type="hidden" name="documentId" value="${document?.id}" />
  <input type="submit" name="save" value="${message(code:'action.save')}" />
  <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'document'])}">
    ${message(code:'action.back')}
  </a>
</p>

