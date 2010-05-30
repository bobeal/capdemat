<html>
  <head>
    <title>Erreur - ${currentSite}</title>
    <style type="text/css">
        .message {
          border: 1px solid black;
          padding: 5px;
          background-color:#E9E9E9;
          text-align: center;
          font-weight: bold;
        }
        .stack {
          border: 1px solid black;
          padding: 5px;
          overflow:auto;
          height: 300px;
        }
        .snippet {
          padding: 5px;
          background-color:white;
          border:1px solid black;
          margin:3px;
          font-family:courier;
        }
    </style>
  </head>
  <body>
    <img src="${createLink(controller : 'localAuthorityResource', action : 'resource', id : 'logoFo')}"
         alt="Logo Collectivité" />
    <h1 style="text-align:center;">${currentSite}</h1>
    <p class="message">Erreur : ${errorMessage}</p>
    <div>
      Vous pouvez :
      <ul>
        <li>
          <a href="${createLink(controller:'frontofficeHome')}">
            <g:message code="action.goHome" />
          </a>
        </li>
      </ul>
    </div>

    <div style="display:none;">
    <div class="message">
      <strong>Message:</strong> ${exception.message?.encodeAsHTML()} <br />
      <strong>Caused by:</strong> ${exception.cause?.message?.encodeAsHTML()} <br />
      <strong>Class:</strong> ${exception.className} <br />
      <strong>At Line:</strong> [${exception.lineNumber}] <br />
      <strong>Code Snippet:</strong><br />
      <div class="snippet">
        <g:each var="cs" in="${exception.codeSnippet}">
          ${cs?.encodeAsHTML()}<br />
        </g:each>
      </div>
    </div>
    <h2>Stack Trace</h2>
    <div class="stack">
      <pre><g:each in="${exception.stackTraceLines}">${it.encodeAsHTML()}<br/></g:each></pre>
    </div>
    </div>
  </body>
</html>
