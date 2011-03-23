<%-- Render entries of a local referential type as a tree in a select tag --%>
<%-- This recursive partial view does not render the select root element --%>
<%-- @param lrEntries set of LocalReferentialEntry --%>
<%-- @param lrDatas --%>
<%-- FIXME Mutualize with backoffice (exactly the same template exists in the backoffice) --%>
<g:each var="entry" in="${lrEntries}">
  <g:if test="${entry.entries}">
    <%-- There are subentries, display the subtree --%>
    <optgroup label="${entry.label}">
      <g:render template="/frontofficeRequestType/widget/localReferentialEntriesSelectTree" model="['lrEntries': entry.entries, 'lrDatas': lrDatas]" />
    </optgroup>
  </g:if>
  <g:else>
    <%-- We are in a leaf, display the element as an option --%>
    <option value="${entry.key}" ${lrDatas?.contains(entry.key) ? 'selected="selected"': ''}>${entry.label}</option>
  </g:else>
</g:each>
