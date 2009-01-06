<div class="yui-g">
  <h3>${doc.pagesTitle}</h3>
  <img src="${createLink('action':'binary', 'params':[id: doc.id, pn: page])}"/>
  <g:if test="${doc.prevPage}">
    <a href="${createLink('action':'details', 'params':[id: doc.id, pn: doc.prevPage])}">
      <g:message code="action.previous"/>
    </a>
  </g:if>
  <g:if test="${doc.nextPage}">
    <a href="${createLink('action':'details', 'params':[id: doc.id, pn: doc.nextPage])}">
      <g:message code="action.next"/>
    </a>
  </g:if>
</div> 
