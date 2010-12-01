<g:each var="rulesField" in="${rulesFieldNames.keySet()}">
  <div class="mainbox mainbox-yellow">
    <h2>
      ${message(code:'requestType.label.rule')} :
      ${message(code:requestTypeAcronym+'.property.'+rulesField + '.label')}
    </h2>
    <form method="post" id="rulesForm_${rulesField}" class="localResourceUpload" action="${createLink(action : 'saveRule')}">
      <div class="error" id="setupFormErrors_${id}"></div>
      <g:if test="${rulesFieldNames[rulesField]}">
        <a target="_blank" href="${createLink(controller : 'localAuthorityResource', action : 'resource', params:[type:'PDF',filename:requestTypeLabelAsDir + '/' + rulesField])}">
          ${message(code:'requestType.label.seeCurrentRule')}
        </a>
      </g:if>
      <g:else>
        ${message(code:'requestType.label.noRuleConfigured')}
      </g:else>
      <br />
      <label for="${id}">
        ${message(code:'requestType.label.newRule')} :
      </label>
      <input type="file" class="required" name="rulesFile" />
      <input type="hidden" name="requestTypeId" value="${id}" />
      <input type="hidden" name="rulesField" value="${rulesField}" />
      <input id="saveRule_${rulesField}" name="save" type="button" value="${message(code:'action.save')}" />
    </form>
  </div>
</g:each>
