


  
    <label class="required"><g:message code="prr.property.placeReservation.label" /> <span><g:message code="prr.property.placeReservation.help" /></span></label>
    <div class="collection-fieldset required validation-scope summary-box">
      <g:set var="listIndex" value="${editList?.name == 'placeReservation' ? editList?.index : ( rqt.placeReservation ? rqt.placeReservation.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required">
    
        <g:if test="${editList?.name == 'placeReservation'}">
          <input type="submit" id="submit-collectionModify-places-placeReservation[${listIndex}]" name="submit-collectionModify-places-placeReservation[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-places-placeReservation[${listIndex}]" name="submit-collectionAdd-places-placeReservation[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.placeReservation}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-places-placeReservation[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-places-placeReservation[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

