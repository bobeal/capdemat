<g:if test="${isDocumentEditMode}">  
  <fieldset>
    <legend>${message(code:documentType.i18nKey)} <span><g:message code="request.step.document.formats"/></span></legend>
    <label><g:message code="document.header.description"/></label>
    <input type="text" name="ecitizenNote" value="${document.ecitizenNote}"/>
    
    <g:each var="data" in="${document.datas}" >
      <label><g:message code="document.header.page"/> ${data.pageNumber + 1}</label>
      <input type="file" name="documentData-${data.pageNumber + 1}"/>
      <input type="submit" value="${message(code:'action.modify')}"
             name="submit-documentModifyPage-document-documentTypeId:${documentType.id}_id:${document.id}_dataPageNumber:${data.pageNumber}" />
      <input type="submit" value="${message(code:'action.delete')}"
             name="submit-documentDeletePage-document-documentTypeId:${documentType.id}_id:${document.id}_dataPageNumber:${data.pageNumber}" />
      <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}?isRequestCreation=true&sessionUuid=${uuidString}&pn=${data.pageNumber}" target="blank" title="${message(code:'document.message.preview.longdesc')}"><g:message code="document.message.preview"/></a>
    </g:each>

    <label><g:message code="document.header.newPage"/></label>
    <input type="file" name="documentData-0"/>
    <input type="submit" value="${message(code:'action.add')}"
           name="submit-documentAddPage-document-documentTypeId:${documentType.id}_id:${document.id}" />
    
  </fieldset>
  <p class="document-button">
    <input type="submit" name="submit-documentSave-document-id:${document.id}_documentTypeId:${documentType.id}" value="${message(code:'action.save')}" />
  </p>
</g:if>
<g:else>  
  <g:each in="${documentTypes}" var="documentType">
  <fieldset>
    <legend>${message(code:documentType.value.name)}</legend>
    
    <label><g:message code="document.header.attachments"/></label>
    <div class="document-fieldset summary-box">
      <g:if test="${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="${documentType.value.associated}" var="document">
        <dt>
          <g:if test="${document.ecitizenNote}">
            <g:message code="document.header.description"/> : ${document.ecitizenNote}<br/>
          </g:if>
          <g:if test="${document.endValidityDate}">
            <g:message code="document.header.expireOn"/> ${formatDate(date:document.endValidityDate,formatName:'format.date')}
          </g:if>
        </dt>
        <dd>
          <g:if test="${document.isNew}">
            <span class="tag-state tag-new"><g:message code="document.header.new"/></span>
            <input type="submit" name="submit-documentEdit-document-documentTypeId:${documentType.key}_id:${document.id}" value="${message(code:'action.modify')}" />
            <input type="submit" name="submit-documentDelete-document-id:${document.id}"value="${message(code:'action.delete')}" />
            <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}?isRequestCreation=true&sessionUuid=${uuidString}" target="blank" title="${message(code:'document.message.preview.longdesc')}"><g:message code="document.message.preview"/></a>
          </g:if>
          <g:else>
            <input type="submit" name="submit-documentUnassociate-document-id:${document.id}"value="${message(code:'action.detach')}" />
            <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}"><g:message code="document.message.preview"/></a>
          </g:else>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        <g:message code="document.header.noDocuments"/>
      </g:else>
    </div>
    <label><g:message code="document.header.available"/></label>
    <div class="document-fieldset summary-box">
      <g:if test="${documentType.value.provided}">
      <dl class="document-available">
        <g:each in="${documentType.value.provided}" var="document">
        <dt>
          <g:if test="${document.endValidityDate}">
            <g:message code="document.header.expireOn"/> ${formatDate(date:document.endValidityDate,formatName:'format.date')}<br/>
          </g:if>
          <g:if test="${document.ecitizenNote}">
            <g:message code="document.header.description"/> : ${document.ecitizenNote}
          </g:if>
        </dt>
        <dd><input type="submit" name="submit-documentAssociate-document-id:${document.id}" value="${message(code:'action.attach')}" />
        <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}"><g:message code="document.message.preview"/></a></dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        <g:message code="document.header.noDocuments"/>
      </g:else>
    </div>
    <div class="document-add-new">
      <input type="submit" name="submit-documentAdd-document-documentTypeId:${documentType.key}" value="${message(code:'document.header.attachNew')}" />
    </div>
  </fieldset>
  </g:each>
  <input type="submit" id="submit-step-document" name="submit-step-document" class="submit-step" value="${message(code:'action.validate')}" />
</g:else>
