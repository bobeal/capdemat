<%
  def displayWidget(element, wrapper) {
    def widgets = [
      'date' : 
          "<span><g:formatDate formatName=\"format.date\" date=\"\${${wrapper}?.${element.javaFieldName}}\"/></span>"
      ,'capdematEnum' :
          "<g:capdematEnumToField var=\"\${${wrapper}?.${element.javaFieldName}}\" i18nKeyPrefix=\"${element.i18nPrefixCode}\" />"
      ,'address' :
          ["<div>"
          ,"<p class=\"additionalDeliveryInformation\">\${${wrapper}?.${element.javaFieldName}?.additionalDeliveryInformation}</p>"
          ,"<p class=\"additionalGeographicalInformation\">\${${wrapper}?.${element.javaFieldName}?.additionalGeographicalInformation}</p>"
          ,"<span class=\"streetNumber\">\${${wrapper}?.${element.javaFieldName}?.streetNumber}</span> "
          ,"<span class=\"streetName\">\${${wrapper}?.${element.javaFieldName}?.streetName}</span>"
          ,"<p class=\"placeNameOrService\">\${${wrapper}?.${element.javaFieldName}?.placeNameOrService}</p>"
          ,"<span class=\"postalCode\">\${${wrapper}?.${element.javaFieldName}?.postalCode}</span> "
          ,"<span class=\"city\">\${${wrapper}?.${element.javaFieldName}?.city}</span>"
          ,"<p class=\"countryName\">\${${wrapper}?.${element.javaFieldName}?.countryName}</p>"
          ,"</div>"
          ].join()
      ,'boolean' :
          "<span class=\"value-\${${wrapper}?.${element.javaFieldName}}\"><g:message code=\"message.\${${wrapper}?.${element.javaFieldName} ? 'yes' : 'no'}\" /></span>"
      ,'text' :
          "<span>\${${wrapper}?.${element.javaFieldName}}</span>"
    ]
    
    if (widgets[element.widget] != null)
      print widgets[element.widget]
    else
      print widgets['text']
  } 
%>

<% for(step in stepBundle) { %>
<!-- step start -->
<div id="page${step.index}">
  <h2><g:message code="property.form" />
    <span><g:message code="${requestBo.acronym}.step.${step.name}.label" /></span>
  </h2>
    <% if (step.name == "requester") { %>
    <g:render template="/backofficeRequestInstruction/requestType/adult" model="['adult':requester, 'action':'no-action']" />
    <% } else { %>
    <div class="yui-g">
      <% for (column in [1,2]) { %>
      <!-- column start -->
      <div class="yui-u${column == 1 ? ' first' : ''}">
        <% for (element in requestBo.getElementsByStep(step, column)) { %>
          <% if (element.typeClass == "SIMPLE") { %>
          <dl>
            <dt class="${element.conditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> ${element.mandatory ? '*' : ''} : </dt>
            <dd id="${element.javaFieldName}" class="${element.htmlClass}" ${element.jsRegexp}>
              <% displayWidget(element, 'request') %>
            </dd>
          </dl>
          <% } else if (element.typeClass == "COMPLEX") { %>
          <h3><g:message code="${element.i18nPrefixCode}.label" /></h3>
          <dl class="${element.conditionsClass}">
            <% for (subElement in element.elements) { %>
              <dt class="${subElement.conditionsClass}"><g:message code="${subElement.i18nPrefixCode}.label" /> ${subElement.mandatory ? '*' : ''} : </dt>
              <dd id="${subElement.javaFieldName}" class="${subElement.htmlClass}" ${subElement.jsRegexp}>
                <% displayWidget(subElement, 'request') %>
              </dd>
            <% } %>
          </dl>
          <% } else if (element.typeClass == "COLLECTION") { %>
          <div id="widget-${element.javaFieldName}">
            <g:render template="/backofficeRequestInstruction/requestType/${requestBo.name}/${element.javaFieldName}" model="['request':request]" />
          </div>
          <% } %>
        <% } %>
      </div>
      <!-- column end -->
      <% } %>
    </div>
    <!-- data step  end -->
    <% } %>
</div>
<!-- step end -->
<% } %>
