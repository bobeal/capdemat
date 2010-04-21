<%
  def beginGT() { return ['<','%','\n'].join() }
  def endGT() { return ['\n','%','>'].join() }
  def toGT(s) { return ['<','%',' '].join() + s + [' ', '%','>'].join() }

  fr.cg95.cvq.generator.common.CommonStep.metaClass.i18nPrefix = {
    return "request"
  }

  fr.cg95.cvq.generator.common.CustomStep.metaClass.i18nPrefix = {
    return requestPdf.acronym
  }

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
            ${toGT(element.enumValuesAsString + '.eachWithIndex {it, i ->')}
              <span \${it == ${wrapper}.${element.javaFieldName}.toString() ? 'class="checked"': ''}>
                \${i18n.translate('${element.i18nPrefixCode}.' + StringUtils.uncapitalize(it))}
              </span>\${i + 1 < ${element.enumValuesAsString}?.size() ? ', ' : ''}
            ${toGT('}')}
          </div>
          """
      ,'address' :
          """
          <div class="response">
            ${toGT("if(${wrapper}.${element.javaFieldName}) {")}
              <p>\${StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.additionalDeliveryInformation)}</p>
              <p>\${StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.additionalGeographicalInformation)}</p>
              <p>\${StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.streetNumber)} \${StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.streetName)}</p>
              <p>\${StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.placeNameOrService)}</p>
              <p>\${StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.postalCode)} \${StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.city)}</p>
              <p>\${StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.countryName)}</p>
            ${toGT('}')}
          </div>
          """
      ,'frenchRIB' :
          """
          <div class="response">
            ${toGT("if(${wrapper}.${element.javaFieldName}) {")}
              <p>
                \${${wrapper}.${element.javaFieldName}?.bankCode}
                \${${wrapper}.${element.javaFieldName}?.counterCode}
                \${${wrapper}.${element.javaFieldName}?.accountNumber}
                \${${wrapper}.${element.javaFieldName}?.accountKey}
              </p>
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
          <div class="response">\${${wrapper}.${element.javaFieldName} ? String.format('%td/%<tm/%<tY',${wrapper}.${element.javaFieldName}) : ''}</div>
          """
      ,'text' :
          """<div class="response">\${StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.toString())}</div>"""
      ,'subject' :
          """
           <div class="response">\${subject?.fullName}</div>
          """
      ,'school' :
          """
           <div class="response">\${${wrapper}.${element.javaFieldName}?.name}</div>
          """
      ,'recreationCenter' :
          """
           <div class="response">\${${wrapper}.${element.javaFieldName}?.name}</div>
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
              <p>\${StringUtils.defaultString(requester?.adress?.additionalDeliveryInformation)}</p>
              <p>\${StringUtils.defaultString(requester?.adress?.additionalGeographicalInformation)}</p>
              <p>\${StringUtils.defaultString(requester?.adress?.streetNumber)} \${StringUtils.defaultString(requester?.adress?.streetName)}</p>
              <p>\${StringUtils.defaultString(requester?.adress?.placeNameOrService)}</p>
              <p>\${StringUtils.defaultString(requester?.adress?.postalCode)} \${StringUtils.defaultString(requester?.adress?.city)}</p>
              <p>\${StringUtils.defaultString(requester?.adress?.countryName)}</p>
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
      lrEntries.eachWithIndex { entry, i -> 
      if (entry.entries) { 
        lrHtml += "<li>"
        lrHtml += "<em>\${entry.labelsMap.fr} :</em>"
        lrHtml += localReferentialWidget(rqt, javaName, entry.entries,++depth)
        lrHtml += "</li>"
      } else {
         lrHtml += "<li><span \${currentLrDatas?.contains(entry.key) ? 'class=\"checked\"' : ''}>\${entry.labelsMap.fr}</span>\${i + 1 < lrEntries.size() ? ',' : ''}</li>"
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
  <link href="file://\${cssPath}" type="text/css" rel="stylesheet" media="print" />
</head>
<body>
  <div id="hd">
    <p>\${localAuthority.displayTitle}</p>
    <img src="file://\${logoPath}" alt="mairie2424" />
  </div>
  <h1>\${i18n.translate('${requestPdf.acronym}.label')}</h1>
  <div class="localAuthority">
    <h2>\${i18n.translate('pdf.localAutorityReservedSection')}</h2>
    <ul>
      <li>\${i18n.translate('property.creationDate')} : <strong>\${String.format('%td/%<tm/%<tY',rqt.creationDate)}</strong></li>
      <li>\${i18n.translate('property.requester')} : <strong>\${rqt.requesterFirstName +' '+ rqt.requesterLastName}</strong></li>
      <li>\${i18n.translate('pdf.requestId')} : <strong>\${rqt.id}</strong></li>
      <li>\${i18n.translate('pdf.agentId')} : <strong>\${rqt.lastInterveningUserId != null ? rqt.lastInterveningUserId : ''}</strong></li>
    </ul>
  </div>
<% requestPdf.steps.each { step -> %>
  <% if (requestPdf.getElementsByStep(step).isEmpty()) return %>
  <h2>\${i18n.translate('${step.i18nPrefix()}.step.${step.name}.label')}</h2>
  <% requestPdf.getElementsByStep(step).each { element -> %>
    <% if (element.typeClass == "COLLECTION") { %>
      <h3>\${i18n.translate('${element.i18nPrefixCode}.label')}</h3>
      <div class="complex">
      ${toGT('rqt.'+ element.javaFieldName +'.each { collectionIt ->')}
      <% element.elements.each { subElement -> %>
        <% displayWidget(subElement, "collectionIt") %>
      <% } %>
      ${toGT('}')}
      </div>    
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
  <h2>\${i18n.translate('contact.property.meansOfContact')}</h2>
  <div class="response choice">
    ${toGT('if (rqt.meansOfContact) {')}
      ${toGT('rqt.meansOfContact.type.allMeansOfContactEnums.eachWithIndex {it, i ->')}
        <span \${it == rqt.meansOfContact.type ? 'class=\"checked\"': ''}>
          \${i18n.translate('request.meansOfContact.' + StringUtils.uncapitalize(it.toString()))}
        </span>\${i + 1 < rqt.meansOfContact.type.allMeansOfContactEnums.length ? ', ' : ''}
      ${toGT('}')}
    ${toGT('} else {')}
      <span class="checked">\${i18n.translate('request.meansOfContact.none')}</span>
    ${toGT('}')}
  </div>
</body>
</html>

