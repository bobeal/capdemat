<g:if test="${isDocumentEditMode}">  
  <fieldset>
    <legend>${message(code:documentType.i18nKey)}</legend>
    
    <label>Comentaire</label>
    <input type="text" name="ecitizenNote" value=""/>
    
    <label>Nouvelle Page</label>
    <input type="file" name="documentData-0"/>
    <input type="submit" name="submit-documentAddPage-document-documentTypeId:${documentType.id}_id:${document?.id}" value="ajouter" />
    
    <g:each var="data" in="${document?.datas}" >
    <label>Page ${data.pageNumber}</label>
    <input type="file" name="documentData-${data.id}"/>
    <input type="submit" name="submit-documentModifyPage-document-id:${document.id}_dataID:${data.id}" value="modifier" />
    <input type="submit" name="submit-documentDeletePage-document-id:${document.id}_dataID:${data.id}" value="supprimer" />
    <a href="">aperçu</a>
    </g:each>
    
    <input type="hidden" name="documentId" value="${document}" />
  </fieldset>
</g:if>
<g:else>  
  <g:each in="${documentTypes}" var="documentType">
  <fieldset>
    <legend>${message(code:documentType.value.i18nKey)}</legend>
    
    <label>Documents joints</label>
    <div class="document-add-new">
      <input type="submit" name="submit-documentAdd-document-documentTypeId:${documentType.key}" value="Joindre un nouveau document" />
    </div>
    <div class="document-fieldset">
      <g:if test="${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="${documentType.value.associated}" var="document">
        <dt>expire le ${formatDate(date:document.endValidityDate,formatName:'format.date')}</dt>
        <dd>
          <span class="tag-state tag-active">new</span>
          <input type="submit" name="submit-documentEdit-document-documentTypeId:${documentType.key}_id:${document.id}" value="modifier" />
          <input type="submit" name="submit-documentDelete-document-id:${document.id}"value="supprimer" />
          <a href="">aperçu</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
      No associated document
      </g:else>
    </div>
    
    <label>Documents disponibles</label>
    <div class="document-fieldset">
      <g:if test="${documentType.value.provided}">
      <dl class="document-available">
        <g:each in="${documentType.value.provided}" var="document">
        <dt>expire le ${formatDate(date:document.endValidityDate,formatName:'format.date')}</dt>
        <dd><input type="submit" name="submit-documentAssociate-document-id:${document.id}" value="joindre" /> <a href="">aperçu</a></dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
      No provided document
      </g:else>
    </div>
  </fieldset>
  </g:each>
</g:else>
