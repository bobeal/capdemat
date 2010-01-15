<html>
  <head>
    <title>${message(code:'request.title.summary')}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  <body>
    <g:if test="${externalInformations}">
      <div class="summary-box created" id="externalInformations">
        <h2><g:message code="request.header.externalInformations" /></h2>
        <div class="body">
          <dl>
            <g:each var="externalInformation" in="${externalInformations}">
              <dt><g:message code="${externalInformation.key}" /></dt>
              <dd>${externalInformation.value}</dd>
            </g:each>
          </dl>
        </div>
      </div>
    </g:if>
    <div class="summary-box created">
      <h2>
        <g:message code="request.header.summary"
          args="${[requestTypeLabel,rqt.id.toString()]}" />
        <g:if test="${requestActionId}">
          <span>
            <g:message code="requestAction.action.download.Creation" /> :
            <a title="<g:message code='requestAction.property.requestCertificate' />"
              href="${createLink(action : 'download', id : requestActionId)}">
              <img
                alt="<g:message code='requestAction.action.download.Creation' />"
                src="${createLinkTo(dir:'images/icons',file:'pdficon_small.gif')}" />
            </a>
          </span>
        </g:if>
      </h2>
      <div class="body">
        <g:render template="/frontofficeRequestType/${validationTemplateDirectory}/summary"
          model="['rqt':rqt]" />
      </div>
    </div>
    <g:if test="${requestNotes}">
      <div class="main-box" id="requestNotes">
        <h2><g:message code="request.property.notes" /></h2>
        <dl class="notes">
          <g:each var="requestNote" in="${requestNotes}">
            <dt>
              <span class="tag-${requestNote.nature}"><g:message code="${requestNote.nature}" /></span>
              ${requestNote.user_name}
            </dt>
            <dd>
              <p class="note">${requestNote.note}</p>
              <p class="noteMetadata">
                <g:message code="request.property.note" /> 
                <strong><g:message code="request.note.type.${requestNote.type.toString().toLowerCase()}" /></strong>
                n° <strong>${requestNote.id}</strong>
                <g:if test="${requestNote.date != null}">
                  <g:message code="request.note.date" /> <strong><g:formatDate formatName="format.fullDate" date="${requestNote.date}"/></strong>
                </g:if>
              </p>
            </dd>
          </g:each>
        </dl>
      </div>
    </g:if>
  </body>
</html>
