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
        <img src="${createLink(controller:'localAuthorityResource', action:'resource',  params:[type:'DISPLAY_GROUP_IMAGE',filename:group.key]).encodeAsXML()}" alt="${message(code:'displayGroup.header.logo')} ${group.value.get('label')}" />
        <ul>
          <g:each var="requestType" in="${group.value.get('requests')}">
            <li>
              <g:if test="${requestType.enabled}">
                <g:if test="${requestType.seasons && !requestType.seasons.isEmpty()}">
                  <g:if test="${requestType.seasons.size() == 1}">
                    <a href="${createLink(controller:'frontofficeRequest', action : 'start',
                      params:['label':requestType.label, 'requestSeasonId' : requestType.seasons.iterator().next().id])}">
                      <g:translateRequestTypeLabel label="${requestType.label}"/>
                    </a>
                    <span class="notice">
                      ${requestType.seasons.iterator().next().label}
                    </span>
                  </g:if>
                  <g:else>
                    <a href="${createLink(controller : 'frontofficeRequestType', action : 'seasons', params:['label':requestType.label])}">
                      <g:translateRequestTypeLabel label="${requestType.label}"/>
                    </a>
                  </g:else>
                </g:if>
                <g:else>
                  <a href="${createLink(controller:'frontofficeRequest', action : 'start',
                    params:['label':requestType.label])}">
                    <g:translateRequestTypeLabel label="${requestType.label}"/>
                  </a>
                </g:else>
                <g:if test="${requestType.countDraft > 0}">
                  &nbsp;
                  <a href="${createLink(controller:'frontofficeRequest', params:[stateFilter:'draft',typeFilter:requestType.id])}" class="tag-draft">${message(code:'requestType.message.draftNumber', args:[requestType.countDraft])}</a>
                </g:if>
              </g:if>
              <g:else>
                <g:translateRequestTypeLabel label="${requestType.label}"/>
                <g:if test="${requestType.countDraft > 0}">
                  &nbsp;
                  <a href="${createLink(controller:'frontofficeRequest', params:[stateFilter:'draft',typeFilter:requestType.id])}" class="tag-draft">${message(code:'requestType.message.draftNumber', args:[requestType.countDraft])}</a>
                </g:if>
                <g:if test="${requestType.message}">
                  <span class="notice">
                    <g:message code="${requestType.message}"/>
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
