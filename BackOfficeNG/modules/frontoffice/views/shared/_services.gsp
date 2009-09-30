<div class="yui-g">
  <g:each var="group" in="${groups}" status="i">
    <g:if test="${i == 0}">
      <div class="yui-u first">
    </g:if>
    <g:elseif test="${i == groups.size() / 2 || i == (groups.size() + 1) / 2}">
      </div>
      <div class="yui-u">
    </g:elseif>
    <g:if test="${!group.value.get('requests').isEmpty()}">
      <div class="group-box">
        <h3>${group.value.get('label')}</h3>
        <img src="${createLink(controller:'localAuthorityResource', action:'resource',  params:[type:'DISPLAY_GROUP_IMAGE',filename:group.key])}" />
        <ul>
          <g:each var="request" in="${group.value.get('requests')}">
            <li>
              <g:if test="${request.enabled}">
                <g:if test="${request.seasons && !request.seasons.isEmpty()}">
                  <g:if test="${request.seasons.size() == 1}">
                    <a href="${createLink(controller:'frontofficeRequestCreation',
                      params:['label':request.label, 'requestSeasonId' : request.seasons.iterator().next().id])}">
                      <g:translateRequestTypeLabel label="${request.label}"/>
                    </a>
                    <span class="disabled-request-notice">
                      ${request.seasons.iterator().next().label}
                    </span>
                  </g:if>
                  <g:else>
                    <a href="${createLink(action : 'seasons',
                      params:['label':request.label])}">
                      <g:translateRequestTypeLabel label="${request.label}"/>
                    </a>
                  </g:else>
                </g:if>
                <g:else>
                  <a href="${createLink(controller:'frontofficeRequestCreation',
                    params:['label':request.label])}">
                    <g:translateRequestTypeLabel label="${request.label}"/>
                  </a>
                </g:else>
              </g:if>
              <g:else>
                <g:translateRequestTypeLabel label="${request.label}"/>
                <g:if test="${request.message}">
                  <span class="disabled-request-notice">
                    <g:message code="${request.message}"/>
                  </span>
                </g:if>
              </g:else>
            </li>
          </g:each>
        </ul>
      </div>
    </g:if>
  </g:each>
  </div> 
</div>
