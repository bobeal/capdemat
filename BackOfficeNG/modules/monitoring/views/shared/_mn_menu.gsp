<div id="menu">
  <a href="${createLink(controller: 'monitoringSystem')}" 
     class="${menu.current(elem: 'system', 'class' : 'selected-menu-entry')}">
    <span>
      <g:message code="menu.system"/>
    </span>
  </a>
  <a href="${createLink(controller: 'monitoringDatabase')}" 
     class="${menu.current(elem: 'database', 'class' : 'selected-menu-entry')}">
    <span>
      <g:message code="menu.database"/>
    </span>
  </a>
  <a href="${createLink(controller: 'monitoringSpecific')}" 
     class="${menu.current(elem: 'specific', 'calss' : 'selected-menu-entry')}">
    <span>
      <g:message code="menu.capdematSpecific"/>
    </span>
  </a>
</div>
