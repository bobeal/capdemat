<g:each var="lrType" in="${lrTypes}">
  <div id="lrtDataName_${lrType.dataName}" class="mainbox mainbox-yellow">
    <h2>${lrType.labelsMap.fr}</h2>
    <form id="widgetForm_${lrType.dataName}" action="${createLink(action:'localReferentialWidget')}" method="post" style="padding-top: 0;">
      <select id="confirmSaveWidget_${lrType.dataName}" name="entriesSupportMultiple">
        <option value="false" ${lrType.entriesSupportMultiple ? '' : 'selected="selected"'}>${message(code:'localReferential.label.dropDownListWidget')}</option>
        <option value="true" ${lrType.entriesSupportMultiple ? 'selected="selected"' : ''}>${message(code:'localReferential.label.checkBoxTreeWidget')}</option>
      </select>
      <input type="hidden" name="lrtDataName" value="${lrType.dataName}" />
    </form>
    <div class="createConfigurationItem">
      <a id="addEntry_${lrType.dataName}">${message(code:'localReferential.label.addEntry')}</a>
    </div>
    <g:if test="${lrType.entriesSupportMultiple}">
      <div class="editableListSwithcher" style="margin-right: 2em; padding-right: 0;">
        <a id="expandEntries_${lrType.dataName}" class="current">${message(code:'action.expand')}</a>/
        <a id="collapseEntries_${lrType.dataName}" class="">${message(code:'action.collapse')}</a>
      </div>
    </g:if>
    <div id="formContainer_${lrType.dataName}" class="newItem"></div>
    <div id="lrtEntriesContainer_${lrType.dataName}">
    <g:render template="localReferentialEntries" 
              model="['lrEntries': lrType.entries, 'parentEntry':lrType.dataName, 'isMultiple':lrType.entriesSupportMultiple,'depth':0]" />
    </div>
  </div>
</g:each>
