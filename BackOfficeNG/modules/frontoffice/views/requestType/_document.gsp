<g:if test="${isDocumentEditMode}">  
  <fieldset>
    <legend>${message(code:documentType.i18nKey)}</legend>
    
    <label>Description</label>
    <input type="text" name="ecitizenNote" value="${document.ecitizenNote}"/>
    
    <g:each var="data" in="${document.datas}" >
      <label>Page ${data.pageNumber}</label>
      <input type="file" name="documentData-${data.pageNumber}"/>
      <input type="submit" value="modifier"
             name="submit-documentModifyPage-document-documentTypeId:${documentType.id}_id:${document.id}_dataPageNumber:${data.pageNumber}" />
      <input type="submit" value="supprimer"
             name="submit-documentDeletePage-document-documentTypeId:${documentType.id}_id:${document.id}_dataPageNumber:${data.pageNumber}" />
      <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">aperçu</a>
    </g:each>

    <label>Nouvelle Page</label>
    <input type="file" name="documentData-0"/>
    <input type="submit" value="ajouter"
           name="submit-documentAddPage-document-documentTypeId:${documentType.id}${document.id ? '_id:'+document.id : ''}" />
    
  </fieldset>
  <input type="submit" name="submit-documentSave-document-id:${document.id}" value="${message(code:'action.save')}" />
  <input type="submit" name="submit-documentCancel-document-id:${document.id}" value="${message(code:'action.cancel')}" />
</g:if>
<g:else>  
  <g:each in="${documentTypes}" var="documentType">
  <fieldset>
    <legend>${documentType.value.name}</legend>
    
    <label>Documents joints</label>
    <div class="document-fieldset">
      <g:if test="${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="${documentType.value.associated}" var="document">
        <dt>
          <g:if test="${document.ecitizenNote}">
            description : ${document.ecitizenNote}<br/>
          </g:if>
          <g:if test="${document.endValidityDate}">
            expire le ${formatDate(date:document.endValidityDate,formatName:'format.date')}
          </g:if>
        </dt>
        <dd>
          <g:if test="${document.isNew}">
            <span class="tag-state tag-active">nouveau</span>
            <input type="submit" name="submit-documentEdit-document-documentTypeId:${documentType.key}_id:${document.id}" value="modifier" />
            <input type="submit" name="submit-documentDelete-document-id:${document.id}"value="supprimer" />
            <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">aperçu</a>
          </g:if>
          <g:else>
            <input type="submit" name="submit-documentUnassociate-document-id:${document.id}"value="détacher" />
            <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">aperçu</a>
          </g:else>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        Aucun document joint
      </g:else>
    </div>
    <div class="document-add-new">
      <input type="submit" name="submit-documentAdd-document-documentTypeId:${documentType.key}" value="Joindre un nouveau document" />
    </div>
    
    <label>Documents disponibles</label>
    <div class="document-fieldset">
      <g:if test="${documentType.value.provided}">
      <dl class="document-available">
        <g:each in="${documentType.value.provided}" var="document">
        <dt>
          <g:if test="${document.endValidityDate}">
            expire le ${formatDate(date:document.endValidityDate,formatName:'format.date')}<br/>
          </g:if>
          <g:if test="${document.ecitizenNote}">
            description : ${document.ecitizenNote}
          </g:if>
        </dt>
        <dd><input type="submit" name="submit-documentAssociate-document-id:${document.id}" value="joindre" />
        <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">aperçu</a></dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        Aucun document disponible
      </g:else>
    </div>
  </fieldset>
  </g:each>
  <input type="submit" id="submit-step-document" name="submit-step-document" class="submit-step" value="${message(code:'action.save')}" />
</g:else>
