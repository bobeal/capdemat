<g:if test="${documents?.all?.size() > 0}">
  <ul>
    <g:each var="record" in="${documents.all}">
      <li>
        <p>
          <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="document.state" />
          <g:if test="${record.certified}">
            <span class="certified">
              <g:message code="property.certified" />
            </span>
          </g:if>
          <span>
            ${record.title}
            <g:if test="${record?.subject}">
               (${record.subject})
            </g:if> 
          </span>
          <g:if test="${record?.endValidityDate}">
            <g:message code="message.expireOn" />
            <span>
              <g:formatDate value="${record.endValidityDate}" formatName="format.date" />
            </span>
          </g:if>
        </p>
        <p>
          <g:if test="${record?.creationDate || record?.depositor}">
            <span>
              <g:message code="message.created" />
              <g:if test="${record?.creationDate}">
                <g:message code="message.date.on" />
                <g:formatDate value="${record.creationDate}" formatName="format.date" />
              </g:if>
              <g:if test="${record?.depositor}">
                <g:message code="message.by" />
                ${record.depositor?.firstName} ${record.depositor?.lastName}
              </g:if>
            </span>
          </g:if>
          <g:capdematEnumToFlag var="${record.depositType}" i18nKeyPrefix="document.depositType" />
          <g:capdematEnumToFlag var="${record.depositOrigin}" i18nKeyPrefix="document.depositOrigin" />
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
