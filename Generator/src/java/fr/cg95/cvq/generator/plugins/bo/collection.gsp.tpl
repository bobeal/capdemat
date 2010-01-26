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

  <g:set var="listSize" value="\${rqt.${element.javaFieldName}.size()}" />
  <h3>
    <a class="addListItem" id="add_${element.javaFieldName}[\${listSize}]"></a>
    <span><g:message code="${element.i18nPrefixCode}.label" /></span>
  </h3>
  <g:each var="it" in="\${rqt.${element.javaFieldName}.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_${element.javaFieldName}[\${listSize - 1 - index}]"></a>
  </div>
  <dl class="${element.conditionsClass}">
    <% for (subElement in element.elements) { %>
      <dt class="${subElement.conditionsClass}"><g:message code="${subElement.i18nPrefixCode}.label" /> ${subElement.mandatory ? '*' : ''} : </dt>
      <dd id="${element.javaFieldName}[\${listSize - 1 - index}].${subElement.javaFieldName}" class="${subElement.htmlClass}" ${subElement.jsRegexp}>
        <% displayWidget(subElement, 'it') %>
      </dd>
    <% } %>
  </dl>
  </g:each>
