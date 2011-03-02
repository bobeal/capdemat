<g:if test="${count > 0}">
  <div class="pagination" id="pagination-top"></div>
  <ul>
    <g:each var="record" in="${records}">
      <li>
        <p class="first-line">
          <g:if test="${record.homeFolderId}">
            <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="user.state" />
            <a href="${createLink(action:'details',id:record.homeFolderId)}">
          </g:if>
          ${record.firstName} 
          <span class="${state?.orderBy == 'lastName' ? 'current-sort' : ''}">${record.lastName}</span>
          <span class="${state?.orderBy == 'id' ? 'current-sort' : ''}">(${record.id})</span>
          <g:if test="${record.homeFolderId}">
            - ${message(code:'property.homeFolderId')}: 
            <span class="${state?.orderBy == 'homeFolder.id' ? 'current-sort' : ''}">
              ${record.homeFolderId}
            </span>
            </a>
          </g:if>
        </p>
        <p class="second-line">
          ${record.streetNumber} ${record.streetName}
          <g:if test="${currentSiteName != record.city}">
            ${record.postalCode} ${record.city}
          </g:if>
          -
          <g:if test="${record.status}">
            <span class="tag-enable"><g:message code="property.active"/></span>
          </g:if>
          <g:else>
            <span class="tag-disable"><g:message code="property.inactive"/></span>
          </g:else>
        </p>
        <g:if test="${record.birthDate}">
          <p class="third-line">
            <g:message code="homeFolder.header.born"/>
            <g:message code="homeFolder.header.on"/> 
            <g:formatDate formatName="format.date" date="${record.birthDate}"/>
            <g:if test="${record.birthCity}">
              <g:message code="homeFolder.header.in"/>
              ${record.birthCity}
            </g:if>
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