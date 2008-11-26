<%@ taglib prefix="g" uri="/BackOfficeNG/web-app/WEB-INF/tld/grails.tld"%>
<html>
  <head>
    <title><g:message code="statistics.header" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'statistics.js')}"></script>
    
    <style>
      .mainbox-stat img {
      display: block;
      margin : 2em auto;
      }
    </style>
  </head>
  
  <body>
    
    <div id="yui-main">
      <div class="yui-b">
        
        <div class="head">
          <h1><g:message code="statistics.header" /></h1>
        </div>
        
        <div class="mainbox mainbox-stat">
          <h2><g:message code="statistics.header.newRequests" /></h2>
          <img src="${detailedCreatedUrl}" />
          <img src="${summarizedCreatedUrl}" />
        </div>
        
        <div class="mainbox mainbox-stat">
          <h2><g:message code="statistics.header.instructedRequests" /></h2>
          <img src="${detailedTreatedUrl}" />
          <img src="${summarizedTreatedUrl}" />
        </div>
        
        <div class="mainbox mainbox-stat">
          <h2><g:message code="statistics.header.instructionDelay" /></h2>
          <img src="${qualityUrl}" />
        </div>
        
      </div>
       
    </div>
    
    <div id="narrow" class="yui-b">
      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#">
            <label for="categoryId"><g:message code="property.category" /> :</label>
            <select name="categoryId" id="categoryId" onchange="doStatisticsRefresh('requestTypeId');">
              <option value=""></option>
              <g:each in="${categories}" var="category">
                <option value="${category.id}">${category.name}</option>
              </g:each>
            </select>
            
            <label for="requestType"><g:message code="property.requestType" /> : </label>
            <select name="requestTypeId" id="requestTypeId" onchange="doStatisticsRefresh('requestTypeId');" 
									id="requestTypeId" style="width:100%;">
              <option value=""></option>
              <g:each in="${requestTypes}" var="requestType">
                <option value="${requestType.key}">${requestType.value}</option>
              </g:each>
            </select>
            
            <label for="timescale">
              <g:message code="statistics.message.timescale" /> :</label>
            <select name="timescale" id="timescale" onchange="doStatisticsRefresh('timescale');">
              <g:each in="${timescales.keySet()}" var="timescale">
                <option value="${timescales.get(timescale)}">${timescale}</option>
              </g:each>
            </select>
          </form>
        </div>
      </div>

    </div>
    
  </body>
</html>


