


  
    <div class="collection required">
    <h3>
      <g:message code="prr.property.placeReservation.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="prr.property.placeReservation.help" /></span>
      <button type="submit" name="submit-collectionAdd-places-placeReservation">
        <a>${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="${rqt.placeReservation}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="prr.property.placeReservation.label" /> (${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-places-placeReservation[${listIndex}]" value="${message(code:'action.remove')}" />
        </legend>
        
      </fieldset>
    </g:each>
    </div>
  

