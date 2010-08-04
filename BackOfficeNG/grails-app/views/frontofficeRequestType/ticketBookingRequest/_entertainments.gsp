<style>
#entertainments .narrow-box h4 {
  margin: 0; padding: .7em .5em;
  font-size: 1.1em;
  -moz-border-radius: .5em .5em 0 0;
  color: #fff; background: #FF812B
}
#entertainments .narrow-box h4 .cartInfo { display: block; font-size:.85em; font-style: italic; }

#entertainments .narrow-box .body       { padding: .2em; background: #eee; }
#entertainments .narrow-box .body input,
#entertainments .narrow-box .body select { width:auto; display: inline; margin: .5em .1em; }

#entertainments .narrow-box ul        { width: 100%; }
#entertainments .narrow-box ul li     { padding: .4em; }
#entertainments .narrow-box ul strong { font-size: 1.1em; float:right; }

#entertainments .narrow-box li .cartDetail       { display: none; font-style: italic; font-size: .9em; color: #444; }
#entertainments .narrow-box li:hover .cartDetail { display: block; }

#entertainments button       { border: 0; background: transparent; }
#entertainments button:hover { cursor: pointer; text-decoration: none; }

#entertainments dl dt        { width: 25%; }
#entertainments dl dd        { width: 67%; }
#entertainments dl dd p      { margin: 0 0 .2em; font-size:.9em; }
#entertainments dl dd button { float: right; color: #00f; text-decoration: underline; }

#entertainments dl dd ul { width: 100%; text-align: right; background: #fff; }
#entertainments dl dd li { padding: .4em .1em; border-bottom: 1px dashed #bbb; }
#entertainments dl dd li button { float: none; }
#entertainments dl dd li input {
  display: inline !important; 
  width: auto !important; 
  font-size: 1em !important;
  border: 1px solid #bbb !important; 
  margin: 0 !important; padding: 0 !important;
}
#entertainments dl dd li input.hidden { display: none !important; } 
#entertainments dl dd li .error { text-align: right; } 

#entertainments dl dd h5 { font-size: 1.1em; }
#entertainments dl dd h6 { font-size: .9em; font-weight: bold; }

#entertainments dl dd em { font-style: italic; }

.confirmation      { padding: 1em; background:#fee; border: 2px solid #f55; }
.confirmation .msg { font-size: 1.2em; font-weight: bold; color: #f55; }
</style>

<g:if test="${!flash?.tbrAskUpdateSubscriberMode}">
  <g:if test="${flash?.tbrErrorSubscriber}">
    <p class="error" style="text-align:left">${flash.tbrMessageError}</p>
  </g:if>
  <label class="required"><g:message code="tbr.property.isSubscriber.label" /> *  <span><g:message code="tbr.property.isSubscriber.help" /></span></label>
  <ul class="yes-no required">
  <g:each in="${[true,false]}">
    <li>
      <input type="radio" id="isSubscriber_${it ? 'yes' : 'no'}" class="required condition-hasSubscriberNumber-trigger  validate-one-required boolean" title="" value="${it}" name="isSubscriber" ${it == rqt.isSubscriber ? 'checked="checked"': ''} />
      <label for="isSubscriber_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
    </li>
  </g:each>
  </ul>

  <label for="subscriberNumber" class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberNumber.label" />   <span><g:message code="tbr.property.subscriberNumber.help" /></span></label>
  <input type="text" id="subscriberNumber" name="subscriberNumber" value="${rqt.subscriberNumber?.toString()}" 
  class="required condition-hasSubscriberNumber-filled  validate-token" title="<g:message code="tbr.property.subscriberNumber.validationError" />"   />
    
  <label for="subscriberFirstName" class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberFirstName.label" /> *  <span><g:message code="tbr.property.subscriberFirstName.help" /></span></label>
  <input type="text" id="subscriberFirstName" name="subscriberFirstName" value="${rqt.subscriberFirstName?.toString()}" 
  class="required condition-hasSubscriberNumber-filled  validate-string" title="<g:message code="tbr.property.subscriberFirstName.validationError" />"   />

  <label for="subscriberLastName" class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberLastName.label" /> *  <span><g:message code="tbr.property.subscriberLastName.help" /></span></label>
  <input type="text" id="subscriberLastName" name="subscriberLastName" value="${rqt.subscriberLastName?.toString()}" 
  class="required condition-hasSubscriberNumber-filled  validate-string" title="<g:message code="tbr.property.subscriberLastName.validationError" />"   />

  <input type="submit" name="submit-tbrAskUpdateSubscriberMode-entertainments" value="${message(code:'action.' + (rqt.subscriberNumber ? 'modify' : 'save'))}" />
</g:if>
<g:else>
<div class="confirmation">
  <label class="required"><g:message code="tbr.property.isSubscriber.label" /> *  <span><g:message code="tbr.property.isSubscriber.help" /></span></label>
  <ul class="yes-no required">
  <g:each in="${[true,false]}">
    <li>
      <input type="radio" id="isSubscriber_${it ? 'yes' : 'no'}" class="required condition-hasSubscriberNumber-trigger  validate-one-required boolean" title="" value="${it}" name="isSubscriber" ${it == flash?.isSubscriber ? 'checked="checked"': ''} />
      <label for="isSubscriber_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
    </li>
  </g:each>
  </ul>

  <label for="subscriberNumber" class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberNumber.label" />   <span><g:message code="tbr.property.subscriberNumber.help" /></span></label>
  <input type="text" id="subscriberNumber" name="subscriberNumber" value="${flash?.subscriberNumber?.toString()}" 
  class="required condition-hasSubscriberNumber-filled  validate-token" title="<g:message code="tbr.property.subscriberNumber.validationError" />"   />
    
  <label for="subscriberFirstName" class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberFirstName.label" /> *  <span><g:message code="tbr.property.subcriberFirstName.help" /></span></label>
  <input type="text" id="subscriberFirstName" name="subscriberFirstName" value="${flash?.subscriberFirstName?.toString()}" 
  class="required condition-hasSubscriberNumber-filled  validate-string" title="<g:message code="tbr.property.subscriberFirstName.validationError" />"   />

  <label for="subscriberLastName" class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberLastName.label" /> *  <span><g:message code="tbr.property.subcriberLastName.help" /></span></label>
  <input type="text" id="subscriberLastName" name="subscriberLastName" value="${flash?.subscriberLastName?.toString()}" 
  class="required condition-hasSubscriberNumber-filled  validate-string" title="<g:message code="tbr.property.subscriberLastName.validationError" />"   />
  
  <p class="msg">${message(code:'tbr.message.confirmUpdateSubscriberMode')}</p>
  <input type="submit" name="submit-tbrCancelSubscriberMode-entertainments" value="${message(code:'action.cancel')}" />
  <input type="submit" name="submit-tbrUpdateSubscriberMode-entertainments" value="${message(code:'action.confirm')}" />

</div>
</g:else>

<h3>
  ${message(code:'tbr.header.nextEvents')}
  <g:if test="${rqt.subscriberNumber}">
    <span> ${message(code:'tbr.label.subscribtion')} : ${rqt.subscriberFirstName?.toString()} ${rqt.subscriberLastName?.toString()}</span>
  </g:if>
</h3>

<div id="entertainments">    
  <div id="yui-main"> 
    <div id="main" class="yui-b summary-box">
    
      <g:if test="${session[uuidString].ticketBooking.startsIndex > 0}">
        <input type="submit" name="submit-tbrDisplayPrevious-entertainments" value="${message(code:'tbr.action.displayPrevious')}" style="width:100%;">
      </g:if>

      <dl>
      <g:each var="event" in="${ticketEvents}">
        <dt>
          <img src="${createLink('action':'entertainmentLogo', 'id':event.entertainment.id).encodeAsXML()}" alt="" />
        </dt>
        <dd>
          <button name="submit-tbrBook-entertainments-${event.id}" type="submit">${message(code:'tbr.action.book')}</button>
          <h5>${event.entertainment.name}</h5>
          <p>
            ${event.entertainment.category}
            <g:if test="${event.entertainment.link != null && !event.entertainment.link.isEmpty()}">
            / <a href="${event.entertainment.link}" target="blank">${event.entertainment.link}</a>
            </g:if>
          </p>
          <p><strong><g:formatDate formatName='format.fullDate' date='${event.date}'/></strong></p>
          <p>
            <strong>${event.place}</strong>
            <g:if test="${event.address != null && !event.address.isEmpty()}"> : ${event.address}</g:if>
            <g:if test="${event.link != null && !event.link.isEmpty()}">
              (<a href="${event.link}" target="blank">${event.link}</a>)
            </g:if>
          </p>
          <g:if test="${event.entertainment.information != null && !event.entertainment.information.isEmpty()}">
            <p><em>${event.entertainment.information}</em></p>
          </g:if>
          <g:if test="${event.id == session[uuidString].ticketBooking.selectedEventId}">
            <g:each var="category" in="${event.placeCategories}">
            <h6>
              Cat. ${category.name}  
              <em>${message(code:'tbr.message.availablePlaceNumber', args:[category.placeNumber - category.bookedPlaceNumber])}</em> :
            </h6>
            <ul>
              <g:each var="fare" in="${category.fares}">
              <g:if test="${fare.withSubscribtion == rqt.isSubscriber}">
                <li>
                  <g:if test="${fare.id == flash?.tbrErrorFareId}">
                    <p class="error">${flash.tbrMessageError}</p>
                  </g:if>
                  ${fare.name}
                  <strong>${fare.price} €</strong>
                  <input type="text" name="placeNumber_${fare.id}" value="" size="1" />
                  <button name="submit-tbrBookPlaces-entertainments-fareId:${fare.id}_placeCategoryId:${category.id}_eventId:${event.id}" type="submit">
                    <img src="${createLinkTo(dir:'images/icons',file:'16-add.png')}" />
                  </button>
                </li>
              </g:if>
              </g:each>
            </ul>
            </g:each>
          </g:if>
        </dd>
      </g:each>
      </dl>
      
      <g:if test="${session[uuidString].ticketBooking.startsIndex + session[uuidString].ticketBooking.recordsReturns < session[uuidString].ticketBooking.ticketEventsSize -1}">
        <input type="submit" name="submit-tbrDisplayNext-entertainments" value="${message(code:'tbr.action.displayNext')}" style="width:100%;">
      </g:if>

    </div> 
  </div> 

  <div id="narrow" class="yui-b">
    <div class="narrow-box">
      <h4>${message(code:'header.filterBy')}</h4>
      <div class="body">
        <select name="sortBy">
          <option value="name" ${session[uuidString].ticketBooking.sortBy == 'name' ? 'selected="selected"' : ''}>nom</option>
          <option value="date" ${session[uuidString].ticketBooking.sortBy == 'date' ? 'selected="selected"' : ''}>date</option>
        </select>
        <input type="submit" name="submit-tbrSortBy-entertainments" value="${message(code:'tbr.action.sortBy')}"/>
      </div>
    </div>
    <div class="narrow-box">
      <h4>
        ${message(code:'tbr.header.cart')}
        <span class="cartInfo">
          (${message(code:'tbr.label.maxCartSize', args:[maxCartSize])})
        </span>
      </h4>
      <div class="body">
        <g:if test="${rqt.tbrTicket}">
          <ul>
          <g:each var="ticket" in="${rqt.tbrTicket}" status="index">
            <li>
              <button name="submit-tbrFreePlaces-entertainments-${index}" type="submit">
                <img src="${createLinkTo(dir:'images/icons',file:'16-delete.png')}" />
              </button>
              <strong><g:formatNumber number="${ticket.price}" type="number" format="#####.##" /> €</strong>
              ${ticket.eventName}
              <span class="cartDetail">
                ${ticket.placeNumber} tickets (${ticket.placeCategory}) 
                <g:formatDate formatName='format.fullDate' date='${ticket.eventDate}'/>
              </span>
            </li>
          </g:each>
          </ul>
        </g:if>
        <p style="margin-top: 1em; text-align: right">
        <g:if test="${rqt.totalPrice != null && rqt.totalPrice > 0}">
          ${message(code:'tbr.label.total')} :
          <strong><g:formatNumber number="${rqt?.totalPrice}" type="number" format="#####.##" /> €</strong>
        </g:if>
        <g:else>
          <em>${message(code:'tbr.message.cartIsEmpty')}</em>
        </g:else>
        </p>
      </div>
    </div>
  </div><!-- end of narrow -->
</div>

<br style="clear:both;" />

