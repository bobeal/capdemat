<%
  def toGroovyTemplate(s) {
    return ['<','%',' '].join() + s + [' ', '%','>'].join()
  }
  
  def displayWidget(element, wrapper) {
     
    def widgets = [
      'boolean' : 
          """
          <dd>\${i18n.translate('message.\${${wrapper}.${element.javaFieldName} ? 'yes' : 'no'}')}</dd>
          """
      ,'check' :
          """
          <dd>
            ${toGroovyTemplate('if (' + wrapper + '.' + element.javaFieldName + ') {')}
              \${i18n.translate('${element.i18nPrefixCode}.' + ${wrapper}.${element.javaFieldName})}
            ${toGroovyTemplate('}')}
          </dd>
          """
      ,'address' :
          """
          <dd>
            ${toGroovyTemplate('if (' + wrapper + '.' + element.javaFieldName + ') {')}
              <p>\${${wrapper}.${element.javaFieldName}?.additionalDeliveryInformation}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.additionalGeographicalInformation}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.streetNumber} \${${wrapper}.${element.javaFieldName}?.streetName}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.placeNameOrService}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.postalCode} \${${wrapper}.${element.javaFieldName}?.city}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.countryName}</p>
            ${toGroovyTemplate('}')}
          </dd>
          """
      ,'localReferentialData' :
          """
          <dd>
            LOCAL REFERENTIAL TODO
          </dd>
          """
      ,'date' :
          """
          <dd>\${${wrapper}.${element.javaFieldName}}</dd>
          """
      ,'text' :
          """<dd>\${${wrapper}.${element.javaFieldName}?.toString()}</dd>"""
      ,'subject' :
          """<dd>\${subjects.get(rqt.subjectId)}</dd>"""
      ,'requester' :
          """
          REQUESTER TODO
          """
      ,'label' :
          """<dt>\${i18n.translate('${element.i18nPrefixCode}.label')}</dt>"""
      ,'acceptance' :
          """
          <dd>\${i18n.translate('message.\${${wrapper}.${element.javaFieldName} ? 'yes' : 'no'}')}</dd>
          """
    ]
    
    def output = (element.widget != 'requester' ?  widgets['label'] : '')
    if (widgets[element.widget] != null) output += widgets[element.widget]
    else output += widgets['text']
    println output
  }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <title>\${i18n.translate('${requestPdf.acronym}.label')}</title>
  <link href="certificate.css" type="text/css" rel="stylesheet"></link>
</head>
<body>
  <h1>\${i18n.translate('${requestPdf.acronym}.label')}</h1>
<% requestPdf.steps.each { step -> %>
  <% if (['validation','document'].contains(step.name)) return; %>
  <h2>\${i18n.translate('${requestPdf.acronym}.step.${step.name}.label')}</h2>
  <% requestPdf.getElementsByStep(step).each { element -> %>
    <% if (element.typeClass == "COLLECTION") { %>
    <h3>\${i18n.translate('${element.i18nPrefixCode}.label')}</h3>
    ${toGroovyTemplate('\${rqt.${element.javaFieldName}}.each { it ->')}
      <dl>
        <% element.elements.each { subElement -> %>
          <% displayWidget(subElement, "it") %>
        <% } %>
      </dl>
    ${toGroovyTemplate('}')}
    <% } else if (element.typeClass == "COMPLEX") { %>
    <h4>\${i18n.translate('${element.i18nPrefixCode}.label')}</h4>
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
</body>
</html>

