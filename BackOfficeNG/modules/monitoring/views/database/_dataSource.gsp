
<h2><g:message code="monitoring.header.pool" /> :</h2>
<div>
  <form action="#" class="" method="post" id="datasourceForm">
    <p>
      <label><g:message code="monitoring.initialPoolSize" /> :</label>
      <input type="text" disabled value="${datasource.initialPoolSize}"/>
    </p>
    <p>
      <label class="required" for="maxPoolSize">
        <g:message code="monitoring.maxPoolSize" /> * :
      </label>
      <input type="text" value="${datasource.maxPoolSize}" title="" 
              class="required" id="maxPoolSize" name="maxPoolSize"/>
    </p>
    <p>
      <label class="required" for="minPoolSize">
        <g:message code="monitoring.minPoolSize" /> * :
      </label>
      <input type="text" value="${datasource.minPoolSize}" 
              class="required" id="minPoolSize" name="minPoolSize"/>
        
      <input type="hidden" value="" name="currentTemplateName"/>
    </p>
    <p class="same-line">
      <input type="button" value="${message(code: 'action.save')}" name="save" id="save"/> 
    </p>
  </form>
</div>

<h2><g:message code="monitoring.header.connections" /> :</h2>