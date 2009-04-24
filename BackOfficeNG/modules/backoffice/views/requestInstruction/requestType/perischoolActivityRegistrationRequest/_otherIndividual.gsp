

  <g:set var="listSize" value="${request.otherIndividual.size()}" />
  <h3>
    <a class="addListItem" id="add_otherIndividual[${listSize}]"></a>
    <span><g:message code="parr.property.otherIndividual.label" /></span>
  </h3>
  <g:each var="it" in="${request.otherIndividual.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_otherIndividual[${listSize - 1 - index}]"></a>
  </div>
  <dl class="">
    
  </dl>
  </g:each>
