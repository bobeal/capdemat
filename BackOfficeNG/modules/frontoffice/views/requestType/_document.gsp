<g:if test="${isDocumentEditMode}">  
  <fieldset>
    <legend>${message(code:documentType.i18nKey)}</legend>
    
    <label>Comentaire</label>
    <input type="text" name="ecitizenNote" value=""/>
    
    <label>Nouvelle Page</label>
    <input type="file" name="data-"/>
    <input type="submit" name="submit-documentAddPage-document-documentTypeId:${documentType.id}" value="ajouter" />

<!--    <label>Page 1</label>-->
<!--    <input type="file" /> <input type="submit" value="modifier" /> <a href="">aperçu</a>-->
<!--    <label>Page 2</label>-->
<!--    <input type="file" /> <input type="submit" value="modifier" /> <a href="">aperçu</a>-->

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
