<h2><g:message code="homeFolder.header.generalInformations"/></h2>
<div class="homFolderInfo">
  <p>
    ${message(code:'property.active')} :
    <g:if test="${homeFolder.info.enabled}"><span class="tag-valid"><g:message code="message.yes" /></span></g:if>
    <g:else><span class="tag-invalid"><g:message code="message.no" /></span></g:else>
  </p>
  <p>${message(code:'property.state')} : <g:capdematEnumToFlag var="${homeFolder.info.state}" i18nKeyPrefix="user.state" /></p>
  <p>${message(code:'property.address')} : <strong>${homeFolder.info.addressDetails}</strong></p>
  <p>        
    <a href="${createLink(controller:'backofficeHomeFolder', action:'details', id:homeFolder.info.id)}">
      ${message(code:'homeFolder.individual.action.seeDetails')}
    </a>
  </p>
</div>

<div class="yui-g">
  <div class="yui-u first">            
    <g:if test="${!homeFolder.adults.isEmpty()}">
      <h2>${message(code:'homeFolder.property.adults')}</h2>
      <g:each var="record" in="${homeFolder.adults}">
        <dl class="account">
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
              ${message(code:'homeFolder.header.born')}
              ${message(code:'homeFolder.header.on')}
              ${formatDate(date:record.birthDate,formatName:'format.date')}
            </g:if>
            <g:if test="${record.birthCity || record.birthPostalCode || record.birthCountry}">
              ${message(code:'homeFolder.header.in')} 
              ${record.birthCity}
              <g:if test="${record.birthPostalCode}"> (${record.birthPostalCode}) </g:if>
              <g:if test="${record.birthCountry}"> - ${record.birthCountry}</g:if>
            </g:if>
          </dd>
          <g:if test="${record.homePhone}">
            <dd>${message(code:'homeFolder.adult.property.homePhone')} : ${record.homePhone}</dd>
          </g:if>
          <g:if test="${record.mobilePhone}">
            <dd>${message(code:'homeFolder.adult.property.mobilePhone')} : ${record.mobilePhone}</dd>
          </g:if>
          <g:if test="${record.email}">
            <dd>${record.email}</dd>
          </g:if>
        </dl>
      </g:each>
    </g:if>
  </div>
  <div class="yui-u">
    <g:if test="${!homeFolder.children.isEmpty()}">
      <h2>${message(code:'homeFolder.property.children')}</h2>
      <g:each var="record" in="${homeFolder.children}">
        <dl class="account">
          <dt>${record.fullName}</dt>
          <dd>
            ${message(code:'homeFolder.child.property.sex')} 
            <g:capdematEnumToText var="${record.sex}" i18nKeyPrefix="homeFolder.child.property.sex"/>
          </dd>
          <dd>
            ${message(code:'homeFolder.header.born')}
            <g:if test="${record.birthDate}">
              ${message(code:'homeFolder.header.on')} 
              ${formatDate(date:record.birthDate,formatName:'format.date')}
            </g:if>
            <g:if test="${record.birthCity || record.birthPostalCode || record.birthCountry}">
              ${message(code:'homeFolder.header.in')}
              ${record.birthCity}
              <g:if test="${record.birthPostalCode}"> (${record.birthPostalCode}) </g:if>
              <g:if test="${record.birthCountry}"> - ${record.birthCountry}</g:if>
            </g:if>
          </dd>
          <g:if test="${record.roleOwners}">
            <dd>
              <strong>${message(code:'homeFolder.child.property.legalResponsibles')}</strong> :
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
        </dl>
      </g:each>
    </g:if>
  </div>
</div>


