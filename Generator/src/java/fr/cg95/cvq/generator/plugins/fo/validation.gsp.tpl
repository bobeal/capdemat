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
<% requestFo.steps.each { step -> %>
  <% if (step.name == 'document') { %>
  <h3><g:message code="request.step.document.label" /></h3>
  <!-- TODO : Render document summary template -->
  <% } else if (step.name != 'validation') { %>
  <h3><g:message code="${requestFo.acronym}.step.${step.name}.label" /></h3>
  <% } %>
  <% requestFo.getElementsByStep(step).each { element -> %>
    <% if (element.typeClass == "COLLECTION") { %>
    <!-- <h4><g:message code="${element.i18nPrefixCode}.label" /></h4> -->
    <!-- TODO : Render one to many elements -->
    <% } else if (element.typeClass == "COMPLEX") { %>
    <h4><g:message code="${element.i18nPrefixCode}.label" /></h4>
    <dl>
      <% if (step.name == 'subject' && !displayedSubject) { %>
      <dt><g:message code="request.property.subjectName" /></dt>
      <dd>\${subjects.get(request.subjectId)}</dd>
          <% displayedSubject = true %>
      <% } %>
      <% element.elements.each { subElement -> %>
      <dt><g:message code="${subElement.i18nPrefixCode}.label" /></dt>
        <% displayWidget(subElement, "request") %>
      <% } %>
    </dl>
    <% } else { %>
      <dt><g:message code="${element.i18nPrefixCode}.label" /></dt>
      <% displayWidget(element, "request") %>
    <% } %>
  <% } %>
<% } %>

