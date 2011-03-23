<form id="fares_${event.id}" class="fares listItem" method="post" action="${createLink(action:'entertainment')}" class="editable-list-form">
  <div class="error" id="fares_${event.id}_Errors"></div>
  <input type="hidden" name="eventId" value="${event.id}" class="invisible" />
  <p style="text-align:right;">
    <a id="addPlaceCategory_${event.id}" class="createSubItem"></a>
    <select id="placeCategoryName_${event.id}">
      <option>${message(code:'placeCategory.action.add')}</option>
      <g:each var="lre" in="${lrTypes.placeCategories?.entries}">
      <option value="${lre.label}" ${lre.label == '' ? 'selected="selected"' : ''}>
        ${lre.label}  
      </option>
      </g:each>
    </select>
    
  </p>
  
  <script type="text/html" id="fareEditTmpl">
    <select id="name_<!=id!>">
    <g:each var="lre" in="${lrTypes.rateTypes?.entries}">
    <option value="${lre.label}" <!= '${lre.label}' == name ? 'selected="selected"' : '' !>>
      ${lre.label}  
    </option>
    </g:each>
    </select>
    <select id="withSubscribtion_<!=id!>">
      <option value="false" <!= withSubscribtion === "true" ? 'selected="selected"': '' !>>${message(code:'fare.label.noSubscriber')}</option>
      <option value="true" <!= withSubscribtion === "true" ? 'selected="selected"' : '' !>>${message(code:'fare.label.subscriber')}</option>
    </select>
    <input type="text" id="price_<!=id!>" size="3" value="<!=price!>" /> &euro;
    <a id="cancelEditFare_<!=id!>" class="cancelEditItem"></a>
    <a id="saveFare_<!=id!>" class="modifyItem"></a>
  </script>
  <script type="text/html" id="fareStaticTmpl">
    <em>
      <span id="name_<!=id!>"><!=name!></span>
      <! if (withSubscribtion === "true") { !>
      <span class="tag subscriber">${message(code:'fare.label.subscriber')}</span>
      <! } !>
    </em>
    <span id="withSubscribtion_<!=id!>" class="invisible"><!=withSubscribtion!></span>
    <strong><span id="price_<!=id!>"><!=price!></span> &euro;</strong>
    <a id="deleteFare_<!=id!>" class="deleteItem"></a>
    <a id="editFare_<!=id!>" class="editItem"></a>
  </script>

  <g:each var="placeCategory" in="${event.placeCategories}">
    <div id="placeCategory_${placeCategory.id}">
      <h3>
        <a id="deletePlaceCategory_${placeCategory.id}" class="deleteItem"></a>
        ${message(code:'placeCategory.header')} : ${placeCategory.name}
      </h3>
      <p style="text-align:right;">
        <a id="savePlaceCategory_${placeCategory.id}"" class="modifyItem"></a>
        <span for="placeNumber" class="required">${message(code:'placeCategory.property.placeNumber')} : *</span>
        <input id="placeNumber_${placeCategory.id}" type="text" name="placeNumber" value="${placeCategory.placeNumber}" size="4" class="required" />
      </p>
      <dl>
        <dt>${message(code:'fare.header')} <a id="addFare_${placeCategory.id}" class="createSubItem text">${message(code:'fare.action.add')}</a></dt>
        <g:each var="fare" in="${placeCategory.fares}">
        <dd>
          <em>
            <span id="name_${fare.id}">${fare.name}</span>
            <g:if test="${fare.withSubscribtion == true}">
              <span class="tag subscriber">${message(code:'fare.label.subscriber')}</span>
            </g:if>
          </em>
          <span id="withSubscribtion_${fare.id}" class="invisible">${fare.withSubscribtion}</span>
          <strong><span id="price_${fare.id}">${fare.price}</span> &euro;</strong> 
          <a id="deleteFare_${fare.id}" class="deleteItem"></a>
          <a id="editFare_${fare.id}" class="editItem"></a>
        </dd>
        </g:each>
      </dl>
    </div>
  </g:each>
  
  <p class="button">
    <input type="button" id="discard_${event.id}" value="${message(code:'action.close')}" />
  </p>

</form>
