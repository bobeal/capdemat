  <g:message code="request.step.document.listHeader" /> :
  <ul>
    <g:each in="${documentTypes}" var="documentType">
      <li>
        <g:message code="${documentType.value}"/>
      </li>
    </g:each>
  </ul>       
