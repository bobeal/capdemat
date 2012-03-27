<g:if test="${flash.inRequestId}">
    <div class="information-box">
      <p>
      	${message(code:'homeFolder.message.inRequest')}
        <a href='<g:baseUrl controller="frontoffice" />/request/edit/${flash.inRequestId}'>
            <g:translateRequestTypeLabel label="${flash.inRequestLabel}"/>.
        </a>
      </p>
    </div>
  </g:if>