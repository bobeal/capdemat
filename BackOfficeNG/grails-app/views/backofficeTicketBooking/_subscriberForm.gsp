<form id="subscriber_${subscriber?.id}" class="listItem" method="post" action="${createLink(action:'subscriber')}" >
  <g:if test="${subscriber?.id == null}">
    <h3>${message(code:'subscriber.header.add')}</h3>
  </g:if>
  <p class="error" id="subscriber_${subscriber?.id}_Errors"></p>
  <input type="hidden" name="id" value="${subscriber?.id}" />
  <p>
    <label for="firstName" class="required">${message(code:'subscriber.property.firstName')} : *</label>
    <input type="text" value="${subscriber?.firstName}" name="firstName" class="required" />
  </p>
  <p>
    <label for="lastName" class="required">${message(code:'subscriber.property.lastName')} : *</label>
    <input type="text" value="${subscriber?.lastName}" name="lastName" class="required" />
  </p>
  <p>
    <label for="number" class="required">${message(code:'subscriber.property.number')} : *</label>
    <input type="text" value="${subscriber?.number}" name="number" ${subscriber.id != null ? 'readonly="readonly"' : ''} class="required" />
  </p>
  <p>
    <label for="fullFareLimit"><em style="background:#fcf;">${message(code:'subscriber.property.fullFareLimit')}</em> : </label>
    <input type="text" value="${subscriber.limitByString('Plein')}" name="fullFareLimit" class="validate-number" />
  </p>
  <p>
    <label for="reduceFareLimit"><em style="background:#ffc;">${message(code:'subscriber.property.reduceFareLimit')}</em> : </label>
    <input type="text" value="${subscriber.limitByString('Reduit')}" name="reduceFareLimit" class="validate-number" />
  </p>
  <p class="button">
    <input type="button" id="saveSubscriber_${subscriber?.id}" value="${message(code:'action.' + (subscriber?.id != null ? 'save' : 'create'))}" />
    <input type="button" id="discard_${subscriber?.id}" value="${message(code:'action.close')}"/>
  </p>
</form>

