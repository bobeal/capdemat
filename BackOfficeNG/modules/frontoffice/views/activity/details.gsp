<html>
  <head>
    <meta name="layout" content="fo_main"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'activity.css')}" />
  </head>
  
  <body>
  <div id="yui-main">
    <div id="main" class="yui-b">
      <div class="list-box">
        <h2>
          <g:translateRequestTypeLabel label="${label}"/> <g:message code="message.for" /> ${individual} 
        </h2>
        <g:activityCalendar month="${params.month}" year="${params.year}" data="${datas}"/>
      </div>
    </div>
  </div> 
  <!-- end of yui-main -->

  <div id="narrow" class="yui-b">
    <div class="requestBox">
      <h3>
        <g:message code="header.display" />
      </h3>
      <div class="body">
        <a class="top-link" href="${createLink(action:'index')}">
          <g:message code="activity.header.mainPanel" />
        </a>
      </div>
    </div>
  </div>
  
  <div id="narrow" class="yui-b">
    <div class="requestBox">
      <h3>
        <g:message code="header.legend" />
      </h3>
      <div class="body">
        <ul class="legend">
          <g:each in="${datas.keySet()}" status="i" var="activity">
            <li>
              <span class="legend-label legend-label-${i}">&nbsp;</span>
              ${activity} (${datas.get(activity).size()})
            </li>
          </g:each>
        </ul>
      </div>
    </div>
  </div>
  <!-- end of narrow -->
  
  </body>
</html>