<html>
  <head>
    <title><g:message code="requestType.header.configuration" /> "${requestTypeLabel}"</title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/yui/editor',file:'simpleeditor.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common/yui-skin',file:'container.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/yui/editor',file:'simpleeditor-beta.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'defaultToolbar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'calendar.js')}"></script>
    
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'templateManager.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'requestTypeForms.js')}"></script>
    
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'requestTypeDocuments.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'requestTypeLocalReferential.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'requestTypeConfigure.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'requestTypeSeasons.js')}"></script>
    
    <script type="text/javascript">
      zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');
      zenexity.capdemat.bong.requesttype.currentId = '${requestType.id}';
    </script>
  </head>

  <body>

    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="requestType.header.configuration" /> ${requestTypeLabel}</h1>
        </div>
        
        <div id="mainPanel">
          <!-- Tabview panel -->
          <div id="requestTypeForms" class="yui-navset yellow-yui-tabview" style="display:block;">
            <ul class="yui-nav">
              <li class="selected" title="active">
                <a href="#confArea_Tab1"><em>${message(code:'requestType.header.formsList')}</em></a>
              </li> 
            </ul>
            <div class="yui-content">
              <!-- First area -->
              <div id="confArea_Tab1">
                <div id="formsConfiguration">
                  <!-- <h2>${message(code:'requestType.configuration.forms')}</h2> -->
                  <div class="editableListSwithcher">
                    <a id="linkShowDatasheet" href="javascript:;">${message(code:'action.create')}</a>
                  </div>
                  <div id="insertInList"></div>
                  <div id="requestFormList"></div>
                  <div class="separator"></div>
                </div>
              </div>
            </div>
          </div>
          <div class="mainbox mainbox-yellow" id="requestTypeAlerts" style="display:none"></div>
          <div class="mainbox mainbox-yellow" id="requestTypeSeasons" style="display:none"></div>
          <div class="mainbox mainbox-yellow" id="requestTypeDocuments" style="display:none">
            <h2><g:message code="requestType.configuration.documents" /></h2>
            <div id="documentTypeFilterPanel" class="editableListSwithcher">
              <a id="showAssociatedDocuments">${message(code:'filter.viewBounded')}</a>/
              <a id="showUnassociatedDocuments" class="current">${message(code:'filter.viewUnbounded')}</a>/
              <a id="showAllDocuments">${message(code:'filter.viewAll')}</a>
            </div>
            <div id="documentList"></div>
          </div>
          <div id="requestTypeLocalReferential" style="display:none"></div>
        </div>
        <form method="post" id="editorForm" action="${createLink(action:'mailTemplate')}" class="editor-form">
          <div id="editPanel">
            <div class="hd">Change state</div>
            <div class="bd" >
              <div id="editorBody" style="display:none">
                  <textarea id="editor" rows="15" name="editor"></textarea>
                  <input type="hidden" id="element" name="element" value="" />
                  <input type="hidden" name="requestTypeId" value="" />
                  <input type="hidden" name="requestFormId" value="" />
                  <input type="button" id="submit" name="submit" value="Save" />
              </div>
            </div>
          </div>
        </form>
        
        <div id="trash" style="display:none">
        </div>
        
      </div>
    </div>
    <div id="narrow" class="yui-b">
      <div class="nobox taskstate">
        <h3><g:message code="property.state" /></h3>
        <div class="body">
          <g:if test="${requestType?.active}">
            <span id="requestState" class="tag-enable"><g:message code="property.active" /></span>
          </g:if>
          <g:else>
            <span id="requestState" class="tag-disable"><g:message code="property.inactive" /></span>
          </g:else>
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="requestType.header.subMenu" /></h3>
        <div class="body">
          <ul class="second-level-menu" id="secondMenu">
          <g:each in="${baseConfigurationItems}">
            <li id="requestType-${it.key}">
              <span class="second-level-menu-item" id="display_${it.key}">
                <g:message code="${it.value[0]}"/>
                <g:if test="${it.value[1]}">*</g:if>
              </span>
              <span>&nbsp;</span>
            </li>
          </g:each>
          </ul>
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="requestType.header.switchRequestType" /></h3>
        <div class="body">
          <form action="${createLink(action : 'configure')}" method="get">
            <select name="id" id="requestTypeId" onchange="submit();">
              <option value=""></option>
              <g:each in="${requestTypes}" var="requestType">
                <option value="${requestType.id}">${requestType.label}</option>
              </g:each>
            </select>
          </form>
        </div>
      </div>
      
      <div id="requestStatePanel" class="state-overlay">
        <div class="hd" style="cursor: auto;"><g:message code="request.header.changeState" /></div>
        <div class="bd"></div>
        <div class="ft"></div>
      </div>
    </div>

  </body>
</html>

