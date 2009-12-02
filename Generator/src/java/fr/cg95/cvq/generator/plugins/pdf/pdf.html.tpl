<%
  def beginGT() { return ['<','%','\n'].join() }
  def endGT() { return ['\n','%','>'].join() }
  def toGT(s) { return ['<','%',' '].join() + s + [' ', '%','>'].join() }
  
  def displayWidget(element, wrapper) {
     
    def widgets = [
      'boolean' : 
          """
          <div class="response choice">
            ${toGT('[true,false].each {')}
              <span \${it == ${wrapper}.${element.javaFieldName} ? 'class="checked"': ''}>
                \${i18n.translate('message.' + (it ? 'yes' : 'no'))}
              </span>
              \${it ? ' / ' : ''}
            ${toGT('}')}
          </div>
          """
      ,'pick' :
          """
          <div class="response">
            ${toGT("if(${wrapper}.${element.javaFieldName}) {")}
              \${i18n.translate('${element.i18nPrefixCode}.' + StringUtils.uncapitalize(${wrapper}.${element.javaFieldName}.toString()))}
            ${toGT('}')}
          </div>
          """
      ,'choice' :
          """
          <div class="response choice">
            ${toGT(element.enumValuesAsString + '.each {')}
              <span \${it == ${wrapper}.${element.javaFieldName}.toString() ? 'class="checked"': ''}>
                \${i18n.translate('${element.i18nPrefixCode}.' + StringUtils.uncapitalize(it))}
              </span> / 
            ${toGT('}')}
          </div>
          """
      ,'address' :
          """
          <div class="response">
            ${toGT("if(${wrapper}.${element.javaFieldName}) {")}
              <p>\${${wrapper}.${element.javaFieldName}?.additionalDeliveryInformation}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.additionalGeographicalInformation}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.streetNumber} \${${wrapper}.${element.javaFieldName}?.streetName}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.placeNameOrService}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.postalCode} \${${wrapper}.${element.javaFieldName}?.city}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.countryName}</p>
            ${toGT('}')}
          </div>
          """
      ,'localReferentialData' :
          """
          <div class="response choice">
            ${toGT("localReferentialWidget(rqt, '${element.javaFieldName}', lrTypes.${element.javaFieldName}.entries, 0)")}
          </div>
          """
      ,'date' :
          """
          <div class="response">\${${wrapper}.${element.javaFieldName}}</div>
          """
      ,'text' :
          """<div class="response">\${${wrapper}.${element.javaFieldName}?.toString()}</div>"""
      ,'subject' :
          """
           <div class="response">\${subject?.fullName}</div>
          """
      ,'requester' :
          """
          <p class="label">
            \${i18n.translate('homeFolder.adult.property.title')}
            \${i18n.translate('homeFolder.individual.property.firstName')}
            \${i18n.translate('homeFolder.individual.property.lastName')}
          </p>
          <div class="response">
            ${toGT('if(requester?.title) {')}
              \${i18n.translate('homeFolder.adult.title.' + StringUtils.uncapitalize(requester?.title.toString()))}
            ${toGT('}')}
            \${requester?.firstName}
            \${requester?.lastName}
          </div>
          <p class="label">\${i18n.translate('homeFolder.individual.property.address')}</p>
          <div class="response">
            ${toGT('if (requester?.adress) {')}
              <p>\${requester?.adress?.additionalDeliveryInformation}</p>
              <p>\${requester?.adress?.additionalGeographicalInformation}</p>
              <p>\${requester?.adress?.streetNumber} \${requester?.adress?.streetName}</p>
              <p>\${requester?.adress?.placeNameOrService}</p>
              <p>\${requester?.adress?.postalCode} \${requester?.adress?.city}</p>
              <p>\${requester?.adress?.countryName}</p>
            ${toGT('}')}
          </div>
          <p class="label">\${i18n.translate('homeFolder.adult.property.email')}</p>
          <div class="response">\${requester?.email}</div>
          <p class="label">\${i18n.translate('homeFolder.adult.property.homePhone')}</p>
          <div class="response">\${requester?.homePhone}</div>
          """
      ,'label' :
          """<p class="label">\${i18n.translate('${element.i18nPrefixCode}.label')}</p>"""
      ,'acceptance' :
          """
          <div class="response choice">
            ${toGT('[true,false].each {')}
              <span \${it == ${wrapper}.${element.javaFieldName} ? 'class="checked"': ''}>
                \${i18n.translate('message.' + (it ? 'yes' : 'no'))}
              </span>
              \${it ? ' / ' : ''}
            ${toGT('}')}
          </div>
          """
    ]
    
    def output = (element.widget != 'requester' ?  widgets['label'] : '')
    if (widgets[element.widget] != null) output += widgets[element.widget]
    else output += widgets['text']
    println output
  }
%>

${beginGT()}
  import org.apache.commons.lang.StringUtils
  
  def localReferentialWidget(rqt, javaName, lrEntries, depth) {
    def lrHtml = ''
    def currentLrDatas = rqt[javaName].collect{it.name}
    if (lrTypes[javaName].entriesSupportMultiple) { 
      lrHtml += "<ul \${depth==0 ? 'class=\"dataTree\"' : ''}>"
      lrEntries.each { entry -> 
      if (entry.entries) { 
        lrHtml += "<li>"
        lrHtml += "<em>\${entry.labelsMap.fr} :</em>"
        lrHtml += localReferentialWidget(rqt, javaName, entry.entries,++depth)
        lrHtml += "</li>"
      } else {
         lrHtml += "<li><span \${currentLrDatas?.contains(entry.key) ? 'class=\"checked\"' : ''}>\${entry.labelsMap.fr}</span></li>"
      } 
    } 
    lrHtml += "</ul>"
    } else { 
      lrEntries.each { entry -> 
        lrHtml += "\${currentLrDatas?.contains(entry.key) ? entry.labelsMap.fr: ''}"
      } 
    }
    println lrHtml
  }
${endGT()}
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <title>\${i18n.translate('${requestPdf.acronym}.label')}</title>
  <link href="certificate.css" type="text/css" rel="stylesheet" media="print" />
</head>
<body>
  <img src="mairie2424.png" alt="mairie2424" />
  <h1>\${i18n.translate('${requestPdf.acronym}.label')}</h1>
<% requestPdf.steps.each { step -> %>
  <% if (['validation','document'].contains(step.name)) return; %>
  <h2>\${i18n.translate('${requestPdf.acronym}.step.${step.name}.label')}</h2>
  <% requestPdf.getElementsByStep(step).each { element -> %>
    <% if (element.typeClass == "COLLECTION") { %>
      <h3>\${i18n.translate('${element.i18nPrefixCode}.label')}</h3>
      <div class="complex">
      ${toGT('\${rqt.${element.javaFieldName}}.each { it ->')}
      <% element.elements.each { subElement -> %>
        <% displayWidget(subElement, "it") %>
      <% } %>
      </div>
    ${toGT('}')}
    <% } else if (element.typeClass == "COMPLEX") { %>
      <h3>\${i18n.translate('${element.i18nPrefixCode}.label')}</h3>
      <div class="complex">
        <% element.elements.each { subElement -> %>
          <% displayWidget(subElement, "rqt") %>
        <% } %>
      </div>
    <% } else { %>
      <% displayWidget(element, "rqt") %>
    <% } %>
  <% } %>
<% } %>
</body>
</html>

