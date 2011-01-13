<g:set var="currentLrDatas" value="${rqt[javaName].collect{it.name}}" />
<g:if test="${lrTypes[javaName].entriesSupportMultiple}">
  <ul class="${depth==0 ? 'dataTree ' : ''}${rqt.stepStates[currentStep].invalidFields.contains(javaName) ? 'validation-failed' : ''} ${htmlClass}">
  <g:each var="entry" in="${lrEntries}">
    <g:if test="${entry.entries}">
      <li>
      <em>${entry.labelsMap.fr} :</em>
      <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                model="['javaName':javaName, 'i18nPrefixCode':i18nPrefixCode, 'htmlClass':htmlClass, 'lrEntries': entry.entries, 'depth':++depth]" />
      </li>
    </g:if>
    <g:else>
      <li>
      <input type="hidden" name="_${javaName}[${flash[javaName+'Index']}].name" value="" />
      <input type="checkbox" id="${javaName}.${flash[javaName+'Index']}.name" name="${javaName}[${flash[javaName+'Index']}].name" value="${entry.key}" 
          class="${flash[javaName+'Index'] == 0 ? htmlClass : htmlClass.replace('required','') } ${flash[javaName+'Index'] == 0 ? 'validate-localReferentialData' : '' }" title="${message(code: i18nPrefixCode +'.validationError')}"
          ${currentLrDatas?.contains(entry.key) ? 'checked="checked"': ''} />
      <label for="${javaName}.${flash[javaName+'Index']++}.name">${entry.labelsMap.fr}</label>
      </li>
    </g:else>
  </g:each>
  </ul>
</g:if>
<g:else>
  <select name="${javaName}[0].name" class="${htmlClass} validate-not-first data-localReferentialData ${rqt.stepStates[currentStep].invalidFields.contains(javaName) ? 'validation-failed' : ''}" title="${message(code: i18nPrefixCode +'.validationError')}">
    <option value="">${message(code:'message.select.defaultOption')}</option>
    <g:each var="entry" in="${lrEntries}">
    <option value="${entry.key}" ${currentLrDatas?.contains(entry.key) ? 'selected="selected"': ''}>${entry.labelsMap.fr}</option>
    </g:each>
  </select>
</g:else>
