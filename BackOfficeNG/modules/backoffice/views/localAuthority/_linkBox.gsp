<h2><g:message code="localAuthority.header.setup.${id}" /></h2>
<dl class="localResources linkedResources">
  <g:if test="${hasCurrent}">
    <dt>
      <a target="_blank" href="${createLink(controller : 'localAuthorityResource', action : 'resource', id : id, params : ['version' : currentCode])}">
        <g:message code="localAuthority.property.current.${id}" />
      </a>
    </dt>
  </g:if>
  <g:if test="${hasOld}">
    <dt>
      <a target="_blank" href="${createLink(controller : 'localAuthorityResource', action : 'resource', id : id, params : ['version' : oldCode])}">
        <g:message code="localAuthority.property.old.${id}" />
      </a>
    </dt>
    <dd><a id="rollback_${id}"><g:message code="localAuthority.property.${id}.rollback" /></a></dd>
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
