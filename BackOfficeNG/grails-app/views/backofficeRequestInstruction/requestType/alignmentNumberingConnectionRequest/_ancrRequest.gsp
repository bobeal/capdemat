

  <g:set var="listSize" value="${request.ancrRequest.size()}" />
  <h3>
    <a class="addListItem" id="add_ancrRequest[${listSize}]"></a>
    <span><g:message code="ancr.property.ancrRequest.label" /></span>
  </h3>
  <g:each var="it" in="${request.ancrRequest.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_ancrRequest[${listSize - 1 - index}]"></a>
  </div>
  <dl class="required">
    
  </dl>
  </g:each>
