<g:if test="${dashBoard.requests?.count > 0}">
  <ul>
    <g:each var="record" in="${dashBoard.requests.records}">
      <li>
        <p class="first-line"> 
          ${record.label}
        </p>
        
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <strong><g:message code="message.noRequests" /></strong>
</g:else>