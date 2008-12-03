<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>

  <body>
    <form action="${createLink(action:'index')}" method="post" id="mainForm">

      <div id="yui-main">
        <div id="main" class="yui-b">

          <div class="yui-navset">
            <div class="yui-content" >

              <div id="search-results">
                <g:render template="documentList" />
                %{--<g:paginate action="index" total="${documents?.count}"--}%
                            %{--max="10" next="&gt;" prev="&lt;"--}%
                            %{--params="${['ps':pageState]}"--}%
                            %{--/>--}%
              </div>

            </div>
          </div>

        </div>
      </div>

      <div id="narrow" class="yui-b">

        <div id="requestSubject" class="requestBox">
          <h3>
            <g:message code="header.filterBy" />
          </h3>
          <div class="body">
            <label for="dtf">
              <g:message code="property.type" /> :
            </label>
            
            <g:select
              id="dtf"
              name="dtf"
              from="${types}"
              value="${state?.dtf}"
              noSelection="['':' ']"
              valueMessagePrefix="document.type"
            />

            <label for="nf">
              <g:message code="property.individual" /> :
            </label>

            <g:select
              id="nf"
              name="nf"
              from="${individuals}"
              value="${state?.nf}"
              noSelection="['':' ']"/>

            <label for="sf">
              <g:message code="property.state" /> :
            </label>
            <g:select
              optionKey="id"
              optionValue="label"
              id="sf"
              name="sf"
              from="${states}"
              value="${state?.sf}"
              noSelection="['':' ']"
              valueMessagePrefix="document.state"
            />

            <input type="submit" value="${message(code:'action.filter')}"/>
          </div>
        </div>
      </div><!-- end of narrow -->

      <g:hiddenField name="ps" value="${pageState}" />
    </form>
  </body>
</html>

