<g:set var="currentLrDatas" value="${rqt[javaName].collect{it.name}}" />
<g:if test="${localReferentialTypes[javaName].entriesSupportMultiple}">
  <ul>
  <g:each status="i" var="entry" in="${lrEntries}">
    <li>
    <g:if test="${entry.entries}">
      <strong>${entry.labelsMap.fr} :</strong>
      <g:render template="/frontofficeRequestType/localReferentialDatas" model="['javaName':javaName, 'lrEntries': entry.entries]" />
    </g:if>
    <g:else>
      ${currentLrDatas?.contains(entry.key) ? entry.labelsMap.fr + (i < lrEntries.size() - 1 ? ', ' : '') : ''}
    </g:else>
    </li>
  </g:each>
  </ul>
</g:if>
<g:else>
  <g:each var="entry" in="${lrEntries}">
  ${currentLrDatas?.contains(entry.key) ? entry.labelsMap.fr: ''}
  </g:each>
</g:else>
