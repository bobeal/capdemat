<h1><g:message code="request.header.advancedSearch" /></h1>
<form method="POST" id="requestForm" class="advanced-search" action="<g:createLink action="search" />">
  <input type="hidden" id="totalRecords" value="${totalRecords}" />
  <input type="hidden" id="recordOffset" name="recordOffset" value="${recordOffset}" />
  <input type="hidden" id="recordsReturned" value="${recordsReturned}" />
  <input type="hidden" id="sortBy" name="sortBy" value="${sortBy}" />
  <input type="hidden" id="filterBy" name="filterBy" value="${filterBy}" />
  <input type="hidden" id="mode" name="mode" value="advanced" />
  <div class="yui-g">

    <div class="yui-u first">
      <label for="requesterLastName"><g:message code="request.property.requesterLastName" /> :</label>
      <input type="text" id="requesterLastName" name="requesterLastName" size="40" 
        value="${params?.requesterLastName}" />
      
      <label for="requestId"><g:message code="request.property.requestId" /> :</label>
      <input type="text" id="id" name="id" size="40" value="${params?.id}" />

      <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
      <input type="text" id="homeFolderId" name="homeFolderId" size="40" 
        value="${params?.homeFolderId}" />

    </div>

    <div class="yui-u">
      <label for="state"><g:message code="property.state" /> :</label>
      <select name="state" id="state">
        <option value=""></option>
        <g:each in="${allStates}" var="state">
          <option value="${state}" ${params?.state == state.toString() ? 'selected' : ''}>${state}</option>
        </g:each>
      </select>
      
      <label for="lastInterveningAgent"><g:message code="request.property.lastInterveningAgent" /> :</label>
      <select name="lastInterveningAgentId" id="lastInterveningAgentId">
        <option value=""></option>
        <g:each in="${allAgents}" var="agent">
          <option value="${agent.id}" ${params?.lastInterveningAgentId == agent.id.toString() ? 'selected' : ''}>
            ${agent.getLastName() + " " + agent.getFirstName()}
          </option>
        </g:each>
      </select>

      <label for="requestTypeId"><g:message code="property.requestType" /> :</label>
      <select name="requestType" id="requestType" style="width:60%;">
        <option value=""></option>
        <g:each in="${allRequestTypes}" var="requestType">
          <option value="${requestType.key}" ${params?.requestType == requestType.key.toString() ? 'selected' : ''}>${requestType.value}</option>
        </g:each>
      </select>

      <label for="categoryName"><g:message code="property.category" /> :</label>
      <select name="categoryId" id="categoryId">
        <option value=""></option>
        <g:each in="${allCategories}" var="category">
          <option value="${category.id}" ${params?.categoryId == category.id.toString() ? 'selected' : ''}>${category.name}</option>
        </g:each>
      </select>
    </div>
  </div>

  <input type="button" id="submitSearchRequest" name="submitSearchRequest" class="form-button"
    value="<g:message code="action.search" />"/>
    
</form>
