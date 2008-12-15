<%
  def displayWidget(element, wrapper) {
    def widgets = [
      'date' : 
          "<span><g:formatDate format=\"dd/MM/yyyy\" date=\"\${${wrapper}.${element.javaFieldName}}\"/></span>"
      ,'capdematEnum' :
          "<g:capdematEnumToField var=\"\${${wrapper}.${element.javaFieldName}}\" i18nKeyPrefix=\"${element.i18nPrefixCode}\" />"
      ,'address' :
          ["<div>"
          ,"<p class=\"additionalDeliveryInformation\">\${${wrapper}.${element.javaFieldName}.additionalDeliveryInformation}</p>"
          ,"<p class=\"additionalGeographicalInformation\">\${${wrapper}.${element.javaFieldName}.additionalGeographicalInformation}</p>"
          ,"<span class=\"streetNumber\">\${${wrapper}.${element.javaFieldName}.streetNumber}</span> "
          ,"<span class=\"streetName\">\${${wrapper}.${element.javaFieldName}.streetName}</span>"
          ,"<p class=\"placeNameOrService\">\${${wrapper}.${element.javaFieldName}.placeNameOrService}</p>"
          ,"<span class=\"postalCode\">\${${wrapper}.${element.javaFieldName}.postalCode}</span> "
          ,"<span class=\"city\">\${${wrapper}.${element.javaFieldName}.city}</span>"
          ,"<p class=\"countryName\">\${${wrapper}.${element.javaFieldName}.countryName}</p>"
          ,"</div>"
          ].join()
    ]
    
    if (widgets[element.widget] != null)
      print widgets[element.widget]
    else
      print "<span>\${${wrapper}.${element.javaFieldName}}</span>"
  } 
%>

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  <% for(step in requestBo.steps) { %>
    <li${step.index == 0 ? ' class="selected"' :'' }>
      <a href="#page${step.index}"><em><g:message code="${requestBo.acronym}.step.${step.name}.label" /></em></a>
    </li>
  <% } %>
  </ul>
   
  <div class="yui-content">
    <% for(step in requestBo.steps) { %>
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
                <dt class="${element.conditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> : </dt>
                <dd id="${element.javaFieldName}" class="${element.htmlClass}" ${element.jsRegexp != null ? 'regex="' + element.jsRegexp + '"' : ''}>
                  <% displayWidget(element, 'request') %>
                </dd>
              </dl>
              <% } else if (element.typeClass == "COMPLEX") { %>
              <h3><g:message code="${element.i18nPrefixCode}.label" /></h3>
              <dl class="${element.conditionsClass}">
                <% for (subElement in element.elements) { %>
                  <dt class="${subElement.conditionsClass}"><g:message code="${subElement.i18nPrefixCode}.label" /> : </dt>
                  <dd id="${subElement.javaFieldName}" class="${subElement.htmlClass}" ${subElement.jsRegexp != null ? 'regex="' + subElement.jsRegexp + '"' : ''}>
                    <% displayWidget(subElement, 'request') %>
                  </dd>
                <% } %>
              </dl>
              <% } else if (element.typeClass == "COLLECTION") { %>
              <h3><g:message code="${element.i18nPrefixCode}.label" /></h3>
              <g:each var="it" in="\${request.${element.javaFieldName}}" status="index">
              <dl class="${element.conditionsClass}">
                <% for (subElement in element.elements) { %>
                  <dt class="${subElement.conditionsClass}"><g:message code="${subElement.i18nPrefixCode}.label" /> : </dt>
                  <dd id="${element.javaFieldName}[\${index}].${subElement.javaFieldName}" class="${subElement.htmlClass}" ${subElement.jsRegexp != null ? 'regex="' + subElement.jsRegexp + '"' : ''}>
                    <% displayWidget(subElement, 'it') %>
                  </dd>
                <% } %>
              </dl>
              </g:each>
              <% } %>
            <% } %>
          </div>
          <!-- column end -->
          <% } %>
        </div>
        <!-- step test end -->
        <% } %>
    </div>
    <!-- step end -->
    <% } %>
    
  </div>
  
</div>
