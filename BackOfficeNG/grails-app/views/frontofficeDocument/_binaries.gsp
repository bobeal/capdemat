<div class="yui-g">
  <h3>${doc.pagesTitle} ${page + 1} / ${doc.numberOfPages}</h3>
  <div>
    <g:if test="${doc.prevPage != null}">
      <a href="${createLink('action':'details', 'params':[id: doc.id, sessionUuid:sessionUuid, pn: doc.prevPage])}">
        &lt; <g:message code="action.previous"/>
      </a>
    </g:if>
    <g:if test="${doc.nextPage != null}">
      &nbsp;
      <a href="${createLink('action':'details', 'params':[id: doc.id, sessionUuid:sessionUuid, pn: doc.nextPage])}">
        <g:message code="action.next"/> &gt;
      </a>
    </g:if>
  </div>
  <a href="${createLink('action' : 'binary', params : [id: doc.id, sessionUuid:sessionUuid, pn:page])}">
  <g:if test="${doc.preview != null}">
    <img src="${createLink('action':'preview', 'params':[id:doc.id, sessionUuid:sessionUuid, pn:page]).encodeAsXML()}" alt="${doc.title}" />
  </g:if>
  <g:else>
    <g:message code="document.message.notPreview"/>
  </g:else>
  </a>
  <a href="${createLink('action' : 'binary', params : [id: doc.id, sessionUuid:sessionUuid, pn:page])}"><g:message code="document.message.openPage" /></a>
</div>
