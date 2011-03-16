<html>
  <head>
  <title>
    ${message(code:'displayGroup.header.' + (editMode == 'edit' ? 'generalData' : 'creation'))}         
  </title>
  <meta name="layout" content="main" />
  <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" />
  <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'displayGroupEdit.js')}"></script>
  <script type="text/javascript">
    zenexity.capdemat.bong.DisplayGroupEdit.displayGroupId = '${displayGroup?.id}';
    zenexity.capdemat.bong.DisplayGroupEdit.editMode = '${editMode}';
    zenexity.capdemat.bong.DisplayGroupEdit.ressourceBaseUrl = '${createLink(controller:'localAuthorityResource', action:'resource',  params:[type:'DISPLAY_GROUP_IMAGE',filename:''])}'
  </script>
  </head>

  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>${message(code:'displayGroup.header.configuration')}</h1>
        </div>

        <div id="displayGroupData" class="mainbox mainbox-yellow">
          <h2>${message(code:'displayGroup.header.' + (editMode == 'edit' ? 'generalData' : 'creation'))}</h2>
          <div id="displayGroupMsg" class="invisible"></div>
          <form method="post" id="displayGroupForm" action="${createLink(action:'save')}">
            <div class="error" id="displayGroupFormErrors"></div>

            <label for="label" class="required">${message(code:'displayGroup.property.label')} * :</label>
            <input type="text" name="label" class="required" title="${message(code:'displayGroup.error.labelRequired')}" value="${displayGroup?.label}" size="40" />

            <label for="name" class="required validate-alphanum">
            ${message(code:'displayGroup.property.name')} * :
            <span>${message(code:'displayGroup.property.name.help')}</span>
            </label>
            <input type="text" name="name" class="required" title="${message(code:'displayGroup.error.nameRequired')}" value="${displayGroup?.name}" size="40" />

            <p class="form-button">
              <input type="hidden" name="hasLogo" value="${hasLogo}" />
              <input type="hidden" name="id" value="${displayGroup?.id}" />
              <g:if test="${editMode == 'create'}">
                <input type="submit" name="submitDisplayGroup" value="${message(code:'action.create')}" />
                <a id="cancelCreateDisplayGroup" href="${createLink(action:'list')}">${message(code:'action.cancel')}</a>
              </g:if>
              <g:else>
                <input type="submit" name="submitDisplayGroup" value="${message(code:'action.save')}" />
              </g:else>
            </p>
          </form>
        </div>

        <g:if test="${editMode != 'create'}">
          <div class="mainbox mainbox-yellow">
            <h2>${message(code:'displayGroup.header.logo')}</h2>
            <form method="post" id="logoForm" class="localResourceUpload" action="${createLink(action : 'logo')}">
              <p>(${message(code:'displayGroup.message.logoInformation')})</p>
              <p>
              <img id="logoImg" src="${createLink(controller:'localAuthorityResource', action:'resource',  params:[type:'DISPLAY_GROUP_IMAGE',filename:displayGroup?.name])}" />
              </p>
              <input type="hidden" name="name" value="${displayGroup?.name}" />
              <input type="hidden" name="hasLogo" value="${hasLogo}" />
              <label for="logo">${message(code:'displayGroup.message.newLogo')} :</label>
              <input type="file" name="logo" id="logo" />
              <input name="save" id="saveLogo" type="submit" value="${message(code:'action.save')}" />
            </form>
          </div>
          <div id="displayGroupRequestTypesBox" class="mainbox mainbox-yellow">
            <h2>${message(code:'displayGroup.header.requests')}</h2>
            <div class="editableListSwithcher">
              <form id="sortRequestTypeForm" method="post" action="${createLink(action:'requestTypes')}" />
                <select id="orderRequestTypeBy" name="orderRequestTypeBy">
                  <option value="label" ${orderRequestTypeBy == 'label' ? 'selected' : ''}>
                    ${message(code:'displayGroup.filter.byLabel')}
                  </option>
                  <option value="displayGroupLabel" ${orderRequestTypeBy == 'displayGroupLabel' ? 'selected' : ''}>
                    ${message(code:'displayGroup.filter.byDisplayGroup')}
                  </option>
                </select>
                <input type="hidden" name="id" value="${displayGroup?.id}" />
                <input type="hidden" name="scope" id="scope" value="${scope}" />
                <a id="viewRequestTypes_bounded" class="current">${message(code:'filter.viewBounded')}</a>
                / <a id="viewRequestTypes_all">${message(code:'filter.viewAll')}</a>
              </form>
            </div>
            <div id="displayGroupRequestTypesWrapper">
              <g:render template="requestTypes"
                  model="['requestTypes':requestTypes, 'displayGroupId':displayGroup.id]" />
            </div>
          </div>
        </g:if>

      </div>
    </div>

    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
      <div class="nobox">
        <h3>${message(code:'displayGroup.header.switchDisplayGroup')}</h3>
        <div class="body">
          <g:if test="${displayGroups.size == 0}">
            ${message(code:'displayGroup.message.noDisplayGroupDefined')}
          </g:if>
          <g:else>
            <form action="<g:createLink action="edit" />">
              <select id="changeDisplayGroup" name="id">
                <g:each in="${displayGroups}">
                  <option value="${it.id}" ${it.id == displayGroup?.id ? 'selected' : ''}>${it.label}</option>
                </g:each>
              </select>
            </form>
          </g:else>
          <!--
          <a href="${createLink(action:'list')}">${message(code:'displayGroup.message.backToList')}</a>
          -->
        </div>
      </div>
    </div>

  </body>
</html>
