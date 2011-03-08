<html>
  <head>
    <title><g:message code="requestType.header.configuration" /> "${requestTypeLabel}"</title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice/yui/editor',file:'simpleeditor.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice/common/yui-skin',file:'simpleeditor.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice/common/yui-skin',file:'container.css')}" />
    <script type="text/javascript" src="${resource(dir:'js/yui/editor',file:'simpleeditor-min.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/common',file:'editor.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'requestTypeConfigure.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'requestType' + org.apache.commons.lang3.StringUtils.capitalize(params.action) + '.js')}"></script>
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
          <g:render template="${params.action}" />
        </div>
      </div>
    </div>
    <div id="narrow" class="yui-b">
      <menu:subMenu i18nPrefix="header" data="${subMenuEntries}" />
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
        <h3><g:message code="requestType.header.configurationElements" /></h3>
        <div class="body">
          <ul class="second-level-menu" id="secondMenu">
          <g:each in="${configurationItems}">
            <li>
              <span class="second-level-menu-item">
                <a href="${createLink(action : it.key, id : requestType.id)}">
                  <g:message code="${it.value[0]}"/>
                  <g:if test="${it.value[1]}">*</g:if>
                </a>
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
          <form action="${createLink(action : 'forms')}" method="get">
            <select name="id" id="requestTypeId">
              <g:each in="${requestTypes}">
                <option value="${it.id}" ${it.id == requestType?.id ? 'selected' : ''}>${it.label}</option>
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

