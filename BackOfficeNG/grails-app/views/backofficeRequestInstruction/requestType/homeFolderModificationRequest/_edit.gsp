<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
    <li class="selected"><a href="#page1"><em><g:message code="homeFolder.property.adults" /></em></a></li>
    <li><a href="#page1"><em><g:message code="homeFolder.property.children" /></em></a></li>
  </ul>
  <div class="yui-content">
      
    <!-- Page 1 -->
    <div id="page1">
      <h2><g:message code="property.form" /><span> - <g:message code="homeFolder.property.adults" /></span></h2>
    
      <!-- start of individual -->
      <g:each status="index" var="adult" in="${adults}">
        <g:render template="/backofficeRequestInstruction/requestType/adult" model="['adult':adult.data, 'index':adult.index, 'action':'action']" />
      </g:each>
      <!-- end of individual -->
      
    </div>
    
     <!-- Page 2 -->
    <div id="page2">
      <h2><g:message code="property.form" /><span> - <g:message code="homeFolder.property.children" /></span></h2>
    
      <!-- start of individual -->
      <g:each status="index" var="child" in="${children}">
        <g:render template="/backofficeRequestInstruction/requestType/child" 
            model="['child':child.data, 'index':child.index, 'childLegalResponsibles':childrenLegalResponsibles[child.data.id]]" />
      </g:each>
      <!-- end of individual -->
      
    </div>
      
  </div>
</div>

