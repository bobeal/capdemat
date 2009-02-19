<%
  def displayWidget(element, valuePrefix, namePrefix) {
      def widgets = [
        'boolean' : 
            """
            <ul class="${element.listenerConditionsClass}">
              <g:each in="\${[true,false]}">
              <li>
                <input type="radio" class="${element.htmlClass}" title="" value="\${it}" name="${namePrefix}${element.javaFieldName}" \${it == ${valuePrefix}.${element.javaFieldName} ? 'checked="checked"': ''} />
                <g:message code="message.\${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            """
        ,'radio' :
            """
            <ul class="${element.listenerConditionsClass}">
              <g:each in="\${${element.enumValuesAsString}}">
              <li>
                <input type="radio" class="${element.htmlClass}" value="${element.qualifiedType}_\${it}" name="${namePrefix}${element.javaFieldName}" \${it == ${valuePrefix}.${element.javaFieldName}.toString() ? 'checked="checked"': ''} title="<g:message code="${element.i18nPrefixCode}.validationError" />" />
                <g:capdematEnumToField var="\${it}" i18nKeyPrefix="${element.i18nPrefixCode}" />
              </li>
              </g:each>
            </ul>
            """
        ,'select' :
            """
            <select name="${namePrefix}${element.javaFieldName}" class="${element.htmlClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="\${${element.enumValuesAsString}}">
                <option value="${element.qualifiedType}_\${it}" \${it == ${valuePrefix}.${element.javaFieldName}?.toString() ? 'selected=\"selected\"': ''}><g:capdematEnumToField var="\${it}" i18nKeyPrefix="${element.i18nPrefixCode}" /></option>
              </g:each>
            </select>
            """
        ,'address' :
            """
            <div class="address-fieldset ${element.listenerConditionsClass}">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="\${${valuePrefix}.${element.javaFieldName}?.additionalDeliveryInformation}" maxlength="38" name="${namePrefix}${element.javaFieldName}.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="\${${valuePrefix}.${element.javaFieldName}?.additionalGeographicalInformation}" maxlength="38" name="${namePrefix}${element.javaFieldName}.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /></strong></label>
            <input type="text" class="line1" value="\${${valuePrefix}.${element.javaFieldName}?.streetNumber}" maxlength="5" name="${namePrefix}${element.javaFieldName}.streetNumber"/>
            <input type="text" class="line2 required" value="\${${valuePrefix}.${element.javaFieldName}?.streetName}" maxlength="32" name="${namePrefix}${element.javaFieldName}.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="\${${valuePrefix}.${element.javaFieldName}?.placeNameOrService}" maxlength="38" name="${namePrefix}${element.javaFieldName}.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
            <input type="text" class="line1 required" value="\${${valuePrefix}.${element.javaFieldName}?.postalCode}" maxlength="5" name="${namePrefix}${element.javaFieldName}.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="\${${valuePrefix}.${element.javaFieldName}?.city}" maxlength="32" name="${namePrefix}${element.javaFieldName}.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="\${${valuePrefix}.${element.javaFieldName}?.countryName}" maxlength="38" name="${namePrefix}${element.javaFieldName}.countryName"/>
            </div>
            """
         ,'date' :
            """
            <input type="text" name="${namePrefix}${element.javaFieldName}" value="\${formatDate(formatName:'format.date',date:${valuePrefix}.${element.javaFieldName})}" 
                   class="${element.htmlClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" />">
            """
         ,'text' :
            """
            <input type="text" name="${namePrefix}${element.javaFieldName}" value="\${${valuePrefix}.${element.javaFieldName}}" 
                    class="${element.htmlClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" />"${element.jsRegexp != null ? ' regex="' + element.jsRegexp + '"' : ''}>
            """
      ]
      
      if (widgets[element.widget] != null)
          print widgets[element.widget]
      else
          print widgets['text']
  }
  
  
  def displayStaticWidget(element, valuePrefix) {
      def staticWidgets = [
          'boolean' : 
              """<dd><g:message code="message.\${${valuePrefix}.${element.javaFieldName} ? 'yes' : 'no'}" /></dd>"""
          ,'radio' :
              """
              <dd>
                <g:if test="\${${valuePrefix}.${element.javaFieldName}}">
                  <g:capdematEnumToField var="\${${valuePrefix}.${element.javaFieldName}}" i18nKeyPrefix="${element.i18nPrefixCode}" />
                </g:if>
              </dd>
              """
          ,'select' :
              """
              <dd>
                <g:if test="\${${valuePrefix}.${element.javaFieldName}}">
                  <g:capdematEnumToField var="\${${valuePrefix}.${element.javaFieldName}}" i18nKeyPrefix="${element.i18nPrefixCode}" />
                </g:if>
              </dd>
              """
          ,'address' :
              """
              <g:if test="\${${valuePrefix}.${element.javaFieldName}}">
                <dd>
                  <p>\${${valuePrefix}.${element.javaFieldName}?.additionalDeliveryInformation}</p>
                  <p>\${${valuePrefix}.${element.javaFieldName}?.additionalGeographicalInformation}</p>
                  <p>\${${valuePrefix}.${element.javaFieldName}?.streetNumber} \${${valuePrefix}.${element.javaFieldName}?.streetName}</p>
                  <p>\${${valuePrefix}.${element.javaFieldName}?.placeNameOrService}</p>
                  <p>\${${valuePrefix}.${element.javaFieldName}?.postalCode} \${${valuePrefix}.${element.javaFieldName}?.city}</p>
                  <p>\${${valuePrefix}.${element.javaFieldName}?.countryName}</p>
                </dd>
              </g:if>
              """
          ,'date' :
              """<dd><g:formatDate formatName="format.date" date="\${${valuePrefix}.${element.javaFieldName}}"/></dd>"""
          ,'text' : 
              """<dd>\${${valuePrefix}.${element.javaFieldName}}</dd>"""
      ]
  
      if (staticWidgets[element.widget] != null)
          print staticWidgets[element.widget]
      else
          print staticWidgets['text']
  }
  
%>


<% def displayedSubject = false %>
<% elementList.each { element -> %>
  <% if (element.typeClass == "COLLECTION") { %>
    <label class="${element.listenerConditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> <span><g:message code="${element.i18nPrefixCode}.help" /></span></label>
    <div class="collection-fieldset ${element.listenerConditionsClass} validation-scope">
      <!--<h4><g:message code="${element.i18nPrefixCode}.label" /></h4>-->
      <g:set var="listIndex" value="\${editList?.name == '${element.javaFieldName}' ? editList?.index : ( rqt.${element.javaFieldName} ? rqt.${element.javaFieldName}.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add ${element.conditionsClass}">
    <% element.elements.each { subElement -> %>
        <label class="${subElement.listenerConditionsClass}"><g:message code="${subElement.i18nPrefixCode}.label" /> <span><g:message code="${subElement.i18nPrefixCode}.help" /></span></label>
        <% displayWidget(subElement, 'editList?.' + element.javaFieldName + '?', element.javaFieldName + '[${listIndex}].' ) %>
    <% } %>
        <g:if test="\${editList?.name == '${element.javaFieldName}'}">
          <input type="submit" id="submit-collectionModify-${step.name}-${element.javaFieldName}[\${listIndex}]" name="submit-collectionModify-${step.name}-${element.javaFieldName}[\${listIndex}]" value="\${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-${step.name}-${element.javaFieldName}[\${listIndex}]" name="submit-collectionAdd-${step.name}-${element.javaFieldName}[\${listIndex}]" value="\${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="\${rqt.${element.javaFieldName}}" status="index">
      <fieldset class="collection-fieldset-edit">
        <!-- <legend><g:message code="${element.i18nPrefixCode}.label" /></legend> -->
        <dl>
    <% element.elements.each { subElement -> %>
        <dt><g:message code="${subElement.i18nPrefixCode}.label" /></dt>
        <% displayStaticWidget(subElement, 'it') %>
    <% } %>
        </dl>
        <input type="submit" value="\${message(code:'action.modify')}" name="submit-collectionEdit-${step.name}-${element.javaFieldName}[\${index}]" />
        <input type="submit" value="\${message(code:'action.remove')}" name="submit-collectionDelete-${step.name}-${element.javaFieldName}[\${index}]" />
      </fieldset>
    </g:each>
    </div>
  <% } else if (element.typeClass == "COMPLEX") { %>
    <fieldset class="${element.listenerConditionsClass}">
    <legend><g:message code="${element.i18nPrefixCode}.label" /></legend> 
      <% if (step.name == 'subject' && !displayedSubject) { %>
    <label><g:message code="request.property.subjectName" /></label>
    <select name="subjectId" class="required validate-not-first" title="<g:message code="request.subject.validationError" /> ">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="\${subjects}">
        <option value="\${it.key}" \${it.key == rqt.subjectId ? 'selected=\"selected\"': ''}>\${it.value}</option>
      </g:each>
    </select>
      <% displayedSubject = true } %>
    <% element.elements.each { subElement -> %>
      <label class="${subElement.listenerConditionsClass}"><g:message code="${subElement.i18nPrefixCode}.label" /> <span><g:message code="${subElement.i18nPrefixCode}.help" /></span></label>
      <% displayWidget(subElement, 'rqt', '') %>
    <% } %>
    </fieldset>
  <% } else { %>
    <label class="${element.listenerConditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> <span><g:message code="${element.i18nPrefixCode}.help" /></span></label>
    <% displayWidget(element, 'rqt', '') %>
  <% } %>
<% } %>
