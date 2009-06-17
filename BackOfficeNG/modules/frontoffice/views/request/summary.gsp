<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  <body>
    <div class="yui-gc">
      <div class="yui-u first summary-box">
        <h2><g:message code="request.header.summary" args="${[requestTypeLabel,rqt.id.toString()]}"/></h2>
        <div class="body">
          <g:render template="/frontofficeRequestType/${validationTemplateDirectory}/summary"
            model="['rqt':rqt]" />
        </div>
      </div>
      <g:if test="${externalInformations}">
        <div class="yui-u summary-box" id="externalInformations">
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
    </div>
    <g:if test="${requestNotes}">
      <div class="main-box" id="requestNotes">
        <h2><g:message code="request.property.notes" /></h2>
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
      </div>
    </g:if>
  </body>
</html>
