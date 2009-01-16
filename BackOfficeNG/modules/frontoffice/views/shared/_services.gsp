<div class="yui-g">
  <div class="yui-u first">
    <g:each var="group" in="${groups}" status="i">
      <div class="group-box">
        <h3>${group.value.get('label')}</h3>
        <img style="float:left;padding:1em;" 
             src="<g:createLinkTo dir="images/frontoffice" file="${group.key}.gif" />" />
        <ul>
          <g:each var="requestMap" in="${group.value.get('requests')}">
            <li>
              <a href="<g:createLink controller="frontofficeRequestCreation" params="[label:requestMap.key]" />">
                <g:translateRequestTypeLabel label="${requestMap.key}"/>
              </a>
            </li>
          </g:each>
        </ul>
      </div>
      <g:if test="${(groups.size() - 2) / 2 < i }">  
        </div>
        <div class="yui-u">
      </g:if>
    </g:each>
  </div> 
</div>
