<g:if test="${documents.count > 0}">
  <ul>
    <g:each var="record" in="${documents.all}">
      <li>
        <p>
          <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="document.state" />
          <a href="${createLink(action:'details',id:record.id)}">
            ${record.title}
          </a>
          <g:if test="${record.subject}">
            <g:message code="document.searchResult.subject" args="${[record.subject]}"/>
          </g:if>
          - <g:message code="document.searchResult.creationDate" 
              args="${[formatDate(date:record.creationDate,formatName:'format.date')]}" /> 
          <g:if test="${record.depositor}">
            <g:message code="message.by" />
            ${record.depositor.firstName} ${record.depositor.lastName}
          </g:if>
          <g:if test="${record.endValidityDate}">
            - <g:message code="document.searchResult.endValidityDate" 
                args="${[formatDate(date:record.endValidityDate,formatName:'format.date')]}" /> 
          </g:if>
          <g:if test="${record.certified}">
            <span class="certified">
              <g:message code="document.property.certified" />
            </span>
          </g:if>
        </p>
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <strong>
    <g:message code="message.noDocuments" />
  </strong>
</g:else>
