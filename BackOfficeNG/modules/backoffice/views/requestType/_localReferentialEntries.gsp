<ul id="${depth==0 ? 'lrt' : 'lre'}Entries_${parentEntry}" ${depth==0 ? 'class="editableTree"' : ''}>
<g:each var="entry" in="${lrEntries}">
  <li class="" id="entry_${entry.key}">
    <strong>${entry.labelsMap.fr}</strong>
    <a class="editItem" id="editEntry_${entry.key}"><span>${message(code:'action.remove')}</span></a>
    <a class="unassociate" id="confirmRemoveEntry_${entry.key}"><span>${message(code:'action.modify')}</span></a>
    <g:if test="${isMultiple}">
      <a class="createSubItem" id="addSubEntry_${entry.key}"><span>${message(code:'action.create')}</span></a>
    </g:if>
    <div id="formContainer_${entry.key}"></div>
    <g:if test="${entry.entries}">
      <g:render template="localReferentialEntries" 
                model="['lrEntries': entry.entries, 'parentEntry':entry.key, 'isMultiple':isMultiple, 'depth':depth+1]" />
    </g:if>
  </li>
</g:each>
</ul>
