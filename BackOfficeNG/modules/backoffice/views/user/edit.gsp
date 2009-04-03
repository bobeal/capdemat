<%@ taglib prefix="g" uri="/web-app/WEB-INF/tld/grails.tld" %>
<html>
  <head>
  <title>
    <g:message code="user.header.configuration" args="${[user.lastName, user.firstName]}" />           
  </title>
  <meta name="layout" content="main" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" >
  <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'userEdit.js')}"></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'userCategories.js')}"></script>
  <script type="text/javascript">
    zenexity.capdemat.bong.userId = '${user?.id}';
  </script>
  </head>
  
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>
            <g:message code="user.header.configuration" args="${[user.lastName, user.firstName]}" />
          </h1>
        </div>
      
        <div class="mainbox mainbox-yellow">
          <h2><g:message code="user.header.user" /></h2>
          <dl id="user" class="tableDisplay">
            <dt><g:message code="user.property.lastName" /> : </dt>
            <dd>${user.lastName}</dd>
            
            <dt><g:message code="user.property.firstName" /> : </dt>
            <dd>${user.firstName}</dd>
            
            <dt><g:message code="user.property.id" /> : </dt>
            <dd>${user.id}</dd>
          </dl>
        </div>
        
        <div id="userCategoriesBox" class="mainbox mainbox-yellow">
          <h2><g:message code="user.header.categories" /></h2>
          <div class="editableListSwithcher">
            <form id="sortCategoryForm" method="post" action="<g:createLink action="categories" />" />
              <input type="hidden" name="id" value="${user?.id}" />

              <a id="viewUserCategoriesLink" class="current"
                onclick="zenexity.capdemat.bong.userCategory.viewCategories('User');">
                <g:message code="filter.viewBounded" />
              </a> / 
              <a id="viewAllCategoriesLink" 
                onclick="zenexity.capdemat.bong.userCategory.viewCategories('All');">
                <g:message code="filter.viewAll" />
              </a>
            </form>
          </div>
          <ul id="userCategories" class="editableList">
          </ul>
        </div>
      </div>
    </div>  
    
    
    <div id="narrow" class="yui-b">
      <div class="nobox">
        <h3><g:message code="user.header.switchUser" /></h3>
        <div class="body">
          <g:if test="${users.size == 0}">
            <g:message code="user.message.noUserDefined" />
          </g:if>
          <g:if test="${users.size > 0}">
            <form action="<g:createLink action="edit" />">
              <select name="userId" id="userId" onchange="submit();">
                <option value=""></option>
                <g:each in="${users}" var="user">
                  <option value="${user.id}" ${user.id == Long.valueOf(params.id) ? 'selected' : ''}>
                    ${user.lastName} ${user.firstName}
                  </option>>
                </g:each>
              </select>
            </form>
          </g:if>
        </div>
      </div>
    </div>

  </body>
</html>
