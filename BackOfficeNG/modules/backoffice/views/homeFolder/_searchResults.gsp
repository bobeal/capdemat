<g:if test="${count > 0}">
  <div class="pagination" id="pagination-top"></div>
  <ul>
    %{--<g:render template="searchResult" var="record" collection="${records}" />--}%
    <g:each var="record" in="${records}">
      <li>
        <p class="first-line">
          <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="actor.state" />
          <a href="${createLink(action:'details',id:record.homeFolderId)}">
            ${record.firstName} 
            <span style="${state?.orderBy == 'lastName' ? 'font-weight : bold' : ''}">${record.lastName}</span>
            (${message(code:'property.homeFolderId')}: 
            <span style="${state?.orderBy == 'homeFolder.id' ? 'font-weight : bold' : ''}">${record.homeFolderId}</span>, 
            ${message(code:'property.individualId')}: 
            <span style="${state?.orderBy == 'id' ? 'font-weight : bold' : ''}">${record.id}</span>)
          </a>
        </p>
        <p class="second-line">
          ${record.streetNumber} ${record.streetName}
          <g:if test="${currentSiteName != record.city}">
            ${record.postalCode} ${record.city}
          </g:if>
        </p>
      </li>
    </g:each>
  </ul>
  <div class="pagination" id="pagination-bottom"></div>
</g:if>
<g:elseif test="${!request.get}">
  <strong><g:message code="message.noResultFound" /></strong>
</g:elseif>