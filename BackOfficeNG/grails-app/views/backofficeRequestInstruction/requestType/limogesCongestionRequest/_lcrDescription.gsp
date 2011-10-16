

  <g:set var="listSize" value="${rqt.lcrDescription.size()}" />
  <h3>
    <a class="addListItem" id="add_lcrDescription[${listSize}]"></a>
    <span><g:message code="lcr.property.lcrDescription.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.lcrDescription.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_lcrDescription[${listSize - 1 - index}]"></a>
  </div>
  <dl class="required">
    
      <dt class="required"><g:message code="lcr.property.lcrDetailDescription.label" /> * : </dt>
      <dd id="lcrDescription[${listSize - 1 - index}].lcrDetailDescription" class="action-editField validate-capdematEnum required-true i18n-lcr.property.lcrDetailDescription javatype-fr.cg95.cvq.business.request.urbanism.LcrDetailDescriptionType" >
        <g:capdematEnumToField var="${it?.lcrDetailDescription}" i18nKeyPrefix="lcr.property.lcrDetailDescription" />
      </dd>
    
      <dt class="required"><g:message code="lcr.property.lcrDetailLength.label" /> * : </dt>
      <dd id="lcrDescription[${listSize - 1 - index}].lcrDetailLength" class="action-editField validate-string required-true i18n-lcr.property.lcrDetailLength" >
        <span>${it?.lcrDetailLength}</span>
      </dd>
    
      <dt class="required"><g:message code="lcr.property.lcrDetailWidth.label" /> * : </dt>
      <dd id="lcrDescription[${listSize - 1 - index}].lcrDetailWidth" class="action-editField validate-string required-true i18n-lcr.property.lcrDetailWidth" >
        <span>${it?.lcrDetailWidth}</span>
      </dd>
    
      <dt class=""><g:message code="lcr.property.lcrDetailHeight.label" />  : </dt>
      <dd id="lcrDescription[${listSize - 1 - index}].lcrDetailHeight" class="action-editField validate-string i18n-lcr.property.lcrDetailHeight" >
        <span>${it?.lcrDetailHeight}</span>
      </dd>
    
      <dt class=""><g:message code="lcr.property.lcrDetailOther.label" />  : </dt>
      <dd id="lcrDescription[${listSize - 1 - index}].lcrDetailOther" class="action-editField validate-string i18n-lcr.property.lcrDetailOther" >
        <span>${it?.lcrDetailOther}</span>
      </dd>
    
  </dl>
  </g:each>
