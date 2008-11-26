<li>
  <span class="first-line">
    <g:message code="layout.from" />
    <strong>${record.requesterLastName}</strong>
    (<g:message code="payment.searchResult.homeFolderId" />
    &nbsp;<strong>${record.homeFolderId}</strong>) 
    <g:message code="layout.theMale" /> ${record.initializationDate}
  </span>
  <br/>
  <g:if test="${record.bankReference}">
    <span class="second-line">
      <g:message code="payment.property.bankReference" /> : <b>${record.bankReference}</b> 
      <g:message code="payment.searchResult.commitDate" /> ${record.commitDate} -
       <span class="state">${record.paymentState}</span>
    </span>
    <br/>
  </g:if>
  <span class="third-line">
    <g:message code="payment.property.amount" /> <b>${record.amount}</b> <g:message code="payment.searchResult.paidBy" /> ${record.paymentMode}
    <g:if test="${record.broker}">
      <g:message code="layout.on" />
      <g:message code="layout.theFemale" />
      <g:message code="payment.property.broker" /> <i>${record.broker}</i>
    </g:if>
  </span>
</li>

