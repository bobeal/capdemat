<g:if test="${children && children.size() > 0}">
  <h2><g:message code="homeFolder.property.children"/></h2>
  <div class="yui-g">
    <div class="yui-u">
      <g:each var="record" in="${children}">
        <dl>
          <dt>${record.fullName}</dt>
          <dd>
            <g:message code="homeFolder.header.sex" />
            ${record.sex}
          </dd>
          <dd>
            <g:message code="homeFolder.header.born" />
            <g:if test="${record?.birthDate}">
              <g:message code="homeFolder.header.on" />
              ${format('value':record.birthDate,'formatName':'format.date')}
            </g:if>
            <g:if test="${record?.birthCity || record?.birthPostalCode || record?.birthCountry}">
              <g:message code="homeFolder.header.in" />
              ${record?.birthCity}
              <g:if test="${record?.birthPostalCode}"> (${record.birthPostalCode}) </g:if>
              <g:if test="${record?.birthCountry}"> - ${record.birthCountry}</g:if>
            </g:if>
          </dd>
          <dd>${record.addressDetails}</dd>
          <g:if test="${record?.responsables}">
            <dd>
              <g:each var="res" in="${record.responsables}">
                ${res.fullName}
              </g:each>
            </dd>
          </g:if>
        </dl>
      </g:each>
    </div>
  </div>
</g:if>