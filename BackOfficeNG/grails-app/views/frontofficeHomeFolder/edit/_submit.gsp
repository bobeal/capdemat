<input type="hidden" name="fragment" value="${fragment}" />
<input type="hidden" name="id" value="${individual.id}" />
<input type="submit" name="submit" value="${message(code:'action.save')}" class="save" />
<a href="${createLink(action:individual.class.simpleName.toLowerCase(), params:['id':individual.id])}#${fragment}">
  ${message(code:'action.cancel')}
</a>

