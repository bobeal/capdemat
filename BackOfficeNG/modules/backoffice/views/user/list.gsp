<%@ taglib prefix="g" uri="/web-app/WEB-INF/tld/grails.tld" %>
<html>
  <head>
    <title><g:message code="user.header.userList" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" >
  </head>
  
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="user.header.userList" /></h1>
        </div>
          
        <g:if test="${users.size == 0}">
          <g:message code="user.message.noUserDefined" />
        </g:if>
        <g:else>
          <ul class="overviewConfigurationList" id="usersList">
            <g:each in="${users}" var="user">
            <li id="user-${user.id}">
              <h3>
                <a href="${createLink(action:'edit',id:user.id)}">${user.lastName} ${user.firstName}</a>
                <span>- ${user.id}</span>
              </h3>
              <div>
                <g:each in="${user.categoriesRoles}" var="categoryRole">
                  ${categoryRole.category.name}
                  - 
                </g:each>
              </div>
            </li>
            </g:each>
          </ul>
        </g:else>
      </div>
    </div>

    <div id="narrow" class="yui-b">   
      <div class="nobox">
        <h3><g:message code="user.header.overview" /></h3>
        <div class="body">
          <p>
            Cette page présente les utilisateurs actuellement définis et les catégories 
            qui leur sont rattachées.
          </p>
          <p>
            En cliquant sur un utilisateur, vous pouvez voir et modifier le détail de sa
            configuration.
          </p>
       </div>
      </div>
      
    </div>

  </body>
</html>


