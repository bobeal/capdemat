<div class="txt-right" id="requestSearchSwitcher">
  <a href="${module.createLink(module:'backoffice', controller:'Request', action:'initSearch')}" class="simple">
    <g:message code="action.goToRequestSearch" />
  </a> | 
    <g:message code="action.goToHomeFolderSearch" />
</div>

<div id="searchformContainer">
  <h1><g:message code="homeFolder.header.advancedSearch" /></h1>
  <form method="POST" id="searchForm" class="advanced-search" action="${createLink(action:"search")}">
    <input type="hidden" id="pageState" name="pageState" value="${pageState}" />
    <div class="yui-g">
      <div class="yui-u first">
        <label for="individualId"><g:message code="property.individualId" /> :</label>
        <input type="text" name="individualId" class="persistent" size="40" value="${state?.individualId}" />
        
        <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
        <input type="text" name="homeFolderId" class="persistent" size="40" value="${state?.homeFolderId}" />
      </div>
      <div class="yui-u">
        <label for="lastName"><g:message code="homeFolder.individual.property.lastName" /> :</label>
        <input type="text" name="lastName" class="persistent" size="40" value="${state?.lastName}" />
        <label for="isHomeFolderResponsible">
          <g:message code="homeFolder.adult.property.isHomeFolderResponsible" /> :
        </label>
        <input type="checkbox" name="isHomeFolderResponsible" value="true"
          class="persistent" ${state?.isHomeFolderResponsible ? ' checked="checked"': ''} />
      </div>
      <div style="clear:both;">&nbsp;</div>
      <input type="button" id="submitSearch" name="submitSearch"
        class="form-button" value="${message(code:"action.search")}"/>
    </div>
    <input type="hidden" name="currentCount" id="currentCount" value="${count}" />
    <input type="hidden" name="currentOffset" id="currentOffset" value="${offset}" />
    <input type="hidden" name="currentMax" id="currentMax" value="${max}" />
  </form>
</div>
