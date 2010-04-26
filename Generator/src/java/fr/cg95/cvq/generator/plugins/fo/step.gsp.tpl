<%
  def displayWidget(element, valuePrefix, namePrefix) {
      def IdRefNamePrefix = namePrefix.replace('[','.').replace(']','')
      def widgets = [
        'boolean' : 
            """
            <ul class="yes-no ${element.listenerConditionsClass}">
              <g:each in="\${[true,false]}">
              <li>
                <input type="radio" id="${IdRefNamePrefix}${element.javaFieldName}_\${it ? 'yes' : 'no'}" class="${element.htmlClass}" title="" value="\${it}" name="${namePrefix}${element.javaFieldName}" \${it == ${valuePrefix}.${element.javaFieldName} ? 'checked="checked"': ''} />
                <label for="${IdRefNamePrefix}${element.javaFieldName}_\${it ? 'yes' : 'no'}"><g:message code="message.\${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            """
        ,'radio' :
            """
            <ul class="${element.listenerConditionsClass}">
              <g:each in="\${${element.enumValuesAsString}}">
              <li>
                <input type="radio" id="${IdRefNamePrefix}${element.javaFieldName}_\${it}" class="${element.htmlClass}" value="${element.qualifiedType}_\${it}" name="${namePrefix}${element.javaFieldName}" \${it == ${valuePrefix}.${element.javaFieldName}.toString() ? 'checked="checked"': ''} title="<g:message code="${element.i18nPrefixCode}.validationError" />" />
                <label for="${IdRefNamePrefix}${element.javaFieldName}_\${it}"><g:capdematEnumToText var="\${it}" i18nKeyPrefix="${element.i18nPrefixCode}" /></label>
              </li>
              </g:each>
            </ul>
            """
        ,'select' :
            """
            <select id="${IdRefNamePrefix}${element.javaFieldName}" name="${namePrefix}${element.javaFieldName}" class="${element.htmlClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="\${${element.enumValuesAsString}}">
                <option value="${element.qualifiedType}_\${it}" \${it == ${valuePrefix}.${element.javaFieldName}?.toString() ? 'selected=\"selected\"': ''}><g:capdematEnumToText var="\${it}" i18nKeyPrefix="${element.i18nPrefixCode}" /></option>
              </g:each>
            </select>
            """
        ,'address' :
            """
            <div class="address-fieldset ${element.listenerConditionsClass} ${element.autofillClass}">
            <label for="${IdRefNamePrefix}${element.javaFieldName}.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38" value="\${${valuePrefix}.${element.javaFieldName}?.additionalDeliveryInformation}" maxlength="38" id="${IdRefNamePrefix}${element.javaFieldName}.additionalDeliveryInformation" name="${namePrefix}${element.javaFieldName}.additionalDeliveryInformation" />  
            <label for="${IdRefNamePrefix}${element.javaFieldName}.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38" value="\${${valuePrefix}.${element.javaFieldName}?.additionalGeographicalInformation}" maxlength="38" id="${IdRefNamePrefix}${element.javaFieldName}.additionalGeographicalInformation" name="${namePrefix}${element.javaFieldName}.additionalGeographicalInformation" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="${IdRefNamePrefix}${element.javaFieldName}.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber" value="\${${valuePrefix}.${element.javaFieldName}?.streetNumber}" size="5" maxlength="5" id="${IdRefNamePrefix}${element.javaFieldName}.streetNumber" name="${namePrefix}${element.javaFieldName}.streetNumber" />
            <input type="text" class="line2 required validate-streetName" value="\${${valuePrefix}.${element.javaFieldName}?.streetName}" maxlength="32" id="${IdRefNamePrefix}${element.javaFieldName}.streetName" name="${namePrefix}${element.javaFieldName}.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38" value="\${${valuePrefix}.${element.javaFieldName}?.placeNameOrService}" maxlength="38" id="${IdRefNamePrefix}${element.javaFieldName}.placeNameOrService" name="${namePrefix}${element.javaFieldName}.placeNameOrService" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="${IdRefNamePrefix}${element.javaFieldName}.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode" value="\${${valuePrefix}.${element.javaFieldName}?.postalCode}" size="5" maxlength="5" id="${IdRefNamePrefix}${element.javaFieldName}.postalCode" name="${namePrefix}${element.javaFieldName}.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city" value="\${${valuePrefix}.${element.javaFieldName}?.city}" maxlength="32" id="${IdRefNamePrefix}${element.javaFieldName}.city" name="${namePrefix}${element.javaFieldName}.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38" value="\${${valuePrefix}.${element.javaFieldName}?.countryName}" maxlength="38" id="${IdRefNamePrefix}${element.javaFieldName}.countryName" name="${namePrefix}${element.javaFieldName}.countryName" />
            </div>
            """
         ,'textarea' :
            """
            <textarea id="${IdRefNamePrefix}${element.javaFieldName}" name="${namePrefix}${element.javaFieldName}" class="${element.htmlClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" />" rows="${element.rows}" cols="" ${element.jsRegexp} ${element.lengthLimits}>\${${valuePrefix}.${element.javaFieldName}}</textarea>
            """
         ,'localReferentialData':
            """
            <g:set var="${element.javaFieldName}Index" value="\${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'${element.javaFieldName}', 'i18nPrefixCode':'${element.i18nPrefixCode}', 'htmlClass':'${element.htmlClass.replace('validate-localReferentialData','')}', 
                              'lrEntries': lrTypes.${element.javaFieldName}.entries, 'depth':0]" />
            """
         ,'date' :
            """
            <input type="text" id="${IdRefNamePrefix}${element.javaFieldName}" name="${namePrefix}${element.javaFieldName}" value="\${formatDate(formatName:'format.date',date:${valuePrefix}.${element.javaFieldName})}" 
                   class="${element.htmlClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" />" />
            """
         ,'text' :
            """
            <input type="text" id="${IdRefNamePrefix}${element.javaFieldName}" name="${namePrefix}${element.javaFieldName}" value="\${${valuePrefix}.${element.javaFieldName}?.toString()}" 
                    class="${element.htmlClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" />" ${element.jsRegexp} ${element.lengthLimits} />
            """
         ,'subject' :
            """
            <label for="${IdRefNamePrefix}${element.javaFieldName}Id" class="${element.listenerConditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> ${element.mandatory ? '*' : ''}  <span><g:message code="${element.i18nPrefixCode}.help" /></span></label>
            <select id="${IdRefNamePrefix}${element.javaFieldName}Id" name="subjectId" <g:if test="\${isEdition}">disabled="disabled"</g:if> class="required validate-not-first ${element.autofillClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="\${subjects}">
                <option value="\${it.key}" \${it.key == rqt.subjectId ? 'selected=\"selected\"': ''}>\${it.value}</option>
              </g:each>
            </select>
            """
         ,'requester' :
            """
              <g:render template="/frontofficeRequestType/widget/requester" model="['requester':requester, 'hasHomeFolder':hasHomeFolder]" />
            """
         ,'label' :
            """<label class="${element.listenerConditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> ${element.mandatory ? '*' : ''}  <span><g:message code="${element.i18nPrefixCode}.help" /></span></label>"""
         ,'labelWithFor' :
            """<label for="${IdRefNamePrefix}${element.javaFieldName}" class="${element.listenerConditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> ${element.mandatory ? '*' : ''}  <span><g:message code="${element.i18nPrefixCode}.help" /></span></label>"""
         ,'acceptance' :
            """
              <label class="${element.listenerConditionsClass}">
                <g:message code="${element.i18nPrefixCode}.label" /> ${element.mandatory ? '*' : ''}
                <g:if test="\${availableRules.contains('${element.javaFieldName}')}">
                  <a target="_blank" href="\${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'${element.javaFieldName}']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="${element.i18nPrefixCode}.help" /></span>
              </label>
              <ul class="yes-no ${element.listenerConditionsClass}">
                <g:each in="\${[true,false]}">
                  <li>
                    <input type="radio" id="${IdRefNamePrefix}${element.javaFieldName}_\${it ? 'yes' : 'no'}" class="${element.htmlClass}" title="" value="\${it}" name="${namePrefix}${element.javaFieldName}" \${it == ${valuePrefix}.${element.javaFieldName} ? 'checked="checked"': ''} />
                    <label for="${IdRefNamePrefix}${element.javaFieldName}_\${it ? 'yes' : 'no'}"><g:message code="message.\${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            """
      ]
      
      def output
      if (['requester','subject', 'acceptance'].contains(element.widget))
        output = ''
      else if (['radio', 'boolean', 'localReferentialData', 'address'].contains(element.widget))
        output = widgets['label']
      else
        output = widgets['labelWithFor']
      
      if (widgets[element.widget] != null) output += widgets[element.widget]
      else output += widgets['text']
      println output
  }
%>

<% elementList.each { element -> %>
  <% if (element.typeClass == "COLLECTION") { %>
    <div class="collection ${element.listenerConditionsClass}">
    <h3>
      <g:message code="${element.i18nPrefixCode}.label" />
      <span><g:message code="request.masseage.collectionEditionRules" /></span>
      <span><g:message code="${element.i18nPrefixCode}.help" /></span>
      <button type="submit" name="submit-collectionAdd-${step.name}-${element.javaFieldName}">
        <a>\${message(code:'action.add')}</a>
      </button>
    </h3>
    <g:each var="listItem" in="\${rqt.${element.javaFieldName}}" status="listIndex">
      <fieldset>
        <legend>
          <g:message code="${element.i18nPrefixCode}.label" /> (\${listIndex + 1})
          <input type="submit" name="submit-collectionDelete-${step.name}-${element.javaFieldName}[\${listIndex}]" value="\${message(code:'action.remove')}" />
        </legend>
        <% element.elements.each { subElement -> %>
          <% displayWidget(subElement, 'listItem?' , element.javaFieldName + '[${listIndex}].' ) %>
        <% } %>
      </fieldset>
    </g:each>
    </div>
  <% } else if (element.typeClass == "COMPLEX") { %>
    <fieldset class="${element.listenerConditionsClass}">
    <legend><g:message code="${element.i18nPrefixCode}.label" /></legend>
    <% element.elements.each { subElement -> %>
      <% displayWidget(subElement, 'rqt', '') %>
    <% } %>
    </fieldset>
  <% } else { %>
    <% displayWidget(element, 'rqt', '') %>
  <% } %>
<% } %>
