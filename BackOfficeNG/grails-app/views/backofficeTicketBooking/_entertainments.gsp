  <h2>${message(code:'entertainment.header.referential')}</h2>
  <div class="createConfigurationItem">
    <a id="editEntertainment">${message(code:'entertainment.header.add')}</a>
  </div>
  <div class="editableListSwithcher" style="margin-right: 2em; padding-right: 0;">
    <a id="expandEntries_entertainments" class="current">${message(code:'action.expand')}</a>/
    <a id="collapseEntries_entertainments" class="">${message(code:'action.collapse')}</a>
  </div>
  <div id="formContainer_entertainment_" class="newItem"></div>
  <ul id="entertainments" class="editableTree">
    <g:each var="entertainment" in="${entertainments}">
    <li>
      <strong>${entertainment.name}</strong>
      <a id="editEntertainment_${entertainment.id}" class="editItem"> <span>${message(code:'action.modify')}</span></a>
      <a id="confirmRemoveEntertainment_${entertainment.id}" class="deleteItem"><span>${message(code:'action.remove')}</span></a>
      <a id="editEvent_${entertainment.id}_" class="createSubItem text">${message(code:'event.action.add')}</a>
      <div id="formContainer_entertainment_${entertainment.id}" class="editItem mainbox"></div>
      <div id="formContainer_event_${entertainment.id}_" class="editItem mainbox"></div>
      <g:if test="${entertainment.events.size() > 0}">
      <ul class="editableTree">
        <g:each var="event" in="${entertainment.events.sort{it.id}}" status="index">
          <li>
            <strong><g:formatDate formatName='format.fullDate' date='${event.date}'/> (${event.place})</strong>
            <a id="editEvent_${entertainment.id}_${event.id}" class="editItem"> <span>${message(code:'action.modify')}</span></a>
            <a id="editFares_${event.id}" class="editFares"> <span>${message(code:'fare.action.edit')}</span></a>
            <a id="confirmRemoveEvent_${event.id}" class="deleteItem"><span>${message(code:'action.remove')}</span></a>
            <div id="formContainer_event_${entertainment.id}_${event.id}" class="editItem mainbox"></div>
            <div id="formContainer_fares_${event.id}" class="editItem mainbox"></div>
          </li>
        </g:each>
        </ul>
      </g:if>
    </li>
    </g:each>
  </ul>

