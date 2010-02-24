<h2>${message(code:'subscriber.header.referential')}</h2>
<div class="createConfigurationItem">
  <a id="editSubscriber">${message(code:'subscriber.action.add')}</a>
</div>
<div id="formContainer_subscriber_" class="newItem"></div>
<div class="editableListSwithcher">
  <form id="sortSubscribersForm" method="post" action="${createLink(action:'subscribers')}" />
    <select id="orderBySubscriber" name="orderBySubscriber">
       <option>${message(code:'action.orderBy')} ...</option>
      <g:each in="${['lastName','firstName','number']}">
        <option value="${it}" ${orderBySubscriber == it ? 'selected' : ''}>
          ${message(code:'subscriber.filter.' + it)}
        </option>
      </g:each>
    </select>
    <input type="hidden" name="startIndexSubscriber" id="startIndexSubscriber" value="${startIndexSubscriber}" />
    &nbsp;
    <g:if test="${displayDirSubscriber.prev}">
     &lt;<a id="previousSubscribers">${message(code:'action.previous')}</a>
    </g:if>
    <g:else>
      <span style="color:#aaa;">&lt; ${message(code:'action.previous')}</span>
    </g:else>
    |
    <g:if test="${displayDirSubscriber.next}">
      <a id="nextSubscribers">${message(code:'action.next')}</a>&gt;
    </g:if>
    <g:else>
      <span style="color:#aaa;">${message(code:'action.next')} &gt;</span>
    </g:else>
  </form>
</div>
<ul id="subscribers" class="editableList">
  <g:each var="subscriber" in="${subscribers}">
    <li>
      <a id="removeSubscriber_${subscriber.id}" class="deleteItem"><span>${message(code:'action.delete')}</span></a>
      <a id="editSubscriber_${subscriber.id}" class="editItem"><span>${message(code:'action.edit')}</span></a>
      <strong>${subscriber.firstName} ${subscriber.lastName}</strong>
      <span>(${subscriber.number})</span>
      <div id="formContainer_subscriber_${subscriber.id}" class="editItem mainbox"></div>
    </li>
  </g:each>
</ul>

