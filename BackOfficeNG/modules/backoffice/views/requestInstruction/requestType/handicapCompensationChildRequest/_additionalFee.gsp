

  <g:set var="listSize" value="${request.additionalFee.size()}" />
  <h3>
    <a class="addListItem" id="add_additionalFee[${listSize}]"></a>
    <span><g:message code="hccr.property.additionalFee.label" /></span>
  </h3>
  <g:each var="it" in="${request.additionalFee.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_additionalFee[${listSize - 1 - index}]"></a>
  </div>
  <dl class="">
    
      <dt class="required"><g:message code="hccr.property.additionalFeeKind.label" /> * : </dt>
      <dd id="additionalFee[${listSize - 1 - index}].additionalFeeKind" class="action-editField validate- required-true i18n-hccr.property.additionalFeeKind maxLength-30" >
        <span>${it?.additionalFeeKind}</span>
      </dd>
    
      <dt class="required"><g:message code="hccr.property.additionalFeeCost.label" /> * : </dt>
      <dd id="additionalFee[${listSize - 1 - index}].additionalFeeCost" class="action-editField validate- required-true i18n-hccr.property.additionalFeeCost" >
        <span>${it?.additionalFeeCost}</span>
      </dd>
    
      <dt class="required"><g:message code="hccr.property.additionalFeePeriodicity.label" /> * : </dt>
      <dd id="additionalFee[${listSize - 1 - index}].additionalFeePeriodicity" class="action-editField validate- required-true i18n-hccr.property.additionalFeePeriodicity maxLength-30" >
        <span>${it?.additionalFeePeriodicity}</span>
      </dd>
    
  </dl>
  </g:each>
