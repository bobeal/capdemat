<g:each in="${documentsByTypes}" var="documentType">
<fieldset>
  <legend>${message(code:documentType.value.name)}</legend>
  
  <label>${message(code:'document.header.attachments')}</label>
  <div class="document-fieldset summary-box">
    <g:if test="${documentType.value.associated}">
    <dl class="document-linked">
      <g:each in="${documentType.value.associated}" var="document">
      <dt>
        <g:if test="${document.ecitizenNote}">
          ${message(code:'document.header.description')} : ${document.ecitizenNote}<br/>
        </g:if>
        <g:if test="${document.endValidityDate}">
          ${message(code:'document.header.expireOn')} ${formatDate(date:document.endValidityDate,formatName:'format.date')}
        </g:if>
      </dt>
      <dd>
        <g:capdematEnumToFlag var="${document.state}" i18nKeyPrefix="document.state" />
        <g:if test="${document.state.toString() == 'Draft'}">
          <a href="${createLink(controller:'frontofficeRequestDocument', action:'edit', params:['requestId':rqt.id, 'documentTypeId':documentType.key, 'documentId':document.id])}">
            ${message(code:'action.modify')}
          </a>
          <a href="${createLink(controller:'frontofficeRequestDocument', action:'delete', params:['requestId':rqt.id, 'documentId':document.id])}">
            ${message(code:'action.delete')}
          </a>
        </g:if>
        <g:else>
          <a href="${createLink(controller:'frontofficeRequestDocument', action:'unassociate', params:['requestId':rqt.id, 'documentId':document.id])}">
            ${message(code:'action.detach')}
          </a>
        </g:else>
        <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}?isRequestCreation=true" target="blank" title="${message(code:'document.message.preview.longdesc')}">
          ${message(code:'document.message.preview')}
        </a>
      </dd>
      </g:each>
    </dl>
    </g:if>
    <g:else>
      ${message(code:'document.header.noDocuments')}
    </g:else>
  </div>
  <label>${message(code:'document.header.available')}</label>
  <div class="document-fieldset summary-box">
    <g:if test="${documentType.value.provided}">
    <dl class="document-available">
      <g:each in="${documentType.value.provided}" var="document">
      <dt>
        <g:if test="${document.endValidityDate}">
          ${message(code:'document.header.expireOn')} ${formatDate(date:document.endValidityDate,formatName:'format.date')}<br/>
        </g:if>
        <g:if test="${document.ecitizenNote}">
          ${message(code:'document.header.description')} : ${document.ecitizenNote}
        </g:if>
      </dt>
      <dd>
        <g:capdematEnumToFlag var="${document.state}" i18nKeyPrefix="document.state" />
        <a href="${createLink(controller:'frontofficeRequestDocument', action:'associate', params:['requestId':rqt.id, 'documentId':document.id])}">
          ${message(code:'action.attach')}
        </a>
        <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}">
          ${message(code:'document.message.preview')}
        </a>
        </dd>
      </g:each>
    </dl>
    </g:if>
    <g:else>
      ${message(code:'document.header.noDocuments')}
    </g:else>
  </div>
  <div class="document-add-new">
    <a href="${createLink(controller:'frontofficeRequestDocument', action:'edit', params:['requestId':rqt.id, 'documentTypeId':documentType.key])}">
      ${message(code:'document.header.attachNew')}
    </a>
  </div>
</fieldset>
</g:each>
<input type="submit" id="submit-step-document" name="submit-step-document" class="submit-step" value="${message(code:'action.validate')}" />
