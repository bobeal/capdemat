<html>
  <head>
    <title><g:message code="localAuthority.header.configuration" /></title>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'localAuthorityContacts.js')}"></script>
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" />
    <meta name="layout" content="main" />
  </head>
  <body>
    
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="localAuthority.header.configuration" /></h1>
        </div>
        
        <div class="mainbox mainbox-yellow">
          <h2><g:message code="localAuthority.header.meansOfContactConfiguration" /></h2>
          <ul id="meansOfContactList" class="editableList">
            <g:each in="${means}" var="${mean}">
              <li>
                <a id="processMean_${mean.id}" class="${mean.verb}">
                  <span>${mean.verb}</span>
                </a>
                <span><g:message code="request.meansOfContact.${mean.name}"/></span>
              </li>
            </g:each>
          </ul>
          <form id="meanOfContactsForm" action="${createLink(action:'processMean')}">
            <input type="hidden" name="meanId" value="" />
            <input type="hidden" name="verb" value="" />
          </form>
        </div>
        
      </div>
    </div>
    <g:render template="subMenus"/>

  </body>
</html>
