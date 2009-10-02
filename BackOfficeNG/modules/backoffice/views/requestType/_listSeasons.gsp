<h2><g:message code="requestType.configuration.seasons" /></h2>
<div class="editableListSwithcher">
  <a id="linkShowDatasheet" class="createItem"><g:message code="action.create" /></a>
</div>
<div id="newSeasonFormContainer"></div>
<ul id="seasons" class="editableList">
  <g:each in="${seasons}" var="season">
    <li id="season_${season.id}">
      <a id="deleteSeason_${season.id}" class="unassociate"><span>deleteItem</span></a>
      <a id="editSeason_${season.id}" class="editItem"><span>editItem</span></a>
      <span class="name">${season.label} (<g:formatDate formatName='format.date' date='${season.effectStart.toDate()}'/> - <g:formatDate formatName='format.date' date='${season.effectEnd.toDate()}'/>)</span>
      <div id="seasonEditionContainer_${season.id}"></div>
    </li>
  </g:each>
</ul>
