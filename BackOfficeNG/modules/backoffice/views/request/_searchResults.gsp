<g:if test="${totalRecords > 0}">
  <div class="pagination" id="pagination-top"></div>
  <ul>
    <g:render template="searchResult" var="record" collection="${records}" />
  </ul>
  <div class="pagination" id="pagination-bottom"></div>
</g:if>
<g:elseif test="${inSearch}">
  <strong><g:message code="message.noResultFound" /></strong>
</g:elseif>
