<g:if test="${count > 0}">
  <div class="pagination" id="pagination-top"></div>
  <ul>
    <g:each var="record" in="${records}">
      <li>
        <p class="first-line">
          <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="user.state" />
          <g:if test="${record.homeFolderId}">
            <a href="${createLink(action:'details',id:record.homeFolderId)}">
          </g:if>
          ${record.firstName} 
          <span class="${state?.orderBy == 'lastName' ? 'current-sort' : ''}">${record.lastName}</span>
          <span class="${state?.orderBy == 'id' ? 'current-sort' : ''}">(${record.id})</span>
          <g:if test="${record.homeFolderId}">
            </a>
          </g:if>
        </p>
        <p class="second-line">
          ${record.streetNumber} ${record.streetName}
          <g:if test="${currentSiteName != record.city}">
            ${record.postalCode} ${record.city}
          </g:if>
          <g:if test="${record.birthDate}">
            - <g:message code="homeFolder.header.born"/>
            <g:message code="homeFolder.header.on"/> 
            <g:formatDate formatName="format.date" date="${record.birthDate}"/>
            <g:if test="${record.birthCity}">
              <g:message code="homeFolder.header.in"/>
              ${record.birthCity}
            </g:if>
          </g:if>
        </p>
        <g:if test="${record.homeFolderId}">
          <p class="third-line">
            ${message(code:'property.homeFolderId')} :
            <span class="${state?.orderBy == 'homeFolder.id' ? 'current-sort' : ''}">
              ${record.homeFolderId}
            </span>
            <g:capdematEnumToFlag var="${record.homeFolderState}" i18nKeyPrefix="user.state" />
          </p>
        </g:if>
      </li>
    </g:each>
  </ul>
  <div class="pagination" id="pagination-bottom"></div>
</g:if>
<g:elseif test="${!request.get}">
  <strong><g:message code="message.noResultFound" /></strong>
</g:elseif>