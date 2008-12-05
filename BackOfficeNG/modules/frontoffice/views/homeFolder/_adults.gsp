<g:if test="${adults && adults.size() > 0}">
  <h2><g:message code="homeFolder.property.adults"/></h2>

  <g:each var="record" in="${adults}">
    <dl>
      <dt>${record.title} ${record.fullName}</dt>
      <dd>
        <g:message code="homeFolder.header.born" />
        <g:if test="${record?.birthDate}">
          <g:message code="homeFolder.header.on" />
          ${formatDate(date:record.birthDate,formatName:'format.date')}
        </g:if>
        <g:if test="${record?.birthCity || record?.birthPostalCode || record?.birthCountry}">
          <g:message code="homeFolder.header.in" /> 
          ${record?.birthCity}
          <g:if test="${record?.birthPostalCode}"> (${record.birthPostalCode}) </g:if>
          <g:if test="${record?.birthCountry}"> - ${record.birthCountry}</g:if>
        </g:if>
      </dd>
      <dd>${record.addressDetails}</dd>
      <g:if test="${record?.homePhone}">
        <dd>
          <g:message code="homeFolder.header.phone" /> :
          ${record.homePhone}
        </dd>
      </g:if>
      <g:if test="${record?.mobilePhone}">
        <dd>
          <g:message code="homeFolder.header.mobile" /> :
          ${record.mobilePhone}
        </dd>
      </g:if>
      <g:if test="${record?.email}">
        <dd>${record.email}</dd>
      </g:if>
    </dl>
  </g:each>

</g:if>
