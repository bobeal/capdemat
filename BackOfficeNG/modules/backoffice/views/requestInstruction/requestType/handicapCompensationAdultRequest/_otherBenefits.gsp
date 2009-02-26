

  <g:set var="listSize" value="${request.otherBenefits.size()}" />
  <h3>
    <a class="addListItem" id="add_otherBenefits[${listSize}]"></a>
    <span><g:message code="hcar.property.otherBenefits.label" /></span>
  </h3>
  <g:each var="it" in="${request.otherBenefits.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_otherBenefits[${listSize - 1 - index}]"></a>
  </div>
  <dl class="condition-isOtherBenefits-filled">
    
      <dt class="required"><g:message code="hcar.property.otherBenefitName.label" /> : </dt>
      <dd id="otherBenefits[${listSize - 1 - index}].otherBenefitName" class="action-editField validate- required-true i18n-hcar.property.otherBenefitName" >
        <span>${it?.otherBenefitName}</span>
      </dd>
    
  </dl>
  </g:each>
