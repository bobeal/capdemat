<h4>${message(code:documentType.i18nKey)}</h4>
<g:if test="${document == null && documentsByTypes[documentType.id].provided}">
  <h5>${message(code:'document.header')}</h5>
  <g:each in="${documentsByTypes}" var="type">
    <g:if test="${type.value.provided && type.key == documentType.id}">
    <dl>
      <g:each in="${type.value.provided}" var="document">
      <dt>
        <img src="${resource(dir:'images/icons',file:'mime_' + (document.isPDF() ? 'pdf' : 'img') + '.png')}" />
      </dt>
      <dd>
        <g:if test="${document.ecitizenNote}">
          <p>${message(code:'document.header.description')} : ${document.ecitizenNote}</p>
        </g:if>
        <p class="help">
          ${document.datas.size()} ${message(code:'property.pages')}
          <g:if test="${document.endValidityDate}">
            -
            <span>${message(code:'document.header.expireOn')} ${formatDate(date:document.endValidityDate,formatName:'format.date')}</span>
          </g:if>
        </p>
        <p>
          <a href="${createLink(controller:'frontofficeRequestDocument', action:'associate', params:['requestId':rqt.id, 'documentId':document.id])}">
            ${message(code:'action.attach')}
          </a>&nbsp;
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}">
            ${message(code:'document.message.preview')}
          </a>
        </p>
        </dd>
      </g:each>
    </dl>
    </g:if>
  </g:each>
</g:if>

  <h5>
    ${message(code:'document.header.attachNew')}
    <span class="help">${message(code:'request.step.document.formats')}</span>
  </h5>
  <dl>
  <dt>
    <img src="${resource(dir:'images/icons',file:'mime_img.png')}" />
  </dt>
  <dd>
    <p>
    <label>${message(code:'document.header.description')}</label>
    <input type="text" name="ecitizenNote" value="${document?.ecitizenNote}"/>
    </p>
    <g:each var="data" in="${document?.datas}" status="index">
      <p>
        <label ${index == 0 ? 'class="required"' : ''}>
          ${message(code:'document.header.page')} ${index + 1}
        </label>
        <input type="file" name="documentData-${index}"/>
        <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}?pn=${index}" target="blank" title="${message(code:'document.message.preview.longdesc')}">
          ${message(code:'document.message.preview')}
        </a>
        <g:if test="${index > 0}">
          &nbsp;
          <a href="${createLink(controller:'frontofficeRequestDocument', action:'deletePage', params:['requestId':rqt.id, 'documentTypeId':documentType.id, 'documentId':document?.id, 'pageIndex':index])}">
            ${message(code:'action.delete')}
          </a>
        </g:if>
      </p>
    </g:each>
    <p>
      <label ${!document ? 'class="required"' : ''}>${message(code:'document.header.newPage')}</label>
      <input type="file" name="documentData-${document != null ? document.datas.size() : 0}" />
    </p>
    <p style="padding-top: .5em;">
      <input type="submit" name="saveDocument" value="${message(code:'action.save')}" />
    </p>
  </dd>
</dl>
<p style="margin-top: 1em;">
  <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'document'])}">
    ${message(code:'action.back')}
  </a>
</p>

<input type="hidden" name="requestId" value="${rqt.id}" />
<input type="hidden" name="documentTypeId" value="${documentType.id}" />
<input type="hidden" name="documentId" value="${document?.id}" />

