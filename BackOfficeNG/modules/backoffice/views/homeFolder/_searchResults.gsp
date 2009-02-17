<g:if test="${count > 0}">
  <div class="pagination" id="pagination-top"></div>
  <ul>
    %{--<g:render template="searchResult" var="record" collection="${records}" />--}%
    <g:each var="record" in="${records}">
      <li>
        <p class="first-line">
          ${record.firstName} ${record.lastName} 
          ${message(code:'property.id')}: ${record.id}
          ${message(code:'property.homeFolderId')}: ${record.homeFolderId}
        </p>
      </li>
    </g:each>
  </ul>
  <div class="pagination" id="pagination-bottom"></div>
</g:if>
<g:elseif test="${!request.get}">
  <strong><g:message code="message.noResultFound" /></strong>
</g:elseif>