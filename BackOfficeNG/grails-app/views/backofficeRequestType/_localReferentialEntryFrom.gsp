<form id="entryForm_${entry?.key}" method="post" action="${createLink(action:'saveLocalReferentialEntry', id:requestTypeId)}" class="editable-list-form">
  <g:if test="${isNewSubEntry}">
    <h3>${message(code:'localReferential.label.newEntry')}</h3>
  </g:if>
  <div class="error" id="entryForm_${entry?.key}_Errors"></div>
  <label for="label" class="required">${message(code:'localReferential.label.label')} * : </label>
  <input type="text" name="label" value="${entry?.label}" class="required" title="${message(code:'localReferential.error.labelisRequired')}" />
  <label for="message">${message(code:'localReferential.label.message')} : </label>
  <input type="text" name="message" value="${entry?.message}" />
  
  <input type="hidden" name="entry.key" value="${entry?.key}" />
  <input type="hidden" name="parentEntryKey"value="${parentEntryKey}" />
  <input type="hidden" name="dataName" value="${dataName}" />
  
  <label></label>
  <input type="button" id="saveEntry_${entry.key}" class="first-button" value="${isNewSubEntry ? message(code:'action.create') : message(code:'action.modify')}"/>
  <input type="button" id="discardEntry_${entry.key}" class="form-button" value="${message(code:'action.cancel')}"/>
</form>

