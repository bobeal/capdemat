<form id="entertainment_${entertainment?.id}" class="listItem" method="post" action="${createLink(action:'entertainment')}" >
  <h3>${message(code:'entertainment.header.' + (entertainment != null ? 'edit' : 'add'))}</h3>
  <p class="error" id="entertainment_${entertainment?.id}_Errors"></p>
  <input type="hidden" name="id" value="${entertainment?.id}" />
  
  <p>
    <label for="name" class="required">${message(code:'entertainment.property.name')} : *</label>
    <input type="text" value="${entertainment?.name}" name="name" class="required" />
  </p>
  <p>
    <label for="information">${message(code:'entertainment.property.information')} : </label>
    <textarea name="information">${entertainment?.information}</textarea>
  </p>
  <p>
    <label for="link">${message(code:'entertainment.property.link')} : </label>
    <input type="text" name="link" value="${entertainment?.link}" />
  </p>
  <p>
    <label for="label" class="required">${message(code:'entertainment.property.category')} : </label>
    <g:if test="${categories}">
      <select name="category">
      <g:each var="lre" in="${categories?.entries}">
      <option value="${lre.label}" ${lre.label == entertainment?.category ? 'selected="selected"' : ''}>
        ${lre.label}  
      </option>
      </g:each>
      </select>
    </g:if>
    <g:else>
      <input type="text" name="category" value="${entertainment?.category}" />
    </g:else>
  </p>

  <g:if test="${entertainment?.id}">
  <h3 style="clear: both;">${message(code:'entertainment.header.logo')}</h3>
    <p>
      <img id="logo_${entertainment?.id}" src="${createLink(action:'entertainmentLogo', params:['id':entertainment?.id])}" />
    </p>
    <p>
      <label for="logoFile">
        ${message(code:'entertainment.message.newLogo')} :
        <span>(${message(code:'entertainment.message.logoInformation')})</span>
      </label>
      <input type="file" name="logoFile" />
    </p>
  </g:if>

  <p class="button">
    <input type="button" id="saveEntertainment_${entertainment?.id}" value="${message(code:'action.' + (entertainment != null ? 'save' : 'create'))}" />
    <input type="button" id="discard_${entertainment?.id}" value="${message(code:'action.close')}"/>
  </p>
  
</form>

