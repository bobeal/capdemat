<html>
  <head>
    <title>${message(code : acronym + ".description")}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <style type="text/css">
      #request .steps p.help { margin-bottom: .5em; font-style: italic;}
      #request .datas form div p.error { text-align: left; }
      #request .datas form p { padding-left: 0; font-style: italic;}
      #request .datas form { padding: 0; }
      #request form div label { line-height: 1.6em; }
    </style>
  </head>
  <body>
    <div id="request" class="main-box">
      <h2>
        <g:translateRequestTypeLabel label="${params.id}" />
      </h2>
      <p><g:message code="request.duration.label" /><strong> : <g:message code="sgr.duration.value" /></strong></p>
      <p>
        <g:message code="request.requiredDocuments.header" /> :
        <g:if test="${!documentTypes.isEmpty()}">
          <g:each var="documentType" in="${documentTypes}" status="index">
            <strong>${documentType?.name}${index < documentTypes.size() - 1 ? ', ' : ''}</strong>
          </g:each>
        </g:if>
        <g:else>
          <g:message code="message.none" />
        </g:else>
      </p>
      ${intro}
    </div>
    <div class="yui-g">
      <div class="yui-u first list-box">
        <h2><g:message code="request.header.continueDraft" /></h2>
        <g:if test="${drafts.isEmpty()}">
          <p class="empty"><g:message code="message.noRequests" /></p>
        </g:if>
        <g:else>
          <ul>
            <g:each var="draft" in="${drafts}">
              <li>
                <p>
                  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', id : draft.id)}">
                    ${draft.label}
                    <g:message code="request.searchResult.requestId" />
                    <span>${draft.id}</span>
                    - <g:message code="layout.from" />
                    <span>${draft.requesterLastName} ${draft.requesterFirstName}</span>
                    <g:if test="${draft.subjectLastName && draft.subjectLastName != ''}">
                      <g:message code="layout.for" />
                      ${draft.subjectLastName} ${draft.subjectFirstName}
                    </g:if>
                  </a>
                </p>
                <p>
                  <g:message code="request.searchResult.creationDate"
                    args="${[formatDate(date:draft.creationDate,formatName:'format.date')]}"/>
                  <g:if test="${draft.lastModificationDate}">
                    - <g:message code="request.property.lastModificationDate" />
                    <g:formatDate date="${draft.lastModificationDate}" formatName="format.date" />
                    <g:if test="${draft.lastInterveningUserId}">
                      <g:message code="layout.by" />
                      ${draft.lastInterveningUserId}
                    </g:if>
                  </g:if>
                </p>
              </li>
            </g:each>
          </ul>
        </g:else>
      </div>
      <div class="yui-u main-box">
        <h2><g:message code="request.header.createNewRequest" /></h2>
        <form action="${createLink(controller : 'frontofficeRequest', action : 'create')}">
          <input type="hidden" name="label" value="${params.id}" />
          <g:if test="${!seasons.isEmpty()}">
            <h3>${message(code:'request.action.choose.requestSeason')}</h3>
            <g:each var="season" in="${seasons}">
              <label>
                <input name="requestSeasonId" type="radio" value="${season.id}" />
                ${season.label}
                <span class="help">
                  (${message(code : 'message.dateInterval', args : [
                    g.formatDate(formatName : 'format.date', date : season.effectStart.toDate()),
                    g.formatDate(formatName : 'format.date', date : season.effectEnd.toDate())])})
                </span>
              </label>
            </g:each>
          </g:if>
          <g:if test="${!lastRequests.isEmpty()}">
            <h3>${message(code:'requestType.message.renew.chooseRequest')}</h3>
            <g:each var="lastRequest" in="${lastRequests}">
              <label>
                <input name="renewedId" type="radio" value="${lastRequest.value.id}" />
                ${message(code:'requestType.property.renew.requestFor')} ${lastRequest.key.lastName} ${lastRequest.key.firstName}
                ${message(code:'requestType.property.renew.dateTo')} <g:formatDate formatName="format.date" date="${lastRequest.value.creationDate}"/>
                <span class="help">
                  (<a href="${createLink(controller : 'frontofficeRequest', action : 'summary', id : lastRequest.value.id)}" target="_blank" >${message(code:'requestType.action.display')}</a>)
                </span>
              </label>
            </g:each>
            <label>
              <input name="renewedId" type="radio" value="" checked="checked" />
              ${message(code:'requestType.message.renew.noRequest')}
            </label>
          </g:if>
          <p style="text-align: center;">
            <input type="submit" value="${message(code:'requestType.action.start')}" style="font-size:1.2em;" />
          </p>
        </form>
      </div>
    </div>
  </body>
</html>
