<h2>
  <g:if test="${hfmr.enabled}">
    <a href="${createLink(action:'child', params:['mode':'edit'])}" class="action">
      ${message(code:'homeFolder.action.addChild')}
    </a>
  </g:if>
  <g:message code="homeFolder.property.children"/>
</h2>
<g:if test="${!children.isEmpty()}">
  <g:each var="record" in="${children}">
    <dl>
      <dt>${record.fullName}</dt>
      <dd>
        <g:message code="homeFolder.child.property.sex" /> 
        <g:capdematEnumToText var="${record.sex}" i18nKeyPrefix="homeFolder.child.property.sex"/>
      </dd>
      <dd>
        <g:if test="${record.born}"><g:message code="homeFolder.header.born" /></g:if>
        <g:else><g:message code="homeFolder.header.noBorn" /></g:else>
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
      <g:if test="${record.roleOwners}">
        <dd>
          <g:message code="homeFolder.child.property.legalResponsibles" /> :
          <ul>
            <g:each var="roleOwner" in="${record.roleOwners}">
              <li>
                ${roleOwner.fullName}
                <g:each in="${roleOwner.getIndividualRoles(record.id)}">
                  <g:capdematEnumToFlag var="${it.role}" i18nKeyPrefix="homeFolder.role" />
                </g:each>
              </li>
            </g:each>
          </ul>
        </dd>
      </g:if>
      <dd class="see-details">
        <a href="${createLink(action:'child',id:record.id)}">
          <g:message code="homeFolder.individual.action.seeDetails" />
        </a>
        <g:if test="${hfmr.enabled}">
          <p><a href="${createLink(action:'child', params:['id':record.id, 'mode':'edit'])}">${message(code:'action.modify')}</a></p>
        </g:if>
      </dd>
    </dl> 
  </g:each>
</g:if>
