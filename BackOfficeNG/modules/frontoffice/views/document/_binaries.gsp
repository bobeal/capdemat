<div class="yui-g">
  <h3>${doc.pagesTitle} ${page + 1} / ${doc.numberOfPages}</h3>
  <img src="${createLink('action':'binary', 'params':[id: doc.id, sessionUuid:sessionUuid ,pn: page])}"/>
  <g:if test="${doc.prevPage != null}">
    <a href="${createLink('action':'details', 'params':[id: doc.id, sessionUuid:sessionUuid, pn: doc.prevPage])}">
      <g:message code="action.previous"/>
    </a>
  </g:if>
  <g:if test="${doc.nextPage != null}">
    <a href="${createLink('action':'details', 'params':[id: doc.id, sessionUuid:sessionUuid, pn: doc.nextPage])}">
      <g:message code="action.next"/>
    </a>
  </g:if>
</div> 
