<ul ${dataName ? 'id="entryTree_' + dataName + '"' :''} ${depth == 0 ? 'class="editableTree"' : ''}>
<g:each var="entry" in="${lrEntries}">
  <li class="" id="entry_${entry.key}">
    <strong>${entry.labelsMap.fr}</strong>
    <a class="editItem" id="editEntry_${entry.key}"><span>delete</span></a>
    <a class="unassociate" id="deleteEntry_${entry.key}"><span>edit</span></a>
    <a class="createSubItem" id="addSubEntry_${entry.key}"><span>create</span></a>
    <div id="formContainer_${entry.key}"></div>
    <g:if test="${entry.entries}">
      <g:render template="localReferentialEntries" model="['lrEntries': entry.entries, 'depth':depth+1]" />
    </g:if>
  </li>
</g:each>
</ul>
