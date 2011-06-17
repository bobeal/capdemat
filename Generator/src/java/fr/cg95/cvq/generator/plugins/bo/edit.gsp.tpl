<%
    fr.cg95.cvq.generator.common.CommonStep.metaClass.i18nPrefix = {
        return "request"
    }

    fr.cg95.cvq.generator.common.CustomStep.metaClass.i18nPrefix = {
        return requestBo.acronym
    }
%>
<%
  def displayWidget(element, wrapper) {
    def widgets = [
      'date' :
          "<span><g:formatDate formatName=\"format.date\" date=\"\${${wrapper}?.${element.javaFieldName}}\"/></span>"
      ,'time' : 
          ["<span>\${${wrapper}.${element.javaFieldName}?.getHourOfDay()} : "
          ,"\${${wrapper}.${element.javaFieldName} && ${wrapper}.${element.javaFieldName}.getMinuteOfHour() < 10 ? '0' : ''}"
          ,"\${${wrapper}.${element.javaFieldName}?.getMinuteOfHour()}</span>"
          ].join()
      ,'capdematEnum' :
          "<g:capdematEnumToField var=\"\${${wrapper}?.${element.javaFieldName}}\" i18nKeyPrefix=\"${element.i18nPrefixCode}\" />"
      ,'address' :
          ["<div>"
          ,"<p class=\"additionalDeliveryInformation\">\${${wrapper}?.${element.javaFieldName}?.additionalDeliveryInformation}</p>"
          ,"<p class=\"additionalGeographicalInformation\">\${${wrapper}?.${element.javaFieldName}?.additionalGeographicalInformation}</p>"
          ,"<span class=\"streetNumber\">\${${wrapper}?.${element.javaFieldName}?.streetNumber}</span> "
          ,"<span class=\"streetName\">\${${wrapper}?.${element.javaFieldName}?.streetName}</span>"
          ,"<g:if test=\"\${!!${wrapper}?.${element.javaFieldName}?.streetMatriculation}\"><br /><em><g:message code=\"address.property.streetMatriculation\" /></em><span class=\"streetMatriculation\">\${${wrapper}?.${element.javaFieldName}?.streetMatriculation}</span></g:if>"
          ,"<g:if test=\"\${!!${wrapper}?.${element.javaFieldName}?.streetRivoliCode}\"><br /><em><g:message code=\"address.property.streetRivoliCode\" /></em><span class=\"streetRivoliCode\">\${${wrapper}?.${element.javaFieldName}?.streetRivoliCode}</span></g:if>"
          ,"<p class=\"placeNameOrService\">\${${wrapper}?.${element.javaFieldName}?.placeNameOrService}</p>"
          ,"<span class=\"postalCode\">\${${wrapper}?.${element.javaFieldName}?.postalCode}</span> "
          ,"<span class=\"city\">\${${wrapper}?.${element.javaFieldName}?.city}</span>"
          ,"<p class=\"countryName\">\${${wrapper}?.${element.javaFieldName}?.countryName}</p>"
          ,"<g:if test=\"\${!!${wrapper}?.${element.javaFieldName}?.cityInseeCode}\"><em><g:message code=\"address.property.cityInseeCode\" /></em><span class=\"cityInseeCode\">\${${wrapper}?.${element.javaFieldName}?.cityInseeCode}</span></g:if>"
          ,"</div>"
          ].join()
      ,'frenchRIB' :
          ["<div>"
          ,"<p class=\"bankCode\">\${${wrapper}?.${element.javaFieldName}?.bankCode}</p>"
          ,"<p class=\"counterCode\">\${${wrapper}?.${element.javaFieldName}?.counterCode}</p>"
          ,"<p class=\"accountNumber\">\${${wrapper}?.${element.javaFieldName}?.accountNumber}</p>"
          ,"<p class=\"accountKey\">\${${wrapper}?.${element.javaFieldName}?.accountKey}</p>"
          ,"</div>"
          ].join()
      ,'bankAccount' :
          ["<div>"
          ,"<p>\${${wrapper}?.${element.javaFieldName}?.BIC}</p>"
          ,"<p>\${${wrapper}?.${element.javaFieldName}?.IBAN}</p>"
          ,"</div>"
          ].join()
      ,'boolean' :
          "<span class=\"value-\${${wrapper}?.${element.javaFieldName}}\"><g:message code=\"message.\${${wrapper}?.${element.javaFieldName} ? 'yes' : 'no'}\" /></span>"
      ,'acceptance' :
          "<span class=\"value-\${${wrapper}?.${element.javaFieldName}}\"><g:message code=\"message.\${${wrapper}?.${element.javaFieldName} ? 'yes' : 'no'}\" /></span>"
      ,'localReferentialData' :
          """
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'${element.javaFieldName}', 'lrEntries': lrTypes.${element.javaFieldName}?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.${element.javaFieldName}?.isMultiple(), 'depth':0]" />
 
          """
      ,'school' :
          """<span class="value-\${${wrapper}?.${element.javaFieldName}?.id}">\${${wrapper}?.${element.javaFieldName}?.name}</span>"""
      ,'recreationCenter' :
          """<span class="value-\${${wrapper}?.${element.javaFieldName}?.id}">\${${wrapper}?.${element.javaFieldName}?.name}</span>"""
      ,'text' :
          "<span>\${${wrapper}?.${element.javaFieldName}}</span>"
      ,'subject' :
          """<dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>\${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          """
      ,'requester' :
          """<g:render template="/backofficeRequestInstruction/requestType/requester" model="['requester':requester]" />"""
    ]
    
    
    def output = ['requester','subject'].contains(element.widget) ? 
            widgets[element.widget] : 
          ["<dt class=\"${element.conditionsClass}\"><g:message code=\"${element.i18nPrefixCode}.label\" /> ${element.mandatory ? '*' : ''} : </dt>"
          ,"<dd id=\"${element.javaFieldName}\" class=\"${element.htmlClass}\" ${element.jsRegexp}>"
          ,(widgets[element.widget] != null ? widgets[element.widget]: widgets['text'])
          ,"</dd>"].join()
          
    print output
  } 
%>

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  <% for(step in requestBo.steps) { %>
    <li class="${step.index == 0 ? 'selected ' :''}${step.name == "administration" ? 'administration ' :''}">
      <a href="#page${step.index}"><em><g:message code="${step.i18nPrefix()}.step.${step.name}.label" /></em></a>
    </li>
  <% } %>
  </ul>
   
  <div class="yui-content">
    <% if(requestBo.stepBundles.size() > 1 ) { %>
      <% requestBo.stepBundles.eachWithIndex { step, i -> %>
        <g:render template="/backofficeRequestInstruction/requestType/${requestBo.name}/steps${i}" model="['rqt':rqt]" />
      <% } %>
    <% } else { %>
      <% for(step in requestBo.steps) { %>
      <!-- step start -->
      <div id="page${step.index}">
        <h2><g:message code="property.form" />
          <span><g:message code="${step.i18nPrefix()}.step.${step.name}.label" /></span>
        </h2>
        <div class="yui-g">
          <% if (step.name == "administration") { %>
            <div class="administration information-message">
              <g:message code="request.step.administration.desc" />
            </div>
          <% } %>
          <% for (column in [1,2]) { %>
          <!-- column start -->
          <div class="yui-u${column == 1 ? ' first' : ''}">
            <% for (element in requestBo.getElementsByStep(step, column)) { %>
              <% if (element.typeClass == "SIMPLE") { %>
              <dl>
                <% displayWidget(element, 'rqt') %>
              </dl>
              <% } else if (element.typeClass == "COMPLEX") { %>
              <h3><g:message code="${element.i18nPrefixCode}.label" /></h3>
              <dl class="${element.conditionsClass}">
                <% for (subElement in element.elements) { %>
                  <% displayWidget(subElement, 'rqt') %>
                <% } %>
              </dl>
              <% } else if (element.typeClass == "COLLECTION") { %>
              <div id="widget-${element.javaFieldName}" class="${element.conditionsClass}">
                <g:render template="/backofficeRequestInstruction/requestType/${requestBo.name}/${element.javaFieldName}" model="['rqt':rqt]" />
              </div>
              <% } %>
            <% } %>
          </div>
          <!-- column end -->
          <% } %>
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      <% } %>
    <% } %>
    
  </div>
  
</div>
