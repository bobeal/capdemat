<g:if test="${children?.size() > 0}">
  <h2><g:message code="homeFolder.property.children"/></h2>
  <g:each var="record" in="${children}">
    <dl>
      <dt>${record.fullName}</dt>
      <dd>
        <g:message code="homeFolder.child.property.sex" /> 
        <g:capdematEnumToText var="${record.sex}" i18nKeyPrefix="homeFolder.child.sex"/>
      </dd>
      <dd>
        <g:message code="homeFolder.header.born" />
        <g:if test="${record.birthDate}">
          <g:message code="homeFolder.header.on" />
          ${formatDate(date:record.birthDate,formatName:'format.date')}
        </g:if>
        <g:if test="${record.birthCity || record.birthPostalCode || record.birthCountry}">
          <g:message code="homeFolder.header.in" />
          ${record.birthCity}
          <g:if test="${record.birthPostalCode}"> (${record.birthPostalCode}) </g:if>
          <g:if test="${record.birthCountry}"> - ${record.birthCountry}</g:if>
        </g:if>
      </dd>
      <g:if test="${record.childSubjectRoles}">
        <dd>
          <g:message code="homeFolder.child.property.legalResponsibles" /> :
          <ul>
            <g:each var="childSubjectRole" in="${record.childSubjectRoles}"> 
              <li>
                ${childSubjectRole.fullName}
                <g:each in="${childSubjectRole.roles}" var="role">
                  <g:capdematEnumToFlag var="${role}" i18nKeyPrefix="homeFolder.role" />
                </g:each>
              </li>
            </g:each>
          </ul>
        </dd>
      </g:if>
      <dd class="see-details">
        <a href="${createLink(action:'individual',id:record.id)}">
          <g:message code="homeFolder.individual.action.seeDetails" />
        </a>
      </dd>
    </dl> 
  </g:each>
</g:if>
