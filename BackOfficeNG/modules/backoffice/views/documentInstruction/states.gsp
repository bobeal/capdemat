
<form method="post" id="documentStateForm" action="${createLink(action:'changeState')}">
  <div id="documentStateFormErrors" class="error"> </div>
  
  <label for="endValidityDate">
    <g:message code="document.property.endValidityDate" /> :
  </label>
  <input type="text" id="endValidityDate" name="endValidityDate" size="10" 
    value="${formatDate(formatName:'format.date',date:endValidityDate)}" />
  <a href="javascript:;" id="endValidityDateShow">
    <img alt="" src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
  </a>
  <div id="endValidityDateCalContainer" class="yui-cal"> </div>
  
  <label for="state">
    <g:message code="request.header.changeState" /> :
  </label>
  
  <g:if test="${states.isEmpty()}">
    <g:message code="request.message.noTransition" />
  </g:if>
  <g:else>
    <ul>
      <g:each var="state" status="i" in="${states}">
        <li>
          <input type="radio" name="state" value="${state.enumString}" />
          <span class="${state.cssClass}">
            <g:message code="${state.i18nKey}" />
          </span>
        </li>
      </g:each>
    </ul>
  </g:else>
  
  <input type="hidden" name="documentId" value="${documentId}" />
  <input id="changeDocumentState" class="submitDocumentStateChange" type="button" value="${message(code:'action.confirm')}" />
  <input id="cancelDocumentState" class="cancelDocumentStateChange" type="button" value="${message(code:'action.cancel')}" />
</form>