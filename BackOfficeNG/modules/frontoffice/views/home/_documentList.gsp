<div class="list-box">
  <h2><g:message code="document.header.endValidityDateDocuments" /></h2>
  <g:if test="${dashBoard.documents?.records.size() > 0}">
    <ul>
      <g:each var="record" in="${dashBoard.documents.records}">
        <li>
            <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="document.state" />
            ${record.title},
            <g:if test="${record.creationDate != ''}">
              <g:message code="document.property.creationDate" /> : 
              <span>${record.creationDate},</span>
            </g:if>
            <g:if test="${record.validationDate != ''}">
              <g:message code="document.property.validationDate" /> : 
              <span>${record.validationDate},</span>
            </g:if>
            <g:if test="${record.endValidityDate != ''}">
              <g:message code="document.property.endValidityDate" /> : 
              <span>${record.endValidityDate}</span>
            </g:if>
        </li>
      </g:each>
    </ul>
    <p class="see-all">
      <a href="${createLink(controller:'frontofficeDocument')}" id="showAllDocuments">
        <g:message code="action.seeAll" />
      </a>
    </p>
  </g:if>
  <g:else>
    <strong>
      <g:message code="message.noDocuments" />
    </strong>
  </g:else>
</div>
