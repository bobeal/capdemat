<h2><g:message code="localAuthority.header.setup.${id}" /></h2>
<dl class="localResources">
  <g:if test="${hasCurrent}">
    <dt><g:message code="localAuthority.property.current.${id}" /></dt>
    <dd><img src="${createLink(controller : 'localAuthorityResource', action : 'resource', id : id, params : ['version' : currentCode, 'rand' : rand])}" /></dd>
  </g:if>
  <g:if test="${hasOld}">
    <dt><g:message code="localAuthority.property.old.${id}" /></dt>
    <dd>
      <img src="${createLink(controller : 'localAuthorityResource', action : 'resource', id : id, params : ['version' : oldCode, 'rand' : rand])}" />
      <a id="rollback_${id}"><g:message code="localAuthority.property.${id}.rollback" /></a>
    </dd>
  </g:if>
</dl>
<form method="post" id="setupForm_${id}" class="localResourceUpload" action="${createLink(action : 'aspect')}">
  <div class="error" id="setupFormErrors_${id}"></div>
  <label for="${id}">
    <g:message code="localAuthority.property.new.${id}" /> :
  </label>
  <input type="file" class="required" name="content" />
  <input type="hidden" name="id" value="${id}" />
  <input id="save_${id}" name="save" type="button" value="${message(code:'action.save')}" />
</form>
