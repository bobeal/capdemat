<g:set var="lrDatas" value="${rqt[javaName].collect{it.name}}" />
  <ul "${depth==0 ? 'class="dataTree"' : ''}>
  <g:each status="i" var="entry" in="${lrEntries}">
    <g:if test="${entry.entries}">
    <li>
      <em>${entry.label}</em>
      <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
          model="['javaName':javaName, 'lrEntries': entry.entries, 'rqt':rqt, 'depth':1+depth]" />
    </li>
    </g:if>
    <g:else>
      <g:if test="${lrDatas?.contains(entry.key)}">
      <li>
      <span class="entry:${entry.key}">${entry.label}</span>
      </li>
      </g:if>
    </g:else>
  </g:each>
  </ul>
