<g:each var="lrType" in="${lrTypes}">
  <div id="lrtDataName_${lrType.name}" class="mainbox mainbox-yellow">
    <h2>${lrType.label}</h2>
    <form id="widgetForm_${lrType.name}" action="${createLink(action:'saveLocalReferentialType', id: requestTypeId)}" method="post" style="padding-top: 0;">
      <select id="saveWidget_${lrType.name}" name="allowMultipleChoices">
        <option value="false" ${lrType.isMultiple() ? '' : 'selected="selected"'}>${message(code:'localReferential.label.dropDownListWidget')}</option>
        <option value="true" ${lrType.isMultiple() ? 'selected="selected"' : ''}>${message(code:'localReferential.label.checkBoxTreeWidget')}</option>
      </select>
      <input type="hidden" name="lrtDataName" value="${lrType.name}" />
    </form>
    <div class="createConfigurationItem">
      <a id="addEntry_${lrType.name}">${message(code:'localReferential.label.addEntry')}</a>
    </div>
    <div class="editableListSwithcher" style="margin-right: 2em; padding-right: 0;">
      <a id="expandEntries_${lrType.name}" class="current">${message(code:'action.expand')}</a>/
      <a id="collapseEntries_${lrType.name}" class="">${message(code:'action.collapse')}</a>
    </div>
    <div id="formContainer_${lrType.name}" class="newItem"></div>
    <div id="lrtEntriesContainer_${lrType.name}">
    <g:render template="localReferentialEntries"
              model="['lrEntries': lrType.entries, 'parentEntry':lrType.name,'depth':0]" />
    </div>
  </div>
</g:each>
