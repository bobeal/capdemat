<ul id="${depth==0 ? 'lrt' : 'lre'}Entries_${parentEntry}" ${depth==0 ? 'class="editableTree"' : ''}>
<g:each var="entry" in="${lrEntries}">
  <li class="" id="entry_${entry.key}">
    <strong>${entry.label}</strong>
    <a class="editItem" id="editEntry_${entry.key}"><span>${message(code:'action.remove')}</span></a>
    <a class="deleteItem" id="confirmRemoveEntry_${entry.key}"><span>${message(code:'action.modify')}</span></a>
    <a class="createSubItem" id="addSubEntry_${entry.key}"><span>${message(code:'action.create')}</span></a>
    <div id="formContainer_${entry.key}"></div>
    <g:if test="${entry.entries}">
      <g:render template="localReferentialEntries" 
                model="['lrEntries': entry.entries, 'parentEntry':entry.key, 'depth':depth+1]" />
    </g:if>
  </li>
</g:each>
</ul>
