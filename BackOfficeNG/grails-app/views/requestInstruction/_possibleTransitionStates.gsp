  <g:if test="${states.size() == 0}">
    <g:message code="state.noTransition" />
  </g:if>
  <g:else>
    <form>
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
      <input class="submitRequestStateChange" type="button" value="confirm" />
      <input class="cancelRequestStateChange" type="button" value="cancel" />
    </form>
  </g:else>
