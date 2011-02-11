<dl>
  <dt>${message(code:'property.creationDate')} : </dt>
  <dd><g:formatDate formatName="format.date" date="${adult.creationDate}"/></dd>
  <dt>${message(code:'property.state')} : </dt>
  <dd><g:capdematEnumToFlag var="${adult.state}" i18nKeyPrefix="user.state" /></dd>
  <g:if test="${!ownerRoles.homeFolder.isEmpty()}">
    <dt>${message(code:'homeFolder.adult.property.homeFolderRoles')} : </dt>
    <dd>
      <g:each var="ownerRole" in="${ownerRoles.homeFolder}">
        <g:capdematEnumToFlag var="${ownerRole.role}" i18nKeyPrefix="homeFolder.role" />
      </g:each>
    </dd>
  </g:if>
  <g:if test="${!ownerRoles.individual.isEmpty()}">
    <dt>${message(code:'homeFolder.adult.property.individualRoles')} : </dt>
    <dd>
      <g:each var="ownerRole" in="${ownerRoles.individual}">
        <p>
          <g:capdematEnumToFlag var="${ownerRole.role}" i18nKeyPrefix="homeFolder.role" />
          ${ownerRole.subjectName}
        </p>
      </g:each>
    </dd>
  </g:if>
</dl>

<dl>
  <dt>${message(code:'homeFolder.adult.property.login')} : </dt><dd>${adult.login}</dd>
  <dt>${message(code:'homeFolder.adult.property.question')} : </dt><dd>${adult.question}</dd>
  <dt>${message(code:'homeFolder.adult.property.answer')} : </dt><dd>${adult.answer}</dd>
</dl>
