  <g:if test="${states.size() == 0}">
    <g:message code="request.message.noTransition" />
  </g:if>
  <g:else>
    <form method="post" id="changeStateForm" action="<g:createLink action="changeState" />" />
      <div id="changeStateFormErrors" class="error"></div>
      <ul>
        <g:each var="state" status="i" in="${states}">
          <li>
            <input type="radio" name="newState" value="${state.enumString}"
              <g:if test="${i == 0}">
                class="validate-one-required" title="<g:message code="request.error.newStateRequired"/>"
              </g:if>
            />
            <span class="${state.cssClass}">
              <g:message code="${state.i18nKey}" />
            </span>
          </li>
        </g:each>
      </ul>
      <input type="hidden" name="stateType" value="${stateType}" />
      <input type="hidden" name="id" value="${id}" />
      
      <input class="submitStateChange" type="button" value="<g:message code="action.confirm" />" />
      <input class="cancelStateChange" type="button" value="<g:message code="action.cancel" />" />
    </form>
  </g:else>
