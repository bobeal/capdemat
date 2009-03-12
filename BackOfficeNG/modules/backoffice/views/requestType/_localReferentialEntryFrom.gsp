<form class="editable-list-form" action="" id="entryForm_${entry.id}" method="post">
  <div class="error" id="entryForm_${entry.id}_Errors"></div>
  <label for="label">label : </label><input type="text" name="label" />
  <label for="message">message : </label><input type="text" name="message" />
  
  <input type="hidden" value="${entry.id}" name="entryId"/>
  <label></label>
  <input type="button" id="deleteEntry_${entry.id}" class="first-button" value="modifier"/>
  <input type="button" id="deleteEntry_${entry.id}" class="form-button" value="annuler"/>
</form>
