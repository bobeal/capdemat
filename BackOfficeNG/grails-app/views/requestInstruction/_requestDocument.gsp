  <h1>
    <span id="documentState" class="${document.state.cssClass}">
      <g:message code="${document.state.i18nKey}" />
    </span>
    
    <g:message code="document.header.document" /> : ${document.name} 
    (<g:message code="property.id" />: ${document.id})
    
    <span id="documentDepositType" class="${document.depositType.cssClass}">
      <g:message code="${document.depositType.i18nKey}" />
    </span>
    
    <span id="documentOrigin" class="${document.depositOrigin.cssClass}">
      <g:message code="${document.depositOrigin.i18nKey}" />
    </span>
    
    <span id="documentExpirationDate" class="tag-disable">
      <g:formatDate format="dd/MM/yyyy" date="${document.endValidityDate}"/>
    </span>
  </h1>
  
  <!-- datas bloc-->
  <div id="requestDocumentData" class="yellow-yui-tabview">
  
    <ul class="yui-nav">
      <g:each var="page" in="${document.pages}">
        <li class="selected">
          <a href="#page${page.pageNumber}">
          <em><g:message code="property.page" /> ${page.pageNumber}</em></a>
        </li>
      </g:each>
    </ul>
    
    <div class="yui-content"> 
      <g:each var="page" in="${document.pages}">
        <div id="page${page.pageNumber}">
          <img src="<g:createLink action="documentPage" params="[documentId: document.id, pageNumber: page.pageNumber]" />"/>
        </div>
      </g:each>

    </div>
  </div>

  <!-- editable field bloc-->
  <div class="mainbox mainbox-yellow">
    <h2><g:message code="document.header.information" /></h2>
    
    <form method="POST" id="modifyDocumentForm" action="<g:createLink action="modifyDocument" />">
    
      <label for="endValidityDate" class="required">
        <g:message code="document.property.endValidityDate" /> :
      </label>
      <input type="text" id="endValidityDate" name="endValidityDate" class="required" size="10" 
          title="" value="<g:formatDate format="dd/MM/yyyy" date="${document.endValidityDate}"/>" />
      <a onclick="showCalendar('endValidityDateShow', 0);">
        <img id="endValidityDateShow" src="${createLinkTo(dir:'css/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="endValidityDateCalContainer" class="yui-cal"></div>
      
      <label for="ecitizenNote" class="required">
        <g:message code="document.property.ecitizenNote" /> :
      </label>
      <input type="text" name="ecitizenNote" size="50" title="" value="${document.ecitizenNote}" disabled="disabled" />
          
      <label for="agentNote" class="required">
        <g:message code="document.property.agentNote" /> :
      </label>
      <input type="text" name="agentNote" size="50" title="" value="${document.agentNote}"  />
      
      <input type="hidden" name="documentId" value="${document.id}" />
      
      <input type="button" id="submitModifyDocumentForm" class="form-button" value="submit" />
      
    </form>
  </div>

  <!-- document action bloc -->
  <div class="mainbox mainbox-blue">
    <h2><g:message code="document.header.actionHistory" /></h2>
    <ul>
      <g:each var="action" in="${document.actions}">
        <li>
          <span class="${action.resultingState.cssClass}">
            <g:message code="${action.resultingState.i18nKey}" />
          </span>
          
          <strong>${action.label}</strong>
          - <stron><g:formatDate format="dd/MM/yyyy" date="${document.endValidityDate}"/></stron>
          - <strong>${action.agentName}</strong>
        </li>
      </g:each>
    </ul> 
  </div>
  
  
            
