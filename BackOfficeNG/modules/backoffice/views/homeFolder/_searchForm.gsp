<div class="txt-right" id="requestSearchSwitcher">
  <a href="${module.createLink(module:'backoffice', controller:'Request', action:'initSearch')}" class="simple">
    <g:message code="action.goToRequestSearch" />
  </a> | 
    <g:message code="action.goToHomeFolderSearch" />
</div>

<div id="searchformContainer">
  <h1><g:message code="request.header.advancedSearch" /></h1>
  <form method="POST" id="searchForm" class="advanced-search" action="${createLink(action:"search")}">
    <input type="hidden" id="pageState" name="pageState" value="${pageState}" />
    <div class="yui-g">
      <div class="yui-u first">
        <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
        <input type="text" name="homeFolderId" class="persistent" size="40" value="${state?.homeFolderId}" />
        
        <label for="accountNumber"><g:message code="property.accountNumber" /> :</label>
        <input type="text" name="accountNumber" class="persistent" size="40" value="${state?.accountNumber}" />
      </div>

      <div class="yui-u">
        <label for="lastName"><g:message code="homeFolder.individual.property.lastName" /> :</label>
        <input type="text" name="lastName" class="persistent" size="40" value="${state?.lastName}" />
      </div>

      <div style="clear:both;">&nbsp;</div>
      <input type="button" id="submitSearch" name="submitSearch"
        class="form-button" value="<g:message code="action.search" />"/>
    </div>
  </form>
</div>
