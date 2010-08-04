

  <g:set var="listSize" value="${rqt.tbrTicket.size()}" />
  <h3>
    <span><g:message code="tbr.property.tbrTicket.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.tbrTicket.reverse()}" status="index">

  <dl class="required">
    
      <dt class=""><g:message code="tbr.property.eventName.label" />  : </dt>
      <dd id="tbrTicket[${listSize - 1 - index}].eventName" class="validate-string i18n-tbr.property.eventName" >
        <span>${it?.eventName}</span>
      </dd>
    
      <dt class=""><g:message code="tbr.property.eventDate.label" />  : </dt>
      <dd id="tbrTicket[${listSize - 1 - index}].eventDate" class="validate-date i18n-tbr.property.eventDate" >
        <span><g:formatDate formatName="format.date" date="${it?.eventDate}"/></span>
      </dd>
    
      <dt class=""><g:message code="tbr.property.eventPlace.label" />  : </dt>
      <dd id="tbrTicket[${listSize - 1 - index}].eventPlace" class="validate-string i18n-tbr.property.eventPlace" >
        <span>${it?.eventPlace}</span>
      </dd>
    
      <dt class=""><g:message code="tbr.property.placeCategory.label" />  : </dt>
      <dd id="tbrTicket[${listSize - 1 - index}].placeCategory" class="validate-string i18n-tbr.property.placeCategory" >
        <span>${it?.placeCategory}</span>
      </dd>
    
      <dt class="required"><g:message code="tbr.property.placeNumber.label" /> * : </dt>
      <dd id="tbrTicket[${listSize - 1 - index}].placeNumber" class="validate-positiveInteger required-true i18n-tbr.property.placeNumber" >
        <span>${it?.placeNumber}</span>
      </dd>
    
      <dt class=""><g:message code="tbr.property.fareType.label" />  : </dt>
      <dd id="tbrTicket[${listSize - 1 - index}].fareType" class="validate-string i18n-tbr.property.fareType" >
        <span>${it?.fareType}</span>
      </dd>
    
      <dt class="required"><g:message code="tbr.property.price.label" /> * : </dt>
      <dd id="tbrTicket[${listSize - 1 - index}].price" class="validate-decimal required-true i18n-tbr.property.price" >
        <span>${it?.price}</span>
      </dd>
    
  </dl>
  </g:each>
