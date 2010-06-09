<%
  def displayWidget(element, valuePrefix, namePrefix) {
      def IdRefNamePrefix = namePrefix.replace('[','.').replace(']','')
      def validationNamePrefix = namePrefix.replaceAll("\\[\\\$\\{collectionIndex\\}\\]", "")
      def widgets = [
        'boolean' : 
            """
            <ul class="yes-no ${element.listenerConditionsClass} \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}">
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
            <ul class="${element.listenerConditionsClass} \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}">
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
            <select id="${IdRefNamePrefix}${element.javaFieldName}" name="${namePrefix}${element.javaFieldName}" class="${element.htmlClass} \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}" title="<g:message code="${element.i18nPrefixCode}.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="\${${element.enumValuesAsString}}">
                <option value="${element.qualifiedType}_\${it}" \${it == ${valuePrefix}.${element.javaFieldName}?.toString() ? 'selected=\"selected\"': ''}><g:capdematEnumToText var="\${it}" i18nKeyPrefix="${element.i18nPrefixCode}" /></option>
              </g:each>
            </select>
            """
        ,'address' :
            """
            <div id="${IdRefNamePrefix}${element.javaFieldName}" class="address-fieldset ${element.listenerConditionsClass} ${element.autofillClass} \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}">
            <label for="${IdRefNamePrefix}${element.javaFieldName}.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.additionalDeliveryInformation}" maxlength="38" id="${IdRefNamePrefix}${element.javaFieldName}.additionalDeliveryInformation" name="${namePrefix}${element.javaFieldName}.additionalDeliveryInformation" />  
            <label for="${IdRefNamePrefix}${element.javaFieldName}.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.additionalGeographicalInformation}" maxlength="38" id="${IdRefNamePrefix}${element.javaFieldName}.additionalGeographicalInformation" name="${namePrefix}${element.javaFieldName}.additionalGeographicalInformation" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="${IdRefNamePrefix}${element.javaFieldName}_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.streetNumber') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.streetNumber}" size="5" maxlength="5" id="${IdRefNamePrefix}${element.javaFieldName}_streetNumber" name="${namePrefix}${element.javaFieldName}.streetNumber" />
            <input type="text" class="line2 required validate-streetName \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.streetName') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.streetName}" maxlength="32" id="${IdRefNamePrefix}${element.javaFieldName}_streetName" name="${namePrefix}${element.javaFieldName}.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="\${${valuePrefix}.${element.javaFieldName}?.streetMatriculation}" id="${IdRefNamePrefix}${element.javaFieldName}_streetMatriculation" name="${IdRefNamePrefix}${element.javaFieldName}.streetMatriculation" />
            <input type="hidden" value="\${${valuePrefix}.${element.javaFieldName}?.streetRivoliCode}" id="${IdRefNamePrefix}${element.javaFieldName}_streetRivoliCode" name="${IdRefNamePrefix}${element.javaFieldName}.streetRivoliCode" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.placeNameOrService') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.placeNameOrService}" maxlength="38" id="${IdRefNamePrefix}${element.javaFieldName}.placeNameOrService" name="${namePrefix}${element.javaFieldName}.placeNameOrService" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="${IdRefNamePrefix}${element.javaFieldName}_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.postalCode') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.postalCode}" size="5" maxlength="5" id="${IdRefNamePrefix}${element.javaFieldName}_postalCode" name="${namePrefix}${element.javaFieldName}.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.city') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.city}" maxlength="32" id="${IdRefNamePrefix}${element.javaFieldName}_city" name="${namePrefix}${element.javaFieldName}.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="\${${valuePrefix}.${element.javaFieldName}?.cityInseeCode}" id="${IdRefNamePrefix}${element.javaFieldName}_cityInseeCode" name="${IdRefNamePrefix}${element.javaFieldName}.cityInseeCode" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.countryName') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.countryName}" maxlength="38" id="${IdRefNamePrefix}${element.javaFieldName}.countryName" name="${namePrefix}${element.javaFieldName}.countryName" />
            </div>
            """
         ,'frenchRIB' :
            """
            <div class="address-fieldset ${element.listenerConditionsClass} ${element.autofillClass} ${element.autofillClass} \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}">
            <label for="${IdRefNamePrefix}${element.javaFieldName}.bankCode"><g:message code="frenchRIB.property.bankCode" /></label>
            <input type="text" class="\${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.bankCode') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.bankCode}" maxlength="5" id="${IdRefNamePrefix}${element.javaFieldName}.bankCode" name="${namePrefix}${element.javaFieldName}.bankCode" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}.counterCode"><g:message code="frenchRIB.property.counterCode" /></label>
            <input type="text" class="\${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.counterCode') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.counterCode}" maxlength="5" id="${IdRefNamePrefix}${element.javaFieldName}.counterCode" name="${namePrefix}${element.javaFieldName}.counterCode" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}.accountNumber"><g:message code="frenchRIB.property.accountNumber" /></label>
            <input type="text" class="\${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.accountNumber') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.accountNumber}" maxlength="11" id="${IdRefNamePrefix}${element.javaFieldName}.accountNumber" name="${namePrefix}${element.javaFieldName}.accountNumber" />
            <label for="${IdRefNamePrefix}${element.javaFieldName}.accountKey"><g:message code="frenchRIB.property.accountKey" /></label>
            <input type="text" class="\${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}.accountKey') ? 'validation-failed' : ''}" value="\${${valuePrefix}.${element.javaFieldName}?.accountKey}" maxlength="2" id="${IdRefNamePrefix}${element.javaFieldName}.accountKey" name="${namePrefix}${element.javaFieldName}.accountKey" />
            </div>
            """
         ,'textarea' :
            """
            <textarea id="${IdRefNamePrefix}${element.javaFieldName}" name="${namePrefix}${element.javaFieldName}" class="${element.htmlClass} \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}" title="<g:message code="${element.i18nPrefixCode}.validationError" />" rows="${element.rows}" cols="" ${element.jsRegexp} ${element.lengthLimits}>\${${valuePrefix}.${element.javaFieldName}}</textarea>
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
            <div class="date ${element.htmlClass} ${element.listenerConditionsClass} ${element.autofillClass}">
              <select class="day \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}"
                id="${IdRefNamePrefix}${element.javaFieldName}_day"
                name="${namePrefix}${element.javaFieldName}_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="\${1..31}">
                  <option value="\${it}"
                    <g:if test="\${${valuePrefix}.${element.javaFieldName}?.date == it
                      || (${valuePrefix}.${element.javaFieldName} == null && params['${namePrefix}${element.javaFieldName}_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    \${it}
                  </option>
                </g:each>
              </select>
              <select class="month \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}"
                id="${IdRefNamePrefix}${element.javaFieldName}_month"
                name="${namePrefix}${element.javaFieldName}_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="\${1..12}">
                  <option value="\${it}"
                    <g:if test="\${${valuePrefix}.${element.javaFieldName}?.month == (it - 1)
                      || (${valuePrefix}.${element.javaFieldName} == null && params['${namePrefix}${element.javaFieldName}_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.\${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}"
                id="${IdRefNamePrefix}${element.javaFieldName}_year"
                name="${namePrefix}${element.javaFieldName}_year"
                value="\${${valuePrefix}.${element.javaFieldName} ? ${valuePrefix}.${element.javaFieldName}.year + 1900 : params['${validationNamePrefix}${element.javaFieldName}_year']}"
                title="<g:message code="${element.i18nPrefixCode}.validationError" />" />
            </div>
            """
            
         ,'time' :
            """
            <div class="time ${element.htmlClass} ${element.listenerConditionsClass} ${element.autofillClass}">
              <label class="${element.listenerConditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> ${element.mandatory ? '*' : ''}  
                <span><g:message code="${element.i18nPrefixCode}.help" /></span>
              </label>
              <select class="hour \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}"
                id="${IdRefNamePrefix}${element.javaFieldName}_hour"
                name="${namePrefix}${element.javaFieldName}_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="\${0..23}">
                  <option value="\${it}"
                    <g:if test="\${${valuePrefix}.${element.javaFieldName}?.hourOfDay == it
                      || (${valuePrefix}.${element.javaFieldName} == null && params['${namePrefix}${element.javaFieldName}_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    \${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}"
                id="${IdRefNamePrefix}${element.javaFieldName}_minute"
                name="${namePrefix}${element.javaFieldName}_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="\${0..59}">
                 <g:if test="\${(it % 5) == 0}">
                  <option value="\${it}"
                    <g:if test="\${${valuePrefix}.${element.javaFieldName}?.minuteOfHour == it
                      || (${valuePrefix}.${element.javaFieldName} == null && params['${namePrefix}${element.javaFieldName}_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="\${it < 10}">
                           0\${it}
                        </g:if>
                        <g:else>
                            \${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            """
            
         ,'text' :
            """
            <input type="text" id="${IdRefNamePrefix}${element.javaFieldName}" name="${namePrefix}${element.javaFieldName}" value="\${${valuePrefix}.${element.javaFieldName}?.toString()}" 
                    class="${element.htmlClass} \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}" title="<g:message code="${element.i18nPrefixCode}.validationError" />" ${element.jsRegexp} ${element.lengthLimits} />
            """
         ,'subject' :
            """
            <label for="${IdRefNamePrefix}${element.javaFieldName}Id" class="${element.listenerConditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> ${element.mandatory ? '*' : ''}  <span><g:message code="${element.i18nPrefixCode}.help" /></span></label>
            <select id="${IdRefNamePrefix}${element.javaFieldName}Id" name="subjectId" <g:if test="\${isEdition}">disabled="disabled"</g:if> class="required validate-not-first ${element.autofillClass} \${rqt.stepStates['${step.name}'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="${element.i18nPrefixCode}.validationError" /> ">
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
                <g:if test="\${availableRules.contains('$validationNamePrefix${element.javaFieldName}')}">
                  <p><a target="_blank" href="\${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'${element.javaFieldName}']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="${element.i18nPrefixCode}.help" /></span>
              </label>
              <ul class="yes-no ${element.listenerConditionsClass} \${rqt.stepStates['${step.name}'].invalidFields.contains('$validationNamePrefix${element.javaFieldName}') ? 'validation-failed' : ''}">
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
      if (['requester','subject', 'acceptance', 'time'].contains(element.widget))
        output = ''
      else if (['radio', 'boolean', 'localReferentialData', 'address', 'date'].contains(element.widget))
        output = widgets['label']
      else
        output = widgets['labelWithFor']
      
      if (widgets[element.widget] != null) output += widgets[element.widget]
      else output += widgets['text']
      println output
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
           ,'localReferentialData':
            """
            <!-- TODO - local referential Data (local referential Data in collection are notimplemented in model plugin) -->
            """
          ,'date' :
              """<dd><g:formatDate formatName="format.date" date="\${${valuePrefix}.${element.javaFieldName}}"/></dd>"""
          ,'time' :
              """<dd><g:formatDate formatName="format.time" date="\${${valuePrefix}.${element.javaFieldName}}" type="time"/></dd>"""
          ,'text' : 
              """<dd>\${${valuePrefix}.${element.javaFieldName}?.toString()}</dd>"""
      ]
  
      if (staticWidgets[element.widget] != null)
          print staticWidgets[element.widget]
      else
          print staticWidgets['text']
  }
%>

<% elementList.each { element -> %>
  <% if (element.typeClass == "COLLECTION") { %>
    <label class="${element.listenerConditionsClass}"><g:message code="${element.i18nPrefixCode}.label" /> <span><g:message code="${element.i18nPrefixCode}.help" /></span></label>
    <div class="collection-fieldset ${element.listenerConditionsClass} summary-box">
    <a href="\${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'${step.name}', 'currentCollection':'${element.javaFieldName}', 'collectionIndex':(rqt.${element.javaFieldName} ? rqt.${element.javaFieldName}.size() : 0)])}" />
      \${message(code:'request.action.newCollectionItem')}
    </a>
    <g:each var="it" in="\${rqt.${element.javaFieldName}}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    <% element.elements.each { subElement -> %>
        <dt><g:message code="${subElement.i18nPrefixCode}.label" /></dt>
        <% displayStaticWidget(subElement, 'it') %>
    <% } %>
        </dl>
         <a href="\${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'${step.name}', 'currentCollection':'${element.javaFieldName}', 'collectionIndex':index])}">
           \${message(code:'request.action.editCollectionItem')}
         </a>
         <a href="\${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'${step.name}', 'currentCollection':'${element.javaFieldName}', 'collectionIndex':index])}">
           \${message(code:'request.action.deleteCollectionItem')}
         </a>
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
