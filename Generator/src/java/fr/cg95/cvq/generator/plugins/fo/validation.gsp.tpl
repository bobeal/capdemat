<% 
  def displayWidget(element, wrapper) {
     
    def widgets = [
      'boolean' : 
          """
          <dd><g:message code="message.\${${wrapper}.${element.javaFieldName} ? 'yes' : 'no'}" /></dd>
          """
      ,'radio' :
          """
          <dd>
            <g:if test="\${${wrapper}.${element.javaFieldName}}">
              <g:capdematEnumToField var="\${${wrapper}.${element.javaFieldName}}" i18nKeyPrefix="${element.i18nPrefixCode}" />
            </g:if>
          </dd>
          """
      ,'select' :
          """
          <dd>
            <g:if test="\${${wrapper}.${element.javaFieldName}}">
              <g:capdematEnumToField var="\${${wrapper}.${element.javaFieldName}}" i18nKeyPrefix="${element.i18nPrefixCode}" />
            </g:if>
          </dd>
          """
      ,'address' :
          """
          <dd>
          <g:if test="\${${wrapper}.${element.javaFieldName}}">
              <p>\${${wrapper}.${element.javaFieldName}?.additionalDeliveryInformation}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.additionalGeographicalInformation}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.streetNumber} \${${wrapper}.${element.javaFieldName}?.streetName}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.placeNameOrService}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.postalCode} \${${wrapper}.${element.javaFieldName}?.city}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.countryName}</p>
          </g:if>
          </dd>
          """
      ,'localReferentialData' :
          """
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'${element.javaFieldName}', 'lrEntries': lrTypes.${element.javaFieldName}.entries, 'depth':0]" />
          </dd>
          """
      ,'date' :
          """
          <dd><g:formatDate formatName="format.date" date="\${${wrapper}.${element.javaFieldName}}"/></dd>
          """
      ,'text' :
          """<dd>\${${wrapper}.${element.javaFieldName}?.toString()}</dd>"""
      ,'subject' :
          """<dd>\${subjects.get(rqt.subjectId)}</dd>"""
      ,'requester' :
          """
          <g:render template="/frontofficeRequestType/widget/requesterSummary" model="['requester':requester]" />
          """
      ,'label' :
          """<dt><g:message code="${element.i18nPrefixCode}.label" /></dt>"""
      ,'acceptance' :
          """
          <dd><g:message code="message.\${${wrapper}.${element.javaFieldName} ? 'yes' : 'no'}" /></dd>
          """
    ]
    
    def output = (element.widget != 'requester' ?  widgets['label'] : '')
    if (widgets[element.widget] != null) output += widgets[element.widget]
    else output += widgets['text']
    println output
  }
%>

<% stepBundle.each { step -> %>
  <% if (step.name == 'document') { %>
  <g:if test="\${!documentTypes.isEmpty()}">
    <h3>\${message(code:'request.step.document.label')}</h3>
    <g:each in="\${documentTypes}" var="documentType">
      <h4>\${message(code:documentType.value.name)}</h4>
      <g:if test="\${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="\${documentType.value.associated}" var="document">
        <dt>
          <g:if test="\${document.ecitizenNote}">\${message(code:'document.header.description')} : \${document.ecitizenNote}<br/></g:if>
          <g:if test="\${document.endValidityDate}">\${message(code:'document.header.expireOn')} \${formatDate(date:document.endValidityDate,formatName:'format.date')}</g:if>
        </dt>
        <dd>
          <g:if test="\${document.isNew}"><span class="tag-state tag-new">\${message(code:'document.header.new')}</span>
            <a href="\${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}?isRequestCreation=true&sessionUuid=\${uuidString}" target="blank" title="\${message(code:'document.message.preview.longdesc')}">\${message(code:'document.message.preview')}</a>
          </g:if>
          <g:else>
            <a href="\${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="\${message(code:'document.message.preview.longdesc')}">\${message(code:'document.message.preview')}</a>
          </g:else>
          </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        \${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  <% } else if (step.name != 'validation') { %>
    <h3><g:message code="${requestFo.acronym}.step.${step.name}.label" /></h3>
    <% requestFo.getElementsByStep(step).each { element -> %>
      <% if (element.typeClass == "COLLECTION") { %>
      <h4><g:message code="${element.i18nPrefixCode}.label" /></h4>
      <g:each var="it" in="\${rqt.${element.javaFieldName}}" status="index">
      <dl>
        <% element.elements.each { subElement -> %>
          <% displayWidget(subElement, "it") %>
        <% } %>
      </dl>
      </g:each>
      <% } else if (element.typeClass == "COMPLEX") { %>
      <h4><g:message code="${element.i18nPrefixCode}.label" /></h4>
      <dl>
        <% element.elements.each { subElement -> %>
          <% displayWidget(subElement, "rqt") %>
        <% } %>
      </dl>
      <% } else { %>
      <dl>
        <% displayWidget(element, "rqt") %>
      </dl>
      <% } %>
    <% } %>
  <% } %>
<% } %>

