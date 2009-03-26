<h2><g:message code="requestType.configuration.seasons" /></h2>
<div class="editableListSwithcher">
  <a id="linkShowDatasheet" class="createItem"><g:message code="action.create" /></a>
</div>
<div id="newSeasonFormContainer"></div>
<ul id="seasons" class="editableList">
  <g:each in="${seasons}" var="season">
    <li id="season_${season.uuid}">
      <a id="deleteSeason_${season.uuid}" class="unassociate"><span>deleteItem</span></a>
      <a id="editSeason_${season.uuid}" class="editItem"><span>editItem</span></a>
      <span class="name">${season.label}</span>
      <div id="seasonEditionContainer_${season.uuid}"></div>
    </li>
  </g:each>
</ul>
