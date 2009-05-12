<g:set var="lrDatas" value="${rqt[javaName].collect{it.name}}" />
<g:if test="${isMultiple}">
  <ul "${depth==0 ? 'class="dataTree"' : ''}>
  <g:each status="i" var="entry" in="${lrEntries}">
    <g:if test="${entry.entries}">
    <li>
      <em>${entry.labelsMap.fr} :</em>
      <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
          model="['javaName':javaName, 'lrEntries': entry.entries, 'rqt':rqt, 'isMultiple':isMultiple, 'depth':++depth]" />
    </li>
    </g:if>
    <g:else>
      <g:if test="${lrDatas?.contains(entry.key)}">
      <li>
      <span class="entry:${entry.key}">${entry.labelsMap.fr}</span>
      </li>
      </g:if>
    </g:else>
  </g:each>
  </ul>
</g:if>
<g:else>
  <g:each var="entry" in="${lrEntries}">
    <g:if test="${lrDatas?.contains(entry.key)}">
    <span class="entry:${entry.key}">${entry.labelsMap.fr}</span>
    </g:if>
  </g:each>
</g:else>
