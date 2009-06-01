<g:if test="${payments?.all?.size() > 0}">
<div class="list-box">
  <h2><g:message code="payment.header.paymentsHistory" /></h2>
    <p class="paginator">
      <g:paginate action="history" total="${payments.count}" max="${maxRows}" next="&gt;" prev="&lt;" params="${['ps':pageState]}"  />
    </p>
    <ul>
      <g:each var="record" in="${payments.all}">
        <li>
            <g:capdematEnumToFlag var="${record.state}" i18nKeyPrefix="payment.state" />
            <p>
              <g:message code="payment.property.payment" /> 
              <g:if test="${record.bankReference}">
                ${record.bankReference}
              </g:if>
              <g:message code="payment.searchResult.amount" /> 
              <span><g:formatNumber number="${record.amount / 100}" formatName="format.currency"/></span>
              - <g:message code="payment.searchResult.paidBy" />
              <span>${record.paymentMode}</span>
            </p>
            <p>
              <g:message code="payment.searchResult.initializationDate" /> 
              <g:formatDate date="${record.initializationDate}" formatName="format.fullDate"/>
            </p>
        </li>
      </g:each>
    </ul>
    <p class="paginator">
      <g:paginate action="history" total="${payments.count}" max="${maxRows}" next="&gt;" prev="&lt;" params="${['ps':pageState]}"  />
    </p>
</div>
</g:if>
<g:else>
  <div class="information-box">
  	<g:message code="payment.message.noPayments" />
  </div>
</g:else>
