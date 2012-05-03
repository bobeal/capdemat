<g:if test="${isMultiple}">
  <ul ${depth==0 ? 'class="dataTree"' : ''}>
  <g:each var="entry" in="${lrEntries}">
    <li>
      <g:if test="${entry.entries}">
        <em>${entry.label}</em>
        <g:render template="/backofficeRequestInstruction/widget/localReferentialEntries"
            model="['javaName':javaName, 'htmlClass':htmlClass, 
                    'lrDatas':lrDatas, 'isMultiple':isMultiple,
                    'lrEntries': entry.entries, 'i18nKeyPrefix':i18nKeyPrefix, 'depth':++depth]" />
      </g:if>
      <g:else>
      <input type="hidden" name="_${javaName}[${flash[javaName+'Index']}].name" value="" />
      <input type="checkbox" name="${javaName}[${flash[javaName+'Index']++}].name" value="${entry.key}" 
          class="${htmlClass}" title="${message(code:'request.'+ javaName +'.validationError')}"
          ${lrDatas?.contains(entry.key) ? 'checked="checked"': ''} />
      <span>${entry.label}</span>
      </g:else>
    </li>
  </g:each>
  </ul>
</g:if>
<g:else>
  <select name="${javaName}[0].name" class="${htmlClass}" title="${message(code:'request.'+ javaName +'.validationError')}">
    <option value="">${message(code:'message.select.defaultOption')}</option>
    <g:render template="/backofficeRequestInstruction/widget/localReferentialEntriesSelectTree" model="['lrEntries': lrEntries, 'lrDatas': lrDatas]" />
  </select>
</g:else>
