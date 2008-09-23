  <h1>
    <span id="documentState" class="${document.state.cssClass}">
      <g:message code="${document.state.i18nKey}" />
    </span>
    Document: ${document.name} (ref: ${document.id})
    
    <span id="documentDepositType" class="${document.depositType.cssClass}">
      <g:message code="${document.depositType.i18nKey}" />
    </span>
    
    <span id="documentOrigin" class="${document.depositOrigin.cssClass}">
      <g:message code="${document.depositOrigin.i18nKey}" />
    </span>
    
    <span id="documentExpirationDate" class="tag-disable">
      validity end: <g:formatDate format="dd/MM/yyyy" date="${document.endValidityDate}"/>
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
          <img src="<g:createLink action="documentPage" params="[ documentId: document.id, pageNumber: page.pageNumber]" />"/>
        </div>
      </g:each>

    </div>
  </div>

  <!-- editable field bloc-->
  <div class="mainbox mainbox-yellow">
    <h2>Information</h2>
    
    <form method="POST" id="" action="<g:createLink action="" />">
      
      <label for="endValidityDate" class="required">Validity end :</label>
      <input type="text" name="endValidityDate" class="required" size="40" 
          title="" value="<g:formatDate format="dd/MM/yyyy" date="${document.endValidityDate}"/>" />
      
      <label for="ecitizenNote" class="required">eCitizen Note :</label>
      <input type="text" name="ecitizenNote" size="60" title="" value="${document.ecitizenNote}" />
          
      <label for="agentNote" class="required">Agent Note :</label>
      <input type="text" name="agentNote" size="60" title="" value="${document.agentNote}" />

    </form>
  </div>

  <!-- document action bloc -->
  <div class="mainbox mainbox-blue">
    <h2>Historique</h2>
    <ul>
      <g:each var="action" in="${document.actions}">
        <li>
          <span class="${action.resultingState.cssClass}">
            <g:message code="${action.resultingState.i18nKey}" />
          </span>
          
          <strong>${action.label}</strong>
          - <stron><g:formatDate format="dd/MM/yyyy" date="${document.endValidityDate}"/></stron>
          - par <strong>${action.agentName}</strong>
        </li>
      </g:each>
    </ul> 
  </div>
            
