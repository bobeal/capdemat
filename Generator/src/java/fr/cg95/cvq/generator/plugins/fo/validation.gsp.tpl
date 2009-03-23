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
          <g:if test="\${${wrapper}.${element.javaFieldName}}">
            <dd>
              <p>\${${wrapper}.${element.javaFieldName}?.additionalDeliveryInformation}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.additionalGeographicalInformation}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.streetNumber} \${${wrapper}.${element.javaFieldName}?.streetName}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.placeNameOrService}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.postalCode} \${${wrapper}.${element.javaFieldName}?.city}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.countryName}</p>
            </dd>
          </g:if>
          """
      ,'localReferentialData':
          """
          <dd>
          <g:render template="/frontofficeRequestType/localReferentialDatas" model="['javaName':'${element.javaFieldName}', 'lrEntries': localReferentialTypes.${element.javaFieldName}.entries]" />
          </dd>
          """
      ,'date' :
          """
          <dd><g:formatDate formatName="format.date" date="\${${wrapper}.${element.javaFieldName}}"/></dd>
          """
    ]
    
    if (widgets[element.widget] != null)
      print widgets[element.widget]
    else
      print """<dd>\${${wrapper}.${element.javaFieldName}}</dd>"""
  }
%>

<% def displayedSubject = false %>
<% stepBundle.each { step -> %>
  <% if (step.name == 'document') { %>
  <g:if test="\${!documentTypes.isEmpty()}">
    <h3><g:message code="request.step.document.label" /></h3>
    <g:each in="\${documentTypes}" var="documentType">
      <h4>\${message(code:documentType.value.name)}</h4>
      <g:if test="\${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="\${documentType.value.associated}" var="document">
        <dt>
          <g:if test="\${document.ecitizenNote}">description : \${document.ecitizenNote}<br/></g:if>
          <g:if test="\${document.endValidityDate}">expire le \${formatDate(date:document.endValidityDate,formatName:'format.date')}</g:if>
        </dt>
        <dd>
          <g:if test="\${document.isNew}"><span class="tag-state tag-active">nouveau</span></g:if>
          <a href="\${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">aperçu</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        Aucun document joint
      </g:else>
    </g:each>
  </g:if>
  <% } else if (step.name != 'validation') { %>
  <h3><g:message code="${requestFo.acronym}.step.${step.name}.label" /></h3>
  <% } %>
  <% requestFo.getElementsByStep(step).each { element -> %>
    <% if (element.typeClass == "COLLECTION") { %>
    <h4><g:message code="${element.i18nPrefixCode}.label" /></h4>
    <g:each var="it" in="\${rqt.${element.javaFieldName}}" status="index">
    <dl>
      <% element.elements.each { subElement -> %>
      <dt><g:message code="${subElement.i18nPrefixCode}.label" /></dt>
        <% displayWidget(subElement, "it") %>
      <% } %>
    </dl>
    </g:each>
    <% } else if (element.typeClass == "COMPLEX") { %>
    <h4><g:message code="${element.i18nPrefixCode}.label" /></h4>
    <dl>
      <% if (step.name == 'subject' && !displayedSubject) { %>
      <dt><g:message code="request.property.subjectName" /></dt>
      <dd>\${subjects.get(rqt.subjectId)}</dd>
          <% displayedSubject = true %>
      <% } %>
      <% element.elements.each { subElement -> %>
      <dt><g:message code="${subElement.i18nPrefixCode}.label" /></dt>
        <% displayWidget(subElement, "rqt") %>
      <% } %>
    </dl>
    <% } else { %>
      <dl>
      <dt><g:message code="${element.i18nPrefixCode}.label" /></dt>
      <% displayWidget(element, "rqt") %>
      </dl>
    <% } %>
  <% } %>
<% } %>

