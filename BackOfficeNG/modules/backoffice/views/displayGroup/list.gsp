<%@ taglib prefix="g" uri="/web-app/WEB-INF/tld/grails.tld" %>
<html>
  <head>
    <title>${message(code:'displayGroup.header.list')}</title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" 
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'displayGroupList.js')}"></script>
  </head>

  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>${message(code:'localAuthority.header.configuration')}</h1>
        </div>
        <div class="mainbox mainbox-yellow">
          <h2>${message(code:'displayGroup.header.list')}</h2>
          <div id="displayGroupMsg" class="invisible"></div>
          <p class="createConfigurationItem">
            <a href="${createLink(action:'create')}">${message(code:'action.create')}</a>
          </p>
          <g:if test="${displayGroups.size == 0}">
            ${message(code:'displayGroup.message.noDisplayGroup')}
          </g:if>
          <g:else>
            <ul id="displayGroups" class="overviewConfigurationList">
              <g:each in="${displayGroups}" var="displayGroup">
              <li>
                <h3>
                  <a href="${createLink(action:'edit',id:displayGroup.id)}">${displayGroup.label}</a>
                  <img id="confirmDelete_${displayGroup.id}" 
                       src="${createLinkTo(dir:'images/icons',file:'16-delete.png')}" 
                       alt="${message(code:'displayGroup.message.confirmDelete',args:[displayGroup?.label])}" />
                </h3>
                <div>
                  <g:each in="${requestTypesByDisplayGroup[displayGroup.id]}" var="requestType">
                    <g:if test="${requestType.active}">
                      ${requestType.label}
                    </g:if>
                    <g:else>
                      <span class="disabled">
                        ${requestType.label}
                      </span>
                    </g:else>
                    - 
                  </g:each>
                </div>
              </li>
              </g:each>
            </ul>
          </g:else>
        </div>
      </div>
    </div>
    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
    </div>
  </body>
</html>

