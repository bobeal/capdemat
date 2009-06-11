<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  <body>
    <div class="main-box">
      <h2><g:message code="request.header.summary" args="${[requestTypeLabel,rqt.id.toString()]}"/></h2>
      <div class="requestSummary">
        <div id="requestTabView">
          <g:render template="/frontofficeRequestType/${validationTemplateDirectory}/summary" 
          	model="['rqt':rqt]" />
          <g:if test="${requestNotes}">
            <h3><g:message code="request.property.notes" /></h3>
            <dl class="notes">
              <g:each var="requestNote" in="${requestNotes}">
                <dt>
                  <span class="tag-${requestNote.nature}">${requestNote.nature}</span>
                  ${requestNote.user_name}
                </dt>
                <dd>
                  <p class="note">
                    <g:capdematEnumToFlag var="${requestNote.type}" i18nKeyPrefix="request.note.type" />${requestNote.note}
                  </p>
                  <p class="noteMetadata">
                    <g:message code="request.property.note" /> n° <strong>${requestNote.id}</strong>
                    <g:if test="${requestNote.date != null}">
                      <g:message code="request.note.date" /> <strong><g:formatDate formatName="format.fullDate" date="${requestNote.date}"/></strong>
                    </g:if>
                  </p>
                </dd>
              </g:each>
            </dl>
          </g:if>
        </div>
      </div>
    </div>
  </body>
</html>
