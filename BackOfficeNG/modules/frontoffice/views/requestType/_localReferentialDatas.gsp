<g:set var="currentLrDatas" value="${rqt[javaName].collect{it.name}}" />
<g:if test="${lrTypes[javaName].entriesSupportMultiple}">
  <ul ${depth==0 ? 'class="dataTree"' : ''}>
  <g:each status="i" var="entry" in="${lrEntries}">
    <g:if test="${entry.entries}">
      <li>
      <em>${entry.labelsMap.fr} :</em>
      <g:render template="/frontofficeRequestType/localReferentialDatas" model="['javaName':javaName, 'lrEntries': entry.entries, 'depth':++depth]" />
      </li>
    </g:if>
    <g:else>
       <li>
      ${currentLrDatas?.contains(entry.key) ? entry.labelsMap.fr : ''}
      </li>
    </g:else>
  </g:each>
  </ul>
</g:if>
<g:else>
  <g:each var="entry" in="${lrEntries}">
  ${currentLrDatas?.contains(entry.key) ? entry.labelsMap.fr: ''}
  </g:each>
</g:else>
