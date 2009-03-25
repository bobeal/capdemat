<g:set var="currentLrDatas" value="${rqt[javaName].collect{it.name}}" />
<g:if test="${lrTypes[javaName].entriesSupportMultiple}">
  <ul ${depth==0 ? 'class="dataTree"' : ''}>
  <g:each var="entry" in="${lrEntries}">
    <g:if test="${entry.entries}">
      <li>
      <em>${entry.labelsMap.fr} :</em>
      <g:render template="/frontofficeRequestType/localReferentialEntries" 
                model="['javaName':javaName, 'htmlClass':htmlClass, 'lrEntries': entry.entries, 'depth':++depth]" />
      </li>
    </g:if>
    <g:else>
      <li>
      <input type="hidden" name="_${javaName}[${flash[javaName+'Index']}].name" value="" />
      <input type="checkbox" name="${javaName}[${flash[javaName+'Index']++}].name" value="${entry.key}" 
          class="${htmlClass}" title="${message(code:'request.'+ javaName +'.validationError')}"
          ${currentLrDatas?.contains(entry.key) ? 'checked="checked"': ''} />
      <span>${entry.labelsMap.fr}</span>
      </li>
    </g:else>
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
