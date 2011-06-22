<ul>
  <g:each var="action" in="${actions}">
    <li>
      <g:render template="${action.template}" model="['action' : action]" />
    </li>
  </g:each>
</ul>
