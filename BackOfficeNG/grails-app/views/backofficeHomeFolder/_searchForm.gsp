<div id="search-form">
  <h1><g:message code="homeFolder.header.search" /></h1>
  <form method="post" id="searchForm" class="advanced-search" action="${createLink(action:"search")}">
    <input type="hidden" id="pageState" name="pageState" value="${pageState}" />
    <input type="hidden" name="currentCount" id="currentCount" value="${count}" />
    <input type="hidden" name="currentOffset" id="currentOffset" value="${offset}" />
    <input type="hidden" name="currentMax" id="currentMax" value="${max}" />
    <div id="errorContainer" class="error"><!-- error container --></div>
    <div class="yui-g">
      <div class="yui-u first">        
        <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
        <input type="text" name="homeFolderId" class="persistent" size="40" value="${state?.homeFolderId}" />
        <label for="isHomeFolderResponsible">
          <g:message code="homeFolder.search.isHomeFolderResponsible" /> :
        </label>
        <input type="checkbox" name="isHomeFolderResponsible" value="true"
          class="persistent" ${state?.isHomeFolderResponsible ? ' checked="checked"': ''} />
      </div>

      <div class="yui-u">
        <label for="lastName"><g:message code="property.individualLastName" /> :</label>
        <input type="text" name="lastName" class="persistent" size="40" value="${state?.lastName}" />
        <label for="firstName"><g:message code="property.individualFirstName" /> :</label>
        <input type="text" name="firstName" class="persistent" size="40" value="${state?.firstName}" />
      </div>
    </div>
    <div class="form-button">
      <input type="submit" value="${message(code:"action.search")}" />
    </div>
  </form>
</div>
