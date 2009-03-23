<div class="head">
  <h1><g:message code="statistics.header.quality" /></h1>
</div>

<div class="mainbox mainbox-stat">
  <h2><g:message code="statistics.header.quality.byQos" /></h2>
  <img src="${summarizedQualityUrl}" />
</div>

<div class="mainbox mainbox-stat">
  <h2><g:message code="statistics.header.quality.byType" /></h2>
  <table class="detailed-stat">
      <tr>
          <th><g:message code="property.requestType"/></th>
          <th class="green"><g:message code="statistics.quality.green"/></th>
          <th class="orange"><g:message code="statistics.quality.orange"/></th>
          <th class="red"><g:message code="statistics.quality.red"/></th>
      </tr>
      <g:each in="${detailedQualityData}">
          <tr class="detailed-stat-data">
              <td>${it.requestType}</td>
              <td>${it.green ? it.green : 0}</td>
              <td>${it.orange ? it.orange : 0}</td>
              <td>${it.red ? it.red : 0}</td>
          </tr>
      </g:each>
  </table>
  <img src="${detailedQualityUrl}" />
</div>
