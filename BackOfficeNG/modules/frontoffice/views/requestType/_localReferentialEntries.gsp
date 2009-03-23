<g:set var="currentLrDatas" value="${rqt[javaName].collect{it.name}}" />
<g:if test="${localReferentialTypes[javaName].entriesSupportMultiple}">
  <ul>
  <g:each var="entry" in="${lrEntries}">
    <li>
      <g:if test="${entry.entries}">
        <strong>${entry.labelsMap.fr}</strong>
        <g:render template="/frontofficeRequestType/localReferentialEntries" model="['javaName':javaName, 'htmlClass':htmlClass, 'lrEntries': entry.entries]" />
      </g:if>
      <g:else>
      <input type="hidden" name="_${javaName}[${flash[javaName+'Index']}].name" value="" />
      <input type="checkbox" name="${javaName}[${flash[javaName+'Index']++}].name" value="${entry.key}" 
          class="${htmlClass}" title="${message(code:'request.'+ javaName +'.validationError')}"
          ${currentLrDatas?.contains(entry.key) ? 'checked="checked"': ''} />
      <span>${entry.labelsMap.fr}</span>
      </g:else>
    </li>
  </g:each>
  </ul>
</g:if>
<g:else>
  <select name="${javaName}[0].name" class="${htmlClass}" title="${message(code:'request.'+ javaName +'.validationError')}">
    <option value="">${message(code:'message.select.defaultOption')}</option>
    <g:each var="entry" in="${lrEntries}">
    <option value="${entry.key}" ${currentLrDatas?.contains(entry.key) ? 'selected="selected"': ''}>${entry.labelsMap.fr}</option>
    </g:each>
  </select>
</g:else>
