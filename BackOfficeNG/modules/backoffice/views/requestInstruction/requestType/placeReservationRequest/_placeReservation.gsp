

  <g:set var="listSize" value="${rqt.placeReservation.size()}" />
  <h3>
    <a class="addListItem" id="add_placeReservation[${listSize}]"></a>
    <span><g:message code="prr.property.placeReservation.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.placeReservation.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_placeReservation[${listSize - 1 - index}]"></a>
  </div>
  <dl class="required">
    
  </dl>
  </g:each>
