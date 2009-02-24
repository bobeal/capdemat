<div class="yui-g">
  <div class="yui-u first">
    <g:each var="group" in="${groups}" status="i">      
      <g:if test="${group.value.get('requests').size() > 0}">
        <div class="group-box">
          <h3>${group.value.get('label')}</h3>
          <img style="float:left;padding:1em;" 
               src="${createLinkTo(dir:'images/frontoffice',file:group.key + '.gif')}" />
          <ul>
            <g:each var="request" in="${group.value.get('requests')}">
              <li>
                <g:if test="${request.enabled}">
                  <a href="${createLink(controller:'frontofficeRequestCreation',params:['label':request.label])}">
                    <g:translateRequestTypeLabel label="${request.label}"/>
                  </a>
                </g:if>
                <g:else>
                  <g:translateRequestTypeLabel label="${request.label}"/>
                  <g:if test="${request?.message}">
                    <span class="disabled-request-type" style="color:gray;font-size:0.85em;font-style:italic;display:block;">
                      <g:message code="${request.message}"/>
                    </span>
                  </g:if>
                </g:else>
              </li>
            </g:each>
          </ul>
        </div>
      </g:if>
      <g:if test="${(groups.size() - 2) / 2 < i }">  
        </div>
        <div class="yui-u">
      </g:if>
    </g:each>
  </div> 
</div>
