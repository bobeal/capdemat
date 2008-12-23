  <h1>
    <span id="documentState" class="${document.state.cssClass} documentState_${document.id}">
      <span><g:message code="${document.state.i18nKey}" /></span>
      <span class="invisible">${document.endValidityDate}</span>
    </span>
    

    <g:message code="document.header.document" /> : ${document.name} 
    (${document.id})
    
    <span id="documentDepositType" class="${document.depositType.cssClass}">
      <g:message code="${document.depositType.i18nKey}" />
    </span>
    
    <span id="documentOrigin" class="${document.depositOrigin.cssClass}">
      <g:message code="${document.depositOrigin.i18nKey}" />
    </span>
    
    <span id="documentEndValidityDate">
      <g:message code="document.property.endValidityDate" />
      <strong>
        <g:formatDate formatName="format.date" date="${document.endValidityDate}"/>
      </strong>
    </span>
    
    <div id="documentTransitionStates"></div>
  </h1>
  
  <!-- datas bloc-->
  <div id="requestDocumentData" class="yellow-yui-tabview">
  
    <ul class="yui-nav">
      <g:each var="page" in="${document.pages}" status="i">
        <li class="${i == 0 ? 'selected' : ''}">
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

  <!-- editable field bloc -->

  <!-- document action bloc -->
  <div id="documentMetaData" class="blue-yui-tabview">
    <ul class="yui-nav">
      <li class="selected"><a href="#page1"><em><g:message code="document.header.actionHistory" /></em></a></li>
      <li><a href="#page1"><em><g:message code="document.header.information" /></em></a></li>
    </ul>
    <div class="yui-content">
        
      <!-- Page 1 -->
      <div id="page1">
        <h2><g:message code="document.header.actionHistory" /></h2>
        <ul>
          <g:each var="action" in="${document.actions}">
            <li>
              <span class="${action.resultingState.cssClass}">
                <g:message code="${action.resultingState.i18nKey}" />
              </span>
              
              <strong>${action.label}</strong>
              - <strong><g:formatDate formatName="format.date" date="${action.date}"/></strong>
              - <strong>${action.agentName}</strong>
            </li>
          </g:each>
        </ul> 
      </div>
      
       <!-- Page 2 -->
      <div id="page2">
        <h2><g:message code="document.header.information" /></h2>
        <div id="documentInformationtMsg" style="display:none"></div>
        <form method="POST" id="modifyDocumentForm" action="<g:createLink action="modifyDocument" />">
          <div id="modifyDocumentFormErrors" class="error"></div> 
          <label for="ecitizenNote">
            <g:message code="document.property.ecitizenNote" /> :
          </label>
          <input type="text" name="ecitizenNote" size="50" title="" value="${document.ecitizenNote}" disabled="disabled" />
              
          <label for="agentNote">
            <g:message code="document.property.agentNote" /> :
          </label>
          <input type="text" name="agentNote" size="50" title="" value="${document.agentNote}"  />

          <input type="hidden" name="documentId" value="${document.id}" />
          
          <input type="button" id="submitModifyDocumentForm" class="form-button" value="<g:message code="action.save" />" />
          
        </form>
      </div>
        
    </div>
  </div>

  
  
            
