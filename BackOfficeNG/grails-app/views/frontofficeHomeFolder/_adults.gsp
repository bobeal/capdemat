<h2>
  <g:if test="${hfmr.enabled}">
    <a href="${createLink(action : 'adult', params : ['mode' : 'edit'])}" class="action">
      ${message(code:'homeFolder.action.addAdult')}
    </a>
  </g:if>
  <g:message code="homeFolder.property.adults"/>
</h2>
<g:if test="${!adults.isEmpty()}">
  <g:each var="record" in="${adults}">
    <dl>
      <dt>${record.title} ${record.fullName}</dt>
      <g:if test="${record.ownerRoles.homeFolder.size() > 0}">
        <dd>
          <g:each var="ownerRole" in="${record.ownerRoles.homeFolder}"> 
            <g:capdematEnumToFlag var="${ownerRole.role}" i18nKeyPrefix="homeFolder.role" />
          </g:each>
        </dd>
      </g:if>
      <dd>
        <g:if test="${record.birthDate}">
          <g:message code="homeFolder.header.born" />
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
      <g:if test="${record.homePhone}">
        <dd>
          <g:message code="homeFolder.adult.property.homePhone" /> :
          ${record.homePhone}
        </dd>
      </g:if>
      <g:if test="${record.mobilePhone}">
        <dd>
          <g:message code="homeFolder.adult.property.mobilePhone" /> :
          ${record.mobilePhone}
        </dd>
      </g:if>
      <g:if test="${record.email}">
        <dd>${record.email}</dd>
      </g:if>
      
      <dd class="see-details">
        <a href="${createLink(action:'adult',id:record.id)}">
          <g:message code="homeFolder.individual.action.seeDetails" />
        </a>
        <g:if test="${hfmr.enabled}">
          <p><a href="${createLink(action:'adult', params:['id':record.id, 'mode':'edit'])}">${message(code:'action.modify')}</a></p>
        </g:if>
      </dd>
    </dl>
  </g:each>
</g:if>
