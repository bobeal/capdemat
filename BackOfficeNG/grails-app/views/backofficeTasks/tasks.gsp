<html>
  <head>
    <title><g:message code="tasks.header" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${resource(dir:'js/backoffice', file:'tasks.js')}"></script>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice', file:'tasks.css')}" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="tasks.header.onRequests" /></h1>
        </div>

          <div class="tasks red">
            <h2>
            <strong class="toggle"><g:message code="tasks.header.late" /> (${taskMap.aboutRequests.late.count})</strong>
              <a href="${createLink(controller : 'backofficeRequest', action : 'listTasks', params : ['qoS' : fr.cg95.cvq.business.request.Request.QUALITY_TYPE_RED])}"><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${taskMap.aboutRequests.late.count > 0 ? '' : 'collapse'}">
              <g:render template="requestEntry" var="record" collection="${taskMap.aboutRequests.late.all}" />
            </ul>
          </div>

          <div class="tasks orange">
            <h2>
              <strong class="toggle"><g:message code="tasks.header.urgent" /> (${taskMap.aboutRequests.urgent.count})</strong>
              <a href="${createLink(controller : 'backofficeRequest', action : 'listTasks', params : ['qoS' : fr.cg95.cvq.business.request.Request.QUALITY_TYPE_ORANGE])}"><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${taskMap.aboutRequests.late.count == 0 && taskMap.aboutRequests.urgent.count > 0 ? '' : 'collapse'}">
              <g:render template="requestEntry" var="record" collection="${taskMap.aboutRequests.urgent.all}" />
            </ul>
          </div>

          <div class="tasks green">
            <h2>
              <strong class="toggle"><g:message code="tasks.header.good" /> (${taskMap.aboutRequests.good.count})</strong>
              <a href="${createLink(controller : 'backofficeRequest', action : 'listTasks', params : ['qoS' : fr.cg95.cvq.business.request.Request.QUALITY_TYPE_OK])}" ><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${(taskMap.aboutRequests.late.count == 0 && taskMap.aboutRequests.urgent.count == 0 && taskMap.aboutRequests.good.count > 0) ? '' : 'collapse'}">
              <g:render template="requestEntry" var="record" collection="${taskMap.aboutRequests.good.all}" />
            </ul>
          </div>

        <div class="head" style="margin-top: 2em">
          <h1><g:message code="tasks.header.onIndividuals" /></h1>
        </div>

          <div class="tasks red">
            <h2>
            <strong class="toggle"><g:message code="tasks.header.late" /> (${taskMap.aboutIndividuals.late.count})</strong>
              <a href="${createLink(controller : 'backofficeHomeFolder', action : 'listTasks', params : ['qoS' : fr.cg95.cvq.business.QoS.LATE])}"><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${taskMap.aboutIndividuals.late.count > 0 ? '' : 'collapse'}">
              <g:render template="individualEntry" var="record" collection="${taskMap.aboutIndividuals.late.all}" />
            </ul>
          </div>

          <div class="tasks orange">
            <h2>
              <strong class="toggle"><g:message code="tasks.header.urgent" /> (${taskMap.aboutIndividuals.urgent.count})</strong>
              <a href="${createLink(controller : 'backofficeHomeFolder', action : 'listTasks', params : ['qoS' : fr.cg95.cvq.business.QoS.URGENT])}"><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${taskMap.aboutIndividuals.late.count == 0 && taskMap.aboutIndividuals.urgent.count > 0 ? '' : 'collapse'}">
              <g:render template="individualEntry" var="record" collection="${taskMap.aboutIndividuals.urgent.all}" />
            </ul>
          </div>

          <div class="tasks green">
            <h2>
              <strong class="toggle"><g:message code="tasks.header.good" /> (${taskMap.aboutIndividuals.good.count})</strong>
              <a href="${createLink(controller : 'backofficeHomeFolder', action : 'listTasks', params : ['qoS' : fr.cg95.cvq.business.QoS.GOOD])}" ><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${(taskMap.aboutIndividuals.late.count == 0 && taskMap.aboutIndividuals.urgent.count == 0 && taskMap.aboutIndividuals.good.count > 0) ? '' : 'collapse'}">
              <g:render template="individualEntry" var="record" collection="${taskMap.aboutIndividuals.good.all}" />
            </ul>
          </div>

      </div>
    </div>

    <div id="narrow" class="yui-b">
    </div>

  </body>
</html>

