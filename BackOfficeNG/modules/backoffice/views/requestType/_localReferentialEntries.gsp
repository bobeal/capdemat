<ul id="${depth==0 ? 'lrtEntries_'+parentEntry : 'lreEntries_'+parentEntry}" ${depth==0 ? 'class="editableTree"' : ''}>
<g:each var="entry" in="${lrEntries}">
  <li class="" id="entry_${entry.key}">
    <strong>${entry.labelsMap.fr}</strong>
    <a class="editItem" id="editEntry_${entry.key}"><span>delete</span></a>
    <a class="unassociate" id="removeEntry_${entry.key}"><span>edit</span></a>
    <a class="createSubItem" id="addSubEntry_${entry.key}"><span>create</span></a>
    <div id="formContainer_${entry.key}"></div>
    <g:if test="${entry.entries}">
      <g:render template="localReferentialEntries" model="['lrEntries': entry.entries, 'depth':depth+1, 'parentEntry':entry.key]" />
    </g:if>
  </li>
</g:each>
</ul>
