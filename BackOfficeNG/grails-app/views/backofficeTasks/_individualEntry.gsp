<li>
  <a href="${createLink(controller:'backofficeHomeFolder', action:'details', id:record.homeFolder.id)}">
    <strong>
      ${record.lastName} ${record.firstName}
    </strong>
  </a>
  -
  <strong>
    <g:if test="${record.state == fr.cg95.cvq.business.users.UserState.NEW}">
      <g:message code="tasks.individual.created" />
    </g:if>
    <g:if test="${record.state == fr.cg95.cvq.business.users.UserState.MODIFIED}">
      <g:message code="tasks.individual.modified" />
    </g:if>
    <g:if test="${record.state == fr.cg95.cvq.business.users.UserState.INVALID}">
      <g:message code="tasks.individual.invalid" />
    </g:if>
  </strong>
  <g:message code="tasks.individual.onHomeFolder" /> <strong>${record.homeFolder.id}</strong>
  - <g:message code="tasks.individual.onDate" /><strong>
  <g:formatDate formatName="format.fullDate" date="${record.lastModificationDate}"/></strong>
</li>
