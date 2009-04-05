<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice/common', file:'form.css')}" />
  </head>
  <body>
    <g:if test="${flash.errorMessage}"><div class="error-box"><p>${flash.errorMessage}</p></div></g:if>
    <div class="yui-g">
      <div class="yui-u first">
        <form action="${createLink(action:'editQuestion')}" method="post">

          <fieldset>

            <legend><g:message code="account.header.editQuestion"/></legend>

            <label class="required" for="password"><g:message code="homeFolder.adult.property.password"/> * :</label>
            <input type="password" name="password" value="" class="required" />

            <label class="required"><g:message code="homeFolder.adult.property.question" /> * :</label>
            <select name="question" class="required validate-not-first">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['q1','q2','q3','q4']}">
                <option value="<g:message code='homeFolder.adult.question.${it}' />"${message(code:'homeFolder.adult.question.' + it) == question.toString() ? 'selected="selected"': ''}>
                  <g:message code="homeFolder.adult.question.${it}" />
                </option>
              </g:each>
            </select>

            <label class="required"><g:message code="homeFolder.adult.property.answer" /> * :</label>
            <input type="text" name="answer" value="${answer}" class="required" />
          </fieldset>

          <p class="submit-form">
            <input type="submit" value="${message(code:'action.save')}" />
            <input type="submit" name="cancel" value="${message(code:'action.cancel')}" />
          </p>
        </form>
      </div>
    </div>
  </body>
</html>
