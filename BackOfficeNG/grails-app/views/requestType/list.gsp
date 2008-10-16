<%@ taglib prefix="g" uri="/BackOfficeNG/web-app/WEB-INF/tld/grails.tld" %>
<html>
  <head>
    <title><g:message code="requestType.header.requestList" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'configuration.css')}" ></link>
  </head>
  
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="requestType.header.requestList" /></h1>
        </div>
        
        <ul class="overviewConfigurationList">
        <g:each in="${requestTypes}" var="requestType">
          <li>
            <g:if test="${requestType.active}">
              <span  class="tag-enable"><g:message code="property.active" /></span>
            </g:if>
            <g:else>
              <span class="tag-disable"><g:message code="property.unactive" /></span>
            </g:else>
            <h3>
              <a href="${createLink(action:'configure',id:requestType.id)}">
              <g:translateRequestTypeLabel label="${requestType.label}" />
              </a>
              <span>
                <g:if test="${requestType.category}">
                  - <g:message code="property.category" /> : ${requestType.category?.name}
                </g:if>
                <g:else>
                  - <g:message code="requestType.message.noCategoryAssociated" /> 
                </g:else>
              </span>
            </h3>
          </li>
         </g:each>
         </ul>
      </div>
    </div>

    <div id="narrow" class="yui-b">
      <div class="nobox">
      <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#">
            <label for="categoryId"><g:message code="property.category" /> :</label>
            <select name="categoryId" id="categoryId">
              <option value=""></option>
              <g:each in="${categories}" var="category">
                <option value="${category.id}">${category.name}</option>
              </g:each>
            </select>
    
            <label for="categoryId"><g:message code="property.state" /> :</label><br/>
            <select name="state" id="state">
              <option value=""></option>
              <option value="active"><g:message code="property.active" /></option>
              <option value="inactive"><g:message code="property.unactive" /></option>
            </select>
          </form>
        </div>
      </div> 
    </div>
    
  </body>
</html>

