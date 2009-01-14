<%
  import org.apache.commons.lang.StringUtils
   
  def displayWidget(element,  wrapper) {
      
    def widgets = [
      'boolean' : 
          """
          <ul class="${element.conditionsClass}">
            <g:each in="\${[true,false]}">
            <li>
              <input type="radio" class="${element.htmlClass}" title="" value="\${it}" name="${element.javaFieldName}" \${it == ${wrapper}.${element.javaFieldName} ? 'checked="checked"': ''} />
	            <g:message code="message.\${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          """
      ,'radio' :
          """
          <ul class="${element.conditionsClass}">
            <g:each in="\${${element.enumValuesAsString}}">
            <li>
              <input type="radio" class="${element.htmlClass}" value="${element.qualifiedType}_\${it}" name="${element.javaFieldName}" \${it == ${wrapper}.${element.javaFieldName}.toString() ? 'checked="checked"': ''} title="<g:message code="${element.i18nPrefixCode}.validationError" />" />
	            <g:capdematEnumToField var="\${it}" i18nKeyPrefix="${element.i18nPrefixCode}" />
	          </li>
            </g:each>
          </ul>
          """
      ,'select' :
          """
          <select name="${element.javaFieldName}" class="${element.htmlClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" />">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="\${${element.enumValuesAsString}}">
              <option value="${element.qualifiedType}_\${it}" \${it == ${wrapper}.${element.javaFieldName}?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="\${it}" i18nKeyPrefix="${element.i18nPrefixCode}" /></option>
            </g:each>
          </select>
          """
      ,'address' :
          """
          <div class="address-fieldset ${element.conditionsClass}">
          <label><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" value="\${${wrapper}.${element.javaFieldName}.additionalDeliveryInformation}" maxlength="38" name="${element.javaFieldName}.additionalDeliveryInformation"/>  
          <label><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" value="\${${wrapper}.${element.javaFieldName}.additionalGeographicalInformation}" maxlength="38" name="${element.javaFieldName}.additionalGeographicalInformation"/>
          <label class="required"><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
          <input type="text" class="line1" value="\${${wrapper}.${element.javaFieldName}.streetNumber}" maxlength="5" name="${element.javaFieldName}.streetNumber"/>
          <input type="text" class="line2 required" value="\${${wrapper}.${element.javaFieldName}.streetName}" maxlength="32" name="${element.javaFieldName}.streetName" title="<g:message code="address.property.streetName.validationError" />" />
          <label><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" value="\${${wrapper}.${element.javaFieldName}.placeNameOrService}" maxlength="38" name="${element.javaFieldName}.placeNameOrService"/>
          <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
          <input type="text" class="line1 required" value="\${${wrapper}.${element.javaFieldName}.postalCode}" maxlength="5" name="${element.javaFieldName}.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
          <input type="text" class="line2 required" value="\${${wrapper}.${element.javaFieldName}.city}" maxlength="32" name="${element.javaFieldName}.city" title="<g:message code="address.property.city.validationError" />" />
          <label><g:message code="address.property.countryName" /></label>
          <input type="text" value="\${${wrapper}.${element.javaFieldName}.countryName}" maxlength="38" name="${element.javaFieldName}.countryName"/>
          </div>
          """
       ,'date' :
          """
          <input name="${element.javaFieldName}" value="\${formatDate(formatName:'format.date',date:${wrapper}.${element.javaFieldName})}" 
                 class="${element.htmlClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" />">
          """
    ]
    
    if (widgets[element.widget] != null)
      print widgets[element.widget]
    else
      print """<input name="${element.javaFieldName}" value="\${${wrapper}.${element.javaFieldName}}" class="${element.htmlClass}" title="<g:message code="${element.i18nPrefixCode}.validationError" />">"""
  }
%>
<% def displayedSubject = false %>
<% elementList.each { element -> %>
  <% if (element.typeClass == "COLLECTION") { %>
    <!-- 
    <label class="${element.conditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> <span><g:message code="${element.i18nPrefixCode}.help" /></span></label>
    TODO = ON TO MANY
    -->
  <% } else if (element.typeClass == "COMPLEX") { %>
    <fieldset class="${element.conditionsClass}">
    <legend><g:message code="${element.i18nPrefixCode}.label" /></legend> 
      <% if (step.name == 'subject' && !displayedSubject) { %>
    <label><g:message code="request.property.subjectName" /></label>
    <select name="subjectId" class="required validate-not-first" title="request.subject.validationError">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="\${subjects}">
        <option value="\${it.key}" \${it.key == ${acronym}.subjectId ? 'selected="selected"': ''}>\${it.value}</option>
      </g:each>
    </select>
      <% displayedSubject = true } %>
    <% element.elements.each { subElement -> %>
      <label class="${subElement.conditionsClass}"><g:message code="${subElement.i18nPrefixCode}.label" /> <span><g:message code="${subElement.i18nPrefixCode}.help" /></span></label>
      <% displayWidget(subElement, "request") %>
    <% } %>
    </fieldset>
  <% } else { %>
    <label class="${element.conditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> <span><g:message code="${element.i18nPrefixCode}.help" /></span></label>
    <% displayWidget(element, "request") %>
  <% } %>
<% } %>
