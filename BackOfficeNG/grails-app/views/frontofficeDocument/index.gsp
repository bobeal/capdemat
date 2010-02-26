<html>
  <head>
    <title>${message(code:'document.title')}</title>
    <meta name="layout" content="fo_main" />
  </head>

  <body>
    <form action="${createLink(action:'index')}" method="post" id="mainForm">

      <div id="yui-main">
        <div id="main" class="yui-b">

          <div class="list-box">
            <h2><g:message code="menu.documents" /></h2>
            <g:if test="${documents.count > 0}">
              <p class="paginator">
                <g:paginate action="index" total="${documents.count}" max="${maxRows}" next="&gt;" prev="&lt;" params="${['ps':pageState]}"  />
              </p>
              <g:render template="documentList" />
              <p class="paginator">
                <g:paginate action="index" total="${documents.count}" max="${maxRows}" next="&gt;" prev="&lt;" params="${['ps':pageState]}"  />
              </p>
            </g:if>
            <g:else>
              <p class="empty"><g:message code="message.noDocuments" /></strong>
            </g:else>
          </div>

        </div>
      </div>

      <div id="narrow" class="yui-b">

        <div class="narrow-box">
          <h3>
            <g:message code="header.filterBy" />
          </h3>
          <div class="body">
            <label for="nf">
              <g:message code="property.individual" /> :
            </label>

            <g:select id="nf" name="nf"
              optionKey="id" optionValue="fullName"
              from="${individuals}" value="${state?.nf}"
              noSelection="['':message(code:'search.filter.defaultValue')]" />

            <label for="df">
              <g:message code="property.type" /> :
            </label>
            
            <g:select id="df" name="df"
              optionKey="id" optionValue="name"
              from="${types}" value="${state?.df}"
              noSelection="['':message(code:'search.filter.defaultValue')]"
              valueMessagePrefix="document.type" />

            <label for="sf">
              <g:message code="property.state" /> :
            </label>
            <g:select id="sf" name="sf"
              from="${states}" value="${state?.sf}"
              noSelection="['':message(code:'search.filter.defaultValue')]"
              valueMessagePrefix="document.state" />

            <input type="submit" value="${message(code:'action.filter')}"/>
          </div>
        </div>
      </div><!-- end of narrow -->

      <g:hiddenField name="ps" value="${pageState}" />
    </form>
  </body>
</html>

