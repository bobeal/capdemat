<g:if test="${count > 0}">
  <div class="pagination" id="pagination-top"></div>
  <ul>
    <g:each var="record" in="${records}">
      <li>
        <p class="first-line">
          <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="user.state" />
          <g:if test="${record.homeFolder}">
            <a href="${createLink(action:'details',id:record.homeFolder.id)}">
          </g:if>
          ${record.firstName} 
          <span class="${state?.orderBy == 'lastName' ? 'current-sort' : ''}">${record.lastName}</span>
          <span class="${state?.orderBy == 'id' ? 'current-sort' : ''}">(${record.id})</span>
          <g:if test="${record.homeFolder}">
            </a>
          </g:if>
        </p>
        <p class="second-line">
          ${record.address.streetNumber} ${record.address.streetName}
          <g:if test="${currentSiteName != record.address.city}">
            ${record.address.postalCode} ${record.address.city}
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
        <g:if test="${record.homeFolder}">
          <p class="third-line">
            ${message(code:'property.homeFolderId')} :
            <span class="${state?.orderBy == 'homeFolder.id' ? 'current-sort' : ''}">
              ${record.homeFolder.id}
            </span>
            <g:capdematEnumToFlag var="${record.homeFolder.state}" i18nKeyPrefix="user.state" />
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