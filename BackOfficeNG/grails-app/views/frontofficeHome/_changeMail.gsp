<g:if test="${changeEmail != '0'}">
  <div class="list-box warn">
    <h2><g:message code="homeFolder.header.email" /></h2>
    <p class="warn documents">
      ${message(code:'homeFolder.message.email')}
      <a href="${createLink(controller:'frontofficeHomeFolder', action:'adult', params:['id':changeEmail, 'fragment': "contact"])}#contact">
        ${message(code:'homeFolder.message.email.link')}
      </a>
    </p>
  </div>
</g:if>
