<% 
  def className = individual.class.simpleName.toLowerCase()
%>
<g:if test="${individual.id != flash.idToDelete}">
  <dd class="action">
    <a href="${createLink(action:className, params:['id':individual.id])}">${message(code:'homeFolder.individual.action.seeDetails')}</a>
    <g:if test="${!individual.homeFolderResponsible()}">
      / <a href="${createLink(action:'index', params:['idToDelete':individual.id])}">${message(code:'action.remove')}</a>
    </g:if>
  </dd>
</g:if>
<g:else>
  <dd class="delete">
    ${message(code:'homeFolder.individual.message.confirmRemove')}
    <a href="${createLink(action:'deleteIndividual', params:['id':individual.id])}" class="yes">${message(code:'action.yes')}</a>
    /
    <a href="${createLink(action:index)}">${message(code:'action.no')}</a>
  </dd>
</g:else>
