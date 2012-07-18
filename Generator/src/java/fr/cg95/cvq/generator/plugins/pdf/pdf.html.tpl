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
              <span \${it == ${wrapper}.${element.javaFieldName} ? 'class="checked"': 'class="unchecked"'}>
                \${esc(i18n.translate('message.' + (it ? 'yes' : 'no')))}
              </span>
            ${toGT('}')}
          </div>
          """
      ,'pick' :
          """
          <div class="response">
            ${toGT("if(${wrapper}.${element.javaFieldName}) {")}
              \${esc(i18n.translate('${element.i18nPrefixCode}.' + EnumTool.toLowerCamelCase(${wrapper}.${element.javaFieldName}.toString())))}
            ${toGT('}')}
          </div>
          """
      ,'choice' :
          """
          <div class="response choice">
            ${toGT(element.enumValuesAsString + '.eachWithIndex {it, i ->')}
              <span \${it == ${wrapper}.${element.javaFieldName}.legacyLabel ? 'class="checked"': 'class="unchecked"'}>
                \${esc(i18n.translate('${element.i18nPrefixCode}.' + StringUtils.uncapitalize(it)))}
              </span>
            ${toGT('}')}
          </div>
          """
      ,'address' :
          """
          <div class="response">
            ${toGT("if(${wrapper}.${element.javaFieldName}) {")}
              <p>\${esc(StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.additionalDeliveryInformation))}</p>
              <p>\${esc(StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.additionalGeographicalInformation))}</p>
              <p>\${esc(StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.streetNumber))} \${esc(StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.streetName))}</p>
              <p>\${esc(StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.placeNameOrService))}</p>
              <p>\${esc(StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.postalCode))} \${esc(StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.city))}</p>
              <p>\${esc(StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.countryName))}</p>
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
      ,'bankAccount' :
          """
          <div class="response">
            ${toGT("if(${wrapper}.${element.javaFieldName}) {")}
              <p>
                \${${wrapper}.${element.javaFieldName}?.BIC}
                \${${wrapper}.${element.javaFieldName}?.IBAN}
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
      ,'time' :
          """
          <div class="response">
            \${${wrapper}.${element.javaFieldName} ? ${wrapper}.${element.javaFieldName}.getHourOfDay() : ''} :
            \${${wrapper}.${element.javaFieldName} && ${wrapper}.${element.javaFieldName}.getMinuteOfHour() < 10 ? '0' : ''}\${${wrapper}.${element.javaFieldName} ? ${wrapper}.${element.javaFieldName}.getMinuteOfHour() : ''}
          </div>
          """
      ,'text' :
          """<div class="response">\${esc(StringUtils.defaultString(${wrapper}.${element.javaFieldName}?.toString()))}</div>"""
      ,'number' :
          "<div class=\"response\">\${esc(StringUtils.defaultString(NumberFormat.getInstance().format((${wrapper}.${element.javaFieldName})?.doubleValue()?: 0).toString()))}</div>"
      ,'subject' :
          """
          <p class="label">\${esc(i18n.translate('${requestPdf.acronym}.property.subject.label'))}</p>
          <div class="response">\${esc(subjectIsChild && !subject?.born ? i18n.translate('request.subject.childNoBorn', subject?.fullName) : subject?.fullName)}</div>
          """
      ,'school' :
          """
           <div class="response">\${esc((${wrapper}.${element.javaFieldName}?.name != null)?${wrapper}.${element.javaFieldName}?.name : ' ')}</div>
          """
      ,'recreationCenter' :
          """
           <div class="response">\${esc((${wrapper}.${element.javaFieldName}?.name != null)?${wrapper}.${element.javaFieldName}?.name : ' ')}</div>
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
              \${i18n.translate('homeFolder.adult.title.' + StringUtils.lowerCase(requester?.title.toString()))}
            ${toGT('}')}
            \${esc(requester?.firstName)}
            \${esc(requester?.lastName)}
          </div>
          <p class="label">\${i18n.translate('homeFolder.individual.property.address')}</p>
          <div class="response">
            ${toGT('if (requester?.address) {')}
              <p>\${esc(StringUtils.defaultString(requester?.address?.additionalDeliveryInformation))}</p>
              <p>\${esc(StringUtils.defaultString(requester?.address?.additionalGeographicalInformation))}</p>
              <p>\${esc(StringUtils.defaultString(requester?.address?.streetNumber))} \${esc(StringUtils.defaultString(requester?.address?.streetName))}</p>
              <p>\${esc(StringUtils.defaultString(requester?.address?.placeNameOrService))}</p>
              <p>\${esc(StringUtils.defaultString(requester?.address?.postalCode))} \${esc(StringUtils.defaultString(requester?.address?.city))}</p>
              <p>\${esc(StringUtils.defaultString(requester?.address?.countryName))}</p>
            ${toGT('}')}
          </div>
          <p class="label">\${i18n.translate('homeFolder.adult.property.email')}</p>
          <div class="response">\${esc(StringUtils.defaultString(requester?.email))}</div>
          <p class="label">\${i18n.translate('homeFolder.adult.property.homePhone')}</p>
          <div class="response">\${esc(StringUtils.defaultString(requester?.homePhone))}</div>
          <p class="label">\${i18n.translate('homeFolder.adult.property.mobilePhone')}</p>
          <div class="response">\${esc(StringUtils.defaultString(requester?.mobilePhone))}</div>
          <p class="label">\${i18n.translate('homeFolder.adult.property.officePhone')}</p>
          <div class="response">\${esc(StringUtils.defaultString(requester?.officePhone))}</div>
          """
      ,'label' :
          """<p class="label">\${esc(i18n.translate('${element.i18nPrefixCode}.label'))}</p>"""
      ,'acceptance' :
          """
          <div class="response choice">
            ${toGT('[true,false].each {')}
              <span \${it == ${wrapper}.${element.javaFieldName} ? 'class="checked"': 'class="unchecked"'}>
                \${i18n.translate('message.' + (it ? 'yes' : 'no'))}
              </span>
            ${toGT('}')}
          </div>
          """
      ,'family' :
          """
          ${toGT('if (rqt.requestType.getStepAccountCompletion()){')}
              <h2>\${i18n.translate('pdf.homeFolder.label')}</h2>

            ${toGT('firstChild = true')}

            ${toGT('responsibleId = requester.getHomeFolder().getIndividuals().findAll{ it.getHomeFolderRoles(requester.getHomeFolder().getId()).findAll{ it.getRole() == fr.cg95.cvq.business.users.RoleType.HOME_FOLDER_RESPONSIBLE }.size() > 0 }.get(0).getId() ')}

            ${toGT('list = requester.getHomeFolder().getIndividuals().findAll{ !(it.getState().name.equals("Archived") || it.getState().name.equals("Invalid"))}.sort{a,b -> a.getClass() == fr.cg95.cvq.business.users.Adult.class ? (a.getId() == responsibleId ? -1 : 0) : 1 } ')}

            ${toGT('list.each { individual ->')}

              ${toGT('if (individual.getClass() == fr.cg95.cvq.business.users.Adult.class) {')}

                ${toGT('if (individual.getId() == responsibleId) {')}
                  <h3>\${i18n.translate('homeFolder.property.responsible')}</h3>
                ${toGT('}')}

                ${toGT('if (list.indexOf(individual) == 1) {')}
                  <h3>\${i18n.translate('homeFolder.property.adults')}</h3>
                ${toGT('}')}

                <p class="label">
                  \${i18n.translate('homeFolder.adult.property.title')}
                  \${i18n.translate('homeFolder.individual.property.firstName')}
                  \${i18n.translate('homeFolder.individual.property.lastName')}
                </p>
                <div class="response">
                  ${toGT('if(individual?.title) {')}
                    \${i18n.translate('homeFolder.adult.title.' + StringUtils.lowerCase(individual?.title.toString()))}
                  ${toGT('}')}
                  \${esc(individual?.firstName)}
                  \${esc(individual?.lastName)}
                </div>
                <p class="label">\${i18n.translate('homeFolder.individual.property.address')}</p>
                <div class="response">
                  ${toGT('if (individual?.address) {')}
                    <p>\${esc(StringUtils.defaultString(individual?.address?.additionalDeliveryInformation))}</p>
                    <p>\${esc(StringUtils.defaultString(individual?.address?.additionalGeographicalInformation))}</p>
                    <p>\${esc(StringUtils.defaultString(individual?.address?.streetNumber))} \${esc(StringUtils.defaultString(individual?.address?.streetName))}</p>
                    <p>\${esc(StringUtils.defaultString(individual?.address?.placeNameOrService))}</p>
                    <p>\${esc(StringUtils.defaultString(individual?.address?.postalCode))} \${esc(StringUtils.defaultString(individual?.address?.city))}</p>
                    <p>\${esc(StringUtils.defaultString(individual?.address?.countryName))}</p>
                  ${toGT('}')}
                </div>

                ${toGT('if (individual?.email) {')}
                  <p class="label">\${i18n.translate('homeFolder.adult.property.email')}</p>
                  <div class="response">\${esc(StringUtils.defaultString(individual?.email))}</div>
                ${toGT('}')}
                ${toGT('if (individual?.homePhone) {')}
                  <p class="label">\${i18n.translate('homeFolder.adult.property.homePhone')}</p>
                  <div class="response">\${esc(StringUtils.defaultString(individual?.homePhone))}</div>
                ${toGT('}')}
                ${toGT('if (individual?.mobilePhone) {')}
                  <p class="label">\${i18n.translate('homeFolder.adult.property.mobilePhone')}</p>
                  <div class="response">\${esc(StringUtils.defaultString(individual?.mobilePhone))}</div>
                ${toGT('}')}
                ${toGT('if (individual?.officePhone) {')}
                  <p class="label">\${i18n.translate('homeFolder.adult.property.officePhone')}</p>
                  <div class="response">\${esc(StringUtils.defaultString(individual?.officePhone))}</div>
                ${toGT('}')}
                <hr />
              ${toGT('}')}


              ${toGT('if (individual.getClass() == fr.cg95.cvq.business.users.Child.class) {')}

                ${toGT('if (firstChild){')}
                  <h3>\${i18n.translate('homeFolder.property.children')}</h3>
                ${toGT('firstChild=false }')}

                <p class="label">
                  \${i18n.translate('homeFolder.individual.property.firstName')}
                  \${i18n.translate('homeFolder.individual.property.lastName')}
                </p>
                <div class="response">
                  \${esc(individual?.firstName)}
                  \${esc(individual?.lastName)}
                </div>

                ${toGT('if (individual?.isBorn()) {')}
                  <p class="label">\${i18n.translate('homeFolder.individual.property.birthDate')}</p>
                ${toGT('} else {')}
                  <p class="label">\${i18n.translate('homeFolder.individual.property.expectedBirthDate')}</p>
                ${toGT('}')}
                <div class="response">
                  \${String.format('%td/%<tm/%<tY',individual?.getBirthDate())}
                </div>

                <p class="label">\${i18n.translate('homeFolder.child.property.sex')}</p>
                <div class="response">
                  \${i18n.translate('homeFolder.child.property.sex.'+StringUtils.lowerCase(individual?.getSex().getLegacyLabel()))}
                </div>

                <p class="label">\${i18n.translate('homeFolder.child.property.legalResponsibles')}</p>

                <div class="response">

                ${toGT('requester.getHomeFolder().getIndividuals().each { indiv_2 -> ')}
                  ${toGT('if (indiv_2.getClass() == fr.cg95.cvq.business.users.Adult.class) {')}
                    ${toGT('indiv_2.getIndividualRoles().each{ indRole ->')}
                      ${toGT('if((indRole.getRole().getLegacyLabel().equals("ClrMother") || indRole.getRole().getLegacyLabel().equals("ClrFather") || indRole.getRole().getLegacyLabel().equals("ClrTutor") || indRole.getRole().getLegacyLabel().equals("Tutor")) && indRole.getIndividualId() == individual.getId()){')}

                          \${esc(indiv_2?.firstName)}
                          \${esc(indiv_2?.lastName)}

                      ${toGT('}')}
                    ${toGT('}')}
                  ${toGT('}')}
                ${toGT('}')}
                </div>
                <hr />

              ${toGT('}')}
            ${toGT('}')}
          ${toGT('}')}
          """
    ]

    def output

    switch (element.widget) {
      case ['requester', 'subject', 'family']:
        output = widgets[element.widget]
        break
      case ['decimal', 'double', 'float']:
        output = widgets['label'] + widgets['number']
        break
      default:
        output = widgets['label']
        output += (widgets[element.widget] != null) ? widgets[element.widget] : widgets['text']
        break
    }

    println output
  }
%>

${beginGT()}
  import org.apache.commons.lang.StringUtils
  import fr.cg95.cvq.util.EnumTool
  import java.text.NumberFormat
  import fr.cg95.cvq.business.users.RoleType
  import fr.cg95.cvq.business.users.IndividualRole

  def esc(s) { return org.apache.commons.lang3.StringEscapeUtils.escapeXml(s) }
  def localReferentialWidget(rqt, javaName, lrEntries, depth) {
    def currentLrDatas = rqt[javaName].collect{it.name}
    if (lrEntries.any{it.entries}) {
      println "<ul \${depth==0 ? 'class=\"dataTree\"' : ''}>"
      
      lrEntries.each { entry ->
        println "<li>"
        if (entry.entries) {
          println "<em \${currentLrDatas?.contains(entry.key) ? 'class=\"checked\"' : 'class=\"unchecked\"'}>\${entry.label} :</em>"
          localReferentialWidget(rqt, javaName, entry.entries, depth + 1)
        } else {
          println "<span \${currentLrDatas?.contains(entry.key) ? 'class=\"checked\"' : 'class=\"unchecked\"'}>\${entry.label}</span>"
        }
        println "</li>"
      }

      println "</ul>"
    } else {
      lrEntries.eachWithIndex { entry, i ->
        println "<span \${currentLrDatas?.contains(entry.key) ? 'class=\"checked\"' : 'class=\"unchecked\"'}>\${entry.label}</span>"
      }
    }
  }
${endGT()}
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <title>\${esc(i18n.translate('${requestPdf.acronym}.label'))}</title>
  <link href="file://\${cssPath}" type="text/css" rel="stylesheet" media="print" />
</head>
<body>
  <div id="hd">
    <p>\${esc(localAuthority.displayTitle)}</p>
    <img src="file://\${logoPath}" alt="mairie2424" />
  </div>
  <h1>\${esc(i18n.translate('${requestPdf.acronym}.label'))}</h1>
  <div class="localAuthority">
    <h2>\${i18n.translate('pdf.localAutorityReservedSection')}</h2>
    <ul>
      <li>\${i18n.translate('property.creationDate')} : <strong>\${String.format('%td/%<tm/%<tY',rqt.creationDate)}</strong></li>
      <li>\${i18n.translate('property.requester')} : <strong>\${esc(rqt.requesterFirstName +' '+ rqt.requesterLastName)}</strong></li>
      <li>\${i18n.translate('pdf.requestId')} : <strong>\${rqt.id}</strong></li>
      <li>\${i18n.translate('pdf.agentId')} : <strong>\${rqt.lastInterveningUserId != null ? rqt.lastInterveningUserId : ''}</strong></li>
    </ul>
  </div>
  <h2>\${i18n.translate('request.property.requester')}</h2>
  <% displayWidget(['widget':'requester'], "rqt") %>
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
        <span \${it == rqt.meansOfContact.type ? 'class=\"checked\"': 'class=\"unchecked\"'}>
          \${i18n.translate('meansOfContact.' + StringUtils.uncapitalize(it.legacyLabel))}
        </span>
      ${toGT('}')}
    ${toGT('} else {')}
      <span class="checked">\${i18n.translate('meansOfContact.none')}</span>
    ${toGT('}')}
  </div>

  <% displayWidget(['widget':'family'], "rqt") %>

</body>
</html>

