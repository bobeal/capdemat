<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <title><g:message code="statistics.header.${currentStatisticType}" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'statistics.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'statistics.js')}"></script>
  </head>

  <body>

    <div id="yui-main">
      <div class="yui-b">
        <g:render template="${currentStatisticType}" />
      </div>
    </div>

    <div id="narrow" class="yui-b">

      <div class="nobox">
        <h3><g:message code="header.display" /></h3>
        <div class="body">
          <ul>
            <g:each in="${statisticTypes}" var="type">
              <li id="statistics-${type}">
                <g:if test="${currentStatisticType != type}">
                  <g:link action="${type}"><g:message code="statistics.header.${type}"/></g:link>
                </g:if>
                <g:else><g:message code="statistics.header.${type}"/></g:else>
              </li>
            </g:each>
          </ul>
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form id="filterForm" action="${createLink(action:currentStatisticType)}">
            <input type="hidden" id="pageState" name="pageState" value="${pageState}" />
            
            <label for="categoryId"><g:message code="property.category" /> :</label>
            <select name="categoryId" class="persistent filter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allCategories}" var="category">
                <option value="${category.id}" ${state.categoryId == category.id.toString() ? 'selected="selected"' : ''}>${category.name}</option>
              </g:each>
            </select>

            <label for="requestTypeId"><g:message code="property.requestType" /> : </label>
            <select name="requestTypeId" style="width:100%;" class="persistent filter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allRequestTypes}" var="requestType">
                <option value="${requestType.id}" ${state.requestTypeId == requestType.id.toString() ? 'selected="selected"' : ''}>${requestType.label}</option>
              </g:each>
            </select>

            <label for="startDate"><g:message code="statistics.filter.period" /> :</label>
            <input type="text" id="startDate" name="startDate" size="10" value="${state.startDate}"
                   class="persistent filter" />
            <a onclick="showCalendar('startDateShow', 0);">
              <img id="startDateShow"
                   src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
            </a>
            <div id="startDateCalContainer" class="yui-cal"></div>
            <input type="text" id="endDate" name="endDate" size="10" value="${state.endDate}"
                   class="persistent filter" />
            <a onclick="showCalendar('endDateShow', 1);">
              <img id="endDateShow"
                   src="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.gif')}"/>
            </a>
            <div id="endDateCalContainer" class="yui-cal"></div>

            <p>
              <input type="button" id="filterDisplay" value="${message(code:'action.filter')}" />
            </p>

          </form>
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="header.export" /></h3>
        <div class="body">
          <form action="${createLink(action : 'export')}">
            <input type="hidden" name="currentStatisticType" value="${currentStatisticType}" />
            <input type="hidden" name="pageState" value="${pageState}" />
            <select name="format">
              <option value="csv">${message(code : 'export.format.csv')}</option>
            </select>
            <input type="submit" value="${message(code : 'action.export')}" />
          </form>
        </div>
      </div>

    </div>

  </body>
</html>
