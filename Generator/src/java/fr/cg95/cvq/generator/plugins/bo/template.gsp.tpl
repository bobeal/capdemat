<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  <% for(step in requestBo.steps) { %>
    <li${step.index == 0 ? ' class="selected"' :'' }>
      <a href="#page${step.index}"><em><g:message code="request.property.${step.name}" /></em></a>
    </li>
  <% } %>
  </ul>
   
  <div class="yui-content">
    <% for(step in requestBo.steps) { %>
    <!-- step start -->
    <div id="page${step.index}">
      <h2><g:message code="property.form" />
        <span><g:message code="request.property.step.${step.name}" /></span>
      </h2>
      <div class="yui-g">
        <% for (column in [1,2]) { %>
        <!-- column start -->
        <div class="yui-u${column == 1 ? ' first' :'' }">
          <% for (element in requestBo.getElementsByStep(step, column)) { %>
            <% if (element.typeClass == "SIMPLE") { %>
            <dl>
              <dt><g:message code="${element.i18nLabelCode}" /> : </dt>
              <dd id="${element.javaFieldName}" class="${element.htmlClass}">
                <span>\${request.${element.javaFieldName}}</span>
              </dd>
            </dl>
            <% } else if (element.typeClass == "COMPLEX") { %>
            <h3><g:message code="${element.i18nLabelCode}" /></h3>
            <dl>
              <% for (subElement in element.elements) { %>
                <dt><g:message code="${subElement.i18nLabelCode}" /> : </dt>
                <dd id="${subElement.javaFieldName}" class="${subElement.htmlClass}">
                  <span>\${request.${subElement.javaFieldName}}</span>
                </dd>
              <% } %>
            </dl>
            <% } else if (element.typeClass == "COLLECTION") { %>
            <h3><g:message code="${element.i18nLabelCode}" /></h3>
            <g:each var="it" in="\${request.${element.javaFieldName}}" statut="index">
            <dl>
              <% for (subElement in element.elements) { %>
                <dt><g:message code="${subElement.i18nLabelCode}" /> : </dt>
                <dd id="${element.javaFieldName}.[\${index}].${subElement.javaFieldName}" class="${subElement.htmlClass}">
                  <span>\${it.${subElement.javaFieldName}}</span>
                </dd>
              <% } %>
            </dl>
            </g:each>
            <% } %>
          <% } %>
        </div>
        <!-- column end -->
        <% } %>
      </div>
    </div>
    <!-- step end -->
    <% } %>
    
  </div>
  
</div>
