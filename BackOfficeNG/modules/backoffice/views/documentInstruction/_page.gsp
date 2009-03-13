<div id="page${pageNumber}">
  <div class="button-panel">
    <a id="displayEditPanel_${pageNumber}" href="javascript:;">
      <img src="${createLinkTo(dir:'images/icons',file:'edit.png')}" alt="${message(code:'action.edit')}">
    </a>
    <a id="confirmDeletePage_${pageNumber}" href="javascript:;">
      <img src="${createLinkTo(dir:'images',file:'delete.png')}" alt="${message(code:'action.delete')}">
    </a>
  </div>
  <div id="pageFormPanel_${pageNumber}" style="display:none">
    <div class="error" style="display:none"><g:message code="document.message.pageFileCantBeEmpty"/></div>
    <form method="post" id="pageDeleteForm_${pageNumber}" action="${g.createLink(action:'deletePage')}">
      <input type="hidden" name="documentId" value="${document.id}" />
      <input type="hidden" name="pageNumber" value="${pageNumber}" />
    </form>
    <form method="post" id="pageEditForm_${pageNumber}" action="${g.createLink(action:'modifyPage')}">
      <input type="file" class="required" name="pageFile" />
      <input type="button" name="pageModif" value="${message(code:'action.modify')}" />
      <span class="routine-indicator" style="display:none">
        <g:message code="action.loading" /> ...
      </span>
      <input type="hidden" name="pageNumber" value="${pageNumber}" />
      <input type="hidden" name="requestId" value="${params.rid}" />
      <input type="hidden" name="documentId" value="${document.id}" />
    </form>
  </div>
  <img alt="" src="${g.createLink(action:"documentPage")}/${document.id}/?pageNumber=${pageNumber}&uuid=${UUID.randomUUID().toString().substring(0,4)}"/>
</div>