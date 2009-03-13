<g:each var="lrData" in="${lrDatas}">
  <div id="data_${lrData.dataName}" class="mainbox mainbox-yellow">
    <h2>${lrData.labelsMap.fr}</h2>
    <form id="dataWidget_${lrData.dataName}"action="/BackOfficeNG/backoffice/category/requestTypes" method="post" style="padding-top: 0;">
      <select name="widget">
        <option value="" selected="selected">menu déroulant (choix unique)</option>
        <option value="">liste/arbre de case à cocher (choix multiple)</option>
      </select>
    </form>
    <div class="createConfigurationItem">
      <a id="addEntry_${lrData.dataName}" href="">Ajouter une entrée</a>
    </div>
    <div class="editableListSwithcher" style="margin-right: 2em; padding-right: 0;">
      <a id="expandTree_${lrData.dataName}" class="current">ouvrir</a>/
      <a id="collapseTree_${lrData.dataName}" class="">fermer</a>
    </div>
    <g:render template="localReferentialEntries" model="['lrEntries': lrData.entries, 'depth':0, 'dataName':lrData.dataName]" />
  </div>
</g:each>
