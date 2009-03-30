
<g:if test="${activities?.keySet()}">
  <g:each in="${activities.keySet()}" var="${name}" >
    <div class="list-box">
      <h2><g:message code="activity.header.briefReviewOf"/> ${name}</h2>
        <g:each in="${activities.get(name.toString()).keySet()}" var="${label}">
          <h3><g:translateRequestTypeLabel label="${label}"/></h3> 
          <ul>
            <g:each in="${activities.get(name.toString()).get(label).keySet()}" var="${activity}">
              <li>
                ${activity} : ${activities.get(name.toString()).get(label).get(activity).size()}
              </li>
            </g:each>
          </ul>
          <div class="details-panel">
            <a href="${createLink(action:'details')}?name=${name}&label=${label}&year=${params.yf}&month=${params.mf}">
              <g:message code="action.seeDetails"/>
            </a>
          </div>
        </g:each>
    </div>
  </g:each>
</g:if>
<g:else>
  <div>
    <g:message code="message.noRecords"/>
  </div>
</g:else>