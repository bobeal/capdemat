<dt>&nbsp;</dt>
<dd style="font-size: .95em;">
  <input type="hidden" name="template" value="${template}" />
  <input type="hidden" name="id" value="${object.id}" />
  <input type="submit" name="submit" value="${message(code:'action.save')}" class="save" />
  <a class="cancel${!object.id ? 'Add' : ''}">
    ${message(code:'action.cancel')}
  </a>
</dd>
