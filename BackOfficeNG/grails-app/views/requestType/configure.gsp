<html>
  <head>
    <title><g:message code="requestType.header.configuration" /> "${requestTypeLabel}"</title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'configuration.css')}" ></link>
    <link rel="stylesheet" href="${createLinkTo(dir:'css/yui/editor',file:'simpleeditor.css')}" ></link>
    <script type="text/javascript" src="${createLinkTo(dir:'js/yui/editor',file:'simpleeditor-beta.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'defaultToolbar.js')}"></script>
    
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'templateManager.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'requestTypeConfiguration.js')}"></script>
    
    <!--
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'requestTypeConfigure.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'requestTypeForms.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'requestTypeAlerts.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'requestTypeDocuments.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'requestTypeLocalReferential.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'requestTypeSeasons.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'calendar.js')}"></script>
    -->
    
    <script type="text/javascript">
      zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');
      zenexity.capdemat.bong.requesttype.currentId = '${requestType.id}';
      YAHOO.capdematBo.requestTypeId = '${requestType.id}';
    </script>
  </head>

  <body>

    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="requestType.header.configuration" /> ${requestTypeLabel}</h1>
        </div>
        
        <!-- Tabview panel -->
        <div id="workArea" class="yui-navset yellow-yui-tabview" style="display:block;">
          <ul class="yui-nav">
            <li class="selected" title="active">
              <a href="#confArea_Tab1"><em>Request configuration</em></a>
            </li> 
          </ul>            
          <div class="yui-content">
            <!-- First area -->
            <div id="confArea_Tab1">
              
              
              <div id="formsConfiguration">
                <h2>${message(code:'requestType.configuration.forms')}</h2>
                
                <div class="createConfigurationItem">
                  <a id="linkShowDatasheet" href="javascript:;">${message(code:'action.create')}</a>
                </div>
                
                <div id="requestFormList">
                </div>
                
                <div class="separator"></div>
              </div>
              
              <!--
              <div class="mainbox mainbox-yellow" id="requestTypeForms"></div>
              <div class="mainbox mainbox-yellow" id="requestTypeAlerts"></div>
              <div class="mainbox mainbox-yellow" id="requestTypeSeasons"></div>
              -->
              
            </div>
            
          </div>
        </div>
        
        <form method="post" id="editor-form" action="${createLink(action:'mailTemplate')}" class="editor-form">
          <div id="editPanel">
            <div class="hd">Change state</div>
            <div class="bd" >
              <div id="bd-editor" style="display:none">
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
        <h3>Etat</h3>
        <div class="body">
          <g:if test="${requestType?.active}">
            <span class="tag-enable"><g:message code="property.active" /></span>
          </g:if>
          <g:else>
            <span class="tag-disable"><g:message code="property.unactive" /></span>
          </g:else>
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="requestType.header.subMenu" /></h3>
        <div class="body">
          <ul class="second-level-menu">
          <g:each in="${baseConfigurationItems}">
            <li id="requestType-${it.key}">
              <span class="second-level-menu-item" 
                onclick="fireRequestTypeSubmenuSelectedEvent('requestType-${it.key}','${it.key}','${requestType.id }');">
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
          <form action="#">
            <select name="requestTypeId" id="requestTypeId" style="width: 100%;">
              <option value=""></option>
              <g:each in="${requestTypes}" var="requestType">
                <option value="${requestType.id}">
                  <g:translateRequestTypeLabel label="${requestType.label}" />
                </option>
              </g:each>
            </select>
          </form>
        </div>
      </div>

    </div>

  </body>
</html>

