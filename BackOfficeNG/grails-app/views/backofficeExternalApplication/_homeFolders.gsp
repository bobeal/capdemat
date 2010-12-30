<h2>${message(code:'external.header.account')}</h2>

<div class="editableListSwithcher">
  <input type="hidden" name="startIndexHomeFolder" id="startIndexHomeFolder" value="${startIndexHomeFolder}" />
  &nbsp;
  <g:if test="${displayDirHomeFolder.prev}">
   &lt;<a id="previousHomeFolders">${message(code:'action.previous')}</a>
  </g:if>
  <g:else>
    <span style="color:#aaa;">&lt; ${message(code:'action.previous')}</span>
  </g:else>
  |
  <g:if test="${displayDirHomeFolder.next}">
    <a id="nextHomeFolders">${message(code:'action.next')}</a>&gt;
  </g:if>
  <g:else>
    <span style="color:#aaa;">${message(code:'action.next')} &gt;</span>
  </g:else>
</div>
<ul id="homeFolders" class="editableList">
  <g:each var="homeFolder" in="${homeFolders}">
    <li>
      <a id="matchHomeFolders_${homeFolder.id}" class="editItem"><span>${message(code:'action.edit')}</span></a>
      <span>${message(code:'external.label.account')}</span>
      <strong>(${homeFolder.externalId})</strong>
      <span class="tag-wrapper">
        <g:capdematEnumToFlag var="${homeFolder.mappingState}" i18nKeyPrefix="external.mappingState" />
      </span>
      <div id="matchedHomeFolders_${homeFolder.id}"></div>
    </li>
  </g:each>
</ul>

