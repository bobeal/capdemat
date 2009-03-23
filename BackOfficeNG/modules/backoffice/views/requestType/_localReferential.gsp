<g:each var="lrData" in="${lrDatas}">
  <div id="lrtDataName_${lrData.dataName}" class="mainbox mainbox-yellow">
    <h2>${lrData.labelsMap.fr}</h2>
    <form id="dataWidget_${lrData.dataName}" action="#" method="post" style="padding-top: 0;">
      <select name="widget">
        <option value="" selected="selected">menu déroulant (choix unique)</option>
        <option value="">liste/arbre de case à cocher (choix multiple)</option>
      </select>
    </form>
    <div class="createConfigurationItem">
      <a id="addEntry_${lrData.dataName}">Ajouter une entrée</a>
    </div>
    <div class="editableListSwithcher" style="margin-right: 2em; padding-right: 0;">
      <a id="expandEntries_${lrData.dataName}" class="current">ouvrir</a>/
      <a id="collapseEntries_${lrData.dataName}" class="">fermer</a>
    </div>
    <div id="formContainer_${lrData.dataName}" class="newItem"></div>
    <div id="lrtEntriesContainer_${lrData.dataName}">
    <g:render template="localReferentialEntries" model="['lrEntries': lrData.entries, 'depth':0, 'parentEntry':lrData.dataName]" />
    </div>
  </div>
</g:each>
