<g:if test="${invoices?.all?.size() > 0}">
<div class="list-box">
  <h2><g:message code="${title}" /></h2>
    <g:if test="${paginate}">
      <p class="paginator">
        <g:paginate action="history" total="${invoices.count}" max="${maxRows}" next="&gt;" prev="&lt;" params="${['ps':pageState]}"  />
      </p>
    </g:if>
    <ul>
      <g:each var="record" in="${invoices.all}">
        <li>
            <g:if test="${record.isPaid}">
                <g:capdematEnumToFlag var="paid" i18nKeyPrefix="payment.invoice.state" />
            </g:if>
            <h3>
              <g:message code="payment.header.invoice" />
              <g:if test="${record.externalItemId}">
                ${record.externalItemId}
              </g:if>
              <g:message code="payment.searchResult.amount" /> 
              <span><g:formatNumber number="${record.amount / 100}" formatName="format.currency"/></span>
            </h3>
            <p>
              <g:message code="payment.searchResult.initializationDate" /> 
              <g:formatDate date="${record.issueDate}" formatName="format.fullDate"/>
              - <span><g:message code="payment.searchResult.externalServiceLabel" /> : ${record.externalServiceLabel}</span>
            </p>
        </li>
      </g:each>
    </ul>
    <g:if test="${paginate}">
      <p class="paginator">
        <g:paginate action="history" total="${invoices.count}" max="${maxRows}" next="&gt;" prev="&lt;" params="${['ps':pageState]}"  />
      </p>
    </g:if>
</div>
</g:if>
<g:else>
  <div class="information-box">
    <g:message code="${noInvoicesMsg}" />
  </div>
</g:else>
