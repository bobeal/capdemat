<form id="entryForm_${entry?.key}" method="post" action="${createLink(action:'saveLocalReferentialEntry')}" class="editable-list-form">
  <div class="error" id="entryForm_${entry?.key}_Errors"></div>
  <g:if test="${isNewSubEntry}">
    <strong>${message(code:'localReferential.label.NewEntry')}</strong>
  </g:if>
  <label for="label">label : </label>
  <input type="text" name="labelsMap['fr']" value="${entry?.labelsMap?.fr}" />
  <label for="message">message : </label>
  <input type="text" name="messagesMap['fr']" value="${entry?.messagesMap?.fr}" />
  
  <input type="hidden" name="entry.key" value="${entry?.key}" />
  <input type="hidden" name="parentEntryKey"value="${parentEntryKey}" />
  <input type="hidden" name="dataName" value="${dataName}" />
  
  <label></label>
  <input type="button" id="saveEntry_${entry.key}" class="first-button" value="${isNewSubEntry ? message(code:'action.create') : message(code:'action.modify')}"/>
  <input type="button" id="discardEntry_${entry.key}" class="form-button" value="${message(code:'action.cancel')}"/>
</form>

