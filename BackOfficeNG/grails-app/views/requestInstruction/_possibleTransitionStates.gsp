  <g:if test="${states.size() == 0}">
    <g:message code="state.noTransition" />
  </g:if>
  <g:else>
    <form method="post" id="changeStateForm" action="<g:createLink action="changeState" />" />
      <ul>
        <g:each var="state" status="i" in="${states}">
          <li>
            <input type="radio" name="newState" value="${state.enumString}" />
            <span class="${state.cssClass}">
              <g:message code="${state.i18nKey}" />
            </span>
          </li>
        </g:each>
      </ul>
      <input type="hidden" name="stateType" value="${stateType}" />
      <input type="hidden" name="id" value="${id}" />
      
      <input class="submitStateChange" type="button" value="confirm" />
      <input class="cancelStateChange" type="button" value="cancel" />
    </form>
  </g:else>
