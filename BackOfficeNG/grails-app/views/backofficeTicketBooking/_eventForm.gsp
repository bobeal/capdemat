<form id="event_${entertainmentId}_${event?.id}" class="listItem" method="post" action="${createLink(action:'event')}">
  <input type="hidden" name="eventId" value="${event?.id}" />
  <input type="hidden" name="entertainmentId" value="${entertainmentId}" />

  <h3>${message(code:'event.header.' +(event != null ? 'edit' : 'add'))}</h3>
  <p class="error" id="event_${entertainmentId}_${event?.id}_Errors"></p>

  <p>
    <label class="required">${message(code:'event.property.place')} :</label>
    <input type="text" name="place" value="${event?.place}" class="required" />
  </p>
  <p>
    <label class="required">${message(code:'event.property.date')} :</label>
    <input type="text" name="date" value="<g:formatDate formatName='format.date' date='${event?.date}'/>" 
        id="date_${entertainmentId}_${event?.id}" size="8" class="required validate-date" />
    <img id="date_${entertainmentId}_${event?.id}Show" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}" class="calendar" />
    <span id="date_${entertainmentId}_${event?.id}CalContainer" class="yui-cal yui-calcontainer"></span>
    <input type="text" name="dateHour" value="<g:formatDate format='HH' date='${event?.date}'/>"
        id="dateHour_${entertainmentId}_${event?.id}" size="1" class="validate-hour" />
    <span>${message(code:'event.label.hour')}</span>
    <input type="text" name="dateMinute" value="<g:formatDate format='mm' date='${event?.date}' />"
        id="dateMinute_${entertainmentId}_${event?.id}" size="1" class="validate-minute" />
  </p>
  <p>
    <label class="required">${message(code:'event.property.bookingStart')} :</label>
    <input type="text" name="bookingStart" value="<g:formatDate formatName='format.date' date='${event?.bookingStart}'/>" 
        id="bookingStart_${entertainmentId}_${event?.id}" size="8" class="required validate-date"/>
    <img id="bookingStart_${entertainmentId}_${event?.id}Show" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"  class="calendar" />
    <span id="bookingStart_${entertainmentId}_${event?.id}CalContainer" class="yui-cal yui-calcontainer"></span>
    <input type="text" name="bookingStartHour" value="<g:formatDate format='HH' date='${event?.bookingStart}'/>"
        id="bookingStartHour_${entertainmentId}_${event?.id}" size="1" class="validate-hour" />
    <span>${message(code:'event.label.hour')}</span>
    <input type="text" name="bookingStartMinute" value="<g:formatDate format='mm' date='${event?.bookingStart}' />"
        id="bookingStartMinute_${entertainmentId}_${event?.id}" size="1" class="validate-minute" />
  </p>
  <p>
    <label class="required">${message(code:'event.property.bookingEnd')} :</label>
    <input type="text" name="bookingEnd" value="<g:formatDate formatName='format.date' date='${event?.bookingEnd}'/>"
        id="bookingEnd_${entertainmentId}_${event?.id}" size="8" class="required validate-date"/>
    <img id="bookingEnd_${entertainmentId}_${event?.id}Show" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}" class="calendar" />
    <span id="bookingEnd_${entertainmentId}_${event?.id}CalContainer" class="yui-cal yui-calcontainer"></span>
    <input type="text" name="bookingEndHour" value="<g:formatDate format='HH' date='${event?.bookingEnd}'/>"
        id="bookingEndHour_${entertainmentId}_${event?.id}" size="1" class="validate-hour" />
    <span>${message(code:'event.label.hour')}</span>
    <input type="text" name="bookingEndMinute" value="<g:formatDate format='mm' date='${event?.bookingEnd}' />"
        id="bookingEndMinute_${entertainmentId}_${event?.id}" size="1" class="validate-minute" />
  </p>
  <p>
    <label>${message(code:'event.property.address')} : </label>
    <input type="text" name="address" value="${event?.address}" />
  </p>
  <p>
    <label>${message(code:'event.property.link')} : </label>
    <input type="text" name="link" value="${event?.link}" />
  </p>
  <p class="button">
    <input type="button" id="saveEvent_${entertainmentId}_${event?.id}" value="${message(code:'action.' + (event != null ? 'modify' : 'create'))}" />
    <input type="button" id="discard_${entertainmentId}_${event?.id}" value="${message(code:'action.close')}"/>
  </p>
</form>
