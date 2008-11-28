<g:if test="${dashBoard.payments?.all.size() > 0}">
  <ul>
    <g:each var="record" in="${dashBoard.payments.all}">
      <li>
        <p class="first-line"> 
          ${record.id}
        </p>
        
      </li>
    </g:each>
  </ul>
</g:if>
<g:else>
  <strong><g:message code="message.noDocuments" /></strong>
</g:else>