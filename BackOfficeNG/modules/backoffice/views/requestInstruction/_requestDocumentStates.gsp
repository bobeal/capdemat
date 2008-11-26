
    <form method="post" id="documentStateForm" action="<g:createLink action="modifyDocument" />" />
      <div id="documentStateFormErrors" class="error"></div>
      
      <label for="endValidityDate">
        <g:message code="document.property.endValidityDate" /> :
      </label>
      <input type="text" id="endValidityDate" name="endValidityDate" size="10" 
          title="" value="<g:formatDate format="dd/MM/yyyy" date="${endValidityDate}"/>" />
      <a onclick="showCalendar('endValidityDateShow', 0);">
        <img id="endValidityDateShow" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="endValidityDateCalContainer" class="yui-cal"></div>
      
      <label for="endValidityDate">
        <g:message code="request.header.changeState" /> :
      </label>
      
      <g:if test="${states.size() == 0}">
        <g:message code="request.message.noTransition" />
      </g:if>
      <g:else>
        <ul>
          <g:each var="state" status="i" in="${states}">
            <li>
              <input type="radio" name="state" value="fr.cg95.cvq.business.document.DocumentState_${state.enumString}"
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
      </g:else>
      
      <input type="hidden" name="documentId" value="${documentId}" />
      
      <input class="submitDocumentStateChange" type="button" value="<g:message code="action.confirm" />" />
      <input class="cancelDocumentStateChange" type="button" value="<g:message code="action.cancel" />" />
    </form>

